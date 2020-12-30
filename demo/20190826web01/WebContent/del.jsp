<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    boolean f=dao.delMember(id);
    if(f){
	    response.sendRedirect("success.jsp");
   }else{
	    response.sendRedirect("error.jsp");
   }
   %>
</body>
</html>