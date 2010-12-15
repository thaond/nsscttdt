<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%
	String redirect = renderRequest.getParameter("redirect");
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/phone_book/view_detail");
	portletURL.setParameter(Constants.CMD,Constants.ADD);
	portletURL.setParameter("redirect", redirect);
%>


<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace />fm">
		<table>
			<tr>
				<td><liferay-ui:message key="detail-code" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookCode"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-name" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookName"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-description" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookDescription"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-zip" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookZip"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-internal" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookInternal"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-home" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookHome"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-mobile" /></td>
				<td><input type="text" name="<portlet:namespace/>detailBookMobile"></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="detail-active" /></td>
				<td><input type="checkbox" name="<portlet:namespace/>detailBookActive"></td>
			</tr>
		</table>
	<input type="submit" value='<liferay-ui:message key="add" />'>
</form>