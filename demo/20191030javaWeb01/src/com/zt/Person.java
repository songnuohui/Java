package com.zt;

public class Person {
	private String idCard;
	private String name;

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private static int num;

	public Person() {
	}

	public Person(String idCard, String name) {
		this.idCard = idCard;
		this.name = name;
	}

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.idCard = "3522323231111111";
		p1.name = "张三";
		p1.num = 100;

		Person p2 = new Person();
		System.out.println(p2.idCard);// null 与p1无关 独立
		System.out.println(p2.name);// null 与p1无关 独立
		System.out.println(p2.num);// 100 static属性共享

	}
}
