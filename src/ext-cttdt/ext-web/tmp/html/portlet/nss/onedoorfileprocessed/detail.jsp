<%@ include file="/html/portlet/nss/onedoorfileprocessed/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>

<%@page import="com.nss.portlet.onedoorprocess.dto.PmlFilePcccDTO"%>
<%@page import="com.nss.portlet.onedoor.model.PmlFileReturningInfo"%>
<%@page import="com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile"%>
<%@page import="com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>

<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />

<%
	PmlFilePcccDTO filePcccDTO = (PmlFilePcccDTO) renderRequest.getAttribute("filePcccDTO");
	String state = (String) renderRequest.getAttribute("state");
	PmlFileReturningInfo fileReturningInfo = (PmlFileReturningInfo) renderRequest.getAttribute("fileReturningInfo");
	PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(filePcccDTO.getFileId());
	List<PmlFilePCCCAttachedFile> filePCCCAttachedFileList = (List<PmlFilePCCCAttachedFile>) renderRequest.getAttribute("filePCCCAttachedFileList");
%>
<form action="<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>">
	<portlet:param name="struts_action" value="/nss/onedoorfileprocessed/detail" /></portlet:actionURL>" 
	enctype="multipart/form-data" method="post" name="<portlet:namespace />fm_View">

<fieldset class="filborder_div">
<ul>
	<li style="width: 49.6%; margin-right: 0.8%" >
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-thongtinhoso"/></label>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-DSHS-mahoso"/>:</td>
				<td class="td-right"><%=filePcccDTO.getFileId() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-tenhoso"/>:</td>
				<td class="td-right"><%=filePcccDTO.getFileName() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-nguoinophoso"/>:</td>
				<td class="td-right"><%=filePcccDTO.getApplicantName() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-diachi"/>:</td>
				<td class="td-right"><%=filePcccDTO.getPermanentAddress() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-dienthoai"/>:</td>
				<td class="td-right"><%=filePcccDTO.getApplicantTelephone() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-ngaynophoso"/>:</td>
				<td class="td-right"><%= filePcccDTO.getApplicationDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(filePcccDTO.getApplicationDate()) : "" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-thoigiannophoso"/>:</td>
				<td class="td-right">
					<%= filePcccDTO.getApplicantTime() %>
				</td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-trangthaihoso"/>:</td>
				<td class="td-right td-right-trangthai">
					<%if (file.getExactReturningDate() != null) { %>
						<liferay-ui:message key="pccc-trangthaihoso-hoanthanh"/>
					<%} else {%>
						<%=state %>
					<% } %>
				</td>
			</tr>
			<tr valign="top">
				<td class="td-left" nowrap="nowrap"><liferay-ui:message key="pccc-TN-noidungxulycuoicung"/>:</td>
				<td class="td-right"><%= filePcccDTO.getLastTestProcessInfo().replace("/\\/", "<br />") %></td>
			</tr>
			<tr valign="top">
				<td class="td-left" valign="top">Barcode:</td>
				<td class="td-right"><font face="IDAutomationHC39M, Free 3 of 9,Free 3 of 9 Extended" style="font-size: 15px"><%=filePcccDTO.getNumberReceipt() %></font></td>
			</tr>
			</table>
		</fieldset>
		
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-hosothietke"/></label>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-congtrinh"/>:</td>
				<td class="td-right"><%=filePcccDTO.getProjectname() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-hangmuc"/>:</td>
				<td class="td-right"><%=filePcccDTO.getApplicantCategory() %></td>
			</tr>
			<tr>
				<td class="td-left" nowrap="nowrap"><liferay-ui:message key="pccc-TN-diadiemxaydung"/>:</td>
				<td class="td-right"><%=filePcccDTO.getAddressBuilder() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-chudautu"/>:</td>
				<td class="td-right"><%=filePcccDTO.getInvestor() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-donvithietke"/>:</td>
				<td class="td-right"><%=filePcccDTO.getDesignCop() %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-sobohoso"/>:</td>
				<td class="td-right"><%=filePcccDTO.getFileNumber() %></td>
			</tr>
			</table>
		</fieldset>
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-dinhkemtaptin"/></label>
			<table cellspacing="0" width="100%" class="bor_rgh">
				<%
					if (filePCCCAttachedFileList == null || filePCCCAttachedFileList.size() == 0) {
				%>
				<div style="text-align: center;"><liferay-ui:message key="pccc-TN-khongcohosodinhkem"/></div>
				<%
					} else {
				%>
				<tr>
					<td width="35px" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
					<td><liferay-ui:message key="pccc-TN-tentaptin"/></td>
				</tr>
				<logic:iterate id="filePCCCAttachedFile" name="filePCCCAttachedFileList" type="com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile" indexId="p">
					<tr valign="top">
						<td align="center"><%=p + 1 %></td>
						<td><a href="#" onclick="getHostName(this,'<%= filePCCCAttachedFile.getPath()%>' )"><%=filePCCCAttachedFile.getAttachedFileName() %></a></td>
					</tr>
				</logic:iterate>
				<%
					}
				%>
			</table>
		</fieldset>
	</li>
	<li style="width: 49.6%;">
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-thongtinquanly"/></label>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-nguoinhaplieu"/>:</td>
				<%
				User nguoiNhapLieu = UserLocalServiceUtil.getUser(Long.valueOf(filePcccDTO.getReceiver()));
				String firstName = nguoiNhapLieu.getFirstName();
				String lastName = nguoiNhapLieu.getLastName();
				String middleName = nguoiNhapLieu.getMiddleName();
				String receiveName = lastName + " " + middleName + " " + firstName;
				%>
				<td class="td-right"><%=receiveName %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-ngaynhaplieu"/>:</td>
				<td class="td-right"><%=filePcccDTO.getInputDataDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(filePcccDTO.getInputDataDate()) : "" %></td>
			</tr>
			<tr>
				<td class="td-left" nowrap="nowrap"><liferay-ui:message key="pccc-TN-ngayhentrakhach"/>:</td>
				<td class="td-right"><%=filePcccDTO.getExpectedReturingDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(filePcccDTO.getExpectedReturingDate()) : "" %></td>
			</tr>
			<tr valign="top">
				<td class="td-left"><liferay-ui:message key="pccc-TN-ghichu"/>:</td>
				<td class="td-right"><textarea class="textarea-display" readonly="" rows="3"><%=filePcccDTO.getNoteInformationManagement() %></textarea></td>
			</tr>
			</table>
		</fieldset>
		
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-thongtintrahoso"/></label>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-nguoitrahoso"/>:</td>
				<td class="td-right"><%=fileReturningInfo != null ? fileReturningInfo.getFileSender() : "" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-ngaytrahoso"/>:</td>
				<td class="td-right"><%=file.getExactReturningDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(file.getExactReturningDate()) : "" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-nguoinhanhoso"/>:</td>
				<%
				User nguoiNhanHS = null;
				String fn = "";
				String ln = "";
				String mn = "";
				try {
					nguoiNhanHS = UserLocalServiceUtil.getUser(Long.valueOf(file.getReceiver()));
					fn = nguoiNhanHS.getFirstName();
					ln = nguoiNhanHS.getLastName();
					mn = nguoiNhanHS.getMiddleName();
				}
				catch (Exception ex) {}
				String tenNguoiNhanHS = ln + " " + mn + " " + fn;
				%>
				<td class="td-right"><%="" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-sogiayphep"/>:</td>
				<td class="td-right"><%=fileReturningInfo != null ? fileReturningInfo.getLicenseNumber() : "" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-ngaycapphep"/>:</td>
				<td class="td-right"><%=(fileReturningInfo != null && fileReturningInfo.getIssuingDateLicense() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(fileReturningInfo.getIssuingDateLicense()) : "" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-ngaynhangiayphep"/>:</td>
				<td class="td-right"><%=(fileReturningInfo != null && fileReturningInfo.getReceiveLicenseDate() != null) ? new SimpleDateFormat("dd/MM/yyyy").format(fileReturningInfo.getReceiveLicenseDate()) : "" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-socongvan"/>:</td>
				<td class="td-right"><%=fileReturningInfo != null ? fileReturningInfo.getDocumentNumber() : "" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-sohoadon"/>:</td>
				<td class="td-right"><%=fileReturningInfo != null ? fileReturningInfo.getBillNumber() : "" %></td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-sotien"/>:</td>
				<td class="td-right"><%=fileReturningInfo != null ? fileReturningInfo.getNumberMoney() : "" %></td>
			</tr>
			<tr valign="top">
				<td class="td-left"><liferay-ui:message key="pccc-TN-ghichu"/>:</td>
				<td class="td-right"><textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="3"><%=fileReturningInfo != null ? fileReturningInfo.getNote() : "" %></textarea></td>
			</tr>
			</table>
		</fieldset>
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-ketluanvehosothamduyet"/></label>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr valign="top">
				<td class="td-left"><liferay-ui:message key="pccc-TN-ketluan"/>:</td>
				<td class="td-right"><textarea class="textarea-display" readonly="" rows="3"><%=filePcccDTO.getConclusion() %></textarea></td>
			</tr>
			</table>
		</fieldset>

	</li>
</ul>
<ul>
	<li style="width: 100%">
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-hosodinhkem"/></label>
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
						<td width="4%" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
						<td><liferay-ui:message key="pccc-TN-tenhosodinhkem"/></td>
						<td align="center"><liferay-ui:message key="pccc-TN-banchinh"/></td>
						<td align="center"><liferay-ui:message key="pccc-TN-banphu"/></td>
						<td width="20%"><liferay-ui:message key="pccc-TN-ghichu"/></td>
					</tr>
					<logic:iterate id="fileAttachedFile" name="fileAttachedFileList" type="com.nss.portlet.filetype.model.PmlFileAttachedFile" indexId="i">
						<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}">
							<td align="center"><%=i+1 %>.</td>
							<td><%=fileAttachedFile.getAttachedFileName() %></td>
							<td align="center"><%=fileAttachedFile.getOriginal() %></td>
							<td align="center"><%=fileAttachedFile.getCopy_() %></td>
							<td width="20%"><%=fileAttachedFile.getNote() %></td>
						</tr>
					</logic:iterate>
					</table>

					<table cellspacing="0" width="100%" style="display: none;" class="taglib-search-iterator table-pml">
					<tr class="portlet-section-header results-header" >
						<td width="4%" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
						<td><liferay-ui:message key="pccc-TN-tentailieubanve"/></td>
						<td align="center"><liferay-ui:message key="pccc-TN-soluong"/></td>
						<td width="20%"><liferay-ui:message key="pccc-TN-ghichu"/></td>
					</tr>
					<logic:iterate id="paintDocument" name="paintDocumentList" type="com.nss.portlet.onedoor.model.PmlPaintDocument" indexId="j">
						<tr>
							<td width="4%" align="center"><%=j+1 %>.</td>
							<td><%=paintDocument.getPaintDocumentName() %></td>
							<td align="center"><%=paintDocument.getQuantity() %></td>
							<td width="20%"><%=paintDocument.getNote() %></td>
						</tr>
					</logic:iterate>
					</table>
		</fieldset>
	</li>
	<li style="width: 100%">
		<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-TN-quytrinhxuly"/></label>
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
						<td width="4%" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
						<td width="20%"><liferay-ui:message key="pccc-XL-nguoigui"/></td>
						<td align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
						<td width="20%"><liferay-ui:message key="pccc-XL-nguoiNhan"/></td>
						<td align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></td>
						<td width="25%"><liferay-ui:message key="pccc-TN-noidungxuly"/></td>						
					</tr>
					<logic:iterate id="processDispose" name="processDisposeList" type="com.nss.portlet.onedoor.model.PmlProcessDispose" indexId="k">
						<tr class="${((k % 2)==0)? 'results-row':'tr_two results-row'}">
							<td align="center"><%=k+1 %>.</td>
							<%
							User processer = UserLocalServiceUtil.getUser(processDispose.getProcesser());
							String fin = processer.getFirstName();
							String lan = processer.getLastName();
							String min = processer.getMiddleName();
							String processerName = lan + " " + min + " " + fin;
							
							User receive = null;
							String nameReceive = "";
							if (processDispose.getReceiver() != 0) {
								receive = UserLocalServiceUtil.getUser(processDispose.getReceiver());
								nameReceive = receive.getLastName() + " " + receive.getMiddleName() + " " + receive.getFirstName();
							}
							
							%>
							<td><%=processDispose.getProcesser() != 0 ? processerName : ""%></td>
							<td align="center"><%=processDispose.getDateProcess() != null ? new SimpleDateFormat("dd/MM/yyyy").format(processDispose.getDateProcess()) : "" %></td>
							<td><%=processDispose.getReceiver() != 0 ? nameReceive : ""%></td>
							<td align="center"><%=processDispose.getReceiveDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(processDispose.getReceiveDate()) : "" %></td>
							<td><%=processDispose.getProcessInfomation().replace("/\\/", "<br />") %></td>
						</tr>
					</logic:iterate>
			</table>
		</fieldset>
	</li>
</ul>
</fieldset>

<div id ="table-button" align="right" >
	<%
	String redirect = ParamUtil.getString(request, "redirect");
	String currentURL = PortalUtil.getCurrentURL(request);
	%>	
		<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>" var="back">
			<portlet:param name="struts_action"	value="/nss/onedoorfileprocessed/view" />
		</portlet:actionURL> 
			<span onclick="javascript:submitForm(document.hrefFm,'<%= back %>');" >
				<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
			</span>
</div>
</form>
