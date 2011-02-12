<%@ include file="/html/portlet/ext/report_registry_work_index/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab");
	if (Validator.isNull(tab)){
		tab = "view_department";
	}
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%=tab.equals("view_department") %>'>
		<liferay-util:include page="/html/portlet/ext/report_registry_work_index/display.jsp"></liferay-util:include>
	</c:when>
</c:choose>