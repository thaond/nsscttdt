<%@ include file="/html/portlet/ext/loaivanbannoibo/init.jsp" %>
<%@ include file="/html/portlet/ext/loaivanbannoibo/js/loaivanbannoibo.jsp" %>


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
	portletURL.setParameter("struts_action", "/sgs/loaivanbannoibo/view");
	String portletURLString = portletURL.toString();
	
	String kyHieuLoaiVanBanNoiBo = (String) request.getAttribute("kyHieuLoaiVanBanNoiBo");
	String tenLoaiVanBanNoiBo = (String) request.getAttribute("tenLoaiVanBanNoiBo");
	String errorAddLoaiVanBanNoiBo = (String) request.getAttribute("errorAddLoaiVanBanNoiBo");
%>

<% if(errorAddLoaiVanBanNoiBo != null){ %>
	<div style="color: red"><liferay-ui:message key="not-add-loai-van-ban-noi-bo"/></div>	
<%}%>

<portlet:actionURL var="add_loaivanbannoibo">
	<portlet:param name="struts_action" value="/sgs/loaivanbannoibo/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.ADD %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=add_loaivanbannoibo%>" method="post" name="<portlet:namespace/>fm">
	<table>
		<tr>
			<td><liferay-ui:message key="ky-hieu-loai-van-ban-noi-bo" /></td>
			<td><input type="text" size="50" name="<portlet:namespace/>kyHieuLoaiVanBanNoiBo" value="<%= (kyHieuLoaiVanBanNoiBo != null) ? kyHieuLoaiVanBanNoiBo : "" %>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="ten-loai-van-ban-noi-bo" /></td>
			<td><input type="text" size="50" name="<portlet:namespace/>tenLoaiVanBanNoiBo" value="<%= (tenLoaiVanBanNoiBo != null) ? tenLoaiVanBanNoiBo : "" %>"></td>
		</tr>
	</table>	
<br>
	<input type="submit" value='<liferay-ui:message key="add-loai-van-ban-noi-bo"/>' onclick="return checkInput();">
	<a href="<%=redirect %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>