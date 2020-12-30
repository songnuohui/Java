package com.zt;

public class Test {
    char c='a';
	public static void main(String[] args) {
		// 32767        - 32768
	/*	System.out.println(Short.MAX_VALUE);
		System.out.println(Short.MIN_VALUE);*/
//		   short s= 32767;
//             s++;
//            System.out.println(s);
		
		  short s= (short)32768;
		   System.out.println(s);
		   
		   System.out.println(Integer.MAX_VALUE);
		   int n=2147483647;
		 //  int n2=2147483648;		   
		   long n3=2147483648L;		   	   
		   System.out.println(Float.MAX_VALUE);
		   System.out.println(Float.MIN_VALUE);
		   
		   System.out.println(Double.MAX_VALUE);
		   System.out.println(Double.MIN_VALUE);		   
		   Test t=new Test();
		   System.out.println((int)t.c);
		   
		   String s1="abc";
		   System.out.println(s1.charAt(-1));

	}

}
