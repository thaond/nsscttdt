<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp" %>


<%
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);
portletURL.setParameter("struts_action", "/nss/image_signer/view");
request.setAttribute("portletURL", portletURL);
%>

<form action="<%=portletURL.toString()%>" method="post"
			name="<portlet:namespace />fm">
<liferay-util:include page="/html/portlet/nss/image_signer/view_user.jsp" />
</form>