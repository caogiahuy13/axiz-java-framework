<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="page.insertConfirm.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>これでよろしいですか？</p>

	<c:if test="${not empty msg}">
		<p class="error">${msg}</p>
	</c:if>

	<form:form action="insert" modelAttribute="insertConfirmForm">
		<fieldset class="label-130">
			<div>
				<label><fmt:message key="form.lbl.id" /></label>
				<form:input path="loginId" readonly="true" />
			</div>
			<div>
				<label><fmt:message key="form.lbl.userName" /></label>
				<form:input path="userName" readonly="true" />
			</div>
			<div>
				<label><fmt:message key="form.lbl.tel" /></label>
				<form:input path="tel" readonly="true" />
			</div>
			<div>
				<label><fmt:message key="form.lbl.role" /></label>
				<form:input path="roleName" readonly="true" />
			</div>
			<div>
				<label><fmt:message key="form.lbl.rePass" /></label>
				<form:input path="rePass" type="password"/>
				<form:errors path="rePass" cssStyle="color: red"/>
			</div>
			<div>
				<form:input path="roleId" type="hidden"/>
				<form:input path="pass" type="hidden"/>
			</div>
		</fieldset>
		<div>
			<form:button name="insert">
				<fmt:message key="btn.insert" />
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
