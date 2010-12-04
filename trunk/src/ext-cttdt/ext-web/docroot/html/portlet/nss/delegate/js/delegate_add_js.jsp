<%@ include file="/html/portlet/nss/delegate/init.jsp" %>

<script type='text/javascript' src='/dwr/engine.js'></script>
<script type='text/javascript' src='/dwr/util.js'></script>
<script type='text/javascript'src='/dwr/interface/pmlUserUtilClient.js'></script>

<script type="text/javascript">
	function <portlet:namespace />changeDepartment() {
		var currUserObj = document.<portlet:namespace />fm.<portlet:namespace />currUser;
		var depObj = document.<portlet:namespace />fm.<portlet:namespace />department;
		var recObj = document.<portlet:namespace />fm.receiver;
		
		recObj.length = 1;
		pmlUserUtilClient.getPmlUserByDepartmentId(depObj.value, function(data) {
			if (data != null) {
				for (idx = 0; idx < data.length; idx ++) {
					if (data[idx].userId == currUserObj.value || data[idx].screenName == "") {
						continue;
					}
					objNew = document.createElement("option");
					objNew.value = data[idx].userId;
					objNew.text = data[idx].lastName + " " + data[idx].middleName + " " + data[idx].firstName;
					recObj.options[recObj.options.length] = objNew;
				}
			}
		});
	}
</script>