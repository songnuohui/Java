package com.zt;

public class StringDemo {
     public static void main(String[] args) {
		String s="javaScript";
		//int index=s.indexOf("a",s.indexOf("a")+1);
		//System.out.println(index);
//		System.out.println(s.substring(1));
//		System.out.println(s.substring(1,3));
//		String citys=",ÄÏ²ı,¾Å½­,¸ÓÖİ,ÒË´º";
//		String arrs[]=citys.split(",");
//		System.out.println(arrs.length);
		
		for(int i=0;i<s.length();i++){
			System.out.println(s.charAt(i));
		}
		
		char as[]=s.toCharArray();
		for(char c:as){
			System.out.println(c);
		}
		
	}
}
