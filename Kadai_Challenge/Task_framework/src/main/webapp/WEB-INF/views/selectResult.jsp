<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="page.selectResult.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${sessionScope.currentUser.roleId == 1}">
		<p>編集する場合は、1つのみ対象を選択してください</p>

		<c:if test="${not empty msg}">
			<p class="error">${msg}</p>
		</c:if>

		<form:form action="selectResult" modelAttribute="selectResultForm">
			<table>
				<caption>
					<fmt:message key="page.selectResult.table.caption" />
				</caption>
				<thead>
					<tr>
						<th><fmt:message key="page.selectResult.table.header.select" /></th>
						<th><fmt:message key="page.selectResult.table.header.loginId" /></th>
						<th><fmt:message
								key="page.selectResult.table.header.userName" /></th>
						<th><fmt:message key="page.selectResult.table.header.tel" /></th>
						<th><fmt:message key="page.selectResult.table.header.role" /></th>
						<th><fmt:message
								key="page.selectResult.table.header.createDate" /></th>
						<th><fmt:message
								key="page.selectResult.table.header.updateDate" /></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${sessionScope.resultUsers}">
						<tr>
							<td style="text-align: center;"><label style="display: table-cell; width: 2em" for="${user.userId}">
									<form:checkbox path="userIDs" value="${user.userId}"
										id="${user.userId}" />
							</label></td>
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

			<form:button name="edit">
				<fmt:message key="btn.edit" />
			</form:button>
			<form:button name="delete">
				<fmt:message key="btn.delete" />
			</form:button>
		</form:form>
	</c:if>

	<c:if test="${sessionScope.currentUser.roleId != 1}">
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
				<c:forEach var="user" items="${sessionScope.resultUsers}">
					<tr>
						<td>${fn:escapeXml(user.loginId)}</td>
						<td>${fn:escapeXml(user.userName)}</td>
						<td>${fn:escapeXml(user.telephone)}</td>
						<td>${fn:escapeXml(user.roleName)}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<div>
		<a href="menu"><fmt:message key="btn.returnToMenu" /></a>
	</div>
</body>
</html>
