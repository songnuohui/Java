package com.zt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet{
     private String className="";
     private String url="";
     private String user="";
     private String pass="";
    public void init(ServletConfig config) throws ServletException {
    	className=config.getInitParameter("className");
    	url=config.getInitParameter("url");
    	user=config.getInitParameter("user");
    	pass=config.getInitParameter("pass");
    	System.out.println("className="+className);
    	System.out.println("url="+url);
    	System.out.println("user="+user);
    	System.out.println("pass="+pass);
    }
     
	
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	 try {
			Class.forName(className);
			Connection conn=DriverManager
					       .getConnection(url, user, pass);
			
			 System.out.println(conn);
			
		    } catch (Exception e) {
			e.printStackTrace();
		}
    	 
    }
}
