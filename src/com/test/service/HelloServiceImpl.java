package com.test.service;

import org.springframework.stereotype.Service;

/**
 * @Service注释表示定义一个bean，
 * 自动根据bean的类名实例化一个首写字母为小写的bean，
 * 例如XXX实例化为xXX，Ame实例化为ame，
 * 如果需要自己改名字则:@Service("你自己改的bean名")。 
 * 作用在业务层。 
 * @author hp
 *
 */
@Service(value="df")
public class HelloServiceImpl implements HelloService {
	
	public void printMessage(String message){
		System.out.println(message);
	}

}
