<%@ include file="/html/portlet/nss/filestatus/init.jsp" %>


<script type="text/javascript">
function validateFileStatusForm() {
	var code = document.getElementById("pml_edm_file_status_code");
	var name = document.getElementById("pml_edm_file_status_name");
	//var erroMessage = "";
	if (code.value.trim() == "") {
		alert('<liferay-ui:message key="insert-file-status-code"/> ');
		code.focus();
		return false;
	}
	if (name.value.trim() == "") {
		alert('<liferay-ui:message key="insert-file-status-name"/> ');
		name.focus();
		return false;
	}
	/*
	if (erroMessage != "") {
		erroMessage = "Please-mpledmfilestatus \n" + erroMessage;
		alert(erroMessage);
		erroMessage = "";
		return false;
	}
	*/
	else {
		return true;
	}
}

/*
function checkData() {
	var code = document.getElementById('pml_edm_file_status_code').value;
	var codeHidden = document.getElementById('pml_edm_file_status_codeHidden').value;

	var type = document.getElementById('type').value;

	if (code.trim() == "") {
		return true;
	}
	
	fileStatusDWRClient.countFileStatusByCode(code, type, function (data) {
		if ((codeHidden != code && data > 0) || (codeHidden == code && data != 1)) {
			alert("<liferay-ui:message key='ma-trang-thai-khong-duoc-trung'/>");
			document.getElementById('pml_edm_file_status_code').value = codeHidden;
			document.getElementById('pml_edm_file_status_code').focus();
		}
	});
}

function checkFocusFileStatusCode() {
	checkData();
	return;
}
*/
</script>