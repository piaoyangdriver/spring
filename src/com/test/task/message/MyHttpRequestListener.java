package com.test.task.message;

import java.util.Enumeration;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

public class MyHttpRequestListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		Enumeration em = request.getAttributeNames();
		while(em.hasMoreElements()){
			String strinName = (String) em.nextElement();
			System.out.println(strinName);
		}
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		//启动的时候哪里来的参数呢
		HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
		Enumeration em = request.getAttributeNames();
		while(em.hasMoreElements()){
			String strinName = (String) em.nextElement();
			System.out.println("test" + strinName);
		}
	}

}
