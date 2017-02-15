package com.martin.tomcatapp;

import org.apache.catalina.LifecycleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by martindev on 2/14/17.
 */
@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    EmbeddedServletContainerFactory embeddedServletContainerFactory;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home() {

        String result = "Home Controller";
        return result;
    }

    @RequestMapping(value = "/stop", method = RequestMethod.GET)
    void stop() throws LifecycleException {

        TomcatEmbeddedServletContainer container = (TomcatEmbeddedServletContainer)embeddedServletContainerFactory.getEmbeddedServletContainer();

        // container.stop()   // did not work
        // container.getTomcat().stop();  // triggered stop events but application still accessible
        // container.getTomcat().destroy();  // throws invalid transition exception
        // container.getTomcat().getServer().stop();

        container.getTomcat().stop();

        //container.getTomcat().getServer().start();

    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    void exit() {

        SpringContext.close();

    }
}
