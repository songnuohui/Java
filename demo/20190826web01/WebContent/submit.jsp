<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="request.jsp" method="post">
        <p>姓名：<input type="text" name="name"/></p>
        <p>爱好：
           <input type="checkbox" name="fav" value="篮球"/> 篮球
           <input type="checkbox" name="fav" value="足球"/> 足球
           <input type="checkbox" name="fav" value="羽毛球"/> 羽毛球
           <input type="checkbox" name="fav" value="排球"/> 排球 
        </p>
        
        <p> <input type="submit" value="提交"></p>
    </form>
</body>
</html>