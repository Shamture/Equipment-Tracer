<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="c"	uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta charset="UTF-8">
<title>Page Login</title>
 <meta name="viewport" content="width=device-width">

  <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css" />">
    <link rel="stylesheet" href="<c:url value="/resources/css/main.css" />">

</head>
<body id="login-body">

<div id="login-div">
   <h1>Connectez Vous</h1>
   <c:if test="${requestScope.error==true }">
      <div class="alert alert-danger">
 			 <strong>Login ou mot de passe invalide !</strong> 
	  </div>
   </c:if>
   <form method="post" action="">
      <div class="form-group">
        <label for="login">Login : </label>
        <input type="text" name="login" id="login" class="form-control" placeHolder="Login" />
      </div>
      <div class="form-group">
        <label for="pass">Mot de passe : </label>
        <input type="password" name="pass" id="pass" class="form-control" placeHolder="Mot de passe" />
      </div>
      
      <input type="submit" value="Connecter" class="btn btn-danger" />
   </form>
</div>

<script src="<c:url value="/resources/js/jquery-1.9.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/js/main.js" />"></script>
</body>
</html>