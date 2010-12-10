			
			<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
			<%@ taglib prefix="pg" uri="http://jsptags.com/tags/navigation/pager"%>
			<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
				<pg:param name="pager.items" value="${pager.items}"/>
				<pg:first>
			        <a href="javascript:{${ajaxInvoke}('${pageUrl }');}">首页</a>
			    </pg:first>
				<pg:prev>
					<a href="javascript:{${ajaxInvoke}('${pageUrl }');}">上一页</a>
				</pg:prev>
				<pg:pages>
					<c:choose>
						<c:when test="${pageNumber eq currentPageNumber }">
							<font color="red">${pageNumber }</font>
						</c:when>
						<c:otherwise>
							<a href="javascript:{${ajaxInvoke}('${pageUrl }');}">[${pageNumber}]</a>
						</c:otherwise>
					</c:choose>
				</pg:pages>
				<pg:next>
					<a href="javascript:{${ajaxInvoke}('${pageUrl }');}">下一页</a>
				</pg:next>
				<pg:last>
					<a href="javascript:{${ajaxInvoke}('${pageUrl }');}">尾页</a>
				</pg:last>