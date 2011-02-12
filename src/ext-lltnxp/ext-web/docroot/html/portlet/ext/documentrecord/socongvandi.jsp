<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documentrecord/view");
	portletURL.setParameter("searchView","false");
	portletURL.setParameter("soCVDiFlag","true");
	
	String tabsSoCongVanDi = ParamUtil.getString(renderRequest, "tabs","socongvandi");
	
	String portletURLString = portletURL.toString();
%>

<%
	tabs = ParamUtil.getString(request, "tabs", "socongvandi");
	String tabCVDi = ParamUtil.getString(request, "tabCVDi", "so");
	
	PortletURL urlCVDi= renderResponse.createRenderURL();
	
	urlCVDi.setWindowState(WindowState.NORMAL);
	urlCVDi.setParameter("struts_action", "/sgs/documentrecord/view");
	urlCVDi.setParameter("tabCVDi",tabCVDi);
	urlCVDi.setParameter("tabs",tabs);
	
	String urlCVDiString = urlCVDi.toString();
%>

<liferay-ui:tabs names="so,phongban" param="tabCVDi" url="<%=urlCVDiString%>" value="<%=tabCVDi %>"></liferay-ui:tabs>
<div class="boxcontent_Tab">
<c:choose>
	<c:when test='<%= tabCVDi.equals("so") %>'>
		<div>
			<%@ include file="/html/portlet/ext/documentrecord/socongvandicuaso.jsp" %>
		</div>
	</c:when>
	<c:when test='<%= tabCVDi.equals("phongban") %>'>
		<div>
			<%@ include file="/html/portlet/ext/documentrecord/socongvandicuapb.jsp" %>
		</div>
	</c:when>
</c:choose>
</div>