<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%request.setCharacterEncoding("UTF-8"); %>
  <%=request.getParameter("userName") %><br/>
  <%=request.getParameter("pass") %><br/>
  <%=request.getParameter("tel") %><br/>
  
    <%=request.getProtocol() %><br/>
    <%=request.getScheme() %><br/>
    <!--  显示请求项目的信息  -->
    <%=request.getScheme()+"://"
       +request.getServerName()+":"
       +request.getServerPort()	
       +request.getContextPath()+""
       %><br/>
        <%=request.getRequestURL() %><br/>
         <%=request.getRequestURI() %><br/>
         <%=request.getRemoteAddr()%><br/>
         <%
         //request.setAttribute(arg0, arg1)
         %>
</body>
</html>