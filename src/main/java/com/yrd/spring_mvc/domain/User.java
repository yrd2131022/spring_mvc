package com.yrd.spring_mvc.domain;

public class User {

	private String username;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String addr;
	private int age;



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}



	@Override
	public String toString() {
		return "User {\"username\"=\"" + username + "\", \"addr\"=\"" + addr + "\", \"age\"=\"" + age + "\"}";
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
