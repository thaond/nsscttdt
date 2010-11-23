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
		<div><liferay-util:include
			page="/html/portlet/nss/qa_cau_hoi/display.jsp" /></div>
	</c:when>

	<c:when test='<%=tabs.equals("add")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/qa_cau_hoi/add.jsp" /></div>
	</c:when>
	
	<c:when test='<%=tabs.equals("detail")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/qa_cau_hoi/detail.jsp" /></div>
	</c:when>
	
</c:choose>
