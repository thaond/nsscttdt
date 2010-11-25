<%@ include file="/html/portlet/nss/van_ban_phap_quy_display/init.jsp" %>

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
		<div><liferay-util:include
			page="/html/portlet/nss/van_ban_phap_quy_display/display.jsp" /></div>
	</c:when>

	<c:when test='<%=tabs.equals("detail")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/van_ban_phap_quy_display/detail.jsp" /></div>
	</c:when>
</c:choose>
