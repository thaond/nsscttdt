<%@ include file="/html/portlet/ext/onedoorreturn/init.jsp" %>
	  
<%
	String redirect = ParamUtil.getString(renderRequest, "redirect");
%>	  

<portlet:renderURL var="refresh">
	<portlet:param name="struts_action" value="/sgs/onedoorreturn/view"/>
	<portlet:param name="redirect"	value="<%= redirect %>" />
</portlet:renderURL>

<portlet:renderURL var="back">
	<portlet:param name="redirect"	value="<%= redirect %>" />
</portlet:renderURL>

<script type="text/javascript">
function agreeSubmit() {
	var url = document.getElementById('formSumit').action;
	
	if (url.substring(url.length-1,url.length) != "#") {
		document.getElementById('formSumit').action = url;
		return true;
	} else {		
		return false;
	}		
}
</script>


			<form id="formSumit" action="#" method="post"  onsubmit="return agreeSubmit();">
				<%
					String default_landing_page_path = PropsUtil.get("default.landing.page.path");
				%>
				<a href="#" id="home" 
					onclick='document.getElementById("home").href = "http://" + location.host + "<%= default_landing_page_path %>" + "/trangchu";'>
						<img src="/html/images/nav_home_ico_01.png" title="<liferay-ui:message key="home" />"/>&nbsp;
				</a>		
				<img src="/html/images/nav_back_ico_02.png" onclick="javascript:submitForm(document.hrefFm,'<%= back %>');" title="<liferay-ui:message key="back"/>"/>&nbsp;
				<a href="<%= refresh %>"><img src="/html/images/nav_refresh_ico_01.png" title="<liferay-ui:message key="refresh"/>"/></a>&nbsp;
			</form>

