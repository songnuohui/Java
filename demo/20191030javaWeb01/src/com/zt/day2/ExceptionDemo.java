package com.zt.day2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.script.SimpleScriptContext;

public class ExceptionDemo {
     public static void main(String[] args) {
		int a=10/0;
		
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd") ;
		try {
			Date birth=df.parse("1990-10-10");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
