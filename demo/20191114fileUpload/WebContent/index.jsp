<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <form action="reg" method="post" 
                 enctype="multipart/form-data">
         <p>用户名：<input type="text" name="name"/></p>
         <p>密码：<input type="password" name="pass"/></p>
         <p>住址：<input type="text" name="address"/></p>
         <p>头像：<input type="file" name="photo"/></p>
         <p><input type="submit" value="注册"/></p>
     </form>
</body>
</html>