<%@ include file="/html/portlet/ext/pmledm_filestatus/init.jsp" %>

<script type="text/javascript" src="/dwr/engine.js"></script>
<script type="text/javascript" src="/dwr/util.js"></script>
<script type="text/javascript"
	src="/dwr/interface/PmlFileStatusStateProcessUtilClient.js"></script>
<script type="text/javascript">

	function validateFileStatusStateProcess(){
		var description = document.getElementById('description');
		var descriptiontrim = description.value.trim();
		if (descriptiontrim == ""){
			alert("<liferay-ui:message key='nhap-trang-thai-xu-ly'/>")
			description.focus();
			return false;		
		}
		if(!checkFileStatusStateProcess()){
			return false;
		}
		return true;
	}
	
	function checkFileStatusStateProcess(){
		var fileStatusId = document.getElementById('fileStatusId').value;
		var stateProcessId = document.getElementById('stateProcessId').value;
		var stateProcessIdChooice = document.getElementById('stateProcessIdChoice').value;
		PmlFileStatusStateProcessUtilClient.checkExitFileStatusStateProcess(fileStatusId,stateProcessId,stateProcessIdChooice,{callback:checkFileStatusStateProcessHelp, async:false});
	
		var result = document.getElementById('checkFileStatusStateProcess').value;
		  if ("false" == result ) {
			  return false;
		  }
	
		  else {
			  return true;
		  }	
	}
	
	var checkFileStatusStateProcessHelp = function (data){
		if(data == true){			 
			 alert('<liferay-ui:message key="ten-trang-thai-xu-ly-da-ton-tai-vui-long-chon-ten-trang-thai-xu-ly-khac"/>');
			 document.getElementById('checkFileStatusStateProcess').value = "false";
		}
		else {
			document.getElementById('checkFileStatusStateProcess').value = "true";
		}
	};
	
</script>