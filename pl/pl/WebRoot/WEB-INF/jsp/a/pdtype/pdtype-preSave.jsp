<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@ include file="/common/taglibs.jsp" %>
<title>类别添加</title>
</head>
<body>
<s:form id="form1" action="pdtype!save.action" method="POST">
	<s:hidden name="saveFlag"/>
	<s:hidden name="pdtype.seq"/>
		<table width="100%" align="center">
			<tr>
				<td colspan="2" align="center">
					保存
				</td>
			</tr>
			<tr>
				<td>类别名称</td>
				<td><s:textfield name="pdtype.pdtypeName1"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="errorShow" style="background: green" style="color: red"><s:actionerror theme="simple"/></div>
					<s:submit value="保存" />
				</td>
			</tr>
		</table>
	</s:form>
</body>
</html>