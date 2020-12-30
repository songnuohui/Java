package com.zt.day2;

import java.util.HashSet;
import java.util.Set;

public class SetDemo02 {
   public static void main(String[] args) {
	   Set set=new HashSet();
	   String s1=new String("abc");
	   String s2=new String("abc");
	   set.add(s1); set.add(s2);
	   StringBuffer s3=new StringBuffer("abc");
	   StringBuffer s4=new StringBuffer("abc");
	   set.add(s3); set.add(s4);
	   System.out.println(set.size());
	   
}
}
