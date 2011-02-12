<%@ include file="/html/portlet/ext/imagehome/init.jsp" %>

<% if (imageUpload == 0) { %>
	<liferay-ui:message key="vui-long-chon-cau-hinh" />
	
<%} else { %>
	<a href="<%= urlImageHome %>" style="background:url('<%= themeDisplay.getPathImage() %>/imagehome?img_id=<%= String.valueOf(imageUpload) %>');display: block;width: 230px;height: 170px; margin: 0 70px 10px 0;"> </a>

<% } %> 