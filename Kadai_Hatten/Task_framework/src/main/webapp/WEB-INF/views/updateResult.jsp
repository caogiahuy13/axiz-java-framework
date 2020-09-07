<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><fmt:message key="page.updateResult.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
	<p>実行者：${sessionScope.currentUser.userName}</p>
	<p>正常に更新されました</p>
	<div>
		<a href="menu"><fmt:message key="btn.returnToMenu" /></a>
	</div>
</body>
</html>
