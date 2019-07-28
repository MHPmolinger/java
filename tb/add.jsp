<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
    <form action="${pageContext.request.contextPath }/addProductServlet" method="post" enctype="multipart/form-data">
   <table border="1" width="65%">
    <tr><td> 商品编号：</td><td><input type="text" name="pid" /></td></tr>
    <tr><td> 商品名称：</td><td><input type="text" name="pname" /></td></tr>
    <tr><td> 商品价格：</td><td><input type="text" name="price" /></td></tr>
    <tr><td> 商品描述：</td><td><textarea rows="5" cols="50" name="pdesc"></textarea></td></tr>
    <tr><td>商品图片:</td><td><input type="file" name="imagePath"/></td></tr>
    <tr><td colspan="2"> <input type="submit" value="添加商品" /></td></tr>
   </table>   
     
    </form>
  </center>
</body>
</html>