<%@ include file="/html/portlet/nss/filestatus/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.nss.portlet.onedoor.PmlFileStatusCodeSameCodeException"%>
<%@ include file="/html/portlet/nss/filestatus/js/filestatus_js.jsp" %>
<%
	String tabsAddOnedoor = request.getParameter("tabs");
	String redirectAddOnedoor = request.getParameter("redirect");
	String filestatusFlag = request.getAttribute("filestatusFlag") == null ? "" : String.valueOf(request.getAttribute("filestatusFlag"));
	String filestatusCode = "";
	String filestatusName = "";
	String description = "";
	Boolean active = true;
	
	if (filestatusFlag.equals("fail")) { // Them that bai
		filestatusCode = ParamUtil.getString(request, "pml_edm_file_status_code");
		filestatusName = ParamUtil.getString(request, "pml_edm_file_status_name");
		description = ParamUtil.getString(request, "pml_edm_file_status_description");
		active = ParamUtil.getBoolean(request, "pml_edm_file_status_active");
	}
%>

<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/nss/filestatus/add_filestatus_onedoor"/>
	<portlet:param name="tabs" value="<%= tabsAddOnedoor %>"/>
</portlet:actionURL>

<form action="<%=add %>" method="post" name="<portlet:namespace/>fm" onsubmit="return validateFileStatusForm()" class="table-border-pml" enctype="multipart/form-data">
<div class="title_categ"><liferay-ui:message key="add_new"/></div>
	 <div class="boxcontent">	
	<liferay-ui:error exception="<%= PmlFileStatusCodeSameCodeException.class %>" message="ma-trang-thai-khong-duoc-trung" />
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirectAddOnedoor) %>" />
	
	<table cellspacing="0" width="100%">
		<tr>
			<td width="20%"><label><liferay-ui:message key="pml_edm_file_state_type" />&nbsp;:</label></td>
			<% int type = 0; %>
			<td style="font-weight: bold;">
				<liferay-ui:message key="mot-cua" />
				<input type="hidden" name="pml_edm_file_state_type" value='<%= type %>' id="type" style="width: 50%"/>
			</td>
		</tr>
		
		
		<tr>
			<td><label><liferay-ui:message key="pml_edm_file_status_code"/>&nbsp;:<font color="#FF0000" size="1">(*)</font></label></td>
			<td >
				<input style="width: 50%" type="text" name="<portlet:namespace/>pml_edm_file_status_code" 
						value="<%= filestatusCode %>" id="pml_edm_file_status_code"/>
			</td>
		</tr>
		
		
		<tr>
			<td><label><liferay-ui:message key="pml_edm_file_status_name"/>&nbsp;:<font color="#FF0000" size="1">(*)</font></label></td>
			<td ><input style="width: 50%" type="text" name="<portlet:namespace/>pml_edm_file_status_name" 
						value="<%= filestatusName %>" id="pml_edm_file_status_name"/></td>
		</tr>
		
		
		<tr valign="top">
			<td><label><liferay-ui:message key="pml_edm_file_status_description"/>&nbsp;:</label></td>
			<td >
				<textarea style="width: 95%" name="pml_edm_file_status_description" id="pml_edm_file_status_description" rows="5"><%= description %></textarea>
			</td>
		</tr>
		
		
		<tr>
			<td><label><liferay-ui:message key="pml_edm_file_status_active"/>:</label></td>
			<td><input type="checkbox" name="pml_edm_file_status_active" id="active" checked="checked" value="<%= active %>"/></td>
		</tr>
		<tr>
			<td></td>
				<td>
					<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="save"/>'/>
	    			<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
					<span onclick="javascript:submitForm(document.hrefFm,'<%= redirectAddOnedoor %>');">
						<input type="button" value='<liferay-ui:message key="back"/>' />
					</span>
			 	</td>
			</tr>
	</table>
</div>
</form>