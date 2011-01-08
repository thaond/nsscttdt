<%@ include file="/html/portlet/ext/pmledm_filestatus/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%
	String tabDisplayDocument = ParamUtil.getString(renderRequest,"tabDisplayDocument");
	if (Validator.isNull (tabDisplayDocument)) {
		tabDisplayDocument = "display";
	}
%>

<c:choose>
	<c:when test='<%= tabDisplayDocument.equals("display") %>'>
		<div>
			<%@ include file="/html/portlet/ext/pmledm_filestatus/document_process.jsp" %>						
		</div>	
	</c:when>
	<c:when test='<%= tabDisplayDocument.equals("add") %>'>
		<div>
			<%@ include file="/html/portlet/ext/pmledm_filestatus/add_filestatus_document.jsp" %>
		</div>
	</c:when>
	<c:when test='<%= tabDisplayDocument.equals("edit") %>'>
		<div>
			<%@ include file="/html/portlet/ext/pmledm_filestatus/edit_filestatus_document.jsp" %>
		</div>
	</c:when>
</c:choose>

