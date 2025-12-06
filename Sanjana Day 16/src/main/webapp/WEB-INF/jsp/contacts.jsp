<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<jsp:include page="include/header.jsp" />

<div>
  <c:if test="${not empty sessionScope['flash.message']}">
    <div class="message ${sessionScope['flash.type']}">
      ${sessionScope['flash.message']}
    </div>
    <c:remove var="flash.message" scope="session" />
    <c:remove var="flash.type" scope="session" />
  </c:if>

  <h2>Your Contacts</h2>

  <c:if test="${empty contacts}">
    <p>No contacts found. <a href="${pageContext.request.contextPath}/contacts?action=new">Add your first contact</a></p>
  </c:if>

  <c:if test="${not empty contacts}">
    <table border="1" cellpadding="6" cellspacing="0">
      <thead>
        <tr>
          <th>Name</th><th>Email</th><th>Phone</th><th>Address</th><th>Actions</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="c" items="${contacts}">
          <tr>
            <td><c:out value='${fn:escapeXml(c.name)}'/></td>
            <td><c:out value='${c.email}'/></td>
            <td><c:out value='${c.phone}'/></td>
            <td><c:out value='${c.address}'/></td>
            <td>
              <a href="${pageContext.request.contextPath}/contacts?action=edit&id=${c.id}">Edit</a> |
              <a href="${pageContext.request.contextPath}/contacts?action=delete&id=${c.id}"
                 onclick="return confirm('Delete contact ${c.name}?');">Delete</a>
            </td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
  </c:if>
</div>

</body>
</html>
