package com.zt.day2;
import java.util.*;
class Person{
	private String idCard;
	private String name;
	public Person(String idCard, String name) {
		this.idCard = idCard;
		this.name = name;
	}
	public int hashCode() {
         System.out.println("Person hashCode");
		return idCard.hashCode()+name.hashCode();
	}
	public boolean equals(Object obj) {
		System.out.println("Person equals");
		if(obj instanceof Person){
			Person p=(Person)obj;
			return  this.name.equals(p.name)
					&&this.idCard.equals(p.idCard);
		}else{return false;}		
	}
	
	
}
public class SetDemo {
    public static void main(String[] args) {
    	Set set=new HashSet();
    	/*set.add(1);set.add(1);set.add(1);set.add(1);
    	System.out.println(set.size());*/
    	Person p1=new Person("222212222111","张三");
    	Person p2=new Person("222212222111","张三");
    	Person p3=new Person("222212222111","张三");
    	set.add(p1);set.add(p2);set.add(p3);
    	System.out.println(set.size());
    	
	}
}
