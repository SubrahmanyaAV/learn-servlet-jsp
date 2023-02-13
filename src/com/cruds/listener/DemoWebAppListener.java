package com.cruds.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class DemoWebAppListener
 *
 */
public class DemoWebAppListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DemoWebAppListener() {
       System.out.println("Context listener constructor**");
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("Servlet context destroyed");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
        System.out.println("servlet context init==>");
    }
	
}
