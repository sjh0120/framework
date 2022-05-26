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
	java.util.Date msg1=new java.util.Date();
	
	/* pageContext.setAttribute("msg2", msg1);
	request.setAttribute("msg3", msg1);
	session.setAttribute("msg4", msg1);
	application.setAttribute("msg5", msg1); */
	
	//이상황일 때에는 msg2 는 pageContext의 우선순위가 제일 높다
	//page -> request -> session -> application -> null 순서
	request.setAttribute("msg2", "request");
	pageContext.setAttribute("msg2", "page");
	session.setAttribute("msg2", "session");
	application.setAttribute("msg2", "application");
	%>
	<p>msg1= <%=msg1 %></p>
	<p>msg1= ${msg1 }</p>
	<hr/>
	<%-- <p>pageContext msg2= <%=pageContext.getAttribute("msg2") %></p>
	<p>pageContext msg2= ${msg2 }</p> -> pageContext scope가 제일 높음!
	<hr/> --%>
	
	<%-- <p>request msg3= <%=request.getAttribute("msg3") %></p>
	<p>request msg3= ${msg3 }</p>
	<hr/>
	<p>session msg4= <%=session.getAttribute("msg4") %></p>
	<p>session msg4= ${msg4 }</p>
	<hr/>
	<p>application msg5= <%=application.getAttribute("msg5") %></p>
	<p>application msg5= ${msg5 }</p>
	<hr/> --%>
	<!-- 앞에 scope 수준을 명시해주면 같은 변수명이더라도 올바른 스코프 수준의 값을 받아 올 수 있다! -->
	
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