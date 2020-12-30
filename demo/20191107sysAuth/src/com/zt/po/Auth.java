package com.zt.po;
/*
 * Auth 系统功能权限类   对应  t_Auth
 * */
public class Auth {
	private int id;         //主键				
	private String url;     //访问路径
	private String name;    //名称
	private Auth parent;   //父级Id
	private String status="1";  //状态
	
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
