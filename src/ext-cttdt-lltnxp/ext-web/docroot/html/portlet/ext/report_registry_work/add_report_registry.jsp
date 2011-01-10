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
%>

<liferay-ui:tabs names="Department,Report-Registry" url="<%= portletURLString %>" />

<div class="separator"></div>

<portlet:actionURL var="add_report_registry">
	<portlet:param name="struts_action" value="/sgs/report_registry_work/view" />
	<portlet:param name="varAction" value="reportregistry" />
	<portlet:param name="tabs1" value="Report-Registry" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=add_report_registry%>" onsubmit="return check(this);" method="post">
<table>
	<tr>
		<td><liferay-ui:message key="report-registry-code" /></td>
		<td><input type="text" name="<portlet:namespace/>reportRegistryCode"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="result-work" /></td>
		<td><input type="text" name="<portlet:namespace/>resultWork"></td>
	</tr>
	<% int fileList = 1; %>
	<% for(int i = 1;i <= fileList; i++){ %>
	<tr>
		<td><liferay-ui:message key="result-work-file" /></td>
		<td><input type="file" name="<portlet:namespace/>resultWorkFile"></td>
	</tr>
	<%} %>
	<tr>
		<td><liferay-ui:message key="program-work" /></td>
		<td><input type="text" name="<portlet:namespace/>programWork"></td>
	</tr>
</table>
<div class="separator"></div>
<input type="submit" value='<liferay-ui:message key="add-report-registry"/>'></form>

<script type="text/javascript" language="JavaScript">
	 function check(form){
		 if((checkCode(form)==false) || checkName(form)==false || (checkDescription(form)==false)){
			return false;			 
		 }else{
			 return true;
		 }
	 }
	 
	 function checkCode(form){
			if(form.<portlet:namespace/>reportRegistryCode.value=="" || form.<portlet:namespace/>reportRegistryCode.value==null){
				alert("<liferay-ui:message key='input-report-registry-code'/>");
				return false;
			}
	    }
	 
	 function checkName(form){
			if(form.<portlet:namespace/>resultWork.value=="" || form.<portlet:namespace/>resultWork.value==null){
				alert("<liferay-ui:message key='input-result-work'/>");
				return false;
			}
	    }
	 
	function checkDescription(form){
		if(form.<portlet:namespace/>programWork.value=="" || form.<portlet:namespace/>programWork.value==null){
			alert("<liferay-ui:message key='input-program-work'/>");
			return false;
		}
    }
</script>