var toplogin = document.getElementById("top-login");
var loginForm = document.getElementById("login_form");

var isShown = false;

function showOrNot(){
	
	if(isShown){
		loginForm.style.display = "none";
	}
	
	if(!isShown){
		loginForm.style.display = "block";
	}
	
	
	isShown=!isShown;
}


function closeDialog(){
	
	
	
		loginForm.style.display = "none";
	
	
	
	isShown=false;
}



$(document).ready(function(){
	  $(".owl-carousel").owlCarousel({
		  margin:3,
		  autoWidth:true,
		    nav:true,
		    loop:true
	  });
	});

