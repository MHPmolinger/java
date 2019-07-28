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
	   try {
			// Firefox, Opera 8.0+, Safari
			xmlHttpRequest = new XMLHttpRequest();
		} catch (e) {
			// Internet Explorer
			try {
				xmlHttpRequest = new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					alert("您的浏览器不支持AJAX！");
					return false;
				}
			}
		}
   }
   
   function callAjax(){
	   //1.创建Ajax引擎对象XmlHttpRequest
	   createXmlHttpRequest();
	   alert("1"+xmlHttpRequest);
	   //2.在Ajax引擎的状态改变触发器上注册一个回调函数
	   xmlHttpRequest.onreadystatechange=function(){
		    if(xmlHttpRequest.readyState==1){
		    	//alert("1");
		    }else if(xmlHttpRequest.readyState==2){
		    	//alert("2");
		    }else if(xmlHttpRequest.readyState==3){
		    	//alert("3");
		    }else if(xmlHttpRequest.readyState==4){
			   if(xmlHttpRequest.status==200){
				  //获取服务器端返回的文本数据
				  var content=xmlHttpRequest.responseText;
				 // alert(content);
                  //获取div标签对应的dom对象
                  var divObject=document.getElementById("div1");
                   //把返回的数据挂在到该标签中来
                   divObject.innerHTML=content;
			   }
		   }
	   }
	   //3.建立连接
	   xmlHttpRequest.open("GET","${pageContext.request.contextPath}/servlet/FirstAjaxServlet?name=lixiaoming");
	   //发送数据
	   
	   xmlHttpRequest.send(null);
   }
   function validateType(){
	   createXmlHttpRequest();
	   xmlHttpRequest.onreadystatechange=function(){
		   if(xmlHttpRequest.readyState==4){
			   if(xmlHttpRequest.status==200){
				  var content=xmlHttpRequest.responseText; 
				  document.getElementById("span1").innerHTML=content;
			   }
		   }
	   }
	   xmlHttpRequest.open("POST", "${pageContext.request.contextPath}/servlet/ValidateTypeServlet.do");
	   var textValue=document.getElementById("goodsType").value;
	   xmlHttpRequest.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	   xmlHttpRequest.send("goodsTypeId="+textValue);
   }
   function validateName(){
	   createXmlHttpRequest();
	   xmlHttpRequest.onreadystatechange=function(){
		   if(xmlHttpRequest.readyState==4){
			   if(xmlHttpRequest.status==200){
				  var content=xmlHttpRequest.responseText; 
				  document.getElementById("span2").innerHTML=content;
			   }
		   }
	   }
	   xmlHttpRequest.open("POST", "${pageContext.request.contextPath}/servlet/ValidateTypeServlet.do");
	   var textValue=document.getElementById("goodsType").value;
	   xmlHttpRequest.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	   xmlHttpRequest.send("goodsTypeId="+textValue);
   }
</script>
</head>
<body>
<input type="button" value="点击我" onclick="callAjax();" >
<div id="div1">
  没要数据
</div>
<br><hr>
请输入商品分类的的编号<input id="goodsType" type="text" name="goodsTypeId" onblur="validateType();"><span id="span1"></span>
<br>请输入商品分类的名称<input type="text" name="goodsTypeName" onblur="validateName();"><span id="span2"></span>
</body>
</html>