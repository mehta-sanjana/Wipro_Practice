<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8"/>
  <title>Contact Manager</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/static/styles.css" />
</head>
<body>
<nav>
  <a href="${pageContext.request.contextPath}/contacts">Contacts</a> |
  <a href="${pageContext.request.contextPath}/contacts?action=new">Add Contact</a>
</nav>
<hr/>
