package com.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="T_Hello")
public class HelloBean {
	
	@Id
	@Column(name="Hello_Id")    
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="username", length=80, nullable = true)
	private String name;
	
	private int age;
	
	@Transient
	private boolean isVip;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="start_time")   
	private Date date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isVip() {
		if(this.getAge() > 25){
			return true;
		}
		return false;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
