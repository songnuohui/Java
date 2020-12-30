package com.zt;

public class Student {
   private int id;
   private String name;
   private String sex;
   private String tel;
   public Student(){}
   public Student(String tel){
	  // this(1,"aaa","ÄÐ");
	   this.tel = tel;
   }
   public Student(int id, String name, String sex) {
	   this("13333333");
	   this.id = id;
	   this.name = name;
	   this.sex = sex;
		
	}
public static void main(String[] args) {
	   //Student s=new Student();
	   Student s2=new Student(1,"aaa","ÄÐ");
   }
}
