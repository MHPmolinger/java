<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <center>
     <h1>可供客户购买的商品如下：</h1>
     <table border="1" width="85%">
       <tr>
         <th>商品图片</th>
         <th>商品编号</th>
         <th>商品名称</th>
         <th>商品价格</th>
         <th>商品描述</th>
         <th>购买</th>
       </tr>
       <c:choose>
         <c:when test="${!empty(products)}">
           <c:forEach items="${products }" var="p">
             <tr>
               <td><img src="${pageContext.request.contextPath }/images/${p.imagePath}" width="200px" height="200px" /></td>
               <td>${p.pno }</td>
               <td>${p.pname }</td>
               <td>${p.price }</td>
               <td>${p.pdesc }</td>
               <td><a href="">购买</a></td>
             </tr>
           </c:forEach>
         </c:when>
         <c:otherwise>
          <tr><td colspan="6" align="center">对不起，还没有任何的商品供用户购买！</td></tr>
         </c:otherwise>
       </c:choose>
     </table>
   </center>
</body>
</html>