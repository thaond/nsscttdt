<%@page import="com.liferay.portal.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.util.WebKeys"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/html/portlet/nss/image_signer/init.jsp"%>

<%
	ResultRow row = (ResultRow) request
			.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	User user_image = (User) row.getObject();
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="uploadImagePopUp"
		windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>">
		<portlet:param name="struts_action" value="/nss/image_signer/view" />
		<portlet:param name="varRender" value="upload" />
		<portlet:param name="userId" value="<%=String.valueOf(user_image.getUserId()) %>"/>
	</portlet:renderURL>
	<form action="<%=uploadImagePopUp %>"><input type="button" value="<liferay-ui:message key="upload-image"/>"
		onclick="uploadImagePopUp('<%=uploadImagePopUp%>');return false;">
	</form>
</liferay-ui:icon-menu>

<script type="text/javascript">
	function uploadImagePopUp(url) {
		var popup = new Liferay.Popup({
			title : '<liferay-ui:message key="upload-image-signer"/>',
			position : [ 'center', 100 ],
			modal : true,
			width : 350,
			height : 'auto',
			xy : [ 'center', 100 ],
			url : url,
			scroll : 'auto'
		});

	}
</script>