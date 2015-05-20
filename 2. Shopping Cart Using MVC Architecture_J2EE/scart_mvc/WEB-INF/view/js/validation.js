        function firstName()
        {
            var fn = document.getElementById("fn").value;
           
            if (fn.trim() == "") {
                window.alert("First Name Missing !!!");
                return false;
            }
            return true;
        }
        
        function lastName()
        {
            var ln = document.getElementById("ln").value;
     
            
            if (ln.trim() == "") {
                window.alert("Missing Last Name !!!");
                return false;
            }

            return true;
            
        }
        
        function userName()
        {
            var un = document.getElementById("un").value;
            if (un.trim() == "") {
                window.alert("Missing User Name !!!!");
                //fname.focus();
                return false;
            }
            return true;
        }
        
        function checkGender()
        {
            var gender  = document.getElementById("gender").value;
           
            
            if (gender.trim() == "")
            {
                window.alert("Missing Gender Field !!!!");
                return false;
            }
 
           
            return true;
        }
		
		function checkPresentAddress()
        {
            var present_add  = document.getElementById("present_add").value;
           
            
            if (present_add.trim() == "")
            {
                window.alert("Missing Present Address !!!!");
                return false;
            }
 
           
            return true;
        }
		
		function checkPermanentAddress()
        {
            var permanent_add  = document.getElementById("permanent_add").value;
           
            
            if (permanent_add.trim() == "")
            {
                window.alert("Missing Permanent Address !!!!");
                return false;
            }
 
           
            return true;
        }
		
		function checkContact()
        {
            var contact  = document.getElementById("contact").value;
           
            
            if (contact.trim() == "")
            {
                window.alert("Missing Contact !!!!");
                return false;
            }
 
           
            return true;
        }
		
		function checkQualification()
        {
            var quali  = document.getElementById("quali").value;
           
            
            if (quali.trim() == "")
            {
                window.alert("Missing Qualification !!!!");
                return false;
            }
 
           
            return true;
        }
       
		
        function checkPassword()
        {
            var pass  = document.getElementById("pass").value;
            var repass  = document.getElementById("conpass").value;
            var len = pass.length;
            
            if (pass.trim() == "")
            {
                window.alert("Missing password !!!!");
                return false;
            }
			
			if (repass.trim() == "")
            {
                window.alert("Missing Confirm password  Field!!!!");
                return false;
            }

            else if (pass != repass ) {
                window.alert("Password mismatched !!!");
                return false;
            }
           
            return true;
        }
		
        function Reg1() {
            if (firstName() == false )
            {
                return false;
            }
            if (lastName() == false) {
                return false;
            }
            if (userName() == false) {
                return false;
            }
            
            if (checkGender() == false) {
                return false;
            }
            return true;
        }
		
		function Reg2() {
            if (checkPresentAddress() == false )
            {
                return false;
            }
            if (checkPermanentAddress() == false) {
                return false;
            }
            if (checkContact() == false) {
                return false;
            }
            
            return true;
        }
		
		function Reg3() {
            if (checkQualification() == false )
            {
                return false;
            }
            if (checkPassword() == false) {
                return false;
            }
            
            return true;
        }
        
        function loginCheck() {
            var email = document.getElementById("un").value;
            var pass = document.getElementById("pass").value;
            if (email.trim() == "" || pass.trim() == "") {
                window.alert("Missing E-mail or Password!");
                return false;
            }
            return true;
        }
        
        

 
 