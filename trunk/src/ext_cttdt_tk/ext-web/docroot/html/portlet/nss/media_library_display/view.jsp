<%@ include file="/html/portlet/nss/media_library_display/init.jsp" %>

<%
	String tabs = ParamUtil.getString(request, "tabs");
	PortletURL portletURL = renderResponse.createRenderURL();
	if (Validator.isNull(tabs)) {
		tabs = "display";
	}
	portletURL.setParameter("tabs", tabs);
%>

<c:choose>
	<c:when test='<%=tabs.equals("display")%>'>
		<div>
			<liferay-util:include page="/html/portlet/nss/media_library_display/displayall.jsp" />
		</div>
	</c:when>

	<c:when test='<%=tabs.equals("topic")%>'>
		<div>
			<liferay-util:include page="/html/portlet/nss/media_library_display/displaytopic.jsp" />
		</div>
	</c:when>
</c:choose>