<%@ include file="/html/portlet/nss/delegate/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab", "display");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%=tab.equals("display")%>'>
		<div><liferay-util:include page="/html/portlet/nss/delegate/display.jsp" /></div>
	</c:when>

	<c:when test='<%=tab.equals("add")%>'>
		<div><liferay-util:include page="/html/portlet/nss/delegate/add.jsp" /></div>
	</c:when>
</c:choose>
