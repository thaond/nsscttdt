<%@ include file="/html/portlet/ext/documentrecord/init.jsp" %>

<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/documentrecord/view");
	
	tabs = ParamUtil.getString(renderRequest, "tabs","socongvanden");
	
	String portletURLString = portletURL.toString();
%>

<%
	String tabCVDens = ParamUtil.getString(request, "tabCVDens", "so");
	
	PortletURL urlCVDen= renderResponse.createRenderURL();
	
	urlCVDen.setWindowState(WindowState.NORMAL);
	urlCVDen.setParameter("struts_action", "/sgs/documentrecord/view");
	urlCVDen.setParameter("tabCVDens",tabCVDens);
	
	String urlCVDenString = urlCVDen.toString();
%>

<liferay-ui:tabs names="so,phongban" param="tabCVDens" url="<%=urlCVDenString%>" value="<%=tabCVDens %>"></liferay-ui:tabs>
<div class="boxcontent_Tab">
<c:choose>
	<c:when test='<%= tabCVDens.equals("so") %>'>
		<div>
			<%@ include file="/html/portlet/ext/documentrecord/socongvandencuaso.jsp" %>
		</div>
	</c:when>
	<c:when test='<%= tabCVDens.equals("phongban") %>'>
		<div>
			<%@ include file="/html/portlet/ext/documentrecord/socongvandencuapb.jsp" %>
		</div>
	</c:when>
</c:choose>
</div>

