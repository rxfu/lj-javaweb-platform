<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<title>Insert title here</title>
		
		<script type="text/javascript">
				ajaxAnywhere.formName = "form1";
			
				function ajaxPaginationInvoke(url){
				    document.form1.action=url;
				    ajaxAnywhere.submitAJAX();
				}
				
				ajaxAnywhere.onAfterResponseProcessing= function (){
					document.form1.submit();
				}
		</script>
	</head>
	<body>
	<s:form name="form1" action="user!list" method="post">
		<table width="100" border="1">
			<tr>
				<td>
				<s:textfield name="userBean.name"/>
				<s:submit label="提交1"/>
				</td>
			</tr>
		</table>
	</s:form>
		<table width="100" border="1">
			<tr>
				<td>
					id
				</td>
				<td>
					名称
				</td>
			</tr>
			<s:iterator value="#request.reList" id="userBean">
				<tr>
					<td>
						<s:property value="#userBean.id" />
					</td>
					<td>
						<s:property value="#userBean.name" />
					</td>
					<td>
						${pager.items}
					</td>
				</tr>
			</s:iterator>
			<pg:pager url="${path}/sys/user/user!list.action" 
			items="${pager.items}" maxPageItems="${pager.maxPageItems}"
			export="currentPageNumber=pageNumber" scope="request">
				<%@include file="/common/pager.jsp"%>
			</pg:pager>
		</table>
	</body>
</html>