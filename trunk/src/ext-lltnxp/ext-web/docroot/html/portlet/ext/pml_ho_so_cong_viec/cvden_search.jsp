<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>

<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>

<%
	PmlEdmDocumentReceiptSearch documentSearch = (PmlEdmDocumentReceiptSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PmlEdmDocumentReceiptDisplayTerms displayTerms = (PmlEdmDocumentReceiptDisplayTerms)documentSearch.getDisplayTerms();
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/thu_thap_cvden");
%>


	<div class="title_categ" style="text-transform: inherit;"><liferay-ui:message key="tim-kiem-cong-van-den"/></div>
	<div class="boxcontent">
	<table width="100%" cellspacing="0">
	
		<tr>
			<td width="15%">
				<label><liferay-ui:message key="pccc-cvdtn-sohieu" />:</label>
			</td>
			<td>
				<table width="100%" cellspacing="0">
					<tr>
						<td width="40%">
							<input style="width: 90%" type="text" name="<portlet:namespace /><%= displayTerms.DOCUMENT_REFERENCE %>" value="<%= displayTerms.getDocumentReference() %>"/>
						</td>
						<td width="22%">
							<label><liferay-ui:message key="tu-ngay" /></label>
							<input style="width: 120px;" type="text" id="fromDate" name="<portlet:namespace /><%= displayTerms.FROM_DATE %>" value="<%= displayTerms.getFromDate() == null ? "" : df.format(displayTerms.getFromDate()) %>"/>
							<img align="top" style="cursor: pointer" id="cal-button-fromDate" src="/html/images/cal.gif" onclick="callCalendar('fromDate','cal-button-fromDate');"/>
						</td>
						<td >
							<label><liferay-ui:message key="den-ngay" /></label>
							<input style="width: 120px;" type="text" id="toDate" name="<portlet:namespace /><%= displayTerms.TO_DATE %>" value="<%= displayTerms.getToDate() == null ? "" : df.format(displayTerms.getToDate()) %>"/>
							<img align="top" style="cursor: pointer" id="cal-button-toDate" src="/html/images/cal.gif" onclick="callCalendar('toDate','cal-button-toDate');"/>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr>
			<td>
				<label><liferay-ui:message key="trich-yeu"/>:</label>
			</td>
			<td>
				<textarea rows="4" style="width: 80%;" name="<portlet:namespace /><%= displayTerms.BRIEF_CONTENT %>"><%= displayTerms.getBriefContent() %></textarea>
			</td>
		</tr>
	</table>
</div>
<input style="margin-left: 16%" type="button" value="<liferay-ui:message key="search" />" onclick="javascript : submitForm (document.<portlet:namespace />fm, '<%= portletURL.toString() %>');" />