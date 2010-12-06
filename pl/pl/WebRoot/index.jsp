<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>
</head>
<body>
登录用户：<ss:authentication property="name"/><br/>
<a href="${path}/a/menu/menu!list.action" target="_top">后台管理菜单</a><br/>
<a href="${path}/sys/user/user!preAdd.action" target="_blank">增加用户</a><br/>
<a href="${path}/sys/user/user!list.action" target="_blank">查詢用户</a><br/>
</body>
</html>