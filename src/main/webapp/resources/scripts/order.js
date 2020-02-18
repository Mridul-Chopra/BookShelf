var books={};

 $(document).ready(function()
{
	
  $("#apply").click(function(){
	  
	
	var email=$('p[name=email]').text();
	var page=$('p[name=page]').text();
	var author=$('select[name=author]').val();
	var genre=$('select[name=genre]').val();
	
	let myContextPath = $(this).attr('myContextPath');
	
	console.log(author);
	console.log(genre);
	console.log(email);
	console.log(page);
	
	//console.log(myContextPath);
	
    $.ajax(
    		{
    			url: myContextPath+"/order/"+ email + "/" + page + "?author=" + author + "&genre=" + genre, 
    			type: "POST",
    			success: function(result)
    						{
    							print(result);
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
	 { 	 let myContextPath = $(this).attr('myContextPath');
		 let email=$('p[name=email]').text();
		 let x=1;
		 $(".orders tr td").each(
			
				 function(i)
				 {
					 if(x==1)
					 {	books[$(this).text()] = $(this).next("td").text();
					 	x++;
					 }
					 else if(x==2)
					{
						 x++;
					}
					 else if(x==3)
					 {
						 x=1;
					 }
				 }
		 
		 );
		 console.log(JSON.stringify(books));
	 
	 
		 $.ajax(
		    		{
		    			url: myContextPath+"/orderDetails?email="+email, 
		    			type: "POST",
		    			contentType: "application/json; charset=utf-8",
		    			data : JSON.stringify(books),
		    			success: function(result)
		    						{
		    							$(".order-message").text(result);
		    				
		    						}
		    		});
	 
	 
	 
	 
	 
	 } );
	 
	 

 
 
  
  
  $(".cross-icon").click(
		  
		  	function()
		  	{
		  		$("#cart-box").css("top","-100%");
		  	}
		  
		  );
  
  $(".all").on('click' , 'button' ,
  
	function()
		  	{
		  		let bookName = $(this).closest("td").prev().prev().prev().prev().text();
				books[bookName]  = 1;
		  	}
	
  );
	
	function print(txt)
	{
		if(txt.length==0)
		{
			$(".message").text("Sorry we did not find anything..  :(");
			return;
		}
		
		$(".books-row").remove();
		for(i=0;i<txt.length;i++)
		{
			let booksName = "<td>"+txt[i].bookName+"</td>";
			let genre = "<td>"+txt[i].genre+"</td>";
			
			let authorsList = "<td> <ul>";
			let authors =txt[i].authors
			for(j=0;j<authors.length;j++)
				{
					authorsList += "<li>"+authors[j]+"</li>";
				}
			 authorsList+="</td>";

			 let price ="<td> Rs. "+txt[i].price+"</td>";
			let button ="<td class='cart-button'><button class='add-to-cart'>Add to 'Cart'</button></td>"
			let row="<tr class='.books-row'>"+booksName+genre+authorsList+price+button+"</tr>"
			$(".all").append(row);
		}
	}
 
  
}); 