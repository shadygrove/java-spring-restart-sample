package com.martin.tomcatapp;

import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

/**
 * Created by martindev on 2/14/17.
 */
public class CustomLifecycleListener implements LifecycleListener {
    @Override
    public void lifecycleEvent(LifecycleEvent event) {
        String eventType = event.getType();

        if (eventType == "after_stop") {
            // start it back up

        }
    }
}
