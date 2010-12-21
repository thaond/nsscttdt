<%@ include file="/html/portlet/nss/header/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%
String serverURL = "/web/guest/";
String vssLanguageVN = "?p_p_id=82&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_pos=2&_82_struts_action=%2Flanguage%2Fview&languageId=vi_VN";
String vssLanguageEN = "?p_p_id=82&p_p_lifecycle=1&p_p_state=normal&p_p_mode=view&p_p_col_id=column-1&p_p_col_pos=2&_82_struts_action=%2Flanguage%2Fview&languageId=en_US";
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
		<li class="marqtxt"><liferay-ui:message key="Doan text chay tin tieu de tin moi + tin noi bat trong ngay..." /></li>
		<li class="search"><liferay-ui:journal-content-search /></li>
    </ul>
</div>

