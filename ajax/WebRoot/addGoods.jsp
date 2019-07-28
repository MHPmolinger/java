<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  //声明一个Ajax的引擎对象
  var xmlHttpRequest;
  //定义一个方法用来创建ajax的引擎对象
  function createXmlHttpRequest(){
	  if(window.ActiveXObject){
		  xmlHttpRequest = new  ActiveXObject("Microsoft.XMLHTTP");
	     }else if(window.XMLHttpRequest){
	    	 xmlHttpRequest = new XMLHttpRequest();

	     }
  }
  //发送ajax请求的时机是,当页面被加载的时候我们就要让其执行
  window.onload=function(){
	  //alert("测试");
	  //1.创建Ajax引擎对象
	  createXmlHttpRequest();
	  //2.要给Ajax的引擎对象的onreadystatechange属性改变添加一个监听的函数
	  xmlHttpRequest.onreadystatechange=function(){
		  if(xmlHttpRequest.readyState==4){
			  if(xmlHttpRequest.status==200){
				  // 把处理的代码写在这里
				  var content=xmlHttpRequest.responseText;
				  var jsonObject=eval("("+content+")");
				  //alert(jsonObject);
				  //获取select标签对应的元素对象
				  var selectElement=document.getElementById("goodsClassityType");
				  //遍历数组
				  for(var i=0;i<jsonObject.length;i++){
					  //要创建一个option元素
					  var optionElement=document.createElement("option");
					  optionElement.setAttribute("value", jsonObject[i].id);
					  optionElement.innerHTML=jsonObject[i].name;
					  //把该元素挂载到父对象上
					  selectElement.appendChild(optionElement);
				  }
			  }
		  }
		  
	  }
	  //3.创建Ajax引擎到服务器的连接
	  xmlHttpRequest.open("GET", "${pageContext.request.contextPath}/servlet/showGoodsClassityTypeServlet.do",true);
	  //4.发送数据
	  xmlHttpRequest.send(null);
	  
  }
</script>
</head>
<body>

<select name="goodsClassityType" id="goodsClassityType">
 <option value="">--请选择---</option>
</select>
</body>
</html>