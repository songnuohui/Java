package com.zt.servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet{
    
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	request.setAttribute("name", "requestName");
    	
    	HttpSession session=request.getSession();
    	session.setAttribute("name", "sessionName");
    	
    	ServletContext application=request.getServletContext();
    	application.setAttribute("name", "applicationName");
    	
    	request.getRequestDispatcher("second.jsp")
    	        .forward(request, response);
    	
    }
}
