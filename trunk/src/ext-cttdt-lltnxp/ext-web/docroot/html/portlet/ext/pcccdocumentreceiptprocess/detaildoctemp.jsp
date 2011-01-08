<%@ include file="/html/portlet/ext/pcccdocumentreceiptprocess/js/changeselectboxvalue.jsp" %>


<%@page import="javax.portlet.RenderRequest"%>
<%@page import="com.sgs.portlet.document.send.model.PmlEdmDocumentSend"%>
<%@page import="com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portlet.PortletURLImpl"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlDocumentReceiptLog"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlEdmDocumentReceiptLocalServiceUtil"%>
<%@page import="com.liferay.portal.NoSuchUserException"%>
<link type="text/css" rel="stylesheet" href="/html/portlet/ext/pcccdocumentreceiptprocess/css/letter.css" />
<%@page import="com.sgs.portlet.document.workflow.DocumentReceiptPortletAction"%>
<%@page import="com.sgs.portlet.document.receipt.dto.PmlEdmDocumentReceiptDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.ext.portlet.processtype.model.ProcessType"%>
<%@page import="com.ext.portlet.processtype.service.persistence.ProcessTypeUtil"%>
<%@page import="com.liferay.portal.service.persistence.UserUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<liferay-util:include page="/html/portlet/ext/onedoorpccc/js/pccc-onedoorreceipt.jsp"></liferay-util:include>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />
<%
	PmlEdmDocumentReceiptDTO documentDTO = (PmlEdmDocumentReceiptDTO)renderRequest.getAttribute("documentDTO");
	boolean timkiemtheotieuchi = ParamUtil.getBoolean(renderRequest, "timkiemtheotieuchi", false);
	String soVanBanDen = ParamUtil.getString(renderRequest, "sovanbanden", "");
	String soHieuGoc = ParamUtil.getString(renderRequest, "sohieugoc", "");
	int loaiSoVB = ParamUtil.getInteger(renderRequest, "loaisocongvan", 0);
	String issuingplaceId = ParamUtil.getString(renderRequest, "issuingplaceId", "");
	String noiphathanh = ParamUtil.getString(renderRequest, "noiphathanh", "");
	String trichyeu = ParamUtil.getString(renderRequest, "trichyeu", "");
	
	String tuNgay = ParamUtil.getString(renderRequest, "tungay", "");
	String denNgay = ParamUtil.getString(renderRequest, "denngay", "");
/*
	String documentRecordTypeId = (String) renderRequest.getAttribute("documentRecordTypeId");
	
	String daysProcessDeparmentMain = (String) renderRequest.getAttribute("daysProcessDeparmentMain");
	String expireDateProcess = (String) renderRequest.getAttribute("expireDateProcess");
	String mainProcessName = (String) renderRequest.getAttribute("mainProcessName");
	String mainDepartmentName = (String) renderRequest.getAttribute("mainDepartmentName");
	String processInformation = (String) renderRequest.getAttribute("processInformation");
	String soCongVanDenHientai = (String) renderRequest.getAttribute("soCongVanDenHientai");
	*/
	String hienTrang = ParamUtil.getString(renderRequest, "hienTrang", "vbquamang");//yenlt update 13/04/2010
	String tabChung = ParamUtil.getString(renderRequest, "tabChung", "");
	String redirect = ParamUtil.getString(renderRequest, "redirect")+ "&tabChung="+tabChung ;
%>

<form method="post">
<div class="title_categ"><liferay-ui:message key="pccc-TN-thongtinchitiet"/></div>
    <div class="boxcontent">
	<table width="100%" cellspacing="0" class="detail_xl">
		<tr>	  
		    <td class="td-left" width="18%"><label><liferay-ui:message key="pccc-cvdtn-capgoi"/>: </label></td>
		    <td class="td-right" width="32%"><%=documentDTO.getLevelSendName() != null ? documentDTO.getLevelSendName() : "" %></td>
		    <td class="td-left" width="18%"><label><liferay-ui:message key="pccc-cvdtn-noiphathanh"/>: </label></td>
		    <td class="td-right"><%=documentDTO.getIssuingPlaceName() != null ? documentDTO.getIssuingPlaceName() : "" %></td>
		</tr>
		<tr>
		    <td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-sohieu"/>: </label></td>
			<td class="td-right"><%=documentDTO.getDocumentReference() != null ? documentDTO.getDocumentReference() : "" %></td>
		    <td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-loaicongvan"/>:</label></td>
		    <td class="td-right" ><%=documentDTO.getDocumentTypeName() != null ? documentDTO.getDocumentTypeName() : "" %></td>
		</tr>
		<tr>
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-socongvan"/>: </label></td>
			<td class="td-right"></td>
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-soCVden"/>: </label></td>
			<td class="td-right"><%=documentDTO.getNumberDocumentReceipt() != null ? documentDTO.getNumberDocumentReceipt() : "" %></td>
		</tr>
		<tr>
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-nguoiky"/>:</label></td>
			<td class="td-right"><%=documentDTO.getSigner() != null ? documentDTO.getSigner() : "" %></td>
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-ngayden"/>:</label></td>
			<td class="td-right"><%=documentDTO.getDateArrive() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(documentDTO.getDateArrive()) : "" %>
			<liferay-ui:message key='hour' />:<%=documentDTO.getThoigiannhancvden() != null ? documentDTO.getThoigiannhancvden() : "" %>
			</td>
		</tr>
		<tr>
			<td class="td-left" ><label><liferay-ui:message key="pccc-cvdtn-ngayphathanh"/>:</label></td>
			<td class="td-right"><%=documentDTO.getIsuuingDate() != null ? new java.text.SimpleDateFormat("dd/MM/yyyy").format(documentDTO.getIsuuingDate()) : "" %></td>
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-domat"/>:</label></td>
			<td class="td-right"><%=documentDTO.getConfidentialLevelName() != null ? documentDTO.getConfidentialLevelName() : "" %></td>
		</tr>
		<tr>
			<td class="td-left"><label><liferay-ui:message key="pccc-cvdtn-dokhan"/>:</label></td>
			<td class="td-right"><%= documentDTO.getPrivilegeLevel() != null ? documentDTO.getPrivilegeLevel() : ""%></td>
			<td class="td-left" valign="top"><label><liferay-ui:message key="cach-thuc-xu-ly"/>:</label></td>
				<td class="td-right">
				</td>
		</tr>
		
		<tr valign="top">
			<td valign="top" class="td-left"><label><liferay-ui:message key="pccc-cvdtn-trichyeu"/>:</label></td>
			<td colspan="3" class="td-right"><textarea class="textarea-display" onMouseover="this.style.backgroundColor='white';" readonly="" rows="5" style="width: 95%"><%=documentDTO.getBriefContent() != null ? documentDTO.getBriefContent() : ""%></textarea></td>
		</tr>
</table>


<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="pccc-XL-quatrinhluanchuyencongvanden"/></label>
			<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
				<tr class="portlet-section-header results-header" >
				<td align="center" width="35px"><liferay-ui:message key="pccc-TN-stt"/></td>
				<td width="20%"><liferay-ui:message key="pccc-XL-donvicanhangui"/></td>
				<td align="center"><liferay-ui:message key="pccc-XL-ngaygui"/></td>
				<td width="35%"><liferay-ui:message key="pccc-XL-yeucauxuly"/></td>
				<td width="20%"><liferay-ui:message key="pccc-XL-donvicanhannhan"/></td>
				<td align="center"><liferay-ui:message key="pccc-DSHS-ngaynhan"/></td>						
			</tr>	
			
			</table>
</fieldset>
<div align="right" id="table-button">
	<%
		if ("vbquamang".equals(hienTrang)) {
	%>
	<liferay-util:include page="/html/portlet/ext/pcccdocumentreceiptprocess/common/workflowAction.jsp"></liferay-util:include>
	<%
		}
		PortletURL redirectURL = renderResponse.createRenderURL();
		redirectURL.setWindowState(WindowState.NORMAL);
		redirectURL.setParameter("struts_action", "/sgs/pcccdocumentreceiptprocess/view");
		redirectURL.setParameter("hienTrang", hienTrang);
		redirectURL.setParameter("tabChung", tabChung);
		redirectURL.setParameter("timkiemtheotieuchi", String.valueOf(timkiemtheotieuchi));
		redirectURL.setParameter("sovanbanden", soVanBanDen);
		redirectURL.setParameter("sohieugoc", soHieuGoc);
		redirectURL.setParameter("loaisocongvan", String.valueOf(loaiSoVB));
		redirectURL.setParameter("issuingplaceId", issuingplaceId);
		redirectURL.setParameter("noiphathanh", noiphathanh);
		redirectURL.setParameter("trichyeu", trichyeu);
		redirectURL.setParameter("tungay", tuNgay);
		redirectURL.setParameter("denngay", denNgay);
	%>
	<portlet:actionURL var="backDoctemp">
		<portlet:param name="struts_action" value="/sgs/pcccdocumentreceiptprocess/delete" />
		<portlet:param name="documentReceiptIdTemp"	value='<%=(String) renderRequest.getParameter("documentReceiptIdTemp") %>' />
		<portlet:param name="documentReceiptId"	value='<%=(String) renderRequest.getParameter("documentReceiptId") %>' />	
		<portlet:param name="redirect" value="<%= String.valueOf(redirectURL) %>" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION%>" value="true" />
		<portlet:param name="<%=com.sgs.liferay.jbpm.util.Constants.WORKFLOW_ACTION_NAME%>" value='<%=DocumentReceiptPortletAction.COMMAND_PREFIX + ".xoacongvan"%>' />
	</portlet:actionURL>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= backDoctemp %>');" >
			<input class="button-width" type="button" value='<liferay-ui:message key="back" />'>
		</span>
</div>
</div>
</form>