package com.lh.spring.web.servlet.handler;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by lh on 2016/11/10.
 */
public class MyContentLoadListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("contextinitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("contextdestroyed");
    }
}
