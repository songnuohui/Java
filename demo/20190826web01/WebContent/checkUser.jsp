<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--jsp中导入外部其他类  可以在一个import中导入一个类或者一个包
         或者在多个import中根据需要导入
   -->
<%@ page import="com.zt.po.Member" %>    
<%@ page import="com.zt.dao.MemberDao,com.zt.dao.impl.MemberDaoImpl" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%--  <% request.setCharacterEncoding("UTF-8");%>
     
     <h1>你输入的信息如下：</h1>
     <p>姓名：<%=request.getParameter("name")%></p>
     <p>密码：<%=request.getParameter("pass")%></p>
     
     --%>
     <% request.setCharacterEncoding("UTF-8");
        String name=request.getParameter("name");
        String pass=request.getParameter("pass");
        MemberDao dao= new MemberDaoImpl();
        Member member=dao.login(name, pass);
        //根据 member结果进行响应
        if(member==null){
        	//失败
        	response.sendRedirect("error.jsp");
        }else{
        	response.sendRedirect("success.jsp");
        }
     %>
</body>
</html>