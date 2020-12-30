<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%! 
       int index=1;   //全局变量  所有用户共享
     %>
     <% 
       int count=1;   //局部变量 单个用户共享
     %>
     <h1>欢迎大家开始jsp的学习！！！</h1>
         你是本站的第<%=count++ %>个访问者！
          
       <!-- 这个是html的注释 所有人可见 -->
       
       <%-- 这个是jsp的注释 这个代码仅仅程序员可见  --%> 
       
       <a href="login.jsp?id=10">我要登录系统</a> 
         
</body>
</html>