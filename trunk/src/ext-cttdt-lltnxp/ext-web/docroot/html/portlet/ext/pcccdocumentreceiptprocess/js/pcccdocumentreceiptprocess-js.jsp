<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/init.jsp" %>

<script language="JavaScript" type="text/javascript">

function checknguoinhan(){
	var Error="";	
	var nguoinhan = document.getElementById('nguoiNhan');
	//var processInformation = document.getElementById('processInformation');
	if (nguoinhan.selectedIndex == 0) {
		Error += "<liferay-ui:message key='chonnguoitiepnhanxuly'/>\n";
		nguoinhan.focus();
	}
	/*
	if (processInformation.value == "") {
		Error += "<liferay-ui:message key='nhapthongtinxuly'/>\n";
		processInformation.focus();
	}
	*/
	if (Error !="") {
		Error = "<liferay-ui:message key='doc-r8-alert'/>\n" + Error;
		alert(Error);
		Error = "";
		return false;
	}
		
	else{
		return true;
	}
}


</script>
