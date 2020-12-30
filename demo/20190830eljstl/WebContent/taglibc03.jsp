<style type="text/css">
   .myclass0{background:#ff0000;}
   .myclass1{background:#0000ff;}
   .myclass2{background:#99ccff;}
</style>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.zt.po.User" %>    
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
     List<User> users=new ArrayList<User>();
     for(int i=0;i<10;i++){//模拟获取10条数据到集合
    	 User user=new User(i+1,"admin"+i,"123456");
    	 users.add(user);
     }
     pageContext.setAttribute("users", users);
    
%>
   <table width="400px" cellpadding="0" cellspacing="0" border="1">
      <c:forEach items="${users}" var="user" varStatus="i">
        <tr class="myclass${i.count%3}"><td>${user.id}</td><td>${user.name}</td>
            <td>${i.count}</td>
        </tr>
      </c:forEach>
   </table>  
     <hr/>
     <table width="400px" cellpadding="0" cellspacing="0" border="1">
      <c:forEach items="${users}" var="user" varStatus="i"
          begin="1" end="6" step="2">
        <tr class="myclass${i.count%3}"><td>${user.id}</td><td>${user.name}</td>
            <td>${i.count}</td>
        </tr>
      </c:forEach>
   </table>  
      