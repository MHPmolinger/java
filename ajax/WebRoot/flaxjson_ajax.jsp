<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
  var xmlHttpRequest;
  function createXmlHttpRequest(){
	  if(window.ActiveXObject){
			 xmlHttpRequest = new  ActiveXObject("Microsoft.XMLHTTP");
	     }else if(window.XMLHttpRequest){
		     xmlHttpRequest = new XMLHttpRequest();

	     }
  }
  function showJSON(){
	  //1.创建ajax引擎
	  createXmlHttpRequest();
	  //2.
	  xmlHttpRequest.onreadystatechange=function(){
		  if(xmlHttpRequest.readyState==4){
			  if(xmlHttpRequest.status==200){
				 var jsonContent=xmlHttpRequest.responseText;
				 var jsonObject=eval("("+jsonContent+")");
				 alert(jsonObject.length);
				 //返回的对象时一个数组,我们要遍历数组
				 var text="<table border='1' width='75%'>";
				 text+="<tr><th>商品类型编号</th><th>商品类型名称</th><th>商品类型描述</th></tr>";
				 for(var i=0;i<jsonObject.length;i++){
					 text+="<tr><td>"+jsonObject[i].id+"</td>"+"<td>"+jsonObject[i].name+"</td>"+"<td>"+jsonObject[i].gtype+"</td></tr>";
				 }
				 text+="</table>";
				 alert(text);
				 //document.getElementsByName("div")[0].innerHTML=text;
				 document.getElementById("div1").innerHTML=text;
			  }
		  }
	  }
	  //3.
	  xmlHttpRequest.open("GET", "${pageContext.request.contextPath}/servlet/JSONServlet.do");
	  //4.
	  xmlHttpRequest.send(null);
  }
</script>
<body>
<input type="button" value="显示所有JSON数据" onclick="showJSON();">
<br>
<div id="div1" name="div">

</div>
</body>
</html>