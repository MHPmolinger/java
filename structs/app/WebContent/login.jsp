<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    ${error }
    ${login }
   <form action="${pageContext.request.contextPath }/email/email_login" method="post">
     email_name:<input type="text" name="emailName" /><br>
     email_password:<input type="password" name="loginPwd" /><br>
     <input type="submit" value="loginEmail" />
   </form>
</body>
</html>