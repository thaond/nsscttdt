<%@ include file="/html/portlet/ext/sovanbannoibo/init.jsp" %>
<%@ include file="/html/portlet/ext/sovanbannoibo/js/sovanbannoibo.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.ext.portal.util.ConstantsExt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/sovanbannoibo/view");
	String portletURLString = portletURL.toString();
	
	String maSoVanBanNoiBo = (String) request.getAttribute("maSoVanBanNoiBo");
	String tenSoVanBanNoiBo = (String) request.getAttribute("tenSoVanBanNoiBo");
	String errorAddSoVanBanNoiBo = (String) request.getAttribute("errorAddSoVanBanNoiBo");
%>

<% if(errorAddSoVanBanNoiBo != null){ %>
	<div style="color: red"><liferay-ui:message key="not-add-so-van-ban-noi-bo"/></div>	
<%}%>

<portlet:actionURL var="add_sovanbannoibo">
	<portlet:param name="struts_action" value="/sgs/sovanbannoibo/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=add_sovanbannoibo%>" method="post" name="<portlet:namespace/>fm">
	<table>
		<tr>
			<td><liferay-ui:message key="ma-so-van-ban-noi-bo" /></td>
			<td><input type="text" size="50" name="<portlet:namespace/>maSoVanBanNoiBo" value="<%=(maSoVanBanNoiBo != null) ? maSoVanBanNoiBo : "" %>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="ten-so-van-ban-noi-bo" /></td>
			<td><input type="text" size="50" name="<portlet:namespace/>tenSoVanBanNoiBo" value="<%=(tenSoVanBanNoiBo != null) ? tenSoVanBanNoiBo : "" %>"></td>
		</tr>
	</table>	
<br>
	<input type="submit" value='<liferay-ui:message key="add-so-van-ban-noi-bo"/>' onclick="return checkInput();">
	<a href="<%=redirect %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>