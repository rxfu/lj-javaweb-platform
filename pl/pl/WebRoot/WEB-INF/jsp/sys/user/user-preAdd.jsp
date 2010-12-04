<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<script type="text/javascript" src="${path}/ckeditor/ckeditor.js"/></script>
		<title>Insert title here</title>
		<script type="text/javascript">
$(function() {
	$("#form1").validate( {
		errorLabelContainer : $("#error"),
		rules : {
			"userBean.id" : {
				required : true,
				min : 10
			},
			"userBean.name" : {
				required : true,
				minlength : 5
			}
		},
		messages : {
			"userBean.id" : {
				required : "ABC 必须输入<br/>",
				min : "最好输入10个长度<br/>"
			},
			"userBean.name" : {
				required : "必须输入名稱<br/>",
				minlength : "最少輸入5"
			}
		}
	});
});
</script>
	</head>
	<body>
		<table width="100%">
			<s:form id="form1" action="user!add">
				<tr>
					<td>
						用户id：
					</td>
					<td>
						<s:textfield name="userBean.id" />
					</td>
				</tr>
				<tr>
					<td>
						用户name：
					</td>
					<td>
					</td>
				</tr>
				<tr>
					<td>
						密码：
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						密码确认
					</td>
					<td>
						&nbsp;
					</td>
				</tr>
				<tr>
					<td>
						电子邮件
					</td>
					<td>
						<textarea name="ckeditor1" Class="ckeditor" rows="20" cols="2"></textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="error" style="background: green"></div>
						<s:submit label="提交" />
					</td>
				</tr>
			</s:form>
		</table>
	</body>
</html>