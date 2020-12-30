package com.zt.po;
public class Member {
	private int id; // Ö÷¼ü id
	private String name; // ÕË»§Ãû
	private String pass; // ÃÜÂë

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

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", pass=" + pass + "]";
	}
	

}
