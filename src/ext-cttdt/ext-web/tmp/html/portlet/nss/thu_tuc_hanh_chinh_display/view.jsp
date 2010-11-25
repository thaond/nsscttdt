<%@ include file="/html/portlet/nss/thu_tuc_hanh_chinh_display/init.jsp" %>

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
			page="/html/portlet/nss/thu_tuc_hanh_chinh_display/display.jsp" /></div>
	</c:when>

	<c:when test='<%=tabs.equals("detail")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/thu_tuc_hanh_chinh_display/detail.jsp" /></div>
	</c:when>
</c:choose>
