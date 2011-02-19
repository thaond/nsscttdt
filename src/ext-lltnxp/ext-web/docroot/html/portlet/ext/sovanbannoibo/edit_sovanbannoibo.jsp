<%@ include file="/html/portlet/ext/sovanbannoibo/init.jsp" %>
<%@ include file="/html/portlet/ext/sovanbannoibo/js/sovanbannoibo.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.ext.portal.util.ConstantsExt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/sovanbannoibo/view");
	String portletURLString = portletURL.toString();
	
	SoVanBanNoiBo soVanBanNoiBo = (SoVanBanNoiBo) request.getAttribute("soVanBanNoiBo");
	String errorEditSoVanBanNoiBo = (String) request.getAttribute("errorEditSoVanBanNoiBo");
%>

<% if(errorEditSoVanBanNoiBo != null){ %>
	<div style="color: red"><liferay-ui:message key="not-edit-so-van-ban-noi-bo"/></div>	
<%}%>

<portlet:actionURL var="edit_sovanbannoibo">
	<portlet:param name="struts_action" value="/sgs/sovanbannoibo/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=edit_sovanbannoibo%>" method="post" name="<portlet:namespace/>fm">
	<input type="hidden" name="<portlet:namespace/>soVanBanNoiBoId" value="<%=(soVanBanNoiBo != null) ? soVanBanNoiBo.getSoVanBanNoiBoId() : "" %>">
	<table>
		<tr>
			<td><liferay-ui:message key="ma-so-van-ban-noi-bo" /></td>
			<td><input type="text" size="50" name="<portlet:namespace/>maSoVanBanNoiBo" value="<%=(soVanBanNoiBo != null) ? soVanBanNoiBo.getMaSoVanBanNoiBo() : "" %>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="ten-so-van-ban-noi-bo" /></td>
			<td><input type="text" size="50" name="<portlet:namespace/>tenSoVanBanNoiBo" value="<%=(soVanBanNoiBo != null) ? soVanBanNoiBo.getTenSoVanBanNoiBo() : "" %>"></td>
		</tr>
	</table>	
<br>
	<input type="submit" value='<liferay-ui:message key="edit-so-van-ban-noi-bo"/>' onclick="return checkInput();">
	<a href="<%=redirect %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>