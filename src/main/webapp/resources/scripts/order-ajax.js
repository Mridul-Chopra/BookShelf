 $(document).ready(function(){
	 
	 genres.push("all");
	 authors.push("all");
	 
	 //getBooks("All","All",$('p[name=email]').text(),$('p[name=page]').text(),"/bookshelf");
	 getBooks(
				 {
					page:'1',
				 	authors:['all'],
				 	genres:['all']
				 }
			 );
	 
	 /*
	 ------------------------Function to display data in table-------------------
	 */
	 function print(data)
		{
		 	let txt = data.booksList;  // getting books list
		 	 totalPages =data.totalPages;  // getting total pages
		 	
			$(".all tbody tr").remove();  // clearing table
			
			if(data.length==0)  // if no data
			{
				$(".message").text("Sorry we did not find anything..  :("); // display feedback
				return;
			}
			else
			{
				$(".message").text("");
			}
			
			/*
			 * Display data by iterting through it
			*/
			for(i=0;i<txt.length;i++)
			{
				let booksName = "<td name='"+txt[i].id+"'>"+txt[i].bookName+"</td>";  // get bookName
				let genre = "<td>"+txt[i].genre+"</td>";							// get genre
				
				let authorsList = "<td> <ul>";					
				let authors =txt[i].authors
				for(j=0;j<authors.length;j++)
				{
					authorsList += "<li>"+authors[j]+"</li>";		// adding authors to list
				}
				authorsList+="</td>";
				let price ="<td> Rs. "+txt[i].price+"</td>";		// getting price
				let button ="<td class='cart-button'><button class='add-to-cart'>Add to 'Cart'</button></td>" // adding button
				let row="<tr class='.books-row'>"+booksName+authorsList+genre+price+button+"</tr>"	
				$(".all").append(row);		// finnaly displaying
			}
		}
	 
	 /*
	 ------------------------Function to display data in table-------------------
	 									(ENDS)
	 */		
	 
	 
	/*
	 *  ----------------------------Function to apply filters by ajax--------------------------------- 
	*/	 
			 function filter(x)
			  {
				 getBooks(
						 {
							page:page,
						 	authors:authors,
						 	genres:genres
						 }
					 );
					
			  }

	/*
	 * ------------------------ Function to apply filters by ajax------------------------------ 
	 *  									(ENDS)
	*/	 	 
			 
			function getBooks(data)
			{
				console.log(JSON.stringify(data));
				$.ajax(
			    		{
			    			url: "/bookshelf/getBooks" , 
			    			type: "POST",
			    			contentType: "application/json; charset=utf-8",
			    			data : JSON.stringify(data), 
			    			success: function(result)
			    						{
			    							console.log(result);
			    							print(result);
			    							setPages(page);
			    						}
			    		});
				
			}
			 
			 
			 
 /*
			 
-----------------------	PLACING ORDERS ON CLICK OF PLACE ORDER BUTTON-----------------------------
			 
 */
			 $(".place-order").click(function()
			{ 	 
				 	let myContextPath = $(this).attr('myContextPath'); // getting context path
					 let email=$('p[name=email]').text();				// get email
					 let x=1;											// a pointer to help getting orders
					 let booksId={};
					 
					 /*
					  *  Getting order of the user an updating books[]
					 */
					 $(".orders tr td").each(function(i)
					 {
						 if(x==1)
						{
							let bookName = $(this).text();			// getting bookName
						 	let id = books[bookName].id;			// getting book Id
						 	booksId[id] = $(this).next("td").text(); // adding id and quantity to booksId
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
					 });
				 
				/*	 
					 MAKING AJAX CALL
				 */
					 $.ajax(
					    		{
					    			url: myContextPath+"/orderDetails?email="+email,		// send to this url 
					    			type: "POST",											// post request
					    			contentType: "application/json; charset=utf-8",			// defining type of content
					    			data : JSON.stringify(booksId), 							// converting order in json
					    			success: function(result)								// on success of ajax do this
					    						{
					    							// showing result status
					    							$(".order-message").text(result);
					    							
					    							// setting states of buttons and cart to original
					    							$(".all button").parent().html("<button class='add-to-cart'>Add to 'Cart'</button>");
					    							$(".item-nos").text("0");
					    							$(".item-nos").css("display","none");
					    							
					    							// empty selected books
					    							books={};
					    						}
					    		});
				 });
			 
 /*
-------------------------PLACING ORDER (ENDS)---------------------------------------
 */
			 
			 

			 
			 
			 
			 
 /*
------------------------------APPLY FILTER ON AUTHORS AND GENRE SELECTED----------------------
 */
			 $(".selected-author").change(function()
			{
				 let author=$(this).attr('value');
					
				if(this.checked)
				{	
					if(author=="all")
					{
						authors=[];
						$('.other-authors').prop('checked',false);
					}
					else
					{
						$('.all-authors').prop('checked',false);
					}
					
		 			 if(authors.indexOf(author) === -1) 
					 {
					      authors.unshift(author);
					 }
				}
				else
				{
					authors.splice(authors.indexOf(author),1);
				}
				
				page=1;
				filter();
				console.log(authors);
			});
									 
									 
			 $(".selected-genre").click(function()
			{
					 let genre=$(this).attr('value');
					 if(this.checked)
						{
						 	if(genre=="all")
						 	{
						 		genres=[];
						 		$('.other-genres').prop('checked',false);
						 	}
						 	else
						 	{
						 		$('.all-genres').prop('checked',false);
						 	}
				 			 if(genres.indexOf(genre) === -1) 
							 {
							      genres.unshift(genre);
							 }
						}
						else
						{
							genres.splice(genres.indexOf(genre),1);
						}
					 
					 page=1;
					 filter();
					 console.log(genres);
			});
		 
 /*
-----------------------------APPLY FILTER ON AUTHORS AND GENRE SELECTED---------------------------
		 									(ENDS)
 */ 
			 
			 
/*
 * -------------------------------- Pagination Buttons Functionality------------------------------------------		 
*/
			 
			 $("#next").click(function()
			{
				 increase_page();  // increase page number
				 filter();			// apply selected filter
			});
			 
			 $("#previous").click(function()
			{
				 decrease_page(); // decrease page number
				 filter(); 			// apply filter
			});
			
			$(".page-number").click(function()
			{
				let pageNumber = $(this).text();  // ge page Number
				if(isNaN(pageNumber))				// if not a number do nothing
				return;
				
				page = parseInt(pageNumber);		// set pageNumber
				filter();							// apply filter
			});
/*
 * ------------------------- Pagination Buttons Functionality------------------------------------------------
 *  									(ENDS)			 
*/		 
		
			
			
/*
 *  --------------------------Set Page numbers in the pager----------------------------			
*/		
		function setPages(pageNumber)
		{
			let page1 = $("#previous").next();  // get where to display page 1
			 let page2 = page1.next();			// get where to display page 2
			 let page3 = page2.next();			// get where to display page 3
			 
			if(((pageNumber+2)/3)%1 ==0)		// if page 1
			{
				 
				// setting css
				 page1.css("border","0.2em solid red");
				 page2.css("border","none");
				 page3.css("border","none");
				 
				 page1.children().text(pageNumber);// setting page number
				 
				 if(pageNumber+1<=totalPages)     // if data present for page then set
					 page2.children().text(pageNumber+1);
				 else
					 page2.children().text("..");
				 
				 if(pageNumber+2 <= totalPages)   // if data present for page then set
					 page3.children().text(pageNumber+2);
				 else
					 page3.children().text("..");
			} 
			else if((pageNumber/3)%1 ==0)  // if page = 3
			{
				
				// setting page numbers
				page1.children().text(pageNumber-2);
				page2.children().text(pageNumber-1);
				page3.children().text(pageNumber);
				
				
				// setting css
				page3.css("border","0.2em solid red");
				page1.css("border","none");
				page2.css("border","none");
			}
			else  // if page == 2
			{
				// setting css
				page2.css("border","0.2em solid red");
				 page1.css("border","none");
				 page3.css("border","none");
			}
		}
		
/*
--------------------------Setting page number in page number------------------------------
										(Ends)
*/		
		
/*
 *  Making Ajax Call on Search bar		
*/		
		$( "#myInput" ).keyup(function() {
			
			let bookName = $("#myInput").val();  // getting entered data
			$.ajax(
		    		{
		    			url: "/bookshelf/getBooksbyName?bookName="+bookName ,  // sending request
		    			type: "POST",											// post request
		    			success: function(result)
		    						{
		    							console.log(result);
		    							print(result);		
		    							setPages(page);
		    						}
		    		});
			
			});
/*
 *  Making Ajax Call on Search bar		
 *  		(ENDS )
*/
});
		 
		 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
