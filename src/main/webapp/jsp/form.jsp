<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form
		action="${pageContext.request.contextPath }/userController/quick14"
		method="post">
		<%-- 表明是第一个User对象的username age --%>
		<input type="text" inputmode="text" name="userList[0].username"><br /> 
		<input
			type="text" name="userList[0].age"><br /> 
		<input type="text"
			name="userList[1].username"><br /> 
		<input type="text"
			name="userList[1].age"><br /> 
		<input type="submit" value="提交">
	</form>
</body>
</html>