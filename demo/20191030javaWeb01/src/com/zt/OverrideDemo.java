package com.zt;

import java.io.IOException;

class Parent{
	void print(){System.out.println("Parent print");}
	public Object getObject() throws Exception{
		System.out.println("Parent getObject");
		return null;
	}
}
class Son extends Parent{
	public void print(){System.out.println("Son print");}
	public Parent getObject() throws IOException{
		System.out.println("Son getObject");
		return null;
	}
}
public class OverrideDemo {
     public static void main(String[] args) {
    	 Son s=new Son();
    	 s.print();
    	 try {
			s.getObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
