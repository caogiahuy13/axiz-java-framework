<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="page.selectResult.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<table>
		<caption>
			<fmt:message key="page.selectResult.table.caption" />
		</caption>
		<thead>
			<tr>
				<th><fmt:message key="page.selectResult.table.header.loginId" /></th>
				<th><fmt:message key="page.selectResult.table.header.userName" /></th>
				<th><fmt:message key="page.selectResult.table.header.tel" /></th>
				<th><fmt:message key="page.selectResult.table.header.role" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${fn:escapeXml(user.loginId)}</td>
					<td>${fn:escapeXml(user.userName)}</td>
					<td>${fn:escapeXml(user.telephone)}</td>
					<td>${fn:escapeXml(user.roleName)}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div>
		<a href="menu"><fmt:message key="btn.returnToMenu" /></a>
	</div>
</body>
</html>
