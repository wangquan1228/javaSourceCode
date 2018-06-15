<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script type="text/javascript">
	$(function() {
		//导航切换
		$(".menuson li").click(function() {
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});
		$('.title').click(function() {
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if ($ul.is(':visible')) {
				$(this).next('ul').slideUp();
			} else {
				$(this).next('ul').slideDown();
			}
		});
	})
</script>
</head>

<body style="background: #f0f9fd;">
	<div class="lefttop">
		<span></span>信息管理
	</div>
	<dl class="leftmenu">
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /></span>员工管理
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="emplist"
					target="right">在职员工管理</a><i></i></li>
				<li class="active"><cite></cite><a href="editpassword.jsp" target="right">修改密码</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /></span>客户管理
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="customer" target="right">客户信息管理</a><i></i></li>
			</ul>
		</dd>
		<dd>
			<div class="title">
				<span><img src="images/leftico01.png" /></span>房间管理
			</div>
			<ul class="menuson">
				<li class="active"><cite></cite><a href="room" target="right">房间信息管理</a><i></i></li>
			</ul>
		</dd>
	</dl>
</body>
</html>