<%@ include file="/html/portlet/ext/document_manager_index/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab");
	if (Validator.isNull(tab)){
		tab = "view_document_manager_index";
	}
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tab", tab);
%>


<c:choose>
	<c:when test='<%=tab.equals("view_document_manager_index") %>'>
		<liferay-util:include page="/html/portlet/ext/document_manager_index/display.jsp"></liferay-util:include>
	</c:when>
</c:choose>