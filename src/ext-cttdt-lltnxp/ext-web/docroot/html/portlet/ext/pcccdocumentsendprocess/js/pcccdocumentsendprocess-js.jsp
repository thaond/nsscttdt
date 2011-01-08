<script language="JavaScript" type="text/javascript">

function checknguoinhan(){
	var Error="";	
	var nguoinhan = document.getElementById('nguoiNhan');
	var processInformation = document.getElementById('processInformation');
	if (nguoinhan.selectedIndex == 0) {
		Error += "<liferay-ui:message key='chonnguoitiepnhanxuly'/>\n";
		nguoinhan.focus();
	}
	/*
	if (processInformation.value == "") {
		Error += "<liferay-ui:message key='nhapthongtinxuly'/>\n";
		processInformation.focus();
	}
	*/
	if (Error !="") {
		Error = "<liferay-ui:message key='doc-r8-alert'/>\n" + Error;
		alert(Error);
		Error = "";
		return false;
	}
		
	else{
		return true;
	}
}
function checkFormDepartment() {
		var processInformation = document.getElementById('processInformation')
	
		if ("" == processInformation.value.trim()) {
			alert('<liferay-ui:message key="nhapthongtinxuly"/>');
			processInformation.focus();
			return false;
		}
		if (!kiemtraphongban()) {
			alert("<liferay-ui:message key='vui-long-chon-phong-ban'/>!");
			return false;
		} 
		else {
			return true;
		}
}

function kiemtraphongban() {
	
	var departmentList = document.getElementsByName('<portlet:namespace/>DepartmentsSendId');
	
	var res = false;
	for ( var i = 0; i < departmentList.length; i++) {
		if (departmentList[i].checked) {
			res = true;
			break;
		}		
	}

	if(!res) {
		return false;
	}

	else {
		return true;
	}
		
}
function getSelectCheckBox(elementRow){		
	
	var idElementTd = elementRow.cells[0].id;	
	var elementInputDer = document.getElementById('DepartmentsSendId'+idElementTd);
	if (!elementInputDer.checked) {
		elementInputDer.checked = true;			
		
	}
	else if (elementInputDer.checked) {
		elementInputDer.checked = false;			
	}
}

function clickCheckBox(event,eleCheckBox)
{
	checkInUserAssign(eleCheckBox);
	if (event) // firefox
	{
		if (event.stopPropagation)
		{
			event.stopPropagation();
		}
		else event.cancelBubble = true;
				
	}
	else // windows
	{
		window.event.cancelBubble = true;
	}
	return true; // co the false, bo
}

/**
 *for user 
 */
 function checkUserAssign(elementRow) {
		
		var selectedOptionsmain = document.getElementById('selectedOptionsmain');
		var idElementTd = elementRow.cells[0].id;	
		var elementInput = document.getElementById('nguoiNhan'+idElementTd);
		
		if (!elementInput.checked) {
			elementInput.checked = true;			
			selectedOptionsmain.options[selectedOptionsmain.options.length] = new Option(elementRow.cells[1].firstChild.nodeValue, elementInput.value );
		}
		else {
			elementInput.checked = false;
			var arrOption = selectedOptionsmain.options;		
			for ( var i = 0; i < arrOption.length; i++) {
				if (elementInput.value == arrOption[i].value) {
						
					selectedOptionsmain.remove(i);
					break; 
				}
			} 	
		}
		
	}

	//ham nay goi khi click tren chinh checkbox chon phong ban hoac nhan vien
	function checkInUserAssign(elementInput) {	
		
		var selectedOptionsmain = document.getElementById('selectedOptionsmain');	
		if (elementInput.checked) {
			var elementRow = elementInput.parentNode.parentNode;				
			selectedOptionsmain.options[selectedOptionsmain.options.length] = new Option(elementRow.cells[1].firstChild.nodeValue, elementInput.value );
		}
		else {
			
			var arrOption = selectedOptionsmain.options;		
			for ( var i = 0; i < arrOption.length; i++) {
				if (elementInput.value == arrOption[i].value) {					
					selectedOptionsmain.remove(i);
					break; 
				}
			} 	
		}
		
	}
</script>
