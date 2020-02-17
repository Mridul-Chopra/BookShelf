var books={};

 $(document).ready(function()
{
	
  $("#apply").click(function(){
	  
	
	var email=$('p[name=email]').text();
	var page=$('p[name=page]').text();
	var author=$('select[name=author]').val();
	var genre=$('select[name=genre]').val();
	
	console.log(author);
	console.log(genre);
	console.log(email);
	console.log(page);
	
    $.ajax(
    		{
    			url: "login", 
    			type: "POST",
    			success: function(result)
    						{
    							document.write(result);
    							document.close();
    						}
    		});
  });
  
  
  
  $(".cart-icon").click( 
  	function()
  	{
		$(".order-row").remove();
		for (const [key, value] of Object.entries(books))
		{
			console.log(key , value);
			let row = "<tr class='order-row'> "+
							"<td>"+key +"</td>"+
							"<td contenteditable=true>"+ value+"</td>"+
							"<td> <i class='material-icons remove-icon '>remove_shopping_cart</i> </td>"+
							"</tr>"
			$(".orders").append(row);
		}
  		$("#cart-box").css("top","0%");
  			
  	}
  );
  
 $(".orders").on('click' , 'i' ,
 
 function()
 {
	 let bookName = $(this).closest("td").prev().prev().text();
	 delete books[bookName];
	 $(this).closest("td").parent().remove();
 }
 );
 
 $(".place-order").click
 (
	 function()
	 {
		 console.log(JSON.stringify(books));
	 }
 )
 
 
  
  
  $(".cross-icon").click(
		  
		  	function()
		  	{
		  		$("#cart-box").css("top","-100%");
		  		console.log(books);
		  	}
		  
		  );
  
  $(".add-to-cart").click(
  
	function()
		  	{
		  		let bookName = $(this).closest("td").prev().prev().prev().prev().text();
				books[bookName]  = 1;
				console.log(books)
		  	}
	
  );
	
	
 
  
}); 