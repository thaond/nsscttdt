<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp"%>

<% 
	String userId = ParamUtil.getString(request,"userId");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/image_signer/upload");
	portletURL.setParameter("userId", userId);
%>

<form action="<%=portletURL.toString() %>" enctype="multipart/form-data" method="post">
	<liferay-ui:message key="image-Sign" /> <input type="file" name="<portlet:namespace/>imageSign"><br>
	<liferay-ui:message key="image-UnSign" /> <input type="file" name="<portlet:namespace/>imageUnSign"><br>
	<input type="submit"  value='<liferay-ui:message key="upload" />'>
</form>



