<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>down load page</h1>
<!-- 방법1 -->
<%-- <div><a href="down?file=${filename }&origin=${origin}">[${origin}][down]</a></div> --%>
<div><a href="down/${filename}">${filename }</a></div>

</body>
</html>