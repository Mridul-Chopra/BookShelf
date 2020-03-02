var books={}; 	// contains cart books
var authors=[];	// filter autjos
var genres=[];	//filter genres
var page=1;		// page number
var totalPages; // total pages available

/*
 *  increasing the page number
*/
function increase_page()
{
	if(page<totalPages)  // increase if less than total
	{
		page++;
	}
}



/*
 *  decrease the page number
*/
function decrease_page()
{
	if(page>1) // decrease if greater than 1
	{
		page--;
	}
}