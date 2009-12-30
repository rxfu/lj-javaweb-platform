<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<s:form action="/sys/login">
		<tr>
			<td><s:actionmessage accesskey="showMessage"></s:actionmessage></td>
		</tr>
		<tr>
			<td>用户名</td>
			<td><s:textfield name="userId" /></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><s:textfield name="password" /></td>
		</tr>
		<tr>
			<td><s:submit value="查询" /></td>
		</tr>
	</s:form>
</table>
</body>
</html>