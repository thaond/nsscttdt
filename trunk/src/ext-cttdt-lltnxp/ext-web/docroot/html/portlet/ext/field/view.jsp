<%@ include file="/html/portlet/ext/field/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>

<%
String tab = ParamUtil.getString(request, "tab");
if(Validator.isNull(tab)) tab = "list";

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tab", tab);
%>


<c:choose>
	<c:when test='<%=tab.equals("list") %>'>
		<liferay-util:include page="/html/portlet/ext/field/list.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("add") %>'>
		<liferay-util:include page="/html/portlet/ext/field/add.jsp" />
	</c:when>
	<c:when test='<%=tab.equals("edit") %>'>
		<liferay-util:include page="/html/portlet/ext/field/edit.jsp" />
	</c:when>
</c:choose>