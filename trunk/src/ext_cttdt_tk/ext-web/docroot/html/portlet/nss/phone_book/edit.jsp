<%@page import="com.nss.portlet.phone_book.model.ContactBook"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%
	String redirect = renderRequest.getParameter("redirect");
	ContactBook contactBook = (ContactBook) renderRequest.getAttribute("contactBook");
	boolean check = contactBook.getContactActive();
	String checked = "";
	if(check == true){
		checked = "checked";
	}
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/phone_book/view");
	portletURL.setParameter(Constants.CMD,Constants.UPDATE);
	portletURL.setParameter("redirect", redirect);
%>


<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace />fm">
<input type="hidden" name="<portlet:namespace/>contactBookId" value="<%=contactBook.getContactBookId()%>">
<table>
	<tr>
		<td><liferay-ui:message key="contact-code" /></td>
		<td><input type="text" name="<portlet:namespace/>contactBookCode" value="<%= contactBook.getContactBookCode()%>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="contact-name" /></td>
		<td><input type="text" name="<portlet:namespace/>contactBookName" value="<%= contactBook.getContactBookName()%>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="contact-description" /></td>
		<td><input type="text"
			name="<portlet:namespace/>contactBookDescription" value="<%= contactBook.getContactDescription()%>"></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="contact-active" /></td>
		<td><input type="checkbox"
			name="<portlet:namespace/>contactBookActive" checked="<%=checked %>"></td>
	</tr>
</table>
<input type="submit" value='<liferay-ui:message key="update" />'>
</form>