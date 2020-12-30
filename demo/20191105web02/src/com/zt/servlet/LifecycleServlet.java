package com.zt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LifecycleServlet extends HttpServlet{
	public void init() throws ServletException {
		System.out.println("LifecycleServlet init 初始化方法");
	}
	public LifecycleServlet(){
		System.out.println("LifecycleServlet 构造方法");
	}
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1)
			throws ServletException, IOException {
		System.out.println("LifecycleServlet service方法");
		super.service(arg0, arg1);
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		  System.out.println("LifecycleServlet doGet方法");
	}
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			System.out.println("LifecycleServlet doPost方法");
    }
    public void destroy() {
    	 System.out.println("LifecycleServlet destroy方法");
    }

}
