package com.test.dao;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.domain.HelloBean;

@Repository(value="helloDaoImpl")
public class HelloDaoImpl implements HelloDao {
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	public HelloBean getHello(int id){
		HelloBean bean = hibernateTemplate.get(HelloBean.class, 1);
		
		return bean;
	}

	@Override
	public void save(HelloBean bean) {
		hibernateTemplate.save(bean);
	}
	
}
