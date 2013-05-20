function paginate(currentPage) {
			document.newsForm.action="kindOfKey_init.action?currentPage="+currentPage;
			document.newsForm.submit();
		}