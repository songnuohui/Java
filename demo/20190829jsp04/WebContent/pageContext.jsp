<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% pageContext.setAttribute("name", "admin"); %>
   <% System.out.print(pageContext.getAttribute("name")); %>
   
   <%
      request.getRequestDispatcher("show.jsp")
             .forward(request, response);
   
      pageContext.getRequest();
      pageContext.getResponse();
      pageContext.getOut();
      pageContext.getException();
      pageContext.getSession();
      pageContext.getServletContext();
      
   
   %>
   
</body>
</html>