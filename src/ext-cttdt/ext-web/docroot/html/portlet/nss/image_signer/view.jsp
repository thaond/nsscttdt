<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp" %>


<%
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);
portletURL.setParameter("struts_action", "/nss/image_signer/view");
request.setAttribute("portletURL", portletURL);
String varRender = ParamUtil.getString(request,"varRender");
String userId = ParamUtil.getString(request,"userId");
request.setAttribute("userId",userId);
%>

<% if(varRender.equals("upload")){ %>
<liferay-util:include
			page="/html/portlet/nss/image_signer/upload_image_signer.jsp"></liferay-util:include>
<%}else{ %>

<form action="<%=portletURL.toString()%>" method="post"
			name="<portlet:namespace />fm">
<liferay-util:include page="/html/portlet/nss/image_signer/view_user.jsp" />
</form>
<%} %>
