<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp"%>

<% 
	String userId = ParamUtil.getString(request,"userId");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/image_signer/view");
	portletURL.setParameter("userId", userId);
%>

<form action="<%=portletURL.toString() %>" enctype="multipart/form-data" method="post">
<table cellspacing="0" width="100%">
<tr>
	<td width="30%"><liferay-ui:message key="image-Sign" />: </td>
	<td><input type="file" name="<portlet:namespace/>imageSign"></td>
</tr>
<tr>
	<td><liferay-ui:message key="image-UnSign" />:</td>
	<td> <input type="file" name="<portlet:namespace/>imageUnSign"></td>
</tr>
<tr>
	<td></td>
	<td><input type="submit"  value='<liferay-ui:message key="upload" />'></td>
	</tr>
</table>
</form>



