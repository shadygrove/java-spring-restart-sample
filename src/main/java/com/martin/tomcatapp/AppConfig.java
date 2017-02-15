package com.martin.tomcatapp;

import org.apache.catalina.startup.Tomcat;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;

@Configuration
public class AppConfig implements EmbeddedServletContainerCustomizer {
    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
    }

    @Bean
    public EmbeddedServletContainerFactory servletContainerFactory() {

        return new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected TomcatEmbeddedServletContainer getTomcatEmbeddedServletContainer(
                    Tomcat tomcat) {
                tomcat.addUser("admin", "secret");
                tomcat.addRole("admin", "manager-gui");

                try {
                    tomcat.addWebapp("/manager", "/path/to/manager/app");
                }
                catch (ServletException ex) {
                    throw new IllegalStateException("Failed to add manager app", ex);
                }
                return super.getTomcatEmbeddedServletContainer(tomcat);
            }
        };
    }


}