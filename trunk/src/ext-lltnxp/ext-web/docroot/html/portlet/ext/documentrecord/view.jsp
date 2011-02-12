<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletSession"%>
<%
	String tabs = ParamUtil.getString(request, "tabs", "socongvanden");
	
	PortletURL portleturl= renderResponse.createRenderURL();
	
	portleturl.setWindowState(WindowState.NORMAL);
	portleturl.setParameter("struts_action", "/sgs/documentrecord/view");
	portleturl.setParameter("tabs",tabs);
	
	String portleturlString = portleturl.toString();
%>
	<div class="title_categ"><liferay-ui:message key="document-record"/></div>
	<div class="boxcontent">
	<liferay-ui:tabs names="socongvanden,socongvandi" param="tabs" url="<%=portleturlString%>" value="<%=tabs %>"/>
	<div class="boxcontent_Tab">
	<c:choose>
	<c:when test='<%= tabs.equals("socongvanden") %>'>

		<div>
			<%@ include file="/html/portlet/ext/documentrecord/socongvanden.jsp" %>						
		</div>	
	</c:when>
	
	<c:when test='<%= tabs.equals("socongvandi") %>'>
		<div>
				<%@ include file="/html/portlet/ext/documentrecord/socongvandi.jsp" %>
		</div>
	</c:when>
	</c:choose>
	</div>
</div>

