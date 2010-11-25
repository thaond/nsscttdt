<%@ include file="/html/portlet/nss/link/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%
	String tabs = ParamUtil.getString(renderRequest, "tabs");
	PortletURL portletURLTabs = renderResponse.createRenderURL();
	portletURLTabs.setWindowState(WindowState.NORMAL);
	portletURLTabs.setParameter("struts_action", "/nss/link/view");
	
	if (Validator.isNull(tabs)) {
		tabs = "view_link";
	}
	portletURLTabs.setParameter("tabs", tabs);
%>


<div class="commom-form">
		<div class="parent-title"><liferay-ui:message key="javax.portlet.title.NSS_LINK" /></div>
<liferay-ui:tabs names="view_link,view_loaiWebsite " param="tabs" url="<%= portletURLTabs.toString()%>" value="<%= tabs %>"></liferay-ui:tabs>
<c:choose>
	<c:when test='<%=tabs.equals("view_link")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/link/view_link.jsp" /></div>
	</c:when>

	<c:when test='<%=tabs.equals("view_loaiWebsite")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/link/view_loaiwebsite.jsp" /></div>
	</c:when>
</c:choose>
</div>