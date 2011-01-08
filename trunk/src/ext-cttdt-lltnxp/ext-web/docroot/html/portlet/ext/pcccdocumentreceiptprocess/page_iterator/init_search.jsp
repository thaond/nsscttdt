
<%@page import="com.liferay.portal.kernel.util.Validator"%><%@page import="com.liferay.portal.kernel.util.JavaConstants"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="javax.portlet.PortletResponse"%>
<%@page import="javax.portlet.PortletRequest"%>

<%@ include file="/html/common/init.jsp" %>

<%
PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);

String namespace = StringPool.BLANK;

if (portletResponse != null) {
	namespace = portletResponse.getNamespace();
}

String currentURL = PortalUtil.getCurrentURL(request);
%>

<%!
private String _getHREF(String formName, String curParam, int curValue, String jsCall, String url, String urlAnchor) throws Exception {
	String href = null;

	if (Validator.isNotNull(url)) {
		href = url + curParam + "=" + curValue + urlAnchor;
	}
	else {
		href = "javascript: document." + formName + "." + curParam + ".value = '" + curValue + "'; " + jsCall;
		
	}

	return href;
}
%>