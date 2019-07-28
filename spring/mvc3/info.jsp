<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${sessionid }<br>
<br><hr><br>
<c:forEach items="${cookie }" var="entry">
  ${entry.key}:${entry.value.name }=${entry.value.value }<br>
</c:forEach>
<br><hr><br>
user.name:${user.name },user.city:${user.address.city }<br>
HttpSession：name:${sessionScope.user.name },city:${sessionScope.user.address.city }<br>
<br>
<hr><br>
u.name:${u.name },u.city:${u.address.city }<br>
user.name:${user.name },user.city:${user.address.city }<br>
<br><br>
${name }<br>
</body>
</html>