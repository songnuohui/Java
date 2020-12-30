<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        request.setAttribute("role", "系统管理员");
        out.print(request.getAttribute("role"));
    
        List<String> names=new ArrayList();
        names.add("aaaaa");names.add("bbbbb");names.add("cccc");
        out.print("<ol type='1'>");
        for(String s:names){
        	 out.print("<li>"+s+"</li>");
        }
        out.print("</ol>");
    %>
    <%--=request.getAttribute("role") --%>
    <%--for(String s:names){
    	
    --%>
    <%--=s  --%>
    <%--} --%>
</body>
</html>