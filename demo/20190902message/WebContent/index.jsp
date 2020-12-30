<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div style="width:800px;margin:0 auto;">
     <!-- 未登录 -->
     <!--  c:if test="${loginMember==null}">-->
     <c:if test="${empty loginMember}">
     <form action="member?method=login" method="post">
             用户名:<input type="text" name="name">
             密码:<input type="password" name="pass">
            <input type="submit" value="登录"> 
            <span style="color:#ff0000;">${error}</span>
     </form>
     </c:if>
     <c:if test="${not empty loginMember}">
      <!-- 登录  --> 
              欢迎    ${loginMember.name} 进入留言管理中心！      
              <a href="member?method=out">退出</a> 
       </c:if>  
       <table width="800px" cellpadding="0" cellspacing="0"
             align="center" border="1px">
         <tr>
             <td>序号</td>
             <td>标题</td>
             <td>发布人</td>
             <td>发布时间</td>
             <td>操作</td>
         </tr>
         <c:forEach items="${msgList}" var="msg" varStatus="i">
          <tr>
             <td>${i.count}</td>
             <td><a href="msg?method=show&id=${msg.id}">${msg.title}</a></td>
             <td>${msg.member.name}</td>
             <td>${msg.createTime}  &nbsp; &nbsp; &nbsp;${msg.ip}</td>
             <td>
                 <c:if test="${msg.member.id==loginMember.id}">
                   <a href="msg?method=edit&id=${msg.member.id}">修改</a>
                     &nbsp; &nbsp; &nbsp;
                   <a href="msg?method=del&id=${msg.member.id}">删除</a>
                 </c:if>
             
             </td>
         </tr>
          </c:forEach>
       </table>  
    </div>     
      <c:if test="${not empty loginMember}">
       <form action="msg?method=add" method="post">
         <table width="800px" cellpadding="0" cellspacing="10"
             align="center" border="0px" style="margin-top:40px;">
            <tr>
                <td>标题:</td>
                <td><input type="text" name="title" size="80"></td>
            </tr>
             <tr>
                <td>内容:</td>
                <td>
                   <textarea rows="10" cols="80" name="content"></textarea>
                </td>
            </tr>
             <tr>
                <td colspan="2" align="center">
                <input type="submit" value="发布留言"></td>
            </tr>
         </table>
       </form>
      </c:if>     
</body>
</html>