function validate() {
	var fname = document.module.firstName.value;
	var lname = document.module.lastName.value;
	var email = document.module.email.value;
	var password = document.module.password.value;
	var cnfpassword = document.module.confirmPassword.value;
	var regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";


	if (fname == null || fname == "" || fname.length < 3) {
		// alert("name can't be left blank");
		document.getElementById("err_fname").innerHTML = "Enter first name with min.3 characters";
		return false;
	} else {
		if (lname == null || lname == "") {
			document.getElementById("err_lname").innerHTML = "Enter valid last name";
			return false;
		} else {
			if (email == null || email == "") {
			document.getElementById("err_email").innerHTML = "Enter valid emailId";
			return false;
			}
			else{
				if(!email.match(regex)){
				document.getElementById("err_email").innerHTML="Email is not in proper format";
				return false;
			}
			 else{
			if (password == null || password == "") {
					document.getElementById("err_password").innerHTML = "Enter valid password";
					return false;
				} else {
					if (password != cnfpassword) {
						document.getElementById("err_match").innerHTML = "Passwords are mismatching";
						return false;

					} else {

						return true;
					}
				}

				}

			}
		}
	}
}