package com.test.task.message;

import java.util.Date;
import java.util.TimerTask;

import javax.servlet.ServletContext;

public class SendMessageTask extends TimerTask {
	
	private ServletContext servletContext;
	
	public SendMessageTask() {
	}

	

	public SendMessageTask(ServletContext servletContext) {
		super();
		this.servletContext = servletContext;
	}


	// WebApplicationContext webApplicationContext = (WebApplicationContext)
	// servletContext.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	@Override
	public void run() {
		
		//��ȡ����һ����Ŀ��servletContext.getRequestDispatcher("").
		System.out.println("now time is:" + new Date());
	}

}
