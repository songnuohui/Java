<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加角色</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../../css/main.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="../../js/common.js"></script>
	</head>
<body>
   <form action="role?method=save" method="post">
	<div class="page_title">角色管理&nbsp; &gt; 添加角色</div>
	<div class="button_bar">
		<button class="common_button" onclick="back();">返回</button>
		<input type="submit" value="保存" class="common_button">
	</div>
	<table class="query_form_table">
		<tr>
			<th>角色名称</th>
			<td><input type="text" name="name"/><span class="red_star">*</span></td>
			
		</tr>
	</table>
	</form>
</body>
</html>