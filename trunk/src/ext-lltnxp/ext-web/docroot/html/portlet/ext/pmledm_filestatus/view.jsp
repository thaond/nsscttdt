<%@ include file="/html/portlet/ext/pmledm_filestatus/init.jsp" %>
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
	portleturlFileStatus.setParameter("struts_action", "/sgs/pmledm_filestatus/view");

%>
<div class="title_categ"><liferay-ui:message key="file-status"/></div>
<div class="boxcontent">
<liferay-ui:tabs names="mot-cua,cong-van" param="tabs" url="<%=portleturlFileStatus.toString()%>" value="<%=tabs %>"/>
<c:choose>
	<c:when test='<%= tabs.equals("mot-cua") %>'>
		<div>
			<%@ include file="/html/portlet/ext/pmledm_filestatus/view_onedoor.jsp" %>						
		</div>	
	</c:when>
	<c:when test='<%= tabs.equals("cong-van") %>'>
		<div>
			<%@ include file="/html/portlet/ext/pmledm_filestatus/view_document.jsp" %>
		</div>
	</c:when>
</c:choose>
</div>

