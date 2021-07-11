<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath }/userController/quick22"
		method="post" enctype="multipart/form-data">

		名称<input type="text" name="username"><br> 
		文件1<input type="file" name="uploadFile"><br> 
		文件2<input type="file" name="uploadFile2"><br> 
		<input type="submit" name="提交"><br>

	</form>
	<!-- 	name 相同时，服务端用数组接  -->
	<form
		action="${pageContext.request.contextPath }/userController/quick23"
		method="post" enctype="multipart/form-data">

		名称<input type="text" name="username"><br> 
		文件1<input type="file" name="uploadFile"><br> 
		文件2<input type="file" name="uploadFile"><br>
		 <input type="submit" name="提交"><br>

	</form>

</body>
</html>