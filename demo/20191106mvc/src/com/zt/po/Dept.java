package com.zt.po;

/*
 * javaBean  命名规范：
 *     1：所有属性私有  属性名 符合标识符的规范 并小驼峰命名
 *     2：为所有属性提供get/set方法
 *     3：提供默认构造器
 * */
public class Dept {
	private int deptNo;
	private String dname;
	private String loc;

	public int getDeptNo() {
		return deptNo;
	}

	public void setDeptNo(int deptNo) {
		this.deptNo = deptNo;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

}
