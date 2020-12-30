<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zt.po.Member"%>
<%@ page import="com.zt.dao.MemberDao,com.zt.dao.impl.MemberDaoImpl"%>       
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <% MemberDao dao= new MemberDaoImpl(); 
     String idStr= request.getParameter("id");
     int id=0;
     if(idStr!=null&&!idStr.equals("")){
    	 id=Integer.parseInt(idStr);
     }
     Member member=dao.getMemberById(id);
    %>
       <form action="updateUser.jsp" method="post">
        <input type="hidden" name="id" value="<%=member.getId()%>">
        <p>姓名：<input type="text" name="name" 
                  value="<%=member.getName()%>"></p>
        <p>原密码：<input type="password" name="pass"></p>
        <p>新密码：<input type="password" name="newpass"></p>
        <p><input type="submit" value="修改"></p>
     </form>
</body>
</html>