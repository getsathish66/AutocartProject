<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="resources/css/header.css">
<title>Insert title here</title>
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
  <c:choose>
  <c:when test="${isUser=='true'}">
  <div class="row">
    <div class="col-sm-6" style="background-color:;"></div>
    <div class="col-sm-4" style="background-color:;">
    <h6>Welcome User</h6>
    </div>
  </div>
  </c:when>
  <c:when test="${isAdmin=='true'}">
    <div class="row">
    <div class="col-sm-6" style="background-color:;"></div>
    <div class="col-sm-4" style="background-color:;">
    <h3>Welcome Admin</h3>
    </div>
  </div>
  </c:when>
  </c:choose>
  
  <div class="row">
    <div class="col-sm-12" style="background-color:;">
<jsp:include page="navbar.jsp"></jsp:include>
    </div>
    </div>
</header>
</body>
</html>