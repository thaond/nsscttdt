<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/init.jsp" %>
<div class="title_categ"><liferay-ui:message key="tieu-chi-tra-cuu"/></div>
<div class="boxcontent">
<%
	boolean flag = (Boolean) renderRequest.getPortletSession().getAttribute("search",PortletSession.APPLICATION_SCOPE);
	
	String receiptFlag = renderRequest.getAttribute("receiptFlag") == null? "flase" : (String) renderRequest.getAttribute("receiptFlag");  
	String sendFlag = renderRequest.getAttribute("sendFlag") == null? "flase" : (String) renderRequest.getAttribute("sendFlag");
	
	String tabs = ParamUtil.getString(request, "tabs", "cvdi");
	
	if ("flase".equals(receiptFlag)  && "true".equals(sendFlag)) {
		tabs = "cvdi";
	}
	else if ("true".equals(receiptFlag)  && "flase".equals(sendFlag)) {
		tabs = "cvden";
	}
	
	PortletURL URL = renderResponse.createRenderURL();
	URL.setWindowState(WindowState.NORMAL);
	
	URL.setParameter("struts_action", "/sgs/pcccdocumentsendprocess/search");
	URL.setParameter("tabs", tabs);
%>

<%-- 
// phmphuc close 11/02/2011 - hien thi tab Tra cuu van ban di
<liferay-ui:tabs names="cvdi,cvden" param="tabs" url="<%= URL.toString() %>" value="<%=tabs %>"/>
<div class="boxcontent_Tab">
<c:choose>
	<c:when test='<%= tabs.equals("cvdi") %>'>
		<div>
			<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/timcongvandi.jsp" %>						
		</div>	
	</c:when>
	<c:when test='<%= tabs.equals("cvden") %>'>
		<div>
				<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/timcongvanden.jsp" %>
		</div>
	</c:when>
</c:choose>
</div>
// end phmphuc close 11/02/2011
--%>

<%@ include file="/html/portlet/ext/pcccdocumentsendprocess/timcongvandi.jsp" %>

</div>