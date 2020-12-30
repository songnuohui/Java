<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zt.po.User,
                com.zt.dao.UserDao,
                com.zt.dao.impl.UserDaoImpl" %>    
<%
  String name=request.getParameter("name");
  String pass=request.getParameter("pass");
  UserDao dao=new UserDaoImpl();
  User user=dao.login(name, pass);
  if(user!=null){
	  session.setAttribute("user", user);
	  response.sendRedirect("manager.jsp");
  }else{
	  request.setAttribute("error", "用户名或密码错误");
	  request.getRequestDispatcher("index.jsp")
	          .forward(request, response);	  
  }

%> 