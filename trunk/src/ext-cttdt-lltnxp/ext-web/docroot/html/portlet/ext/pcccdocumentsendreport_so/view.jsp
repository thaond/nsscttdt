<%@ include file="/html/portlet/ext/pcccdocumentsendreport_so/init.jsp" %>
<%@page import="com.sgs.portlet.department.model.Department"%>
<%@page import="com.sgs.portlet.department.service.persistence.DepartmentUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordTypeUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmPrivilegeLevelUtil"%>

<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmConfidentialLevelUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlEdmDocumentType"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil"%>

<script type="text/javascript">
function checkFormSearch(form) {
	if(isNaN(form.<portlet:namespace />stt.value) == true) {
		form.<portlet:namespace />stt.focus();
		return false;
	}
	return true;
}
</script>

<%
String stt = request.getAttribute("attSTT").toString();
String soCVNoiBo = request.getAttribute("attSoCVNoiBo").toString();
String soCVDi = request.getAttribute("attSoCVDi").toString();
String noiNhan = request.getAttribute("attNoiNhan").toString();
String nguoiKy = request.getAttribute("attNguoiKy").toString();
String trichYeu = request.getAttribute("attTrichYeu").toString();
String loaiCV = request.getAttribute("attLoaiCV").toString();
String doUuTien = request.getAttribute("attDoUuTien").toString();
%>

<portlet:actionURL var="filter">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendreport_so/view" />
</portlet:actionURL>
<portlet:actionURL var="inBaoCaoXuatExcel">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentsendreport_so/view" />
	<portlet:param name="cmd" value="report" />
</portlet:actionURL>
<script type="text/javascript">
function <portlet:namespace />addActionFrom(reportType) {
	var action = "<%= inBaoCaoXuatExcel %>&<portlet:namespace />reportType=" + reportType;
	document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", action);
}
function <portlet:namespace />setActionFrom() {
	document.getElementsByName("<portlet:namespace />frmReport")[0].setAttribute("action", "");
}
</script>
<jsp:useBean id="documentSendList" type="java.util.List" scope="request" />
<form name="<portlet:namespace />frmReport" action="<%= filter %>" method="post" onsubmit="return checkFormSearch(this);">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
	<td colspan="7">
		<table cellpadding="0" cellspacing="0" border="0" width="100%" class="pos-border">
		<tr class="table-header" bgcolor="#dbeafc" align="center" style="height: 30px;">
			<td><liferay-ui:message key="pcccdocumentsendreport-stt" /></td>
			<td><liferay-ui:message key="pcccdocumentsendreport-socvnoibo" /></td>
			<td><liferay-ui:message key="pcccdocumentsendreport-socvdi" /></td>
			<td><liferay-ui:message key="pcccdocumentsendreport-noinhan" /></td>
			<td><liferay-ui:message key="pcccdocumentsendreport-nguoiky" /></td>
			<td><liferay-ui:message key="pcccdocumentsendreport-trichyeu" /></td>
			<td><liferay-ui:message key="pcccdocumentsendreport-loaicv" /></td>
			<td><liferay-ui:message key="pcccdocumentsendreport-douutien" /></td>
			<td><liferay-ui:message key="pcccdocumentsendreport-trinhtuxuly" /></td>
		</tr>
		<tr>
			<td width="4%"></td>
			<td width="10%"><input type="text" name="<portlet:namespace />soCVNoiBo" value="<%= soCVNoiBo %>" style="width: 95%;" /></td>
			<td width="10%"><input type="text" name="<portlet:namespace />soCVDi" value="<%= soCVDi %>" style="width: 95%;" /></td>
			<td width="10%"><input type="text" name="<portlet:namespace />noiNhan" value="<%= noiNhan %>" style="width: 95%;" /></td>
			<td width="10%"><input type="text" name="<portlet:namespace />nguoiKy" value="<%= nguoiKy %>" style="width: 95%;" /></td>
			<td width="20%"><input type="text" name="<portlet:namespace />trichYeu" value="<%= trichYeu %>" style="width: 95%;" /></td>
			<td width="9%">
				<select name="<portlet:namespace />loaiCV" style="width: 100%;">
					<option value="tatca">[...]</option>
					<%
					List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findAll();
					for(PmlEdmDocumentType pmlEdmDocumentType : pmlEdmDocumentTypeList) {
						String documentTypeId = pmlEdmDocumentType.getDocumentTypeId() + "";
					%>
						<option value="<%= documentTypeId %>" <%= documentTypeId.equals(loaiCV) ? "selected" : "" %>><%= pmlEdmDocumentType.getDocumentTypeName() %></option>
					<%
					}
					%>
				</select>
			</td>
			<td width="9%">
				<select name="<portlet:namespace />doUuTien" style="width: 100%;">
					<option value="tatca">[...]</option>
					<%
					List<PmlEdmPrivilegeLevel> pmlEdmPrivilegeLevelList = PmlEdmPrivilegeLevelUtil.findAll();
					for(PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel : pmlEdmPrivilegeLevelList) {
						String privilegeLevelId = pmlEdmPrivilegeLevel.getPrivilegeLevelId();
					%>
						<option value="<%= privilegeLevelId %>" <%= privilegeLevelId.equals(doUuTien) ? "selected" : "" %>><%= pmlEdmPrivilegeLevel.getPrivilegeLevelName() %></option>
					<%
					}
					%>
				</select>
			</td>
			<td align="center"><input type="submit" value="     >>     " /></td>
		</tr>
		<logic:iterate id="documentSendDTO" name="documentSendList"
		type="com.sgs.portlet.pcccdocumentsendreport.dto.DocumentSendDTO" indexId="i">
		<tr>
			<td align="center"><%= documentSendDTO.getStt() %></td>
			<td><%= documentSendDTO.getSoCVNoiBo() %></td>
			<td><%= documentSendDTO.getSoCVDi() %></td>
			<td><%= documentSendDTO.getNoiNhan() %></td>
			<td><%= documentSendDTO.getNguoiKy() %></td>
			<td><%= documentSendDTO.getTrichYeu() %></td>
			<td align="center"><%= documentSendDTO.getLoaiCV() %></td>
			<td align="center"><%= documentSendDTO.getDoUuTien() %></td>
			<td><%= documentSendDTO.getTrinhTuXuLy() %></td>
		</tr>
		</logic:iterate>
		</table>	
	</td>
</tr>
</table>
<table id="table-button">
	<tr><td>
	<input type="button" value='<liferay-ui:message key="pcccdocumentsendreport-inbaocao" />' onclick="<portlet:namespace />addActionFrom('word');<portlet:namespace />frmReport.submit();<portlet:namespace />setActionFrom();" />
	<input type="button" value='<liferay-ui:message key="pcccdocumentsendreport-xuatexcell" />' onclick="<portlet:namespace />addActionFrom('excel');<portlet:namespace />frmReport.submit();<portlet:namespace />setActionFrom();" disabled />
</td></tr></table>
</form>
