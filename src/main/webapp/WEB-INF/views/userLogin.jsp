<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid body-content">


<%-- <jsp:include page="carousel.jsp"></jsp:include> --%>
<jsp:include page="productlist.jsp"></jsp:include>






<c:if test="${productdetails=='true'}">

		<jsp:include page="productdetails.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${isUserClickedaddtocart=='true'}">

		<jsp:include page="mycart.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${isUserClickedShippingAddress=='true'}">

		<jsp:include page="viewshippingadd.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${newShippingaddressClicked=='true'}">

		<jsp:include page="shippingadd.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${deliverhereClicked=='true'}">

		<jsp:include page="payment.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${checkoutClicked=='true'}">

		<jsp:include page="thankyou.jsp"></jsp:include>

	</c:if>
	
	</div>
</body>
</html>