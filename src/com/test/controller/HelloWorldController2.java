package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * һ��ʵ�ַ�ʽ
 * @author hp
 *
 */
public class HelloWorldController2 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		//1���ռ���������֤����  
	       //2���󶨲������������  
	       //3�������������ҵ��������ҵ����  
	       //4��ѡ����һ��ҳ��  
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Hello world");
		mv.setViewName("hello");
		return mv;
	}
}
