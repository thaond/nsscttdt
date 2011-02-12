<%@ include file="/html/portlet/ext/pmlstreet/init.jsp" %>

<script type="text/javascript">

function editStreet (id) {
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	name.style.display = "none";	
	editName.style.display = "inline";	

	current.style.display = "none";	
	edit.style.display = "inline";
}

function deleteStreet(id, url) {
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

function updateStreet (id, url) {
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


function addStreet(url) {	
	var streetName = document.getElementById("streetName");
	var checkCode = document.getElementById("checkCode");
	if (checkCode.checked == "") {
		if (document.getElementById("streetCode").value.trim() == "") {
			alert("<liferay-ui:message key='nhap-ma-duong'/>");
			document.getElementById("streetCode").focus();
			return false;
		}
	}
	if (streetName.value.trim() == "") {
		alert("<liferay-ui:message key='nhap_ten_duong'/>");
		streetName.focus();
		return false;
	} else {
		submitForm(document.<portlet:namespace />fm, url);
	}

}

function changeTextStreetCode() {
	var streetCode = document.getElementById("streetCode");
	var checkCode = document.getElementById("checkCode");
	if (checkCode.checked == "") {
		streetCode.disabled = "";
	} else {
		streetCode.value = "";
		streetCode.disabled = "disabled";
	}
}
</script>