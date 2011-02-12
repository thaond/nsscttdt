<%@ include file="/html/portlet/ext/nation/init.jsp" %>

<%
String tabs1 = ParamUtil.getString(request, "tabs1");

PortletURL portletURL = renderResponse.createRenderURL();
if (Validator.isNull(tabs1)) {
	tabs1 = "display";
}
portletURL.setParameter("tabs1", tabs1);
%>

<c:choose>
	<c:when test='<%= tabs1.equals("display") %>'>
		<div><liferay-util:include
			page="/html/portlet/ext/nation/display.jsp" /></div>
	</c:when>
	
	<c:when test='<%= tabs1.equals("add") %>'>
		<div><liferay-util:include
			page="/html/portlet/ext/nation/add.jsp" /></div>
	</c:when>
	
</c:choose>