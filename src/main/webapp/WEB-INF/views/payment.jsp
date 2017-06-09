<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">

<title>Payment</title>
<style>


/*
 * demo styles
 */

@media screen and (min-width: 981px){
  
	html{
		font-size: 62.5%;
	}
}

@media screen and (min-width: 481px) and (max-width: 980px){
  
	html{
		font-size: 9px;
	}
}

@media screen and (max-width: 480px){
  
	html{
		font-size: 8px;
	}
}

body{
    background: radial-gradient(rgb(253, 253, 253), rgb(248, 248, 248));
  	font-family: -apple-system, BlinkMacSystemFont, "Roboto", "Open Sans", "Helvetica Neue", "Segoe UI", sans-serif;
	font-size: 1.6rem;
	margin: 0;
}

.demo{
	min-height: 470px;
  box-sizing: border-box;
  position: relative;

  padding-left: 1rem;
  padding-right: 1rem;

	display: flex;
	justify-content: center;
	align-items: center;
}

.footer{
    padding: 2rem;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;  
}

a{
  color: #000;
}

a:focus{
	outline: 2px solid #fdde60;
}

a:hover{
    text-decoration: none;
}

.melnik909{
  margin-left: 2rem;
}

/*
 * CSS payment card
 */

.payment-card{
	width: 60rem;
}

.payment-card__footer{
	text-align: center;
	margin-top: 2rem;
}

.bank-card{
	position: relative;
}

@media screen and (min-width: 481px){

    .bank-card{
    	height: 30rem;
    }

    .bank-card__side{
    	border-radius: 10px;
    	border: 1px solid transparent;
		  position: absolute;
		  width: 65%;
    }

    .bank-card__side_front{
    	background-color: #f0f0ee;
    	padding: 5%;
    	box-shadow: 0 0 10px #f4f4f2;
    	border-color: #a29e97;

    	top: 0;
    	left: 0;
    	z-index: 3;
    }

    .bank-card__side_back{
    	background-color: #e0ddd7;
    	padding: 24.5% 5% 11%;
    	box-shadow: 0 0 2rem #f3f3f3;

    	text-align: right;
    	border-color: #dad9d6;

		  top: 12%;
    	right: 0;
    }

    .bank-card__side_back:before{
    	content: "";
    	width: 100%;
    	height: 25%;
    	background-color: #8e8b85;

    	position: absolute;
    	top: 14%;
    	right: 0;
    }
}

@media screen and (max-width: 480px){

    .bank-card__side{
        border: 1px solid #a29e97;
        background-color: #f0f0ee;
        padding-left: 5%;
        padding-right: 5%;
    }

    .bank-card__side_front{
        border-radius: 10px 10px 0 0;
        border-bottom: none;
        padding-top: 5%;
    }

    .bank-card__side_back{
        border-radius: 0 0 10px 10px;
        border-top: none;
        padding-bottom: 5%;
    }
}

.bank-card__inner{
	margin-bottom: 4%;
}

.bank-card__inner:last-child{
	margin-bottom: 0;
}

.bank-card__label{
	display: inline-block;
	vertical-align: middle;
}

.bank-card__label_holder, .bank-card__label_number{
	width: 100%;
}

@media screen and (min-width: 481px){

    .bank-card__month, .bank-card__year{
        width: 25%;
    }
}

@media screen and (max-width: 480px){

    .bank-card__month, .bank-card__year{
        width: 48%;
    }
}

@media screen and (min-width: 481px){

    .bank-card__cvc{
        width: 25%;
    }
}

@media screen and (max-width: 480px){

    .bank-card__cvc{
        width: 100%;
        margin-top: 4%;
    }
}

.bank-card__hint{
	position: absolute;
	left: -9999px;
}

.bank-card__caption{
	text-transform: uppercase;
	font-size: 1.1rem;
  margin-left: 1%;
}

.bank-card__field{
	box-sizing: border-box;
	border: 3px solid #d0d0ce;
	width: 100%;

	padding: 1rem;
	font-family: inherit;
	font-size: 100%;
}

.bank-card__field:focus{
	outline: none;
	border-color: #fdde60;
}

.bank-card__separator{
	font-size: 3.2rem;
	color: #c4c4c3;

	margin-left: 3%;
	margin-right: 3%;
	display: inline-block;
	vertical-align: middle;
}

@media screen and (max-width: 480px){

    .bank-card__separator{
        display: none;
    }
}

@media screen and (min-width: 481px){

    .bank-card__footer{
        background-image: url("https://stas-melnikov.ru/demo-icons/mastercard-colored.svg"), url("https://stas-melnikov.ru/demo-icons/visa-colored.svg");
        background-repeat: no-repeat;
        background-position: 78% 50%, 100% 50% ;
    }
}

@media screen and (max-width: 480px){

    .bank-card__footer{
        display: flex;
        justify-content: space-between;
    }
}

.payment-card__button{

	background-color: #ada093;
	transition: background-color .4s ease-out;

	border-radius: 5px;
	border: 3px solid transparent;
	cursor: pointer;
	padding: 1rem 6.5rem;

	font-size: 100%;
	font-family: inherit;
	color: #fff;
}

.payment-card__button:focus{
	outline: none;
	border-color: #fdde60;
}

.payment-card__button:hover, .payment-card__button:focus{
	background-color: #8e8b85;
}


</style>
</head>
<body>

	<div class="demo">
		<form action="ThankyouPage" method="post" class="payment-card">
			<div class="bank-card">
				<div class="bank-card__side bank-card__side_front">
					<div class="bank-card__inner">
						<label class="bank-card__label bank-card__label_holder">
							<span class="bank-card__hint">Holder of card</span>
							<input type="text" class="bank-card__field" placeholder="Holder of card" pattern="[A-Za-z, ]{2,}" name="holder-card" required>
						</label>
					</div>
					<div class="bank-card__inner">
						<label class="bank-card__label bank-card__label_number">
							<span class="bank-card__hint">Number of card</span>
							<input type="text" class="bank-card__field" placeholder="Number of card" pattern="[0-9]{16}" name="number-card" required>
						</label>
					</div>
					<div class="bank-card__inner">
						<span class="bank-card__caption">valid thru</span>
					</div>
					<div class="bank-card__inner bank-card__footer">
						<label class="bank-card__label bank-card__month">
							<span class="bank-card__hint">Month</span>
							<input type="text" class="bank-card__field" placeholder="MM" maxlength="2" pattern="[0-9]{2}" name="mm-card" required>
						</label>
						<span class="bank-card__separator">/</span>
						<label class="bank-card__label bank-card__year">
							<span class="bank-card__hint">Year</span>
							<input type="text" class="bank-card__field" placeholder="YY" maxlength="2" pattern="[0-9]{2}" name="year-card" required>
						</label>
					</div>
				</div>
				<div class="bank-card__side bank-card__side_back">
					<div class="bank-card__inner">
						<label class="bank-card__label bank-card__cvc">
							<span class="bank-card__hint">CVC</span>
							<input type="text" class="bank-card__field" placeholder="CVC" maxlength="3" pattern="[0-9]{3}" name="cvc-card" required>
						</label>
					</div>
				</div>
			</div>
			<div class="payment-card__footer">
				<button type="submit" class="payment-card__button">Send</button>
			</div>
		</form>
	</div>


</body>
</html>