			<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
				<pg:param name="pager.items" value="${pager.items}"/>
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