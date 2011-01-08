<%@ include file="/html/portlet/ext/pcccdocumentrecordto_so/init.jsp" %>
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
	if(form.<portlet:namespace />ngayDen.value != "") {
		if(isDate(form.<portlet:namespace />ngayDen.value) == false) {
			form.<portlet:namespace />ngayDen.focus();
			return false;
		}
	}
	if(form.<portlet:namespace />ngayHetHan.value != "") {
		if(isDate(form.<portlet:namespace />ngayHetHan.value) == false) {
			form.<portlet:namespace />ngayHetHan.focus();
			return false;
		}
	}
	return true;
}
</script>

<%
String stt = request.getAttribute("attSTT").toString();
String soCVNoiBo = request.getAttribute("attSoCVNoiBo").toString();
String soCVDen = request.getAttribute("attSoCVDen").toString();
String ngayDen = request.getAttribute("attNgayDen").toString();
String ngayHetHan = request.getAttribute("attNgayHetHan").toString();
String noiBanHanh = request.getAttribute("attNoiBanHanh").toString();
String trichYeu = request.getAttribute("attTrichYeu").toString();
String loaiCV = request.getAttribute("attLoaiCV").toString();
String doUuTien = request.getAttribute("attDoUuTien").toString();
%>

<portlet:actionURL var="filter">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentrecordto_so/view" />
</portlet:actionURL>
<portlet:actionURL var="inBaoCaoXuatExcel">
	<portlet:param name="struts_action" value="/sgs/pcccdocumentrecordto_so/view" />
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

<jsp:useBean id="documentRecordToList" type="java.util.List" scope="request" />
<form name="<portlet:namespace />frmReport" action="<%= filter %>" method="post" onsubmit="return checkFormSearch(this);">
<table cellpadding="0" cellspacing="0" border="0">
<tr>
	<td colspan="6">
		<table cellpadding="0" cellspacing="0" border="0" width="100%" class="pos-border">
		<tr class="table-header" bgcolor="#dbeafc" align="center" style="height: 30px;">
			<td><liferay-ui:message key="pcccdocumentrecordto-stt" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-socvnoibo" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-socvden" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-ngayden" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-ngayhethan" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-noibanhanh" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-trichyeu" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-loaicv" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-douutien" /></td>
			<td><liferay-ui:message key="pcccdocumentrecordto-trinhtuxuly" /></td>
		</tr>
		<tr>
			<td width="4%"></td>
			<td width="10%"><input type="text" name="<portlet:namespace />soCVNoiBo" value="<%= soCVNoiBo %>" style="width: 95%;" /></td>
			<td width="10%"><input type="text" name="<portlet:namespace />soCVDen" value="<%= soCVDen %>" style="width: 95%;" /></td>
			<td width="7%"><input type="text" name="<portlet:namespace />ngayDen" value="<%= ngayDen %>" style="width: 95%;" /></td>
			<td width="7%"><input type="text" name="<portlet:namespace />ngayHetHan" value="<%= ngayHetHan %>" style="width: 95%;" /></td>
			<td width="10%"><input type="text" name="<portlet:namespace />noiBanHanh" value="<%= noiBanHanh %>" style="width: 95%;" /></td>
			<td width="10%"><input type="text" name="<portlet:namespace />trichYeu" value="<%= trichYeu %>" style="width: 95%;" /></td>
			<td width="12%">
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
			<td width="12%">
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
		<logic:iterate id="documentRecordToDTO" name="documentRecordToList"
		type="com.sgs.portlet.pcccdocumentrecordto.dto.DocumentRecordToDTO" indexId="i">
		<tr>
			<td align="center"><%= documentRecordToDTO.getStt() %></td>
			<td><%= documentRecordToDTO.getSoCVNoiBo() %></td>
			<td><%= documentRecordToDTO.getSoCVDen() %></td>
			<td align="center"><%= documentRecordToDTO.getNgayDen() %></td>
			<td align="center"><%= documentRecordToDTO.getNgayHetHan() %></td>
			<td><%= documentRecordToDTO.getNoiBanHanh() %></td>
			<td><%= documentRecordToDTO.getTrichYeu() %></td>
			<td align="center"><%= documentRecordToDTO.getLoaiCV() %></td>
			<td align="center"><%= documentRecordToDTO.getDoUuTien() %></td>
			<td><%= documentRecordToDTO.getTrinhTuXuLy() %></td>
		</tr>
		</logic:iterate>
		</table>	
	</td>
</tr>
</table>
<table id="table-button">
<tr><td>
	<input type="button" value='<liferay-ui:message key="pcccdocumentrecordto-inbaocao" />' onclick="<portlet:namespace />addActionFrom('word');<portlet:namespace />frmReport.submit();<portlet:namespace />setActionFrom();" />
	<input type="button" value='<liferay-ui:message key="pcccdocumentrecordto-xuatexcell" />' onclick="<portlet:namespace />addActionFrom('excel');<portlet:namespace />frmReport.submit();<portlet:namespace />setActionFrom();" disabled />
</td></tr>
</table>
</form>
