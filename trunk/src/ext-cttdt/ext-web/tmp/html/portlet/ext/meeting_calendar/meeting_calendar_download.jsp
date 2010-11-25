<liferay-portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="downloadURL">
	<liferay-portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" />					
	<liferay-portlet:param name="<%= Constants.CMD %>" value="DOWNLOAD" />				
	<liferay-portlet:param name="MCalId" value="<%= String.valueOf(mcal.getMcalId()) %>" />
	<liferay-portlet:param name="attachment" value="<%= mcal.getFilename() %>" />
</liferay-portlet:actionURL>

<liferay-ui:icon image="clip" message="<%= mcal.getFilename()%>" url="<%= downloadURL %>" />