package com.test.service;

import java.util.List;

public class TableServiceImpl implements TableService {
	
	private List<Integer> listInt;

	public TableServiceImpl(String arg, ConstructorArg constructor) {
		System.out.println("arg value:" + arg + " constructor:"
				+ constructor.getName());
	}

	@Override
	public String getMessage(String message) {
		// TODO Auto-generated method stub
		return "message:" + message;
	}

	public List<Integer> getListInt() {
		return listInt;
	}

	public void setListInt(List<Integer> listInt) {
		this.listInt = listInt;
	}

}
