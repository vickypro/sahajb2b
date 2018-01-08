<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- <!DOCTYPE html> -->
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>Sahaj | B2B</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

  
</head>
 
<body onload='document.loginForm.username.focus();'>

<br><br>
	

  <div class="login-page">
  <div class="form">
   
    	<img alt="Solar_logo" src="img/logo-left.png">
    <form class="login-form" name='login' action="<c:url value='/loginPage' />" method='POST'>
      <input type="text" placeholder="username" name='username' value=''/>
      <input type="password" placeholder="password" name='password'/>
      <button>login</button>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
      <br><br>
    <c:if test="${not empty error}"><div align="center" style="color:#679AC7"><b>${error}</b></div></c:if>
	<c:if test="${not empty message}"><div align="center" style="color:#679AC7"><b>${message}</b></div></c:if>
    </form>
  </div>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

    <script  src="js/index.js"></script>

</body>
</html>
