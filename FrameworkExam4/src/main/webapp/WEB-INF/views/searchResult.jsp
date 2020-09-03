<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
</head>
<body>
	<h3>検索結果</h3>
	<table border="1">
		<tr>
			<th><fmt:message key="productId"/></th>
			<th><fmt:message key="productName"/></th>
			<th><fmt:message key="price"/></th>
		</tr>
		<c:forEach var="product" items="${products}">
			<tr>
				<td>${fn:escapeXml(product.productId)}</td>
				<td>${fn:escapeXml(product.productName)}</td>
				<td>${fn:escapeXml(product.price)}</td>
			</tr>
		</c:forEach>
	</table>

	<a href="top"><fmt:message key="btn.return"/></a>
</body>
</html>