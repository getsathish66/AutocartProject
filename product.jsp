<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="resources/js/productValidation.js"></script>
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
<script src="resources/js/jquery.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<style>
body, html {
	height: 100%;
	background-repeat: no-repeat;
	background-color: #d3d3d3;
	font-family: 'Oxygen', sans-serif;
}

.main {
	margin-top: 70px;
}

h1.title {
	font-size: 50px;
	font-family: 'Passion One', cursive;
	font-weight: 400;
}

hr {
	width: 10%;
	color: #fff;
}

.form-group {
	margin-bottom: 15px;
}

label {
	margin-bottom: 15px;
}

input, input::-webkit-input-placeholder {
	font-size: 11px;
	padding-top: 3px;
}

.main-login {
	background-color: #fff;
	/* shadows and rounded borders */
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.main-center {
	margin-top: 30px;
	margin: 0 auto;
	max-width: 330px;
	padding: 40px 40px;
}

.login-button {
	margin-top: 5px;
}

.login-register {
	font-size: 11px;
	text-align: center;
}
</style>
</head>
<body>



	<div class="container-fluid body-content">
<!-- 		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">Products</a>
				</div>
				<ul class="nav navbar-nav">

					<li><a href="ViewProductPage">View</a></li>
					<li><a href="afterLogin">Home</a></li>

				</ul>
			</div>
		</nav> -->
		<div class="container">
			<div class="row main">
				<div class="panel-heading"></div>
				<div class="main-login main-center">
					<form action="newProduct" method="post"
						onsubmit="return validation()" enctype="multipart/form-data"
						class="form-horizontal">
						<h3 style="color: red">Product form</h3>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Product
								Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-tags"></i></span> <input type="text"
										class="form-control" name="productName" id="name"
										placeholder="Enter Product Name" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Product
								Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-tags"></i></span> <input type="text"
										class="form-control" name="productDescription"
										id="description" placeholder="About Product" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Prize</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-tags"></i></span> <input type="tel"
										class="form-control" name="productPrize" id="prize"
										placeholder="Enter Prize" />
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="contact" class="cols-sm-2 control-label">Quantity</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-tags"></i></span> <input type="number"
										class="form-control" name="productQuantity" id="quantity"
										placeholder="Enter Quantity" />
								</div>
							</div>
						</div>

						<select class="form-control" name="supplier"
							id="supplier">
								<option value="" class="form-control">Select Supplier</option>
								 <c:forEach items="${supplierList}" var="supplier">
									<option value="${supplier.suppliername}">${supplier.suppliername}</option>
								</c:forEach>
						</select>
<br>
							<br>

						<select class="form-control" name="category"
							id="category">
								<option value="" class="form-control">Select Category</option>
								<c:forEach items="${categoryList}" var="category">
									<option value="${category.categoryName}">${category.categoryName }</option>
								</c:forEach>
						</select><br>
							<br>
						
						
						<div class="form-group">
							<label for="contact" class="cols-sm-2 control-label">Product
								image</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-tags"></i></span> <input type="file"
										class="form-control" name="image" id="file" placeholder="" />
								</div>
							</div>
						</div>

						<div class="form-group ">
							<button type="submit"
								class="btn btn-primary btn-lg btn-block login-button">Add
								Product</button>
						</div>

					</form>
				</div>
			</div>
		</div>
		
		
		
	</div>
	<script type="text/javascript" src="resources/js/bootstrap.js"></script>

</body>
</html>
