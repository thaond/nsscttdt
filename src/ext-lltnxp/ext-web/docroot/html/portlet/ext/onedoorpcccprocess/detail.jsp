<%@ include file="/html/portlet/ext/onedoorpcccprocess/init.jsp" %>
<%@ include file="/html/portlet/ext/onedoorpcccprocess/js/onedoorpcccprocess-js.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlProcessDispose"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="com.sgs.portlet.onedoorpccc.dto.PmlFilePcccDTO"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlFileAttachedFile"%>
<%@page import="com.sgs.portlet.onedoorpccc.model.PmlFileReturningInfo"%>
<%@page import="com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile"%>
<%@page import="com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil"%>
<%@page import="com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<link type="text/css" rel="stylesheet" href="/html/css/changeColorRow.css" />
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/onedoorpcccprocess/css/style.css" />

<%

	PmlFilePcccDTO filePcccDTO = (PmlFilePcccDTO) renderRequest.getAttribute("filePcccDTO");
	String state = (String) renderRequest.getAttribute("state");
	List<PmlFileAttachedFile> fileAttachedFileList = (List<PmlFileAttachedFile>) renderRequest.getAttribute("fileAttachedFileList");
	List<PmlFileAttachedFile> paintDocumentList = (List<PmlFileAttachedFile>) renderRequest.getAttribute("paintDocumentList");
	List<PmlFileAttachedFile> processDisposeList = (List<PmlFileAttachedFile>) renderRequest.getAttribute("processDisposeList");
	PmlFileReturningInfo fileReturningInfo = (PmlFileReturningInfo) renderRequest.getAttribute("fileReturningInfo");
	PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileUtil.findByPrimaryKey(filePcccDTO.getFileId());
	List<PmlFilePCCCAttachedFile> filePCCCAttachedFileList = (List<PmlFilePCCCAttachedFile>) renderRequest.getAttribute("filePCCCAttachedFileList");
	// yenlt update 24052010
	String processValue = ParamUtil.getString(renderRequest, "processValue");
	String isDelegate = ParamUtil.getString(renderRequest, "isDelegate");
	// end yenlt 24052010
%>


<fieldset class="filborder_div">
<ul >
	<li style="width: 49.6%; margin-right: 0.8%" >
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-thongtinhoso"/></legend>
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
				<!--  minh update 20100524 -->
				<!-- %=filePcccDTO.getApplicationDate() != null ? new SimpleDateFormat("hh:mm:ss").format(filePcccDTO.getApplicationDate()) : "" %-->
				<%= filePcccDTO.getApplicantTime() %>
				<!-- end minh update 20100524 -->
				</td>
			</tr>
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-trangthaihoso"/>:</td>
				<td class="td-right td-right-trangthai"><%=state %></td>
			</tr>
			<tr valign="top">
				<td class="td-left" nowrap="nowrap"><liferay-ui:message key="pccc-TN-noidungxulycuoicung"/>:</td>
				<td class="td-right"><%= filePcccDTO.getLastTestProcessInfo().replace("/\\/", "<br />") %></td>
			</tr>
			<tr>
				<td class="td-left" valign="top">Barcode:</td>
				<td class="td-right"><font style="font-size: 15px" face="IDAutomationHC39M, Free 3 of 9,Free 3 of 9 Extended" ><%=file.getFileId()%></font></td>
			</tr>
			</table>
		</fieldset>
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-hosothietke"/></legend>
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
		<legend class="laborder"><liferay-ui:message key="pccc-TN-dinhkemtaptin"/></legend>
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
				<logic:iterate id="filePCCCAttachedFile" name="filePCCCAttachedFileList" type="com.sgs.portlet.onedoorpccc.model.PmlFilePCCCAttachedFile" indexId="p">
					<tr  valign="top">
						<td align="center"><%=p + 1 %></td>
						<td ><a href="#" onclick="getHostName(this,'<%= filePCCCAttachedFile.getPath()%>' )"><%=filePCCCAttachedFile.getAttachedFileName() %></a></td>
					</tr>
				</logic:iterate>
				<%
					}
				%>
			</table>
		</fieldset>
	</li>
	<li style="width: 49.6%">
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-thongtinquanly"/></legend>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td class="td-left"><liferay-ui:message key="pccc-TN-nguoinhaplieu"/>:</td>
				<%
				//User nguoiNhapLieu = UserUtil.findByPrimaryKey(Long.valueOf(filePcccDTO.getReceiver()));
				//String firstName = nguoiNhapLieu.getFirstName();
				//String lastName = nguoiNhapLieu.getLastName();
				//String middleName = nguoiNhapLieu.getMiddleName();
				User nguoiNhapLieu = null;
				String firstName = "";
				String lastName = "";
				String middleName = "";
				try {
					nguoiNhapLieu = UserUtil.findByPrimaryKey(Long.valueOf(filePcccDTO.getReceiver()));
					firstName = nguoiNhapLieu.getFirstName();
					lastName = nguoiNhapLieu.getLastName();
					middleName = nguoiNhapLieu.getMiddleName();
				}
				catch (Exception ex) {}
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
			
			
			<% 
			int timeProcessRemainOfFile = (Integer) renderRequest.getAttribute("timeProcessRemainOfFile");
			
			if (timeProcessRemainOfFile > 0) {%>
				<tr>
					<td class="td-left" nowrap="nowrap"><liferay-ui:message key="pccc-TN-nagyxulyconlaicuahoso"/>:</td>
					
					<td class="td-right"><%= String.valueOf(timeProcessRemainOfFile + " ") %> <liferay-ui:message key="pccc-TN-ngay-lam-viec"/></td>
				</tr>
			
			<%} else {%>
				<tr>
					<td class="td-left" nowrap="nowrap"><liferay-ui:message key="pccc-TN-hosotrehan"/>:</td>
					
					<td class="td-right"><%= String.valueOf(Math.abs(timeProcessRemainOfFile) + " ") %> <liferay-ui:message key="pccc-TN-ngay-lam-viec"/></td>
				</tr>
			
			<%} %>
			<tr valign="top">
				<td class="td-left"><liferay-ui:message key="pccc-TN-ghichu"/>:</td>
				<td class="td-right"><textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="3"><%=filePcccDTO.getNoteInformationManagement() %></textarea></td>
			</tr>
			</table>
		</fieldset>
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-thongtintrahoso"/></legend>
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
				//User nguoiNhanHS = UserUtil.findByPrimaryKey(Long.valueOf(file.getReceiver()));
				//String fn = nguoiNhanHS.getFirstName();
				//String ln = nguoiNhanHS.getLastName();
				//String mn = nguoiNhanHS.getMiddleName();
				User nguoiNhanHS = null;
				String fn = "";
				String ln = "";
				String mn = "";
				try {
					nguoiNhanHS = UserUtil.findByPrimaryKey(Long.valueOf(file.getReceiver()));
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
		<legend class="laborder"><liferay-ui:message key="pccc-TN-ketluanvehosothamduyet"/></legend>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr valign="top">
				<td class="td-left"><liferay-ui:message key="pccc-TN-ketluan"/>:</td>
				<td class="td-right"><textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="3"><%=filePcccDTO.getConclusion() %></textarea></td>
			</tr>
			</table>
		</fieldset>
	</li>
</ul>

<ul>
	<li style="width: 100%">
	<table cellspacing="0" width="100%" >	
		<tr>
		<td >
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-hosodinhkem"/></legend>
			<table cellspacing="0" width="100%" class="bor_rgh">
			<tr>
				<td>
				<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
						<td width="4%" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
						<td><liferay-ui:message key="pccc-TN-tenhosodinhkem"/></td>
						<td align="center"><liferay-ui:message key="pccc-TN-banchinh"/></td>
						<td align="center"><liferay-ui:message key="pccc-TN-banphu"/></td>
						<td><liferay-ui:message key="pccc-TN-ghichu"/></td>
					</tr>
					<logic:iterate id="fileAttachedFile" name="fileAttachedFileList" type="com.sgs.portlet.onedoor.model.PmlFileAttachedFile" indexId="i">
						<tr class="${((i % 2)==0)? 'results-row':'tr_two results-row'}">
							<td width="4%" align="center"><%=i+1 %>.&nbsp;</td>
							<td width="51%"><div ><%=fileAttachedFile.getAttachedFileName() %></div></td>
							<td align="center" style="width:12%"><%=fileAttachedFile.getOriginal() %></td>
							<td align="center" style="width:12%"><%=fileAttachedFile.getCopy_() %></td>
							<td style="width:20%"><%=fileAttachedFile.getNote() %></td>
						</tr>
					</logic:iterate>
					</table>
				</td>
			</tr>
			<tr>
				<td>
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
						<td width="4%" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
						<td><liferay-ui:message key="pccc-TN-tentailieubanve"/></td>
						<td align="center"><liferay-ui:message key="pccc-TN-soluong"/></td>
						<td align="left"><liferay-ui:message key="pccc-TN-ghichu"/></td>
					</tr>
					<logic:iterate id="paintDocument" name="paintDocumentList" type="com.sgs.portlet.onedoorpccc.model.PmlPaintDocument" indexId="j">
						<tr class="${((j % 2)==0)? 'results-row':'tr_two results-row'}">
							<td width="4%" align="center"><%=j+1 %>.&nbsp;</td>
							<td style="width:66%"><div><%=paintDocument.getPaintDocumentName() %></div></td>
							<td style="width:12%" align="center"><%=paintDocument.getQuantity() %></td>
							<td><%=paintDocument.getNote() %></td>
						</tr>
					</logic:iterate>
					</table>
				</td>
			</tr>
			</table>
		</fieldset>
	</td>
</tr>
<tr>
	<td>
		<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="pccc-TN-quytrinhxuly"/></legend>
			<table cellspacing="0" width="100%">
			<tr>
				<td>
					<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
					<tr class="portlet-section-header results-header" >
						<td width="4%" align="center"><liferay-ui:message key="pccc-TN-stt"/></td>
						<td><liferay-ui:message key="pccc-XL-nguoigui"/></td>
						<td width="12%" align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
						<td><liferay-ui:message key="pccc-XL-nguoiNhan"/></td>
						<td width="12%" align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></td>
						<td><liferay-ui:message key="pccc-TN-noidungxuly"/></td>						
					</tr>
					<logic:iterate id="processDispose" name="processDisposeList" type="com.sgs.portlet.document.model.PmlProcessDispose" indexId="k">
						<tr class="${((k % 2)==0)? 'results-row':'tr_two results-row'}">
							<td width="35px" align="center"><%=k+1 %>.</td>
							<%
							//User processer = UserUtil.findByPrimaryKey(processDispose.getProcesser());
							//String fin = processer.getFirstName();
							//String lan = processer.getLastName();
							//String min = processer.getMiddleName();
							User processer = null;
							String fin = "";
							String lan = "";
							String min = "";
							try {
								processer = UserUtil.findByPrimaryKey(processDispose.getProcesser());
								fin = processer.getFirstName();
								lan = processer.getLastName();
								min = processer.getMiddleName();
							}
							catch (Exception ex) {}
							String processerName = lan + " " + min + " " + fin;
							
							User receive = null;
							String nameReceive = "";
							if (processDispose.getReceiver() != 0) {
								try {
								receive = UserUtil.findByPrimaryKey(processDispose.getReceiver());
								nameReceive = receive.getLastName() + " " + receive.getMiddleName() + " " + receive.getFirstName();
							}
								catch (Exception ex) {}
							}
							
							%>
							<td ><div ><%=processDispose.getProcesser() != 0 ? processerName : ""%></div></td>
							<td align="center"><%=processDispose.getDateProcess() != null ? new SimpleDateFormat("dd/MM/yyyy").format(processDispose.getDateProcess()) : "" %></td>
							<td nowrap="nowrap"><div align="left"><%=processDispose.getReceiver() != 0 ? nameReceive : ""%></div></td>
							<td align="center"><%=processDispose.getReceiveDate() != null ? new SimpleDateFormat("dd/MM/yyyy").format(processDispose.getReceiveDate()) : "" %></td>
							<td><div> <%=processDispose.getProcessInfomation().replace("/\\/", "<br />") %></div></td>
						</tr>
					</logic:iterate>
					</table>
				</td>
			</tr>
		</table>
		</fieldset>
		</td>
	</tr>
	</table>
	</li>
</ul>
</fieldset>

<div id="table-button" align="right">
		<liferay-util:include page="/html/portlet/ext/onedoorpcccprocess/common/workflowAction.jsp"></liferay-util:include>
		<!-- a onclick="location.reload()"><input class="button-width" type="button" value='<liferay-ui:message key="back"/>'--><!-- /a-->
</div>
