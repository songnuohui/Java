package com.zt.day2;

import java.util.Arrays;
import java.util.List;

public class ArrayDemo01 {
      public static void main(String[] args) {
		String address[]={"江西南昌紫阳大道",
				           "江西南昌高新大道",
				           "江西南昌青山湖大道"};
		//求数组元素个数
		System.out.println(address.length);
		//取某个位置的元素
		System.out.println(address[0]);
		
		for(int i=0;i<address.length;i++){
			System.out.println(address[i]);
		}
		for(String s:address){
			System.out.println(s);
		}
		//数组工具类  Arrays 提供了操作数组的方法
		System.out.println("-----Arrays.sort把数组元素排序----------------");
		Arrays.sort(address);
		for(String s:address){
			System.out.println(s);
		}
		System.out.println("------Arrays.asList把数组转集合---------------");
		List<String> list=Arrays.asList(address);
		for(String s:list){
			System.out.println(s);
		}
		System.out.println("------Arrays.copyOf把数组---------------");
		String address2[]=Arrays.copyOf(address, 1);
		for(String s:address2){
			System.out.println(s);
		}
		System.out.println("------Arrays.toString把数组以字符串形式显示---------------");
		System.out.println(Arrays.toString(address));
		
	}
}
