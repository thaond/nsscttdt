<%@page import="com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend"%>
<%@page import="com.sgs.portlet.pmllevelsend.service.PmlEdmLevelSendLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace"%>
<%@page import="com.sgs.portlet.pmlissuingplace.service.PmlEdmIssuingPlaceLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmLevelSendDetailLocalServiceUtil"%>
<%@ include file="/html/portlet/ext/pcccdocumentreceipt/init.jsp" %>
<%@page import="java.util.List"%>
<%@ include file="/html/portlet/ext/pcccdocumentreceipt/js/addeditrelunit.jsp"%>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/themes/sgs-portal-skin/css/main.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
<style>
	.ie7 body,body,html {background: #f9ffff;overflow: auto;}
</style>

<%
	// Doc toan bo cap gui van ban
	List<PmlEdmLevelSend> levelSends = PmlEdmLevelSendLocalServiceUtil.getAll();
	// Doc toan bo don vi lien quan gui nhan van ban
	List<PmlEdmIssuingPlace> issPlaces = PmlEdmIssuingPlaceLocalServiceUtil.getAll();
	String strUnitSendId = ""; // Chuoi ma don vi gui, cach nhau bang dau ;
	String strLevelUnitSendId = ""; // Chuoi ma so cap gui cua don vi gui, cach nhau bang dau ;
	List<PmlEdmLevelSendDetail> levSenDets = PmlEdmLevelSendDetailLocalServiceUtil.getAll();
	if (!levSenDets.isEmpty()) {
		for (int idx = 0; idx < levSenDets.size(); idx ++) {
			PmlEdmLevelSendDetail lsdItem = (PmlEdmLevelSendDetail) levSenDets.get(idx);
			if (!lsdItem.getIssuingPlaceId().equals("") && lsdItem.getLevelSendId() > 0) {
				if (strUnitSendId.length() > 0) {
					strUnitSendId += ";";
				} // end if
				strUnitSendId += lsdItem.getIssuingPlaceId().trim();
				
				if (strLevelUnitSendId.length() > 0) {
					strLevelUnitSendId += ";";
				} // end if
				strLevelUnitSendId += String.valueOf(lsdItem.getLevelSendId());
			} // end if
		} // end for
	} // end if
%>

<script type="text/javascript">
	var strUnitSendId = "<%= strUnitSendId %>";
	var strLevelUnitSendId = "<%= strLevelUnitSendId %>";
	var arrUnitSendId = strUnitSendId.split(";");
	var arrLevelUnitSendId = strLevelUnitSendId.split(";");
</script>

<form name="fmAERelUnit" >
<div >
	<table width="100%" cellspacing="0" style="font-size: 12px;">
		<tr valign="top">
			<td width="40%" style="padding: 1%;">
				<ul>
				
					<liferay-ui:message key="recordtype.code" />&nbsp;<font color="red">(*)</font>:<br>
					<input type="text" name="issuingplaceid" id="issuingplaceid" style="width: 98%;" />
					<input type="hidden" name="hidIPId" id="hidIPId" />
				</ul>
				<ul>
					<liferay-ui:message key="name" />&nbsp;<font color="red">(*)</font>:<br>
					<input type="text" name="issuingplacename" id="issuingplacename" style="width: 98%;" />
				</ul>
				<ul>
					<liferay-ui:message key="pccc-cvdtn-nguoiky" /> (<liferay-ui:message key="phan-cach-ten-bang-dau-;" />):<br>
					<textarea rows="4" name="signer" id="signer" style="width: 98%;"></textarea>
				</ul>
			</td>
			<td style="padding-right: 5px;">
			<fieldset class="filborder">
			<legend class="laborder"><liferay-ui:message key="thuoc-cap-gui-van-ban" /></legend>
			<div style="width: 100%; height: 150px; overflow-x: none; overflow-y: auto;">
						<%
						if (!levelSends.isEmpty()) {
							for (int idx = 0; idx < levelSends.size(); idx ++) {
								PmlEdmLevelSend levelSendItem = (PmlEdmLevelSend) levelSends.get(idx);
						%>
								<ul class="chk_pup">
									<input type="checkbox" value="<%= levelSendItem.getLevelSendId() %>" name="chkLevelSend">&nbsp;
									<%= levelSendItem.getLevelSendName() %>
								</ul>
						<%
							} // end for
						} // end if
						%>
			</div>
			</fieldset>
			</td>
		</tr>
		<tr height="25">
			<td colspan="2" align="right">
				<input type="button" value="<liferay-ui:message key='save-new' />" onclick="addIssuingPlace()">&nbsp;
				<input type="button" value="<liferay-ui:message key='save-edit' />" onclick="updateIssuingPlace()">&nbsp;
				<input type="button" value="<liferay-ui:message key='close' />" onclick="window.opener.changeLevelSend(); window.close();">&nbsp;
			</td>
		</tr>
	</table>
	</div>
	<div style="height: 180px; overflow-x: none; overflow-y: auto;">
		<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%" style="font-size: 12px;">	
			
			<tr style="font-weight:bold;color: #fff;text-transform: uppercase;" bgcolor="#0579c3" align="center">
				<td colspan="4">
					<liferay-ui:message key="chinh-sua-don-vi-da-co-trong-he-thong" />
				</td>
			</tr>
			<tr class="portlet-section-header results-header" >
				<td width="4%" tr_two results-row><liferay-ui:message key="no." /></td>
				<td width="16%"><liferay-ui:message key="recordtype.code" /></td>
				<td width="45%"><liferay-ui:message key="name" /></td>
				<td><liferay-ui:message key="pccc-cvdtn-nguoiky" /></td>
			</tr>
			<%
			if (!issPlaces.isEmpty()) {
				for (int idx = 0; idx < issPlaces.size(); idx ++) {
					PmlEdmIssuingPlace issPlaItem = (PmlEdmIssuingPlace) issPlaces.get(idx);
					String style = "tr_two results-row";	
					if (idx % 2 == 0) style = "results-row";
			%>
					<tr onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);' onclick="selItemToEdit('<%= issPlaItem.getIssuingPlaceId() %>', '<%= issPlaItem.getIssuingPlaceName() %>', '<%= issPlaItem.getSigner() %>');" class="<%= style %>">
						<td align="center"><%= idx + 1 %></td>
						<td><%= issPlaItem.getIssuingPlaceId() %></td>
						<td><%= issPlaItem.getIssuingPlaceName() %></td>
						<td><%= issPlaItem.getSigner() %>&nbsp;</td>
					</tr>
			<%
				} // end for
			} // end if
			%>
		</table>
	</div>
</form>

<script language="javascript">
	function selItemToEdit(id, name, signer) {
		// Gan tham so vao cac doi tuong tren form
		document.getElementById("issuingplaceid").value = id;
		document.getElementById("hidIPId").value = id;
		document.getElementById("issuingplacename").value = name;
		document.getElementById("signer").value = signer;
		// Gan check box
		if (id.length > 0) {
			chkCheckbox(id);
		}
	}
	
	function chkCheckbox(id) {
		// Lay danh sach ma so cap gui tuong ung voi id cua don vi gui
		var strValidLevel = ""; // Danh sach ma so cap gui cua don vi gui trong he thong
		for (var idx = 0; idx < arrUnitSendId.length; idx ++) {
			if (arrUnitSendId[idx] == id) {
				if (strValidLevel.length > 0) {
					strValidLevel += ";";
				} // end if
				strValidLevel += arrLevelUnitSendId[idx];
			} // end if
		} // end for
		var objChkes = document.getElementsByName("chkLevelSend");
		if (objChkes != null && objChkes.length > 0) {
			for (idx = 0; idx < objChkes.length; idx ++) {
				var chkVal = objChkes[idx].value;
				objChkes[idx].checked = false;
				if (chkVal.length > 0 && strValidLevel.length > 0 && strValidLevel.indexOf(chkVal) >= 0) {
					if (strValidLevel.indexOf(chkVal) == 0 || 
					(strValidLevel.indexOf(chkVal) > 0 && strValidLevel.charAt(strValidLevel.indexOf(chkVal) - 1) == ';')) {
						if (strValidLevel.indexOf(chkVal) + chkVal.length == strValidLevel.length || 
						(strValidLevel.indexOf(chkVal) + chkVal.length < strValidLevel.length && strValidLevel.charAt(strValidLevel.indexOf(chkVal) + chkVal.length) == ';')) {
							// Valid
							objChkes[idx].checked = true;
						}
					} // end if
				} // end if
			} // end for
		} // end if
	}
</script>