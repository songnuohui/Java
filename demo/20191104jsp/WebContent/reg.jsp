<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zt.dao.UserDao,
                com.zt.dao.impl.UserDaoImpl" %>    
<%
   String name=request.getParameter("name");
   String pass=request.getParameter("pass");
   UserDao dao=new UserDaoImpl();
   boolean f=dao.reg(name, pass);
   if(f){
	   request.setAttribute("info", "恭喜你，注册成功！");
   }else{
	   request.setAttribute("info", "sorry，注册失败！");
   }
   request.getRequestDispatcher("index.jsp")
     .forward(request, response);
 %>