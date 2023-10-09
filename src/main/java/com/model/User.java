package com.model;

public class User {
	
	private Integer id;
	private String userName;
	private String passWord;
	private String role;
	
	public User() {
	}
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	
	public User(String userName, String passWord) {
		this.userName = userName;
		this.passWord = passWord;
	}

	public User(String userName, String passWord, String role) {
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}

	public User(Integer id, String userName, String passWord, String role) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}

	
	

}
