<%@ include file="/html/portlet/ext/pmllevelsend/init.jsp" %>

<%
String _page = ParamUtil.getString(request, "page");
if(Validator.isNull(_page)) _page = "list";

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("page", _page);
%>

<c:choose>
	<c:when test='<%=_page.equals("list") %>'>
		<liferay-util:include page="/html/portlet/ext/pmllevelsend/list.jsp" />
	</c:when>
	<c:when test='<%=_page.equals("add") %>'>
		<liferay-util:include page="/html/portlet/ext/pmllevelsend/add.jsp" />
	</c:when>
	<c:when test='<%=_page.equals("edit") %>'>
		<liferay-util:include page="/html/portlet/ext/pmllevelsend/edit.jsp" />
	</c:when>
</c:choose>