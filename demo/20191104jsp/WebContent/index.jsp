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
  <hr/>
    <h1 align="center">用户注册</h1>
    <form action="reg.jsp" method="post">
        <p>用户名：<input type="text" name="name"></p>
        <p>密码：<input type="password" name="pass"></p>
        <p><input type="submit" value="注册"></p>
    </form>
     <p><%--=request.getAttribute("info")--%>
           ${info}
     </p>
     <hr/>
    <h1 align="center">用户登录</h1>
    <form action="login.jsp" method="post">
        <p>用户名：<input type="text" name="name"></p>
        <p>密码：<input type="password" name="pass"></p>
        <p><input type="submit" value="登录"></p>
    </form>
      <p>${error}</p>
</body>
</html>