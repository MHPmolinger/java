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
	//当页面被加载就要获取到所有省份
	createXmlHttpRequest();
	//alert("asdf");
	//2.
	xmlHttpRequest.onreadystatechange=function(){
		if(xmlHttpRequest.readyState==4){
			if(xmlHttpRequest.status==200){
				var selectObject=document.getElementById("province");
				var pjson=xmlHttpRequest.responseText;
				var psjsonObject=eval("("+pjson+")");
				for(var i=0;i<psjsonObject.length;i++){
					var value=psjsonObject[i].id;
					var text=psjsonObject[i].name;
					var optionElement=document.createElement("option");
					optionElement.setAttribute("value", value);
					optionElement.innerHTML=text;
					selectObject.appendChild(optionElement);
				}
			}
		}
	}
	//3
	xmlHttpRequest.open("GET", "${pageContext.request.contextPath}/servlet/findProvinceServlet.do", true);
	//4
	xmlHttpRequest.send(null);
}

function findCity(){
	//获取所有的市
	createXmlHttpRequest();
	//alert("2");
		var pid=document.getElementById("province").value;
	    // alert(pid);
	     var selectCity=document.getElementById("city");
	       selectCity.length=1;//每次都会把原来的动态生成的option子元素设置为0
	//2.
	xmlHttpRequest.onreadystatechange=function(){
		if(xmlHttpRequest.readyState==4){
			if(xmlHttpRequest.status==200){
				var xmlObject=xmlHttpRequest.responseXML;
				//alert(xmlObject);
				var citys=xmlObject.getElementsByTagName("city");
				//alert(citys.length);
				for(var i=0;i<citys.length;i++){
					var cid=citys[i].childNodes[0].firstChild.nodeValue;
					var cname=citys[i].childNodes[1].firstChild.nodeValue;
					var optionElement=document.createElement("option");
					optionElement.setAttribute("value", cid);
					optionElement.innerHTML=cname;
					selectCity.appendChild(optionElement);
				}
			}
		}
	}
	//3.
	  xmlHttpRequest.open("POST", "${pageContext.request.contextPath}/servlet/findAllCityServlet.do", true);
	//4
    xmlHttpRequest.setRequestHeader("CONTENT-TYPE","application/x-www-form-urlencoded");
	xmlHttpRequest.send("pid="+pid);
	
}
function findStreet(){
	//获取所有的区县
}
</script>
</head>
<body>
<select name="province" id="province" onchange="findCity();">
<option value="">--请选择省份--</option>
</select>省&nbsp;&nbsp;
<select name="city" id="city" onchange="findStreet();"> 
<option value="">--请选择市--</option>
</select>市&nbsp;&nbsp;
<select name="street" id="street"> 
<option value="">--请选择街道--</option>
</select>街道
</body>
</html>