<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<script type="text/javascript">
	function logout() {
		if (confirm("你确定要退出吗？"))
			top.location = "out.asp";
		return false;
	}
</script>
<head>
<title>系统管理</title>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base target="main">
<link href="../css/skin.css" rel="stylesheet" type="text/css">
</head>
<body leftmargin="0" topmargin="0">
<table width="100%" height="64" border="0" cellpadding="0"
	cellspacing="0" style="	background-image: url(../images/top-right.gif);background-repeat: repeat-x;">
	<tr>
		<td width="61%" height="64"><img src="../images/logo.gif"
			width="262" height="64"></td>
		<td width="39%" valign="top">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="74%" height="38" class="admin_txt">欢迎 <b> 熊庆春 </b> 登录</td>
				<td width="22%"><a href="#" target="_self" onClick="logout();">
				<img src="../images/out.gif" alt="退出登录" width="46" height="20"
					border="0"> </a></td>
				<td width="4%">&nbsp;</td>
			</tr>
			<tr>
				<td height="19" colspan="3">&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html>
