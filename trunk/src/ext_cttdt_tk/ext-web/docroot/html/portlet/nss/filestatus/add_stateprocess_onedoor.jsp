<%@page import="com.nss.portlet.onedoor.service.PmlStateProcessLocalServiceUtil"%>
<%@ include file="/html/portlet/nss/filestatus/init.jsp" %>
<%@ include file="/html/portlet/nss/filestatus/js/pmledm_filestatus-js.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.nss.portlet.onedoor.model.PmlFileStatusStateProcess"%>
<%@page import="com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessUtil"%>
<%@page import="com.nss.portlet.onedoor.model.PmlStateProcess"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.nss.portlet.onedoor.service.persistence.PmlStateProcessUtil"%>
<%@page import="com.liferay.portal.SystemException"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%

	String tabsProcessOnedoor = request.getParameter("tabs");
	String redirectfileStatus = request.getParameter("redirect");
	String redirectProcessOnedoor = request.getParameter("redirect1");
	String fileStatusId = (String)request.getParameter("fileStatusId");
	
%>

<portlet:actionURL var="add_stateprocess_action">
	<portlet:param name="struts_action" value="/nss/filestatus/display_stateprocess_onedoor"/>
	<portlet:param name="fileStatusId" value="<%=fileStatusId%>"/>
</portlet:actionURL>
<form action="<%=add_stateprocess_action %>" method="post" name="<portlet:namespace/>fm" onsubmit="return validateFileStatusStateProcess()">
	<input name="<portlet:namespace /><%= Constants.CMD %>" type="hidden" value="<%= Constants.ADD %>" />
	<input type="hidden" value="<%= tabsProcessOnedoor %>"  name="tabs"/>
	<input type="hidden" value="<%= fileStatusId %>"  id="fileStatusId"/>
	<input type="hidden" value="<%= String.valueOf(0) %>"  id="stateProcessId"/>
	<input type="hidden" value=""  id="checkFileStatusStateProcess"/>
	<div class="title_categ"><liferay-ui:message key="add_new"/></div>
	 <div class="boxcontent">
	<table cellspacing="0" width="100%">
			<tr>
				<td width="20%"><label><liferay-ui:message key="pml_edm_file_state_process_name"/>&nbsp;:</label></td>
				<td><select name="state_process_id" id="stateProcessIdChoice" style="width: 96%">
				<%
					List<PmlStateProcess> stateProcessList = PmlStateProcessLocalServiceUtil.findByStateProcessName("MC");
					
					for (PmlStateProcess pmlStateProcess : stateProcessList) {
						out.println("<option value=\"" + pmlStateProcess.getStateProcessId() + "\">" + pmlStateProcess.getStateProcessCode() + "</option>");
					}
				%>
				</select></td>
			</tr>
			<tr valign="top">
				<td><label><liferay-ui:message key="trangthai_xuly"/>&nbsp;:</label></td>
				<td><textarea name="<portlet:namespace/>description" id="description" rows="5" style="width: 95%"></textarea></td>
			</tr>
	
	<portlet:renderURL var="back">
		<portlet:param name="struts_action" value="/nss/filestatus/display_stateprocess_onedoor"/>
		<portlet:param name="fileStatusId" value="<%=fileStatusId%>"/>
		<portlet:param name="tabs" value="<%= tabsProcessOnedoor %>"/>
		<portlet:param name="redirect" value="<%= redirectfileStatus %>"/>
		<portlet:param name="redirect1" value="<%= redirectProcessOnedoor %>"/>
	</portlet:renderURL>
	
	
			<tr>
				<td></td>
				<td>
				<input style="margin-left: 0" type="submit" value='<liferay-ui:message key="save"/>'/>
	    		<input type="reset" name="reset" id="reset" value='<liferay-ui:message key="reset" />' />
				<span onclick="javascript:submitForm(document.hrefFm,'<%= back.toString() %>');"><input  type="button"	value='<liferay-ui:message key="back"/>' /></span>
			 </td>
			</tr>
	</table>
</div>	
</form>