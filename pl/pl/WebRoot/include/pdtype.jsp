<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.pl.sys.SysContexts" %>
<%@page import="com.pl.web.w.pdtype.Pdtype" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
.my_left_category{
width:200px;
font-size:12px;
font-family:arial,sans-serif;
letter-spacing:2px;
}
.my_left_category h1{
background-image:url(${path}/imags/spring_06.gif);
height:20px;
background-repeat:no-repeat;
font-size:14px;
font-weight:bold;
padding-left:15px;
padding-top:8px;
margin:0px;
color:#FFF;
}
.my_left_category .my_left_cat_list{
width:198px;
border-color:#b60134;
border-style:solid;
border-width:0px 1px 1px 1px;
line-height:13.5pt;
}
.my_left_category .my_left_cat_list h2 {
margin:0px;
padding:3px 5px 0px 9px;
}
.my_left_category .my_left_cat_list h2 a {
color:#d6290b;
font-weight:bold;
font-size:14px;
line-height:22px;
}
.my_left_category .my_left_cat_list h2 a:hover {
color:#d6290b;
font-weight:bold;
font-size:14px;
line-height:22px;
}
.my_left_category .h2_cat{
width:198px;
height:26px;
background-image:url(${path}/imags/my_menubg.gif);
background-repeat:no-repeat;
line-height:26px;
font-weight:normal;
color:#333333;
position:relative;
}
.my_left_category .h2_cat_1{
width:198px;
height:26px;
background-image:url(${path}/imags/my_menubg_1.gif);
background-repeat:no-repeat;
line-height:26px;
font-weight:normal;
color:#333333;
position:relative;
}
.my_left_category a{
font:12px;
text-decoration:none;
color:#333333;
}
.my_left_category a:hover{
text-decoration:underline;
color:#ff3333;
}
.my_left_category h3{
margin:0px;
padding:0px;
height:26px;
font-size:12px;
font-weight:normal;
display:block;
padding-left:8px;
}
.my_left_category h3 span{color:#999999; width:145px; float:right;}
.my_left_category h3 a{	line-height:26px;}
.my_left_category .h3_cat{
display:none;
width:254px;
position:absolute;
left:123px;
margin-top:-26px;
cursor:auto;
}
.my_left_category .shadow{
position:inherit;
background:url(${path}/imags/shadow_04.gif) left top;
width:254px;
}
.my_left_category .shadow_border{
position:inherit;
width:250px;
border:1px solid #959595; margin-top:1px;
border-left-width:0px;
background:url(${path}/imags/shadow_border.gif) no-repeat 0px 21px;
background-color:#ffffff;
margin-bottom:3px
}
.my_left_category .shadow_border ul{margin:0; padding:0; margin-left:15px}
.my_left_category .shadow_border ul li {
list-style:none;
padding-left:10px;
background-image:url(${path}/imags/my_cat_sub_menu_dot.gif);
background-repeat:no-repeat;
background-position:0px 8px;
/*float:left;*/
width:75px;
height:26px;
overflow:hidden;
letter-spacing:0px;
}
.my_left_category .active_cat{ z-index:99;background-position:0 -25px;cursor:pointer;}
.my_left_category .active_cat h3 { font-weight:bold}
.my_left_category .active_cat h3 span{ display:none;}
.my_left_category .active_cat div{display:block;}
</style>
<script type="text/javascript">
var shoppingCartArray = []; 
function addCookie(pdName){
	$.cookie('shoppingCart', pdName);
}
function showCookie(){
	alert($.cookie('shoppingCart'));

}
</script>
</head>
<body>
<div class="my_left_category">
	<h1 align="center">所有商品类型 </h1>
	<div class="my_left_cat_list">
		<%for(Pdtype pdtypeTemp1:SysContexts.currentAllPdtype){%>
		<div class="h2_cat" onmouseover="this.className='h2_cat active_cat'" onmouseout="this.className='h2_cat'">
			<h3><a href="#" style="font-size: 14"><%=pdtypeTemp1.getPdtypeName1() %></a></h3>
			<div class="h3_cat">
			<div class="shadow">
			<div class="shadow_border">
			<ul>
			<%for(Pdtype pdtypeTemp2:pdtypeTemp1.getChildrens()){%>
				<li>
				<a href="${path}/w/pd/pd!listByGroup.action?pdType.seq=<%=pdtypeTemp2.getSeq() %>"><%=pdtypeTemp2.getPdtypeName2() %></a>
				</li>
			<%}%>
			</ul>
			</div>
			</div>
			</div>
		</div>
		<%}%>
	</div>
</div>
</body>
</html>