package com.test.task.message;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class SendMessageListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		Timer timer = new Timer();
		timer.schedule(new SendMessageTask(), 10000, 3000);
		servletContextEvent.getServletContext().setAttribute("timer", timer);
		
		System.out.println("timer start");
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		Timer timer = (Timer)servletContextEvent.getServletContext().getAttribute("timer");	
		
		timer.cancel();
		System.out.println("timer cancel");
	}

}
