<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>  
<%
    pageContext.setAttribute("price", 99.34544545);
    Date dt=new Date();
    pageContext.setAttribute("createTime", dt);
%>  
     <p> ${price}</p>
     <p><fmt:formatNumber value="${price}"pattern="#.###"/>
     </p>
     <p> ${createTime}</p>
     <p><fmt:formatDate value="${createTime}" pattern="yyyy"/></p>
     <p><fmt:formatDate value="${createTime}" pattern="yyyy-MM-dd"/></p>
     <p><fmt:formatDate value="${createTime}"
                         pattern="yyyy-MM-dd HH:mm:ss"/></p>
  
