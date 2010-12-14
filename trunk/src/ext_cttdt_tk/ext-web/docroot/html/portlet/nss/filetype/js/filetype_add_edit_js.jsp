<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<script type="text/javascript">
function <portlet:namespace />validateForm(form){
	var fileTypeCode = form._fileTypeCode;
	var fileTypeName = form._fileTypeName;
	var processTime = form._processTime;
	var currentReceiptNumber = form._currentReceiptNumber;

	if (fileTypeCode.value.trim() == "") {
		alert("<liferay-ui:message key='fileTypeCode-nhap-ma-loai-ho-so'/>");
		fileTypeCode.focus();
		return false;
	}
		
	if (fileTypeName.value.trim() == "") {
		alert("<liferay-ui:message key='fileTypeName-nhap-ten-loai-ho-so'/>");
		fileTypeName.focus();
		return false;
	}
	
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

</script>