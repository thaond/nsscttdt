<%@ include file="/html/portlet/nss/filestatus/init.jsp" %>
<%@ include file="/html/portlet/nss/filestatus/js/pmledm_filestatus-js.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.nss.portlet.onedoor.model.PmlStateProcess"%>
<%@page import="com.nss.portlet.onedoor.service.persistence.PmlStateProcessUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.SystemException"%>
<%@page import="com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.nss.portlet.onedoor.model.PmlFileStatusStateProcess"%>
<%@page import="com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%
	long stateProcessId = ParamUtil.getLong(renderRequest,"stateProcessId");
	long fileStatusId = ParamUtil.getLong(renderRequest,"fileStatusId");
	long statusId = ParamUtil.getLong(renderRequest,"statusId");
	
	String tabsEditOnedoor = request.getParameter("tabs");
	String redirectOnedoor = request.getParameter("redirect");
	
	PmlStateProcess pmlStateProcess = PmlStateProcessUtil.findByPrimaryKey(stateProcessId);
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
	<portlet:param name="struts_action" value="/nss/filestatus/display_stateprocess_onedoor"/>
</portlet:actionURL>

<form action="<%=update_process %>" method="post" name="<portlet:namespace />fm" class="table-border-pml" onsubmit="return validateFileStatusStateProcess()">
	<div class="title_categ"><liferay-ui:message key="cap-nhat-thong-tin"/></div>
	 <div class="boxcontent">
	<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirectOnedoor) %>" />
	<input name="<portlet:namespace />tabs" type="hidden" value="<%= tabsEditOnedoor %>" />
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<input name="<portlet:namespace />stateProcessId" type="hidden" id="stateProcessId" value="<%=String.valueOf(stateProcessId) %>" />
	<input name="<portlet:namespace />fileStatusId" type="hidden" id="fileStatusId" value="<%=String.valueOf(fileStatusId) %>" />
	<input name="<portlet:namespace />statusId" type="hidden" value="<%=String.valueOf(statusId) %>" />
	<input type="hidden" value=""  id="checkFileStatusStateProcess"/>
	<table cellspacing="0" width="100%">
			<tr>
				<td width="20%"><label><liferay-ui:message key="pml_edm_file_state_process_code"/>&nbsp;:</label></td>
				<td>					
					<select  name="<portlet:namespace />stateprocessidchoice" id="stateProcessIdChoice" style="width: 96%">
					<%
						List<PmlStateProcess> stateProcessList = new ArrayList<PmlStateProcess>();
						
						try {
							stateProcessList = PmlStateProcessUtil.findByStateProcessName("MC");
						} catch (SystemException e) {
							stateProcessList = new ArrayList<PmlStateProcess>();
						}
						
						for (PmlStateProcess pmlStateProcessOnedoor : stateProcessList) {
						%>
							<option <%= (stateProcessId == pmlStateProcessOnedoor.getStateProcessId()? "selected=selected" : "") %> value="<%= pmlStateProcessOnedoor.getStateProcessId()%>" ><%= pmlStateProcessOnedoor.getStateProcessCode() %> </option>
						<%
						}
						
					%>
						
					</select>
				</td>
				
		</tr>
		<tr valign="top">
			<td><label><liferay-ui:message key="trangthai_xuly"/>&nbsp;:</label></td>
			<td><textarea name="<portlet:namespace/>description" id="description" rows="5" style="width: 95%" ><%= stateProcess%></textarea></td>
		</tr>
		<tr>
			<td></td>
			<td>
			<input style="margin-left: 0" type="submit" value='<liferay-ui:message key="update"/>'/>
    		<input type="reset" name="reset" id="reset" value="<liferay-ui:message key="reset" />" />
    		<input onclick="window.history.back()" type="button"	value='<liferay-ui:message key="back"/>' />
		 </td>
		</tr>
	</table>
	</div>
</form>