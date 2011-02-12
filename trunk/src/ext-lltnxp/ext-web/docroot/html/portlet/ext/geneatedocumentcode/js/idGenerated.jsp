<%@ include file="/html/portlet/ext/geneatedocumentcode/init.jsp" %>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/cityManagement.js'></script>
<script type='text/javascript'src='/dwr/interface/idGenerated.js'></script>

<script type="text/javascript">


function editGenerated (id) {
	var currentYear = document.getElementById("currentYear" + id);
	var editYear = document.getElementById("editYear" + id);
	var currentNumber = document.getElementById("currentNumber" + id);
	var editNumber = document.getElementById("editNumber" + id);
	var editButton = document.getElementById("editButton" + id);
	var saveButton = document.getElementById("saveButton" + id);
	var deleteButton = document.getElementById("deleteButton" + id);
	var cancelButton = document.getElementById("cancelButton" + id);

	currentYear.setAttribute("style", "display:none");
	editYear.setAttribute("style", "");
	currentNumber.setAttribute("style", "display:none");
	editNumber.setAttribute("style", "");
	editButton.setAttribute("style", "display:none");
	saveButton.setAttribute("style", "");
	deleteButton.setAttribute("style", "display:none");
	cancelButton.setAttribute("style", "");
}

function resetGenerated (id) {
	var currentYear = document.getElementById("currentYear" + id);
	var editYear = document.getElementById("editYear" + id);
	var currentNumber = document.getElementById("currentNumber" + id);
	var editNumber = document.getElementById("editNumber" + id);
	var editButton = document.getElementById("editButton" + id);
	var saveButton = document.getElementById("saveButton" + id);
	var deleteButton = document.getElementById("deleteButton" + id);
	var cancelButton = document.getElementById("cancelButton" + id);

	currentYear.setAttribute("style", "");
	editYear.setAttribute("style", "display:none");
	currentNumber.setAttribute("style", "");
	editNumber.setAttribute("style", "display:none");
	editButton.setAttribute("style", "");
	saveButton.setAttribute("style", "display:none");
	deleteButton.setAttribute("style", "");
	cancelButton.setAttribute("style", "display:none");
}

function updateIdGenerated (id) {
	
	var currentYear = document.getElementById("currentYear" + id);
	var editYear = document.getElementById("editYear" + id);
	var currentNumber = document.getElementById("currentNumber" + id);
	var editNumber = document.getElementById("editNumber" + id);
	var editButton = document.getElementById("editButton" + id);
	var saveButton = document.getElementById("saveButton" + id);
	var deleteButton = document.getElementById("deleteButton" + id);
	var cancelButton = document.getElementById("cancelButton" + id);

	var year = document.getElementById("year" + id);
	var currentValue = document.getElementById("currentValue" + id);
	idGenerated.editGenerateCode(id, year.value, currentValue.value, function() {});

	currentYear.innerHTML = year.value;
	currentNumber.innerHTML = currentValue.value;
	
	currentYear.setAttribute("style", "");
	editYear.setAttribute("style", "display:none");
	currentNumber.setAttribute("style", "");
	editNumber.setAttribute("style", "display:none");
	editButton.setAttribute("style", "");
	saveButton.setAttribute("style", "display:none");
	deleteButton.setAttribute("style", "");
	cancelButton.setAttribute("style", "display:none");
}

function deleteGenerate(row, id) {
	
	if (confirm('<%= UnicodeLanguageUtil.get(pageContext, "ban-co-that-su-muon-xoa") %>')) {
		idGenerated.deleteIdGenerated(id, function(){});	
 		document.getElementById('tableGenerated').deleteRow(row);
	}
	
 }

function addGenerated () {
	var addAction = document.getElementById("addAction");
	var addButton = document.getElementById("add");
	if (addAction.style.display == "none") {
		addAction.setAttribute("style", "");
		addButton.value = "<liferay-ui:message key='cancel'/>";
	}
	else {
		addAction.setAttribute("style", "display:none");
		addButton.value = "<liferay-ui:message key='add'/>";
	}
}
</script>
