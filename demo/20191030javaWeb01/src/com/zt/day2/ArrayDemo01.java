package com.zt.day2;

import java.util.Arrays;
import java.util.List;

public class ArrayDemo01 {
      public static void main(String[] args) {
		String address[]={"�����ϲ��������",
				           "�����ϲ����´��",
				           "�����ϲ���ɽ�����"};
		//������Ԫ�ظ���
		System.out.println(address.length);
		//ȡĳ��λ�õ�Ԫ��
		System.out.println(address[0]);
		
		for(int i=0;i<address.length;i++){
			System.out.println(address[i]);
		}
		for(String s:address){
			System.out.println(s);
		}
		//���鹤����  Arrays �ṩ�˲�������ķ���
		System.out.println("-----Arrays.sort������Ԫ������----------------");
		Arrays.sort(address);
		for(String s:address){
			System.out.println(s);
		}
		System.out.println("------Arrays.asList������ת����---------------");
		List<String> list=Arrays.asList(address);
		for(String s:list){
			System.out.println(s);
		}
		System.out.println("------Arrays.copyOf������---------------");
		String address2[]=Arrays.copyOf(address, 1);
		for(String s:address2){
			System.out.println(s);
		}
		System.out.println("------Arrays.toString���������ַ�����ʽ��ʾ---------------");
		System.out.println(Arrays.toString(address));
		
	}
}
