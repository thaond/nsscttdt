<%@ include file="/html/portlet/nss/geneatedocumentcode/init.jsp" %>


<%
	String tab = ParamUtil.getString(request, "tab", "display");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setParameter("tab", tab);
%>
<c:choose>
	<c:when test='<%=tab.equals("display")%>'>
		<div><liferay-util:include page="/html/portlet/nss/geneatedocumentcode/display.jsp" /></div>
	</c:when>
	<c:when test='<%=tab.equals("add_new")%>'>
		<div><liferay-util:include page="/html/portlet/nss/geneatedocumentcode/add_edit.jsp" /></div>
	</c:when>
</c:choose>

