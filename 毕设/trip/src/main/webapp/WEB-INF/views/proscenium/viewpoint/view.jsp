<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
	<title>View | 景点</title>
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
	<div class="content-wrapper" style="min-height: 471px;/*background-color:bisque*/">
		<div class="container">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<br>
				<h1>
					旅游景点 | View
					<small>最新发布</small>
				</h1>
				<ol class="breadcrumb">
					<br>
					<li><a href="/view/point"><i class="fa fa-dashboard"></i>旅游景点</a></li>
					<li><a href="#">SHOW</a></li>
					<div class="box-tools"style="padding-top: 10px">
						<form action="/view/viewPointSearch" method="get">
							<div class="input-group input-group-sm" style="width: 200px;">
								<input type="text" name="keyword" class="form-control pull-right" placeholder="景点搜索...">

								<div class="input-group-btn">
									<button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
								</div>
							</div>
						</form>
					</div>
				</ol>
			</section>
			<br><br><hr>
			<section class="content" >
				<div class="row">
					<c:forEach items="${viewPoints}" var="viewPoint">
						<%--自定义内容--%>
						<div class="col-sm-6 col-md-4 col-lg-3 viewpages">
							<div class="thumbnail" style="height: 345px;"><%--442px--%>
								<a href="/view/content?tpVid=${viewPoint.tpVid}">
									<img style="height: 180px;width: 100%" src="${viewPoint.tpVpic}" alt="..." class="img-rounded">
								</a>
								<div style="height: 220px;" class="caption">
									<div class="container-fluid">
										<div class="row">
											<div class="col-md-14">
												<h3 style="color: #0b97c4"><strong>${fn:substring(viewPoint.tpTitle,0,30)}<strong/></h3><hr>
												<h5 style="color: #ffa309">
													[${viewPoint.tpVname}]|<small>${viewPoint.tpLocation}</small>
														<br/>
												</h5><hr>
												<h4 style="color: #0b93d5">景点价格: ${viewPoint.tpPrice}元/人</h4><hr>
												<%--<h4 style="color: #ffa309">开放时间: ${viewPoint.tpOpentime}</h4><hr>
												<h4 style="color: #0b93d5">景点价格: ${viewPoint.tpPrice}元/人</h4><hr>
												<h4 style="color: #0b93d5">详细地址:${fn:substring(viewPoint.tpZip,0,7)}...<strong/><br><hr>--%>
												<div>
													<c:if test="${user!=null}">
														<a href="/shop/viewcart?tpVid=${viewPoint.tpVid}">
															<i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a>
													</c:if>
													<c:if test="${user==null}">
														<a href="/view/point"><i class="fa fa-fw fa-cart-plus"style="color: red"></i> 加入购物车</a>
													</c:if>
													<a class="btn" style="color: #0b93d5;float: right"
													   href="/view/content?tpVid=${viewPoint.tpVid}">查看详情 »</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					<!-- 分页 -->

			</section>
			<ul class="pager"style="float: right">
				<li class="prev">
				<c:if test="${page>1}">
					<a href="/view/point?page=${page-1}">上一页</a>
				</c:if>
				</li>
				<li class="next">
				<c:if test="${page<total}">
					<a href="/view/point?page=${page+1}">下一页</a>
				</c:if>
				</li>
			</ul>
		</div>
			<br>

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