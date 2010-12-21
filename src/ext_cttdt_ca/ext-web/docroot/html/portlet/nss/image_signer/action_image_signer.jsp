<%@page import="com.liferay.portal.model.User"%>
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
		<portlet:param name="struts_action" value="/nss/image_signer/upload" />
		<portlet:param name="userId" value="<%=String.valueOf(user_image.getUserId()) %>"/>
	</portlet:renderURL>
	
	<form action="<%=uploadImagePopUp %>">
		<input type="button" value="<liferay-ui:message key="upload-image"/>" onclick="uploadImagePopUp('<%=uploadImagePopUp%>');return false;">
	</form>
</liferay-ui:icon-menu>

<script type="text/javascript">
	function uploadImagePopUp(url) {
		var popup = new Liferay.Popup({
			title : '<liferay-ui:message key="upload-image-signer"/>',
			position : [ 'center', 100 ],
			modal : true,
			width : 450,
			height : 'auto',
			xy : [ 'center', 100 ],
			url : url,
			scroll : 'auto'
		});

	}
</script>