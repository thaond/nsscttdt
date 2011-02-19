<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@ include file="/html/portlet/ext/vanbannoibo/init.jsp" %>

<liferay-portlet:actionURL var="form" portletConfiguration="true"></liferay-portlet:actionURL>

<form action="<%=form %>" method="post">
	<input type="radio" name="<portlet:namespace/>actionVanBanNoiBo" value="tiepNhan" <%= (actionVanBanNoiBo.equals("tiepNhan")) ? "checked" : "" %>><liferay-ui:message key="tiep-nhan-van-ban-noi-bo" /><br>
	<input type="radio" name="<portlet:namespace/>actionVanBanNoiBo" value="xuLy" <%= (actionVanBanNoiBo.equals("xuLy")) ? "checked" : "" %>><liferay-ui:message key="xu-ly-van-ban-noi-bo" /><br>
	<input type="radio" name="<portlet:namespace/>actionVanBanNoiBo" value="traCuu" <%= (actionVanBanNoiBo.equals("traCuu")) ? "checked" : "" %>><liferay-ui:message key="tra-cuu-van-ban-noi-bo" /><br>
	<input type="radio" name="<portlet:namespace/>actionVanBanNoiBo" value="baoCao" <%= (actionVanBanNoiBo.equals("baoCao")) ? "checked" : "" %>><liferay-ui:message key="bao-cao-van-ban-noi-bo" /><br>
	<liferay-ui:message key="ky-hieu-van-ban" /><input type="text" name="<portlet:namespace/>kyHieuVaoSo" value="<%=kyHieuVaoSo %>">
	<input type="submit" value="save">
</form>
