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
<title><fmt:message key="page.update.title" /></title>
<link href="css/commons.css" rel="stylesheet">
</head>
<body>
  <p>
    更新するIDを入力してください<br> <span class="required"></span>は必須です
  </p>

  <c:if test="${not empty msg}">
	<p class="error">${msg}</p>
  </c:if>

  <form:form action="updateInput" modelAttribute="updateForm">
    <fieldset>
      <div>
        <label class="required"><fmt:message key="form.lbl.id" /></label>
        <form:input path="loginId"/>
        <form:errors path = "loginId" cssStyle="color: red"/>
      </div>
    </fieldset>
    <form:button><fmt:message key="btn.confirm" /></form:button>
  </form:form>
  <div>
    <a href="menu"><fmt:message key="btn.returnToMenu" /></a>
  </div>
</body>
</html>
