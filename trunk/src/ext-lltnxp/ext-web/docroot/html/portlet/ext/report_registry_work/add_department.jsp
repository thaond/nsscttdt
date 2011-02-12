<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	String tabs1 = ParamUtil.getString(request, "tabs1" ,"Report-Registry");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/report_registry_work/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
	
	String departmentCode = (String) request.getAttribute("departmentCode");
	String departmentName = (String) request.getAttribute("departmentName");
	String departmentDescription = (String) request.getAttribute("departmentDescription");
	String duplicateDepartmentCode = (String) request.getAttribute("duplicate_department_code");
%>

<% if(duplicateDepartmentCode != null){ %>
	<div style="color: red"><liferay-ui:message key="not-add-department"/></div>
<%} %>

<liferay-ui:tabs names="Report-Registry,Department" url="<%= portletURLString %>" />

<div class="separator"></div>

<portlet:actionURL var="add_department">
	<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
	<portlet:param name="varAction" value="department" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=add_department%>" onsubmit="return check(this);" method="post" name="<portlet:namespace />fm">
<table>
	<tr>
		<td><liferay-ui:message key="department-code" /></td>
		<td><input type="text" name="<portlet:namespace/>departmentCode" value="<%= (departmentCode != null) ? departmentCode : "" %>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="department-name" /></td>
		<td><input type="text" name="<portlet:namespace/>departmentName" value="<%= (departmentName != null) ? departmentName : "" %>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="department-description" /></td>
		<td><input type="text" name="<portlet:namespace/>departmentDescription" value="<%= (departmentDescription != null) ? departmentDescription : "" %>"></td>
	</tr>
</table>
<div class="separator"></div>
<input type="submit" value='<liferay-ui:message key="add-department"/>'>
<a href="<%=redirect %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>


<script type="text/javascript" language="JavaScript">
	 function check(form){
		 if((checkCode(form)==false) || (checkName(form)==false)){
			return false;			 
		 }else{
			 return true;
		 }
	 }
	 
	 function checkCode(form){
			if(form.<portlet:namespace/>departmentCode.value=="" || form.<portlet:namespace/>departmentCode.value==null){
				alert("<liferay-ui:message key='input-department-code'/>");
				return false;
		}
	 }
	 
	 function checkName(form){
			if(form.<portlet:namespace/>departmentName.value=="" || form.<portlet:namespace/>departmentName.value==null){
				alert("<liferay-ui:message key='input-department-name'/>");
				return false;
		}
	 }
	 
	function checkDescription(form){
		if(form.<portlet:namespace/>departmentDescription.value=="" || form.<portlet:namespace/>departmentDescription.value==null){
			alert("<liferay-ui:message key='input-department-description'/>");
			return false;
		}
    }
</script>