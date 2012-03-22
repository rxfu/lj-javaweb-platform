<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<title>产品组管理</title>
<script type="text/javascript">
function submitForm2(valStr){
	if(valStr == "edit" && $("input[name='num']").val() == ""){
		alert("请输入移动量");
		return;
	}
	$("input[name='actionType']").val(valStr);
	alert($("input[name='actionType']").val());
	alert($("input[name='num']").val());
	$("#form2").submit();
}
</script>
	</head>
	<body>
		<s:form id="form1" action="group!list.action">
			<table width="100%" align="center">
				<tr>
					<td colspan="2">
						查询
					</td>
				</tr>
				<tr>
					<td width="10" nowrap="nowrap">
						产品组：
					</td>
					<td align="left">
						<s:select list="#{1:'每周热销',2:'今日热销'}" name="tpProductBean.groupId"></s:select>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<div id="errorShow" style="background: green" style="color: red">
							<s:actionerror theme="simple" />
						</div>
						<div id="errorShow" style="background: green">
							<s:actionmessage theme="simple" />
						</div>
						<s:submit value="查询" />
					</td>
				</tr>
			</table>
		</s:form>
		<s:form id="form2" action="group!edit.action">
		<aa:zone name="refreshZone">
		<table width="100%" align="center" border="1">
			<tr>
				<td colspan="6">
					<s:hidden name="tpProductBean.groupId"/>
					<s:hidden name="actionType"/>
					移动量:<s:textfield name="num" value="1"/>
					<input type="button" value="移动" onclick="submitForm2('edit')">
					<input type="button" value="关联" onclick="submitForm2('add')">
					<input type="button" value="取消关联" onclick="submitForm2('del')">
				</td>
			</tr>
			<tr>
				<td >全选 <s:checkbox name="selectAll" onclick="selectBoxSelectAll(this,'productIds')"></s:checkbox></td>
				<td >关联</td>
				<td >顺序号</td>
				<td >产品ID</td>
				<td >产品简称</td>
				<td >图片</td>
			</tr>
			<s:iterator value="#request.reList" id="tpProduct">
				<tr>
					<td>
						<s:checkbox name="productIds" fieldValue="%{#tpProduct.seq}"></s:checkbox></td>
					<td>
						<s:if test='(#tpProduct.groupId != null)'><font color="greed">已关联</font></s:if>
						<s:else><font color="red">未关联</font></s:else>
					</td>
					<td>
						<s:property value="#tpProduct.seq" />
					</td>
					<td>
						<s:property value="#tpProduct.productId" />
					</td>
					<td>
						<s:property value="#tpProduct.productNameSimple" />
					</td>
					<td>
						<img  src="${path}/uploads/${imagfileFileName}" width="145" height="145">
					</td>
				</tr>
			</s:iterator>
		</table>
		<c:if test="${firstFlag!=1}">
			<table>
				<tr>
					<td colspan="3">
						<pg:pager url="${path}/a/product/product!list.action"
							items="${pager.items}" maxPageItems="${pager.maxPageItems}"
							export="currentPageNumber=pageNumber" scope="request">
							<%@include file="/common/pager.jsp"%>
						</pg:pager>
					</td>
				</tr>
			</table>
		</c:if>
		</aa:zone>
		</s:form>
	</body>
</html>