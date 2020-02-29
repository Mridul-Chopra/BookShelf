$(document).ready(function()
{ 
	$(".plus").click(function()
	{		
		let data = "<input id='author' name='author' class='form-control' type='text' value=''>";
			data+= "<i class='fa fa-minus-square min' style='font-size:2em;color:red'></i>";
		$(".authors").append(data);
	});
	
	$(".authors").on('click','.min',function()
			{
				$(this).prev().remove();
				$(this).remove();
			});
	
	
	$(".authors").on('keydown keyup','input' , function(e){
		  
		 var regExp = new RegExp("^[0-9]*$");
		    var value = String.fromCharCode(e.which) || e.key;

		    // No letters
		    if (regExp.test(value)) {
		      e.preventDefault();
		      return false;
		    }
	  
		    
	  }
	);

});