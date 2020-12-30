<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%  
    pageContext.setAttribute("title", "亏大了!男子灭个蟑螂烧坏3辆车");
 pageContext.setAttribute("content", "<font size=7>亏大了</font>!男子灭个蟑螂烧坏3辆车");
 %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
            prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
            prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>${title}</h1>
    <p>${fn:length(title)}</p>  
      
    <p>
       <c:if test="${fn:length(title)<=10}">
         ${title}
       </c:if>
        <c:if test="${fn:length(title)>10}">
           ${fn:substring(title,0,10)}
        </c:if>
    </p> 
    <p>
      <c:if test="${fn:contains(title,'男子')}">
                   包含男子字符</c:if>  </p>
      ${fn:startsWith(filename, ".txt")}判断是否以什么开头
      ${fn:endsWith(filename, ".txt")}  判断是否以什么结尾    
      <p>${content}</p>
     <p>${fn:escapeXml(content)}</p>     
</body>
</html>