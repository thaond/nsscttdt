<%@ include file="/html/portlet/ext/holiday_calendar/init.jsp" %>
<%@ include file="/html/portlet/ext/holiday_calendar/js/holiday_calendar.jsp" %>

<script type="text/javascript"	src="/html/js/calendar.js"></script>
<script type="text/javascript"	src="/html/js/calendar-setup.js"></script>
<script type="text/javascript"	src="/html/js/calendar-en.js"></script>
<script type="text/javascript"	src="/html/js/dateFormat.js"></script>
<link type="text/css" rel="stylesheet"	href="/html/css/calendar-system.css" />

<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.sgs.portlet.holiday_calendar.service.HolidayCalendarLocalServiceUtil"%>
<%@page import="com.sgs.portlet.holiday_calendar.model.HolidayCalendar"%>
<%@page import="com.ext.portal.util.ConstantsExt"%>
<%@page import="com.sgs.portlet.holiday_calendar.model.AttactFileHoliday"%>

<%
	String redirect = ParamUtil.getString(request,"redirect");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("struts_action", "/sgs/holiday_calendar/view");
	String portletURLString = portletURL.toString();
	
	List<HolidayCalendar> holidayCalendars = HolidayCalendarLocalServiceUtil.getHolidayCalendars(-1,-1);
	String holidayCalendarCode = (String) request.getAttribute("holidayCalendarCode");
	String holidayCalendarTitle = (String) request.getAttribute("holidayCalendarTitle");
	String holidayCalendarDateCreate = (String) request.getAttribute("holidayCalendarDateCreate");
	String duplicateholidayCalendarCode = (String) request.getAttribute("duplicate_holiday_calendar_code");
	
	String content = renderRequest.getAttribute("htmlToRTF") != null ? (String) renderRequest.getAttribute("htmlToRTF") :"";
	List<AttactFileHoliday> attactFileHolidays = (List<AttactFileHoliday>) request.getAttribute("attactFileHolidays");
	HolidayCalendar holidayCalendar = (HolidayCalendar) request.getAttribute("holidayCalendar");
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
%>


<portlet:actionURL var="edit_holiday_calendar">
	<portlet:param name="struts_action" value="/sgs/holiday_calendar/view" />
	<portlet:param name="<%=Constants.CMD %>" value="<%=Constants.UPDATE %>" />
	<portlet:param name="holidayCalendarId" value="<%=String.valueOf(holidayCalendar.getHolidayCalendarId())%>" />
	<portlet:param name="redirect" value="<%=redirect %>" />
</portlet:actionURL>
<div id="boxcontent">
<form action="<%=edit_holiday_calendar%>" enctype="multipart/form-data" method="post" name="<portlet:namespace/>fm">
<input name="<portlet:namespace />content" type="hidden" value="" />
<input name="<portlet:namespace/>attactFileHolidayId" type="hidden" value="" />
<input name="<portlet:namespace/>holidayCalendarId" type="hidden" value="<%=String.valueOf(holidayCalendar.getHolidayCalendarId())%>" />
<div class="title_categ"><liferay-ui:message key="edit-holiday-calendar" /></div>
<div class="boxcontent" >
<table cellspacing="0" width="100%">
	<tr>
		<td width="20%"><liferay-ui:message key="holiday-calendar-code" />:</td>
		<td><input type="text" readonly="readonly" size="45" name="<portlet:namespace/>holidayCalendarCode" value="<%= (holidayCalendar != null) ? holidayCalendar.getHolidayCalendarCode() : "" %>"></td>
	</tr>

	<tr>
		<td><liferay-ui:message key="date-create" />&nbsp;:</td>
		<td>
			<input name="<portlet:namespace/>holidayCalendarDateCreate" value="<%= (holidayCalendar != null) ? simpleDateFormat.format(holidayCalendar.getHolidayCalendarDateCreate()) : "" %>" id="<portlet:namespace />cal_from_date" size="12" type="text" value="" style="width: 140px" maxlength="10" onFocus="javascript:vDateType='3'" onKeyUp="DateFormat(this,this.value,event,false,'3')"/>
			<img align="top" src="/html/images/cal.gif" style="cursor: pointer;" id="cal-button-FromDate" onmouseover="callCalendar('<portlet:namespace/>cal_from_date','cal-button-FromDate')" />
		</td>
	</tr>
	<tr id="<portlet:namespace/>titleFileContent" style="display: none">
		<td><liferay-ui:message key="title-file-content" /></td>
		<td><input type="text" size="45" name="<portlet:namespace/>titleFileContent" value=""></td>
	</tr>
	<tr style="display: none">
		<td><a onclick="showExportFileDiv()"><liferay-ui:message key="create-content" /></a>&nbsp;</td>
		<td>
		<%
	  		boolean previewExportFileB = ParamUtil.getBoolean(renderRequest, "previewExportFile", false);
	  		%>
			<div id="exportFileDiv">
				<liferay-ui:input-editor/>
				<table width="100%" border="0" cellspacing="0">
					<tr>
						<td>
						
		  				<% for (String conversion : ConstantsExt.allowedExtensions) {  %>
								<input onclick="<portlet:namespace />preCheked(this)" name="<portlet:namespace />extensions" type="checkbox" value="<%= conversion %>" />
								<%= conversion.toUpperCase() %>
						<% }%>
							<input type="submit" onclick="<portlet:namespace />previewExportFile();" value='<liferay-ui:message key="export-file"/>'/>
							<input type="submit" onclick="return <portlet:namespace />convertFile();" value='<liferay-ui:message key="convert-file"/>'/>
						</td>
					</tr>
				</table>	
			</div>
		</td>
	</tr>
</table>	

<fieldset class="filborder">
	<label class="laborder"><liferay-ui:message key="holiday-calendar"/></label>
	<% 
	if(attactFileHolidays != null && attactFileHolidays.size() > 0){
		String linkAttactFile = "";
		String attactFileHolidayIds = "";
	  	for(AttactFileHoliday attactFileHoliday : attactFileHolidays){
	  			attactFileHolidayIds += attactFileHoliday.getAttactFileHolidayId()+"_";
				String path = attactFileHoliday.getAttactFileHolidayPath();
				String title = (String)attactFileHoliday.getAttactFileHolidayTitle().subSequence(0,attactFileHoliday.getAttactFileHolidayTitle().indexOf("_"));
				long attactFileHolidayId = attactFileHoliday.getAttactFileHolidayId();
				String deleteAction = "<a  href='javascript: ;' onclick=deleteConfirmSend('"+ attactFileHolidayId +"')><u>"+ "<img src='/html/images/delete.png'/>" +"</u></a>";
					if(!attactFileHoliday.getAttactFileHolidayTitle().equals("")){
						linkAttactFile = "<a href =" + path + ">" + title + "</a>" + deleteAction;
					}
	%>
	<%=linkAttactFile %>
	<%} %>
	<input type="hidden" name="attactFileHolidayIds" value="<%=attactFileHolidayIds%>">
	<%} %>
	
	<table id="addfileupload" class="taglib-search-iterator table-pml" cellspacing="0" width="100%">	
		<tr class="portlet-section-header results-header" >
	   		<td><liferay-ui:message key="holiday-calendar-content" /></td>
	    	<td width="50%"><liferay-ui:message key="holiday-calendar-file" /></td>
			<td width="15%" align="center"><input style="width: 80%" type="button" value='<liferay-ui:message key="add-file-holiday" />' onclick="uploadResultFile()"></td>
		</tr>
	</table>
	
	<input type="hidden" name="<portlet:namespace/>nameFieldRow" id="nameFieldRow" value="" />
	<input type="hidden" name="<portlet:namespace/>nameFiles" id="nameFiles" value="" />
	<input type="hidden" name="<portlet:namespace/>titleFiles" id="titleFiles" value="" />
</fieldset>

<input type="submit" value='<liferay-ui:message key="edit-holiday-calendar"/>' onclick="return checkValidate()">
<a href="<%=redirect %>"><input type="button" value='<liferay-ui:message key="back"/>'></a>
</div>
</form>
</div>
<script type="text/javascript">
	function deleteConfirmSend(attactFileHolidayId) {
		document.<portlet:namespace/>fm.<portlet:namespace/>attactFileHolidayId.value = attactFileHolidayId;
		if (confirm("<liferay-ui:message key='ban-co-that-su-muon-xoa'/>")) {
			sendDelete();
		}
	}
	
	function sendDelete(){
		submitForm(document.<portlet:namespace/>fm,
			"<portlet:actionURL windowState="<%=WindowState.NORMAL.toString()%>">
			<portlet:param name="struts_action" value="/sgs/holiday_calendar/view" />
			<portlet:param name="redirect" value="<%=redirect%>" />
			<portlet:param name="tab" value="edit_holiday_calendar" />
			<portlet:param name="<%=Constants.CMD%>" value="SENDDELETE" />
			</portlet:actionURL>");
	}
</script>
