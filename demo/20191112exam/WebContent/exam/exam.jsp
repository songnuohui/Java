<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/tag.jsp"  %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>考试试卷-正在考试</title>
</head>
<link rel="stylesheet" href="CSS/exam_online.css">
<script type="text/javascript" src="js/exam_online.js"></script>
<body>
    <!-- 考试中的中间部分 -->
    <div class="examing">
        <p class="exam_position">当前位置：考试 &gt; ${rule.name }</p>
        <div class="exam_title">
            <span class="exam_title1">${rule.name }</span>
            <span class="exam_title2">（剩余考试时间：</span>
            <span id="exam_time" class="minutes">${rule.examTime}</span>
            <span class="exam_title2">分钟）</span>
        </div>
		<form id="exam_paper" action="#" method="post">
	        <ul class="exam_problems">
	          <c:forEach items="${details}" var="d">
	            <li>
	                <span class="es1">
	                   <c:choose>
	                       <c:when test="${d.typeId==1}">单选题</c:when>
	                       <c:when test="${d.typeId==2}">多选题</c:when>
	                       <c:when test="${d.typeId==3}">填空题</c:when>
	                       <c:when test="${d.typeId==4}">判断题</c:when>
	                       <c:otherwise>简答题</c:otherwise>
	                   </c:choose>
	                </span>
	                <span class="es2">（每题${d.score}分，共${d.num}题）</span>
	                <ul>
	                    <c:if test="${d.typeId==1}">
	                    <c:forEach items="${questionList1}" var="q" varStatus="i">
	                    <li>
	                        <span class="radio_1">
	                            ${i.count}、${q.title}？
	                            <!--(<input type="text">)-->
	                        </span>
	                        <ol type="A">
	                           <c:forEach items="${q.options}" var="o" varStatus="i">
	                             <li>
	                             <label>${o.content}</label>
	                             <input type="radio" name="${q.id}" value="${i.count}" />
	                            </li>
	                            </c:forEach>
	                        </ol>
	                    </li>
	                   </c:forEach>
	                   </c:if>
	                   <c:if test="${d.typeId==2}">
	                    <c:forEach items="${questionList2}" var="q" varStatus="i">
	                    <li>
	                        <span class="radio_1">
	                            ${i.count}、${q.title}？
	                            <!--(<input type="text">)-->
	                        </span>
	                        <ol type="A">
	                            <c:forEach items="${q.options}" var="o" varStatus="i">
	                             <li>
	                            	<input type="checkbox" name="${q.id}" value="${i.count}" />
	                            	<label>${o.content}</label>
	                            </li>
	                            </c:forEach>
	                        </ol>
	                    </li>
	                   </c:forEach>
	                   </c:if>
	                   <c:if test="${d.typeId==3}">
	                    <c:forEach items="${questionList3}" var="q" varStatus="i">
	                    <li>
	                        <span class="radio_1">
	                            ${i.count }、${q.title}？
	                            <!--(<input type="text">)-->
	                        </span>
	                        <ul id="ss1" class="radio_1_ul">
	                           <textarea name="${q.id}"></textarea>  
	                        </ul>
	                    </li>
	                   </c:forEach>
	                   </c:if>
	                   <c:if test="${d.typeId==4}">
	                    <c:forEach items="${questionList4}" var="q" varStatus="i">
	                    <li>
	                        <span class="radio_1">
	                            ${i.count }、${q.title}？
	                            <!--(<input type="text">)-->
	                        </span>
	                        <ul id="ss1" class="radio_1_ul">
	                                                       正确 <input type="radio" name="${q.id}" value="T"/> 
	                                                       错误 <input type="radio" name="${q.id}" value="F"/> 
	                        </ul>
	                        
	                    </li>
	                   </c:forEach>
	                   </c:if>
	                   <c:if test="${d.typeId==5}">
	                    <c:forEach items="${questionList5}" var="q" varStatus="i">
	                    <li>
	                        <span class="radio_1">
	                            ${i.count}、${q.title}？
	                            <!--(<input type="text">)-->
	                        </span>
	                        <ul id="ss1" class="radio_1_ul">
	                             <textarea name="${q.id}"></textarea>
	                        </ul>
	                    </li>
	                   </c:forEach>
	                   </c:if>
	                </ul>
	            </li>
	           </c:forEach>
	        </ul>
	
	        <div class="exam_button">
	        	<!--提交到服务器需更改form的action值以及启用以下代码-->
	        	<!--
	        		<input type="submit" class="exam_button1" value="提交试卷" />
	        	-->
	        	<a class="exam_button1" href="exam_paper_confirm.html" ><span>提交试卷</span></a>
	        	<input type="button" class="exam_button2" onclick="location.href='../index/menu2.html'" value="关闭试卷" />
	         
	        </div>
	    </form>
    </div>
</body>
</html>