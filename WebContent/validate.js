function validate()
{
    var fname=document.module.firstName.value; 
    var lname=document.module.lastName.value;
    var email=document.module.email.value;
    var password=document.module.password.value;
    var cnfpassword=document.module.confirmPassword.value;

    if(fname==null || fname=="" || fname.length<3 )
    {
       // alert("name can't be left blank");
        document.getElementById("err_fname").innerHTML="Enter first name with min.3 characters";
    	return false;
    }
    
     if(lname==null || lname=="" )
    {
        document.getElementById("err_lname").innerHTML="Enter valid last name";
    	return false;
    }
     
     if(password!=cnfpassword)
    	 {
         document.getElementById("err_match").innerHTML="Passwords are mismatching";
     	return false;

    	 }
}