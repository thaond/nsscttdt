<%@ include file="/html/portlet/ext/holidaymanagement/init.jsp" %>
<liferay-util:include page="/html/portlet/ext/holidaymanagement/js/holidaymanagement.jsp"></liferay-util:include>
<%@page import="com.sgs.portlet.holiday.model.PmlHoliday"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<script type="text/javascript" src="/html/js/calendar.js"></script>
<script type="text/javascript" src="/html/js/calendar-setup.js"></script>
<script type="text/javascript" src="/html/js/calendar-en.js"></script>
<link type="text/css" rel="stylesheet" href="/html/css/calendar-system.css" />
<portlet:actionURL var="add">
	<portlet:param name="struts_action" value="/sgs/holidaymanagement/view" />
	<portlet:param name="<%=Constants.ACTION %>" value="<%=Constants.ADD %>" />
</portlet:actionURL>

<%
	String redirect = request.getParameter("redirect");
%>

<form action="<%= add %>" method="post" name="<portlet:namespace />fm" onsubmit="return <portlet:namespace />checkForm(this);" >
<div class="title_categ"><liferay-ui:message key="holiday-ngay-nghi-trong-tuan"/></div>
<div class="boxcontent">
	<table class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
			<td  width="35px" align="center"><liferay-ui:message key="pccc-TN-stt" /></td>
			<td ><liferay-ui:message key="holiday-cac-ngay-trong-tuan" /></td>
			<td width="15%" align="center"><liferay-ui:message key="holiday-nghi-ca-ngay" /></td>
			<td width="15%" align="center"><liferay-ui:message key="holiday-nghi-buoi-sang" /></td>
			<td width="15%" align="center"><liferay-ui:message key="holiday-nghi-buoi-chieu" /></td>
		</tr>
		<tr class="tr_two results-row">
			<td align="center" >1</td>
			<td class="td-stt-pml"><liferay-ui:message key="calendar.add_personalevent.monday"/></td>
			<td align="center"><input type="radio" name="monday" value="3/MON" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="monday" value="1/MON" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="monday" value="2/MON" onclick="checkValueDayInput(this);"/></td>
		</tr>
		<tr class="results-row">
			<td align="center" >2</td>
			<td><liferay-ui:message key="calendar.add_personalevent.tuesday"/></td>
			<td align="center"><input type="radio" name="tuesday" value="3/TUES" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="tuesday" value="1/TUES" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="tuesday" value="2/TUES" onclick="checkValueDayInput(this);"/></td>
		</tr>
		<tr class="tr_two results-row">
			<td align="center" >3</td>
			<td><liferay-ui:message key="calendar.add_personalevent.wednesday"/></td>
			<td align="center"><input type="radio" name="wednesday" value="3/WEDNES" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="wednesday" value="1/WEDNES" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="wednesday" value="2/WEDNES" onclick="checkValueDayInput(this);"/></td>
		</tr>
		<tr class="results-row">
			<td align="center" >4</td>
			<td><liferay-ui:message key="calendar.add_personalevent.thursday"/></td>
			<td align="center"><input type="radio" name="thursday" value="3/THURS" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="thursday" value="1/THURS" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="thursday" value="2/THURS" onclick="checkValueDayInput(this);"/></td>
		</tr>
		<tr class="tr_two results-row">
			<td align="center" >5</td>
			<td><liferay-ui:message key="calendar.add_personalevent.friday"/></td>
			<td align="center"><input type="radio" name="friday" value="3/FRI" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="friday" value="1/FRI" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="friday" value="2/FRI" onclick="checkValueDayInput(this);"/></td>
		</tr>
		<tr class="results-row">
			<td align="center" >6</td>
			<td><liferay-ui:message key="calendar.add_personalevent.saturday"/></td>
			<td align="center"><input type="radio" name="saturday" value="3/SATUR" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="saturday" value="1/SATUR" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="saturday" value="2/SATUR" onclick="checkValueDayInput(this);"/></td>
		</tr>
		<tr class="tr_two results-row">
			<td align="center" >7</td>
			<td><liferay-ui:message key="calendar.add_personalevent.sunday"/></td>
			<td align="center"><input type="radio" name="sunday" value="3/SUN" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="sunday" value="1/SUN" onclick="checkValueDayInput(this);"/></td>
			<td align="center"><input type="radio" name="sunday" value="2/SUN" onclick="checkValueDayInput(this);"/></td>
		</tr>
	
	</table>

<fieldset class="filborder">
		<legend class="laborder"><liferay-ui:message key="holiday-ngay-nghi-le" /></legend>
		<input type="hidden" id="stt" value="1" />
		<input type="hidden" id="arr_ngaynghile" name="arr_ngaynghile" value="" />

		<table id="holidayTable" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
			<tr class="portlet-section-header results-header" >
				<td width="60%" ><liferay-ui:message key="holiday-kieu-ngay-nghi" /></td>
				<td width="35%" align="center"><liferay-ui:message key="holiday-ngay-nghi" /></td>
				<td align="center"><input type="button" id="addHoliday" value='<liferay-ui:message key="holiday-them-ngay-le"/>' onclick="addRow()"/></td>
			</tr>
		</table>
</fieldset>

<div align="right" id="table-button">
		<input type="submit" value='<liferay-ui:message key="save"/>'/>
		<input type="reset" value='<liferay-ui:message key="reset"/>'/>
		<span onclick="javascript:submitForm(document.hrefFm,'<%= redirect %>');"><input type="button"	value='<liferay-ui:message key="back"/>' /></span>
</div>

</div>
</form>