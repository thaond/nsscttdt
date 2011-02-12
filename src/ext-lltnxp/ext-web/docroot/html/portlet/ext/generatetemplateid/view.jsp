<%@ include file="/html/portlet/ext/generatetemplateid/init.jsp" %>

<%
	String tab = ParamUtil.getString(request, "tab", "display");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tab", tab);
%>
<c:choose>
	<c:when test='<%=tab.equals("display")%>'>
		<div><liferay-util:include page="/html/portlet/ext/generatetemplateid/display.jsp" /></div>
	</c:when>
	<c:when test='<%=tab.equals("add_edit")%>'>
		<div><liferay-util:include page="/html/portlet/ext/generatetemplateid/add_edit_idtemplate.jsp" /></div>
	</c:when>
</c:choose>