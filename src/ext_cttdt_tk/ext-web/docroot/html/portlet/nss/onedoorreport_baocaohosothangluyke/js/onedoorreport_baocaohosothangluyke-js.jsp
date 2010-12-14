<%@ include file="/html/portlet/nss/onedoorreport_baocaohosothangluyke/init.jsp" %>

<script language="JavaScript" type="text/javascript">
	function <portlet:namespace/>compare2Date(fromDate, toDate) {
		
		var strFromDate = fromDate.value.toString();
		var objFromDate = nss.stringToDate(strFromDate,"dmy");
		var strToDate = toDate.value.toString();
		var objToDate = nss.stringToDate(strToDate,"dmy");
	
		if(objFromDate > objToDate) {
			return false;
		}
		return true;
	}
	
	function <portlet:namespace/>checkForm(form) {
		var fromDate = document.getElementById('<portlet:namespace/>fromDate');
		var toDate = document.getElementById('<portlet:namespace/>toDate');
		if(fromDate.value == "") {
			fromDate.focus();
			return false;
		}
		if(isDate(fromDate.value) == false) {
			alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
			fromDate.focus();
			return false;
		} 
		if(toDate.value == "") {
			toDate.focus();
			return false;
		}
		if(isDate(toDate.value) == false) {
			alert("\u0110\u1ecbnh d\u1ea1ng ng\u00e0y kh\u00f4ng ch\u00ednh x\u00e1c.");
			toDate.focus();
			return false;
		}
		if(<portlet:namespace/>compare2Date(fromDate, toDate) == false) {
			alert("Ch\u1ecdn ng\u00e0y th\u1ed1ng k\u00ea kh\u00f4ng ch\u00ednh x\u00e1c.\n('T\u1eeb ng\u00e0y' ph\u1ea3i nh\u1ecf h\u01a1n ho\u1eb7c b\u1eb1ng '\u0110\u1ebfn ng\u00e0y').");
			fromDate.focus();
			return false;
		}
		return true;
	}
	
	function displayAndHiddenReport() {
		
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
</script>