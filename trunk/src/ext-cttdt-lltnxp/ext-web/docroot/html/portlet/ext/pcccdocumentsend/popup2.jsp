<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pcccdocumentsend.dto.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.signer.model.Signer"%>
<%@page import="com.sgs.portlet.signer.service.SignerLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.position.service.persistence.PositionUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/themes/sgs-portal-skin/css/main.css" />
<script type='text/javascript' src='/html/js/liferay/tr.js'></script>
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
function getSigner() {
	//call from onedoorDWR.java class	
	// Dung cach parse dong nay se khong the them truong dong duoc.
	// Dong doan code sau lai, dung cach xuat ra table truc tiep	
	// xuancong close documentSendUtilClient.getSigner(getReturnSigner);
}

function getReturnSigner(data){	
	var trInfo = "";
	if(data.length > 0 ){


		trInfo += "	<div id='content'>";
		trInfo += "	<table indexId='i' id='fileTypePopUp' cellspacing='0' width='100%' style='padding-bottom: 25px;font-size: 12px;'>";
		trInfo += " <tr class='bgpopup_tr'>";
		trInfo += "	<td width='35px' align='center' >##</td>";
		trInfo += "	<td width='45px' align='center'><liferay-ui:message key='pccc-TN-stt'/></td>";
		trInfo += "	<td width='35%'><liferay-ui:message key='documentcode.username'/></td>";
		trInfo += "	<td ><liferay-ui:message key='documentcode.chucvu'/></td>";
		trInfo += " </tr>";   

	
		for ( var i= 0; i < data.length; i++) {		
			var pmlSigner = data[i];
			
			var stype = "";	
			if (i % 2 == 0){
				stype = "rowOneT1";
			}
			else {
				stype = "rowTwoT2";
			}
			if(pmlSigner !=null){				
				trInfo += "<tr onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);' onClick='getDataHelpSigner(this)' id='"+ i + "' class='"+ stype+"'>";
				trInfo += "<td align='center' id='td1_" + i+  "' ><input type='radio' onClick='getDataHelpSigner(this)' name='chk' id='chk_" + i +  "' value='"+ pmlSigner.userName + "#" +pmlSigner.userId + "#" + pmlSigner.position +"' /></td>";
				trInfo += "<td align='center' onClick='getDataHelpSigneOnRow(this)' id='td2_" + i+  "' ><span id='no'>"+ (i+1)  + "</span></td>";
				trInfo += "<td onClick='getDataHelpSigneOnRow(this)' id='td3_" + i+  "' ><div align='left'>"+ pmlSigner.userName+  "</div></td>";
				trInfo += "<td  onClick='getDataHelpSigneOnRow(this)' id='td4_" + i+  "'><div align='left'>"+ pmlSigner.position +  "</div></td>";
				trInfo += "</tr>";
			}
			
		}
		trInfo += "</table>";
				
		trInfo += "<div id='btpopup_tn' align='right'>";
		trInfo += "		<input type='hidden' value='' id='hidden' >";
		trInfo += "		<input type='hidden' value='' id='signerId' >";
		trInfo += "		<input type='hidden' value='' id='position' >";
		trInfo += "		<input type='button' class='button-width' value='<liferay-ui:message key='pccc-TN-dongy'/>' id='dongy' name='OK' onClick='getDataSigner()'>";
		trInfo += "		<input type='button' class='button-width' value='<liferay-ui:message key='pccc-TN-boqua'/>' onclick='window.close();' name='Cancle'>";
		trInfo += "	</div>";
		trInfo += "	</div>";
		$('rowDocumentpop').innerHTML = trInfo;
	}
	else{	
		trInfo += "<table class='pos' width='100%' cellspacing='0'>";
		trInfo += "<tr>";
		trInfo += "<td colspan='8' scope='col'><liferay-ui:message key='No-attached-file'/> </td>";
		trInfo += "</tr>";	
		trInfo += "</table>";
		$('rowDocumentpop').innerHTML = trInfo;
	}
	
}

window.onload = function () {
	getSigner();
}
</script>

<%
	// Doc danh sach nguoi ky van ban
	List<UserDTO> userDTOList =	new ArrayList<UserDTO>();
	//List<User> listUser = UserUtil.findAll();
	// 20100201: Sap xep listUser theo alphabe
	List<User> listUser = PmlEdmDocumentReceiptLocalServiceUtil.getSortedListUser();
	// Lay danh sach user co quyen ky van ban di
	List<Signer> signers = SignerLocalServiceUtil.getAll();
	List<String> signerUserIds = new ArrayList<String>();
	if (!signers.isEmpty()) {
		for (Signer signer : signers) {
			signerUserIds.add(String.valueOf(signer.getUserId()));
		} // end for
	} // end if
	// Xoa cac phan tu trong list listUser neu nguoi dung khong co quyen ky van ban
	int idx = 0;
	while (!listUser.isEmpty() && idx < listUser.size()) {
		if (signerUserIds.indexOf(String.valueOf(listUser.get(idx).getUserId())) < 0) {
			// Nguoi dung khong co quyen ky
			listUser.remove(idx);
		} // end if
		else {
			idx ++;
		} // end else
	} // end while

	for (User userItem : listUser) {
		UserDTO dto = new UserDTO();
		dto.setUserId(userItem.getUserId());
		dto.setAccount(userItem.getScreenName());
		dto.setUserName(PmlUserLocalServiceUtil.getFullName(userItem.getUserId()));
		String positionName = "";
		PmlUser pmlUser = null;
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userItem.getUserId()); 
		} 
		catch (Exception e) {
			pmlUser = null;
		}
		
		if (pmlUser != null) {
			String positionId = pmlUser.getPositionId();
			Position position = null;
			try {
				position = PositionUtil.findByPrimaryKey(positionId);
			} 
			catch (Exception e) {
				position = null;
			}
			if (position != null ) {
				positionName = position.getPositionName();
			}
		}
		
		dto.setPosition(positionName);
		
		userDTOList.add(dto);
	}
%>
<div id="rowDocumentpop">
<div id='content' >
<table indexId='i' id='tblSignerList' cellspacing='0' width='100%' class='taglib-search-iterator table-pml'>
<tr class='portlet-section-header results-header'>
	<td width='30px' align='center'>##</td>
	<td width='45px' align='center'><liferay-ui:message key='pccc-TN-stt'/></td>
	<td><liferay-ui:message key='documentcode.username'/></td>
	<td><liferay-ui:message key='documentcode.chucvu'/></td>
</tr>
<%
					if (!userDTOList.isEmpty()) {
						for (idx = 0; idx < userDTOList.size(); idx ++) {
							String styleRow = "rowTwoT2";
							if (idx % 2 == 0) {
								styleRow = "rowOneT1";
							} // end if
							UserDTO userDTO = (UserDTO) userDTOList.get(idx);
					%>
							<tr class="<%=(idx % 2) == 0 ? "results-row" : "tr_two results-row" %>" onClick="getDataHelpSigner('chk_<%= idx %>')" id="<%= idx %>" class="<%= styleRow %>" onmouseover='onMouseOverTr(this);' onmouseout='onMouseOutTr(this);'>
								<td id="td1_<%= idx %>" align="center">
									<input type="radio" name="chk" id="chk_<%= idx %>" onClick='getDataHelpSigner("chk_<%= idx %>")' value='<%= userDTO.getUserName() + "#" + userDTO.getUserId() + "#" + userDTO.getPosition() %>' />
								</td>
								<td align="center" onClick='getDataHelpSigneOnRow(this)' id="td2_<%= idx %>" >
									<span id='no'><%= idx + 1 %></span></td>
								<td onClick='getDataHelpSigneOnRow(this)' id="td3_<%= idx %>" >
									<div align='left'><%= userDTO.getUserName() %></div></td>
								<td onClick='getDataHelpSigneOnRow(this)' id="td4_<%= idx %>">
									<div align='left'><%= userDTO.getPosition() %></div></td>
							</tr>
					<%
						} // end for
					} // end if
					%>
			</table>
			<div id='btpopup_tn' align='right' style="width: 100%">
							<input type='hidden' value='' id='hidden'>
							<input type='hidden' value='' id='signerId'>
							<input type='hidden' value='' id='position'>
							<input class="buttonIE" type='button' value='<liferay-ui:message key='pccc-TN-dongy'/>' id='dongy' name='OK' onClick='getDataSigner()'>
							<input class="buttonIE" type='button' value='<liferay-ui:message key='pccc-TN-boqua'/>' onclick='window.close();' name='Cancle'>
							<input class="buttonIE" type='button' style="margin-right: 25px;" value='<liferay-ui:message key='add'/>' onclick="addNewSigner('tblSignerList', 'btnSaveNewSigner')">
							<input class="buttonIE" value='<liferay-ui:message key='save'/>' id='btnSaveNewSigner' type='hidden' onclick='saveNewSigner()'>
			</div>
</div>
</div>