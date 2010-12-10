<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<title>产品添加</title>
		<script type="text/javascript">
ajaxAnywhere.formName = "form1";

function ajaxPaginationInvoke(url) {
	document.form1.action = url;
	ajaxAnywhere.submitAJAX();
}

ajaxAnywhere.onAfterResponseProcessing = function() {
	document.form1.submit();
}
</script>
	</head>
	<body>
		<table width="100%" align="center">
			<tr>
				<td>
					<a href="${path}/a/product/product!preSave.action?saveFlag=insert" target="_top">产品添加</a>
				</td>
			</tr>
		</table>
		<s:form id="form1" action="product!list.action">
			<table width="100%" align="center">
				<tr>
					<td colspan="2">
						查询
					</td>
				</tr>
				<tr>
					<td>
						id
					</td>
					<td>
						<s:textfield name="tpProduct.productId" />
					</td>
				</tr>
				<tr>
					<td>
						简称
					</td>
					<td>
						<s:textfield name="tpProduct.productNameSimple" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<s:submit value="提交" />
					</td>
				</tr>
			</table>
		</s:form>
		<table width="100%" align="center" border="1">
			<s:iterator value="#request.reList" id="tpProduct">
			<tr>
				<td>
					<a href="${path}/a/product/product!preSave.action?saveFlag=update&tpProduct.productId=${productId}">编辑
					</a>
				</td>
				<td>
					<s:property value="#tpProduct.productId" />
				</td>
				<td>
					<s:property value="#tpProduct.productNameSimple" />
				</td>
			</tr>
			</s:iterator>
		</table>
		<table>
			<tr>
				<td colspan="3">
					<pg:pager url="${path}/a/product/product!list.action" 
					items="${pager.items}" maxPageItems="${pager.maxPageItems}"
					export="currentPageNumber=pageNumber" scope="request">
						<%@include file="/common/pager.jsp"%>
					</pg:pager>
				</td>
			</tr>
		</table>
	</body>
</html>