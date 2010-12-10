<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
<%@ taglib prefix="aa" uri="/WEB-INF/ajaxanywhere.tld" %>
<%@ taglib prefix="ss" uri="http://www.springframework.org/security/tags" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<c:set var="ajaxInvoke" scope="request">ajaxPaginationInvoke</c:set>
<c:set var="anonymousUser" value="anonymousUser"/>
<c:set var="sysName" value="x网"/>

<ss:authentication property="name" scope="request" var="username"/>

<link rel="stylesheet" type="text/css" href="${path}/css/cmxform.css"/>
<link rel="stylesheet" type="text/css" href="${path}/css/default.css"/>
<script type="text/javascript" src="${path}/js/jquery-1.4.2.min.js" /></script>
<script type="text/javascript" src="${path}/js/jquery.metadata.js" /></script>
<script type="text/javascript" src="${path}/js/jquery.validate.js" /></script>
<script type="text/javascript" src="${path}/js/cmxforms.js" /></script>
<script type="text/javascript" src="${path}/js/aa.js"/></script>
<script type="text/javascript" src="${path}/js/json2.js"/></script>
<script type="text/javascript" src="${path}/js/public.js"/></script>

