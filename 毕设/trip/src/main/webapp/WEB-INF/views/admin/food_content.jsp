<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
    <title>美食管理|Food</title>
    <jsp:include page="../../includes/header.jsp"/>
</head>
<body class="hold-transition skin-blue sidebar-mini">

<div class="wrapper">
    <%--顶部导航--%>
    <jsp:include page="../../includes/top_navigate_backstage.jsp"/>
    <%--侧边菜单--%>
    <jsp:include page="../../includes/leftside_menu_navigate.jsp"/>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                <br>
                美食管理|
                <small>操作</small>
            </h1>

            <ol class="breadcrumb">
                <br>
                <li><a href="#"><i class="fa fa-users"></i> Operate </a></li>
                <li class="active">Food</li>
            </ol>
        </section>

        <br/><br/>
        <div class="col-xs-12">

            <%--Denger alert--%>
            <%--<c:if test="${msg.msg != null}">
                <div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                        &lt;%&ndash;${msg}&ndash;%&gt;
                    <h4>${msg.msg}</h4>
                </div>
            </c:if>--%>
            <%--/.alert--%>
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">美食内容</h3>
                </div>
                <div class="box-body table-responsive">
                    <table id="myuserstable" class="table table-bordered table-striped">
                        <thead>
                        <tr>
                            <th>参数</th>
                            <th>值</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <th>编号|Id</th>
                            <td>${food.tpFid}</td>
                        </tr>
                        <tr>
                            <td>标题|Title</td>
                            <td>${food.tpFtitle}</td>
                        </tr>
                        <tr>
                            <td>美食名称|Name</td>
                            <td>${food.tpFname}</td>
                        </tr>
                        <tr>
                            <th>地址|Address</th>
                            <td><span class="label label-primary">${food.tpAddress}</span></td>
                        </tr>
                        <tr>
                            <td>价格|Prices</td>
                            <td>${food.tpFprice}</td>
                        </tr>
                        <tr>
                            <td>联系电话|Phone</td>
                            <td>${food.tpPhone}</td>
                        </tr>
                            <td>缩略|Img</td>
                            <td><img style="height: 40px;width: 50px;" src="${food.tpFpic}" /></td>
                        </tr>
                        </tbody>
                    </table>
                    <br>
                    <div>
                        ${food.tpFcontent}
                    </div>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>

    </div>
    <!-- /.content-wrapper -->
    <%--版权--%>
    <jsp:include page="../../includes/copyright.jsp"/>

</div>
<%--css--%>
<jsp:include page="../../includes/footer.jsp"/>

<script>

</script>
</body>
</html>
