<%@ include file="/html/portlet/ext/holiday_calendar/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab");
	String tabAddHolidayCalendar = (String) request.getAttribute("tabAddHolidayCalendar");
	if (Validator.isNull(tab)){
		tab = "view_holiday_calendar";
	}
	if(tabAddHolidayCalendar != null){
		tab = "add_holiday_calendar";
	}
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tab", tab);
%>


<c:choose>
	<c:when test='<%=tab.equals("view_holiday_calendar") %>'>
		<liferay-util:include page="/html/portlet/ext/holiday_calendar/display.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("add_holiday_calendar") %>'>
		<liferay-util:include page="/html/portlet/ext/holiday_calendar/add_holiday_calendar.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("edit_holiday_calendar") %>'>
		<liferay-util:include page="/html/portlet/ext/holiday_calendar/edit_holiday_calendar.jsp"></liferay-util:include>
	</c:when>
</c:choose>