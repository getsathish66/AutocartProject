<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<title>My cart</title>

<style>
table, td, th {
    border: 1px solid black;
}

table {
    border-collapse: collapse;
    width: 100%;
}

th {
    height: 50px;
}
</style>

</head>
<body>


<div class="container">

<h2>Mycart List</h2>

<table class = "table table-bordered">
  
  <tr class="bg-primary">
			
				<th >S.No</th>
				<th >Cart Id</th>
				<th>Product Name</th>
				<th >Price</th>
				<th >Quantity</th>
				<th >Total</th>
				<th >Days</th>
				<th >Remove</th>

			</tr>

			<c:forEach items="${mycartList}" var="mycart" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${mycart.cartid}</td>
					<td>${mycart.productName}</td>
					<td>${mycart.price}</td>
					<td>${mycart.quantity}</td>
					<td>${mycart.total}</td>
					<td>${mycart.days}</td>
					<td><a  class="btn btn-info" href="removecart?cartid=${mycart.cartid}">Remove</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">GrandTotal :</td>
				<td colspan="2"><c:out value="${total}"></c:out></td>
				<td></td>
			</tr>
			
		</table>
		
		<p>
			<a  href="proceed" class="btn btn-info" href="proceed">Proceed</a>
			 
                   
		</p>


                        
                       
</div>


</body>
</html>