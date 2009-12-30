<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<link rel="stylesheet" type="text/css" href="../css/menustyle.css">
<link rel="stylesheet" type="text/css" href="../css/menu.css">
<head>
<title>菜单</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body class="panel" topmargin="0" leftmargin="0">
<div id="body">
<s:actionerror/>
<!-- OA树开始--> 
<a id="expand_link" href="javascript:menu_expand();"><u><span id="expand_text">展开</span></u></a>
<ul id="menu">
	<!-- 循环一级菜单 -->
	<s:iterator value="menuList" id="menuTop" >
		<li class="L1">
		<a href="javascript:c(mtop<s:property value="menuId"/>);" id="mtop<s:property value="menuId"/>">
			<span>
				<img src="../images/ico/2.gif" align="middle" /> <s:property value="menuName"/>
			</span>
		</a>
		</li>
		<!-- 循环二级菜单 -->
		<ul id="mtop<s:property value="menuId"/>d" style="display: none;" class="U1">
			<s:iterator value="subTsMenuBeanList" id="tsMenuBean2">
				<s:if test='menuType=="P"' >
					<li class="L21">
						<a href="javascript:c(f<s:property value="menuId"/>);" id="f<s:property value="menuId"/>">
							<span>
								<img src="../images/ico/2.gif" align="Middle" /> <s:property value="menuName"/>
							</span>
						</a>
					</li>
					<!-- 循环三级菜单 -->
					<ul id="f<s:property value="menuId"/>d" style="display: none;">
						<s:iterator value="subTsMenuBeanList" id="tsMenuBean3">
							<s:if test='menuType=="N"' >
								<li class="L3">
									<a href="<%=request.getContextPath()%><s:property value="menuUrl"/>" target="main" onclick="set_current('f<s:property value="menuId"/>')" id="f<s:property value="menuId"/>">
										<span>
											<img src="../images/ico/2.gif" align="Middle" /> <s:property value="menuName"/>
										</span>
									</a>
								</li>
							</s:if>
							<s:if test='menuType=="S"' >
								<li class="Ls">
								<a class="setting" href="<%=request.getContextPath()%><s:property value="menuUrl"/>" id="f<s:property value="menuId"/>"><s:property value="menuName"/></a>
								</li>
							</s:if>
						</s:iterator>
					</ul>
				</s:if>
				<s:if test='menuType=="N"' >
					<li class="L22">
						<a href="<%=request.getContextPath()%><s:property value="menuUrl"/>" target="main" onclick="set_current('f<s:property value="menuId"/>')" id="f<s:property value="menuId"/>">
							<span>
								<img src="../images/ico/2.gif" align="Middle" /> <s:property value="menuName"/>
							</span>
						</a>
					</li>
				</s:if>
				<s:if test='menuType=="S"' >
					<li class="Ls">
					<a class="setting" href="<s:property value="menuUrl"/>" id="f<s:property value="menuId"/>"><s:property value="menuName"/></a>
					</li>
				</s:if>
			</s:iterator>
		</ul>
	</s:iterator>
</ul>
</div>
<div id="bottom"></div>

<script language="JavaScript">
	var cur_id = "";
	var flag = 0, sflag = 0;

	//-------- 菜单点击事件 -------
	function c(srcelement) {
		var targetid, srcelement, targetelement;
		var strbuf;

		//-------- 如果点击了展开或收缩按钮---------
		targetid = srcelement.id + "d";
		targetelement = document.getElementById(targetid);

		if (targetelement.style.display == "none") {
			srcelement.className = "active";
			targetelement.style.display = '';

			menu_flag = 0;
			expand_text.innerHTML = "收缩";
		} else {
			srcelement.className = "";
			targetelement.style.display = "none";

			menu_flag = 1;
			expand_text.innerHTML = "展开";
			var links = document.getElementsByTagName("A");
			for (i = 0; i < links.length; i++) {
				srcelement = links[i];
				if (srcelement.parentNode.className.toUpperCase() == "L1"
						&& srcelement.className == "active"
						&& srcelement.id.substr(0, 1) == "m") {
					menu_flag = 0;
					expand_text.innerHTML = "收缩";
					break;
				}
			}
		}
	}
	function set_current(id) {
		cur_link = document.getElementById(cur_id);
		if (cur_link)
			cur_link.className = "";
		cur_link = document.getElementById(id);
		if (cur_link)
			cur_link.className = "active";
		cur_id = id;
	}
	//add by YZQ 2008-03-05 begin
	function bindFunc() {
		var args = [];
		for ( var i = 0, cnt = arguments.length; i < cnt; i++) {
			args[i] = arguments[i];
		}
		var __method = args.shift();
		var object = args.shift();
		return ( function() {
			var argsInner = [];
			for ( var i = 0, cnt = arguments.length; i < cnt; i++) {
				argsInner[i] = arguments[i];
			}
			return __method.apply(object, args.concat(argsInner));
		});
	}
	var timerId = null;
	var firstTime = true;
	//add by YZQ 2008-03-05 end
	function d(URL, id) {
		//add by YZQ 2008-03-05 begin
		var winMgr = parent.parent.table_index.main.winManager;
		if (!winMgr) {
			if (firstTime) {
				parent.openURL("/fis/common/frame.jsp", 0);
				firstTime = false;
			}
			timerId = setTimeout(bindFunc(d, window, URL, id), 100);
			return;
		}
		firstTime = true;
		if (timerId) {
			clearTimeout(timerId);
		}
		if (winMgr) {
			winMgr.openActionPort("/fis/" + URL, document.getElementById("f"
					+ id).innerText);
			return;
		}
		//add by YZQ 2008-03-05 end

		set_current(id);
		URL = "/fis/" + URL;
		parent.openURL(URL, 0);
	}
	//-------- 菜单全部展开/收缩 -------
	var menu_flag = 1;
	function menu_expand() {
		if (menu_flag == 1)
			expand_text.innerHTML = "收缩";
		else
			expand_text.innerHTML = "展开";

		menu_flag = 1 - menu_flag;

		var links = document.getElementsByTagName("A");
		for (i = 0; i < links.length; i++) {
			srcelement = links[i];
			if (srcelement.parentNode.className.toUpperCase() == "L1"
					|| srcelement.parentNode.className.toUpperCase() == "L21") {
				targetelement = document.getElementById(srcelement.id + "d");
				if (menu_flag == 0) {
					targetelement.style.display = '';
					srcelement.className = "active";
				} else {
					targetelement.style.display = "none";
					srcelement.className = "";
				}
			}
		}
	}
	//-------- 打开windows程序 -------
	function winexe(NAME, PROG) {
		URL = "/general/winexe?PROG=" + PROG + "&NAME=" + NAME;
		window
				.open(
						URL,
						"winexe",
						"height=100,width=350,status=0,toolbar=no,menubar=no,location=no,scrollbars=yes,top=0,left=0,resizable=no");
	}
</script>
</body>
</html>