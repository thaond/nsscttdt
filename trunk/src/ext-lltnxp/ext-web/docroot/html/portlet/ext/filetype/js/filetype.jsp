<%@ include file="/html/portlet/ext/filetype/init.jsp"%>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/fileTypeDWRClient.js'></script>

<script type="text/javascript">
function <portlet:namespace />validateForm(form){
	var fileTypeCode = form._fileTypeCode;
	var fileTypeName = form._fileTypeName;
	var processTime = form._processTime;
	var currentReceiptNumber = form._currentReceiptNumber;

	// kiem tra Ma loai ho so
	if (fileTypeCode.value.trim() == "") {
		alert("<liferay-ui:message key='fileTypeCode-nhap-ma-loai-ho-so'/>");
		fileTypeCode.focus();
		return false;
	}
	/*else {
		checkFileTypeCode();
	}*/
		
	// kiem tra Ten loai ho so
	if (fileTypeName.value.trim() == "") {
		alert("<liferay-ui:message key='fileTypeName-nhap-ten-loai-ho-so'/>");
		fileTypeName.focus();
		return false;
	}
	
	// kiem tra Thoi gian xu ly
	if (isNaN(processTime.value) == true) {
		alert("<liferay-ui:message key='processTime-chi-nhap-con-so'/>");
		processTime.focus();
		return false;
	}
	if (processTime.value.trim() == "0"){
		alert("<liferay-ui:message key='processTime-nhap-so-lon-hon-0'/>");
		processTime.focus();
		return false;		
	}
	if (processTime.value.trim() == ""){
		alert("<liferay-ui:message key='processTime-nhap-thoi-gian-xu-ly'/>");
		processTime.focus();
		return false;		
	}

	// kiem tra so bien nhan hien tai
	if (currentReceiptNumber.value.trim() == "0"){
		alert("<liferay-ui:message key='currentReceiptNumber-nhap-so-lon-hon-0'/>");
		currentReceiptNumber.focus();
		return false;
	}
	if (isNaN(currentReceiptNumber.value) == true) {
		alert("<liferay-ui:message key='currentReceiptNumber-chi-nhap-con-so'/>");
		currentReceiptNumber.focus();
		return false;
	}
}

/*
function checkFileTypeCode() {
	var fileTypeCode = document.getElementById('fileTypeCode').value;
	var fileTypeCodeHidden = document.getElementById('fileTypeCodeHidden').value;

	if (fileTypeCode.trim() == "") {
		return true;
	}
	
	fileTypeDWRClient.countFileTypeByCode(fileTypeCode, function (data) {
		if ((fileTypeCodeHidden != fileTypeCode && data > 0) || (fileTypeCodeHidden == fileTypeCode && data != 1)) { // neu ton tai ma loai ho so
			alert("<liferay-ui:message key='ma-loai-ho-so-khong-duoc-trung'/>");
			document.getElementById('fileTypeCode').value = fileTypeCodeHidden;
			document.getElementById('fileTypeCode').focus();
		}
	});
}

function checkFocusFileTypeCode() {
	checkFileTypeCode();
	return;
}*/

</script>