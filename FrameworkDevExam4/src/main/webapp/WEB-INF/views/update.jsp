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
<title>Index</title>
</head>
<body>
	<h3>更新する情報を入力してください</h3>

	<c:if test="${not empty msg}">
		<p>${msg}</p>
	</c:if>

	<form:form action="update" modelAttribute="updateForm">
		<fmt:message key="form.lbl.productId" />
		<form:input path="productId" />
		<form:errors path="productId" cssStyle="color: red" />
		<br>

		<fmt:message key="form.lbl.productName" />
		<form:input path="productName" />
		<form:errors path="productName" cssStyle="color: red" />
		<br>

		<fmt:message key="form.lbl.price" />
		<form:input path="price" />
		<form:errors path="price" cssStyle="color: red" />
		<br>

		<form:button>
			<fmt:message key="btn.update" />
		</form:button>
	</form:form>
</body>
</html>