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
<!--
function <portlet:namespace/>reload(){
	jQuery('#<portlet:namespace/>show').load('<%=clock %>');
}

jQuery(document).ready(function(){
	var timeout = setInterval('<portlet:namespace/>reload();', 1000);
});
//-->
</script>

<!--

//-->
<div id="header">
<div id="AVIMControl-panel"><script src="/html/js/avim.js"  type="text/javascript"></script></div>
<div id="banner"><img src="/html/images/banner.jpg" /></div>
<div id="menu">
    <div class="dmy">
    	<span id="<portlet:namespace/>show"></span> 
   		- <liferay-ui:message key="nss-ngay" /> <%=new SimpleDateFormat("dd/MM/yyyy").format(new Date()) %></div>
    <div class="topmenu">
    <ul>
    	<li><a href="<%=serverURL %>"><liferay-ui:message key="nss-trang-chu" /></a></li>
    	<li><a href="<%=serverURL + "chinh-quyen" %>"><liferay-ui:message key="nss-chinh-quyen" /></a></li>
    	<li><a href="<%=serverURL + "dien-dan" %>"><liferay-ui:message key="nss-dien-dan" /></a></li>
    	<li><a href="<%=serverURL + "so-do-website" %>"><liferay-ui:message key="nss-so-do-website" /></a></li>
    </ul>
    </div>
    <div class="search">
    	<liferay-ui:journal-content-search />
      	<!-- <form id="form1" name="form1" method="post" action="">
          	<input name="textfield" type="text" class="insearch" value=""/>
          	<a href="#"><img src="/html/images/search.png" width="19" height="21" align="absmiddle" /></a>
      	</form> -->
    </div>
    <div class="flag"><a href="<%=vssLanguageVN %>"><img src="/html/images/lang_vn.jpg" title="<liferay-ui:message key="nss-tieng-viet" />" /></a><a href="<%=vssLanguageEN %>"><img src="/html/images/lang_en.jpg" title="<liferay-ui:message key="nss-tieng-anh" />" /></a></div>
</div>
</div>