<%@page import="com.sgs.portlet.report_registry_work.model.Department"%>
<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	Department department = (Department) request.getAttribute("department");
	String tabs1 = ParamUtil.getString(request, "tabs1");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/report_registry_work/view");
	portletURL.setParameter("tabs1", tabs1);
	String portletURLString = portletURL.toString();
%>

<liferay-ui:tabs names="Department,Report-Registry" url="<%= portletURLString %>" />

<div class="separator"></div>

<portlet:actionURL var="edit_department">
	<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
	<portlet:param name="varAction" value="department" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=edit_department%>" onsubmit="return check(this);" method="post">
<% if(department != null){ %>
<input type="hidden" name="<portlet:namespace/>departmentId" value="<%=department.getDepartmentId()%>">
<table>
	<tr>
		<td><liferay-ui:message key="department-code" /></td>
		<td><input type="text" name="<portlet:namespace/>departmentCode" value="<%=department.getDepartmentCode()%>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="department-name" /></td>
		<td><input type="text" name="<portlet:namespace/>departmentName" value="<%=department.getDepartmentName()%>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="department-description" /></td>
		<td><input type="text" name="<portlet:namespace/>departmentDescription" value="<%=department.getDepartmentDescription()%>"></td>
	</tr>
</table>
<%}else{ %>
rong
<%} %>
<br>
<input type="submit" value="edit-department"></form>

<script type="text/javascript" language="JavaScript">
	 function check(form){
		 if((checkCode(form)==false) || checkName(form)==false || (checkDescription(form)==false)){
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