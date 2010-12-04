<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="org.springframework.security.web.authentication.AbstractProcessingFilter"%>
<%@ page import="org.springframework.security.web.authentication.AuthenticationProcessingFilter"%>
<%@ page import="org.springframework.security.core.AuthenticationException"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<title>Insert L here</title>
	</head>
	<body>
	<%
		if (session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null) {
		%>
			<span style="color:red"> 登录失败，请重试.</span>
	<%
		}
	%>
		<form name="form1" action="${path}/j_spring_security_check" method="post">
		
		
			<table width="100" border="1">
				<tr>
					<td>
						<s:textfield name="j_username"/>1
					</td>
				</tr>
				<tr>
					<td>
						<s:textfield name="j_password"/>
					</td>
				</tr>
				<tr>
					<td>
						<s:submit label="提交1" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>