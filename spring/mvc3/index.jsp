<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <a href="${pageContext.request.contextPath }/cookieValue">test@CookieValue</a>
  <br><br>
  <a href="${pageContext.request.contextPath }/addCookie">添加一个cookie</a>
   <br><br>
  <a href="${pageContext.request.contextPath }/showCookie">显示一个cookie</a>
  <br><br>
  <form action="${pageContext.request.contextPath }/user/add" method="post">
   name:<Input type="text" name="name" />
   city:<input type="text" name="address.city" />
   <input type="submit" value="addUser" />
  </form>
  <br>
  <a href="${pageContext.request.contextPath }/servletApi">testServletAPI</a>
  <br><br>
  <a href="${pageContext.request.contextPath }/test1">test@ModelAttribute1</a>
   <br><br>
  <a href="${pageContext.request.contextPath }/test2">test@ModelAttribute2</a>
  <br><br>
  <form action="${pageContext.request.contextPath }/add" method="post">
     name:<input type="text" name="name" />
     <input type="submit" value="add"/>
  </form>
  <br><br><br><Hr><br>
  <a href="${pageContext.request.contextPath }/interceptor1">测试自定义的拦截器</a>
</body>
</html>