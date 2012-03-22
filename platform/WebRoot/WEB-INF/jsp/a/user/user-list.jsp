<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@ include file="/common/taglibs.jsp"%>
		<title>用户管理</title>
	</head>
	<body>
		<table width="100%" align="center">
			<tr>
				<td>
					<a href="${path}/a/user/user!preSave.action?saveFlag=insert"
						target="_top">用户添加</a>
				</td>
			</tr>
		</table>

		<s:form id="form1" action="user!list.action">
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
						<s:textfield name="tsUser.userId" />
					</td>
				</tr>
				<tr>
					<td>
						用户名
					</td>
					<td>
						<s:textfield name="tsUser.username" />
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
				<s:iterator value="#request.reList" id="tsUser">
					<tr>
						<td>
							<a
								href="${path}/a/user/user!preSave.action?saveFlag=update&tsUser.userId=${userId}">编辑
							</a>
						</td>
						<td>
							<a
								href="${path}/a/user/user!deleteOne.action?tsUser.userId=${userId}">删除
							</a>
						</td>
						<td>
							<s:property value="#tsUser.userId" />
						</td>
						<td>
							<s:property value="#tsUser.username" />
						</td>
						<td>
							<s:property value="#tsUser.email" />
						</td>
						<td>
							<s:property value="#tsUser.groupId" />
						</td>
					</tr>
				</s:iterator>
			</table>
			<c:if test="${firstFlag!=1}">
				<table>
					<tr>
						<td colspan="3">
							<pg:pager url="${path}/a/user/user!list.action"
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