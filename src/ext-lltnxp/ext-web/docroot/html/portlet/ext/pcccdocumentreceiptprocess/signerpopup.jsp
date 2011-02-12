<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/pcccpopup.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<script type="text/javascript">
//ajax for popup
function getSigner() {
	//call from onedoorDWR.java class	
	documentSendUtilClient.getSigner(getReturnSigner);
}
function getReturnSigner(data){	
	var trInfo = "";
	if(data.length > 0 ){
		trInfo += "	<div id='content'>";
		trInfo += "	<table indexId='i'  id='fileTypePopUp' cellspacing='0' width='100%' style='padding-bottom: 25px'>";
		trInfo += " <tr class='bgpopup_tr'>";
		trInfo += "	<td width='35px' align='center' >##</td>";
		trInfo += "	<td width='35px' align='center'><liferay-ui:message key='pccc-TN-chon'/></td>";
		trInfo += "	<td width='30%'><liferay-ui:message key='pccc-TN-maquytrinh'/></td>";
		trInfo += "	<td ><liferay-ui:message key='pccc-TN-tenquytrinh'/></td>";
		trInfo += " </tr>";  
		 
		for ( var i= 0; i < data.length; i++) {		
			var pmlSigner = data[i];
			var stype = "";	
			if (i % 2 == 0){
				stype = "rowOneT1";
			}
			else {
				stype = "rowOneT2";
			}
			if(pmlSigner !=null){				
				trInfo += "<tr onClick='getDataHelpSigner(this)' class='"+ stype+"'>";
				trInfo += "<td align='center' ><span id='no'>"+ (i+1)  + "</span></td>";
				trInfo += "<td align='center' ><input type='radio'  name='chk' id='chk_' value='"+ pmlSigner.userName + "#" +pmlSigner.userId + "' /></td>";
				trInfo += "<td ><span>"+ pmlSigner.userId +  "</span></td>";
				trInfo += "<td id='signerId' ><span>"+ pmlSigner.userName+  "</span></td>";
				trInfo += "</tr>";
			}
		}
		trInfo += "</table>";
		trInfo += "<div id='btpopup_tn' align='right'>";
		trInfo += "		<input type='hidden' value='' id='hidden' >";
		trInfo += "		<input type='hidden' value='' id='fileTypeIdPop' >";
		trInfo += "		<input type='button' value='<liferay-ui:message key='pccc-TN-dongy'/>' id='dongy' name='OK' onClick='getDataSigner()'>";
		trInfo += "		<input style='margin-right: 10px' type='button' value='<liferay-ui:message key='pccc-TN-boqua'/>' onclick='window.close();' name='Cancel'>";
		trInfo += "</div>";
		trInfo += "</div>";
		
		$('rowDocumentpop').innerHTML = trInfo;
	}
	else {	
		trInfo += "<table class='pos' width='100' cellspacing='0'>";
		trInfo += "<tr>";
		trInfo += "<td colspan='8' scope='col'><liferay-ui:message key='No-attached-file'/></td>";
		trInfo += "</tr>";	
		trInfo += "</table>";
		
		$('rowDocumentpop').innerHTML = trInfo;
	}
	
}
window.onload = function () {
	getSigner();
}
</script>
<div id="rowDocumentpop" > </div>