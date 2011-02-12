<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp" %>
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<link type="text/css" rel="stylesheet" href="/html/themes/sgs-portal-skin/css/main.css" />
<style type="text/css">
	* {padding: 0; margin: 0;}
	body {padding: 0; margin: 0;font-family: arial,tahoma;font-size: 12px;background: #f9ffff;}
	#btpopup_tn input[type="button"],#btpopup_tn input[type="submit"],#btpopup_tn input[type="reset"] {
	 cursor: pointer;background:#b3f2ff url("/html/themes/sgs-portal-skin/images/imgbasic/bgbutton.jpg") repeat-x bottom left;border: 1px solid #60bffc;padding: 1px 12px;margin: 2px 0px 2px 4px ; color: #004470;font-weight: bolder;text-shadow: 0 1px 0 #bef3ff;font-family: arial, tahoma;
	}
	.buttonIE {
	cursor: pointer;background:#b3f2ff url("/html/themes/sgs-portal-skin/images/imgbasic/bgbutton.jpg") repeat-x bottom left;border: 1px solid #60bffc;padding: 1px 12px;margin: 2px 0px 2px 4px ; color: #004470;font-weight: bolder;text-shadow: 0 1px 0 #bef3ff;font-family: arial, tahoma;		
	}
	.taglib-search-iterator td {font-size: 12px;}
	.taglib-search-iterator .results-header td {
			background: #D5F5FF url("/html/themes/sgs-portal-skin/images/imgbasic/bgresult.jpg") repeat-x left top;
		}
	
</style>
<script type="text/javascript">
//ajax for popup
function getDocumentSend() {
	//call from onedoorDWR.java class	
	documentSendUtilClient.getIssuingPlace(getReturnIssuingPlace);
	
	
}
function getReturnIssuingPlace(data){	
	var trInfo = "";
	if(data.length > 0 ){

		
	trInfo += "	<div id='content'>";
	trInfo += "	<table id='fileTypePopUp' cellspacing='0' width='100%' style='padding-bottom: 25px' class='taglib-search-iterator table-pml'>";
	trInfo += " <tr class='portlet-section-header results-header'>";
	trInfo += "	<td width='35px' align='center' >##</td>";
	trInfo += "	<td width='35px' align='center'><liferay-ui:message key='pccc-TN-stt'/></td>";
	trInfo += "	<td width='20%'><liferay-ui:message key='recordtype.code'/></td>";
	trInfo += "	<td width='40%'><liferay-ui:message key='documentcode.name'/></td>";
	trInfo += "	<td><liferay-ui:message key='documentcode.desc'/></td>";
	trInfo += " </tr>";   
	
		for ( var i= 0; i < data.length; i++) {		
			var pmlIssuingPlace = data[i];
			var stype = "";	
			if (i % 2 == 0){
				stype = "results-row";
			}
			else {
				stype = "tr_two results-row";
			}
			if(pmlIssuingPlace !=null){				
				trInfo += "<tr onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);' class='"+ stype+"' onClick='getDataHelpSigner(\"chk_"+ pmlIssuingPlace.issuingPlaceId + "\")'>";
				trInfo += "<td align='center' id='"+ pmlIssuingPlace.issuingPlaceId + "' ><input onclick='clickCheckBox(event,this)' type='checkbox'  name='chk' id='chk_" + pmlIssuingPlace.issuingPlaceId+  "' value='"+ pmlIssuingPlace.issuingPlaceName + "#" +pmlIssuingPlace.issuingPlaceId + "' /></td>";
				trInfo += "<td align='center'><span id='no'>"+ (i+1)  + ".</span></td>";
				//xuancong close trInfo += "<td id='issuingPlaceId' style='color:#003366;'><div align='left'>"+ pmlIssuingPlace.issuingPlaceName+  "</div></td>";
				//xuancong close trInfo += "<td id='issuingPlaceId' style='color:#003366;' ><div align='left'>"+ pmlIssuingPlace.note+  "</div></td>";
				trInfo += "<td><div align='left'>" + pmlIssuingPlace.issuingPlaceId + "</div></td>";
				trInfo += "<td><div align='left'>" + pmlIssuingPlace.issuingPlaceName + "</div></td>";
				trInfo += "<td><div align='left'>" + pmlIssuingPlace.note + "</div></td>";
				trInfo += "</tr>";
			}			
		}
		
		trInfo += "</table>";
		trInfo += "<div id='btpopup_tn' align='right'>";
		trInfo += "		<input type='hidden' value='' id='hidden' >";
		trInfo += "		<input type='hidden' value='' id='fileTypeIdPop' >";
		trInfo += "		<input class='buttonIE' type='button' value='<liferay-ui:message key='pccc-TN-dongy'/>' id='dongy' name='OK' onClick='getData()'>";
		trInfo += "		<input class='buttonIE'  type='button' value='<liferay-ui:message key='pccc-TN-boqua'/>' onclick='window.close();' name='Cancle'>";
		trInfo += "		<input class='buttonIE' style='margin-right: 25px'  type='button' value='<liferay-ui:message key='add'/>' onclick='addNewRelUnit(\"fileTypePopUp\", \"btnSaveNewRelUnit\")'>";
		trInfo += "		<input class='buttonIE'   type='hidden' value='<liferay-ui:message key='save'/>' id='btnSaveNewRelUnit'  onclick='saveNewRelUnit()'>";
		trInfo += "</div>";
		trInfo += "</div>";
		$('rowDocumentpop').innerHTML = trInfo;
	}
	else{	
		trInfo += "<table class='pos' width='100' cellspacing='0'>";
		trInfo += "<tr>";
		trInfo += "<td colspan='8' scope='col'><liferay-ui:message key='No-attached-file'/> </td>";
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
