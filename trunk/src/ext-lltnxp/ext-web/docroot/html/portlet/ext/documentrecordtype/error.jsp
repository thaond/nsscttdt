<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@ include file="/html/portlet/ext/documentrecordtype/init.jsp" %>
<style type="text/css">
<!--
.color {color: #FF0000;font-weight: bold; }
-->
</style>
<span class="color">
<liferay-ui:message key ="compilation-error-in-operation-!!!" />
</span>
<br>
<%

RenderResponseImpl renderResImpl = (RenderResponseImpl)renderResponse;

String portletTitle = renderResImpl.getTitle();
if (portletTitle == null) {
	portletTitle = LanguageUtil.get(pageContext, "portlet");
}
out.println("Error to event a arise: <strong>"+portletTitle+"</strong>");
%>
<br>
<liferay-ui:message key ="please-contact-with:"/>
<p><strong><liferay-ui:message key="Email"/> </strong></p>
<table width="302" border="0" align="left" height="">
	<tr>
		<td width="29"><li></li></td>
		<td width="257"><liferay-ui:message key ="administrator:" /><a href="admin@liferay.com"><liferay-ui:message key ="sales@liferay.com" /> </a> </td>
	</tr>
	<tr>
		<td><li></li></td>
		<td> <liferay-ui:message key ="sales-development:"/> <a href="sales@liferay.com"><liferay-ui:message key ="staff@liferay.com" /> </a> </td>
	</tr>
</table>