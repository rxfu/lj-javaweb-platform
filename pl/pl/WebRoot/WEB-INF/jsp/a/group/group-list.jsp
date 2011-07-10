<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<title>产品组管理</title>
	</head>
	<body>
		<s:form id="form1" action="group!list.action">
			<table width="100%" align="center">
				<tr>
					<td colspan="2">
						查询
					</td>
				</tr>
				<tr>
					<td width="10" nowrap="nowrap">
						产品组：
					</td>
					<td align="left">
						<s:select list="#{1:'每周热销',2:'今日热销'}" name="tpProductBean.groupId"></s:select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="errorShow" style="background: green" style="color: red">
							<s:actionerror theme="simple" />
						</div>
						<div id="errorShow" style="background: green">
							<s:actionmessage theme="simple" />
						</div>
						<s:submit value="提交" />
					</td>
				</tr>
			</table>
		</s:form>
		<aa:zone name="refreshZone">
		<table width="100%" align="center" border="1">
			<s:iterator value="#request.reList" id="tpProduct">
				<tr>
					<td>
						<s:property value="#tpProduct.seq" />
					</td>
					
					<td>
						<s:property value="#tpProduct.productId" />
					</td>
					<td>
						<s:property value="#tpProduct.productNameSimple" />
					</td>
					<td>
						<img  src="${path}/uploads/${imagfileFileName}" width="145" height="145">
					</td>
				</tr>
			</s:iterator>
		</table>
		<c:if test="${firstFlag!=1}">
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
		</c:if>
		</aa:zone>
	</body>
</html>