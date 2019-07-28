<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>用户登录页面</title>
    
  </head>
  
  <body>
    <center>
    <br><br>
     用户登录<hr><br>
     <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
     username:<input type="text" name="username"><br>
     password:<input type="password" name="password"><br><br>
     <input type="submit" value="login">
     </form>
    </center>
  </body>
</html>
