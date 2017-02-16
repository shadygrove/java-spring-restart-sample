package com.martin.tomcatapp;

import org.apache.catalina.LifecycleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainer;
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

    @Autowired
    AppRestarter appRestarter;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    String home() {

        String result = "Home Controller";
        return result;
    }

    @RequestMapping(value = "/restart", method = RequestMethod.GET)
    String restart() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                appRestarter.restart();
            }
        });
        thread.setDaemon(false);
        thread.start();
        return "Restarting";
    }
}
