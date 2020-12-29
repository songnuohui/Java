<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>红色摇篮 | 旅游网站</title>
	<jsp:include page="../includes/header.jsp"/>
	<style>
		.content-wrapper{
			background-image: url("/static/assets/img/test/bgimg.png");
		}
	</style>
</head>

<body class="skin-blue layout-top-nav" style="height: auto; min-height: 100%;">

<div class="wrapper" style="height: auto; min-height: 100%;">

	<jsp:include page="../includes/top_navigation_reception.jsp"/>

	<!-- Full Width Column -->
	<div class="content-wrapper" style="min-height: 471px;/*background-color:bisque*/">
		<div class="container">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<br>
				<h1>
					首页 | Show
					<small>轮播展示</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/index"><i class="fa fa-dashboard"></i> 首页</a></li>
					<li><a href="#">SHOW</a></li>
				</ol>

			</section>
			<hr>

			<%--内容开始--%>
			<!-- Main content -->
			<section class="content">
				<div id="myCarousel" class="carousel slide ">
					<!-- 轮播（Carousel）指标 -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0"
						    class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>
					<!-- 轮播（Carousel）项目 -->
					<div class="carousel-inner">
						<div class="item active">
							<img style="width: 1920px;height: 450px" src="/static/assets/img/test/jinggangshan.jpg" alt="First slide">
							<div class="carousel-caption"><h1>来一场说走就走的旅行</h1>井冈山红色革命根据地
							</div>
						</div>
						<div class="item">
							<img style="width: 1920px;height: 450px"src="/static/assets/img/test/bayiguanchang.jpg" alt="Second slide">
							<div class="carousel-caption"><h1>来一场说走就走的旅行</h1>南昌八一广场
							</div>
						</div>
						<div class="item">
							<img style="width: 1920px;height: 450px"src="/static/assets/img/test/ruijin.jpg" alt="Third slide">
							<div class="carousel-caption"><h1>来一场说走就走的旅行</h1>瑞金中华苏维埃临时中央政府旧址
							</div>
						</div>
					</div>
					<!-- 轮播（Carousel）导航 -->
					<a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</section>
			<!-- /.content -->
			<br>
			<section class="content-header">
				<h1 style="color: black">
					景点 | VIEW
					<small><a href="/view/point/"class="btn" style="color: #0b93d5">查看更多 »</a> </small>
				</h1>
				<hr>
				<br>
				<%--自定义内容--%>
				<div class="row">
					<c:forEach items="${viewPoints}" var="viewPoint">
						<%--自定义内容--%>
						<div class="col-sm-6 col-md-4 col-lg-3 viewpages">
							<div class="thumbnail" style="height: 442px;">
								<a href="/view/content?tpVid=${viewPoint.tpVid}">
									<img style="height: 180px;" src="${viewPoint.tpVpic}" alt="..." class="img-rounded">
								</a>
								<div style="height: 220px;" class="caption">
									<div class="container-fluid">
										<div class="row">
											<div class="col-md-14">
												<h3 style="color: #0b97c4">${fn:substring(viewPoint.tpTitle,0,30)}</h3><hr>
												<h5>
													<strong>[${viewPoint.tpVname}<strong/>]|<small>${viewPoint.tpLocation}</small>
													<br/><hr>
												</h5>
												<strong >等级: ${viewPoint.tpLevel}</strong><br><hr>
												<strong>景点价格: ${viewPoint.tpPrice}元/人</strong><br><hr>
												<strong>详细地址:${fn:substring(viewPoint.tpZip,0,7)}...<strong/><br><hr>
												<div class="form-group" style="text-align: right;">
													<c:if test="${sessionScope.user!=null}">
														<a style="float: left" href="/shop/viewcart?tpVid=${viewPoint.tpVid}"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a>
													</c:if>
													<c:if test="${sessionScope.user==null}">
														<a style="float: left" href="/index"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a>
													</c:if>
													<a class="btn" style="color: #0b93d5"
													   href="/view/content?tpVid=${viewPoint.tpVid}">查看详情 »</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</section>
			<%--酒店--%>
			<section class="content-header">
				<h1 style="color: black">
					酒店 | Hotel
					<small><a href="/hotel/index"class="btn" style="color: #0b93d5">查看更多 »</a> </small>
				</h1>
				<hr>
				<br>
				<%--自定义内容--%>
				<div class="row">
					<c:forEach items="${hotels}" var="hotel">
						<!-- ITEM -->
						<%--<div class="col-lg-1"></div>--%>
						<div class="col-sm-6 col-md-4 col-lg-4">
							<div class="thumbnail"  style="height: 495px;">
								<a href="/hotel/content?hid=${hotel.hid}">
										<%--<img src="${viewPoint.tpVpic}" alt="..." class="img-rounded">--%>
									<img style="height: 200px;" src="${hotel.imgUrl}" alt="...">
								</a>
								<div class="caption">
									<h3 style="color: #0b97c4">${hotel.title}</h3><hr>
									<ol>
										<li><p>城市：${hotel.local}<br><hr>
											房屋类型：${hotel.houseType}<br><hr>
											床类型：${hotel.bedType}</p> </li><hr>
										<li><p>价格：${hotel.price}元/晚 <br><hr>
											详细地址：${fn:substring(hotel.zip,0,14)}...</p></li>
									</ol>
								</div>
								<div class="form-group" style="text-align: right;">

										<c:if test="${sessionScope.user!=null}">
											<strong style="float: left"><a href="/shop/hotelcart?hid=${hotel.hid}"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a></strong>
										</c:if>
										<c:if test="${sessionScope.user==null}">
											<strong style="float: left"><a href="/index"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a></strong>
										</c:if>

									<a class="btn" style="color: #0b97c4"
									   href="/hotel/content?hid=${hotel.hid}">查看详情 »</a>
								</div>
							</div>
						</div>
						<!-- END / ITEM -->

					</c:forEach>

				</div>
			</section>


			<section class="content-header">
				<h1 style="color: black">
					美食 | FOOD
					<small><a href="/food/index"class="btn" style="color: #0b93d5">查看更多 »</a> </small>

				</h1>
				<hr>
				<br>
				<%--自定义内容--%>
				<div class="row">
					<c:forEach items="${foods}" var="foods">
						<%--自定义内容--%>
						<div class="col-sm-6 col-md-4 col-lg-3 viewpages">
							<div class="thumbnail" style="height: 460px;">
								<a href="/food/content?tpFid=${foods.tpFid}">
									<img style="height: 200px;" src="${foods.tpFpic}" alt="..." class="img-rounded">
								</a>
								<div style="height: 220px;" class="caption">
									<div class="container-fluid">
										<div class="row">
											<div class="col-md-14">
												<h3 style="color: #0b97c4">${fn:substring(foods.tpFtitle,0,30)}</h3><hr>
												<h5>
													<strong>美食名称:[${foods.tpFname}]</strong><hr>
												</h5>
												<strong>美食价格: ${foods.tpFprice}元/份</strong><hr>
												<strong>详细地址:${fn:substring(foods.tpAddress,0,7)}...</strong><hr>
												<strong>电话: ${foods.tpPhone}</strong><hr>
												<div class="form-group" style="text-align: right;">
													<c:if test="${sessionScope.user!=null}">
														<strong style="float: left"><a href="/shop/foodcart?tpFid=${foods.tpFid}"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a></strong>
													</c:if>
													<c:if test="${sessionScope.user==null}">
														<strong style="float: left"><a href="/index"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a></strong>
													</c:if>
													<a class="btn" style="color: #0b93d5"
													   href="/food/content?tpFid=${foods.tpFid}">查看详情 »</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
				<div style=" height:80px;"></div>
			</section>
		</div>
		<!-- /.container -->
	</div>
	<!-- /.content-wrapper -->
	<%--版权--%>
	<jsp:include page="../includes/copyright.jsp"/>
</div>
<!-- ./wrapper -->
<%--js--%>
<jsp:include page="../includes/footer.jsp"/>

</body>
</html>