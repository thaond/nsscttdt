<%@ include file="/html/portlet/ext/pmledm_filestatus/init.jsp" %>
<%@ include file="/html/portlet/ext/pmledm_filestatus/js/pmledm_filestatus-js.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.document.model.PmlStateProcess"%>
<%@page import="com.sgs.portlet.document.service.persistence.PmlStateProcessUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.SystemException"%>
<%@page import="com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess"%>
<%@page import="com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	long stateProcessId = ParamUtil.getLong(renderRequest,"stateProcessId");
	long fileStatusId = ParamUtil.getLong(renderRequest,"fileStatusId");
	long statusId = ParamUtil.getLong(renderRequest,"statusId");
	
	String tabsEditDocument = ParamUtil.getString(request, "tabs");
	String redirectfileStatus = ParamUtil.getString(request, "redirect");
	
	PmlStateProcess pmlStateProcess1 = PmlStateProcessUtil.findByPrimaryKey(stateProcessId);
	PmlFileStatusStateProcess fileStatusStateProcess = null;
	String stateProcess = "";
	try {
		fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.getPmlFileStatusStateProcess(statusId);
	} catch (Exception e) {}
	
	if ( null!= fileStatusStateProcess) {
		stateProcess = fileStatusStateProcess.getDescription();
	}
%>


<portlet:actionURL var="update_process">
	<portlet:param name="struts_action" value="/sgs/pmledm_filestatus/display_stateprocess_document"/>
</portlet:actionURL>

<form action="<%=update_process %>" method="post" name="<portlet:namespace />fm" class="table-border-pml" onsubmit="return validateFileStatusStateProcess()">
<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
	 <div class="boxcontent">	
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirectfileStatus) %>" />
	<input name="<portlet:namespace />tabs" type="hidden" value="<%= tabsEditDocument %>" />
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<input name="<portlet:namespace />stateProcessId" type="hidden" id="stateProcessId"  value="<%=String.valueOf(stateProcessId) %>" />
	<input name="<portlet:namespace />fileStatusId" type="hidden" id="fileStatusId" value="<%=String.valueOf(fileStatusId) %>" />
	<input name="<portlet:namespace />statusId" type="hidden" value="<%=String.valueOf(statusId) %>" />
	<input type="hidden" value=""  id="checkFileStatusStateProcess"/>
	<table cellspacing="0" width="100%" >
		<tr>
				<td width="20%"><label><liferay-ui:message key="pml_edm_file_state_process_code"/>&nbsp;:</label></td>
				<td>					
					<select  name="<portlet:namespace />stateprocessidchoice" id="stateProcessIdChoice" style="width: 96%">
						<%
							List<PmlStateProcess> stateProcessList = new ArrayList<PmlStateProcess>();
							
							try {
								stateProcessList = PmlStateProcessUtil.findByStateProcessName("CV");
							} catch (SystemException e) {
								stateProcessList = new ArrayList<PmlStateProcess>();
							}
							
							for (PmlStateProcess pmlStateProcess : stateProcessList) {
						%>
								<option <%= (stateProcessId == pmlStateProcess.getStateProcessId()? "selected=selected" : "") %> value="<%= pmlStateProcess.getStateProcessId()%>" ><%= pmlStateProcess.getStateProcessCode() %> </option>
						<%
							}
						%>
						
					</select>
				
				</td>
		</tr>
		<tr valign="top">
			<td><label><liferay-ui:message key="description"/>&nbsp;:</label></td>
			<td><textarea name="<portlet:namespace/>description" id="description" rows="5" style="width: 95%" ><%= stateProcess %></textarea></td>
		</tr>

		<tr>
		<td></td>
			<td>
			<input style="margin-left: 0;" type="submit" value='<liferay-ui:message key="update"/>'/>
    		<input type="reset" name="reset" id="reset" value="<liferay-ui:message key="reset" />" />
			<input onclick="window.history.back()" type="button" value='<liferay-ui:message key="back"/>' />
		 </td>
		</tr>
	</table>
	</div>
</form>