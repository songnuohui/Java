<%@ page import="com.song.trip.web.entity.FoodShopCart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<%--Header Begin--%>
<head>
    <title>BUDGET | 预算</title>
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
                    我的购物车 | SHOP CART
                </h1>
                <hr>
                <form action="/shop/bijiao" method="post">
                <div style="width: 150px; float: left">
                    <input type="text" class="form-control" placeholder="输入你的预算金额" name="yusuan"/>
                </div>
                <div style="float: left;padding-left: 10px">
                    <button id="btnSunmit" type="submit" class="btn btn-info pull-right" onclick="">确定</button>
                </div><br>
                    <strong style="padding-left:20px;color: red">
                        您的预算金额是：${sessionScope.yusuan}元
                    </strong>
                </form>
            </section>
            <br>
            <section class="content">
                <c:if test="${sessionScope.yusuan<(sessionScope.shopCart.totlePrice+sessionScope.hotelShopCart.totlePrice+sessionScope.foodShopCart.totlePrice)}">
                    <div class="alert alert-danger alert-dismissible" style="width: 250px">
                        <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                        <h4>您已经超出预算,请注意！</h4>
                    </div>
                </c:if>
                <strong style="color: #ffa309">
                    景点费用预算
                </strong>
                <strong><a href="/shop/deleteviewcart"style="color: red">(清空)</a> </strong>
                <div class="box-body table-responsive">
                <table id="myuserstable" class="table table-bordered table-striped">
                    <thead>
                    <tr>
                        <th style="width: 20%;height: 50px">景点名称 | NAME</th>
                        <th style="width: 20%;height: 50px">地址 | ADDRESS</th>
                        <th style="width: 20%;height: 50px">景点票价 | PRICE</th>
                        <th style="width: 20%;height: 50px">购买票数 | COUNT</th>
                        <th style="width: 20%;height: 50px">合计 | SUM</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.shopCart.map}" var="shopCart">
                    <tr>
                        <td><a  style="color: #0b93d5" href="/view/content?tpVid=${shopCart.value.viewPoint.tpVid}">${shopCart.value.viewPoint.tpVname}</a> </td>
                        <td>${shopCart.value.viewPoint.tpLocation}</td>
                        <td>${shopCart.value.viewPoint.tpPrice} 元/张</td>
                        <td>${shopCart.value.viewCount} 张</td>
                        <td>${shopCart.value.sumPrice} 元</td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td align="center" colspan="4" style="color: red"><strong>合计</strong></td>
                        <td>${sessionScope.shopCart.totlePrice} 元</td>
                    </tr>
                    </tbody>
                </table>
                </div>
                    <strong style="color: #ffa309">
                        酒店费用预算
                    </strong><strong><a href="/shop/deletehotelcart"style="color: red">(清空)</a> </strong>
                    <div class="box-body table-responsive">
                        <table id="myuserstable" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th style="width: 20%;height: 50px">酒店名称 | NAME</th>
                                <th style="width: 20%;height: 50px">地址 | ADDRESS</th>
                                <th style="width: 20%;height: 50px">酒店房间价 | PRICE</th>
                                <th style="width: 20%;height: 50px">订购房间数 | COUNT</th>
                                <th style="width: 20%;height: 50px">合计 | SUM</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.hotelShopCart.map}" var="hotelShopCart">
                                <tr>
                                    <td><a style="color: #0b93d5" href="/hotel/content?hid=${hotelShopCart.value.hotel.hid}">${hotelShopCart.value.hotel.title}</a> </td>
                                    <td>${hotelShopCart.value.hotel.local}</td>
                                    <td>${hotelShopCart.value.hotel.price} 元/晚</td>
                                    <td>${hotelShopCart.value.htelCount} 个房间</td>
                                    <td>${hotelShopCart.value.sumPrice} 元</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td align="center" colspan="4" style="color: red"><strong>合计</strong></td>
                                <td>${sessionScope.hotelShopCart.totlePrice} 元</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <strong style="color: #ffa309">
                        美食费用预算
                    </strong><strong><a href="/shop/deletefoodcart"style="color: red">(清空)</a> </strong>
                    <div class="box-body table-responsive">
                        <table id="myuserstable" class="table table-bordered table-striped">
                            <thead>
                            <tr>
                                <th style="width: 20%;height: 50px">美食名称名称 | NAME</th>
                                <th style="width: 20%;height: 50px">地址 | ADDRESS</th>
                                <th style="width: 20%;height: 50px">美食价格 | PRICE</th>
                                <th style="width: 20%;height: 50px">购买数量 | COUNT</th>
                                <th style="width: 20%;height: 50px">合计 | SUM</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${sessionScope.foodShopCart.map}" var="foodShopCart">
                                <tr>
                                    <td><a style="color: #0b93d5" href="/food/content?tpFid=${foodShopCart.value.food.tpFid}">${foodShopCart.value.food.tpFname}</a> </td>
                                    <td>${foodShopCart.value.food.tpAddress}</td>
                                    <td>${foodShopCart.value.food.tpFprice} 元/份</td>
                                    <td>${foodShopCart.value.foodCount} 份</td>
                                    <td>${foodShopCart.value.sumPrice} 元</td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td align="center" colspan="4" style="color: red;height: 50px"><strong>合计</strong></td>
                                <td>${sessionScope.foodShopCart.totlePrice} 元</td>
                            </tr>
                            <tr >
                                <td colspan="5" style="height: 20px"></td>
                            </tr>
                            <tr >
                                <td align="right" colspan="4" style="height: 20px;"><h1><strong style="color: red">
                                    总计 :
                                </strong></h1>
                                </td>
                                <td align="left" style="height: 20px;">
                                    <h1>
                                        <strong style="color: red" id="total">

                                        </strong>
                                    </h1>
                                </td>
                            </tr>
                            </tbody>
                        </table>
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
        $(document).ready(function () {
            totle();
        });
        function totle() {
var views="${sessionScope.shopCart.totlePrice}";
var hotles="${sessionScope.hotelShopCart.totlePrice}";
var foods="${sessionScope.foodShopCart.totlePrice}";
var totles=parseFloat(views)+parseFloat(hotles)+parseFloat(foods);

$("#total").text(totles+"元");
        }
    </script>

</body>
</html>