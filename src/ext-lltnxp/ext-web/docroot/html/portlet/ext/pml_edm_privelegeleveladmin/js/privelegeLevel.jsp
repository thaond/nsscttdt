<%@ include file="/html/portlet/ext/pml_edm_privelegeleveladmin/init.jsp" %>

<script type="text/javascript">

/**
function addPrivelegeLevel () {
	var tableLength = document.getElementById('privilegeLevelTable'). rows.length;
	var row = document.getElementById('privilegeLevelTable').insertRow(tableLength);
	row.style.height = "25px";
	if (tableLength % 2 == 0) {
		row.style.backgroundColor = "#E4E4E4";
	}
	else {
		row.style.backgroundColor = "#F2F2F2";
	}
	
	var stt = row.insertCell(0);
	var code = row.insertCell(1);
	var name = row.insertCell(2);
	var button = row.insertCell(3);

	var addButton = document.getElementById("addButton");
	addButton.disabled = true;
	
	stt.style.backgroundColor = "#EBEADB";
	stt.innerHTML = "<div style='text-align: right; padding-right: 3px'>" + tableLength + ".</div>";
	code.innerHTML = "";
	name.innerHTML = "<div style='text-align: center'><input style='width: 98%' type='text' name='privilegeName' id='nameAdd' /></div>";
	button.innerHTML = "<div align='center'>" + "<input type='submit' value='<liferay-ui:message key='citymanagement.button-save'/>' /><input onclick='deleteRow(this.parentNode.parentNode.parentNode.rowIndex);' type='button' value='<liferay-ui:message key='delete'/>' />";
}

function deleteRow(row) {
	document.getElementById('privilegeLevelTable').deleteRow(row);
	var addButton = document.getElementById("addButton"); 
	addButton.disabled = false;
}
*/

function editPriveledLevel (id) {
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	name.style.display = "none";	
	editName.style.display = "inline";	

	current.style.display = "none";	
	edit.style.display = "inline";
}

//minh update

//xoa do khan
function deletePriveledLevel(id, url) {
	var form = document.<portlet:namespace />fm;
	if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
		form.action = url;
		form.submit();
	}
}

function cancel (id) {
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	name.style.display = "inline";	
	editName.style.display = "none";	

	current.style.display = "inline";	
	edit.style.display = "none";
}

function validate () {
	var name = document.getElementById("nameAdd");
	if (name.value.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
		name.focus();
		return false;
	}
	else {
		return true;
	}
}

function updatePrivilegeLevel (id, url) {
	var form = document.<portlet:namespace />fm;
	form.action = url;
	var name = document.getElementById("hidden" + id);
	form.onsubmit = "";
	if (name.value.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
	}
	else {
		form.submit();
	}
}

</script>
