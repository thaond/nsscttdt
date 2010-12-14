<%@ include file="/html/portlet/nss/filestatus/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>


<%
	String tabs = (String) renderRequest.getAttribute("tabs");
	if (Validator.isNull (tabs)) {
		tabs = "mot-cua";
	}

	PortletURL portleturlFileStatus= renderResponse.createRenderURL();
	
	portleturlFileStatus.setWindowState(WindowState.NORMAL);
	portleturlFileStatus.setParameter("struts_action", "/nss/filestatus/view");

%>
<div class="title_categ"><liferay-ui:message key="file-status"/></div>
<div class="boxcontent">
	
	<c:choose>
		<c:when test='<%= tabs.equals("mot-cua") %>'>
			<div>
				<%@ include file="/html/portlet/nss/filestatus/view_onedoor.jsp" %>						
			</div>	
		</c:when>
	</c:choose>
</div>

