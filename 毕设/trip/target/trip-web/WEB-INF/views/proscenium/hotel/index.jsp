<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>Hotel | 酒店</title>
	<jsp:include page="../../../includes/header.jsp"/>
	<style>
		.content-wrapper{
			background-image: url("/static/assets/img/test/bgimg.png");
		}
	</style>
</head>

<body class="skin-blue layout-top-nav" style="height: auto; min-height: 100%;">

<div class="wrapper" style="height: auto; min-height: 100%;">

	<jsp:include page="../../../includes/top_navigation_reception.jsp"/>

	<!-- Full Width Column -->
	<div class="content-wrapper" style="min-height: 471px">
		<div class="container">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<br>
				<h1>
					酒店 | Hotel
					<small>最新发布</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/hotel/index"><i class="fa fa-dashboard"></i>酒店</a></li>
					<li><a href="#">SHOW</a></li>
					<div class="box-tools col-lg-2" style="padding-top: 20px;">
						<form action="/hotel/hotelPointSearch" method="get">
							<div class="input-group input-group-sm" style="width: 200px;">

								<input type="text" name="keyword" class="form-control pull-right" placeholder="酒店搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</ol>
			</section>
			<br><br><hr>
			<!-- ROOM -->
			<section class="content">

				<div class="row">
					<c:forEach items="${hotels}" var="hotel">
						<!-- ITEM -->
						<div class="col-sm-6 col-md-4 col-lg-4">
							<div class="thumbnail"  style="height: 340px;"><%--510px--%>
								<a href="/hotel/content?hid=${hotel.hid}">
										<%--<img src="${viewPoint.tpVpic}" alt="..." class="img-rounded">--%>
									<img style="height: 200px;width: 100%" src="${hotel.imgUrl}" alt="...">
								</a>
								<div class="caption">
									<h3>${hotel.title}</h3><hr>
									<ol>
										<li><p style="color: #ffa309;float: left">城市：${hotel.local}
											<p style="color: #0b93d5;float: right">价格：￥${hotel.price}/晚 <br><hr></li>
											<%--房屋类型：${hotel.houseType}<br><hr>床类型：${hotel.bedType}</p><hr> </li>
										<li><p style="color: #0b93d5">价格：￥${hotel.price}/晚 <br><hr>
											详细地址：${fn:substring(hotel.zip,0,14)}...</p></li>--%>
									</ol>
								</div>
								<div>
									<c:if test="${user!=null}">
										<strong><a href="/shop/hotelcart?hid=${hotel.hid}"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a></strong>
									</c:if>
									<c:if test="${user==null}">
										<strong><a href="/hotel/index"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a></strong>
									</c:if>
									<a class="btn" style="color: #0b97c4;float: right"
									   href="/hotel/content?hid=${hotel.hid}">查看详情 »</a>
								</div>
								<%--<div class="form-group" style="text-align: right;">
									<a class="btn" style="color: #0b97c4"
									   href="/hotel/content?hid=${hotel.hid}">查看详情 »</a>
								</div>--%>
							</div>
						</div>
						<!-- END / ITEM -->
					</c:forEach>
				</div>

				<ul class="pager"style="float: right">
					<li class="prev">
						<c:if test="${page>1}">
							<a href="/hotel/index?page=${page-1}">上一页</a>
						</c:if>
					</li>
					<li class="next">
						<c:if test="${page<total}">
							<a href="/hotel/index?page=${page+1}">下一页</a>
						</c:if>
					</li>
				</ul>
			</section>
			<!-- /.container -->

		</div>
		<!-- /.content-wrapper -->
	</div>
	<%--版权--%>
	<jsp:include page="../../../includes/copyright.jsp"/>
	<!-- ./wrapper -->
	<%--js--%>
	<jsp:include page="../../../includes/footer.jsp"/>
	<script>
	</script>

</body>
</html>