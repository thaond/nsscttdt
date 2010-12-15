<%@ include file="/html/portlet/nss/phone_book/init.jsp"%>

<%@page import="com.nss.portlet.phone_book.model.DetailBook"%>
<%@page import="com.nss.portlet.phone_book.model.ContactBook"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>

<%
	String redirect = renderRequest.getParameter("redirect");
	DetailBook detailBook = (DetailBook) renderRequest.getAttribute("detailBook");
	boolean check = detailBook.getDetailActive();
	String checked = "";
	if(check == true){
		checked = "checked";
	}
	
	PortletURL portletURL = renderResponse.createActionURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/nss/phone_book/view_detail");
	portletURL.setParameter(Constants.CMD,Constants.UPDATE);
	portletURL.setParameter("redirect", redirect);
%>


<form action="<%=portletURL.toString()%>" method="post" name="<portlet:namespace />fm">
	<table>
		<tr>
			<td><liferay-ui:message key="detail-code" /></td>
			<td><input type="text" name="<portlet:namespace/>detailBookCode" value="<%= detailBook.getDetailBookCode()%>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="detail-name" /></td>
			<td><input type="text" name="<portlet:namespace/>detailBookName" value="<%= detailBook.getDetailBookName()%>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="detail-description" /></td>
			<td><input type="text"
				name="<portlet:namespace/>detailBookDescription" value="<%= detailBook.getDetailDescription()%>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="detail-zip" /></td>
			<td><input type="text"
				name="<portlet:namespace/>detailBookZip" value="<%= detailBook.getZip()%>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="detail-internal" /></td>
			<td><input type="text"
				name="<portlet:namespace/>detailBookInternal" value="<%= detailBook.getInternal()%>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="detail-home" /></td>
			<td><input type="text"
				name="<portlet:namespace/>detailBookHome" value="<%= detailBook.getHome()%>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="detail-mobile" /></td>
			<td><input type="text"
				name="<portlet:namespace/>detailBookMobile" value="<%= detailBook.getMobile()%>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="detail-active" /></td>
			<td><input type="checkbox"
				name="<portlet:namespace/>detailBookActive" checked="<%=checked %>"></td>
		</tr>
	</table>
	<input type="submit" value='<liferay-ui:message key="edit" />'>
</form>