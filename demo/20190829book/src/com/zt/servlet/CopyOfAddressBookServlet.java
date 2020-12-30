package com.zt.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zt.dao.AddressBookDao;
import com.zt.dao.impl.AddressBookDaoImpl;

public class CopyOfAddressBookServlet extends HttpServlet{
	   private AddressBookDao dao;
	   public void init() throws ServletException {
		   dao=new AddressBookDaoImpl();
		 System.out.println("AddressBookServlet init...");
	   }
	   public CopyOfAddressBookServlet(){
		 System.out.println("AddressBookServlet ¹¹ÔìÆ÷...");
	   }
       protected void service(HttpServletRequest request, HttpServletResponse response)
        		throws ServletException, IOException {
        	System.out.println("AddressBookServlet service...");
        	List names=new ArrayList();
        	super.service(request, response);
        }   
       protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        		throws ServletException, IOException {
        	System.out.println("AddressBookServlet doGet....");
        }

       protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        		throws ServletException, IOException {
        	System.out.println("AddressBookServlet doPost....");
        }
        
       public void destroy() {
        	System.out.println("AddressBookServlet destroy...");
        }
        
}
