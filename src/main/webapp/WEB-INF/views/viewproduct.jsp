<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Insert title here</title>
</head>
<body>
<%-- <jsp:include page="header.jsp"></jsp:include> --%>
<div class="container-fluid body-content">
<br>
<br>
<div class="container">

<h2>Product List</h2>
<table class = "table table-bordered">
  <tr class="bg-primary">
<th>S.No</th>
<th>ProductID</th>
<th>ProductName</th>
 <th>Description</th>
<th>Quantity</th>
<th>Prize</th>

<th>EDIT</th>
<th> DELETE</th>
</tr>
 <c:forEach items="${productList}" var="product" varStatus="status">
<tr>
<td>${status.count}</td>
<td>${product.id}</td>
<td>${product.productName}</td>
 <td>${product.productDescription}</td>
 <td>${product.productQuantity}</td>
<td>${product.productPrize}</td>


<td><a href="editProduct?id=${product.id}"><font color="blue"><b>Edit</b></font></a></td>
<td><a href="deleteProduct?id=${product.id}"><font color="red"><b>Delete</b></font></a></td>
</tr>

</c:forEach> 
</table>
</div>
</div>

</body>
</html>