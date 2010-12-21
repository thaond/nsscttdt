<liferay-portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="downloadURL1">
	<liferay-portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" />					
	<liferay-portlet:param name="<%= Constants.CMD %>" value="DOWNLOAD" />				
	<liferay-portlet:param name="MCalId" value="<%= String.valueOf(mcal_E.getMcalId()) %>" />													
	<liferay-portlet:param name="attachment" value="<%= mcal_E.getFilename() %>" />					
</liferay-portlet:actionURL>
<liferay-ui:icon image="clip" message="<%= mcal_E.getFilename()%>" url="<%= downloadURL1 %>" />