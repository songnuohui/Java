package com.zt;

public class OverLoadDemo {
    public void print(){
    	System.out.println("public void print()");
    }
    public void print(String info){
    	System.out.println("public void print(info)");
    }
    public void print(int aaa,String bbb){
    	System.out.println("public void print(aa)");
    }  
    public void print(double aaa,String bbb){
    	System.out.println("public void print(aa)");
    }//  print(1L,"aa");
    public int print(String aaa,int bbb){
    	System.out.println("public void print(aa)");
    	return 0;
    }
    
}
