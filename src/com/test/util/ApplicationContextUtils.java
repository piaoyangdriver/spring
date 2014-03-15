package com.test.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {
	
	private static ApplicationContext context;
	
	public static ApplicationContext getContextByXml(){
		context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		return context;
	}
	
	public Object getBean(String id){
		return context.getBean(id);
		
	}
	
}
