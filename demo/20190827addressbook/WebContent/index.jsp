<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
     <h1 align="center">欢迎进入通讯录管理系统</h1>
     <table width="400px" align="center">
     <tr><td>
     <form action="reg.jsp" method="post">
         <p>姓名:<input type="text" name="name"/></p>
         <p>性别:<input type="radio" name="sex" value="男"/>男  <input type="radio" name="sex" value="女"/>女</p>
         <p>联系电话:<input type="text" name="tel"/></p>
         <p>工作单位:<input type="text" name="company"/></p>
         <p>出生年月日:<input type="text" name="birthDay"/></p> 
         <p><input type="submit" value="注册"/>
            <input type="reset" value="重置"/>
         </p>
     </form>
     </td></tr>
     </table>
      <hr/>
      <table width="400px" align="center">
       <tr><td>
        <form action="checkUser.jsp" method="post">
         <p>姓名:<input type="text" name="name"/></p>
         <p>联系电话:<input type="text" name="tel"/></p>    
         <p><input type="submit" value="登录"/>
            <input type="reset" value="重置"/>
         </p>
     </form>
     </td></tr>
     </table>
</body>
</html>