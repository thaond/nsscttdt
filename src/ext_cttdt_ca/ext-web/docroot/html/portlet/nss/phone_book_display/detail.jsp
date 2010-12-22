<%@ include file="/html/portlet/nss/phone_book/init.jsp" %>

<%@page import="com.nss.portlet.phone_book.model.ContactBook"%>
<%@page import="com.nss.portlet.phone_book.service.DetailBookLocalServiceUtil"%>
<%@page import="com.nss.portlet.phone_book.model.DetailBook"%>
<%@page import="com.nss.portlet.phone_book.search.DetailBookDisplayTerms"%>
<%@page import="com.nss.portlet.phone_book.search.DetailBookSearch"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Sort"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="java.io.File"%>

	<%	
	String redirect = renderRequest.getParameter("redirect");
	DetailBook detailBook = (DetailBook)renderRequest.getAttribute("detailBook");
	long contactBookId = detailBook.getContactBookId();
	
	PortletURL backURL = renderResponse.createRenderURL();
	backURL.setWindowState(WindowState.NORMAL);
	backURL.setParameter("struts_action", "/nss/phone_book/view");
	backURL.setParameter("redirect", redirect);
	backURL.setParameter(Constants.CMD,"DETAIL");
	backURL.setParameter("contactBookId", String.valueOf(contactBookId));
	backURL.setParameter("tabs", "detail");
	%> 

<a href="<%= backURL.toString() %>"><span><input class="button-width" type="button" value='<liferay-ui:message key="back"/>' /></span></a>

<br>
	
<table>
	<tr>
		<td><liferay-ui:message key="detail-code" /></td>
		<td><%=detailBook.getDetailBookCode() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-name" /></td>
		<td><%=detailBook.getDetailBookName() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-description" /></td>
		<td><%=detailBook.getDetailDescription() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-zip" /></td>
		<td><%=detailBook.getZip() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-internal" /></td>
		<td><%=detailBook.getInternal() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-home" /></td>
		<td><%=detailBook.getHome() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-mobile" /></td>
		<td><%=detailBook.getMobile() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-email" /></td>
		<td><%=detailBook.getEmail() %></td>
	</tr>
</table>
    	
   