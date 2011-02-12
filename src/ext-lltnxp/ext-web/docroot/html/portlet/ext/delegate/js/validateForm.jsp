<%@ include file="/html/portlet/ext/delegate/init.jsp" %>
<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pmlUserUtilClient.js'></script>

<script language="JavaScript" type="text/javascript">

function validate(){
	var receiver = document.getElementById('receiver');
	var startDate = document.getElementById('startDate');
	var endDate = document.getElementById('endDate');

	// doi ngay hien tai sang string
	var ngayhientai = new Date();
	var date = ngayhientai.getDate();
	if (date < 10) {
		date = "0" + date;
	}
	var month = ngayhientai.getMonth() + 1;
	if (month < 10) {
		month = "0" + month;
	}
	var year = ngayhientai.getFullYear();
	var nht = year + "/" + month + "/" + date;

	// doi ngay bat dau sang string
	var arr = startDate.value.trim().split("/");
	if (arr[0].length == 1) {
		arr[0] = "0" + arr[0];
	}
	if (arr[1].length == 1) {
		arr[1] = "0" + arr[1];
	}
	var nbd = arr[2] + "/" + arr[1] + "/" + arr[0];

	// doi ngay ket thuc sang string
	var nktarr = endDate.value.trim().split("/");
	if (nktarr[0].length == 1) {
		nktarr[0] = "0" + nktarr[0];
	}
	if (nktarr[1] == 1) {
		nktarr[1] = "0" + nktarr[1];
	}
	var nkt = nktarr[2] + "/" + nktarr[1] + "/" + nktarr[0];
	
	if(receiver.selectedIndex == 0) {
		alert("<liferay-ui:message key='delegate-select-receiver'/>\n");
		receiver.focus();
		return false;
	}
	
	if(startDate.value.trim() == "") {
		alert("<liferay-ui:message key='delegate-startDate-input'/>\n");
		startDate.focus();
		return false;
	}
	
	if(endDate.value.trim() == "") {
		alert("<liferay-ui:message key='delegate-endDate-input'/>\n");
		endDate.focus();
		return false;
	}
	
	if(isDate(startDate.value.trim())==false){
		alert("<liferay-ui:message key='doc-r9-alert'/>");
		startDate.focus();
		return false;
	}

	if(isDate(endDate.value.trim())==false){
		alert("<liferay-ui:message key='doc-r9-alert'/>");
		endDate.focus();
		return false;
	}

	if (nht > nbd) {
		alert("<liferay-ui:message key='delegate-start-date-must-after-current-date'/>");
		startDate.focus();
		return false;
	}

	// minh update 20100524
	if (nbd >= nkt) {
		alert("<liferay-ui:message key='delegate-start-date-must-before-end-date'/>");
		endDate.focus();
		return false;
	}
	// end minh update 20100524

	if (!isCheckFileTypes()) {
		alert("<liferay-ui:message key='delegate-select-file-type'/>");
		return false;
	}
	
	else{
		return true;
	}
	
}

function clickCheckBox(event,eleCheckBox)
{
	if (event) // firefox
	{
		event.stopPropagation();
			
	}
	else // windows
		window.event.cancelBubble = true;
	return true; 
}

function checkFileTypes(elementRow){
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('fileTypes'+idElementTd);
	if (!elementInput.checked) {
		elementInput.checked = true;			
	}
	else {
		elementInput.checked = false;
	}
}

function isCheckFileTypes() {
	var arrRadioElements = document.getElementsByName("<portlet:namespace/>fileTypes");
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

function <portlet:namespace />changeDepartment() {
	var currUserObj = document.<portlet:namespace />fm.<portlet:namespace />currUser;
	var depObj = document.<portlet:namespace />fm.<portlet:namespace />department;
	var recObj = document.<portlet:namespace />fm.receiver;
	
	// Bo tat ca phan tu cua receiver, chi giu lai phan tu dau tien
	recObj.length = 1;
	pmlUserUtilClient.getPmlUserByDepartmentId(depObj.value, function(data) {
		if (data != null) {
			for (idx = 0; idx < data.length; idx ++) {
				// Bo qua nguoi uy quyen
				if (data[idx].userId == currUserObj.value || data[idx].screenName == "") {
					continue;
				}
				// Them option
				objNew = document.createElement("option");
				objNew.value = data[idx].userId;
				objNew.text = data[idx].lastName + " " + data[idx].middleName + " " + data[idx].firstName;
				recObj.options[recObj.options.length] = objNew;
			}
		}
	});
}
</script>