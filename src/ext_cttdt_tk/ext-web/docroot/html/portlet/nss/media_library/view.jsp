<%@ include file="/html/portlet/nss/media_library/init.jsp" %>

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
			page="/html/portlet/nss/media_library/display.jsp" /></div>
	</c:when>

	<c:when test='<%=tabs.equals("add")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/media_library/add.jsp" /></div>
	</c:when>
	
	<c:when test='<%=tabs.equals("edit")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/media_library/edit.jsp" /></div>
	</c:when>
</c:choose>

