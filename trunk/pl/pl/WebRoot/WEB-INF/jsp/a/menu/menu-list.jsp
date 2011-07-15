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
					<a href="${path}/a/pdtype1/pdtype!list.action?firstFlag=1&level=1"
						target="_blank">一级类别管理</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="${path}/a/pdtype2/pdtype!list.action?firstFlag=1&level=2"
						target="_blank">二级类别管理</a>
				</td>
			</tr>
			<tr>
				<td>
					<a href="${path}/a/pdtype3/pdtype!list.action?firstFlag=1&level=3"
						target="_blank">三级类别管理</a>
				</td>
			</tr>
		</table>
	</body>
</html>