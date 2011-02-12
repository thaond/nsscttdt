<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/pcccdocumentreceiptClient.js'></script>
<script type="text/javascript" >

function trim () {
    return this.replace(/^\s*/, "").replace(/\s*$/, "");
}

function isNumeric(str) {
	if (!str || str.length == 0) return false;

	var strValid = "0123456789.-";
	var retVal = true;
	for (var idx = 0; idx < str.length; idx ++) {
		var symb = str.charAt(idx);
		if (strValid.indexOf(symb) == -1) {
			retVal = false;
			break;
		} // end if
	} // end for
	if (str.charAt(0) == '.' || str.charAt(0) == '0' || str.charAt(str.length - 1) == '.') {
		retVal = false;
	} // end if
	else if (str.indexOf('-') > 0) {
		retVal = false;
	} // end if
	else if (str.indexOf('.') >= 0) {
		// Kiem tra 2 dau .
		var curPos = str.indexOf('.');
		if (str.indexOf('.', curPos + 1) > 0) {
			retVal = false;
		} // end if
	} // end if
	return retVal;
}

function validateInputVal() {
	var issuingplaceid = document.getElementById('issuingplaceid');	
	var issuingplacename = document.getElementById('issuingplacename');	
	
	// Kiem tra ma so don vi phat hanh
	issuingplaceid.value = issuingplaceid.value;
	if (issuingplaceid.value == "") {
	    alert("<liferay-ui:message key='vui-long-nhap-ma-so' />");
		if (issuingplaceid.disabled == false) issuingplaceid.focus();
		return false;
	}	

	// Kiem tra ten don vi phat hanh
	issuingplacename.value = issuingplacename.value;
	if (issuingplacename.value == "") {
	    alert("<liferay-ui:message key='vui-long-nhap-ten-don-vi' />");
		if (issuingplacename.disabled == false) issuingplacename.focus();
		return false;
	}	
	return true;
}

function getChkValToList() {
	var retVal = "";
	var objChkes = document.getElementsByName("chkLevelSend");
	if (objChkes != null && objChkes.length > 0) {
		for (var idx = 0; idx < objChkes.length; idx ++) {
			var valId = 0;
			if (isNumeric(objChkes[idx].value) && objChkes[idx].value.indexOf('.') < 0 
			&& objChkes[idx].value.indexOf('-') < 0 && objChkes[idx].checked == true) {
				valId = objChkes[idx].value;
			} // end if
			if (valId > 0) {
				if (retVal.length > 0) {
					retVal += ";";
				} // end if
				retVal += valId;
			} // end if
		} // end for
	} // end if
	return retVal;
}

function addIssuingPlace() {
	// Kiem tra gia tri nhap vao
	if (validateInputVal() == false) return;
	// Lay gia tri
	var issuingPlaceId = document.getElementById("issuingplaceid").value;
	var issuingPlaceName = document.getElementById("issuingplacename").value;
	var signer = document.getElementById("signer").value;
	var lstLevelSendId = getChkValToList();
	if (lstLevelSendId == "" ) {
		alert("<liferay-ui:message key='vui-long-chon-cap-gui' />");
		
	} else {
		// Them vao database
		pcccdocumentreceiptClient.addPmlEdmIssuingPlaceSL(issuingPlaceId, issuingPlaceName, signer, lstLevelSendId, function (data) {
			if (data == true) { // Them thanh cong
				alert("<liferay-ui:message key='da-them-don-vi-moi' />");
				window.location.reload(true);
			}
			else {
				alert("<liferay-ui:message key='ky-hieu-khong-duoc-trung' />");
			}
		});
	}
}

function updateIssuingPlace() {
	// Kiem tra gia tri nhap vao
	if (validateInputVal() == false) return;
	// Lay gia tri
	var issuingPlaceId = document.getElementById("issuingplaceid").value;
	var hidIPId = document.getElementById("hidIPId").value;
	var issuingPlaceName = document.getElementById("issuingplacename").value;
	var signer = document.getElementById("signer").value;
	var lstLevelSendId = getChkValToList();
	// Kiem tra ma so bi thay doi
	if (hidIPId != issuingPlaceId && hidIPId != "") {
		alert("<liferay-ui:message key='vui-long-khong-thay-doi-ma-so' />");
		return;
	}
	// Cap nhat vao database
	pcccdocumentreceiptClient.updatePmlEdmIssuingPlace(issuingPlaceId, issuingPlaceName, signer, lstLevelSendId, function (data) {
		if (data == true) { // Cap nhat thanh cong
			alert("<liferay-ui:message key='da-cap-nhat-thong-tin-don-vi' />");
			window.location.reload(true);
		}
		else {
			alert("<liferay-ui:message key='khong-cap-nhat-duoc-thong-tin-don-vi.vui-long-kiem-tra-du-lieu-nhap' />");
		}
	});
}

</script>