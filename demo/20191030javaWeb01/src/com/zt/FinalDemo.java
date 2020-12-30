package com.zt;

public class FinalDemo {
    public  int num=100;
    public final int numfin=100;
    public Person person1=new Person("3333333333","张三");
    public final Person person2=new Person("444444444","李四");
    public static void main(String[] args) {   	
    	FinalDemo fd=new FinalDemo();
    	fd.num=200;
    //	fd.numfin=200; //error  final修饰的值是不可变的
    	fd.person1=new Person("6666666666","赵六");  	
    	//fd.person2=new Person("88888888","王八");
    	fd.person2.setIdCard("8888888");
    	fd.person2.setName("王八");
	}
}
