<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%
	String redirect = renderRequest.getParameter("redirect");

	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/phone_book/view");
	portletURL.setParameter("cmd", "add");
	portletURL.setParameter("redirect", redirect);
%>


<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace />fm">
<table>
	<tr>
		<td><liferay-ui:message key="contact-code" /></td>
		<td><input type="text" name="<portlet:namespace/>contactBookCode"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="contact-name" /></td>
		<td><input type="text" name="<portlet:namespace/>contactBookName"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="contact-description" /></td>
		<td><input type="text"
			name="<portlet:namespace/>contactBookDescription"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="contact-active" /></td>
		<td><input type="checkbox"
			name="<portlet:namespace/>contactBookActive"></td>
	</tr>
</table>
<input type="submit" value="Add">
</form>