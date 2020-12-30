<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.zt.po.AddressBook,java.text.SimpleDateFormat,java.util.*"%>
<%@ page import="com.zt.dao.AddressBookDao,com.zt.dao.impl.AddressBookDaoImpl"%>
<%
   AddressBookDao dao=new AddressBookDaoImpl();
   List<AddressBook>  books=dao.findAll();
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
        <table width="600px" border="1px"
           cellspacing="0" cellpadding="0" align="center">
           <tr>
               <td height="32px">序号</td>
               <td>姓名</td>
               <td>出生年月日</td>
               <td>性别</td>
               <td>联系电话</td>
               <td>工作单位</td>
               <td>操作</td>
           </tr>
           <%for(int i=0;i<books.size();i++){
             AddressBook book=books.get(i);
            %>
            <tr>
               <td height="32px"><%=i+1%></td>
               <td><%=book.getName() %></td>
               <td><%=book.getBirthDay()%></td>
               <td><%=book.getSex()%></td>
               <td><%=book.getTel() %></td>
               <td><%=book.getCompany() %></td>
               <td>
                 <a href="update.jsp?id=<%=book.getId()%>">修改</a>
                                 删除
               </td>
           </tr>
           <%}  %>
        </table>
</body>
</html>