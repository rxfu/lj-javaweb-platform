<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<%@include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="${path}/js/jquery.cookie.js"/></script>
<script language="javascript">
	$(function(){
		$("input[name='addCookie']").click(function () { 
			var buyCardArray;
			if(null == $.cookie('buyCard')){
				buyCardArray = new Array();
			}else{
				buyCardArray = $.cookie('buyCard').split(",");
			}
			buyCardArray.push($(this).attr("id"));
			buyCardArray = unique(buyCardArray);
			$.cookie('buyCard', buyCardArray);
			alert("商品已经成功添加到您的购物车中");
		 }); 
		$("input[name='showCookie']").click(function () { 
			alert($.cookie('buyCard'));
 		});
	 });

	function unique(data){   
	    data = data || [];   
	        var a = {};   
	    for (var i=0; i<data.length; i++) {   
	        var v = data[i];   
	        if (typeof(a[v]) == 'undefined'){   
	            a[v] = 1;   
	        }   
	    };   
	    data.length=0;   
	    for (var i in a){   
	        data[data.length] = i;   
	    }   
	    return data;   
} 
</script>
</head>
<body>
<%@include file="/include/top.jsp"%>
<%@include file="/include/top1.jsp"%>
<div align="center">
	<table width="1000" border="0" cellspacing="3" cellpadding="0">
		<tr>
			<td width="200" valign="top"><%@include file="/include/pdtype.jsp"%></td>
			<td width="10" valign="top">&nbsp; </td>
			<td width="790" valign="top">
				<table width="790" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td align="center" style="font-size: x-large;font-family:'黑体'; " colspan="2">
							<br/><s:property value="tpProduct.productName"/><br/><br/>
						</td>
					</tr>
					<tr>
						<td width="350">
							<img src="${path}/uploads/${tpProduct.imagfileFileName}" width="350" height="350" border="1" style="border:1px  dotted  #001403;">
						</td>
						<td valign="top" align="left">
							<table border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="100" align="right" height="50" style="font-family:'黑体';font-size: 13">建议零售价:</td><td style="color:#990000;font-size: 15">${tpProduct.priceSellP}</td>
								</tr>
								<tr>
									<td align="right" height="50" style="font-family:'黑体';font-size: 13">添加批发价:</td><td style="color:#990000;font-size: 15">${tpProduct.priceSellE}</td>
								</tr>
								<tr>
									<td align="right" height="50" style="font-family:'黑体';font-size: 13">产品编号:</td><td style="color:#000000;font-size: 14">${tpProduct.productId}</td>
								</tr>
								<tr>
									<td align="right" height="50" colspan="2">
									<!-- 
									<input type="button" value="add1" name="addCookie" id="${tpProduct.productId}"/>
									<input type="button" value="show" name="showCookie" />
									 -->
									<!-- <img src="${path}/imags/addToCart.jpg" width="150" /> -->
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="20" colspan="2">&nbsp; </td>
					</tr>
					<tr>
						<td colspan="2" align="left">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="3"><img src="${path}/imags/title_bg1.png"/></td>
									<td width="100" background="${path}/imags/title_bg2.png" nowrap="nowrap" align="center" style="font-size: 15;color: white;"><strong> 产&nbsp品&nbsp介&nbsp绍</strong></td>
									<td width="4"><img src="${path}/imags/title_bg3.png"/></td>
									<td background="${path}/imags/title_bg4.png" width="683" width="99%">&nbsp</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td height="20" colspan="2" width="790">
							${tpProduct.productIntroduction}
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>

</body>
</html>