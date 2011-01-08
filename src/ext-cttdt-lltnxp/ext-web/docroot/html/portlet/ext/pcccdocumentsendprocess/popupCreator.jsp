<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.pcccdocumentsend.dto.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.signer.model.Signer"%>
<%@page import="com.sgs.portlet.signer.service.SignerLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.service.PmlUserLocalServiceUtil"%>
<%@page import="com.sgs.portlet.pmluser.model.PmlUser"%>
<%@page import="com.sgs.portlet.pmluser.service.persistence.PmlUserUtil"%>
<%@page import="com.sgs.portlet.position.model.Position"%>
<%@page import="com.sgs.portlet.position.service.persistence.PositionUtil"%>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@ include file="/html/portlet/ext/pcccdocumentsend/init.jsp" %>
<%@ include file="/html/portlet/ext/pcccdocumentsend/js/pccc-documentsend.jsp" %>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<script type="text/javascript">
function getSigner() {

}

window.onload = function () {
	getSigner();
}
</script>
<%
	// Doc danh sach nguoi ky van ban
	List<UserDTO> userDTOList =	new ArrayList<UserDTO>();
	// 20100201: Sap xep listUser theo alphabe
	List<User> listUser = PmlEdmDocumentReceiptLocalServiceUtil.getSortedListUser();
	// Lay danh sach user co quyen ky van ban di
	/*
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
	*/
	int idx = 0;
	for (User userItem : listUser) {
		UserDTO dto = new UserDTO();
		dto.setUserId(userItem.getUserId());
		dto.setAccount(userItem.getScreenName());
		dto.setUserName(PmlUserLocalServiceUtil.getFullName(userItem.getUserId()));
		String positionName = "";
		String departmentName = "";
		PmlUser pmlUser = null;
		try {
			pmlUser = PmlUserUtil.findByPrimaryKey(userItem.getUserId()); 
		} 
		catch (Exception e) {
			pmlUser = null;
		}
		
		if (pmlUser != null) {
			String departmentId = pmlUser.getDepartmentsId();
			Department department = null;
			try {
				department = DepartmentUtil.findByPrimaryKey(departmentId);
			} 
			catch (Exception e) {
				department = null;
			}
			if (department != null ) {
				departmentName = department.getDepartmentsName();
			}
		}
		
		dto.setDepartment(departmentName);
		userDTOList.add(dto);
		idx ++;
	}
%>
<div id="rowDocumentpop">
	<table width='100%' cellspacing='0' cellpadding='0' class='table-pml'>
		<tr height='100%'>
			<td valign='top' height='380px' id='content'>
				<table id='tblSignerList' cellspacing='0' cellpadding='0' class='table-pml' width='100%' style='bgcolor='#999999'>
					<tr height='30' align='center' valign='middle' style='font-weight:bold;' bgcolor='#6CA1B4'>
						<td colspan='4' style='color:#FFFFFF' align='left'><liferay-ui:message key='documentcode.chooseuser'/></td>
					</tr> 
					<tr height='30' align='center' valign='middle' style='font-weight:bold;' bgcolor='#EAEBDB'>
						<td width='2%' class='td-stt-pml'>##</td>
						<td width='4%' class='td-stt-pml'><liferay-ui:message key='pccc-TN-stt'/></td>
						<td class='td-stt-pml'><liferay-ui:message key='documentcode.username'/></td>
						<td class='td-stt-pml'><liferay-ui:message key='documentcode.chucvu'/></td>
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
							<tr onClick="getDataHelpCreator('chk_<%= idx %>')" id="<%= idx %>" onMouseOut='nofocusColor(this)' onMouseOver='focusColorWhite(this)' class="<%= styleRow %>">
								<td class='td-stt-pml' bgcolor='#EAEBDB' id="td1_<%= idx %>">
									<input type="radio" name="chk" id="chk_<%= idx %>" onClick='getDataHelpCreator(chk_<%= idx %>)' value='<%= userDTO.getUserName() + "#" + userDTO.getUserId() + "#" + userDTO.getDepartment() %>' />
								</td>
								<td class='td-stt-pml' id="td2_<%= idx %>" style='color:#c00;font-weight:bold;background-color:#EAEBDB'>
									<span id='no'><%= idx + 1 %></span></td>
								<td class='td-stt-pml' id="td3_<%= idx %>" style='color:#003366;' align='left'>
									<div align='left'><%= userDTO.getUserName() %></div></td>
								<td class='td-stt-pml' id="td4_<%= idx %>" style='color:#003366;' align='left'>
									<div align='left'><%= userDTO.getDepartment() %></div></td>
							</tr>
					<%
						} // end for
					} // end if
					%>
	
					<tr bgcolor='#FFFFFF'>
						<td align='right' colspan='4'>
							<input type='hidden' value='' id='hidden'>
							<input type='hidden' value='' id='creatorId'>
							<input type='hidden' value='' id='department'>
							<input type='button' class='button-width' value='<liferay-ui:message key='pccc-TN-dongy'/>' id='dongy' name='OK' onClick='getDataCreator()'>
							<input type='button' class='button-width' value='<liferay-ui:message key='pccc-TN-boqua'/>' onclick='window.close();' name='Cancle'>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</div>