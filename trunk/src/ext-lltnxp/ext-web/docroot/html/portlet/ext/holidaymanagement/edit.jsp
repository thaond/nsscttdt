<%@ include file="/html/portlet/ext/holidaymanagement/init.jsp" %>
<%@page import="com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil"%>
<liferay-util:include page="/html/portlet/ext/holidaymanagement/js/holidaymanagement.jsp"></liferay-util:include>
<%@page import="com.sgs.portlet.holiday.model.PmlHoliday"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />

<%
	String redirect = request.getParameter("redirect");
	String id = renderRequest.getParameter("holidayId");
	long holidayId = 0;
	if (null != id) {
		holidayId = Long.parseLong(id);
	}
	PmlHoliday holiday = PmlHolidayLocalServiceUtil.getPmlHoliday(holidayId);
	
	String type = "holiday-ngay-nghi-le";
	String holidayType = holiday.getHoliday_type();
	if ("1".equals(holidayType)) {
		type = "holiday-nghi-buoi-sang";
	}
	if ("2".equals(holidayType)) {
		type = "holiday-nghi-buoi-chieu";
	}
	if ("3".equals(holidayType)) {
		type = "holiday-nghi-ca-ngay";
	}
	
	String holidayValue = holiday.getHoliday_value();
	String value = holiday.getHoliday_value();
	if ("MON".equals(holidayValue)) {
		value = "calendar.add_personalevent.monday";
	}
	if ("TUES".equals(holidayValue)) {
		value = "calendar.add_personalevent.tuesday";
	}
	if ("WEDNES".equals(holidayValue)) {
		value = "calendar.add_personalevent.wednesday";
	}
	if ("THURS".equals(holidayValue)) {
		value = "calendar.add_personalevent.thursday";
	}
	if ("FRI".equals(holidayValue)) {
		value = "calendar.add_personalevent.friday";
	}
	if ("SATUR".equals(holidayValue)) {
		value = "calendar.add_personalevent.saturday";
	}
	if ("SUN".equals(holidayValue)) {
		value = "calendar.add_personalevent.sunday";
	}
%>
<portlet:actionURL var="update">
	<portlet:param name="struts_action" value="/sgs/holidaymanagement/view" />
	<portlet:param name="<%=Constants.ACTION %>" value="<%=Constants.UPDATE %>" />
	<portlet:param name="holidayId" value='<%=String.valueOf(holidayId) %>' />
</portlet:actionURL>

<form action="<%= update %>" method="post" name="<portlet:namespace />fm" onclick=" return checkFormEdit(this);">
<div class="title_categ"><liferay-ui:message key="javax.portlet.title.SGS_HOLIDAYMANAGEMENT"/></div>
<div class="boxcontent">
<%
	if ("Holiday".equals(holidayType)) {
%>
<fieldset class="filborder">
	<legend class="laborder"><liferay-ui:message key="holiday-ngay-nghi-le" /></legend>
	<table id="holidayTable" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
			<td width="80%"><liferay-ui:message key="holiday-kieu-ngay-nghi" /></td>
			<td align="center"><liferay-ui:message key="holiday-ngay-nghi" /></td>
		</tr>
		
		<tr class="results-row">
			<td><div><input style="width: 95%" type="text" name="holidayType" value='<liferay-ui:message key="<%=type %>"/>' readonly="readonly"/></div></td>
			<td><div align="center">
					<input style="width: 95%" type="text" name="holidayValue" id="holidayValue" value="<%=value %>" onblur="checkValueHolidayInputEdit(this);"/>
					<input style="width: 95%" type="hidden" name="holidayValueHidden" id="holidayValueHidden" value="<%= value %>"/>
				</div>
			</td>
		</tr>
		
		</table>
</fieldset>
<%		
	} else {
%>
<fieldset class="filborder">
	<legend class="laborder"><liferay-ui:message key="holiday-ngay-nghi-trong-tuan" /></legend>
		<table id="holidayTable" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
				<td width="25%" align="center"><liferay-ui:message key="holiday-nghi-ca-ngay" /></td>
				<td width="25%" align="center"><liferay-ui:message key="holiday-nghi-buoi-sang" /></td>
				<td width="25%" align="center"><liferay-ui:message key="holiday-nghi-buoi-chieu" /></td>
				<td align="center"><liferay-ui:message key="holiday-cac-ngay-trong-tuan" /></td>
			</tr>
			
			<tr class="results-row">
				<td align="center"><input type="radio" name="holidayType" <%="3".equals(holidayType) ? "checked" : "" %> value="3"/></td>
				<td align="center"><input type="radio" name="holidayType" <%="1".equals(holidayType) ? "checked" : "" %> value="1"/></td>
				<td align="center"><input type="radio" name="holidayType" <%="2".equals(holidayType) ? "checked" : "" %> value="2"/></td>
				<td align="center"><liferay-ui:message key="<%= value %>" /></td>
			</tr>
			
		</table>
	</fieldset>

<%
	}
%>
<div align="right" id="table-button">
		<input type="submit" value='<liferay-ui:message key="update"/>'/>
		<input type="reset" value='<liferay-ui:message key="reset"/>'/>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
</div>
</div>
</form>
<script type="text/javascript">
	window.onload = function (){
		
		if (document.getElementById('holidayValue') != null) {
			callCalendar('holidayValue','cal-button-FromDate');
		}
	}
</script>