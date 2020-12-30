<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zt.po.AddressBook,java.text.SimpleDateFormat,java.util.Date"%>
<%@ page import="com.zt.dao.AddressBookDao,com.zt.dao.impl.AddressBookDaoImpl"%>
<%
   request.setCharacterEncoding("UTF-8");
   String idStr=request.getParameter("id");
   String name=request.getParameter("name");
   String sex=request.getParameter("sex");
   String tel=request.getParameter("tel");
   String company=request.getParameter("company");
   String birthDay=request.getParameter("birthDay");
   AddressBookDao dao=new AddressBookDaoImpl();
   SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
   Date dt=df.parse(birthDay);
   int id=0;
   if(idStr!=null){
	   id=Integer.parseInt(idStr);
   }
   AddressBook book=dao.getAddressBookById(id);
   book.setName(name);book.setTel(tel);book.setCompany(company);
   book.setSex(sex);book.setBirthDay(dt);
   boolean f=dao.updateAddressBook(book);
   if(f){
	   response.sendRedirect("manager.jsp");
   }else{
	   response.sendRedirect("error.jsp");
   }

%>