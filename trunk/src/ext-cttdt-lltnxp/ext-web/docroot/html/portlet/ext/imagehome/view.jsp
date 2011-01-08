<%@ include file="/html/portlet/ext/imagehome/init.jsp" %>

<% if (imageUpload == 0) { %>
	<liferay-ui:message key="vui-long-chon-cau-hinh" />
	
<%} else { %>
	<a href="<%= urlImageHome %>"> <img src='<%= themeDisplay.getPathImage() %>/imagehome?img_id=<%= String.valueOf(imageUpload) %>' /></a>

<% } %> 