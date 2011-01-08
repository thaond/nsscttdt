<%@ include file="/html/portlet/ext/issuingplace/init.jsp" %>

<script type="text/javascript">
function editIssuingPlace (id) {
	var note = document.getElementById("note" + id);
	var editNote = document.getElementById("editNote" + id);
	
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	note.setAttribute("style", "display:none");	
	editNote.setAttribute("style", "display:inline");
	
	name.setAttribute("style", "display:none");	
	editName.setAttribute("style", "display:inline");	

	current.setAttribute("style", "display:none");	
	edit.setAttribute("style", "display:inline");
	
}

function cancel (id) {

	var note = document.getElementById("note" + id);
	var editNote = document.getElementById("editNote" + id);
	
	var name = document.getElementById("name" + id);
	var editName = document.getElementById("editName" + id);
	var current = document.getElementById("current" + id);
	var edit = document.getElementById("edit" + id);

	note.setAttribute("style", "display:inline");	
	editNote.setAttribute("style", "display:none");	
	
	name.setAttribute("style", "display:inline");	
	editName.setAttribute("style", "display:none");	

	current.setAttribute("style", "display:inline");	
	edit.setAttribute("style", "display:none");

}

function updateIssuingPlace (id, url) {

	var form = document.<portlet:namespace />fm;
	form.action = url;
	var note = document.getElementById("hiddenNote" + id);
	var name = document.getElementById("hiddenName" + id);
	
	form.onsubmit = "";

	if (name.value.trim() == "") {
		alert('<liferay-ui:message key="vui-long-nhap-ten"/>');
		name.focus();
		
	}  else {
		form.submit();
	}

}

function deleteIssuingPlace (id, url) {

	var form = document.<portlet:namespace />fm;
	if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
		form.action = url;
		form.submit();
	}
	
}

function submitFormDepartment(form, url)
{
	if (!validateDisplay()) {
		alert("<liferay-ui:message key='vui-long-chon-tendonvi' />");
	} 
	else {
		form.action = url;
		form.submit();
	}
}

</script>	