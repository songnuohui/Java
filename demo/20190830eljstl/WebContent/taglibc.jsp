<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
     pageContext.setAttribute("age", 18);
    /* int age=(Integer)pageContext.getAttribute("age");
     out.print("<p>"); 
       if(age>=18){
    	 out.print("成年人！");}else{ out.print("未成年人！");} 
       out.print("</p>"); */
     %>
      <p>${age}</p>
      <p> <c:if test="${age>=18}"> 成年人！</c:if>
        <c:if test="${age<18}"> 未成年人！</c:if>
      </p>