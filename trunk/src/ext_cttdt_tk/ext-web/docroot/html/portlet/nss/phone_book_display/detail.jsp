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
		DetailBook detailBook = (DetailBook)renderRequest.getAttribute("detailBook");
	%> 
	
<table>
	<tr>
		<td><liferay-ui:message key="detail-book-code" /></td>
		<td><%=detailBook.getDetailBookCode() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-book-name" /></td>
		<td><%=detailBook.getDetailBookName() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-book-description" /></td>
		<td><%=detailBook.getDetailDescription() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-book-zip" /></td>
		<td><%=detailBook.getZip() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-book-internal" /></td>
		<td><%=detailBook.getInternal() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-book-home" /></td>
		<td><%=detailBook.getHome() %></td>
	</tr>
	<tr>
		<td><liferay-ui:message key="detail-book-mobile" /></td>
		<td><%=detailBook.getMobile() %></td>
	</tr>
</table>
    	
   