<%@ page contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>Hello World!</h2>
<p>param:<%=request.getParameter("id") %></p>
<form><input type="text" name="id"><button>전송</button></form>
</body>
</html>
