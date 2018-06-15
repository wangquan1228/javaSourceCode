          <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.HashMap,java.util.Calendar" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>首页</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>


<body>
 <%
		Calendar now = Calendar.getInstance();
		Integer hour = new Integer(now.get(Calendar.HOUR_OF_DAY));
		request.setAttribute("hour", hour);
	%>
	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">首页</a></li>
    </ul>
    </div>

    <div class="mainindex">
    <div class="welinfo">
    <span><img src="images/sun.png" alt="天气" /></span>
    <b>${exitEmp.userName},
  
	<c:choose>
		<c:when test="${hour >=0 && hour <=12 }">
			<c:set var="sayHello" value="上午好" />
		</c:when>
		<c:when test="${hour > 12 && hour <=17 }">
			<c:set var="sayHello" value="下午好" />
		</c:when>
		<c:otherwise>
			<c:set var="sayHello" value="晚上好" />
		</c:otherwise>
	</c:choose>
	<c:out value=" ${sayHello }" />  
    
    欢迎使用信息管理系统</b>
    <a href="#">帐号设置</a>
    </div>
    
    <div class="welinfo">
    <span><img src="images/time.png" alt="时间" /></span>
    <i>您上次登录的时间： ${exitEmp.createTime}</i> （不是您登录的？<a href="#">请点这里</a>）
    </div>
    <div class="xline"></div>
    </div>
</body>
</html>