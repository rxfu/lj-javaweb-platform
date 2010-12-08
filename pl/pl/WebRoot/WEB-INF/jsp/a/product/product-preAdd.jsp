<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<script type="text/javascript" src="${path}/ckeditor/ckeditor.js"/></script>
		<title>产品添加</title>
	</head>
	<body>
		<table width="100%" align="center">
			<tr>
				<td  colspan="2" align="center">
					添加
				</td>
			</tr>
			<tr>
				<td>简称</td>
				<td><s:textfield name="tpProduct.productNameSimple"/></td>
			</tr>
			<tr>
				<td>介绍</td>
				<td><s:textarea name="tpProduct.productIntroduction" cssClass="ckeditor" rows="20" cols="2"/></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="提交" /></td>
			</tr>
		</table>
	</body>
</html>