package com.test.controller;

import org.apache.commons.lang.StringUtils;

import com.google.gson.JsonElement;

/**
 * controllerµÄ»ùÀà
 * @author hp
 *
 */
public class BasicController {
	
	private String responseJson(boolean flag, String message, JsonElement ja){
		StringBuffer s = new StringBuffer();
		s.append("{");
		
		s.append("\"success\":" + flag);
		if(StringUtils.isNotEmpty(message)){
			s.append(",\"message\":" + message);
		}
		if(ja != null){
			s.append(",\"data\":"+ ja);
		}
		s.append("}");
		return s.toString();
	}
	
	protected String responseJson(boolean flag, String message){
		return responseJson(flag, message, null);
	}
	
	protected String responseJson(boolean flag, JsonElement data){
		return responseJson(flag, null, data);
	}

}
