<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>
<%@ include file="/html/portlet/ext/report_registry_work/js/report_registry.jsp" %>

<%@page import="com.sgs.portlet.report_registry_work.service.DepartmentLocalServiceUtil"%>
<%@page import="com.sgs.portlet.report_registry_work.model.Department"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
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
	String duplicateReportRegistryCode = (String) request.getAttribute("duplicate_report_registry_code");
	String reportRegistryCode = (String) request.getAttribute("reportRegistryCode");
	String departmentId = (String) request.getAttribute("departmentId");
	long departmentIdSelect = 0;
	if(departmentId != null){
		departmentIdSelect = Long.parseLong(departmentId);	
	}
%>

<% if(duplicateReportRegistryCode != null){ %>
	<div style="color: red"><liferay-ui:message key="not-add-report-registry"/></div>
<%} %>

<liferay-ui:tabs names="Department,Report-Registry" url="<%= portletURLString %>" />

<div class="separator"></div>

<portlet:actionURL var="add_report_registry">
	<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
	<portlet:param name="varAction" value="reportregistry" />
	<portlet:param name="tabs1" value="Report-Registry" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=add_report_registry%>" enctype="multipart/form-data" method="post" name="<portlet:namespace/>fm">
<table>
	<tr>
		<td><liferay-ui:message key="report-registry-code" /></td>
		<td><input type="text" size="50" name="<portlet:namespace/>reportRegistryCode" value="<%= (reportRegistryCode != null) ? reportRegistryCode : "" %>"></td>
		<td><liferay-ui:message key="department-name" /></td>
		<td>
		<select name="<portlet:namespace/>department">
			<% if(departments.size() >0 ){ %>
				<% for(int i = 0; i < departments.size(); i++){ %>
					<option value="<%=departments.get(i).getDepartmentId()%>" <%=(departmentId != null && departmentIdSelect == departments.get(i).getDepartmentId()) ? "selected" : "" %>><%=departments.get(i).getDepartmentName()%></option>		
				<%} %> 
			<%} %> 
		</select>
		</td>
	</tr>
</table>	

<fieldset class="filborder">
		<label class="laborder"><liferay-ui:message key="result-work"/></label>
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

<input type="submit" value='<liferay-ui:message key="add-report-registry"/>' onclick="return checkValidate()">
<a href="<%=redirect %>>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>

