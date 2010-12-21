<%@ include file="/html/portlet/nss/filetype/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab");
	if(Validator.isNull(tab)) {
		tab = "list";
	}
	
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%="list".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/filetype/list.jsp" />
	</c:when>
	<c:when test='<%="add".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/filetype/add.jsp" />
	</c:when>
	<c:when test='<%="edit".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/filetype/edit.jsp" />
	</c:when>
	<c:when test='<%="attach_file".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/filetype/attach_file.jsp" />
	</c:when>
	<c:when test='<%="edit_attachfile".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/filetype/attach_file_edit.jsp" />
	</c:when>
	<c:when test='<%="add_attachfile".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/filetype/attach_file_add.jsp" />
	</c:when>
</c:choose>
