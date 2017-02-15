package com.martin.tomcatapp;

import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by martindev on 2/14/17.
 */
public class CustomLifecycleListener implements LifecycleListener {

    @Autowired
    ApplicationContext applicationContext;

    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        String eventType = event.getType();

        // None of the attempts here were successful

        if (eventType == "after_stop") {
            // start it back up
            //ConfigurableApplicationContext ctx = SpringApplication.run(App.class, new String[]{});

            //String appName = applicationContext.getApplicationName();
//            try {
////                event.getLifecycle().start();
////                SpringApplication.run(App.class);
//            } catch (LifecycleException e) {
//                e.printStackTrace();
//            }
        }

        if (eventType == "after_destroy") {
            // restart the Spring App
            //SpringApplication.run(App.class);
//            try {
//                event.getLifecycle().start();
//                SpringContext.run();
//            } catch (LifecycleException e) {
//                e.printStackTrace();
//            }
        }
    }
}
