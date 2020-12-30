package com.zt.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zt.dao.AddressBookDao;
import com.zt.dao.impl.AddressBookDaoImpl;
import com.zt.po.AddressBook;
/*
 *   book?method=login
 *   book?method=list
 * 
 * **/
public class AddressBookServlet extends HttpServlet{
	   private AddressBookDao dao;
	   public void init() throws ServletException {
		   dao=new AddressBookDaoImpl();
	   }
       protected void service(HttpServletRequest request, HttpServletResponse response)
        		throws ServletException, IOException {
    	   request.setCharacterEncoding("UTF-8");
    	   String method=request.getParameter("method");
    	   if("login".equals(method)){
    		   login(request,response);
    	   }
    	   if("list".equals(method)){
    		   list(request,response);
    	   }
    	   if("del".equals(method)){
    		   del(request,response);
    	   }
    	   if("update".equals(method)){
    		   update(request,response);
    	   }
    	   if("modify".equals(method)){
    		   modify(request,response);
    	   }
    	   
        } 
       protected void login(HttpServletRequest request, HttpServletResponse response)
       		throws ServletException, IOException {
    	   String name=request.getParameter("name");
    	   String tel=request.getParameter("tel");
    	  AddressBook book= dao.login(name, tel);
    	  if(book!=null){
    		 HttpSession session= request.getSession();
    		 session.setAttribute("loginBook", book);
    		 response.sendRedirect("book?method=list");
    	  }else{
    		  request.setAttribute("error", "用户名或密码错误");
     		   request.getRequestDispatcher("index.jsp")
     		        .forward(request, response);
    	  }
       }  
       protected void list(HttpServletRequest request, HttpServletResponse response)
          		throws ServletException, IOException {
    	   List<AddressBook> books=dao.findAll();
  		   request.setAttribute("books", books);
  		   request.getRequestDispatcher("list.jsp")
  		        .forward(request, response);
          }  
       protected void del(HttpServletRequest request, HttpServletResponse response)
          		throws ServletException, IOException {
    	   String idStr=request.getParameter("id");
    	   int id=0;
    	   if(idStr!=null){
    		   id=Integer.parseInt(idStr);
    	   }
    	   boolean f=dao.delAddressBook(id);
    	   if(f){
    		   response.sendRedirect("book?method=list");
    	   }else{
    		   response.sendRedirect("error.jsp");
    	   }
          	
          } 
       protected void update(HttpServletRequest request, HttpServletResponse response)
          		throws ServletException, IOException {
    	   String idStr=request.getParameter("id");
    	   int id=0;
    	   if(idStr!=null){
    		   id=Integer.parseInt(idStr);
    	   }
    	   AddressBook book=dao.getAddressBookById(id);
    	   request.setAttribute("book", book);
  		   request.getRequestDispatcher("update.jsp")
  		        .forward(request, response);
          	
          }  
       protected void modify(HttpServletRequest request, HttpServletResponse response)
          		throws ServletException, IOException {
    	   String idStr=request.getParameter("id");
    	   String name=request.getParameter("name");
    	   String sex=request.getParameter("sex");
    	   String tel=request.getParameter("tel");
    	   String company=request.getParameter("company");
    	   String birthDay=request.getParameter("birthDay");
    	   AddressBookDao dao=new AddressBookDaoImpl();
    	   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
    	   Date dt =null;
		    try{
			     dt = df.parse(birthDay);
		     }catch (ParseException e) {
			e.printStackTrace();
		    }
    	   int id=0;
    	   if(idStr!=null){
    		   id=Integer.parseInt(idStr);
    	   }
    	   AddressBook book=dao.getAddressBookById(id);
    	   book.setName(name);book.setTel(tel);book.setCompany(company);
    	   book.setSex(sex);book.setBirthDay(dt);
    	   boolean f=dao.updateAddressBook(book);
    	   if(f){
    		   response.sendRedirect("book?method=list");
    	   }else{
    		   response.sendRedirect("error.jsp");
    	   }
          	
          }  
       
        
}
