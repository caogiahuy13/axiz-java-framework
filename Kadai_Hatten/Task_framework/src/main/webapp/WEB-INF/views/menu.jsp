<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="page.menu.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${empty sessionScope.currentUser}">
		<c:redirect url="index" />
	</c:if>

	<p>${sessionScope.currentUser.userName}さん、こんにちは</p>

	<p>
		<a href="select"><fmt:message key="btn.search" /></a>
	</p>
	<c:if test="${sessionScope.currentUser.roleId == 1}">
		<p>
			<a href="insert"><fmt:message key="btn.insert" /></a>
		</p>
		<p>
			<a href="update"><fmt:message key="btn.update" /></a>
		</p>
		<p>
			<a href="delete"><fmt:message key="btn.delete" /></a>
		</p>
	</c:if>

	<form action="logout" method="post">
		<button type="submit">
			<fmt:message key="btn.logout" />
		</button>
	</form>

</body>
</html>
