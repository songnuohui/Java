package com.zt;

public class TestDateChange {
    public static void main(String[] args) {
    	java.util.Date dt=new java.util.Date();
    	System.out.println(dt);
    	
       java.sql.Date sdt=new java.sql.Date(dt.getTime());
       System.out.println(sdt);
    	
    	/*java.sql.Date  sdt2=new java.sql.Date(11111111);
    	java.util.Date dt2=sdt2;*/
		
	}
}
