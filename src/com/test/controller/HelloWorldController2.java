package com.test.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 一种实现方式
 * @author hp
 *
 */
public class HelloWorldController2 implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		//1、收集参数、验证参数  
	       //2、绑定参数到命令对象  
	       //3、将命令对象传入业务对象进行业务处理  
	       //4、选择下一个页面  
		ModelAndView mv = new ModelAndView();
		mv.addObject("message", "Hello world");
		mv.setViewName("hello");
		return mv;
	}
}
