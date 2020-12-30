package com.zt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1:创建一个类 继承  HttpServlet
 * */
public class FirstServlet extends HttpServlet{
      /*2 重写 service()方法*/
	 @Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
	     System.out.println("FirstServlet service....");
		super.service(arg0, arg1);
	}
	 //3:web.xml 进行配置
}
