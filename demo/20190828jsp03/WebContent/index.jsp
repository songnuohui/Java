<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 
     request.setAttribute("msg", "ok");
     session.setAttribute("sessionkey", "sessionValue");
     session.setAttribute("sessionkey2", "sessionValue2");
    response.sendRedirect("second.jsp");
   //  response.sendRedirect("http://www.sina.com");
 
   // request.getRequestDispatcher("second.jsp").forward(request, response);
    
    //request.getRequestDispatcher("www.sina.com").forward(request, response);
   
 %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   
</body>
</html>