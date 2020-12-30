<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>模块管理</title>
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
    <form id="myform" action="auth?method=list"  method="post">
    <input type="hidden" name="page" id="page">
	<div class="page_title">模块管理</div>
	<div class="button_bar">
		<a class="common_button" href="auth?method=add">新建</a>
		<input type="submit" value="查询" class="common_button"/></button>
	</div>
	<table class="query_form_table">
		<tr>
			<th>模块名称</th>
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
			<th>模块名称</th>
			<th>访问URL</th>
			<th>父模块</th>
			<th>状态</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${authList}" var="auth">
		<tr>
			<td class="list_data_number">${auth.id}</td>
			<td class="list_data_text">${auth.name}</td>
			<td class="list_data_text">${auth.url}</td>
			<td class="list_data_text">${auth.parent.name}</td>
			<td class="list_data_text">${auth.status}</td>
			<td class="list_data_text">
				<a href="modelUpdate.html">编辑</a>
				<a href="#">注销</a>
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