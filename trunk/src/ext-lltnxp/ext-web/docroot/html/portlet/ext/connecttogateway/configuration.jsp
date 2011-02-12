<%@ include file="/html/portlet/ext/connecttogateway/init.jsp" %>

<%@ include file="/html/portlet/ext/connecttogateway/js/connectgatewayutil.jsp" %>

<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<script type="text/javascript">
	window.onload = function () 
	{

		if (document.getElementById('<portlet:namespace/>edmsGatewayFromDate') != null) {
			callCalendar('<portlet:namespace/>edmsGatewayFromDate','cal-button-tuNgay');
		}
		
		if (document.getElementById('<portlet:namespace/>edmsGatewayToDate') != null) {
			callCalendar('<portlet:namespace/>edmsGatewayToDate','cal-button-denNgay');
		}
	}
</script>	

<div class="separator"><!-- --></div>
<%
	PortletPreferences prefs = renderRequest.getPreferences();
	
	String portletResource = ParamUtil.getString(renderRequest, "portletResource");
	
	if (Validator.isNotNull(portletResource)) {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(renderRequest, portletResource);
	}
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	String edmsGatewayUrl = GetterUtil.getString(prefs.getValue("edmsGatewayUrl", "http://210.245.110.195:8833/Gateway"));
	String edmsGatewayUserName = GetterUtil.getString(prefs.getValue("edmsGatewayUserName", ""));
	String edmsGatewayPassword = GetterUtil.getString(prefs.getValue("edmsGatewayPassword", ""));
	long timerDelay = GetterUtil.getLong(prefs.getValue("timerDelay", "30000"));
	long timerDelayOrg = GetterUtil.getLong(prefs.getValue("timerDelayOrg", "30000"));
	long timerDelaySendMail = GetterUtil.getLong(prefs.getValue("timerDelaySendMail", "86400000"));
	String edmsGatewayStatusNew = GetterUtil.getString(prefs.getValue("edmsGatewayStatusNew", "NEW"));
	String edmsGatewayStatusRecieve = GetterUtil.getString(prefs.getValue("edmsGatewayStatusRecieve", ""));
	String edmsGatewayFromDate = GetterUtil.getString(prefs.getValue("edmsGatewayFromDate", "")); 
	String edmsGatewayToDate = GetterUtil.getString(prefs.getValue("edmsGatewayToDate", sdf.format(new Date())));
	String edmsGatewaySubCompany = GetterUtil.getString(prefs.getValue("edmsGatewaySubCompany", "")); 
%>

<form action="<liferay-portlet:actionURL portletConfiguration='true'/>" method="post" name="<portlet:namespace />fm" onsubmit="return validateForm();">
<div class="title_categ"><liferay-ui:message key="cau-hinh-ket-noi"/></div>
<div class="boxcontent" >
	<table>
		<tr>
			<td>
				<liferay-ui:message key="edmsgateway-url"/>:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>edmsGatewayUrl" value="<%= edmsGatewayUrl %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="edmsgateway-username"/>:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>edmsGatewayUserName" value="<%= edmsGatewayUserName %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="edmsgateway-password" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>edmsGatewayPassword" value="<%= edmsGatewayPassword %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="timer-delay" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>timerDelay" value="<%= timerDelay %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="timer-delay-org" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>timerDelayOrg" value="<%= timerDelayOrg %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="timer-delay-send-mail" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>timerDelaySendMail" value="<%= timerDelaySendMail %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="edmsgateway-status-new" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>edmsGatewayStatusNew" value="<%= edmsGatewayStatusNew %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="edmsgateway-status-receive" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>edmsGatewayStatusRecieve" value="<%= edmsGatewayStatusRecieve %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="edmsgateway-sub-company" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>edmsGatewaySubCompany" value="<%= edmsGatewaySubCompany %>">
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="edmsgateway-fromdate" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>edmsGatewayFromDate" id="<portlet:namespace/>edmsGatewayFromDate" value="<%= edmsGatewayFromDate %>">
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-tuNgay" onClick="callCalendar('<portlet:namespace/>edmsGatewayFromDate','cal-button-tuNgay')" />
			</td>
		</tr>
		<tr>
			<td>
				<liferay-ui:message key="edmsgateway-todate" />:
			</td>
			<td>
				<input type="text" size="50" name="<portlet:namespace/>edmsGatewayToDate" id="<portlet:namespace/>edmsGatewayToDate" value="<%= edmsGatewayToDate %>">
				<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-denNgay" onClick="callCalendar('<portlet:namespace/>edmsGatewayToDate','cal-button-denNgay')" />
			</td>
		</tr>
	</table>
	
	<input type="submit" value='<liferay-ui:message key="save" />' />
	
</div>

</form>