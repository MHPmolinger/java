<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
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
   <a href="${pageContext.request.contextPath }/manager/addProduct.jsp">添加商品</a>
   <a href="${pageContext.request.contextPath }/manager/deleteProduct.jsp">删除商品</a>
   <a href="${pageContext.request.contextPath }/manager/updateProduct.jsp">修改商品</a>
   <a href="${pageContext.request.contextPath }/manager/findProduct.jsp">查询商品</a>
  </body>
</html>
