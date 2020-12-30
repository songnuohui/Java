<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
      function reloadCode(){
    	  
		document.getElementById("verifyCode").src="verifyCode?r="+Math.random();
	  }
</script>
</head>
<body>
   <input type="text" name="code"/>   
   <a href="javaScript:void(0)" onclick="reloadCode()">
   <img id="verifyCode" src="verifyCode"></a>
</body>
</html>