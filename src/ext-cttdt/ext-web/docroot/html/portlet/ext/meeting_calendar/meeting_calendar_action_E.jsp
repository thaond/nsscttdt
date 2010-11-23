<%
if(event_E.getGroupId() == portletGroupId.longValue()){
%>
	<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(),MeetingCalendarKey.APPROVE_CALENDAR) && 
		((mcal_E.getState() == MeetingCalendarKey.CHO_DUYET) || (mcal_E.getState() == MeetingCalendarKey.HUY))%>">
		<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>" var="approveURL">
			<portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" />
			<portlet:param name="<%=Constants.CMD %>" value="APPROVE_CALENDAR"/>
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="mcalId" value="<%=String.valueOf(mcal_E.getMcalId())%>" />
		</portlet:actionURL>
		<%
		if (approveURL.startsWith(Http.HTTP_WITH_SLASH) || approveURL.startsWith(Http.HTTPS_WITH_SLASH)) {
			approveURL = "submitForm(document.hrefFm, '" + HttpUtil.encodeURL(approveURL) + "');";
		}
		approveURL = "javascript: if (confirm('" + UnicodeLanguageUtil.get(pageContext, "do-you-want-to-approve")+"?" + "')) { " + approveURL + " } else { self.focus(); }";
		%>
		<liferay-ui:icon image="approve" url="<%=approveURL%>" />
	</c:if>
	
	<c:if test="<%= ((CalEventPermission.contains(permissionChecker, event_E , ActionKeys.UPDATE ) && (mcal_E.getState() == MeetingCalendarKey.CHO_DUYET)) ||
		PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(), ActionKeys.UPDATE))  && 
		(mcal_E.getState() != MeetingCalendarKey.DOI)
		%>">
		<portlet:renderURL windowState="<%=WindowState.NORMAL.toString()%>" var="editURL">
			<portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="tabs1" value="register-calendar" />
			<portlet:param name="eventId" value="<%=String.valueOf(mcal_E.getMcalId())%>" />
		</portlet:renderURL>
		<liferay-ui:icon image="edit" url="<%=editURL%>" />
	</c:if>
	
	<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(), ActionKeys.UPDATE)  && 
		(mcal_E.getState() == MeetingCalendarKey.DA_DUYET) && (mcal_E.getState() != MeetingCalendarKey.HUY) && (mcal_E.getState() != MeetingCalendarKey.DOI)
		%>">
		<portlet:renderURL windowState="<%=WindowState.NORMAL.toString()%>" var="moveURL">
			<portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" />
			<portlet:param name="redirect" value="<%=currentURL%>" />
			<portlet:param name="tabs1" value="register-calendar" />
			<portlet:param name="eventId" value="<%=String.valueOf(mcal_E.getMcalId())%>" />
		</portlet:renderURL>
		<liferay-ui:icon image="undo" message="doi-ngay" url="<%=moveURL%>" />
	</c:if>
	
	<c:if test="<%= PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(), ActionKeys.DELETE) && 
		(mcal_E.getState() == MeetingCalendarKey.DA_DUYET) && (mcal_E.getState() != MeetingCalendarKey.HUY) && (mcal_E.getState() != MeetingCalendarKey.DOI) 
		%>">
		<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>" var="cancelURL">
			<portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.CANCEL %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="eventId" value="<%= String.valueOf(mcal_E.getMcalId()) %>" />
		</portlet:actionURL>
		<%
		if (cancelURL.startsWith(Http.HTTP_WITH_SLASH) || cancelURL.startsWith(Http.HTTPS_WITH_SLASH)) {
			cancelURL = "submitForm(document.hrefFm, '" + HttpUtil.encodeURL(cancelURL) + "');";
		}
		cancelURL = "javascript: if (confirm('" + UnicodeLanguageUtil.get(pageContext, "do-you-want-to-cancel")+"?" + "')) { " + cancelURL + " } else { self.focus(); }";
		%>
		<liferay-ui:icon image="close" message="huy-hop" url="<%= cancelURL %>" />
	</c:if>
	
	<c:if test="<%= ((CalEventPermission.contains(permissionChecker, event_E , ActionKeys.DELETE ) && (mcal_E.getState() == MeetingCalendarKey.CHO_DUYET)) ||
		PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(), ActionKeys.DELETE)) && 
		(mcal_E.getState() != MeetingCalendarKey.DOI) 
		%>">
		<portlet:actionURL windowState="<%= WindowState.NORMAL.toString() %>" var="deleteURL">
			<portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" />
			<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE %>" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="eventId" value="<%= String.valueOf(mcal_E.getMcalId()) %>" />
		</portlet:actionURL>
		<%
		if (deleteURL.startsWith(Http.HTTP_WITH_SLASH) || deleteURL.startsWith(Http.HTTPS_WITH_SLASH)) {
			deleteURL = "submitForm(document.hrefFm, '" + HttpUtil.encodeURL(deleteURL) + "');";
		}
		deleteURL = "javascript: if (confirm('" + UnicodeLanguageUtil.get(pageContext, "do-you-want-to-delete")+"?" + "')) { " + deleteURL + " } else { self.focus(); }";
		%>
		<liferay-ui:icon image="delete" url="<%= deleteURL %>" />
	</c:if>
<%
}
%>