 $(document).ready(function()
{
	 
	 $(".orders").on('keydown keyup' , '.quantity' , function(e)
	{
		  
		  var regExp = /[^0-9\b]/i;
		  //var regExp = /[a-z]/i;
		  		
		    var value = String.fromCharCode(e.which) || e.key;

		    // No letters
		    if (regExp.test(value)) 
		    {
		      e.preventDefault();
		      return false;
		    }
	  });
	 
	  
	$(".orders").on('focusout' , '.quantity' , function(e)
	{
		  
		if($(this).text()==0)
			$(this).text("1");
	 });

	

















});