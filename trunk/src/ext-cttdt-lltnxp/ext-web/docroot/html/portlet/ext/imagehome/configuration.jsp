<%@ include file="/html/portlet/ext/imagehome/init.jsp" %>

<form enctype="multipart/form-data" action="<liferay-portlet:actionURL portletConfiguration="true" />" method="post" name="<portlet:namespace />fm">
	
	<input  type="hidden" name="<portlet:namespace />imageUpload"  value="<%= String.valueOf(imageUpload) %>"/>	
	<br/>
	
	<liferay-ui:message key="url-image-home" />: <input  type="text" name="<portlet:namespace />urlImageHome"  value="<%= HtmlUtil.escape(urlImageHome) %>"/>	
	<br/>
	
	<liferay-ui:message key="description-image-home" />: <textarea rows="2"  name="<portlet:namespace />descriptionImageHome"><%= HtmlUtil.escape(descriptionImageHome)%></textarea>
	<br/>
	
	<liferay-ui:message key="file-upload" /> : <input type="file" name="<portlet:namespace />fileImageHome" />	
	<br/>	
	<input type="submit" value='<liferay-ui:message key="save" />' />
</form>