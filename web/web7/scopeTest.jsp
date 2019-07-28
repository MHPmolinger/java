<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'scopeTest.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
       application.setAttribute("applicationTest", "在application域中添加了一个新值");
       application.setAttribute("applicationTest", "在application域中替换了一个新值");
       application.removeAttribute("applicationTest");
        session.setAttribute("sessionTest", "在session域中添加了一个新值");
       session.setAttribute("sessionTest", "在session域中替换了一个新值");
       session.removeAttribute("sessionTest");
       
       request.setAttribute("requestTest", "在request域中添加了一个新值");
       request.setAttribute("requestTest", "在request域中替换了一个新值");
       request.removeAttribute("requestTest");
       
       
     %>
  </body>
</html>
