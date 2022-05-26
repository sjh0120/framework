<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>값의 전달</h1>
	<%
	String[] arr1={"item1", "item2", "item3"};
	
	request.setAttribute("msg2", arr1);
	pageContext.setAttribute("msg2", arr1);
	session.setAttribute("msg2", arr1);
	application.setAttribute("msg2", arr1);
	%>
	<p>msg1= <%=arr1 %></p>
	<p>msg1= ${msg1 }</p>
	<hr/>
	<p>pageContext msg2= <%=pageContext.getAttribute("msg2") %></p>
	<p>pageContext msg2= ${pageScope.msg2 }</p>
	<hr/>
	<p>request msg3= <%=request.getAttribute("msg2") %></p>
	<p>request msg3= ${requestScope.msg2 }</p>
	<hr/>
	<p>session msg4= <%=session.getAttribute("msg2") %></p>
	<p>session msg4= ${sessionScope.msg2 }</p>
	<hr/>
	<p>application msg5= <%=application.getAttribute("msg2") %></p>
	<p>application msg5= ${applicationScope.msg2 }</p>
	<hr/>
	
</body>
</html>