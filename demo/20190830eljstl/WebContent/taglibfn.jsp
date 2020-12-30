<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" 
           prefix="fn"%>
<%
    pageContext.setAttribute("title", 
    		  "习近平：把握好时和势，引领好中菲关系发展 ");
   pageContext.setAttribute("answer", "ABD");
   pageContext.setAttribute("content", "<ul><li>ABD</li</ul>");
 %> 
  <div style="width:180px;border: 1px solid #ff0000;height:30px;">
    ${title}</div> 
    <p></p>
   <div style="width:180px;border: 1px solid #ff0000;height:30px;">
      <c:if test="${fn:length(title)>10}">
         ${fn:substring(title,0,10)}...
      </c:if>
       <c:if test="${fn:length(title)<=10}">
         ${title}
      </c:if>
    </div> 
    
        <c:if test="${fn:contains(answer,'A')}">
          checked="checked"
        </c:if>
       <p> A:<input type="checkbox" value="A" <c:if test="${fn:contains(answer,'A')}">checked="checked"</c:if>/>  
       ZXXZZZZZZ</p>
       <p> B:<input type="checkbox" value="B" <c:if test="${fn:contains(answer,'B')}">checked="checked"</c:if>/>  
       ZXXZZZZZZ</p>
       <p> C:<input type="checkbox" value="C" <c:if test="${fn:contains(answer,'C')}">checked="checked"</c:if>/>  
       ZXXZZZZZZ</p>
       <p> D:<input type="checkbox" value="D" <c:if test="${fn:contains(answer,'D')}">checked="checked"</c:if>/>  
       ZXXZZZZZZ</p>
       
       <hr/>
       <p>${content}</p>
       <hr/>
        <p>${fn:escapeXml(content)}</p>
       
       
              