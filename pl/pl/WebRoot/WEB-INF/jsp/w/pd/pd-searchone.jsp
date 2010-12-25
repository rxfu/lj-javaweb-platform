<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/common/taglibs.jsp"%>
</head>
<body>
<%@include file="/include/top.jsp"%>
<%@include file="/include/top1.jsp"%>
<div align="center">
	<table width="1000" border="0" cellspacing="3" cellpadding="0">
		<tr>
			<td width="200" valign="top"><%@include file="/include/pdtype.jsp"%></td>
			<td width="10" valign="top"> </td>
			<td width="790" valign="top">
				<table width="790" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="center" style="font-size: x-large;font-family:'黑体'; " colspan="10">
							<br/><s:property value="tpProduct.productName"/><br/><br/>
						</td>
					</tr>
					<tr>
						<td>
							<img src="${path}/uploads/${tpProduct.imagfileFileName}" width="350" height="350" border="1" style="border:1px  dotted  #001403;">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

</body>
</html>