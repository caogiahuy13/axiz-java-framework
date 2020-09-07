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
<title><fmt:message key="page.deleteConfirm.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>これでよろしいですか？</p>

	<form:form action="delete" modelAttribute="deleteConfirmForm">
		<fieldset>
			<div>
				<label><fmt:message key="form.lbl.id" /></label> <input
					type="text" name="loginId" value="${deleteUser.loginId}" readonly>
			</div>
			<div>
				<label><fmt:message key="form.lbl.userName" /></label> <input
					type="text" name="userName" value="${deleteUser.userName}" readonly>
			</div>
			<div>
				<label><fmt:message key="form.lbl.tel" /></label> <input
					type="text" name="tel" value="${deleteUser.telephone}" readonly>
			</div>
			<div>
				<label><fmt:message key="form.lbl.role" /></label> <input
					type="text" name="roleName" value="${deleteUser.roleName}" readonly>
			</div>
			<form:input path="userId" type="hidden" />
		</fieldset>
		<div>
			<form:button name="delete">
				<fmt:message key="btn.delete" />
			</form:button>
			<form:button name="return">
				<fmt:message key="btn.return" />
			</form:button>
		</div>
	</form:form>
	<div>
		<a href="menu"><fmt:message key="btn.returnToMenu" /></a>
	</div>
</body>
</html>
