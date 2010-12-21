<%@ include file="/html/portlet/nss/partner/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
	String tabDisplay = ParamUtil.getString(request, "tabDisplay");
	
	PortletURL portletURLLink = renderResponse.createRenderURL();
	portletURLLink.setWindowState(WindowState.MAXIMIZED);
	portletURLLink.setParameter("struts_action", "/nss/partner/view");
	
	if (Validator.isNull(tabDisplay)) {
		tabDisplay = "display_partner";
	}
	
	portletURLLink.setParameter("tabDisplay", tabDisplay);
%>

<c:choose>
	<c:when test='<%= tabDisplay.equals("display_partner") %>'>
		<div><liferay-util:include page="/html/portlet/nss/partner/display.jsp" /></div>
	</c:when>

	<c:when test='<%= tabDisplay.equals("add_partner") %>'>
		<div><liferay-util:include page="/html/portlet/nss/partner/add.jsp" /></div>
	</c:when>
</c:choose>