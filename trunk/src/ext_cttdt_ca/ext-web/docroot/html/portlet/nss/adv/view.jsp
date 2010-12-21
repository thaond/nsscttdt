<%@ include file="/html/portlet/nss/adv/init.jsp" %>

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
			page="/html/portlet/nss/adv/display.jsp" /></div>
	</c:when>

	<c:when test='<%=tabs.equals("add")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/adv/add.jsp" /></div>
	</c:when>
	
	<c:when test='<%=tabs.equals("edit")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/adv/edit.jsp" /></div>
	</c:when>
</c:choose>

