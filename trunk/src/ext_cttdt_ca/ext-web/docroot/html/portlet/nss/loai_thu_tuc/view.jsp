<%@ include file="/html/portlet/nss/loai_thu_tuc/init.jsp" %>

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
			page="/html/portlet/nss/loai_thu_tuc/display.jsp" /></div>
	</c:when>

	<c:when test='<%=tabs.equals("add")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/loai_thu_tuc/add.jsp" /></div>
	</c:when>
	
	<c:when test='<%=tabs.equals("edit")%>'>
		<div><liferay-util:include
			page="/html/portlet/nss/loai_thu_tuc/edit.jsp" /></div>
	</c:when>
</c:choose>


