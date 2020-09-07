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
<title><fmt:message key="page.updateInput.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>１箇所以上の項目を変更してください</p>

	<c:if test="${not empty msg}">
		<p class="error">${msg}</p>
	</c:if>

	<form:form action="updateConfirm" modelAttribute="updateInputForm">
		<fieldset class="label-60">
			<div>
				<form:input path="userId" type="hidden"/>
			</div>
			<div>
				<label><fmt:message key="form.lbl.id" /></label>
				<form:input path="loginId" />
				<form:errors path="loginId" cssStyle="color: red" />
			</div>
			<div>
				<label><fmt:message key="form.lbl.userName" /></label>
				<form:input path="userName" />
				<form:errors path="userName" cssStyle="color: red" />
			</div>
			<div>
				<label><fmt:message key="form.lbl.tel" /></label>
				<form:input path="tel" />
				<form:errors path="tel" cssStyle="color: red" />
			</div>
			<div>
				<label class="required"><fmt:message key="form.lbl.role" /></label>
				<form:select path="roleId">
					<form:options items="${sessionScope.roles}" itemLabel="roleName"
						itemValue="roleId" />
				</form:select>
			</div>
			<div>
				<label><fmt:message key="form.lbl.pass" /></label>
				<form:input path="pass" type="password" />
				<form:errors path="pass" cssStyle="color: red" />
			</div>
			<div>
				<form:input path="roleId" type="hidden" />
			</div>
		</fieldset>
		<div>
			<form:button name="confirm">
				<fmt:message key="btn.confirm" />
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
