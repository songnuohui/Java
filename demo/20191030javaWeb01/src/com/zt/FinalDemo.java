package com.zt;

public class FinalDemo {
    public  int num=100;
    public final int numfin=100;
    public Person person1=new Person("3333333333","����");
    public final Person person2=new Person("444444444","����");
    public static void main(String[] args) {   	
    	FinalDemo fd=new FinalDemo();
    	fd.num=200;
    //	fd.numfin=200; //error  final���ε�ֵ�ǲ��ɱ��
    	fd.person1=new Person("6666666666","����");  	
    	//fd.person2=new Person("88888888","����");
    	fd.person2.setIdCard("8888888");
    	fd.person2.setName("����");
	}
}
