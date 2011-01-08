<%@ include file="/html/portlet/ext/departmentleader/init.jsp" %>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/departmentDWRClient.js'></script>
<script type='text/javascript' src='/dwr/interface/pmlDepartmentsLeaderDWRClient.js'></script>

<script type="text/javascript">

function getSelectRadio(elementRow){		
	
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('departmentId'+idElementTd)
	if (!elementInput.checked) {
		elementInput.checked = true;			
		
	}
	else if (elementInput.checked) {
		elementInput.checked = false;			
	}
}

function clickRadio(event)
{
	
	if (event) // firefox
	{
		event.stopPropagation();	
	}
	else // windows
		window.event.cancelBubble = true;
	return true; // co the false, bo
}

//minh update
function submitFormDepartment(form, url)
{
	if (!validateDisplay()) {
		alert("<liferay-ui:message key='vui-long-chon-phong-ban' />");
	} 
	else {
		form.action = url;
		form.submit();
	}
}

function submitFormDeleteDepartment(form, url) {
	if (!validateDisplay()) {
		alert("<liferay-ui:message key='vui-long-chon-phong-ban' />");
		
	} 
	else {
		if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "ban-muon-xoa-phong-ban-nay-khoi-he-thong") %>')) {
			form.action = url;
			form.submit();
		}
		
	}
}

function validateDisplay() {
	
	var arrRadioElements = document.getElementsByName("departmentId");
	
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

function getIsLeaderCheckBox(elementRow){		
	
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('isLeader'+idElementTd)
	if (!elementInput.checked) {
		elementInput.checked = true;			
		
	}
	else if (elementInput.checked) {
		elementInput.checked = false;			
	}
}

function validate() {
	var isLeader = document.getElementsByName("isLeader");
	var result = false;
	for ( var i = 0; i < isLeader.length; i++) {
		if (isLeader[i].checked == true) {
			result = true;
			break;
		}
	}
	//if (result == false) {
	//	alert("<liferay-ui:message key='vui-long-chon-nguoi-xu-ly'/>");
	//}
	return true;
}

function getSelectCheckBox(elementRow){		
	
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('pmlUserId'+idElementTd)
	if (!elementInput.checked) {
		elementInput.checked = true;			
		
	}
	else if (elementInput.checked) {
		elementInput.checked = false;			
	}
}

function validateEditForm() {
	var departmentName = document.getElementById("departmentName");

	if (departmentName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-phong-ban' />");
		departmentName.focus()
		return false;
	}
	
	else {
		return true;
	}
}


function validateAddForm() {
	var departmentCode = document.getElementById("departmentCode");
	var departmentName = document.getElementById("departmentName");
	var abbreviateName = document.getElementById("abbreviateName");
	if (departmentCode.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ma-phong-ban' />");
		departmentCode.focus()
		return false;
	}
	if (departmentName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-phong-ban' />");
		departmentName.focus()
		return false;
	}
	if (abbreviateName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap-ten-viet-tat' />");
		abbreviateName.focus()
		return false;
	}
	else {
		return true;
	}
}
function clickCheckBox(event,eleCheckBox)
{
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

function getHSCVSelectCheckBox(elementRow){
	var idElementTd = elementRow.cells[0].id;	
	var elementInput = document.getElementById('hscv'+idElementTd)
	if (!elementInput.checked) {
		elementInput.checked = true;			
		
	}
	else if (elementInput.checked) {
		elementInput.checked = false;			
	}
}

/*
function checkData() {
	var departmentCode = document.getElementById('departmentCode').value;

	if (departmentCode.trim() == "") {
		return true;
	}
	
	departmentDWRClient.countDepartmentByCode(departmentCode, function (data) {
		if (data > 0) { // neu ton tai ma phong ban
			alert("<liferay-ui:message key='ma-phong-ban-khong-duoc-trung'/>");
			document.getElementById('departmentCode').value = "";
			document.getElementById('departmentCode').focus();
		}
	});
}

function checkFocusDepartmentCode() {
	checkData();
	return;
}*/


function checkUserIsDepLeader(userChecked) {
	var userId = userChecked.value;
	pmlDepartmentsLeaderDWRClient.checkUserIsLeader(userId, function (data) {
		if (data) {
			alert("<liferay-ui:message key='khong-the-bo-lanh-dao-phong-khoi-phong-ban'/>");
			userChecked.checked = "checked";
		}
	});
}
</script>