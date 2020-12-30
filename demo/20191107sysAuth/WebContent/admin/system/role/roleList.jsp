<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>角色管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../../css/main.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../js/common.js"></script>
		<script type="text/javascript">
	         function goPage(page){
				document.getElementById("page").value=page;
				document.getElementById("myform").submit();
			}
		
		</script>
	</head>
<body>
    <form id="myform" action="role?method=list"  method="post">
    <input type="hidden" name="page" id="page">
	<div class="page_title">角色管理</div>
	<div class="button_bar">
		<a class="common_button" href="roleAdd.jsp">新建</a>
		<input type="submit" value="查询" class="common_button"/>
	</div>
	<table class="query_form_table">
		<tr>
			<th>角色名称</th>
			<td><input type="text" name="name" value="${filter['name']}"/></td>
			<th>状态</th>
			<td>
				<select name="status">
					<option value="">请选择</option>		
					<option value="1" <c:if test="${filter['status']=='1'}">selected="selected"</c:if>>正常</option>
					<option value="0" <c:if test="${filter['status']=='0'}">selected="selected"</c:if>>注销</option>
				</select>
			</td>
		</tr>
	</table>
	<br />
	<table class="data_list_table">
		<tr>
			<th>编号</th>
			<th>角色名称</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${roleList}" var="role">
		<tr>
			<td class="list_data_number">${role.id}</td>
			<td class="list_data_text">${role.name}</td>
			<td class="list_data_text">${role.status}</td>
			<td class="list_data_text">
				<a href="modelUpdate.html">编辑</a>
				<a href="#">注销</a>
				<a href="role?method=grant&roleId=${role.id}">授权</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
			<th colspan="8">
				<div class="pager">
					<div class="pager_left">
						共${pageUtil.totalSize}条记录 每页${pageUtil.pageSize}条
						第${pageUtil.currPage}页/共${pageUtil.totalPage}页
						转到<input value="1" size="1" />页
						<button width="20" onclick="reload();">GO</button>
					</div>
					<div class="pager_right">
						<button class="common_button" onclick="goPage(1)">首页</button>
						 <c:if test="${pageUtil.currPage>1}">
						<button class="common_button" onclick="goPage(${pageUtil.currPage-1})">上一页</button>
						</c:if>
						 <c:if test="${pageUtil.currPage<pageUtil.totalPage}">
						<button class="common_button" onclick="goPage(${pageUtil.currPage+1})">下一页</button>
						</c:if>
						<button class="common_button" onclick="goPage(${pageUtil.totalPage})">尾页</button>
					</div>
				</div>
			</th>
		</tr>
	</table>
	</form>
</body>
</html>