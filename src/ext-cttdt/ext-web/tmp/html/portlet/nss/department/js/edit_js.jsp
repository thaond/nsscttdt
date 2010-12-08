<%@ include file="/html/portlet/nss/department/init.jsp" %>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript' src='/dwr/interface/pmlDepartmentsLeaderDWRClient.js'></script>

<script type="text/javascript">
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