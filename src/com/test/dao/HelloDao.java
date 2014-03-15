package com.test.dao;

import com.test.domain.HelloBean;

public interface HelloDao {
	
	public HelloBean getHello(int id);
	
	public void save(HelloBean bean);

}
