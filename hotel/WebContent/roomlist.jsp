 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<title>房间列表</title>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">房间管理</a></li>
			<li><a href="#">所有房间管理</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			 

			<form action=" " method="post">
				<ul class="toolbar1">
					<li>房间类型：<input value="${emp.userName }" type="text"
						name="user_name">  <input type="submit"
						value="查询">
					</li>
				</ul>
			</form>
		</div>


		<table class="tablelist">
			<thead>
				<tr>
					<th>房间号 </th>
					<th>房间名</th>
					<th>类型</th>
					<th>价格</th>
					<th>备注</th>
					 
				</tr>
			</thead>
			<tbody>
				<c:if var="u" test="${!(empty roomlist)}">
					<c:forEach items="${roomlist}" var="room">
						<tr>
							<td> ${room.roomId }</td>
							<td> ${room.roomName }</td>
							<td> ${room.roomType } </td>
							<td> ${room.roomPrice }元</td>
							<td>${room.remark}</td> 
							 
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${!u }">
					<td colspan="10" align="center"><font color="red">${message }</font>
					</td>
				</c:if>

			</tbody>
		</table>
	</div>
</body>
</html>`