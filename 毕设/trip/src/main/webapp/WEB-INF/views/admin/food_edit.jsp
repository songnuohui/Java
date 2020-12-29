<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--代表HTML5--%>
<!DOCTYPE html>
<html>
<head>
    <title>美食管理|</title>
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
                <li class="active">Hotel</li>
            </ol>
        </section>

        <br/><br/>
        <div class="col-xs-12">
            <%--danger alert--%>
            <c:if test="${msg.msg != null}">
                <div class="alert alert-${msg.status == 200 ? "success" : "danger"} alert-dismissible">
                    <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                    <h4>${msg.msg}</h4>
                </div>
            </c:if>
            <%--danger alert--%>
            <div class="box">
                <%--用户表单--%>
                <div class="box box-info">
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">美食更新</h3>
                        </div>
                        <!-- /.box-header -->
                        <!-- form start -->
                        <form class="form-horizontal" action="/admin/foodupdate" method="post">
                            <div class="box-body">

                                <%--图片上传组件--%>
                                <div class="form-group">
                                    <label for="tpFpic" class="col-sm-2 control-label">略图上传</label>

                                    <div class="col-sm-10">
                                        <input type="text" readonly name="tpFpic" value="${food.tpFpic}"
                                               class="form-control" id="tpFpic" placeholder="${food.tpFpic}">
                                        <div id="dropz" class="dropzone"></div>
                                    </div>
                                </div>

                                <%--uid--%>
                                <div class="form-group">
                                    <label for="tpFid" class="col-sm-2 control-label">编号</label>
                                    <div class="col-sm-10">
                                        <input type="text" readonly name="tpFid" value="${food.tpFid}"
                                               class="form-control" id="tpFid" placeholder="${food.tpFid}">
                                    </div>
                                </div>

                                <%--title--%>
                                <div class="form-group">
                                    <label for="tpFtitle" class="col-sm-2 control-label">标题</label>
                                    <div class="col-sm-10">
                                        <input type="text" name="tpFtitle" value="${food.tpFtitle}"
                                               class="form-control" id="tpFtitle" placeholder="${food.tpFtitle}">
                                    </div>
                                </div>

                                <%--name--%>
                                <div class="form-group">
                                    <label for="tpFname" class="col-sm-2 control-label">美食名称</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="tpFname" value="${food.tpFname}" class="form-control" id="tpFname"
                                               placeholder="${food.tpFname}">
                                    </div>
                                </div>

                                <%--address--%>
                                <div class="form-group">
                                    <label for="tpAddress" class="col-sm-2 control-label">地址</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="tpAddress" value="${food.tpAddress}" class="form-control" id="tpAddress"
                                               placeholder="${food.tpAddress}">

                                    </div>
                                </div>

                                <%--price--%>
                                <div class="form-group">
                                    <label for="tpFprice" class="col-sm-2 control-label">价格</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="tpFprice" value="${food.tpFprice}" class="form-control" id="tpFprice"
                                               placeholder="${food.tpFprice}">
                                    </div>
                                </div>

                                <%--phone--%>
                                <div class="form-group">
                                    <label for="tpPhone" class="col-sm-2 control-label">联系电话</label>

                                    <div class="col-sm-10">
                                        <input type="text" name="tpPhone" value="${food.tpPhone}" class="form-control" id="tpPhone"
                                               placeholder="${food.tpPhone}">
                                    </div>
                                </div>
                                <%--Content Edit--%>
                                <div class="form-group">
                                    <label for="tpFcontent" class="col-sm-2 control-label">内容编辑</label>

                                    <div class="col-sm-10">

                                        <input type="text" name="tpFcontent" id="tpFcontent" class="form-control"
                                               placeholder="编辑">

                                        <%--wangEditor编辑--%>
                                        <div id="editor">
                                            ${food.tpFcontent}
                                        </div>

                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->

                            <div class="box-footer">
                                <button type="button" class="btn btn-default" onclick="history.go(-1);">返回</button>
                                <button id="btnSunmit" type="submit" class="btn btn-info pull-right" onclick="">提交
                                </button>
                            </div>
                            <!-- /.box-footer -->
                        </form>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
        </div>
        <!-- /.content-wrapper -->
    </div>
    <%--版权--%>
    <jsp:include page="../../includes/copyright.jsp"/>

    <%--css--%>
    <jsp:include page="../../includes/footer.jsp"/>
    <!-- page script -->

    <script>
        $(function () {
            // wangEditor
            var E = window.wangEditor;
            var editor = new E('#editor');

            // 配置服务器端地址
            editor.customConfig.uploadImgServer = '/upload/foodContentUpload';

            // 将图片大小限制为 3M 默认为5MB
            editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
            // 限制一次最多上传 20 张图片
            editor.customConfig.uploadImgMaxLength = 20;
            // 自定义 fileName
            editor.customConfig.uploadFileName = 'dropFile';
            editor.create();

            editor.customConfig.uploadImgHooks = {
                before: function (xhr, editor, files) {

                }
            };

            // 按钮绑定事件
            $("#btnSunmit").bind("click", function () {
                var contentHtml = editor.txt.html();
                console.log(contentHtml);//有内容的
                $("#tpFcontent").val(contentHtml);
                // return false;
            });
        });

        Dropzone.options.dropz = {
            url: "/upload/foodAvatar",
            method: "post",
            autoQueue: true,
            dictDefaultMessage: '拖动文件至此或者点击上传', // 设置默认的提示语句
            paramName: "dropFile",// 传到后台的参数名称
            init: function () {
                this.on("success", function (file, data) {
                    $("#tpFpic").val(data.fileName);
                    // 上传成功触发的事件
                });
            }
        };
    </script>
</body>
</html>
