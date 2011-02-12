<%@ include file="/html/portlet/ext/holiday_calendar_index/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab");
	if (Validator.isNull(tab)){
		tab = "view_holiday_calendar_index";
	}
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tab", tab);
%>


<c:choose>
	<c:when test='<%=tab.equals("view_holiday_calendar_index") %>'>
		<liferay-util:include page="/html/portlet/ext/holiday_calendar_index/display.jsp"></liferay-util:include>
	</c:when>
</c:choose>