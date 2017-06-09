<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>Insert title here</title>
<style>
  @import 'https://fonts.googleapis.com/css?family=Raleway';
div.container
{
    font-family: Raleway;
    margin: 0 auto;
	padding: 1em 2em;
	text-align: left;
}

div.container a
{
    color: white;
    text-decoration: none;
    font: 15px Raleway;
    margin: 0px 10px;
    padding: 10px 10px;
    position: relative;
    z-index: 0;
    cursor: pointer;
}


.blue
{
    background: #21f227;
}


/* Circle behind */
div.circleBehind a:before, div.circleBehind a:after
{
    position: absolute;
    top: 16px;
    left: 50%;
    width: 40px;
    height: 40px;
    border: 2px solid #14c3e2;
    transform: translateX(-50%) translateY(-50%) scale(1.8);
    border-radius: 50%;
    background: transparent;
    content: "/";
    opacity: 0;
    transition: all 0.2s;
    z-index: -1;
}

div.circleBehind a:after
{
    border-width: 2px;
    transition: all 0.7s;
}

div.circleBehind a:hover:before
{
    opacity: 1;
    transform: translateX(-50%) translateY(-50%) scale(1);
}

div.circleBehind a:hover:after
{
    opacity: 1;
    transform: translateX(-50%) translateY(-50%) scale(1.3);
}
</style>
</head>
<body>
<div class="container  circleBehind">
  <c:choose>
  <c:when test="${isUser=='true'}">
  <a><b>Offers</b></a>
  <a><b>Customer care</b></a>
  <a><b>About</b></a>
  <a><b>Contact</b></a>
  <a href="logout"><b>Logout</b></a>
  <a href="mycart"><b><i>MyCart</i></b></a>
  </c:when>
   <c:when test="${isAdmin=='true'}">
   <a href="logout"><b>Logout</b></a>
   </c:when>
  <c:otherwise>
    <a><b>Offers</b></a>
  <a><b>Customer care</b></a>
  <a><b>About</b></a>
  <a><b>Contact</b></a>
  <a href="LoginPage"><b>Login</b></a>
  <a href="RegisterPage"><b>Register</b></a>
  </c:otherwise>
   </c:choose>
</div>

</body>
</html>