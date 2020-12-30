<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"
           prefix="fmt"%>
           
<%       
     pageContext.setAttribute("price1", 101);
     pageContext.setAttribute("price2", 87); 
     pageContext.setAttribute("currTime", new Date()); 
%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <p>${price2/price1}</p>
    <p><fmt:formatNumber value="${price2/price1}"
         pattern="#.#"/>
    </p>
    <p>${currTime}</p>
     <p><fmt:formatDate value="${currTime}" 
         pattern="yyyy-MM-dd HH:mm:ss"/></p>
</body>
</html>