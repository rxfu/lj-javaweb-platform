<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<SCRIPT type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.3.2.min.js"></SCRIPT>
<SCRIPT type="text/javascript">
	$(onloadFunction);
	function onloadFunction(){
		$("#back").click(function() {
			history.go(-1);
		});
	}
</SCRIPT>
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td align="center" style="color: red">错误:<br/><s:actionerror /><s:actionmessage /></td>
	</tr>
		<tr>
		<td  align="center"><input type="button" id="back" name="back" value="后退" style="height: 60;width: 90;font-size: 19"/></td>
	</tr>
</table>
</body>
</html>