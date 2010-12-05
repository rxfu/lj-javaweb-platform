<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/common/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>index</title>
</head>
<body>
<table width="1000" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td valign="middle" align="right" background="${path}/imags/top_bg.gif" height="29">
		<c:choose>
			<c:when test="${username==anonymousUser}">
				<font color="#999999">欢迎来${sysName}！</font>
				<a href="${path}/sys/user/user!preLogin.action" >【请登录】</a>			</c:when>
			<c:otherwise>
				<font color="#999999"><ss:authentication property="name"/>！欢迎来${sysName}！</font> 
				<a href="${path}/j_spring_security_logout" >【退出】</a>			</c:otherwise>
		</c:choose>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="${path}/w/reg/reg!preAdd.action" style="color:red">【用户注册】</a>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;	</td>
  </tr>
  <tr>
    <td valign="middle" align="center" height="80"><img src="${path}/imags_up/top.jpg"/></td>
  </tr>
</table>
</body>
</html>