<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
   *{font-size:24px;}
</style>
</head>
<body>
   <p> 1:获取请求方式：(get|post)<br/>
      request.getMethod():<%=request.getMethod() %></p>
      
    <p>2：请求类型（
            get--> null
           post--> application/x-www-form-urlencoded）<br/>
      request.getContentType(): <%=request.getContentType() %> 
      </p>
    <p>3：获取请求编码
      request.getCharacterEncoding(): 
         <%=request.getCharacterEncoding() %>
               对于get请求 默认是null  post默认是iso-8859-1
     </p> 
    <p>4：设置请求编码
       request.setCharacterEncoding(): 
         <%request.setCharacterEncoding("UTF-8"); %>
                  对于get请求 是无效的   post是可以的
     </p>  
      
   <p>5：获取请求路径（完整路径） 
        request.getRequestURL():<%=request.getRequestURL()%>
   </p>  
    <p>6：获取请求路径（相对路径） 
        request.getRequestURI():<%=request.getRequestURI()%>
   </p> 
    <p>7：获取请求参数列表 ?key1=值1&....&keyn=值n
        request.getQueryString():<%=request.getQueryString()%>
   </p>
   <p>8：获取请求的上下文路径 （项目/工程名）
       request.getContextPath()：<%=request.getContextPath()%>
   </p>
   <p>9：获取请求协议  HTTP/1.1 ->tomcat server.xml里面配置了
       request.getProtocol()：<%=request.getProtocol()%><br/>
       request.getScheme():<%=request.getScheme()%>
   </p>
   <p>10：获取服务器的机器名
       request.getServerName()：<%=request.getServerName()%>
   </p>
    <p>11：获取服务器的机器提供的访问端口号
       request.getServerPort()：<%=request.getServerPort()%>
   </p>
    <p>12：获取客户端的ip
        request.getRemoteAddr():<%=request.getRemoteAddr()%>
   </p>
    <p>13：获取客户端的机器名
        request.getRemoteHost():<%=request.getRemoteHost()%>
                              <%=request.getRemoteUser()%>
   </p>
   <p>14：获取客户端的机器的访问端口号
        request.getRemotePort():<%=request.getRemotePort()%>
   </p>
   <p>15：获取请求参数对应的值
        request.getParameter():<br/>
                姓名:<%=request.getParameter("name")%><br/>
               爱好：  <%String favs[]=request.getParameterValues("fav");
           for(String s:favs){
         %>
           <%=s%> <br/>
        <%} %>
   </p>
   
     
</body>
</html>