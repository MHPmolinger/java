<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <table border="1" width="55%">
    <tr><th>商品分类编号</th><th>商品分类名称</th><th>商品分类描述</th></tr>
    <c:forEach items="${list }" var="goodsType">
    <tr>
    <td>${goodsType.id }</td>
     <td>${goodsType.name }</td>
      <td>${goodsType.gtype}</td>
    </tr>
    </c:forEach>
    </table>