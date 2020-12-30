<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
      String key=request.getParameter("key");
      //模拟用key  去数据库查询相应的数据
      List list=new ArrayList();
      for(int i=0;i<100;i++){
    	  list.add("aaaaa"+i);
      }
      request.setAttribute("news", list);
      request.getRequestDispatcher("dispatcher3.jsp")
      .forward(request, response);
       
      
    %>
</body>
</html>