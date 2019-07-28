<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
    
    <title>列出所用登录的用户</title>
  
  </head>
  
  <body>
    <br><br>
    所有登录的用户如下：<hr><br>
    <table>
    <c:forEach var="entry" items="${applicationScope.map }" >
    <tr><td>${entry.key }</td><td><a href="${pageContext.request.contextPath }/servlet/KichServlet?username=${entry.key}">踢死你</a></td></tr>
    </c:forEach>
    </table>
  </body>
</html>
