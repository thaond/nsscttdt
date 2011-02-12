<%@ include file="/html/portlet/ext/pmledm_filestatus/init.jsp" %>
<%@page import="com.sgs.portlet.document.model.PmlFileStatus"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlFileStatusUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.sgs.portlet.document.service.PmlFileStatusLocalServiceUtil"%>
<%@page import="com.sgs.portlet.document.PmlFileStatusCodeSameCodeException"%>
<%@ include file="/html/portlet/ext/pmledm_filestatus/js/filestatus_js.jsp" %>

<%
	String tabsEdit = ParamUtil.getString(request,"tabs");
	//PmlFileStatus fileStatus = (PmlFileStatus) renderRequest.getAttribute("pmlFileStatus");
	String redirectfileStatusEdit = ParamUtil.getString(request, "redirect");
	
	long fileStatusId = ParamUtil.getLong(request, "fileStatusId");
	PmlFileStatus fileStatus = null;
	try {
		fileStatus = PmlFileStatusLocalServiceUtil.getPmlFileStatus(fileStatusId);
	} catch (Exception e) { }
%>

<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/pmledm_filestatus/edit_filestatus_document"/>	
	<portlet:param name="tabs" value="<%= tabsEdit %>"/>
</portlet:actionURL>

<form method="post" action="<%= update %>" name="<portlet:namespace/>fm" onsubmit="return validateFileStatusForm()" enctype="multipart/form-data">
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
	 <div class="boxcontent">
<liferay-ui:error exception="<%= PmlFileStatusCodeSameCodeException.class %>" message="ma-trang-thai-khong-duoc-trung" />

	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirectfileStatusEdit) %>" />
	<table cellspacing="0" width="100%" >
		<tr>
			<td width="20%"><label><liferay-ui:message key="pml_edm_file_state_type" />&nbsp;:</label></td>
			<td>
				<liferay-ui:message key="cong-van" />
				<input type="hidden" name="pml_edm_file_state_type" value="1" id="type" style="width: 50%"/>
			</td>
		</tr>
		<tr>
			<td><label><liferay-ui:message key="pml_edm_file_status_code"/>&nbsp;:<font color="#FF0000" size="1">(*)</font></label></td>
			<td >
				<input style="width: 50%" type="text" name="pml_edm_file_status_code" id="pml_edm_file_status_code" value="<%=fileStatus.getFileStatusCode() %>"/>
			</td>
		</tr>
		<tr>
			<td><label><liferay-ui:message key="pml_edm_file_status_name"/>&nbsp;:<font color="#FF0000" size="1">(*)</font></label></td>
			<td><input style="width: 50%" type="text" name="pml_edm_file_status_name" id="pml_edm_file_status_name" value="<%=fileStatus.getFileStatusName() %>"/></td>
		</tr>
		<tr valign="top">
			<td ><label><liferay-ui:message key="pml_edm_file_status_description"/>&nbsp;: </label></td>
			<td>
			<textarea style="width: 95%" name="pml_edm_file_status_description" id="pml_edm_file_status_description" rows="5"><%=fileStatus.getDescription() %></textarea>
		</tr>
		<tr>
			<td><label><liferay-ui:message key="pml_edm_file_status_active"/>&nbsp;: </label></td>
			<td><input type="checkbox" name="pml_edm_file_status_active" value="1" <%=fileStatus.getActive().equals("1") ? "checked" : "" %> /></td>
		</tr>
			<tr>
			<td></td>
				<td>
				<input type="hidden" name="fileStatusId" value="<%=String.valueOf(fileStatus.getFileStatusId()) %>"/>
				<input style="margin-left: 0" type="submit" value='<liferay-ui:message key="update"/>'/>
				<input  type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
				<span onclick="javascript:submitForm(document.hrefFm,'<%= redirectfileStatusEdit %>');"><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 </td>
			</tr>
	</table>
	</div>	
</form>