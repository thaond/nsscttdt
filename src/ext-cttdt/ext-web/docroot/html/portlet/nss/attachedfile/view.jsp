<%@ include file="/html/portlet/nss/attachedfile/init.jsp" %>

<%
	String tabs1 = ParamUtil.getString(request, "tabs1");
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.MAXIMIZED);
	if (Validator.isNull(tabs1)) {
		tabs1 = "display";
	}
	portletURL.setParameter("tabs1", tabs1);
%>

<c:choose>
	<c:when test='<%= tabs1.equals("display") %>'>
		<div><liferay-util:include
			page="/html/portlet/nss/attachedfile/display.jsp" /></div>
	</c:when>
	
	<c:when test='<%= tabs1.equals("add_edit") %>'>
		<div><liferay-util:include
			page="/html/portlet/nss/attachedfile/add.jsp" /></div>
	</c:when>
	
</c:choose>

