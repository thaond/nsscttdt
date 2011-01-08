<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>
<script type='text/javascript'>
function documentRecordValidate(){
	var department = document.getElementById('departmentId');
	var isAgency = document.getElementById('isAgency');
	var agencyId = document.getElementById('agencyId');
	

	if (isAgency.checked == false & department.selectedIndex == 0){
	    alert("<liferay-ui:message key='vui-long-chon-phong-ban'/>\n");
	    department.focus();
	    return false;
	  }
	if (isAgency.checked == true & agencyId.selectedIndex == 0){
		alert("<liferay-ui:message key='vui-long-chon-so'/>\n");
		agencyId.focus();
		return false;
		} 
	if (!isCheckFileTypes()) {
		alert("<liferay-ui:message key='document_record_type'/>!");
		return false;
	} 
	else{
		return true;
	}	

}
function clickCheckBox(event,eleCheckBox)
{
	//checkIssuePlace(eleCheckBox);
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
	<!-- Begin
	var checkflag = "false";
	var checkall = document.getElementsByName("<portlet:namespace/>documentRecordTypeId");
	function check() {
	if (checkflag == "false") {
	for (i = 0; i < checkall.length; i++) {
		checkall[i].checked = true;}
	checkflag = "true";
	return "Uncheck All"; }
	else {
	for (i = 0; i < checkall.length; i++) {
		checkall[i].checked = false; }
	checkflag = "false";
	return ""; }
	}
	//  End -->


function isCheckFileTypes() {
	var arrRadioElements = document.getElementsByName("<portlet:namespace/>documentRecordTypeId");
	var res = false;
	for ( var i = 0; i < arrRadioElements.length; i++) {
		if (arrRadioElements[i].checked) {
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
	var elementInput = document.getElementById('documentRecordTypeId'+idElementTd);
	if (!elementInput.checked) {
		elementInput.checked = true;			
		
	}
	else if (elementInput.checked) {
		elementInput.checked = false;			
	}
}


function documentRecordValidateOld(){
	var department = document.getElementById('departmentId');
	var isAgency = document.getElementById('isAgency');
	var agencyId = document.getElementById('agencyId');
	

	if (isAgency.checked == false & department.selectedIndex == 0){
	    alert("<liferay-ui:message key='vui-long-chon-phong-ban'/>\n");
	    department.focus();
	    return false;
	  }
	if (isAgency.checked == true & agencyId.selectedIndex == 0){
		alert("<liferay-ui:message key='vui-long-chon-so'/>\n");
		agencyId.focus();
		return false;
		} 
	
	else{
		return true;
	}	

}
//yenlt update 23082010
function checkCurrentRecord(){
	var typeAgen = document.getElementById("typeAgen");
	var currentRecord = document.getElementById("currentRecord");
	
	var currentRecordTrim = currentRecord.value.trim();
	if (currentRecordTrim == ""){
		alert("<liferay-ui:message key='nhap-so-hien-tai'/>")
		currentRecord.focus();
		return false;		
	}
	
	if (isNaN(currentRecordTrim) == true) {
		alert("<liferay-ui:message key='chi-nhap-con-so'/>");
		currentRecord.focus();
		return false;
	}
	
	if (currentRecordTrim == "0"){
		alert("<liferay-ui:message key='nhap-so-lon-hon-0'/>")
		currentRecord.focus();
		return false;		
	}

	if (currentRecord.value.length >19) {
		alert("<liferay-ui:message key='so-hien-tai-nhap-khong-qua-muoi-chin-con-so'/>")
		currentRecord.focus();
		return false;
	}
	
	if (typeAgen.value == "agency") {
		var agency = document.getElementById("agencyId");
		
		if (agency.value == "[Ch\u1ECDn]"){
			alert("<liferay-ui:message key='chon-so'/>")
			agency.focus();
			return false;		
		}
	}
	
	if (typeAgen.value == "department") {
		var department = document.getElementById("departmentId");
		
		if (department.value == "[Ch\u1ECDn]"){
			alert("<liferay-ui:message key='vui-long-chon-phong-ban'/>")
			department.focus();
			return false;		
		}
	}
	// vu update 31122010
	var listBookDocument = document.<portlet:namespace />fm.<portlet:namespace/>listBookDocument.value = 
		Liferay.Util.listCheckedExcept(document.<portlet:namespace/>fm, "checkallbox");
	if(listBookDocument == ""){
		alert("<liferay-ui:message key='chon-loai-so-van-ban'/>");
		return false;
	}
	// end vu update
}
function checkCurrentNumberRecord(){
	var currentRecord = document.getElementById("currentRecord");
	var currentRecordTrim = currentRecord.value.trim() ;
	if (currentRecordTrim == ""){
		alert("<liferay-ui:message key='nhap-so-hien-tai'/>")
		currentRecord.focus();
		return false;		
	}
	
	if (isNaN(currentRecordTrim) == true) {
		alert("<liferay-ui:message key='chi-nhap-con-so'/>");
		currentRecord.focus();
		return false;
	}
	
	if (currentRecordTrim == "0"){
		alert("<liferay-ui:message key='nhap-so-lon-hon-0'/>")
		currentRecord.focus();
		return false;		
	}

	if (currentRecord.value.length >19) {
		alert("<liferay-ui:message key='so-hien-tai-nhap-khong-qua-muoi-chin-con-so'/>")
		currentRecord.focus();
		return false;
	}
	
}
// end yenlt 23082010
</script>