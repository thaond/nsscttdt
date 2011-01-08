<%@ include file="/html/portlet/ext/home_report_onedoor/init.jsp" %>

<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>

<%
	HomeReportOnedoorSearch searchContainer = (HomeReportOnedoorSearch)request.getAttribute("liferay-ui:search:searchContainer");
	HomeReportOnedoorDisplayTerms displayTerms = (HomeReportOnedoorDisplayTerms)searchContainer.getDisplayTerms();
%>

<%	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/home_report_onedoor/view");
%>

<input type="hidden" id="<portlet:namespace/>url" value="<%= portletURL.toString() %>"/>
<div class="search_bct">
	<ul>
		<li style="width: 50%;">
			<table cellspacing="0" width="100%">
					<tr>
						<td align="right" width="25%" style="padding-right: 10px"><liferay-ui:message key="tu-ngay" /></td>
						<td align="left" >
							<input type="text" name="<portlet:namespace/><%= displayTerms.FROMDATE %>" 
									id="<portlet:namespace />fromDate" 
									value="<%= HtmlUtil.escape(displayTerms.getFromDate()) %>" 
									style="width: 74%" onchange="<portlet:namespace/>enableItemsUser()"/>
							<input type="image" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" 
									onClick="callCalendar('<portlet:namespace />fromDate', 'cal-button-FromDate')"/> 
						</td>
					</tr>
			</table>
		</li>
		<li style="width: 49%;">
			<table cellspacing="0" width="100%">
					<tr>
						<td align="right" width="25%" style="padding-right: 10px"><liferay-ui:message key="den-ngay" /></td>
						<td align="left">
							<input type="text" name="<portlet:namespace/><%= displayTerms.TODATE %>" 
									id="<portlet:namespace />toDate" 
									value="<%= HtmlUtil.escape(displayTerms.getToDate()) %>" 
									style="width: 74%" onchange="<portlet:namespace/>enableItemsUser()"/>
							<input type="image" src="/html/images/cal.gif" id="cal-button-ToDate" style="cursor: pointer;" 
									onClick="callCalendar('<portlet:namespace/>toDate','cal-button-ToDate')" />
						</td>
					</tr>
			</table>
		</li>
	</ul>
</div>



<script type="text/javascript">
	if (document.getElementById('<portlet:namespace />fromDate') != null) {
		callCalendar('<portlet:namespace />fromDate', 'cal-button-FromDate');
	}
	if (document.getElementById('<portlet:namespace />toDate') != null) {
		callCalendar('<portlet:namespace />toDate','cal-button-ToDate');
	}
</script>
