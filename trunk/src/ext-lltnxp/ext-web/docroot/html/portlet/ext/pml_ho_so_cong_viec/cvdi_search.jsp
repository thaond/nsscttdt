<%@ include file="/html/portlet/ext/pml_ho_so_cong_viec/init.jsp" %>

<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>

<%
	PmlEdmDocumentSendSearch documentSearch = (PmlEdmDocumentSendSearch)request.getAttribute("liferay-ui:search:searchContainer");
	PmlEdmDocumentSendDisplayTerms displayTerms = (PmlEdmDocumentSendDisplayTerms)documentSearch.getDisplayTerms();
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("struts_action", "/sgs/pml_ho_so_cong_viec/thu_thap_cvdi");
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
							<input style="width: 90%" type="text" name="<portlet:namespace /><%= displayTerms.DOCUMENT_SEND_REFERENCE %>" value="<%= displayTerms.getDocumentSendReference() %>"/>
						</td>
						<td width="22%">
							<label><liferay-ui:message key="tu-ngay" /></label>
							<input style="width: 130px;" type="text" id="documentSendFromDate" name="<portlet:namespace /><%= displayTerms.DOCUMENT_SEND_FROM_DATE %>" value="<%= displayTerms.getDocumentSendFromDate() == null ? "" : df.format(displayTerms.getDocumentSendFromDate()) %>"/>
							<img align="top" style="cursor: pointer" id="cal-button-documentFromDate" src="/html/images/cal.gif" onclick="callCalendar('documentSendFromDate','cal-button-documentFromDate');"/>
						</td>
						<td>
							<label><liferay-ui:message key="den-ngay" /></label>
							<input style="width: 130px;" type="text" id="documentSendToDate" name="<portlet:namespace /><%= displayTerms.DOCUMENT_SEND_TO_DATE %>" value="<%= displayTerms.getDocumentSendToDate() == null ? "" : df.format(displayTerms.getDocumentSendToDate()) %>"/>
							<img align="top" style="cursor: pointer" id="cal-button-documentSendToDate" src="/html/images/cal.gif" onclick="callCalendar('documentSendToDate','cal-button-documentSendToDate');"/>
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
				<textarea rows="4" style="width: 80%;" name="<portlet:namespace /><%= displayTerms.DOCUMENT_SEND_BRIEF_CONTENT %>"><%= displayTerms.getDocumentSendBriefContent() %></textarea>
			</td>
		</tr>
				
	</table>
</div>
<input style="margin-left: 16%" type="button" value="<liferay-ui:message key="search" />" onclick="javascript : submitForm (document.<portlet:namespace />fm, '<%= portletURL.toString() %>');" />