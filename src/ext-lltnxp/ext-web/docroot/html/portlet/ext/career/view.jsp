<%@ include file="/html/portlet/ext/career/init.jsp" %>

<%
String tab = ParamUtil.getString(request, "tab");
if(Validator.isNull(tab)) tab = "display";

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tab", tab);
%>

<c:choose>
	<c:when test='<%=tab.equals("add") %>'>
		<liferay-util:include page="/html/portlet/ext/career/add.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("display") %>'>
		<liferay-util:include page="/html/portlet/ext/career/display.jsp" />
	</c:when>
</c:choose>
