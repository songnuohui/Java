package com.zt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/show")
public class ShowServlet extends HttpServlet{
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {	  	
	  String name= request.getParameter("name");
	  String address= request.getParameter("address");
	  response.setContentType("text/html;charset=UTF-8");	  
	  PrintWriter out=  response.getWriter();
	  out.write("name="+name+"<br/>");
	  out.write("address"+address);
	  out.flush();  out.close();
}
}
