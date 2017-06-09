function validation(){
	var name = document.getElementById('name');
	var description = document.getElementById('description');
	
	
	// Check each input in the order that it appears in the form!
	 if (notEmpty(name, "Name Should not be empty")) {
			if (isAlphabet(name, "Please enter only letters for Nname")) {
				
			
	if (notEmpty(description, "Description Should not be empty")) {
		if (isAlphabet(description, "Please enter only letters for Description")) {
			
					
							
									return true;

								
							}
						}
					
		}
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
	

		 
