<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
  </head>
  
  <body style="text-align:center;">
    <form action="${pageContext.request.contextPath }/servlet/LoginServlet" method="post">
    <table>
    <tr><td><input type="radio" name=usertype" checked>用户名
    <input type="radio" name="username">UID
    </td><td>
    <input type="text" name="username"><a href="">立即注册</a>
    </td></tr>
    <tr><td>密  码：</td><td><input type="password" name="password"><a href="">忘记密码</a></td></tr>
    <tr><td>登录有效期：</td><td>
    <input type="radio" name="loginExpiressTime" value=${30*24*60*60 }>一个月
    <input type="radio" name="loginExpiressTime" value=${24*60*60 }>一天
    <input type="radio" name="loginExpiressTime" value=${3*60 }>3分钟
    </td></tr>
    <tr><td></td><td><input type="submit" value="提交"></td></tr>
    </table>
    </form>
  </body>
</html>
