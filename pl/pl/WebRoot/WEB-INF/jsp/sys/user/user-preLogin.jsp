<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="org.springframework.security.web.authentication.AbstractProcessingFilter"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<title>用户登录</title>
		<script type="text/javascript">
		$(function(){
			$("#form1").validate({
				errorLabelContainer : $("#error"),
				rules : {
					"j_username" : {
						required : true,
						minlength : 5,
						maxlength : 20
					},
					"j_password" : {
						required : true,
						minlength : 6,
						maxlength : 16
					}
				},
				messages : {
					"j_username" : {
						required : "用户名必须输入<br/>",
						minlength : "用户名不能少于5个字符<br/>",
						maxlength : "用户名不能多于20个字符<br/>"
					},
					"j_password" : {
						required : "密码必须输入<br/>",
						minlength : "密码不能少于6个字符<br/>",
						maxlength : "密码不能多于16个字符<br/>"
					}
				}
			});
		});
		</script>
	</head>
	<body>
		<form id="form1" action="${path}/j_spring_security_check" method="post">
			<table width="100" border="1">
				<tr>
					<td>
						<s:textfield name="j_username"/>
					</td>
				</tr>
				<tr>
					<td>
						<s:password name="j_password"/>
					</td>
				</tr>
				<tr>
					<td>
						<div id="error" style="background: green"></div>
						<div style="background: green">
							<%
								if (session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY) != null) {
							%>
									<font color="red">${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}</font>
							<%
								}
							%>
						</div>
						
						<s:submit value="登录" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>