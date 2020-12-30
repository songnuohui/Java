package com.zt.day2;
import java.util.ArrayList;
import java.util.List;
public class ListDemo {
    public static void main(String[] args) {
    	List<Integer> list=new ArrayList<Integer>();
    	System.out.println(list.size());
    	list.add(1);
    	list.add(1);
    	list.add(1);
    	list.add(1);
    	list.add(1);
    	list.add(1);
    	list.add(1);
    	list.add(1);
    	list.add(1);
    	System.out.println(list.size());
    	
    	/*System.out.println(list.get(0));
    	System.out.println(list.get(list.size()-1));
    	System.out.println(list.get(list.size()+1));*/
    	
    	for(int i=0;i<list.size();i++){
    		System.out.println(list.get(i));
    	}
    	for(Integer o:list){
    		System.out.println(o);
    	}
    	System.out.println("--------------------");
    	List<Integer> ages=new ArrayList();
        ages.add(1);ages.add(2);ages.add(3);
        ages.remove(1);
    	for(Integer a:ages){
    		System.out.println(a);
    	}
    	System.out.println("--------------------");
    	List<String> names=new ArrayList();
    	names.add("张三");names.add("李四");
    	names.add("张三");names.remove("张三");
    	for(String a:names){
    		System.out.println(a);
    	}
        
	}
}
