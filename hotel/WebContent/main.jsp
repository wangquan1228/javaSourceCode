<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="${basePath }">

		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>信息管理系统界面</title>
	</head>

	<frameset rows="88,*" cols="*" frameborder="no" border="0"
		framespacing="0">
		<frame src="top.jsp" name="topFrame" scrolling="No"
			noresize="noresize" id="topFrame" title="topFrame" />
		<frameset cols="187,*" frameborder="no" border="0" framespacing="0">
			<frame src="left.jsp" name="leftFrame" scrolling="No"
				noresize="noresize" id="leftFrame" title="leftFrame" />
			<frame src="center.jsp" name="right" id="rightFrame"
				title="rightFrame" />
		</frameset>
	</frameset>
	<noframes>
	
		<body>
		
		</body>
	</noframes>
</html>