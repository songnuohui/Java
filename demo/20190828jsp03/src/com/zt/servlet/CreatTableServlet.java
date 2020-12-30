package com.zt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreatTableServlet extends HttpServlet{
     @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	 PrintWriter out=response.getWriter();
    	 out.write("<table width='900px' cellspacing='0' "
    	 		+ "cellpadding='0' border='1px'>");
    	 for(int i=1;i<10;i++){
    		 out.write("<tr>");
    		 for(int j=1;j<=i;j++){
    			 out.write("<td>");
    			 out.write(i+"*"+j+"="+i*j);
    			 out.write("</td>");
    		 } 
    		 out.write("</tr>");
    	 }
    	 out.write("</table>");
    }
}
