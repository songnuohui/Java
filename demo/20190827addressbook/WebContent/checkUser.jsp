<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zt.po.AddressBook,java.text.SimpleDateFormat,java.util.Date"%>
<%@ page import="com.zt.dao.AddressBookDao,com.zt.dao.impl.AddressBookDaoImpl"%>
<%
   request.setCharacterEncoding("UTF-8");
   String name=request.getParameter("name");
   String tel=request.getParameter("tel"); 
   AddressBookDao dao=new AddressBookDaoImpl();
   AddressBook book=dao.login(name, tel);
   if(book==null){
	   response.sendRedirect("error.jsp");
   }else{
	   response.sendRedirect("manager.jsp");
   }
 %>