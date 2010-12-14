<%@ include file="/html/portlet/nss/link/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%
	String tabs = ParamUtil.getString(renderRequest,"tabs","view_link");
	String tabDisplay = ParamUtil.getString(request, "tabDisplay");
	
	PortletURL portletURLLink = renderResponse.createRenderURL();
	portletURLLink.setWindowState(WindowState.NORMAL);
	portletURLLink.setParameter("struts_action", "/nss/link/view");
	
	if (Validator.isNull(tabDisplay)) {
		tabDisplay = "display_link";
	}
	
	portletURLLink.setParameter("tabDisplay", tabDisplay);
	portletURLLink.setParameter("tabs", tabs);
%>

<c:choose>
	<c:when test='<%=tabDisplay.equals("display_link")%>'>
		<liferay-util:include page="/html/portlet/nss/link/display.jsp" />
	</c:when>

	<c:when test='<%=tabDisplay.equals("add_link")%>'>
		<liferay-util:include page="/html/portlet/nss/link/add_edit.jsp" />
	</c:when>
</c:choose>

