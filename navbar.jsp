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
<title>Insert title here</title>
<style>
* {
  margin: 0;
  padding: 0;
}
 
nav {
  margin: 20px;
}

 
ul {
	
  overflow: auto;
  list-style-type: none;
}
 
li {
  height: 25px;
  float: left;
  margin-right: 0px;
  border-right: 1px solid #aaa;
  padding: 0 20px;
      overflow: auto;
  
}
 
li:last-child {
  border-right: none;
}
 
li a {
  text-decoration: none;
  color: white;
  font: 12px/1 Helvetica, Verdana, sans-serif;
  text-transform: uppercase;
 
  -webkit-transition: all 0.5s ease;
  -moz-transition: all 0.5s ease;
  -o-transition: all 0.5s ease;
  -ms-transition: all 0.5s ease;
  transition: all 0.5s ease;
}
 
li a:hover {
  color: blue;
}
 
li.active a {
  font-weight: bold;
  color: #333;
}
.dropdown-menu li1 {
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
</style>
</head>
<body>
<nav>
  <ul>
  
  <c:choose>
  <c:when test="${isUser=='true'}">
    <li><a href="Homepage"><b>Home</b></a></li>
    <li><a href="Carspage"><b>Cars</b></a></li>
    <li><a href="Bikespage"><b>Bikes</b></a></li>
    <li><a href="Truckspage"><b>Trucks</b></a></li>
   </c:when>
    <c:when test="${isAdmin=='true'}">
	
	<li><font color=black><b>P R O D U C T--&#160;&#160;</b><a href="Productspage"><b>ADD</b></a></li>
	
	<li><a href="ViewProductPage"><b>VIEW</b></a></li>
	

	
    <li><font color=black><b>C A T E G O R Y--&#160;&#160;</b><a href="Categoriespage"><b>ADD</b></a></li>
    
    <li><a href="ViewCategoryPage"><b>VIEW</b></a></li>
   

    <li><font color=black><b>S U P P L I E R--&#160;&#160;</b><a href="Supplierspage"><b>ADD</b></a></li>
    
    <li><a href="ViewSupplierPage"><b>VIEW</b></a></li>






    
 </c:when>
<%-- <li><a href="Billingpage"><b>Billing</b></a></li>
    <li><a href="Shippingpage"><b>Shipping</b></a></li>
   
    <c:otherwise>
    <h4>Please Login or SignUp</h4>
    </c:otherwise> --%>
    </c:choose>
  </ul>

   
</nav>
</body>
</html>