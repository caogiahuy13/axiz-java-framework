<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
		product_name <form:input path="productName" /><br>
		price <form:input path="price" /><br>
		<form:button name="search">検索</form:button>
		<form:button name="register">登録</form:button>
	</form:form>

</body>
</html>