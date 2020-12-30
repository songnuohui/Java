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
     request.setCharacterEncoding("UTF-8");
     String idStr= request.getParameter("id");
     String name= request.getParameter("name");
     String pass= request.getParameter("pass");
     String newpass= request.getParameter("newpass");
     int id=0;
     if(idStr!=null&&!idStr.equals("")){
    	 id=Integer.parseInt(idStr);
     }
     Member member=dao.getMemberById(id);
     if(member.getPass().equals(pass)){
    	 //原始密码输入正确 可以修改
    	 member.setName(name);
    	 member.setPass(newpass);
    	 boolean f=dao.updateMember(member);
    	 if(f){
    		    response.sendRedirect("success.jsp");
    	   }else{
    		    response.sendRedirect("error.jsp");
    	   }
     }else{
    	  response.sendRedirect("error.jsp");
     }
    %>
</body>
</html>