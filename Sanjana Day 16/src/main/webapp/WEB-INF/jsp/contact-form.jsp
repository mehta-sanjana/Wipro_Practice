<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="include/header.jsp" />

<c:set var="f" value="${not empty contact ? contact : sessionScope.formData}" />
<h2><c:choose><c:when test="${not empty f and not empty f.id}">Edit Contact</c:when><c:otherwise>Add Contact</c:otherwise></c:choose></h2>

<c:if test="${not empty sessionScope['flash.message']}">
  <div class="message ${sessionScope['flash.type']}">
    ${sessionScope['flash.message']}
  </div>
  <c:remove var="flash.message" scope="session" />
  <c:remove var="flash.type" scope="session" />
</c:if>

<form action="${pageContext.request.contextPath}/contacts" method="post">
  <input type="hidden" name="id" value="${f.id}" />
  <label>Name*: <input type="text" name="name" value="${f.name}" required maxlength="100"/></label><br/>
  <label>Email: <input type="email" name="email" value="${f.email}" maxlength="150"/></label><br/>
  <label>Phone: <input type="text" name="phone" value="${f.phone}" maxlength="30"/></label><br/>
  <label>Address: <textarea name="address" maxlength="255">${f.address}</textarea></label><br/>
  <button type="submit">Save</button>
  <a href="${pageContext.request.contextPath}/contacts">Cancel</a>
</form>

</body>
</html>
