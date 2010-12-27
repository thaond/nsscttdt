<%@ include file="/html/portlet/nss/header/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%
String serverURL = "/web/guest/";
%>

<portlet:renderURL var="clock" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
	<portlet:param name="struts_action" value="/nss/header/clock"/>
</portlet:renderURL>
<script type="text/javascript">
function <portlet:namespace/>reload(){
	jQuery('#<portlet:namespace/>show').load('<%=clock %>');
}

jQuery(document).ready(function(){
	var timeout = setInterval('<portlet:namespace/>reload();', 1000);
});
</script>

<div class="banner"></div>
<div class="menu">
    <ul class="spmenu">
		<li class="dmy">
			<span id="<portlet:namespace/>show"></span> 
   			- <liferay-ui:message key="nss-ngay" /> <%=new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %>
		</li>
		<li class="marqtxt">
			<marquee behavior="scroll" direction="left" onmouseout="this.start();" onmouseover="this.stop();">
				<liferay-ui:message key="nss-van-phong-cong-an-tp-ho-chi-minh" /> -
				<liferay-ui:message key="nss-van-phong-cong-an-tp-ho-chi-minh" /> -
				<liferay-ui:message key="nss-van-phong-cong-an-tp-ho-chi-minh" />
			</marquee>
		</li>
		<li class="search"><liferay-ui:journal-content-search /></li>
    </ul>
</div>

