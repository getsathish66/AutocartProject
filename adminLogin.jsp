<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid body-content">
<!-- <h3><b>Welcome Admin</b></h3> -->





</div>
		<c:if test="${isAdminClickedProduct=='true'}">

		<jsp:include page="product.jsp"></jsp:include>

	</c:if>
	
			<c:if test="${isAdminClickedViewProduct=='true'}">

		<jsp:include page="viewproduct.jsp"></jsp:include>

	</c:if>
	
			<c:if test="${isAdminClickedCategory=='true'}">

		<jsp:include page="category.jsp"></jsp:include>

	</c:if>
	
				<c:if test="${isAdminClickedViewCategory=='true'}">

		<jsp:include page="viewcategory.jsp"></jsp:include>

	</c:if>
	
				<c:if test="${isAdminClickedSupplier=='true'}">

		<jsp:include page="supplier.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${isAdminClickedViewSupplier=='true'}">

		<jsp:include page="viewsupplier.jsp"></jsp:include>

	</c:if>
	
	<c:if test="${isAdminClickedEditProduct=='true'}">

		<jsp:include page="editproduct.jsp"></jsp:include>

	</c:if>
		<c:if test="${isAdminClickedEditCategory=='true'}">

		<jsp:include page="editcategory.jsp"></jsp:include>

	</c:if>
		<c:if test="${isAdminClickedEditSupplier=='true'}">

		<jsp:include page="editsupplier.jsp"></jsp:include>

	</c:if>
	

</body>
</html>