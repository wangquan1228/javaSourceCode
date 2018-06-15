<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
<title>员工列表</title>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">客户管理</a></li>
			<li><a href="#">客户列表</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="click"><a href="addCustomer.jsp"><span>
				<img src="images/t01.png" /> </span>添加</a></li>
			</ul>

			<form action="UserListServlet.do" method="post">
				<ul class="toolbar1">
					<li>姓名：<input value="${emp.userName }" type="text"
						name="user_name"> 账号：<input value="${ emp.account }"
						type="text" name="account"> <input type="submit"
						value="查询">
					</li>
				</ul>
			</form>
		</div>


		<table class="tablelist">
			<thead>
				<tr>
					<th><input name="" type="checkbox" value="" checked="checked" />
					</th>
					<th>姓名 </th>
					<th>性别</th>
					<th>身份证</th>
					<th>房间号</th>
					<th>入住时间</th>
					<th>支付金额</th>
					<th>备注</th>
					 <th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if var="u" test="${!(empty customerlist)}">
					<c:forEach items="${customerlist}" var="customer">
						<tr>
						<td><input name="customer_id" type="checkbox"
								value="${customer.customerId }" /></td>
							<td>${customer.customerName }</td>
							<td>${customer.gender}</td>
							<td>${customer.card}</td>
							<td>${customer.roomId}</td>
							<td>${customer.inTime }</td>
							<td>${customer.payPrice }</td>
							<td>${customer.remark }</td>
							<td><a href="customer?method=findCus&id=${customer.customerId }" class="tablelink">修改</a> 
								
								<a href="customer?method=deleteCus&id=${customer.customerId }" class="tablelink">删除</a>
							</td>
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
</html>