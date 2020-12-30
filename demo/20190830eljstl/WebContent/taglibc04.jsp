<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  
   <!--    "A,B,C,D,E" -->
   <c:forTokens items="A,B,C,D,E" delims="," var="s">
       <p>${s}</p>
   </c:forTokens>
   
   <!--    "A,B=C|D,E" -->
   <c:forTokens items="A,B=C|D,E" delims=",=|" var="s">
       <p>${s}</p>
   </c:forTokens>
   
  