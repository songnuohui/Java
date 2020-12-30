<%@ page language="java" contentType="text/html; charset=UTF-8"
     import="com.zt.po.User,java.util.*" pageEncoding="UTF-8"%>
<% 
    User user=new User(2,"admin","123456"); 
    pageContext.setAttribute("user", user);
      pageContext.setAttribute("name", "pageContextName");
      request.setAttribute("name", "requestName");
      session.setAttribute("name", "sessionName");
      application.setAttribute("name", "applicationName");
    List users=new ArrayList();  users.add("aaaaaa");
    users.add("bbbb"); users.add("cccc");
    pageContext.setAttribute("users", users);
    Map map=new HashMap();
    map.put("name", "张三");map.put("score", 90);
    pageContext.setAttribute("stuScore", map);  
   %>
      ${name}<br/>
      ${pageScope.name}<br/>
      ${requestScope.name}<br/>
      ${sessionScope.name}<br/>
      ${applicationScope.name}<br/>
      
      <hr/>
         ${user}<br/>${user.id }<br/>${user.name }<br/>${user.pass }<br/>
         <hr/>${users} <hr/>
            ${stuScore}<br/>
            ${stuScore["name"]}<br/>
            ${stuScore["score"]}<br/>
</html>