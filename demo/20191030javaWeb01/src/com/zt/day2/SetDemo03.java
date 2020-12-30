package com.zt.day2;
import java.util.*;
public class SetDemo03 {
   public static void main(String[] args) {
	   Set<String> set=new HashSet<String>();
	   set.add("sina"); set.add("sohu");
	   set.add("IBM");set.add("oracle");
	   Iterator<String> its=set.iterator();
	   while(its.hasNext()){
		   System.out.println(its.next());
	   }
	   
	   
}
}
