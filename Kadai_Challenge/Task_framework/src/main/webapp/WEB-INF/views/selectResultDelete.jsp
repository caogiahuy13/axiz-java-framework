<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="page.selectResultDelete.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>下記のデータを削除します。</p>
	<p>よろしいですか？</p>

	<table>
		<caption>
			<fmt:message key="page.selectResultDelete.table.caption" />
		</caption>
		<thead>
			<tr>
				<th><fmt:message key="page.selectResult.table.header.loginId" /></th>
				<th><fmt:message key="page.selectResult.table.header.userName" /></th>
				<th><fmt:message key="page.selectResult.table.header.tel" /></th>
				<th><fmt:message key="page.selectResult.table.header.role" /></th>
				<th><fmt:message
						key="page.selectResult.table.header.createDate" /></th>
				<th><fmt:message
						key="page.selectResult.table.header.updateDate" /></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${usersToDelete}">
				<tr>
					<td>${fn:escapeXml(user.loginId)}</td>
					<td>${fn:escapeXml(user.userName)}</td>
					<td>${fn:escapeXml(user.telephone)}</td>
					<td>${fn:escapeXml(user.roleName)}</td>
					<td><fmt:formatDate value="${user.createDatetime}"
							pattern="yyyy/MM/dd" /></td>
					<td><fmt:formatDate value="${user.updateDatetime}"
							pattern="yyyy/MM/dd" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>

	<form:form action="selectResultDelete"
		modelAttribute="selectResultForm">
		<form:button name="delete">
			<fmt:message key="btn.delete" />
		</form:button>
		<form:button name="return">
			<fmt:message key="btn.return" />
		</form:button>
	</form:form>

	<div>
		<a href="menu"><fmt:message key="btn.returnToMenu" /></a>
	</div>
</body>
</html>
