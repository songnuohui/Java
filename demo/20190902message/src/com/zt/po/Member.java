package com.zt.po;
/*
 * po ��javaBean��
 * 1:���е����� private ���Ա�������С�շ�ʽ�����淶
 * 2:�����������ṩ get/set����
 * 3������Ĭ�ϵĹ�����
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
