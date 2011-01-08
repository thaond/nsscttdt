<%@ include file="/html/portlet/ext/onedoorreturn/init.jsp"%>

<script type="text/javascript">

function displayAndHidden () {
	
	  var divclass = document.getElementById('listdivpccc');
	  var full = document.getElementById('<portlet:namespace/>divcontent2');
	  if (divclass.style.display == "none") {		  
		  divclass.style.display = "inline";
		  document.getElementById("back").className = "back";
		  
	  }
	  else {
		  divclass.style.display = "none";
		  document.getElementById("back").className = "outer-full";
	  }
}

function checkonchangBR33(){
	var selectinput = document.getElementById('select');	
	var keyword = document.getElementById('<portlet:namespace/>keyword');	
	var loc = document.getElementById('<portlet:namespace/>loc');
	var comman = document.getElementById('<portlet:namespace/>comman');	
	var day = document.getElementById('<portlet:namespace/>day');
	var beginDate = document.getElementById('<portlet:namespace/>beginDate');
	var endDate = document.getElementById('<portlet:namespace/>endDate');
	
	var fileTypeFilterDiv = document.getElementById('<portlet:namespace/>fileTypeFilterDiv');
	var fileTypeFilter = document.getElementById('<portlet:namespace/>fileTypeFilter');
	
	if (selectinput.selectedIndex == 0 ){
		
		keyword.disabled = true;
		keyword.value = "";
		loc.disabled = true;
	  }

	else if (selectinput.selectedIndex > 0 && keyword.value == "") {
		keyword.disabled =false;
		loc.disabled = true;
	}

	if (selectinput.selectedIndex < 3) {
		comman.style.display = "inline";
		
		if(day != null){
			day.style.display = "none";
		}
		
		fileTypeFilterDiv.style.display = "none";
		
		beginDate.value = "";
		endDate.value = "";	
		document.getElementById('<portlet:namespace/>loc').disabled = true;
	}
	
	else if (selectinput.selectedIndex == 3){
		comman.style.display = "none";
		day.style.display = "none";
		fileTypeFilterDiv.style.display = "inline";
		beginDate.value = "";
		endDate.value = "";
		keyword.value = "";
		
		document.getElementById('<portlet:namespace/>loc').disabled = true;
	}
	
	else {
		comman.style.display = "none";
		day.style.display = "inline";
		fileTypeFilterDiv.style.display = "none";
		keyword.value = "";		
		document.getElementById('<portlet:namespace/>loc').disabled = false;
	}

}

function enableButton () 
{
	document.getElementById('<portlet:namespace/>loc').disabled = false;
}


function enableButton () 
{
	document.getElementById('<portlet:namespace/>loc').disabled = false;
}

function checkBeginEndDate(){
	var beginDate = document.getElementById('<portlet:namespace/>beginDate');
	var endDate = document.getElementById('<portlet:namespace/>endDate');
	var selectinput = document.getElementById('select');	
	
	var d1 = new Date(beginDate.value);
	var d2 = new Date(endDate.value)
	if (selectinput.selectedIndex > 4) {
		if ("" == beginDate.value || "" == endDate.value ||d1 > d2 ) {
			return false;
		}
		else{
			return true;
		}
	}
	else {
		return true;
	}
}

</script>