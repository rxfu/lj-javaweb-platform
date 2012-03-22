<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp" %>
		<title>产品类别管理</title>
	</head>
	<body>
		<s:form id="form1" action="pdtype!list.action">
			<table width="100%" align="center">
				<tr>
					<td colspan="2">
						查询
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
						<s:submit value="查询" />
					</td>
				</tr>
			</table>
		</s:form>
		<aa:zone name="refreshZone">
			<table width="100%" align="center" border="1">
				<s:iterator value="#request.reList" id="pdtype1">
					<s:iterator value="#pdtype1.childrens" id="pdtype2">
						<s:iterator value="#pdtype2.childrens" id="pdtype3">
							<tr>
								<td>
									<s:property value="#pdtype1.pdtypeName1" />
								</td>
								<td>
									<s:property value="#pdtype2.pdtypeName2" />
								</td>
								<td>
									<s:property value="#pdtype3.pdtypeName3" />
								</td>
							</tr>
						</s:iterator>
					</s:iterator>
				</s:iterator>
				<tr>
					<td>
						<a href="${path}/a/pdtype/pdtype!preSave.action?saveFlag=insert" target="_top">添加一级类别</a>
					</td>
					<td>
						<a href="${path}/a/pdtype/pdtype!preSave.action?saveFlag=insert" target="_top">添加二级类别</a>
					</td>
					<td>
						<a href="${path}/a/pdtype/pdtype!preSave.action?saveFlag=insert" target="_top">添加三级类别</a>
					</td>
				</tr>
			</table>
			<c:if test="${firstFlag!=1}">
				<table>
					<tr>
						<td colspan="3">
							<pg:pager url="${path}/a/pdtype/pdtype!list.action"
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