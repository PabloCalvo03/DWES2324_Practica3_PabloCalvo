package com.model;

public class Usuario {
	
	private Integer id;
	private String userName;
	private String passWord;
	
	public Usuario(Integer id, String userName, String passWord) {
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", userName=" + userName + ", passWord=" + passWord + "]";
	}
	
	

}
