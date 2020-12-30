<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
            prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
    function goPage(page){
    	document.getElementById("page").value=page;
    	document.getElementById("searchForm").submit();
    }
</script>
</head>
<body>
  <form id="searchForm" action="empList" method="post">
      <input type="hidden"  id="page" name="page" value="">
    <table width="800px" height="40px" cellpadding="0" cellspacing="0"
               border="1px" align="center">
       <tr>
          <td>
            雇员名:<input type="text" name="ename" value="${filter['ename']}">
         工种： <select name="job">
                <option value="">全部</option>  
                <option value="SALESMAN" <c:if test="${filter['job']=='SALESMAN'}">selected="selected"</c:if>>SALESMAN</option>
                <option value="MANAGER" <c:if test="${filter['job']=='MANAGER'}">selected="selected"</c:if>>MANAGER</option>
                <option value="ANALYST" <c:if test="${filter['job']=='ANALYST'}">selected="selected"</c:if>>ANALYST</option>
                <option value="CLERK" <c:if test="${filter['job']=='CLERK'}">selected="selected"</c:if>>CLERK</option>
                <option value="PRESIDENT" <c:if test="${filter['job']=='PRESIDENT'}">selected="selected"</c:if>>PRESIDENT</option>
           </select>  
           部门： <select name="deptNo">
                <option value="">全部</option>
                <option value="10" <c:if test="${filter['deptNo']==10}">selected="selected"</c:if>>ACCOUNTING</option>
                <option value="20" <c:if test="${filter['deptNo']==20}">selected="selected"</c:if>>RESEARCH</option>
                <option value="30" <c:if test="${filter['deptNo']==30}">selected="selected"</c:if>>SALES</option>
           </select>   
           <input type="submit" value="查询">      
          </td>
       </tr>        
      </table>
      </form>
      <table width="800px" cellpadding="0" cellspacing="0"
               border="1px" align="center">
          <tr>
             <th>empNo</th><th>ename</th><th>job</th><th>mgr</th>
             <th>hireDate</th><th>sal</th><th>comm</th><th>deptNo</th>
          </tr>
          <c:forEach items="${emps}" var="e">
            <tr>
             <td>${e.empNo}</td><td>${e.ename}</td>
             <td>${e.job}</td><td>${e.mgr}</td>
             <td>${e.hireDate}</td><td>${e.sal}</td>
             <td>${e.comm}</td><td>${e.deptNo}</td>
          </tr>
          </c:forEach>
           <tr> 
               <td colspan="8">
                                    共 ${pageUtil.totalSize } 条记录，
                                    每页显示${pageUtil.pageSize }条 ，
                                    当前第${pageUtil.currPage }页，共 ${pageUtil.totalPage }页
                 <a href="javaScript:void(0)" onclick="goPage(1)">首页 </a>
                 <c:if test="${pageUtil.currPage>1}">
                 <a href="javaScript:void(0)" onclick="goPage(${pageUtil.currPage-1})">上一页 </a>  
                 </c:if>
                 <c:if test="${pageUtil.currPage<pageUtil.totalPage}">
                 <a href="javaScript:void(0)" onclick="goPage(${pageUtil.currPage+1})">下一页 </a>    
                 </c:if>
                 <a href="javaScript:void(0)" onclick="goPage(${pageUtil.totalPage })">尾页  </a>               
               
               </td>
           </tr>
      </table>
</body>
</html>