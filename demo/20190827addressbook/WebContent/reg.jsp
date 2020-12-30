<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zt.po.AddressBook,java.text.SimpleDateFormat,java.util.Date"%>
<%@ page import="com.zt.dao.AddressBookDao,com.zt.dao.impl.AddressBookDaoImpl"%>
<%
   request.setCharacterEncoding("UTF-8");
   String name=request.getParameter("name");
   String sex=request.getParameter("sex");
   String tel=request.getParameter("tel");
   String company=request.getParameter("company");
   String birthDay=request.getParameter("birthDay");
   AddressBookDao dao=new AddressBookDaoImpl();
   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
   Date dt=df.parse(birthDay);
   AddressBook book=new AddressBook(name,sex,tel,company,dt);
   boolean f=dao.addAddressBook(book);
   if(f){
	   response.sendRedirect("success.jsp");
   }else{
	   response.sendRedirect("error.jsp");
   }

%>