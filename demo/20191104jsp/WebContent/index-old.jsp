<%@ page language="java" 
     contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%!int count=1; %>
   <% int count2=1; %>
   <%=count++ %>
    <%=count2++ %>
    
  <p>  <a href="req.jsp?name=aaaa&age=20">发生请求</a></p>
  
    <form action="req2.jsp" method="post">
        <p>用户名：<input type="text" name="userName"></p>
        <p>密码：<input type="password" name="pass"></p>
        <p>电话：<input type="text" name="tel"></p>
        <p><input type="submit" value="提交"></p>
    </form>
  
</body>
</html>