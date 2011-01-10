<%@page import="com.sgs.portlet.report_registry_work.search.DepartmentDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.DepartmentSearch"%>
<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>


<%
	DepartmentSearch departmentSearch = (DepartmentSearch) request.getAttribute("liferay-ui:search:searchContainer");
	DepartmentDisplayTerms displayTerms = (DepartmentDisplayTerms) departmentSearch.getDisplayTerms();
%>

<liferay-ui:search-toggle displayTerms="<%= displayTerms %>" id="toogle_id_report_registry_work">
	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="department-code" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DepartmentDisplayTerms.DEPARTMENTCODE%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDepartmentCode())%>" />
			</td>

			<td><liferay-ui:message key="contact-name" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DepartmentDisplayTerms.DEPARTMENTNAME%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDepartmentName())%>" />
			</td>
			
			<td><liferay-ui:message key="contact-description" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DepartmentDisplayTerms.DEPARTMENTDESCRIPTION%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDepartmentDescription())%>" />
			</td>
		</tr>
	</table>
</liferay-ui:search-toggle>

<br><br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />

