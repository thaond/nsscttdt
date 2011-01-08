<%@ include file="/html/portlet/ext/pmluser/init.jsp" %>

<%
String tab = ParamUtil.getString(request, "tab", "list");

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%=tab.equals("list") %>'>
		<liferay-util:include page="/html/portlet/ext/pmluser/list.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("add") %>'>
		<liferay-util:include page="/html/portlet/ext/pmluser/add.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("edit") %>'>
		<liferay-util:include page="/html/portlet/ext/pmluser/edit.jsp" />
	</c:when>
</c:choose>