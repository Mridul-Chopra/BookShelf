var books={};
var author="All";
var genre="All";

 $(document).ready(function()
{
	 $("#authorsInput").on("keyup", function() {
		 var value = $(this).val().toLowerCase();
		 $(".dropdown-menu .selected-author").filter(function() {
			 $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		 });
	 });
	 $("#genresInput").on("keyup", function() {
		 var value = $(this).val().toLowerCase();
		 $(".dropdown-menu .selected-genre").filter(function() {
			 $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
		 });
	 });


		 $("#myInput").on("keyup", function() {
			 var value = $(this).val().toLowerCase();
			 $(".all tbody tr").filter(function() {
				 $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			 });
		 });

	 $(".selected-author").click(function()
	{
		 author=$(this).text();
		$(this).parent().prev().text("AUTHOR : "+author);
		filter(this);
	});
	 
	 
	 $(".selected-genre").click(function()
	{
		 genre=$(this).text();
		 $(this).parent().prev().text("GENRE : "+genre);
		 filter(this);
	});
	 
	 
  $("#apply").click(function(){
	  
	
	var email=$('p[name=email]').text();
	var page=$('p[name=page]').text();
	
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
    						}
    		});
  });
  
  function filter(x)
  {
	  var email=$('p[name=email]').text();
		var page=$('p[name=page]').text();
		
		let myContextPath = $(x).attr('myContextPath');
		
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
	    						}
	    		});
  }

  
  $(".cart-icon").click( 
  	function()
  	{
  		if(parseInt($(".item-nos").text())>0)
		{
			$(".place-order").css("display","block");
		}
		else
		{
			$(".place-order").css("display","none");
			
		}
  		
		$(".order-row").remove();
		for (const [key, value] of Object.entries(books))
		{
			
			let row = "<tr class='order-row'> "+
							"<td>"+key +"</td>"+
							"<td class = 'quantity' contenteditable=true>"+ value+"</td>"+
							"<td> <i class='material-icons remove-icon '>remove_shopping_cart</i> </td>"+
							"</tr>"
			$(".orders").append(row);
		}
  		$("#cart-box").css("top","0%");
  			
  	}
  );
  
  $(".orders").on('keydown keyup' , '.quantity' , function(e){
	  
	  var regExp = /[a-z]/i;
	    var value = String.fromCharCode(e.which) || e.key;

	    // No letters
	    if (regExp.test(value)) {
	      e.preventDefault();
	      return false;
	    }
  
	    
  }
);
  
$(".orders").on('focusout' , '.quantity' , function(e){
	  
	if($(this).text()==0)
		$(this).text("1");
  }
);
  
 $(".orders").on('click' , 'i' ,
 
 function()
 {
	 let bookName = $(this).closest("td").prev().prev().text();
	 delete books[bookName];
	 $(this).closest("td").parent().remove();
	 $(".all td:contains("+bookName+")").next().next().next().next().html("<button class='add-to-cart'>Add to 'Cart'</button>");
 
	 $(".item-nos").text(	parseInt($(".item-nos").text())- 1);
	 if(parseInt($(".item-nos").text())>0)
		{
			$(".item-nos").css("display","block");
			$(".place-order").css("display","block");
		}
		else
		{
			$(".item-nos").css("display","none");
			$(".place-order").css("display","none");
			
		}
 
 });
 
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
		    							$(".all button").parent().html("<button class='add-to-cart'>Add to 'Cart'</button>");
		    							$(".item-nos").text("0");
		    							$(".item-nos").css("display","none");
		    							books={};
		    						}
		    		});
	 
	 
	 
	 
	 
	 } );
	 
	 

 
 
  
  
  $(".cross-icon").click(
		  
		  	function()
		  	{
		  		$(".order-message").text("");
		  		$("#cart-box").css("top","-100%");
		  	}
		  
		  );
  
  $(".all").on('click' , 'button' ,
  
	function()
		  	{
	  		
	  $(".item-nos").text(	parseInt($(".item-nos").text())+ 1);
	  		if(parseInt($(".item-nos").text())>0)
	  			{
	  				$(".item-nos").css("display","block");
	  			}
	  			else
	  			{
	  				$(".item-nos").css("display","none");
	  			}
	  		
		  		let bookName = $(this).closest("td").prev().prev().prev().prev().text();
				books[bookName]  = 1;
				$(this).attr("disabled",true);
				$(this).text("Added");
				$(this).css("background-color","#88ff4d");
		  	}
	
  );
	
	function print(txt)
	{
		$(".all tbody tr").remove();
		
		if(txt.length==0)
		{
			$(".message").text("Sorry we did not find anything..  :(");
			return;
		}
		else
		{
			$(".message").text("");
		}
		for(i=0;i<txt.length;i++)
		{
			let booksName = "<td name='"+txt[i].id+"'>"+txt[i].bookName+"</td>";
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
			let row="<tr class='.books-row'>"+booksName+authorsList+genre+price+button+"</tr>"
			$(".all").append(row);
		}
	}
 
  
}); 