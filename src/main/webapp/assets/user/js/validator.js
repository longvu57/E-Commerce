function Validator(options) {	
	//VALIDATE
	function validate(inputElement, rule) {
		var errorElement = inputElement.parentElement.querySelector(options.errorSelector);
		var error = rule.test(inputElement.value);
		
		if (error) {
			errorElement.innerText = error;
		} else {
			errorElement.innerText = '';
		}
		return !error;
	}

	//GET ELEMENT TO VALIDATE
	var formElement = document.querySelector(options.form);
	if (formElement) {
		
		formElement.onsubmit = function (e){
			e.preventDefault();
			var isFormValid = true;
			options.rules.forEach(function(rule){
				var inputElement = formElement.querySelector(rule.selector);
				var isValid = validate(inputElement, rule);
				if(!isValid){
					isFormValid = false;
				}
			});
			if(isFormValid){
				formElement.submit();
			}
		}
		
		//LISTEN EVENT
		options.rules.forEach(function(rule) {			
		var inputElement = formElement.querySelector(rule.selector);
			if (inputElement) {
				//BLUR AFTER INPUT
				inputElement.onblur = function() {
					validate(inputElement, rule);
				}
				
				//BLUR DURING INPUT
				inputElement.oninput = function() {
					var errorElement = inputElement.parentElement.querySelector('.form-message');
					errorElement.innerText = '';
				}
			}
		})
	}
}

Validator.isRequired = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			return value.trim() ? undefined : 'Invalid input!';
		}
	}
}

Validator.isPhone = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			var regex = /(\+84|0)+(3[2-9]|5[6|8|9]|9\d(?!5)|8[1-9]|7[0|6-9])+([0-9]{7})\b/g;
			return regex.test(value) ? undefined : 'Invalid phone!';
		}
	}
}

Validator.isPrice = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			var regex = /^(?:[1-9]\d*|0)?(?:\.\d+)?$/gm;
			return regex.test(value) ? undefined : 'Invalid price (should be positive)!';
		}
	}
}

Validator.isVoucher = function(selector) {
	return {
		selector: selector,
		test: function(value) {
			var regex = /^[a-z\s]{0,255}$/i;
			return regex.test(value) ? undefined : 'Invalid voucher code!';
		}
	}
}