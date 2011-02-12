<%@ include file="/html/portlet/ext/onedoorpccc/init.jsp" %>
<%@ include file="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<style type="text/css">
	* {padding: 0; margin: 0;}
	body {padding: 0; margin: 0;font-family: arial,tahoma;}
	input[type="button"], input[type="submit"], input[type="reset"] {
	cursor: pointer;background:#b3f2ff url("/html/themes/sgs-portal-skin/images/imgbasic/bgbutton.jpg") repeat-x bottom left;border: 1px solid #60bffc;padding: 1px 12px;margin: 2px 0px 2px 4px ; color: #004470;font-weight: bolder;text-shadow: 0 1px 0 #bef3ff;font-family: arial, tahoma;
	}
	.ie7 input[type="button"],.ie7 input[type="submit"],.ie7 input[type="reset"] {
	cursor: pointer;background:#b3f2ff url("/html/themes/sgs-portal-skin/images/imgbasic/bgbutton.jpg") repeat-x bottom left;border: 1px solid #60bffc;padding: 1px 0;margin: 2px 4px 2px 0 ; color: #004470;font-weight: bolder;text-shadow: 0 1px 0 #bef3ff;font-family: arial, tahoma;
	}
</style>

<script type="text/javascript">

//ajax for popup
function getFileTypes() {
	//call from onedoorDWR.java class	
	OneDoorUtilClientpccc.getPmlFileTypes(getReturnFileTypes);
}

function getReturnFileTypes(data){	
	var trInfo = "";
	if(data.length > 0 ){
	trInfo += "	<div id='divparentpp'>";
	trInfo += "<div id='content'>";
	trInfo += "	<table indexId='i' cellspacing='0' id='fileTypePopUp' width='100%'>";
	trInfo += " <tr class='bgpopup_tr' valign='middle'>";
	trInfo += "	<td width='4%' align='center'>#</td>";
	trInfo += "	<td width='8%' align='center'><liferay-ui:message key='pccc-TN-chon'/></td>";
	trInfo += "	<td width=20%' ><liferay-ui:message key='pccc-TN-maquytrinh'/></td>";
	trInfo += "	<td><liferay-ui:message key='pccc-TN-tenquytrinh'/></td>";
	trInfo += "  </tr>";   
	
		for ( var i= 0; i < data.length; i++) {		
			var pmlFileTypes = data[i];
			var stype = "";	
			if (i % 2 == 0){
				stype = "rowOneT1";
			}
			else {
				stype = "rowTwoT2";
			}
			if(pmlFileTypes !=null){				
				trInfo += "<tr onClick='getDataHelp(this)'  class='"+ stype+"'>";
				trInfo += "<td align='center' ><span id='no'>"+ (i+1)  + "</span>.</td>";
				trInfo += "<td align='center' ><input type='radio'  name='chk' id='chk_' value='"+ pmlFileTypes.fileTypeName + "#" +pmlFileTypes.fileTypeId + "' /></td>";
				trInfo += "<td ><span>"+ pmlFileTypes.fileTypeCode +  "</span></td>";
				trInfo += "<td style='font-weight: bold;color: #023C60' id='fileTypeId' ><span>"+ pmlFileTypes.fileTypeName +  "</span></td>";
				trInfo += "</tr>";
			}
			
		}
		trInfo += "</table>";
		trInfo += "</div>";

		
		trInfo += "<div id='btpopup_tn' align='right'>";		
		trInfo += "	<input type='hidden' value='' id='hidden' >";
		trInfo += "	<input type='hidden' value='' id='fileTypeIdPop' >";
		trInfo += "	<input type='button' class='button-width' value='<liferay-ui:message key='pccc-TN-dongy'/>' id='dongy' name='OK' onClick='getData()'>";
		trInfo += "	<input style='margin-right: 30px;' type='button' class='button-width' value='<liferay-ui:message key='pccc-TN-boqua'/>' onclick='window.close();' name='Cancle'>";
		trInfo += "</div>";
		trInfo += "	</div>";		
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
	getFileTypes ();
}
</script>			  
<div id="rowDocumentpop" ></div> 