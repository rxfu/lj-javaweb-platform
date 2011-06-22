<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.pl.sys.SysContexts" %>
<%@page import="com.pl.tdo.TpProductBean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/common/taglibs.jsp"%>
<c:set var="reList1" value="${SysContexts.groupList1}" scope="request"/>
</head>
<style type="text/css">
.xxtd{BORDER-BOTTOM: #000000 1px dotted;}
</style>
<body>
<table border="0" cellspacing="0" cellpadding="0" width="795">
<tr>
	<td colspan="10" align="left">
		<table width="795"  border="0"  cellspacing="0" cellpadding="0">
			<tr>
			<td width="3"><img src="${path}/imags/title_bg1.png"/></td>
			<td width="100" background="${path}/imags/title_bg2.png" nowrap="nowrap" align="center" style="font-size: 15;color: white;"><strong> 每&nbsp;周&nbsp;热&nbsp;销</strong></td>
			<td width="4"><img src="${path}/imags/title_bg3.png"/></td>
			<td background="${path}/imags/title_bg4.png" colspan="10">&nbsp;</td>
			</tr>
		</table>
	</td>
</tr>
<%
	for (int i = 0; i < SysContexts.groupList1.size(); i++) {
	TpProductBean tpProduct = SysContexts.groupList1.get(i);
	if(i % 5 == 0){
%><tr><%
	}%>
	<td valign="top" class="xxtd">
			<table>
				<tr>
					<td height="145" width="145">
						<a href="${path}/w/pd/pd!searchById.action?tpProduct.productId=<%=tpProduct.getProductId()%>" target="_top">
							<img src="${path}/uploads/<%=tpProduct.getImagfileFileName()%>" width="145" height="145" border="0">
						</a>
					</td>
				</tr>
				<tr>
					<td valign="top" align="center">
					<a href="${path}/w/pd/pd!searchById.action?tpProduct.productId=<%=tpProduct.getProductId()%>" target="_top">
						<%=tpProduct.getProductName()%>
					</a>
					</td>
				</tr>
			</table>
	</td>
	<%if(i % 5 == 4||i==SysContexts.groupList1.size()){
	%></tr><%
	}
}
%>
<c:forEach items="${reList1}" varStatus="status">
<tr><td>123${item}</td></tr>
</c:forEach>
</table>
</body>
</html>