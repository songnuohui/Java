package com.zt.day2;
import java.util.*;
public class MapDemo {
     public static void main(String[] args) {
    	 Map<String,Integer> map=new HashMap<String,Integer>();
    	 map.put("����", 80);map.put("��ѧ", 90);
    	 map.put("Ӣ��", 88);map.put("�����", 92); 
    	 int score=map.get("����");
    	 System.out.println(score);
    	 
     /*	Set<String> kemuSet= map.keySet();
    	Iterator<String> its=kemuSet.iterator();
    	while(its.hasNext()){
    		String key=its.next();
    		int value=map.get(key);
    		System.out.println(key+" ��"+value);
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
