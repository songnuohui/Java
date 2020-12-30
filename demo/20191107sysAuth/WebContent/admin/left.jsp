<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>左边菜单</title>
<link href="css/style-1.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson li").click(function(){
		$(".menuson li.active").removeClass("active")
		$(this).addClass("active");
	});
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('ul').slideUp();
		if($ul.is(':visible')){
			$(this).next('ul').slideUp();
		}else{
			$(this).next('ul').slideDown();
		}
	});
})	
</script>


</head>

<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>在线学习管理系统</div>
    <dl class="leftmenu"> 
      <c:forEach items="${authParent}" var="p">
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /></span>${p.name}
			</div>
			<ul class="menuson">
			   <c:forEach items="${authList}" var="s">
			     <c:if test="${s.parent.id==p.id}">
				<li><cite></cite><a href="${s.url }" target="rightFrame">${s.name}</a></li>
				</c:if>
				</c:forEach>
			</ul>    
		</dd>
		</c:forEach>
    </dl>
</body>
</html>
