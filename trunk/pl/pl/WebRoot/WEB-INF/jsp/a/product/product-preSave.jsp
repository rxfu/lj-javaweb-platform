<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@include file="/common/taglibs.jsp"%>
		<script type="text/javascript" src="${path}/ckeditor/ckeditor.js"/></script>
		<title>产品保存</title>
	</head>
	<body>
	<s:form id="form1" action="product!save.action">
	<s:hidden name="saveFlag"/>
	<s:hidden name="tpProduct.productId"/>
		<table width="100%" align="center">
			<tr>
				<td colspan="2" align="center">
					保存
				</td>
			</tr>
			<tr>
				<td>简称</td>
				<td><s:textfield name="tpProduct.productNameSimple"/></td>
			</tr>
			<tr>
				<td>显示名称</td>
				<td><s:textfield name="tpProduct.productName"/></td>
			</tr>
			<tr>
				<td>封面图片</td>
				<td><s:textfield name="tpProduct.imagfilename"/></td>
			</tr>
			<tr>
				<td>单位</td>
				<td><s:textfield name="tpProduct.unit"/></td>
			</tr>
			<tr>
				<td>单位重量</td>
				<td><s:textfield name="tpProduct.unitWeight"/></td>
			</tr>
			<tr>
				<td>成本价(元)</td>
				<td><s:textfield name="tpProduct.priceCost"/></td>
			</tr>
			<tr>
				<td>人个售价(元)</td>
				<td><s:textfield name="tpProduct.priceSellP"/></td>
			</tr>
			<tr>
				<td>企业售价(元)</td>
				<td><s:textfield name="tpProduct.priceSellE"/></td>
			</tr>
			<tr>
				<td>场市价(元)</td>
				<td><s:textfield name="tpProduct.priceMarket"/></td>
			</tr>
			<tr>
				<td>库存量</td>
				<td><s:textfield name="tpProduct.inventory"/></td>
			</tr>
			<tr>
				<td>牌品</td>
				<td><s:textfield name="tpProduct.brand"/></td>
			</tr>
			<tr>
				<td>介绍</td>
				<td><s:textarea name="tpProduct.productIntroduction" cssClass="ckeditor" rows="20" cols="2"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<div id="errorShow" style="background: green" style="color: red"><s:actionerror theme="simple"/></div>
					<s:submit value="提交" />
				</td>
			</tr>
		</table>
	</s:form>
	</body>
</html>