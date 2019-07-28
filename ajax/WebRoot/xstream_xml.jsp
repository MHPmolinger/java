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
  window.onload=function(){
	//1.创建Ajax引擎
	  createXmlHttpRequest();
	//2.为Ajax引擎的状态改变属性设置回调函数
	   xmlHttpRequest.onreadystatechange=function(){
		if(xmlHttpRequest.readyState==4){
			if(xmlHttpRequest.status==200){
				var xml=xmlHttpRequest.responseXML;
				//alert(xml);
				var selectObject=document.getElementById("goodsType");
				var goodsTypes=xml.getElementsByTagName("goodsType");
				//遍历该标签
				//alert(goodsTypes.length);
				for(var i=0;i<goodsTypes.length;i++){
					var cnodes=goodsTypes[i].childNodes;
					//alert(cnodes.length+"-----");
					//for(var j=0;j<cnodes.length;j++){
						//alert(cnodes[1].firstChild.nodeValue);
						var id=cnodes[0].firstChild.nodeValue;
						var name=cnodes[1].firstChild.nodeValue;
						//alert("id="+id+" ,name="+name);
						var optionObject=document.createElement("option");
						optionObject.setAttribute("value", id);
						optionObject.innerHTML=name;
						selectObject.appendChild(optionObject);
					//}
				}
			}
		}
	}
	//3.建立Ajax引擎和服务器的连接
	xmlHttpRequest.open("GET", "${pageContext.request.contextPath}/servlet/gt.do",true);
	
	//4.发送数据
	  xmlHttpRequest.send(null);
	
  }
</script>
</head>
<body>

<select name="goodsType" id="goodsType">

</select>
</body>
</html>