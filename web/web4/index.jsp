<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.Date,com.neusoft.javaweb.domain.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
JSP->Java Server Page<br>
<form action="" method="post">
 username:<Input type="text" name="name" />
 <input type="submit" value="addUser" />
</form>
<br>
<!-- jsp就是在html页面中可以使用Java代码,可以通过脚本语法来使用 -->
当前的系统时间为：
<%
    //1.第一种脚本语法：我们称为小脚本
    Date date=new Date();
    out.println(date.toLocaleString());
    User user=new User();
    user.setName("张三");
    int n=10;
    class B{
    	
    }
    request.setAttribute("name", "zhangsan");
    out.println(user.getName()+"<br>");
%>
<!-- 声明脚本 -->
<%!
     int n=20;//成员变量
   public void method(){//成员方法
	   System.out.println("asdfdsfsdaf");
   }
     //内部类
   class A{
	   
   }
  // out.printnl("asdfasfsadf");
%><br>
n=<%=n %><br>
this.n=<%=this.n %>
<br>
 <!-- 表达式脚本 -->
用户的姓名为：<%=user.getName() %>
<br>
你表单中填写的用户名称为：<%=request.getParameter("name") %>
 <%--注释脚本 --%>
</body>
</html>