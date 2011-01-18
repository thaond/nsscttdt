<%@ include file="/html/portlet/ext/report_registry_work_index/init.jsp" %>

<%@page import="com.sgs.portlet.report_registry_work_index.search.DepartmentIndexDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work_index.search.DepartmentIndexSearch"%>

<%
	DepartmentIndexSearch departmentSearch = (DepartmentIndexSearch) request.getAttribute("liferay-ui:search:searchContainer");
	DepartmentIndexDisplayTerms displayTerms = (DepartmentIndexDisplayTerms) departmentSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_report_registry_work_index">
	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="department-code" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DepartmentIndexDisplayTerms.DEPARTMENTCODE%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDepartmentCode())%>" />
			</td>

			<td><liferay-ui:message key="department-name" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DepartmentIndexDisplayTerms.DEPARTMENTNAME%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDepartmentName())%>" />
			</td>
			
			<td><liferay-ui:message key="department-description" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DepartmentIndexDisplayTerms.DEPARTMENTDESCRIPTION%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDepartmentDescription())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>

<br><br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />

