<%@ include file="/html/portlet/ext/signer/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletSession"%>
<div class="title_categ"><liferay-ui:message key="quan-tri-he-thong-nguoi-ky-van-ban"/></div>
<div class="boxcontent">
<%
	boolean flag = (Boolean)renderRequest.getPortletSession().getAttribute("search",PortletSession.APPLICATION_SCOPE);
	String afterCheckFlag = renderRequest.getAttribute("afterCheckFlag")== null? "false" : (String)renderRequest.getAttribute("afterCheckFlag");
	String beforeCheckFlag = renderRequest.getAttribute("beforeCheckFlag")== null? "false" :(String) renderRequest.getAttribute("beforeCheckFlag");
	String tabs = ParamUtil.getString(request, "tabs", "da-chon");
	if(("false".equals(beforeCheckFlag))&& ("true".equals(afterCheckFlag))){
		tabs = "da-chon";
	}else if(("true".equals(beforeCheckFlag))&& ("false".equals(afterCheckFlag))){
		tabs = "chua-chon";
	}
	PortletURL portleturl= renderResponse.createRenderURL();
	portleturl.setWindowState(WindowState.NORMAL);
	portleturl.setParameter("struts_action", "/sgs/signer/view");
	portleturl.setParameter("tabs",tabs);
	String portleturlString = portleturl.toString();

%>
<liferay-ui:tabs names="da-chon,chua-chon" param="tabs" url="<%=portleturlString%>" value="<%=tabs %>"/>
<div class="boxcontent_Tab">
<c:choose>
	<c:when test='<%= tabs.equals("chua-chon") %>'>
		<div>
			<%@ include file="/html/portlet/ext/signer/listBeforeCheck_search.jsp" %>						
		</div>	
	</c:when>
	
	<c:when test='<%= tabs.equals("da-chon") %>'>
		<div>
				<%@ include file="/html/portlet/ext/signer/listAfterCheck_search.jsp" %>
		</div>
	</c:when>
</c:choose>
</div>
</div>

