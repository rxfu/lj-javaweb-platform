<%@ page contentType="text/html; charset=utf-8" language="java"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>用户组管理</title>
<link rel="stylesheet" type="text/css" href="../css/plcss.css">
<style type="text/css">
</style>
</head>
<body bgcolor="#F7F8F9">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td class="td_bodyl" height="25">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您现在的位置:系统-系统管理-用户组管理</td>
  </tr>
</table>
<table width="100%" border="0" align="center" cellpadding="0"
	cellspacing="0" bgcolor="#F7F8F9">
  <tr>
		<td height="30">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="15" height="30"><img src="../images/tab_03.gif"
					width="15" height="30" /></td>
				<td class="td_titleTop">用户组列表</td>
				<td width="14"><img src="../images/tab_07.gif" width="14" height="30" /></td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="9" background="../images/tab_12.gif">&nbsp;</td>
				<td bgcolor="#F4FBFF">
				<table width="99%" border="0" align="center" cellpadding="0"
					cellspacing="1" bgcolor="#CECECE">
					<tr>
						<td width="6%" class="td_title1">
						选择<input name="checkbox" type="checkbox" class="STYLE2" value="checkbox" />
						</td>
						<td width="8%" class="td_title1">
						序号
						</td>
						<td width="24%" class="td_title1">
						用户组名称
						</td>
						<td width="15%"class="td_title1">
						权限配置
						</td>
						<td width="15%"class="td_title1">
						名称编辑
						</td>
						<td width="15%"class="td_title1">
						删除
						</td>
					</tr>
					<s:iterator value="groupList" id="groupBean" status="status">
					<tr>
						<td class="td_bodyc">
						<input name="checkbox"
							type="checkbox" class="STYLE2" value="checkbox" />
						</td>
						<td class="td_bodyc">
						<s:property value="#status.index+1"/>
						</td>
						<td class="td_bodyc">
						<s:property value="#groupBean.groupName"/>
						</td>
						<td class="td_bodyc">
						[<a href="#">权限配置</a>]
						</td>
						<td class="td_bodyc">
						<img src="../images/037.gif" width="9" height="9" />[<a href="#">编辑</a>]
						</td>
						<td class="td_bodyc">
						<img src="../images/010.gif" width="9" height="9" />[<a href="#">删除</a>]
						</td>
					</tr>
					</s:iterator>
				</table>
				</td>
				<td width="9" background="../images/tab_16.gif">&nbsp;</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td height="29">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="15" height="29"><img src="../images/tab_20.gif"
					width="15" height="29" /></td>
				<td background="../images/tab_21.gif">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="40%" class="td_bodyc" align="left">
						共120条纪录，当前第1/10页，每页10条纪录
						</td>
						<td width="60%" class="STYLE1">&nbsp;</td>
					</tr>
				</table>
				</td>
				<td width="14"><img src="../images/tab_22.gif" width="14"
					height="29" /></td>
			</tr>
		</table>
		</td>
	</tr>
</table>
</body>
</html>
