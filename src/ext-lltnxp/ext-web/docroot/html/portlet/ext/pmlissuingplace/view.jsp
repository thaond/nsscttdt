<%@ include file="/html/portlet/ext/pmlissuingplace/init.jsp" %>

<%
String _page = ParamUtil.getString(request, "page");
if(Validator.isNull(_page)) _page = "list";

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("page", _page);
%>

<c:choose>
	<c:when test='<%=_page.equals("list") %>'>
		<liferay-util:include page="/html/portlet/ext/pmlissuingplace/list.jsp" />
	</c:when>
	<c:when test='<%=_page.equals("add") %>'>
		<liferay-util:include page="/html/portlet/ext/pmlissuingplace/add.jsp" />
	</c:when>
	<c:when test='<%=_page.equals("edit") %>'>
		<liferay-util:include page="/html/portlet/ext/pmlissuingplace/edit.jsp" />
	</c:when>
</c:choose>