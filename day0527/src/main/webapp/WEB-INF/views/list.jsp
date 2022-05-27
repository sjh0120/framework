<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">홈</a>
<a href="list.jsp">리스트</a>
<%@ page import="com.sjh0120.model.entity.*,java.util.*" %>
<%for(EmpVo bean: (List<EmpVo>)request.getAttribute("list")) {%>
<div><a href="detail.bit?empno=<%=bean.getEmpno() %>"><%=bean %></a></div>
<%} %>
</body>
</html>