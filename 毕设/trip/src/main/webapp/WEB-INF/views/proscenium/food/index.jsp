<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
    <title>Food | 美食</title>
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
                    美食 | Food
                    <small>最新发布</small>
                </h1>
                <ol class="breadcrumb">
                    <br>
                    <li><a href="/food/index"><i class="fa fa-dashboard"></i>美食信息</a></li>
                    <li><a href="#">SHOW</a></li>
                    <div class="box-tools"style="padding-top: 10px;">
                        <form action="/food/foodPointSearch" method="get">
                            <div class="input-group input-group-sm" style="width: 150px;">
                                <input type="text" name="keyword" class="form-control pull-right" placeholder="美食搜索...">

                                <div class="input-group-btn">
                                    <button type="submit" class="btn btn-default"><i class="fa fa-search"></i></button>
                                </div>
                            </div>
                        </form>
                    </div>
                </ol>
            </section>
            <br><br><hr>
            <section class="content">
                <div class="row">
                    <c:forEach items="${foods}" var="foods">
                        <%--自定义内容--%>
                        <div class="col-sm-6 col-md-4 col-lg-3 viewpages">
                            <div class="thumbnail" style="height: 360px;"><%--460px--%>
                                <a href="/food/content?tpFid=${foods.tpFid}">
                                    <img style="height: 180px;width: 100%" src="${foods.tpFpic}" alt="..." class="img-rounded">
                                </a>
                                <%--<div style="height: 220px;"class="caption">--%>
                                    <div class="container-fluid">
                                        <div class="row">
                                            <div class="col-md-12"><hr>
                                                <h3>${fn:substring(foods.tpFtitle,0,30)}</h3><hr>
                                                <h5>
                                                    <strong>美食名称:[${foods.tpFname}]</strong><hr>
                                                </h5>
                                                <strong>美食价格: ${foods.tpFprice}元/份</strong><hr>
                                               <%-- <strong>详细地址:${fn:substring(foods.tpAddress,0,7)}...</strong><hr>
                                                <strong>电话: ${foods.tpPhone}</strong><hr>--%>
                                                <div>
                                                    <c:if test="${user!=null}">
                                                        <strong style="float:left;"><a href="/shop/foodcart?tpFid=${foods.tpFid}"><i class="fa fa-fw fa-cart-plus"style="color: red"></i>加入购物车</a></strong>
                                                    </c:if>
                                                    <c:if test="${user==null}">
                                                        <strong style="float: left;"><a href="/food/index"><i class="fa fa-fw fa-cart-plus"style="color: red"></i>加入购物车</a></strong>
                                                    </c:if>
                                                    <a class="btn" style="color: #0b97c4;float:right"
                                                       href="/food/content?tpFid=${foods.tpFid}">查看详情 »</a>
                                                </div>
                                              <%--  <div class="form-group" style="text-align: right;">
                                                    <a class="btn" style="color: #0b97c4"
                                                       href="/food/content?tpFid=${foods.tpFid}">查看详情 »</a>
                                                </div>--%>
                                            </div>
                                        </div>
                                    </div>
                                <%--</div>--%>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </section>
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