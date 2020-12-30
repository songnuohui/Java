package com.zt.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AppServlet extends HttpServlet{
       @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	   
    	ServletContext application=  request.getServletContext();
    	application.setAttribute("app", "AppServletValue");
    	response.sendRedirect("index.jsp");
    	
    }
} 
