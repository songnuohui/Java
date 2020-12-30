<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.zt.po.User"%>
<%
  request.setAttribute("msg", "admin");

  User user=new User();
  user.setId(10);user.setName("张三");
  user.setTel("136776666");
  request.setAttribute("user", user);
  
  request.getRequestDispatcher("show.jsp")
  .forward(request, response);


%>