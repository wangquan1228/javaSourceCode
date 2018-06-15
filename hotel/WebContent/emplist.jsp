<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
	<div class="place">
		<span>位置：</span>
		<ul class="placeul">
			<li><a href="#">首页</a></li>
			<li><a href="#">员工管理</a></li>
			<li><a href="#">在职员工管理</a></li>
		</ul>
	</div>
	<div class="rightinfo">
		<div class="tools">
			<ul class="toolbar">
				<li class="click"><a href="addEmp.jsp"><span><img
							src="images/t01.png" /> </span>添加</a></li>
			</ul>
			<form action="emplist" method="post">
				<ul class="toolbar1">
					<li>姓名：<input value="${empl.userName }" type="text"
						name="user_name"> 账号：<input value="${empl.account }"
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
					<th>账号</th>
					<th>电话</th>
					<th>状态</th>
					<th>入职日期</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:if var="u" test="${!(empty emplList)}">
					<c:forEach items="${ emplList}" var="empl">
						<tr>
							<td><input name="user_id" type="checkbox"
								value="${empl.id }" /></td>
							<td>${empl.userName }</td>
							<td>${empl.account }</td>
							<td>${empl.mobile }</td>
							<td>
							 <c:if var="b" test="${empl.status eq 0}">在职</c:if>
							 <c:if test="${!b}">离职</c:if>
							</td>
							<td>${empl.createTime }</td>
							<td>
							 <a href="EmpQueryServlet.dao?emp_id=${empl.id }"
								class="tablelink">修改</a>
						     <a href="delete?emp_id=${empl.id }" 
						          class="tablelink">删除</a>
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
	<script type="text/javascript">
		$('.tablelist tbody tr:odd').addClass('odd');
	</script>
</body>
</html>
