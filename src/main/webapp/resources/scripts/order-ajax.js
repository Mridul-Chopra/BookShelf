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
	 
	 function print(data)
		{
		 	let txt = data.booksList;
		 	 totalPages =data.totalPages;
		 	
			$(".all tbody tr").remove();
			
			if(data.length==0)
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
			 
			 
/*			function getBooks(author , genre , email,page,myContextPath)
			{
				
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

			 
			 $("#next").click(function()
			{
				 increase_page();
				 filter();
			});
			 
			 $("#previous").click(function()
			{
				 decrease_page();
				 filter();
			});
			
			$(".page-number").click(function()
			{
				let pageNumber = $(this).text();
				if(isNaN(pageNumber))
				return;
				
				page = parseInt(pageNumber);
				filter();
			});
		 
			

			  
		function setPages(pageNumber)
		{
			let page1 = $("#previous").next();
			 let page2 = page1.next();
			 let page3 = page2.next();
			 
			if(((pageNumber+2)/3)%1 ==0)
			{
				 
				 page1.css("border","0.2em solid red");
				 page2.css("border","none");
				 page3.css("border","none");
				 
				 page1.children().text(pageNumber);
				 
				 if(pageNumber+1<=totalPages)
					 page2.children().text(pageNumber+1);
				 else
					 page2.children().text("..");
				 
				 if(pageNumber+2 <= totalPages)
					 page3.children().text(pageNumber+2);
				 else
					 page3.children().text("..");
			}
			else if((pageNumber/3)%1 ==0)
			{
				page1.children().text(pageNumber-2);
				page2.children().text(pageNumber-1);
				page3.children().text(pageNumber);
				
				page3.css("border","0.2em solid red");
				page1.css("border","none");
				page2.css("border","none");
			}
			else
			{
				page2.css("border","0.2em solid red");
				 page1.css("border","none");
				 page3.css("border","none");
			}
		}
});
		 
		 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
