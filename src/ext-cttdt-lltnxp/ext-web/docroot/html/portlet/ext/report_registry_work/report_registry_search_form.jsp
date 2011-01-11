<%@page import="com.sgs.portlet.report_registry_work.search.ReportRegistryDisplayTerms"%>
<%@page import="com.sgs.portlet.report_registry_work.search.ReportRegistrySearch"%>
<%@ include file="/html/portlet/ext/report_registry_work/init.jsp" %>


<%
	ReportRegistrySearch reportRegistrySearch = (ReportRegistrySearch) request.getAttribute("liferay-ui:search:searchContainer");
	ReportRegistryDisplayTerms displayTerms = (ReportRegistryDisplayTerms) reportRegistrySearch.getDisplayTerms();
%>

	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="report-registry-code" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=ReportRegistryDisplayTerms.REPORTREGISTRYCODE%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getReportRegistryCode())%>" />
			</td>

			<td><liferay-ui:message key="result-work" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=ReportRegistryDisplayTerms.RESULTWORK%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getResultWork())%>" />
			</td>
			
			<td><liferay-ui:message key="program-work" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=ReportRegistryDisplayTerms.PROGRAMWORK%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getProgramWork())%>" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="user-create" />&nbsp;</td>
			<td><input name="<portlet:namespace/>userCreate" style="width: 90%" type="text" value="" />
			</td>

			<td><liferay-ui:message key="date-from" />&nbsp;</td>
			<td><input name="<portlet:namespace/>dateFrom" style="width: 90%" type="text" value="" /></td>
			
			<td><liferay-ui:message key="date-to" />&nbsp;</td>
			<td><input name="<portlet:namespace/>dateTo" style="width: 90%" type="text" value="" /></td>
		</tr>
	</table>

<br><br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" value="<liferay-ui:message key="search"/>" />

