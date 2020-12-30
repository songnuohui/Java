<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1>second.jsp</h1>
       <%=request.getAttribute("msg") %>
       <%request.setAttribute("msg",request.getAttribute("msg")); %>
     <hr/>
     <%=session.getId()%> <BR/>
     <%=session.getAttribute("sessionkey")%> <BR/>
     <%=session.getAttribute("sessionkey2")%> 
       <%--session.removeAttribute("sessionkey"); --%> 
       <%  session.invalidate();%>
       
         <a href="three.jsp">下一页</a>
</body>
</html>