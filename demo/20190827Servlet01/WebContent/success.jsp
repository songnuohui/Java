<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zt.po.Member,java.util.*"%>
<%
List<Member> members=(List<Member>)request.getAttribute("members");
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!--   
     <h1>欢迎 <%=request.getParameter("name") %>  进行xxxxx管理系统！</h1>
   
     <% Member member=(Member)request.getAttribute("member");%>
    <h1>欢迎 <%=member.getName()%>  进行xxxxx管理系统！</h1>
    
    -->  <!--  el -->
     <h1>欢迎 ${membe.name}  进行xxxxx管理系统！</h1>
       <p>${msg}</p>
       <table width="400px" border="1px" cellspacing="0" cellpadding="0">
          <tr>
           <td>id</td>
           <td>name</td>
           <td>pass</td>
           <td>操作</td>
          </tr>
          <%for(Member m:members){ %>
              <tr>
           <td><%=m.getId() %></td>
           <td><%=m.getName() %></td>
           <td><%=m.getPass() %></td>
            <td>修改  删除</td>
          </tr>
          <%} %>
       </table>
</body>
</html>