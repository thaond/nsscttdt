<%@ include file="/html/portlet/ext/districtmanagement/init.jsp" %>

<%
String tab = ParamUtil.getString(request, "tab");
if(Validator.isNull(tab)) tab = "list";

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%=tab.equals("list") %>'>
		<liferay-util:include page="/html/portlet/ext/districtmanagement/list.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("add") %>'>
		<liferay-util:include page="/html/portlet/ext/districtmanagement/add.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("edit") %>'>
		<liferay-util:include page="/html/portlet/ext/districtmanagement/edit.jsp" />
	</c:when>
</c:choose>