<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/common/taglibs.jsp"%>
</head>
<body>
<table border="1">
<s:iterator value="#request.reList" id="tpProduct" status="status">
	<s:if test="#status.index % 3 == 0">
	<tr>
	</s:if>
		<td valign="top">
			<table>
				<tr>
					<td height="160" width="160">
						<img src="${path}/uploads/${imagfileFileName}" width="160" height="160">
					</td>
				</tr>
				<tr>
					<td>
					<s:property value="#tpProduct.productName" />
					</td>
				</tr>
			</table>
		<s:property value="#status.index"></s:property>
		<s:property value="#tpProduct.productId" />
		</td>
	<s:if test="#status.index % 3 == 2 || #status.last">
	</tr>
	</s:if>
</s:iterator>
</table>
</body>
</html>