<%@ include file="/html/portlet/ext/documentfield/init.jsp" %>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/pcccdocumentreceiptClient.js'></script>
<script type='text/javascript' src='/dwr/interface/pcccDocumentRecordTypeClient.js'></script>

<script type="text/javascript" >
 
function validateForm()
{
	var code = document.getElementById("code");
	var name = document.getElementById("name");
	var department = document.getElementById("department");
	if (code.value.trim() == "") { 
		alert("<liferay-ui:message key='nhapmaphanloai'/> \n");
		code.focus();
		return false;
	}
	if (name.value.trim() == "" ) {
		alert("<liferay-ui:message key='nhaptenphanloai'/> \n");
		name.focus();
		return false;
	}
	/* trieu close 20100313 */
	if (department.value.trim() == "" ) {
		alert("<liferay-ui:message key='nhapphongban'/>");
		department.focus();
		return false;
	}
	/**/
	else{
		return true;
	}
} 

function validateEditForm() {
	var name = document.getElementById("name");
	var department = document.getElementById("department");

	if (name.value.trim() == "" ) {
		alert("<liferay-ui:message key='nhaptenphanloai'/> \n");
		name.focus();
		return false;
	}
	/* trieu close 20100313 */
	if (department.value.trim() == "" ) {
		alert("<liferay-ui:message key='nhapphongban'/>");
		department.focus();
		return false;
	}
	/**/
	else{
		return true;
	}
}

/*
function checkData() {
	var fieldCode = document.getElementById('code').value;

	if (fieldCode.trim() == "") {
		return true;
	}
	
	documentFieldDWRClient.countDocumentFieldByCode(fieldCode, function (data) {
		if (data > 0) {
			alert("<liferay-ui:message key='ma-linh-vuc-ho-so-khong-duoc-trung'/>");
			document.getElementById('code').value = "";
			document.getElementById('code').focus();
		}
	});
}

function checkFocusFieldCode() {
	checkData();
	return;
}*/

</script>
	
	
	