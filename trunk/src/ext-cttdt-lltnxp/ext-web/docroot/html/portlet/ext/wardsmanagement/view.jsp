<%@ include file="/html/portlet/ext/wardsmanagement/init.jsp" %>

<%
String tab = ParamUtil.getString(request, "tab");
if(Validator.isNull(tab)) tab = "list";

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%=tab.equals("list") %>'>
		<liferay-util:include page="/html/portlet/ext/wardsmanagement/list.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("add") %>'>
		<liferay-util:include page="/html/portlet/ext/wardsmanagement/add.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("edit") %>'>
		<liferay-util:include page="/html/portlet/ext/wardsmanagement/edit.jsp" />
	</c:when>
</c:choose>