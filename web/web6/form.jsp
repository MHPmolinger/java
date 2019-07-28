<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   
  </head >
  
  <body style="text-align:center;">
    <form action="${pageContext.request.contextPath }/servlet/CharacterEncodingServlet" method="get">
    用户名:<input type="text" name="username"><br>
    <input type="submit" value="登录">
    </form>
  </body>
</html>
