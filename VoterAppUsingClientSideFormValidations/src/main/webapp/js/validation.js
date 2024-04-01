 function validate(frm){
	 //emepty the error message
	 document.getElementById("pnameErr").innerHTML="";
	 document.getElementById("pageErr").innerHTML="";
	 
	 //read from data
	 let name=frm.pname.value;
	 let age=frm.page.value;
	 
	 let vflag=true;
	 //write client side form validation logic
	   if(name==""){
		   vflag=false;
		   documnet.getElementById("pnameErr").innerHTML="<b>Person name must be Required</b>";
		   } 
		   else if(name.length<5 || name.length>10){
		      vflag=false;
		      document.getElementById("pnameErr").innerHTML="<b>Person name must be gatherthan 5 and lessthan 10</b>";
		      }
		    if(age==""){
				vflag=false;
				document.getElementById("pageErr").innerHTML="<b>Person age is required</b>";
				}
				else if(isNaN(age)){
					vflag=false;
					document.getElementById("pageErr").innerHTML="<b>Person age must be given as the numeric value</b>";
					}
				else if(age<0 || age>100){
					vflag=false;
					document.getElementById("pageErr").innerHTML="<b>Person age must be thwere in the range of 1 through 100</b>";
				}	
				return vflag;
				}
			
		   
	   
 