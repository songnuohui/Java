<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
     pageContext.setAttribute("age", 18);
     %>
      <p>${age}</p>
      <p> <!--  <18              未成年人
               >=18   <30      年轻人         >=30   <50      中年人
               >=50            老年人   -->
         <c:choose>
             <c:when test="${age<18}">未成年人</c:when>
             <c:when test="${age<30}">年轻人</c:when>
             <c:when test="${age<50}">中年人</c:when>
             <c:otherwise> 老年人</c:otherwise>
         </c:choose>
      </p>