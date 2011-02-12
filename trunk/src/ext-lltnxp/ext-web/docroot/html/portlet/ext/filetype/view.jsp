<%@ include file="/html/portlet/ext/filetype/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>

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
		<liferay-util:include page="/html/portlet/ext/filetype/list.jsp" />
	</c:when>
	<c:when test='<%="add".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/ext/filetype/add.jsp" />
	</c:when>
	<c:when test='<%="edit".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/ext/filetype/edit.jsp" />
	</c:when>
	<c:when test='<%="attach_file".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/ext/filetype/attach_file.jsp" />
	</c:when>
	<c:when test='<%="edit_attachfile".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/ext/filetype/attach_file_edit.jsp" />
	</c:when>
	<c:when test='<%="add_attachfile".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/ext/filetype/attach_file_add.jsp" />
	</c:when>
</c:choose>