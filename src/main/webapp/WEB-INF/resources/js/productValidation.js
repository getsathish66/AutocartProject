function validation(){
	var name = document.getElementById('name');
	var description = document.getElementById('description');
	var prize = document.getElementById('prize');
	var quantity = document.getElementById('quantity');

	
	
	// Check each input in the order that it appears in the form!
	 if (notEmpty(name, "Productname Should not be empty")) {
			if (isAlphabet(name, "Please enter only letters for Productname")) {
				
			
				if (notEmpty(description,"Description Should not be empty")) {
						if (isAlphabet(description,"Please enter text only in description")) {

	if (notEmpty(prize, "Prize Should not be empty")) {
		if (isNumeric(prize, "Please enter only numbers for Prize")) {
			
			if (notEmpty(quantity, "Quantity Should not be empty")) {
				if (isNumeric(quantity,"Please enter only number for Quantity")) {

					
							
									return true;
											}
										}
									}
								}
							}}}
						}
		return false;
	}
	function notEmpty(elem, helperMsg) {
		if (elem.value.length == 0) {
			alert(helperMsg);
			elem.focus(); // set the focus to this input
			return false;
		}
		return true;
	}
	function isNumeric(elem, helperMsg) {
		var numericExpression = /^[0-9]+$/;
		if (elem.value.match(numericExpression)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	function isAlphabet(elem, helperMsg) {
		var alphaExp = /^[a-z A-Z]+$/;
		if (elem.value.match(alphaExp)) {
			return true;
		} else {
			alert(helperMsg);
			elem.focus();
			return false;
		}
	}
	

		 
