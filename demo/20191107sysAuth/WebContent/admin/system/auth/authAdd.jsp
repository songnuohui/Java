<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加模块</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../../css/main.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../js/common.js"></script>
	</head>
<body>
  <form action="auth?method=save" method="post">
	<div class="page_title">模块管理&nbsp; &gt; 添加模块</div>
	<div class="button_bar">
		<button class="common_button" onclick="back();">返回</button>
		<input type="submit" class="common_button" value="保存">
	</div>
	<table class="query_form_table">
		<tr>
			<th>模块名称</th>
			<td><input type="text" name="name"/><span class="red_star">*</span></td>
			<th>访问URL</th>
			<td><input type="text" name="url"/></td>
		</tr>
		<tr>
			<th>父模块</th>
			<td>
				<select name="parentId">
					<option value="0">请选择</option>
				    <c:forEach items="${authList}" var="auth">
				      <option value="${auth.id}">${auth.name}</option>
				    </c:forEach>
				</select>
			</td>
			
		</tr>
		
	</table>
	</form>
</body>
</html>