<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.pl.sys.SysContexts" %>
<%@page import="com.pl.web.a.product.TpProduct" %>
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
			<td width="100" background="${path}/imags/title_bg2.png" nowrap="nowrap" align="center" style="font-size: 15;color: white;" ><strong> 今&nbsp日&nbsp特&nbsp价</strong></td>
			<td width="4"><img src="${path}/imags/title_bg3.png"/></td>
			<td background="${path}/imags/title_bg4.png" colspan="10">&nbsp</td>
			</tr>
		</table>
	</td>
</tr>
<%
	for (int i = 0; i < SysContexts.groupList2.size(); i++) {
	TpProduct tpProduct = SysContexts.groupList2.get(i);
	if(i % 5 == 0){
	%><tr><%
	}%>
	<td valign="top" class="xxtd">
			<table>
				<tr>
					<td height="145" width="145">
						<img src="${path}/uploads/<%=tpProduct.getImagfileFileName()%>" width="145" height="145">
					</td>
				</tr>
				<tr>
					<td valign="top" align="center">
					<%=tpProduct.getProductName()%>
					</td>
				</tr>
			</table>
	</td>
	<%if(i % 5 == 4||i==SysContexts.groupList2.size()){
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