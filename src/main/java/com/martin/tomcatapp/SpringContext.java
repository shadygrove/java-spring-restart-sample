package com.martin.tomcatapp;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by martindev on 2/15/17.
 */
public class SpringContext {
    static ConfigurableApplicationContext applicationContext;

    public static void run() {
        applicationContext = SpringApplication.run(App.class, new String[] { } );
    }

    public static void close() {
        applicationContext.close();
    }
}
