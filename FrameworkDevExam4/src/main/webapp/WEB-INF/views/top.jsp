<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
</head>
<body>
	<h3>検索要件を入力してください。</h3>

	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>

	<form:form action="top" modelAttribute="product">
		<fmt:message key="form.lbl.productName" />
		<form:input path="productName" />
		<form:errors path="productName" cssStyle="color:red" />
		<br>

		<fmt:message key="form.lbl.price" />
		<form:input path="price" />
		<form:errors path="price" cssStyle="color:red" />
		<br>

		<form:button name="search">
			<fmt:message key="btn.search" />
		</form:button>

		<form:button name="register">
			<fmt:message key="btn.register" />
		</form:button>
	</form:form>

</body>
</html>