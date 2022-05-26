<%@page import="com.bit.frame.controller.DeptVo"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.HashMap"%>
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
	java.util.List<String> arr2=new java.util.ArrayList<String>();
	arr2.add("list1");
	arr2.add("list2");
	arr2.add("list3");
	
	java.util.Set<String> arr3=new HashSet<>(); // JSTL
	arr3.add("Set1");
	arr3.add("Set2");
	arr3.add("Set3");
	
	session.setAttribute("msg2", arr2);
	pageContext.setAttribute("msg2", arr1);
	request.setAttribute("msg2", arr3);
	application.setAttribute("msg2", arr1);
	
	java.util.Map<String,String> map=new java.util.HashMap<String,String>();
	map.put("key1", "val1");
	map.put("key2", "val2");
	map.put("key3", "val3");
	pageContext.setAttribute("map", map);
	
	com.bit.frame.controller.DeptVo bean=new com.bit.frame.controller.DeptVo();
	bean.setDeptno(1111);
	bean.setDname("dname");
	bean.setLoc("loc");
	pageContext.setAttribute("bean", bean);
	
	
	
	%>
	<p>msg1= <%=arr1 %></p>
	<p>msg1= ${msg1 }</p>
	<hr/>
	<p>pageContext msg2= <%=pageContext.getAttribute("msg2") %></p>
	<p>pageContext msg2= ${pageScope.msg2 }</p>
	<%-- <p>pageContext msg2= ${pageScope.msg2.get(0) }</p>
	<p>pageContext msg2= ${pageScope.msg2.get(1) }</p>
	<p>pageContext msg2= ${pageScope.msg2.get(2) }</p> --%>
	<hr/>
	<p>request msg3= <%=request.getAttribute("msg2") %></p>
	<p>request msg3= ${requestScope.msg2 }</p>
	<%-- <p>request msg3= ${requestScope.msg2.get(0) }</p>
	<p>request msg3= ${requestScope.msg2.get(1) }</p>
	<p>request msg3= ${requestScope.msg2.get(2) }</p> --%>
	
	<hr/>
	<p>session msg4= <%=session.getAttribute("msg2") %></p>
	<p>session msg4= ${sessionScope.msg2 }</p>
	<p>session msg4= ${sessionScope.msg2[0] }</p>
	<p>session msg4= ${sessionScope.msg2[1] }</p>
	<p>session msg4= ${sessionScope.msg2[2] }</p>
	<p>session msg4= ${sessionScope.msg2[3] }</p>
	<hr/>
	<p>application msg5= <%=application.getAttribute("msg2") %></p>
	<p>application msg5= ${applicationScope.msg2 }</p>
	<p>application msg5= ${applicationScope.msg2[0] }</p>
	<p>application msg5= ${applicationScope.msg2[1] }</p>
	<p>application msg5= ${applicationScope.msg2[2] }</p>
	<hr/>
	<p>map= ${map }</p>
	<p>map= ${map.key1 }</p>
	<p>map= ${map.key2 }</p>
	<p>map= ${map.key3 }</p>
	<hr/>
	<p>bean= ${bean }</p>
	<p>bean= = ${bean.deptno }</p>
	<p>bean= = ${bean.dname }</p>
	<p>bean= = ${bean.loc }</p>
	
</body>
</html>