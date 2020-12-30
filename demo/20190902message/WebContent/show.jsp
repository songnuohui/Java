<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <div style="width:800px;margin:0 auto;">
     <!-- 未登录 -->
     <!--  c:if test="${loginMember==null}">-->
     <c:if test="${empty loginMember}">
     <form action="member?method=login" method="post">
             用户名:<input type="text" name="name">
             密码:<input type="password" name="pass">
            <input type="submit" value="登录"> 
            <span style="color:#ff0000;">${error}</span>
     </form>
     </c:if>
     <c:if test="${not empty loginMember}">
      <!-- 登录  --> 
              欢迎    ${loginMember.name} 进入留言管理中心！      
              <a href="member?method=out">退出</a> 
       </c:if>  
       </div>
        <hr/>
        <h1>${message.title}</h1>
        <p align="right">
                     作者：${message.member.name}<br/>
                发布时间:${message.createTime}<br/>
                 发布IP:${message.ip}<br/>
        
        </p>
        <p>${message.content}</p>
         <p><a href="msg?method=list">返回主页</a></p>
</body>
</html>