<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,com.zt.po.Member"%>    
<%@ page import="com.zt.dao.MemberDao,com.zt.dao.impl.MemberDaoImpl"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
      <h1> 欢迎进入系统！！！！</h1> 
      <table width="400px" align="center" cellpadding="0"
               cellspacing="0" border="1px">
        <tr>
           <td>id</td><td>name</td><td>操作</td>
        </tr>         
      <% MemberDao dao= new MemberDaoImpl(); 
       List<Member> members=dao.findAll();
       for(Member m:members){
      %>
      <tr>
           <td><%=m.getId() %></td><td><%=m.getName() %></td>
           <td>
            <a href="update.jsp?id=<%=m.getId()%>">修改 </a> 
            <a href="del.jsp?id=<%=m.getId()%>" 
            onclick="return confirm('删除后无法恢复，是否确认删除')">
                       删除</a>
           </td>
        </tr> 
      <%} %>
      </table>
</body>
</html>