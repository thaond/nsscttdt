<%@ include file="/html/portlet/ext/holidaymanagement/init.jsp" %>
<%
String tab = ParamUtil.getString(request, "tab", "display");
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tab", tab);
%>
<c:choose>
	<c:when test='<%="display".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/ext/holidaymanagement/display.jsp" />
	</c:when>
	<c:when test='<%="add".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/ext/holidaymanagement/add.jsp" />
	</c:when>
	<c:when test='<%="edit".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/ext/holidaymanagement/edit.jsp" />
	</c:when>
</c:choose>