package com.zt.day2;
import java.util.*;
public class MapDemo {
     public static void main(String[] args) {
    	 Map<String,Integer> map=new HashMap<String,Integer>();
    	 map.put("语文", 80);map.put("数学", 90);
    	 map.put("英语", 88);map.put("计算机", 92); 
    	 int score=map.get("语文");
    	 System.out.println(score);
    	 
     /*	Set<String> kemuSet= map.keySet();
    	Iterator<String> its=kemuSet.iterator();
    	while(its.hasNext()){
    		String key=its.next();
    		int value=map.get(key);
    		System.out.println(key+" ："+value);
    	}  
    	*/
    	 Set entrt= map.entrySet();
    	 Iterator<Map.Entry> its=entrt.iterator();
    	 while(its.hasNext()){
    		 Map.Entry<String, Integer> a= its.next();
    		 System.out.println(a.getKey()+" : "+a.getValue());
    	 }
    	 
	}
}
