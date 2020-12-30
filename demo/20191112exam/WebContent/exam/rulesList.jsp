<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp" %>    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>考试</title>
</head>
<link rel="stylesheet" href="CSS/exam_index.css">
<link rel="stylesheet" href="layui/css/layui.css">
<script type="text/javascript" src="js/exam_index.js"></script>
<body>
    <!-- 中部内容 -->
    <div id="middle">
        <div class="sercherBox">
            <input type="text" value="请输入试卷名称" id="values" onfocus="disappear();" onblur="visiabled();">
            <a href="#"><img src="img/glass.png"></a>
        </div>

        <div class="title_choice" id="examChange">
            <ul>
                <li onclick="bkChange(0)" style="background-color: #65a2fd;"><a href="#">全部</a></li>
                <li onclick="bkChange(1)"><a href="#">框架</a></li>
                <li onclick="bkChange(2)"><a href="#">Oracle</a></li>
                <li onclick="bkChange(3)"><a href="#">Java</a></li>
                <li onclick="bkChange(4)"><a href="#">HTML</a></li>
                <li onclick="bkChange(5)"><a href="#">CSS</a></li>
                <li onclick="bkChange(6)"><a href="#">JS</a></li>
                <li onclick="bkChange(7)"><a href="#">综合</a></li>
                <li onclick="bkChange(8)"><a href="#">框架</a></li>
                <li onclick="bkChange(9)"><a href="#">Oracle</a></li>
                <li onclick="bkChange(10)"><a href="#">CSS</a></li>
                <li onclick="bkChange(11)"><a href="#">JS</a></li>
                <li onclick="bkChange(12)"><a href="#">综合</a></li>
            </ul>
        </div>

        <div class="exam">
            <table class="layui-table">
                <tr class="exam_tr1" style="background-color: #f2f2f2;">
                    <td>序号</td>
                    <td>科目</td>
                    <td>试卷名称</td>
                    <td class="exam_operation">操作</td>
                </tr>
                <c:forEach items="${rules}"  var="r">
                <tr class="exam_tr2">
                    <td>${r.id}</td>
                    <td>${r.subjectName}</td>
                    <td>${r.name}</td>
                    <td class="exam_operation"
                    ><a href="examRule?method=join&ruleId=${r.id}" class="exam_color">考试</a></td>
                </tr>
                </c:forEach>
            </table>
            <div class="page_choice">
                <font>当前第1页, 共2页</font> 
                <a href="#">首页</a>
                <a href="#">尾页</a>
                <a href="#">上一页</a>
                <a href="#">下一页</a>
            </div>
        </div>
    </div>
</body>
</html>