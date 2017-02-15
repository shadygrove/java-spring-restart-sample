package com.martin.tomcatapp;/*
 * This Java source file was generated by the Gradle 'init' task.
 */


import java.io.IOException;
import java.net.URISyntaxException;

import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan("com.martin.tomcatapp")
public class App {
    public String getGreeting() {
        return "Greetings from the app.";
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new App().getGreeting());

        SpringContext.run();
    }

}
