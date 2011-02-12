<%@ include file="/html/portlet/ext/document_manager/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab");
	String tabAddDocumentManager = (String) request.getAttribute("tabAddDocumentManager");
	if (Validator.isNull(tab)){
		tab = "view_document_manager";
	}
	if(tabAddDocumentManager != null){
		tab = "add_document_manager";
	}
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tab", tab);
%>


<c:choose>
	<c:when test='<%=tab.equals("view_document_manager") %>'>
		<liferay-util:include page="/html/portlet/ext/document_manager/display.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("add_document_manager") %>'>
		<liferay-util:include page="/html/portlet/ext/document_manager/add_document_manager.jsp"></liferay-util:include>
	</c:when>
	<c:when test='<%=tab.equals("edit_document_manager") %>'>
		<liferay-util:include page="/html/portlet/ext/document_manager/edit_document_manager.jsp"></liferay-util:include>
	</c:when>
</c:choose>