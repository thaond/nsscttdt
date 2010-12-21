<%@ include file="/html/portlet/nss/managementworkflowonedoor/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="javax.portlet.PortletURL"%>

<%
String deployFlag = (String) renderRequest.getAttribute("deployFlag");
%>

<script type="text/javascript">
window.onload = function () {
	var flag = <%= deployFlag %>;

	if (flag == true) {
		alert ("<liferay-ui:message key='deploy-workflow-success'/>")
	}

	else if (flag == false) {
		alert ("<liferay-ui:message key='deploy-workflow-fail' />");
	}
}
</script>

<%
String tab = ParamUtil.getString(request, "tab");
if(Validator.isNull(tab)) tab = "list";

PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setParameter("tab", tab);
%>


<c:choose>
	<c:when test='<%="list".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/managementworkflowonedoor/list.jsp" />
	</c:when>
	<c:when test='<%="add".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/managementworkflowonedoor/add.jsp" />
	</c:when>
	<c:when test='<%="edit".equals(tab) %>'>
		<liferay-util:include page="/html/portlet/nss/managementworkflowonedoor/edit.jsp" />
	</c:when>
</c:choose>