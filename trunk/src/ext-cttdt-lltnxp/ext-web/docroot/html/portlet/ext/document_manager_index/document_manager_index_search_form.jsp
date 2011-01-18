<%@ include file="/html/portlet/ext/document_manager_index/init.jsp" %>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@page import="com.sgs.portlet.document_manager_index.search.DocumentManagerIndexDisplayTerms"%>
<%@page import="com.sgs.portlet.document_manager_index.search.DocumentManagerIndexSearch"%>

<%
	DocumentManagerIndexSearch DocumentManagerIndexSearch = (DocumentManagerIndexSearch) request.getAttribute("liferay-ui:search:searchContainer");
	DocumentManagerIndexDisplayTerms displayTerms = (DocumentManagerIndexDisplayTerms) DocumentManagerIndexSearch.getDisplayTerms();
	
	String dateFrom = (String) request.getAttribute("dateFrom");
	String dateTo= (String) request.getAttribute("dateTo");
	
%>

	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="document-manager-code" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERCODE%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDocumentManagerCode())%>" />
			</td>
			
			<td><liferay-ui:message key="document-manager-category" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERCATEGORY%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDocumentManagerCategory())%>" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="document-manager-description" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERDESCRIPTION%>"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDocumentManagerDescription())%>" />
			</td>
			
			<td><liferay-ui:message key="document-manager-title" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DocumentManagerIndexDisplayTerms.DOCUMENTMANAGERTITLE%>" 
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDocumentManagerTitle())%>" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="date-from" />&nbsp;</td>
			<td>
				<input name="<portlet:namespace />dateFrom"  value="<%= (dateFrom != null) ? dateFrom : "" %>" id="<portlet:namespace />cal_from_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onmouseover="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
			</td>
			
			<td><liferay-ui:message key="date-to" />&nbsp;</td>
			<td>
				<input name="<portlet:namespace />dateTo"  value="<%= (dateTo != null) ? dateTo : "" %>" id="<portlet:namespace />cal_to_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
				<img align="top" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onmouseover="callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate')" />
			</td>
		</tr>
	</table>

<br><br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" onclick="return checkDate();" value="<liferay-ui:message key="search"/>" />
