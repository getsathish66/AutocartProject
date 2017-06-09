<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>

.btn-info {
background-color: #364def;
border-color: #364def;
}
.btn{
padding:4px 6px;
}
</style>

<title>Insert title here</title>
</head>
<body>


  <button type="button"><span style="float: center;"><a class="btn btn-info" href="shippingaddPage"> New Shipping Address</a></span></button><br><br>

 <c:forEach items="${shippingList}" var="shipping" >
 <div class="col-sm-3 col-sm-offset-1" style="width:300px;heigth:500px;border:1px solid red; float: left; margin-left: 1.5em;" >

<a class="btn btn-info" href="deleteshippingAddress?shippingId=${shipping.sid}">
<span style="float: left;margin-right:1em;" class="glyphicon glyphicon-trash"></span> 
</a>
<a class="btn btn-info" href="editshippingAddress?shippingId=${shipping.sid }">
<span style="float: left; margin-right:1em;"class="glyphicon glyphicon-pencil"></span>
</a>

<br><font color="#ff0066">Shipping address</font><br><br>

Name:${shipping.name}<br>

Contact Number:${shipping.contact}<br>
Address:${shipping.address}<br>
Zipcode:${shipping.zipcode}

<br><br><button ><a class="btn btn-info" href="shippingAddress?shippingId=${shipping.sid}">Deliver Here</a></button><br><br>
</div>
</c:forEach>
 <br><br>  

</body>
</html>