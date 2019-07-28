<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <a href="${pageContext.request.contextPath }/base/hello">test Struts2.x</a>
   <br>
   <a href="${pageContext.request.contextPath }/base/UserAction_add">addUser</a>
   <br>
   <a href="${pageContext.request.contextPath }/base/UserAction_update.to">updateUser</a>
   <br><br>
   <form action="${pageContext.request.contextPath }/base/UserAction_addUser" method="post">
     username:<Input type="text" name="userName" />
     birthday:<input type="text" name="birthday" />
     <input type="submit" value="addUser" />
   </form>
</body>
</html>