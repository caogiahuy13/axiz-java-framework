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
  <h3>更新完了</h3>

  <p>
  	<fmt:message key="screen.updateResult.before" /><br>
  	<fmt:message key="productId" /> ${fn:escapeXml(oldProduct.productId)}<br>
  	<fmt:message key="productName" /> ${fn:escapeXml(oldProduct.productName)}<br>
  	<fmt:message key="price" /> ${fn:escapeXml(oldProduct.price)}<br>
  </p>

  <p>
  	<fmt:message key="screen.updateResult.after" /><br>
  	<fmt:message key="productId" /> ${fn:escapeXml(newProduct.productId)}<br>
  	<fmt:message key="productName" /> ${fn:escapeXml(newProduct.productName)}<br>
  	<fmt:message key="price" /> ${fn:escapeXml(newProduct.price)}<br>
  </p>

  <a href="update"><fmt:message key="btn.return" /></a>
</body>
</html>