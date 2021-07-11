<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	var userList = new Array();
	userList.push({
		username : "zhangsan",
		age : 18
	});
	userList.push({
		username : "lisi",
		age : 22
	});

	$.ajax({
		type : "POSt",
		url : "${pageContext.request.contextPath}/userController/quick15",
		data : JSON.stringify(userList),
		contentType : "application/json;charset=utf-8"
	})
</script>
</head>
<body>

</body>
</html>