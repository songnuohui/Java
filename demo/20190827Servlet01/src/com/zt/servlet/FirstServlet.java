package com.zt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 1:����һ���� �̳�  HttpServlet
 * */
public class FirstServlet extends HttpServlet{
      /*2 ��д service()����*/
	 @Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
	     System.out.println("FirstServlet service....");
		super.service(arg0, arg1);
	}
	 //3:web.xml ��������
}
