<%@ include file="/html/portlet/ext/loaivanbannoibo/init.jsp" %>
<%@ include file="/html/portlet/ext/loaivanbannoibo/js/loaivanbannoibo.jsp" %>

<%@page import="java.util.List"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.ext.portal.util.ConstantsExt"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/loaivanbannoibo/view");
	String portletURLString = portletURL.toString();
	
	LoaiVanBanNoiBo loaiVanBanNoiBo = (LoaiVanBanNoiBo) request.getAttribute("loaiVanBanNoiBo");
	String errorEditLoaiVanBanNoiBo = (String) request.getAttribute("errorEditLoaiVanBanNoiBo");
%>

<% if(errorEditLoaiVanBanNoiBo != null){ %>
	<div style="color: red"><liferay-ui:message key="not-edit-loai-van-ban-noi-bo"/></div>	
<%}%>

<portlet:actionURL var="edit_loaivanbannoibo">
	<portlet:param name="struts_action" value="/sgs/loaivanbannoibo/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>

<form action="<%=edit_loaivanbannoibo%>" method="post" name="<portlet:namespace/>fm">
	<input type="hidden" name="<portlet:namespace/>loaiVanBanNoiBoId" value="<%=(loaiVanBanNoiBo != null) ? loaiVanBanNoiBo.getLoaiVanBanNoiBoId() : "" %>">
	<table>
		<tr>
			<td><liferay-ui:message key="ky-hieu-loai-van-ban-noi-bo" /></td>
			<td><input type="text" size="50" name="<portlet:namespace/>kyHieuLoaiVanBanNoiBo" value="<%=(loaiVanBanNoiBo != null) ? loaiVanBanNoiBo.getKyHieuLoaiVanBanNoiBo() : "" %>"></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="ten-loai-van-ban-noi-bo" /></td>
			<td><input type="text" size="50" name="<portlet:namespace/>tenLoaiVanBanNoiBo" value="<%=(loaiVanBanNoiBo != null) ? loaiVanBanNoiBo.getTenLoaiVanBanNoiBo() : "" %>"></td>
		</tr>
	</table>	
<br>
	<input type="submit" value='<liferay-ui:message key="update-loai-van-ban-noi-bo"/>' onclick="return checkInput();">
	<a href="<%=redirect %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</form>