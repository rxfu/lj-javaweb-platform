<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<title>注册-个人用户</title>
		<script type="text/javascript">
		$(function(){
			$("#form1").validate({
				errorLabelContainer : $("#error"),
				rules : {
					"tsUser.username" : {
						required : true,
						minlength : 5,
						maxlength : 20
					},
					"tsUser.password" : {
						required : true,
						minlength : 6,
						maxlength : 16
					},
					"tsUser.passwordConfirm" : {
						required : true,
						equalTo : "#form1_tsUser_password"
					},
					"tsUser.email" : {
						required : true,
						email : "#form1_tsUser_password"
					}
				},
				messages : {
					"tsUser.username" : {
						required : "用户名必须输入<br/>",
						minlength : "用户名不能少于5个字符<br/>",
						maxlength : "用户名不能多于20个字符<br/>"
					},
					"tsUser.password" : {
						required : "密码必须输入<br/>",
						minlength : "密码不能少于6个字符<br/>",
						maxlength : "密码不能多于16个字符<br/>"
					},
					"tsUser.passwordConfirm" : {
						required : "确认密码必须输入<br/>",
						equalTo : "两次输入的密码不一致<br/>"
					},
					"tsUser.email" : {
						required : "邮箱地址必须输入<br/>",
						email : "邮箱地址格式不正确<br/>"
					}
				}
			});
			
			$("#checkUser").click( function() {
					alert(1);
			});
		});
		function abc()
		{
			 var params = {   
					username:$("input[name='tsUser.username']").val()
					};
			var url = "${path}/w/reg/json-user!jsonUserExisted.action"
			jQuery.post(url, params, callbackFun, 'json');
 
		}
		function callbackFun(date){
			alert(date.flag);
		}

		</script>
	</head>
	<body>
		<table width="100%" align="center">
			<s:form id="form1" action="reg!add">
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<s:textfield name="tsUser.username" /><input type="button" id="checkUser1" onclick="abc()" value="检查用户"> 
				  	</td>
				</tr>
				<tr>
					<td height="28">
						密码：
					</td>
					<td>
						<s:password name="tsUser.password" />
					</td>
				</tr>
				<tr>
					<td>
						确认密码：
					</td>
					<td>
						<s:password  name="tsUser.passwordConfirm" />
					</td>
				</tr>
				<tr>
					<td>
						电子邮件：
					</td>
					<td>
						<s:textfield name="tsUser.email" />
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