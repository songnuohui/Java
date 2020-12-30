<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%
        application.setAttribute("name", "applicationName");
         //设置一个页面的访问量
      /*   if(application.getAttribute("count")==null){
        	 application.setAttribute("count", 1);
         }else{
        	 Integer n=(Integer)application.getAttribute("count");
        	 application.setAttribute("count", n+1);
         }*/
         
         //访问刷新来增加访问量问题
         if(application.getAttribute("count")==null){
        	 application.setAttribute("count", 1l);
         }else{ 	
        	 //判断是否是一次新的访问
        	 if(session.isNew()){
        		 Long n=(Long)application.getAttribute("count");
            	 application.setAttribute("count", n+1); 
             }	
         } 
    %>
    <p>${name}</p>
     <p><a href="second.jsp">下一页</a></p>
     <p>你是本站的第  ${count} 个访问者！</p>
     
      <p>${app } <p>
</body>
</html>