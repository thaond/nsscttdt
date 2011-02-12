<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.Date"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/html/portlet/ext/message_note/init.jsp" %>

<div id="<portlet:namespace/>showmessage-contain"></div>

<%
	long userId = 0;
	try {
		userId = PortalUtil.getUserId(renderRequest);
	} catch (Exception e) {}
	
	String url = "/html/portlet/ext/message_note/show.jsp?userId=" + String.valueOf(userId);
%>

<script>
	var interval<portlet:namespace/>;
	
	function refreshMe<portlet:namespace/>() {
    	var plid = themeDisplay.getPlid();
    	var portletId = "#<portlet:namespace/>showmessage-contain";
    	url = "<%= url%>";
		jQuery(portletId).load(url+  "&Rand="+ new Date().getTime() + " #showmessage");
	}
     
	jQuery(document).ready(
		function() { 
			refreshMe<portlet:namespace/>();     
			if (interval<portlet:namespace/> == null) {      
				interval<portlet:namespace/> = setInterval('refreshMe<portlet:namespace/>();', 10000);
			}
		}
	);
</script>

