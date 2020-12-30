package com.zt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet{
	public RegServlet(){
		System.out.println("RegServlet ¹¹ÔìÆ÷¡£");
	}
    @Override
    protected void service(HttpServletRequest request, 
    		               HttpServletResponse response)
    		throws ServletException, IOException {
    	System.out.println("RegServlet service..");
    	super.service(request, response);
    	
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	System.out.println("RegServlet doPost..");
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	System.out.println("RegServlet doGet..");
    	
    }
}
