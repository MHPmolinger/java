<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
 var xmlHttpRequest;
 function createXmlHttpRequest(){
	 if(window.ActiveXObject){
		 xmlHttpRequest = new  ActiveXObject("Microsoft.XMLHTTP");
     }else if(window.XMLHttpRequest){
	     xmlHttpRequest = new XMLHttpRequest();

     }
 }
 function showGoodsTypes(){
	 //1.创建Ajax引擎对象
	 createXmlHttpRequest();
	 //2.给Ajax引擎对象的onreadystatechange状态改变属性设置回调函数
	 xmlHttpRequest.onreadystatechange=function(){
		 if(xmlHttpRequest.readyState==4){
			 if(xmlHttpRequest.status==200){
				 //把处理代码写在这里
				 var content=xmlHttpRequest.responseText;
				 document.getElementsByTagName("div")[0].innerHTML=content;
			 }
		 }
	 }
	 //3.建立Ajax引擎到服务器的连接
	 var url="${pageContext.request.contextPath}/servlet/showGoodsTypesServlet.do";
	 xmlHttpRequest.open("GET", url,true);
	 //3.发送数据
	  xmlHttpRequest.send(null);
 }
</script>
</head>
<body>
<input type="button" value="显示所有注册的商品分类编号" onmouseover="showGoodsTypes();">
<br>
<div id="div1">

</div>
</body>
</html>