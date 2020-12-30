<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
           prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <table width="600px" border="1px" cellpadding="0" cellspacing="0">
        <tr>
            <th>deptNo</th><th>dname</th><th>loc</th>
        </tr>
        <c:forEach items="${deptList}" var="dept">
         <tr>
            <td>${dept.deptNo}</td>
            <td>${dept.dname}</td><td>${dept.loc}</td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>