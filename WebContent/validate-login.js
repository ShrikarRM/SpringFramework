function validateLogin() {
		var email = document.login.email.value;
		var password = document.login.password.value;
		var regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
		
		if (email == null || email == "") {
			document.getElementById("err_email").innerHTML = "Check your registered email";
			return false;
		} 
		if (!(email == null || email == "")) {
			document.getElementById("err_email").innerHTML = "";
		}
		
		if (!email.match(regex)) {
			document.getElementById("err_email").innerHTML = "Email is not in proper format";
			return false;
			}
		if (email.match(regex)) {
			document.getElementById("err_email").innerHTML = "";
		}
		
		if (password == null || password == "") {
				document.getElementById("err_password").innerHTML = "Enter valid password";
				return false;
			}
		if (!(password == null || password == "")) {
			document.getElementById("err_password").innerHTML = "";
		}
}