package com.test.service;

import org.springframework.stereotype.Service;

/**
 * @Serviceע�ͱ�ʾ����һ��bean��
 * �Զ�����bean������ʵ����һ����д��ĸΪСд��bean��
 * ����XXXʵ����ΪxXX��Ameʵ����Ϊame��
 * �����Ҫ�Լ���������:@Service("���Լ��ĵ�bean��")�� 
 * ������ҵ��㡣 
 * @author hp
 *
 */
@Service(value="df")
public class HelloServiceImpl implements HelloService {
	
	public void printMessage(String message){
		System.out.println(message);
	}

}
