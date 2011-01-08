<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/pcccpopup.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<script type="text/javascript">

//ajax for popup
function getDocumentSend() {
	//call from onedoorDWR.java class	
	documentSendUtilClient.getIssuingPlace(getReturnIssuingPlace);
	
	
}
function getReturnIssuingPlace(data){	
	var trInfo = "";
	if(data.length > 0 ){
	
	trInfo += "	<table width='100%' height='100%' border='0' cellspacing='1' cellpadding='2' align='center'>";
	trInfo += "	<tr height='100%'>";
	trInfo += "	<td valign='top' height='380px' id='content' >";
	trInfo += "	<table indexId='i'  id='fileTypePopUp' cellpadding='2' cellspacing='1' width='100%' style='border:solid 1px #A3B2CC' border='0' bgcolor='#999999'>";
	trInfo += " <tr height='30' align='center' valign='middle' style='font-weight:bold;' bgcolor='#6CA1B4'>";
	trInfo += " <td colspan='4' style='color:#FFFFFF' align='left'><liferay-ui:message key='pccc-TN-chonquytrinh'/></td>";
	trInfo += " </tr> ";
	trInfo += " <tr height='30' align='center' valign='middle' style='font-weight:bold;' bgcolor='#EAEBDB'>";
	trInfo += "	<td width='4%'>#</td>";
	trInfo += "	<td width='4%'><liferay-ui:message key='pccc-TN-chon'/></td>";
	trInfo += "	<td width=15%'><liferay-ui:message key='pccc-TN-maquytrinh'/></td>";
	trInfo += "	<td><liferay-ui:message key='pccc-TN-tenquytrinh'/></td>";
	trInfo += "  </tr>";   
	
		for ( var i= 0; i < data.length; i++) {		
			var pmlIssuingPlace = data[i];
			var stype = "";	
			if (i % 2 == 0){
				stype = "rowOne";
			}
			else {
				stype = "rowTwo";
			}
			if(pmlIssuingPlace !=null){				
				trInfo += "<tr onClick='getDataHelp(this)' onMouseOut='nofocusColor(this)' onMouseOver='focusColor(this)' class='"+ stype+"'>";
				trInfo += "<td align='center' style='color:#c00;font-weight:bold;background-color:#EAEBDB'><span id='no'>"+ (i+1)  + "</span></td>";
				trInfo += "<td align='center' bgcolor='#EAEBDB'><input type='radio'  name='chk' id='chk_' value='"+ pmlIssuingPlace.issuingPlaceName + "#" +pmlIssuingPlace.issuingPlaceId + "' /></td>";
				trInfo += "<td style='color:#003366;padding-left:5px;padding-right:5px' align='left'><span>"+ pmlIssuingPlace.issuingPlaceId +  "</span></td>";
				trInfo += "<td id='issuingPlaceId' style='color:#003366;padding-left:5px;padding-right:5px' align='left'><span>"+ pmlIssuingPlace.issuingPlaceName+  "</span></td>";
				trInfo += "</tr>";
			}
			
		}
		trInfo += " <tr bgcolor='#FFFFFF'>";
		trInfo += "	<td align='right' colspan='4'>";
		trInfo += "		<input type='hidden' value='' id='hidden' >";
		trInfo += "		<input type='hidden' value='' id='fileTypeIdPop' >";
		trInfo += "		<input type='button' value='<liferay-ui:message key='pccc-TN-dongy'/>' id='dongy' name='OK' onClick='getData()'>";
		trInfo += "		<input type='button' value='<liferay-ui:message key='pccc-TN-boqua'/>' onclick='window.close();' name='Cancel'>";
		trInfo += "	</td>";
		trInfo += "  </tr>";
		trInfo += "</table>";
		trInfo += "</td>";
		trInfo += "</tr>";
		trInfo += "</table>";
		$('rowDocumentpop').innerHTML = trInfo;
	}
	else{	
		trInfo += "<table class='pos' width='100'>";
		trInfo += "<tr>";
		trInfo += "<th colspan='8' scope='col'><liferay-ui:message key='No-attached-file'/> </th>";
		trInfo += "</tr>";	
		trInfo += "</table>";
		$('rowDocumentpop').innerHTML = trInfo;
	}
	
}
window.onload = function () {
	getDocumentSend();
}
</script>
<div id="rowDocumentpop" > </div>