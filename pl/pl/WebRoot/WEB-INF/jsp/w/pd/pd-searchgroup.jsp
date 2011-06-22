<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="${path}/js/jquery.cookie.js"/></script>
<c:set var="size" value="${fn:length(reList)}" scope="request"/>
</head>
<style type="text/css">
.xxtd{BORDER-BOTTOM: #000000 1px dotted;}
</style>
<body>
<%@include file="/include/top.jsp"%>
<%@include file="/include/top1.jsp"%>
<div align="center">
	<table width="1000" border="0" cellspacing="3" cellpadding="0">
		<tr>
			<td width="200" valign="top"><%@include file="/include/pdtype.jsp"%></td>
			<td width="10" valign="top">&nbsp; </td>
			<td width="790" valign="top">
				<table width="790" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td colspan="10" align="left">
							<table width="795"  border="0"  cellspacing="0" cellpadding="0">
								<tr>
									<td width="3"><img src="${path}/imags/title_bg1.png"/></td>
									<td width="100" background="${path}/imags/title_bg2.png" nowrap="nowrap" align="center" style="font-size: 15;color: white;"><strong> 产&nbsp;品&nbsp;列&nbsp;表</strong></td>
									<td width="4"><img src="${path}/imags/title_bg3.png"/></td>
									<td background="${path}/imags/title_bg4.png" colspan="10">&nbsp;</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td>
						<c:forEach items="${reList}" var="products" varStatus="status">
								<span>
										<a href="${path}/w/pd/pd!searchById.action?tpProduct.productId=${products.productId}" target="_top">
											<img src="${path}/uploads/${products.imagfileFileName}" width="145" height="145" border="0"/>
										</a>
										<br/>
										<a href="${path}/w/pd/pd!searchById.action?tpProduct.productId=${products.productId}" target="_top">
											<c:out value="${products.productName}"/>
										</a>
								</span>
						</c:forEach>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

</body>
</html>