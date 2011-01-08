<%@ include file="/html/portlet/ext/meeting_calendar_view/init.jsp" %>

<%

String tabs1 = ParamUtil.getString(request, "tabs1", tabs1Default);
String redirect = ParamUtil.getString(request, "redirect");
String eventType = ParamUtil.getString(request, "eventType");
PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setWindowState(WindowState.NORMAL);

portletURL.setParameter("struts_action", "/ext/meeting_calendar_view/view");
portletURL.setParameter("tabs1", tabs1);

%>
<liferay-util:include page="/html/portlet/ext/meeting_calendar_view/tabs1.jsp" />
<c:choose>
	<c:when test='<%= tabs1.equals("lich-ngay")  %>'>
		<%@ include file="/html/portlet/ext/meeting_calendar_view/date.jsp" %>
	</c:when>
</c:choose>
