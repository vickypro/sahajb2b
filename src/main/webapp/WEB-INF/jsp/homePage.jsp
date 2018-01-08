<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Welcome to BSC</h3>


<h3><a href="insert">Insert</a></h3>
<h3><a href="update">Update</a></h3>
<h3><a href="delete">Delete</a></h3>
<h3><a href="temp">Temp</a></h3>
<h3><a href="re11"></a></h3>



<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>