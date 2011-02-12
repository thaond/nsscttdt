<%@ include file="/html/portlet/ext/document_manager/init.jsp" %>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>

<%@page import="com.sgs.portlet.document_manager.search.DocumentManagerDisplayTerms"%>
<%@page import="com.sgs.portlet.document_manager.search.DocumentManagerSearch"%>

<%
	DocumentManagerSearch documentManagerSearch = (DocumentManagerSearch) request.getAttribute("liferay-ui:search:searchContainer");
	DocumentManagerDisplayTerms displayTerms = (DocumentManagerDisplayTerms) documentManagerSearch.getDisplayTerms();
%>

	<table cellspacing="0" width="100%">
		<tr>
			<td><liferay-ui:message key="document-manager-code" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DocumentManagerDisplayTerms.DOCUMENTMANAGERCODE%>" id ="<portlet:namespace/>documentManagerCodeAutoComplete"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDocumentManagerCode())%>" />
			</td>
			
			<td><liferay-ui:message key="document-manager-category" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DocumentManagerDisplayTerms.DOCUMENTMANAGERCATEGORY%>" id ="<portlet:namespace/>documentManagerCategoryAutoComplete"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDocumentManagerCategory())%>" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="document-manager-description" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DocumentManagerDisplayTerms.DOCUMENTMANAGERDESCRIPTION%>" id ="<portlet:namespace/>documentManagerDescriptionAutoComplete"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDocumentManagerDescription())%>" />
			</td>
			
			<td><liferay-ui:message key="document-manager-title" />&nbsp;</td>
			<td><input name="<portlet:namespace/><%=DocumentManagerDisplayTerms.DOCUMENTMANAGERTITLE%>" id ="<portlet:namespace/>documentManagerTitleAutoComplete"
				style="width: 90%" type="text" value="<%=HtmlUtil.escape(displayTerms.getDocumentManagerTitle())%>" />
			</td>
		</tr>
		<tr>
			<td><liferay-ui:message key="date-from" />&nbsp;</td>
			<td>
				<input name="<portlet:namespace />dateFrom"  value="<%=HtmlUtil.escape(displayTerms.getDateFrom())%>" id="<portlet:namespace />cal_from_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onmouseover="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
			</td>
			
			<td><liferay-ui:message key="date-to" />&nbsp;</td>
			<td>
				<input name="<portlet:namespace />dateTo"  value="<%=HtmlUtil.escape(displayTerms.getDateTo())%>" id="<portlet:namespace />cal_to_date" size="12" type="text" value="" style="width: 125px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
				<img align="top" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" onmouseover="callCalendar('<portlet:namespace/>cal_to_date','cal-button-ToDate')" />
			</td>
		</tr>
	</table>

<br><br>
<input type="submit" class="button-width" name="<portlet:namespace/>search" onclick="return checkDate();" value="<liferay-ui:message key="search"/>" />
