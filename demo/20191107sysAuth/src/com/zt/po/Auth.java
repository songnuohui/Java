package com.zt.po;
/*
 * Auth ϵͳ����Ȩ����   ��Ӧ  t_Auth
 * */
public class Auth {
	private int id;         //����				
	private String url;     //����·��
	private String name;    //����
	private Auth parent;   //����Id
	private String status="1";  //״̬
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Auth getParent() {
		return parent;
	}
	public void setParent(Auth parent) {
		this.parent = parent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
