<!DOCTYPE html>
<html>
<head>
<script src="resources/js/categoryValidation.js"></script>
 <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <script src="resources/js/jquery.min.js"></script>
  <script src="resources/js/bootstrap.min.js"></script>

<style>

body, html{
     height: 100%;
 	background-repeat: no-repeat;
 	background-color: #d3d3d3;
 	font-family: 'Oxygen', sans-serif;
}

.main{
 	margin-top: 70px;
}

h1.title { 
	font-size: 50px;
	font-family: 'Passion One', cursive; 
	font-weight: 400; 
}

hr{
	width: 10%;
	color: #fff;
}

.form-group{
	margin-bottom: 15px;
}

label{
	margin-bottom: 15px;
}

input,
input::-webkit-input-placeholder {
    font-size: 11px;
    padding-top: 3px;
}

.main-login{
 	background-color: #fff;
    /* shadows and rounded borders */
    -moz-border-radius: 2px;
    -webkit-border-radius: 2px;
    border-radius: 2px;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);

}

.main-center{
 	margin-top: 30px;
 	margin: 0 auto;
 	max-width: 330px;
    padding: 40px 40px;

}

.login-button{
	margin-top: 5px;
}

.login-register{
	font-size: 11px;
	text-align: center;
}

</style>
</head>
<body>

<div class="container-fluid body-content">
<!-- <nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Category</a>
    </div>
    <ul class="nav navbar-nav">
      
      <li><a href="ViewCategoryPage">View</a></li>
      <li><a href="#">Edit</a></li>
      
    </ul>
  </div>
</nav> -->
<div class="container">
			<div class="row main">
				<div class="panel-heading">
	          
	            </div> 
				<div class="main-login main-center">
					<form class="form-horizontal" action="newCategory" method="post" onsubmit="return validation()">
						<h3 style="color:red">Category form</h3>
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Category Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="categoryName" id="name"  placeholder="Enter supplier Name"/>
								</div>
							</div>
						</div>


						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label" >Category Description</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="categoryDescription" id="description"  placeholder="Enter your Username"/>
								</div>
							</div>
						</div>
							
						<div class="form-group ">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-button">Add Category</button>
						</div>
						
					</form>
				</div>
			</div>
		</div>
		</div>
		<script type="text/javascript" src="resources/js/bootstrap.js"></script>
</body>
</html>
3