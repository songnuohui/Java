<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="com.zt.po.*" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1 align="center">欢迎进入通讯录管理系统--修改通讯录</h1>
     <table width="400px" align="center">
     <tr><td>
     <% AddressBook book=(AddressBook)request.getAttribute("book");
        if(book!=null){
     %>
     <form action="book?method=modify" method="post">
         <input type="hidden" name="id" value="<%=book.getId()%>"/>
         <p>姓名:<input type="text" name="name" value="<%=book.getName()%>"/></p>
         <p>性别:
          <input type="radio" name="sex" value="男"  <% if("男".equals(book.getSex())){ %>
           checked="checked"
         <%} %>/>男 
          <input type="radio" name="sex" value="女"  <% if("女".equals(book.getSex())){ %>
           checked="checked"
         <%} %>/>女</p>
         <p>联系电话:<input type="text" name="tel" value="<%=book.getTel()%>"/></p>
         <p>工作单位:<input type="text" name="company" value="<%=book.getCompany()%>"/></p>
         <p>出生年月日:<input type="text" name="birthDay" value="<%=book.getBirthDay()%>"/></p> 
         <p><input type="submit" value="修改"/>
            <input type="reset" value="重置"/>
         </p>
     </form>
       <%}else{
    	   out.print("数据不存在！无法修改");
       } %>
     </td></tr>
     </table>
</body>
</html>