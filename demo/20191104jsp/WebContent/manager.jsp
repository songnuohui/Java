<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.zt.po.User,java.util.*,
                com.zt.dao.UserDao,com.zt.utils.PageUtil,
                com.zt.dao.impl.UserDaoImpl" %>    
<%    
   UserDao dao=new UserDaoImpl();
   Map filter=new HashMap();
   int totalSize=dao.getToatalSize(filter);
   PageUtil pageUtil=new PageUtil();
   int currPage=1;
   String pageStr=request.getParameter("page");
   if(pageStr!=null&&!"".equals(pageStr)){
	   currPage=Integer.parseInt(pageStr);
   }
   pageUtil.setCurrPage(currPage);
   pageUtil.setPageSize(4);
   pageUtil.setTotalSize(totalSize);
   pageUtil.setTotalPage(totalSize);
   List<User> userList=dao.findUserBypage(filter, pageUtil);
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table width="600px" cellpadding="0" cellspacing="0"
            border="1px">
      <tr>
          <th>id</th><th>name</th><th>status</th><th>操作</th>
      </tr>      
   <%for(User u:userList){ %>
      <tr>
          <th><%=u.getUserId() %></th>
          <th><%=u.getName() %></th>
          <th><%=u.getStatus() %></th>
          <th>
                         修改   删除
          </th>
      </tr>
   <%} %>
     <tr>
        <td colspan="4">
                  共 <%=pageUtil.getTotalSize() %>条记录，
                  当前第<%=pageUtil.getCurrPage() %>页  
                  每页显示<%=pageUtil.getPageSize() %>条，
                  共<%=pageUtil.getTotalPage() %>  页
                  
           <a href="manager.jsp?page=1">首页</a>
           <a href="manager.jsp?page=<%=pageUtil.getCurrPage()-1%>">上一页</a>
           <a href="manager.jsp?page=<%=pageUtil.getCurrPage()+1%>">下一页</a>      
           <a href="manager.jsp?page=<%=pageUtil.getTotalPage()%>">尾页 </a>
           
        </td>
     </tr>
   </table>
</body>
</html>