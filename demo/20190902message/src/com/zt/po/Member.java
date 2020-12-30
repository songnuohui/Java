package com.zt.po;
/*
 * po （javaBean）
 * 1:所有的属性 private 属性必须满足小驼峰式命名规范
 * 2:给所有属性提供 get/set方法
 * 3：保留默认的构造器
 * */
public class Member {
     private int id;
    // private String memberName;   //${membername} -->getmemberName()
     private String name;
     private String pass;
     
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
     
     
     
     
}
