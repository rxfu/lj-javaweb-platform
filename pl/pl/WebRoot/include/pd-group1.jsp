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
<table border="0" cellspacing="0" cellpadding="0">
<%
	for (int i = 0; i < SysContexts.groupList1.size(); i++) {
	TpProduct tpProduct = SysContexts.groupList1.get(i);
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