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
</body>
</html> 