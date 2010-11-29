<%@ include file="/html/portlet/nss/qa_cau_hoi/init.jsp" %>

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
		<liferay-util:include
			page="/html/portlet/nss/qa_cau_hoi/display.jsp" />
	</c:when>

	<c:when test='<%=tabs.equals("add")%>'>
		<liferay-util:include
			page="/html/portlet/nss/qa_cau_hoi/add.jsp" />
	</c:when>
	
	<c:when test='<%=tabs.equals("detail")%>'>
		<liferay-util:include
			page="/html/portlet/nss/qa_cau_hoi/detail.jsp" />
	</c:when>
	
</c:choose>
