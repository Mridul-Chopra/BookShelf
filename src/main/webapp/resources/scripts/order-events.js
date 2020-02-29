 $(document).ready(function()
{
	  
/*	 
-------------------DISPLAY ALL ITEMS IN CART ON CLICK ON CART----------------------------	 
*/	
	 $(".cart-icon").click( function()
	  {
  		
		/*
		 * Hide order button if cart is empty 
		*/
		if(parseInt($(".item-nos").text())>0)
		{
			$(".place-order").css("display","block");	// display
		}
		else
		{
			$(".place-order").css("display","none");	// hide
		}
  		
		$(".order-row").remove();	//empty the table first 
		
		/*
		 * Iterate through books and populate the order table with data
		*/
		for (const [key,value] of Object.entries(books))
		{
			
			let row = "<tr class='order-row'> "+
							"<td>"+key +"</td>"+
							"<td class = 'quantity' contenteditable=true>"+ value.quantity+"</td>"+
							"<td> <i class='material-icons remove-icon '>remove_shopping_cart</i> </td>"+
							"</tr>"
			$(".orders").append(row);
		}
		
		// showing the orders div
  		$("#cart-box").css("top","0%");
  			
  	});
 /*	 
 -------------------DISPLAY ALL ITEMS IN CART ON CLICK ON CART----------------------------	 
 								(ENDS)
 */	
	 

	 
	 
/*
----------------------- DELETE ITEMS ON CLICK OF REMOVE ICON-----------------------------
*/
	  $(".orders").on('click' , 'i' , function()
	  {
	 	 let bookName = $(this).closest("td").prev().prev().text(); // getting bookName
	 	 delete books[bookName];									// deleting the book
	 	 
	 	 $(this).closest("td").parent().remove();					// delete from UI table
	 	 
	 	 // revert the state of button
	 	 $(".all td:contains("+bookName+")").next().next().next().next().html("<button class='add-to-cart'>Add to 'Cart'</button>");
	  
	 	 $(".item-nos").text(parseInt($(".item-nos").text())- 1);// change the items number in cart
	 	 
	 	 /*
	 	  * Display the number of items if items is greater than 0
	 	 */
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
/*
  ----------------------- DELETE ITEMS ON CLICK OF EMOVE ICON-----------------------------
  									(ENDS)
*/	  
	  
	  
	  
/*
 -----------------------Closing the orders div on click on cross----------------	  
*/  
	  $(".cross-icon").click(function()
		{
	  		$(".order-message").text("");
	  		$("#cart-box").css("top","-100%");
		});
	  
/*
-----------------------Closing the orders div on click on cross----------------	  
									(ENDS)
*/  	  
	  
	  
	  
/*	  
---------------------Action on ADD TO CART button--------------------------  
*/
	  $(".all").on('click' , 'button' , function()
	 {
		$(".item-nos").text(parseInt($(".item-nos").text())+ 1);	// increasing number of items in cart
		
		/*
		 * Display the number of items only if more than 0
		*/
		if(parseInt($(".item-nos").text())>0)
		{
			$(".item-nos").css("display","block");	// display
		}
		else
		{
			$(".item-nos").css("display","none");	// do not display
		}
		
			let bookName = $(this).parent().parent().find('td').eq(0).text();		// getting bookname
			let bookId = $(this).parent().parent().find('td').eq(0).attr('name');	// getting id
			
			books[bookName]={'id':bookId,'quantity':1};  // setting bookName and quantity in books
			
			/*
			 * Changing button css properties			
			*/			
			$(this).attr("disabled",true);				
			$(this).text("Added");
			$(this).css("background-color","#88ff4d");
	 });
/*	  
  ---------------------Action on ADD TO CART button---------------------------- 
   								(ENDS)
*/
	  
	 
	  
});