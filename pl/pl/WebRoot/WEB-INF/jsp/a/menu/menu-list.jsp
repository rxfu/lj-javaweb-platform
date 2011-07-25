<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<title>后台菜单</title>
	</head>
	<body>
		<table width="100%" align="center">
			<tr>
				<td>
					<a href="${path}/a/user/user!list.action?firstFlag=1"
						target="_blank">用户管理</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="${path}/a/product/product!list.action?firstFlag=1"
						target="_blank">产品管理</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="${path}/a/group/group!list.action?firstFlag=1"
						target="_blank">产品组管理</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="${path}/a/pdtype/pdtype!list.action?firstFlag=1"
						target="_blank">类别管理</a>
				</td>
			</tr>
		</table>
	</body>
</html>