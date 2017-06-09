<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="resources/css/header.css">
 
<title>Auto Cart Home</title>
</head>
<body>
<header>
  <div class="row">
    <div class="col-sm-6" style="background-color:;width:640px">
    <div class="navbar-brand brand-name">
           <a href="#"><img class="img-responsive2"       
           src="resources/images/logo1.png" style="height:100px;width:320px"></a>
       </div>
    </div>
    
    <div class="col-sm-5" style="background-color:;">
   <jsp:include page="circlebehind.jsp"></jsp:include>
    </div>
  </div>
  
  <div class="row">
    <div class="col-sm-6" style="background-color:;"></div>
    <div class="col-sm-4" style="background-color:;">
    <jsp:include page="search.jsp"></jsp:include>
    </div>
  </div>
  
  <div class="row">
    <div class="col-sm-12" style="background-color:;">
<jsp:include page="navbar.jsp"></jsp:include>
    </div>
    <div class="col-sm-0" style="background-color:;">
    
    </div>
    </div>
    
</header>

<div class="container-fluid body-content">






<br>
<c:choose>

	<c:when test="${isUserClickedLogin=='true'}">

		<jsp:include page="login.jsp"></jsp:include>

	</c:when>
	<c:when test="${isUserClickedRegister=='true'}">

		<jsp:include page="register.jsp"></jsp:include>

	</c:when>
	<c:otherwise>
	
	<jsp:include page="carousel.jsp"></jsp:include>
	</c:otherwise>
	</c:choose>
	<jsp:include page="productlist.jsp"></jsp:include>
	</div>
<footer></footer>
</body>
</html>