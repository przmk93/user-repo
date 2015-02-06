package org.prz.java.model;

public class User {
	private int id;
	private String name;
	private String surname;

	public void setUserId(int id) {
		this.id=id;
	}

	public void setUserName(String name) {
		this.name=name;
	}

	public void setUserSurname(String surname) {
		this.surname=surname;
	}

	public int getUserId() {
		return id;
	}

	public String getUserName() {
		return name;
	}

	public String getUserSurname() {
		return surname;
	}
}
