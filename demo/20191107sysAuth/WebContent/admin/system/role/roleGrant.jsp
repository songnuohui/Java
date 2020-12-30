<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>角色赋权</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../../css/main.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../js/common.js"></script>
		<script type="text/javascript" src="../../js/jquery.js"></script>
		<style type="text/css">
			ul {
				list-style: none;
			}
			#treeMenu ul{
				margin-left: 50px;
			}
			.hidden{
				display: none;
			}
		</style>
		<script type="text/javascript">
			$(function(){
				$("#treeMenu").children("li").children(":checkbox").click(function(){
					var flag = $(this).attr("checked");
					$(this).siblings("ul").show();
					$(this).siblings("ul").children("li").children(":checkbox").attr("checked", flag);
				}).siblings("a").click(function(){
					$(this).siblings("ul").toggle();
				});
			});
		</script>
	</head>
<body>
    <form action="role?method=saveRoleAuth" method="post">
	<div class="page_title">角色管理&nbsp; &gt; 角色赋权</div>
	<div class="button_bar">
		<button class="common_button" onclick="back();">返回</button>
		<input type="submit" value="保存" class="common_button">
	</div>
	<table class="query_form_table">
		<tr>
			<th>角色名称</th>
			<input type="hidden" value="${role.id}" name="roleId" />
			<td><input type="text" value="${role.name}" readonly /></td>
			<th></th>
			<td></td>
		</tr>

		<tr>
			<th>赋权</th>
			<td colspan="3">
				<ul id="treeMenu" class="forminfo">
				   <c:forEach items="${firstList}" var="p">
					<li>
						<input type="checkbox"/>
						<a href="javascript:void(0);">${p.name}</a>

						<ul class="hidden">
						  <c:forEach items="${secondList}" var="s">
						    <c:if test="${s.parent.id==p.id}">
							<li>
								<input type="checkbox" name="authId" value="${s.id}" <c:forEach items="${roleAuths}" var="ra">
								   <c:if test="${ra.authId==s.id }">checked="checked"</c:if>
								</c:forEach>/>
								
								
								<a href="javascript:void(0);">${s.name}</a>
							</li>
							</c:if>
							</c:forEach>
						</ul>
					</li>
                  </c:forEach>
					
				</ul>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>