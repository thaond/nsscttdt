<liferay-portlet:actionURL windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>" var="printURL">
	<liferay-portlet:param name="struts_action" value="/ext/meeting_calendar/print_cal" />					
	<liferay-portlet:param name="reportType" value="word" />				
	<liferay-portlet:param name="groupId" value="<%= String.valueOf(portletGroupId.longValue()) %>" />
	<liferay-portlet:param name="month" value="<%= String.valueOf(cal.get(Calendar.MONTH)) %>" />
	<liferay-portlet:param name="day" value="<%= String.valueOf(cal.get(Calendar.DATE)) %>" />
	<liferay-portlet:param name="year" value="<%= String.valueOf(cal.get(Calendar.YEAR)) %>" />
	<liferay-portlet:param name="week" value="<%= String.valueOf(cal.get(Calendar.WEEK_OF_YEAR)) %>" />
	<liferay-portlet:param name="eventType" value="<%= eventType %>" />
	<liferay-portlet:param name="tabs1_" value="<%= tabs1_ %>" />
</liferay-portlet:actionURL>

<liferay-ui:icon image="printCt" message="print-calendar" url="<%= printURL %>" />
&nbsp;&nbsp;&nbsp;<liferay-ui:message key ="print-calendar"/>

	