<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>PL系统管理</title>
</head>
<frameset rows="64,*" frameborder="NO" border="0" framespacing="0">
	<frame src="<%=request.getContextPath() %>/sys/topframe.action" noresize="noresize" frameborder="0"
		name="topFrame" scrolling="no" marginwidth="0" marginheight="0" />
	<frameset cols="200,*" rows="560,*" id="frame">
		<frame src="<%=request.getContextPath() %>/sys/leftframe.action" name="leftFrame" noresize="noresize"
			marginwidth="0" marginheight="0" frameborder="0" scrolling="auto" />
		<frame src="<%=request.getContextPath() %>/sys/mainframe.action" name="main" marginwidth="0" marginheight="0"
			frameborder="0" scrolling="auto"/>
	</frameset>
</frameset>
</html>
