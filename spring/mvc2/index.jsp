<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br>
<a href="${pageContext.request.contextPath }/showUser">test1</a>
<br><br>
<a href="${pageContext.request.contextPath }/findUser">test2</a>
<br><br>
<a href="${pageContext.request.contextPath }/requestUser">test HttpRequestHandlerAdapter</a>
<br><br><br>
<a href="${pageContext.request.contextPath }/user/add">添加新用户</a>
<br><br>
<a href="${pageContext.request.contextPath }/user/test">test@RequestMapping</a>
</body>
</html>