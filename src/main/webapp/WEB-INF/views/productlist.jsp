<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="resources/css/productlist.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,600,700' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${ProductList}" var="product">

        
         <div class="product-card">
        
        <div class="card">
          <div class="corner"><p>${product.productPrize}</p></div>
          <div class="body-card">
            <div class="body-header">
              
              <div class="name">${product.productName}</div>
              <p>${product.productDescription}</p></div>
            
            <div class="body-footer">
           

    <button class="btn btn-success btn-sm" type="submit"><span class="fa fa-cart-plus fa-lg" aria-hidden="true"></span>
Add to Cart</button>

    <button class="btn btn-warning btn-xs" type="submit"><span class="fa fa-search " aria-hidden="true"></span>
 <a href="productdetails?id=${product.id}">Moreinfo</a></button>
            </div>
          </div>
          <div class="thumb">
          <img src="resources/images/product/${product.id}.jpg"/>
          </div>
           <div class="thumb-blur">
          <img src="resources/images/product/${product.id}.jpg"/>
          </div>
          </div>
        </div>
       </c:forEach>
       </body>
       </html>