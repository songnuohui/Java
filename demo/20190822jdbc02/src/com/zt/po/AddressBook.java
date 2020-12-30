package com.zt.po;
import java.util.Date;
/*
 * 通讯录的实体类 AddressBook 
 * po 对应t_ addressBook表  
 * */
public class AddressBook {
	 private int  id ;
	 private String name;
	 private String sex ;
	 private String tel ;
	 private Date   birthDay;
	 private String company;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}	
	public AddressBook(String name, String sex, String tel,
			String company, Date birthDay) {
		this.name = name;
		this.sex = sex;
		this.tel = tel;
		this.birthDay = birthDay;
		this.company = company;
	}
	public String toString() {
		return "AddressBook [id=" + id + ", name=" + name + ", sex=" + sex
				+ ", tel=" + tel + ", birthDay=" + birthDay + ", company="
				+ company + "]";
	}
	 
	 
}
