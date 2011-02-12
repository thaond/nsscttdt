<%@page import="com.sgs.portlet.report_registry_work.service.ReportRegistryLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.service.ResultProgramLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sgs.portlet.report_registry_work.model.ResultProgram"%>
<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>
<%@ include file="/html/portlet/ext/report_registry_work/js/report_registry.jsp" %>

<%@page import="com.sgs.portlet.report_registry_work.model.ReportRegistry"%>
<%@page import="com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.Department"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	String tabs1 = ParamUtil.getString(request, "tabs1" ,"Report-Registry");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/report_registry_work/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	
	List<Department> departments = DepartmentLocalServiceUtil.getDepartments(-1,-1);
	ReportRegistry reportRegistry = (ReportRegistry) request.getAttribute("reportRegistry");
	List<ResultProgram> resultPrograms = new ArrayList<ResultProgram>();
	if(reportRegistry != null){
		resultPrograms = ReportRegistryLocalServiceUtil.getResultPrograms(reportRegistry.getReportRegistryId());
	}
	String linkResultWork = "";
	String linkProgramWork = "";
	
%>

<liferay-ui:tabs names="Report-Registry,Department" url="<%= portletURLString %>" />

<div class="separator"></div>

<portlet:actionURL var="edit_report_registry">
	<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
	<portlet:param name="varAction" value="reportregistry" />
	<portlet:param name="tabs1" value="Report-Registry" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<% if(reportRegistry != null){ %>
<form action="<%=edit_report_registry%>" enctype="multipart/form-data" method="post" name="<portlet:namespace/>fm">
<input type="hidden" name="<portlet:namespace/>reportRegistryId" value="<%=reportRegistry.getReportRegistryId()%>">
<input type="hidden" name="<portlet:namespace/>resultProgramId" value="">
<table>
	<tr>
		<td><liferay-ui:message key="report-registry-code" /></td>
		<td><input type="text" readonly="readonly" size="50" name="<portlet:namespace/>reportRegistryCode" value="<%=reportRegistry.getReportRegistryCode()%>"></td>
		<td><liferay-ui:message key="department-name" /></td>
		<td>
		<select name="<portlet:namespace/>department">
			<% if(departments.size() >0 ){ %>
				<% for(int i = 0; i < departments.size(); i++){ %>
					<option value="<%=departments.get(i).getDepartmentId()%>" <%= (departments.get(i).getDepartmentId() == reportRegistry.getDepartmentId() ? "selected" : "") %>><%=departments.get(i).getDepartmentName()%></option>		
				<%} %> 
			<%} %> 
		</select>
		</td>
	</tr>
</table>	

<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="result-work"/></label>
		<% 	for(ResultProgram resultProgram : resultPrograms){
			String path = resultProgram.getResultProgramPath();
			String title = (String)resultProgram.getResultProgramTitle().subSequence(0,resultProgram.getResultProgramTitle().indexOf("_"));
			long resultProgramId = resultProgram.getResultProgramId();
			String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ resultProgramId +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			if(resultProgram.getResultProgramCheck().equals("resultwork")){
				if(!resultProgram.getResultProgramTitle().equals("")){
					linkResultWork = "<a href =" + path + ">" + title + "</a>" + deleteAction;
				}
		%>
			<%=linkResultWork %>
		<% }%> 
		<% }%>
		<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
		   		<td><liferay-ui:message key="result-title-file" /></td>
		    	<td width="50%"><liferay-ui:message key="result-name-file" /></td>
				<td width="15%" align="center"><input type="button" value='<liferay-ui:message key="add-result-work-file" />' onclick="uploadResultFile()"></td>
			</tr>
		</table>
		
		 <input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
		 <input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
</fieldset>

<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="program-work"/></label>
		<% 	for(ResultProgram resultProgram : resultPrograms){
			String path = resultProgram.getResultProgramPath();
			String title = (String)resultProgram.getResultProgramTitle().subSequence(0,resultProgram.getResultProgramTitle().indexOf("_"));
			long resultProgramId = resultProgram.getResultProgramId();
			String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirm('"+ resultProgramId +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
			if(resultProgram.getResultProgramCheck().equals("programwork")){
				if(!resultProgram.getResultProgramTitle().equals("")){
					linkProgramWork = "<a href =" + path + ">" + title + "</a>" + deleteAction;
				}
		%>
			<%=linkProgramWork %>
		<% }%> 
		<% }%>
		<table id="addfileupload1" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
		   		<td><liferay-ui:message key="program-title-file" /></td>
		    	<td width="50%"><liferay-ui:message key="program-name-file" /></td>
				<td width="15%" align="center"><input type="button" value='<liferay-ui:message key="add-program-work-file" />' onclick="uploadProgramFile()"></td>
			</tr>
		</table>
		
		 <input type="hidden" name="<portlet:namespace/>nameFieldRow1" id="nameFieldRow1" value="" />
		 <input type="hidden" name="<portlet:namespace/>nameFiles1" id="nameFiles1" value="" />
		 <input type="hidden" name="<portlet:namespace/>titleFiles1" id="titleFiles1" value="" />
</fieldset>

<br>

<input type="submit" value='<liferay-ui:message key="edit-report-registry"/>' onclick="return checkValidate()">
<a href="<%=redirect %>>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>
<%} %>

<script type="text/javascript">
	function deleteConfirm(resultProgramId) {
		document.<portlet:namespace/>fm.<portlet:namespace/>resultProgramId.value = resultProgramId;
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			sendDelete();
		}
	}
	function sendDelete(){
		submitForm(document.<portlet:namespace/>fm,
			"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
			<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
			<portlet:param name="tabs1" value="Report-Registry" />
			<portlet:param name="varAction" value="resultprogram" />
			<portlet:param name="tab" value="edit_report_registry" />
			<portlet:param name="redirect" value="<%=redirect%>" />
			<portlet:param name="reportRegistryId" value="<%=String.valueOf(reportRegistry.getReportRegistryId())%>" />
			<portlet:param name="<%=Constants.CMD%>" value="<%=Constants.DELETE%>" />
			</portlet:actionURL>");
	}
</script>