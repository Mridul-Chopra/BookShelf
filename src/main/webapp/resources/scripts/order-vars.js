var books={};
var authors=[];
var genres=[];
var page=1;
var totalPages;

function increase_page()
{
	if(page<totalPages)
	{
		page++;
	}
}

function decrease_page()
{
	if(page>1)
	{
		page--;
	}
}