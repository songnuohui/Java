<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.zt.po.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<%   int age=40;
      pageContext.setAttribute("age", age);
      
     List<User> list=new ArrayList<User>(); 
     for(int i=0;i<10;i++){
    	 User u=new User(i,"aaaa"+i,"134545454"+i);
    	 list.add(u);
     }
     pageContext.setAttribute("list", list); 
%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>c 核心标签库 演示</title>
</head>
<body>
    <c:if test="${age>=18}">
                 成年人！
    </c:if>
     <c:if test="${age<18}">
                未成年人！
    </c:if>
    <p>
        <c:choose>
            <c:when test="${age<18}">未成年人！</c:when>
            <c:when test="${age<30}">年青人！</c:when>
            <c:when test="${age<40}">中年人！</c:when>
            <c:when test="${age<60}">中老年人！</c:when>
            <c:otherwise>
                           老年人！
            </c:otherwise>
        </c:choose> 
    </p>
     <ul>
     <c:forEach items="${list}" var="user">
        <li>${user.id}, ${user.name}, ${user.tel}</li>
     </c:forEach>
     </ul>
     
     <ul>
     <c:forEach items="${list}" var="user" varStatus="i">
        <li>${i.index}  ,${user.id}, ${user.name}, ${user.tel}</li>
     </c:forEach>
     </ul>
      <ul>
     <c:forEach items="${list}" var="user" varStatus="i">
        <li>${i.count}  ,${user.id}, ${user.name}, ${user.tel}</li>
     </c:forEach>
     </ul>
</body>
</html>