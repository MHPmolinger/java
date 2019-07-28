<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.neusoft.javaweb.domain.*"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">

   <%
     for(int i=1;i<=9;i++){
   %>
   <tr>
     <%
        for(int j=1;j<=i;j++){
       %>
         <td><%=i %>*<%=j %>=<%=i*j %></td>
       <% 
        } 	   
     }
     %>
   </tr>
   </table>
   <br>
   <h1>使用jstl核心标签库中的核心标签来实现输出乘法口诀：</h1>
   <table border="1">
   <c:forEach begin="1" end="9" var="i" >
     <tr>
       <c:forEach begin="1" end="${i }" var="j" >
         <td>${i }*${j }=${i*j }</td>
       </c:forEach>
     </tr>
   </c:forEach>
   </table>
   <br>
   2.c:if----------------------<br>
   <%
        int i=6;
        pageContext.setAttribute("n", i);//把i的值放置到页面域中
        //页面域只在当前页面范围有效
        pageContext.setAttribute("name", "pageScope_张三");
        //在请求范围有效
        request.setAttribute("name", "requestScope_张三");
        //回话范围
        session.setAttribute("name", "sessionScope_张三");
        //上下文范围（最大）对于整个web项目都是可见的
        application.setAttribute("name", "applicationScope_张三");
        
   %>
   <c:if test="${requestScope.name!=null }">
     <c:out value="${requestScope.name }"></c:out>
   </c:if>
   <br>
   3.c:choose,c:when,c:otherwise---------------------<br>
     <c:choose>
         <c:when test="${n%2==0 }">
            ${n }是偶数<br>
         </c:when>
         <c:otherwise>
            ${n }是奇数<br>
         </c:otherwise>
     </c:choose>
     <br>
    4*5= ${4*5 }<br>
     <form action="" method="post">
       请输入年龄：<input type="text" name="age" />
       <input type="submit" value="判断"/>
     </form>
     <br>
     <c:choose>
       <c:when test="${param.age>=60 }">
         你的年龄[${param.age }]是老年<br>
       </c:when>
       <c:when test="${param.age>=40 }">
        你的年龄[${param.age }]是中年<br>
       </c:when>
        <c:when test="${param.age>=20 }">
          你的年龄[${param.age }]是青年年<br>
        </c:when>
        <c:otherwise>
           你的年龄[${param.age }]是少年<br>
        </c:otherwise>
     </c:choose>
     <br>
     <%
           List<User> users=new ArrayList<User>();
          users.add(new User("张三",new Address("江苏省","南京市","雨花区")));
          users.add(new User("李四",new Address("江苏省","徐州市","贾汪区")));
          users.add(new User("王五",new Address("江苏省","连云港","海州区")));
          users.add(new User("赵六",new Address("江苏省","淮安","楚州区")));
          users.add(new User("田七",new Address("江苏省","南京市","鼓楼区")));
          request.setAttribute("users", users);
     %>
     <table border="1" width="65%">
      <tr><th>姓名</th><th>省份</th><th>城市</th><th>街道</th></tr>
     <c:choose>
       <c:when test="${pageScope.users!=null }">
         <c:forEach items="${requestScope.users }" var="user">
           <tr>
             <td>${user.name }</td>
             <td>${user.address.province }</td>
             <td>${user.address.city }</td>
             <td>${user.address.street }</td>
           </tr>
         </c:forEach>
       </c:when>
       <c:otherwise>
         <tr><td colspan="4">对不起，没有你要查找的数据！</td></tr>
       </c:otherwise>
     </c:choose>
     </table>
</body>
</html>