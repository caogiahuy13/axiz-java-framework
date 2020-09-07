<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="page.login.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<c:if test="${not empty msg}">
		<p class="error">${msg}</p>
	</c:if>

	<form:form action="login" modelAttribute="loginForm">
		<fieldset>
			<div>
				<label><fmt:message key="form.lbl.id" /></label>
				<form:input path="id" />
				<form:errors path="id" cssStyle="color: red" />
			</div>
			<div>
				<label><fmt:message key="form.lbl.pass" /></label>
				<form:input path="pass" type="password"/>
				<form:errors path="pass" cssStyle="color: red" />
			</div>
		</fieldset>
		<form:button>
			<fmt:message key="btn.login" />
		</form:button>
	</form:form>

	<div>
		<a href="index"><fmt:message key="page.login.btn.return" /></a>
	</div>
</body>
</html>
