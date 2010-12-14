<%@ include file="/html/portlet/nss/filestatus/init.jsp" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%
	String tabDisplayOnedoor = ParamUtil.getString(renderRequest,"tabDisplayOnedoor");
	if (Validator.isNull (tabDisplayOnedoor)) {
		tabDisplayOnedoor = "display";
	}
%>

<c:choose>
	<c:when test='<%= tabDisplayOnedoor.equals("display") %>'>
		<div>
			<%@ include file="/html/portlet/nss/filestatus/onedoor_process.jsp" %>						
		</div>	
	</c:when>
	<c:when test='<%= tabDisplayOnedoor.equals("add") %>'>
		<div>
			<%@ include file="/html/portlet/nss/filestatus/add_filestatus_onedoor.jsp" %>
		</div>
	</c:when>
	<c:when test='<%= tabDisplayOnedoor.equals("edit") %>'>
		<div>
			<%@ include file="/html/portlet/nss/filestatus/edit_filestatus_onedoor.jsp" %>
		</div>
	</c:when>
</c:choose>

