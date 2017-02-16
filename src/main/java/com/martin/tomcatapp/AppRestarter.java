package com.martin.tomcatapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.util.ClassUtils;

/**
 * Created by martindev on 2/16/17.
 */
public class AppRestarter implements ApplicationListener<ApplicationReadyEvent> {

    private ConfigurableApplicationContext context;

    private SpringApplication application;

    private String[] args;

    private ApplicationReadyEvent event;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent input) {
        this.event = input;
        if (this.context == null) {
            this.context = this.event.getApplicationContext();
            this.args = this.event.getArgs();
            this.application = this.event.getSpringApplication();
        }
    }

    @ManagedOperation
    public synchronized ConfigurableApplicationContext restart() {
        if (this.context != null) {

            this.application.setEnvironment(this.context.getEnvironment());
            this.context.close();

            // If running in a webapp then the context classloader is probably going to
            // die so we need to revert to a safe place before starting again
            ClassUtils.overrideThreadContextClassLoader(
                    this.application.getClass().getClassLoader());

            this.context = this.application.run(this.args);
        }
        return this.context;
    }

}
