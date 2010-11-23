<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ include file="/html/portlet/ext/meeting_calendar/init.jsp" %>
<script type="text/javascript">
var xmlHttp;

function update(mcalId, stt) { 
	xmlHttp = GetXmlHttpObject();
	if (xmlHttp == null) {
		alert ("Your browser does not support AJAX!");
		return;
	} 
	var url = "/html/portlet/ext/meeting_calendar/updatecal.jsp";
	url = url + "?stt=" + stt;
	url = url + "&sId=" + mcalId;
	xmlHttp.open("GET", url, true);
	xmlHttp.send(null);
}

function GetXmlHttpObject() {
	var xmlHttp = null;
	try {
	  	// Firefox, Opera 8.0+, Safari
	  	xmlHttp = new XMLHttpRequest();
	}
	catch (e) {
		// Internet Explorer
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		}
		catch (e) {
			xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
		}
	}
	return xmlHttp;
}

jQuery(document).ready(function() {
for (var t = 0; t < 2; t++) {
	for (var j = 0; j < 7; j++) {
		jQuery("#sang_" + t + "_" + j).tableDnD({
			onDragClass: "tDnD_whileDrag",
			onDrop: function(table, row) {
				var rows = table.tBodies[0].rows;
				for (var i=0; i<rows.length; i++) {
					var id = rows[i].id;
					var ids = id.split("_");
					var mcalId = ids[0];
					var stt = ids[1];
					rows[i].id = mcalId + "_" + (i + 1);
					update(mcalId, i + 1);
				}
			},
			dragHandle: "nameContent"
		});
		
		jQuery("#sang_" + t + "_" + j + " tr").hover(function() {
			jQuery(this.cells[0]).addClass('showDragHandle');
		}, function() {
			jQuery(this.cells[0]).removeClass('showDragHandle');
		});
	
		jQuery("#chieu_" + t + "_" + j).tableDnD({
			onDragClass: "tDnD_whileDrag",
			onDrop: function(table, row) {
				var rows = table.tBodies[0].rows;
				for (var i = 0; i < rows.length; i++) {
					var id = rows[i].id;
					var ids = id.split("_");
					var mcalId = ids[0];
					var stt = ids[1];
					rows[i].id = mcalId+"_" + (i + 1);
					update(mcalId, i + 1);
				}
			},
			dragHandle: "nameContent"
		});
		
		jQuery("#chieu_" + t + "_" + j + " tr").hover(function() {
			jQuery(this.cells[0]).addClass('showDragHandle');
		}, function() {
			jQuery(this.cells[0]).removeClass('showDragHandle');
		});
	}
}
});
</script>
<script src="/html/js/_libJS/jquery.js" type="text/javascript"></script>
<%
String showDoiHop = "false";
String showHuyHop = "false";

String tabs1 = ParamUtil.getString(request, "tabs1", tabs1Default);
String redirect = ParamUtil.getString(request, "redirect");

String eventType = ParamUtil.getString(request, "eventType", "lich");

String showAdvance = ParamUtil.getString(request, "showAdvance");
String tabs1_ = ParamUtil.getString(request, "tabs1", tabs1Default);
if (Validator.isNotNull(ParamUtil.getString(request, "tabs1"))) {
	tabs1_ = ParamUtil.getString(request, "tabs1");
}

boolean checkUser = PortletPermissionUtil.contains(permissionChecker, plid.longValue(), portletDisplay.getId(), MeetingCalendarKey.APPROVE_CALENDAR);
if (tabs1_.equals("calendar-release")) {
	checkUser = false;
}
else if ((tabs1_.equals("approved-calendar"))) {
	checkUser = true;
}
Calendar cal = (Calendar)selCal.clone();
// DuyDuong add: get Monday is first on week
int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 2;

DateFormat dateFormatDayOfWeek = new SimpleDateFormat("E", locale);
DateFormat dateFormatMonthAndDay = new SimpleDateFormat("M/d", locale);
PortletURL portletURL = renderResponse.createRenderURL();
portletURL.setWindowState(WindowState.NORMAL);
portletURL.setParameter("struts_action", "/ext/meeting_calendar/week_view");
portletURL.setParameter("tabs1", tabs1);
portletURL.setParameter("redirect", redirect);

//Trieu add 20091023
// Object properties
long userId = themeDisplay.getUserId();
long mdweekId = 0;
String focus = "";
String note = "";
String receive = "";
int week = 0;
int year = 0;
week = cal.get(Calendar.WEEK_OF_YEAR);
year = cal.get(Calendar.YEAR);
MeetingDetailWeek meetingDetailWeekes = MeetingDetailWeekLocalServiceUtil.getWeekYear(week, year);
if (meetingDetailWeekes != null) {
	mdweekId = meetingDetailWeekes.getMdweekId();
	userId = meetingDetailWeekes.getUserId();
	focus = meetingDetailWeekes.getFocus();
	note = meetingDetailWeekes.getNote();
	receive = meetingDetailWeekes.getReceive();		
	week = meetingDetailWeekes.getWeek();
	year = meetingDetailWeekes.getYear();
}

MeetingCalendarSearch searchContainer = new MeetingCalendarSearch(renderRequest, portletURL);
MeetingCalendarSearchTerms searchTerms = (MeetingCalendarSearchTerms)searchContainer.getSearchTerms();
MeetingCalendarDisplayTerms displayTerms = (MeetingCalendarDisplayTerms)searchContainer.getDisplayTerms();
SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
String frDay = request.getParameter("frDateDay");
String frMonth = request.getParameter("frDateMonth");
String frYear = request.getParameter("frDateYear");
String toDay = request.getParameter("toDateDay");
String toMonth = request.getParameter("toDateMonth");
String toYear = request.getParameter("toDateYear");
java.util.Date nowDate = new java.util.Date();

%>
<liferay-portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" varImpl="searchURL"><portlet:param name="struts_action" value="/ext/meeting_calendar/search" /></liferay-portlet:renderURL>
<form action="<%= searchURL %>" method="post" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;">
<div class="boxcom">
<div class="titlecategories"><h6><liferay-ui:message key="Lich-lam-viec" /></h6> </div>
<liferay-portlet:renderURLParams varImpl="searchURL" />
<input type="hidden" name="<portlet:namespace /><%= Constants.CMD %>" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= currentURL %>" />
<input type="hidden" name="<portlet:namespace />showAdvance" value="<%= showAdvance %>" />
<input type="hidden" name="<portlet:namespace />tabs1" value="<%= tabs1_ %>" />
<liferay-util:include page="/html/portlet/ext/meeting_calendar/tabs1.jsp" />
<div class="borderendTab">
<table width="100%" cellspacing="0" class="tbleborderSS">
	<tr>
		<td colspan="2" class="td-left">
			<a class="repeat" onclick="<portlet:namespace />showHideAdvance('<portlet:namespace />showHideAdvance','<portlet:namespace />portletShowHide');"><liferay-ui:message key="search" /></a>
			<div id="<portlet:namespace />showHideAdvance" class="div" style="display: <%= (showAdvance.equalsIgnoreCase("true")) ? "block" : "none" %>;">
			<table width="100%">
				<tr>
					<td width="20%" ><liferay-ui:message key="from-date" />&nbsp;:</td>
					<td>
						<%
						//chuyen month thanh so, cong voi 1 de dung voi thang nhap tren combobox
						int frMonthInt = 0;
						if (frMonth !=null) {
							frMonthInt = Integer.parseInt(frMonth) + 1;
						}
						
						String frDMY = frDay + "/" + String.valueOf(frMonthInt) + "/" + frYear; 
						
						Date frDisplayDate = null;
						
						if (frDay != null) {
							frDisplayDate = formatter.parse(frDMY);
						}
						
						// liferay-ui:input-date don`t undertand null
						if (frDay == null) {
							frDay = "0";
						}
						if (frMonth == null) {
							frMonth = "0";
						}
						if (frYear == null) {
							frYear = "0";
						}
						%>
						
						<liferay-ui:input-date
							disableNamespace="<%= true %>"
							formName='<%= renderResponse.getNamespace() + "fm" %>'
							monthParam="frDateMonth"
							monthValue="<%=Integer.parseInt(frMonth) %>"
							dayParam="frDateDay"
							dayValue="<%=Integer.parseInt(frDay) %>"
							yearParam="frDateYear"
							yearValue="<%=Integer.parseInt(frYear) %>"
							yearRangeStart="<%= cal.get(Calendar.YEAR) - 5 %>"
							yearRangeEnd="<%= cal.get(Calendar.YEAR) + 5 %>"
							firstDayOfWeek="<%= cal.getFirstDayOfWeek() - 1 %>"
							disabled="<%= false %>"
						/>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="to-date" />&nbsp;:</td>
					<td>
						<%
						// chuyen month thanh so, cong voi 1 de dung voi thang nhap tren combobox
						int toMonthInt = 0;
						if (toMonth != null) {
							toMonthInt = Integer.parseInt(toMonth) + 1;
						}
						
						String toDMY = toDay + "/" + String.valueOf(toMonthInt) + "/" + toYear; 
						
						Date toDisplayDate = null;
						
						if (toDay != null) {
							toDisplayDate = formatter.parse(toDMY);
						}
						if (toDay == null) {
							toDay = String.valueOf(cal.get(Calendar.DATE));
						}
						if (toMonth == null) {
							toMonth = String.valueOf(cal.get(Calendar.MONTH));
						}
						if (toYear == null) {
							toYear = String.valueOf(cal.get(Calendar.YEAR));
						}
						%>
						
						<liferay-ui:input-date
							disableNamespace="<%= true %>"
							formName='<%= renderResponse.getNamespace() + "fm" %>'
							monthParam="toDateMonth"
							monthValue="<%=Integer.parseInt(toMonth) %>"
							dayParam="toDateDay"
							dayValue="<%=Integer.parseInt(toDay)+1 %>"
							yearParam="toDateYear"
							yearValue="<%=Integer.parseInt(toYear) %>"
							yearRangeStart="<%= cal.get(Calendar.YEAR) - 5 %>"
							yearRangeEnd="<%= cal.get(Calendar.YEAR) + 5 %>"
							firstDayOfWeek="<%= cal.getFirstDayOfWeek() - 1 %>"
							disabled="<%= false %>"
						/>
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="meeting-content" />&nbsp;:</td>
					<td>
						<input name="<portlet:namespace /><%= displayTerms.DESCRIPTION%>" type="text" value="<%= HtmlUtil.escape(displayTerms.getDescription()) %>" style="width:98%;" />
					</td>
				<tr>
					<td><liferay-ui:message key="meeting-sponsor" />&nbsp;:</td>
					<td>
						<input name="<portlet:namespace /><%= displayTerms.SPONSOR%>" type="text" value="<%= HtmlUtil.escape(displayTerms.getSponsor()) %>" style="width:98%;" />
					</td>
				</tr>
				<tr>
					<td><liferay-ui:message key="meeting-component" />&nbsp;:</td>
					<td>
						<input name="<portlet:namespace /><%= displayTerms.COMPONENT%>" type="text" value="<%= HtmlUtil.escape(displayTerms.getSponsor()) %>" style="width:98%;" />
					</td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="<liferay-ui:message key="search" />" onClick="submitForm(document.<portlet:namespace />fm);"/>
					</td>
				</tr>
			</table>
			</div>
		</td>
	</tr>
	<tr>
		<td class="td-left" colspan="2" style="text-align: center;">
						<%
						cal.add(Calendar.DATE, -7);
						%>	
					<a href="<%= portletURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) %>&<portlet:namespace />day=<%= cal.get(Calendar.DATE) %>&<portlet:namespace />year=<%= cal.get(Calendar.YEAR) %>&<portlet:namespace />eventType=<%= eventType %>">
						<img align="top" border="0" src="/html/portlet/ext/meeting_calendar/Prev_Button.gif" />
					</a>&nbsp;&nbsp;
						<%
						cal.add(Calendar.DATE, 7);
						cal.add(Calendar.DATE, -firstDayOfWeek);
						%>
	
					<b>
						<liferay-ui:message key="from-date" />&nbsp;
						<%= dateFormatDate.format(Time.getDate(cal)) %> 
						<liferay-ui:message key="to-date" />&nbsp;
						<%
						cal.add(Calendar.DATE, 6);
						%>
						<%= dateFormatDate.format(Time.getDate(cal)) %>
						<%
						cal.add(Calendar.DATE, 1);
						%>
					</b>
					&nbsp;&nbsp;
						<a href="<%= portletURL.toString() %>&<portlet:namespace />month=<%= cal.get(Calendar.MONTH) %>&<portlet:namespace />day=<%= cal.get(Calendar.DATE) %>&<portlet:namespace />year=<%= cal.get(Calendar.YEAR) %>&<portlet:namespace />eventType=<%= eventType %>">
							<img align="top" border="0" src="/html/portlet/ext/meeting_calendar/Next_Button.gif" />
						</a>
				</td>
			</tr>
			<tr>
				<td class="td-left"></td>
				<td class="td-right">
					<%@ include file="/html/portlet/ext/meeting_calendar/meeting_calendar_print.jsp" %>
				</td>
			</tr>
	<tr>
		<td class="td-left" valign="top" width="15%"><liferay-ui:message key ="trong-tam"/> :</td>
		<td class="td-right"><%= focus %></td>
	</tr>
	<tr>
		<td class="td-left" valign="top" width="15%"><liferay-ui:message key ="luu-y"/> :</td>
		<td class="td-right"><%= note %></td>
	</tr>
	<tr>
		<td class="td-left" valign="top"><liferay-ui:message key ="noi-nhan"/> :</td>
		<td class="td-right"><%= receive %><br></td>
	</tr>
<%
boolean checkDateNow = false;
for(int mcaltype = 0; mcaltype < MeetingCalendarImpl.TYPES.length; mcaltype++) {
	eventType = MeetingCalendarImpl.TYPES[mcaltype];
	cal = (Calendar)selCal.clone();
	// DuyDuong add: get Monday is first on week
	firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 2;
	cal.add(Calendar.DATE, -firstDayOfWeek);
%>
<c:if test='<%= eventType.equals("lich-phu") %>'>
		<tr>
			<td class="td-left"><span style='font-size:14px;'><b>TU&#7846;N <%= cal.get(Calendar.WEEK_OF_YEAR)%> - <%= cal.get(Calendar.YEAR)%>:</b></span></td>
			<td class="td-left" style='font-size:14px;color: #0b8ed1;' align="center">PH&#7908; L&#7908;C L&#7882;CH C&#212;NG T&#193;C TU&#7846;N DO C&#193;C PH&#210;NG BAN V&#192; UBND 15 PH&#431;&#7900;NG &#272;&#258;NG K&#221;.</td>
		</tr>
</c:if>
</table>
<br>
<table cellpadding="0" cellspacing="0" width="100%" class="tblecanlend">
	<tr bgcolor="#1faed9">
		<td style="text-align: center;" class="thungaybuoi" width="15%">
			<%= LanguageUtil.get(pageContext, "thu-ngay").toUpperCase() %>
		</td>
		<td class="thungaybuoi" style="text-align: center;">
			<font>
			<%= LanguageUtil.get(pageContext, "buoi-sang").toUpperCase() %></font>
		</td>
		<td class="thungaybuoi" style="text-align: center;">
			<font><%= LanguageUtil.get(pageContext, "chieu-toi").toUpperCase() %></font>
		</td>
	</tr>
<%
for (int i = 0; i < 7; i++) {
%>
	<tr>	
		<%
		checkDateNow = (cal.getTime().equals(curCal.getTime())) || (cal.getTime().after(curCal.getTime()));
		String className = "portlet-font";
		if ((i%2) == 0) {
			className = "nameCal";
		}
		else {
			className = "nameCal_RE";
		}

		if (cal.getTime().before(curCal.getTime())) {
			className = "nameCal_OLD";
		}
		%>

		<td class="<%= className %>" valign="top" style="text-align: center;">
					<%= user.getLanguageId().equals("vi_VN")? StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))),"Th",LanguageUtil.get(pageContext,"thu-trong-tuan" )):dateFormatDayOfWeek.format(Time.getDate(cal)) %><br />
					<%=dateFormatDate.format(Time.getDate(cal))  %>
					<br/>
					<c:if test='<%=  checkUser && checkDateNow && PortletPermissionUtil.contains(permissionChecker, plid.longValue(), portletDisplay.getId(), ActionKeys.ADD_EVENT)%>'>
						<a href="<portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>"><portlet:param name="struts_action" value="/ext/meeting_calendar/edit_event" /><portlet:param name="redirect" value="<%= currentURL %>" /><portlet:param name="tabs1" value="register-calendar" /><portlet:param name="month" value="<%= String.valueOf(cal.get(Calendar.MONTH)) %>" /><portlet:param name="day" value="<%= String.valueOf(cal.get(Calendar.DATE)) %>" /><portlet:param name="year" value="<%= String.valueOf(cal.get(Calendar.YEAR)) %>" /><portlet:param name="type" value="<%= eventType %>" /></portlet:renderURL>">
						<img border="0" src="/html/portlet/ext/meeting_calendar/Cal_Week_New.gif" title="<liferay-ui:message key="add" />" />
						</a>
					</c:if>
		</td>
		<!-- HIEN THI PHAN BUOI SANG -->
		<td valign="top"  width="45%" style="border-right: 1px solid #1faed9;">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" id='<%= (checkUser && checkDateNow && PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(),MeetingCalendarKey.ORDER)) ? "sang_"+mcaltype+"_"+i : ""%>'>
			<%
			String randomNamespace = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
			String duplicateBgr = StringPool.BLANK;
			List events = CalEventLocalServiceUtil.getEvents(portletGroupId.longValue(), cal, eventType);
			
			List eventsOrg = new ArrayList();
			List mcalComps = null;
			try {
				mcalComps = MeetingCalComponentLocalServiceUtil.getByG_SD(portletGroupId.longValue(), cal);
			}
			catch (Exception e) {
			}
			if (mcalComps != null) {
				for (int j = 0; j < mcalComps.size(); j++) {
					MeetingCalComponent mcalComp = (MeetingCalComponent)mcalComps.get(j);
					if (mcalComp != null) {
						CalEvent cale1 = CalEventLocalServiceUtil.getEvent(mcalComp.getMcalId());
						MeetingCalendar mcale = MeetingCalendarLocalServiceUtil.getMeetingCalendar(mcalComp.getMcalId());
						if (cale1 != null && mcale != null) {
							if (mcale.getState() == MeetingCalendarKey.DA_DUYET) {
								eventsOrg.add(cale1);
							}
						} // end if
					} // end if
				} // end for
			}
			
			//tam thoi dong events = ListUtil.sort(events, new EventTimeComparator(timeZone, locale));
			Collections.sort(events, new EventTimeComparator(timeZone, locale));
			List eventsDuyet = new ArrayList();
			List eventsDoi = new ArrayList();
			List eventsHuy = new ArrayList();
			List eventsDuyet_E = new ArrayList();
			List eventsDoi_E = new ArrayList();
			List eventsHuy_E = new ArrayList();
			
			if (eventsOrg.size() != 0) {
				for (int j = 0; j < eventsOrg.size(); j++) {
					CalEvent cale1 = (CalEvent)eventsOrg.get(j);
					eventsDuyet.add(cale1);
					eventsDuyet_E.add(cale1);
				}
			}
			//tam thoi dong eventsDuyet = ListUtil.sort(eventsDuyet, new EventTimeComparator(timeZone, locale));
			//tam thoi dong eventsDuyet_E = ListUtil.sort(eventsDuyet_E, new EventTimeComparator(timeZone, locale));
			
			//List mcalSTTs = null;
			//try {
			//	mcalSTTs = MeetingCalendarLocalServiceUtil.getByG_SD(portletGroupId.longValue(), cal, eventType);
			//}
			//catch (Exception e) {
			//}
			
			//if (mcalSTTs==null) {
			//	mcalSTTs=events;
			//}
			
			//for(int j=0; j<mcalSTTs.size(); j++) {
			//	MeetingCalendar mcale = (MeetingCalendar)mcalSTTs.get(j);
			//	CalEvent cale1 = CalEventLocalServiceUtil.getEvent(mcale.getMcalId());
			for (int j = 0; j < events.size(); j++) {
				CalEvent cale1 = (CalEvent)events.get(j);
				if (cale1 != null) {
					//xuancong close MeetingCalendar mcale = MeetingCalendarLocalServiceUtil.getMeetingCalendar(cale1.getEventId());
					MeetingCalendar mcale = null;
					try {
						mcale = MeetingCalendarLocalServiceUtil.getMeetingCalendar(cale1.getEventId());
					}
					catch (Exception ex) {
						// Do nothing
					}
					// isTimeZoneSensitive is true
					Date stEvent = null;
					if (cale1.isTimeZoneSensitive()) {
						stEvent = Time.getDate(cale1.getStartDate(), timeZone);
					}
					else {
						stEvent = cale1.getStartDate();
					}
					if (mcale != null) {
						if ((mcale.getState() != MeetingCalendarKey.DOI) && (mcale.getState() != MeetingCalendarKey.HUY)) {
							if (stEvent.getHours() <= 12) {
								eventsDuyet.add(cale1);
							}
							else {
								eventsDuyet_E.add(cale1);
							}
						}
					} // end if
				} // end if
			} // end for
			for (int j = 0; j < events.size(); j++) {
				CalEvent event = (CalEvent)events.get(j);
				if (event != null) {
					MeetingCalendar mcal = null;
					try {
						mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
					}
					catch (Exception ex) {
						mcal = null;
					}
					// isTimeZoneSensitive is true
					Date stEvent = null;
					if (event.isTimeZoneSensitive()) {
						stEvent = Time.getDate(event.getStartDate(), timeZone);
					}
					else {
						stEvent = event.getStartDate();
					}
					if (mcal != null) {
						if (stEvent.getHours()<=12) {
							if ((mcal.getState() == MeetingCalendarKey.DOI)) {
								eventsDoi.add(event);
							}
							else if ((mcal.getState() == MeetingCalendarKey.HUY)) {
								eventsHuy.add(event);
							}
						}
						else {
							if ((mcal.getState() == MeetingCalendarKey.DOI)) {
								eventsDoi_E.add(event);
							}
							else if ((mcal.getState() == MeetingCalendarKey.HUY)) {
								eventsHuy_E.add(event);
							}
						}
					} // end if
				} // end if
			}
			
			// list lich cho duyet va da duyet
			for (int j = 0; j < eventsDuyet.size(); j++) {
				CalEvent event = (CalEvent)eventsDuyet.get(j);
				if (event != null) {
					MeetingCalendar mcal = null;
					try {
						mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
					}
					catch (Exception ex) {
						mcal = null;
					}
					// kt event chi co trong 1 bang
					if (mcal != null) {
						boolean showCalendar = false;
						if (checkUser) {
							showCalendar = true;
						}
						else {
							if (mcal.getState() != 0) {
								showCalendar = true;
							}
						}
						// isTimeZoneSensitive is true
						Date stEvent = null;
						if (event.isTimeZoneSensitive()) {
							stEvent = Time.getDate(event.getStartDate(), timeZone);
						}
						else {
							stEvent = event.getStartDate();
						}
						
						if (stEvent.getHours() <= 12 && showCalendar) {
							Iterator itr = events.iterator();
							while (itr.hasNext()) {
								CalEvent itrCal = (CalEvent)itr.next();
								MeetingCalendar itrMcal = null;
								try {
									itrMcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(itrCal.getEventId());
								}
								catch (Exception ex) {
									itrMcal = null;
								}
								if (itrMcal != null) {
									// isTimeZoneSensitive is true
									Date stCal = null;
									if (itrCal.isTimeZoneSensitive()) {
										stCal = Time.getDate(itrCal.getStartDate(), timeZone);
									}
									else {
										stCal = itrCal.getStartDate();
									} // end else
									if ((itrCal.getEventId() != event.getEventId()) && (stCal.getHours() <= 12)) {
										if (stCal.getHours() > stEvent.getHours()) {
											if (((itrCal.getStartDate().getTime() - CalUtil.getEndTime(event).getTime()) < 0)
												&& (((Validator.isNotNull(mcal.getPlace())) && (mcal.getPlace().equals(itrMcal.getPlace())))
												|| ((Validator.isNotNull(mcal.getPlace_diff())) && (mcal.getPlace_diff().equals(itrMcal.getPlace_diff()))))) {
												duplicateBgr = "red";
												if (tabs1_.equals("calendar-release")) {
													duplicateBgr = itrMcal.getState() == MeetingCalendarKey.DA_DUYET ? "red" : "";
												}
												break;
											}
											else {
												duplicateBgr = "";
											}
										} // end if
										else {
											if (((event.getStartDate().getTime() - CalUtil.getEndTime(itrCal).getTime()) < 0) 
												&& (((Validator.isNotNull(mcal.getPlace())) && (mcal.getPlace().equals(itrMcal.getPlace())))
												|| ((Validator.isNotNull(mcal.getPlace_diff())) && (mcal.getPlace_diff().equals(itrMcal.getPlace_diff()))))) {
												duplicateBgr = "red";
												if (tabs1_.equals("calendar-release")) {
													duplicateBgr = itrMcal.getState() == MeetingCalendarKey.DA_DUYET ? "red" : "";
												}
												break;
											}
											else {
												duplicateBgr = "";
											}
										} // end else
									} // end if 
								} // end if
							} // end while
							boolean prior = mcal.getPrior();
							String bgPrior = "";
							if (prior) {
								bgPrior = "#EFEFDE";
							}
	 %>										
							<tr id='<%= (mcal.getMcalId() + "_" + (j + 1)) %>'>
								<td align="center" nowrap class="nameContent" valign="top" width="20%">
									<c:choose>
										<c:when test="<%= event.isAllDay() %>">
											<liferay-ui:message key="all-day" />
										</c:when>
										<%-- xuancong close
										<c:when test="<%= mcal.isMorning() || mcal.isAfternoon() || mcal.isEvening() %>">
											
										</c:when>
										--%>
										<c:when test="<%= mcal.isMorning() %>">
											<liferay-ui:message key="buoi-sang" />
										</c:when>
										<c:when test="<%= mcal.isAfternoon() %>">
											<liferay-ui:message key="buoi-chieu" />
										</c:when>
										<c:when test="<%= event.isTimeZoneSensitive() %>">
											<%= dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)) %>
										</c:when>
										<c:otherwise>
											<%= dateFormatTime.format(event.getStartDate()) %>
										</c:otherwise>
									</c:choose>
									<br>
									<%
									if (checkUser && checkDateNow) { 
									%>
										<%@ include file="/html/portlet/ext/meeting_calendar/meeting_calendar_action.jsp" %>
										<br />
										<% 
										if (PortletPermissionUtil.contains(permissionChecker, plid.longValue(), portletDisplay.getId(), MeetingCalendarKey.ORDER)) {
										%>
											<img src="/html/portlet/ext/meeting_calendar/updown2.gif"/>
											<br />
									<%
										}
									}
									else {
										if ((nowDate.getTime() - event.getStartDate().getTime()) > 0 && (nowDate.getTime() - CalUtil.getEndTime(event).getTime()) < 0 && (mcal.getState() == MeetingCalendarKey.DA_DUYET)) {
									%>
											<img border="0" src="/html/portlet/ext/meeting_calendar/iDangHop.gif" title="<liferay-ui:message key="dang-hop" />" />
									<%
										}
										else if ((nowDate.getTime() - CalUtil.getEndTime(event).getTime()) >= 0 && (mcal.getState() == MeetingCalendarKey.DA_DUYET)) {
									%>
											<img border="0" src="/html/portlet/ext/meeting_calendar/iDaHop.gif" title="<liferay-ui:message key="da-hop" />" />
									<%
										}
									}
									%>
								</td>
							
								<td style="padding-left: 2px;" bgcolor ="<%= duplicateBgr %>"></td>
								<td valign="top" align="left" width="99%">
									<font class="textinfoCal" color="#000080"><b><%= LanguageUtil.get(pageContext, "content") %>:</b>
									<%
									if (!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)) { 
									%>
										&nbsp; <%= event.getTitle() %>
									<% 
									}
									%>
									<font color="black">&nbsp;
									<%
									String title = StringPool.BLANK;
									int indexKeywordQuot = -1;			
									int indexKeywordBr = -1;
									indexKeywordQuot = event.getDescription().toLowerCase().indexOf("&#039;");
									indexKeywordBr = event.getDescription().toLowerCase().indexOf("\n");
									if (indexKeywordQuot != -1) {
										title = event.getDescription().replaceAll("&#039;","&quot;");
									}
									if (indexKeywordBr != -1) {
										if (!title.equals(StringPool.BLANK)) {
											title = title.replaceAll("\n","<br />");
										}
										else {
											title = event.getDescription().replaceAll("\n","<br />");
										}
									}
									if (!title.equals(StringPool.BLANK)) {
									%>
										<%= title%>
									<%
									}
									else {
									%>
										<%= event.getDescription()%> 
									<%
									}
									%>
									&nbsp;
									<%
									if (Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())) { 
									%>
										<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tai-noi") %>:</font>&nbsp; <%= Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff() %>
									<%
									}
									%>
									<br>
									<%
									if (Validator.isNotNull(mcal.getComponent())) { 
									%>
										<font class="textinfoCal" color="#000080">TP:</font>&nbsp; <%= mcal.getComponent() %><br>
									<%
									}
									%>
									<%
									if (Validator.isNotNull(mcal.getNote())) { 
									%>
										<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "note") %>:</font>&nbsp;<%=mcal.getNote() %><Br>
									<%
									} 
									%>
									<%
									if (Validator.isNotNull(event.getUserName()) && tabs1_.equals("approved-calendar")) { 
										User user1 = UserLocalServiceUtil.getUser(event.getUserId());
									%>
										<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "entrant") %>:</font>&nbsp;<%= user1.getScreenName() %><Br>
									<%
									} 
									%>
									<%
									if (Validator.isNotNull(mcal.getFilename())) { 
									%>
										<%@ include file="/html/portlet/ext/meeting_calendar/meeting_calendar_download.jsp" %>
									<br />
									<%
									} 
									%>
									<%
									String tinh_trang = "";
									if (checkUser) {
										if (mcal.getState() == MeetingCalendarKey.CHO_DUYET) {
											tinh_trang = "<font color='red'><b>" + LanguageUtil.get(pageContext, "cho-duyet") + "</b></font>";
										}
										else if (mcal.getState() == MeetingCalendarKey.DA_DUYET) {
											tinh_trang = "<font color='blue'><b>" + LanguageUtil.get(pageContext, "da-duyet") + "</b></font>";
										}
									%>
										<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tinh-trang") %>:</font>&nbsp;<%= tinh_trang %>
									<%
									}
									%>
								</td>
							</tr>
				<%
						}//end if
					}//end kt event co trong 2 bang
				} // end if
			}//end lich cho duyet va da duyet
			%>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<c:if test="<%=(eventsDoi.size()!= 0) || (eventsHuy.size()!= 0)%>">
				<tr>
					<td colspan="3">
						<div class="separator"><!-- --></div>
					</td>
				</tr>
			</c:if>
			<c:if test="<%= eventsDoi.size() != 0%>">
				<tr>
					<td colspan="3">
						<a class="repeat" onclick="<portlet:namespace />showHideDoiHop('<portlet:namespace />showHideDoiHop_<%= randomNamespace %>');"><liferay-ui:message key="doi-hop"/></a>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div id="<portlet:namespace />showHideDoiHop_<%= randomNamespace %>" class="div" style="display: <%= (showDoiHop.equalsIgnoreCase("true")) ? "block" : "none" %>;">
						<table>
						<%
						// list lich doi hop
						for (int j = 0; j < eventsDoi.size(); j++) {
							CalEvent event = (CalEvent)eventsDoi.get(j);
							if (event != null) {
								MeetingCalendar mcal = null;
								try {
									mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
								}
								catch (Exception ex) {
									mcal = null;
								}
								// kt event chi co trong 1 bang
								if (mcal != null) {
									boolean showCalendar = false;
									if (checkUser) {
										showCalendar = true;
									}
									else {
										if (mcal.getState()!= 0) {
											showCalendar = true;
										}
									}
									// isTimeZoneSensitive is true
									Date stEvent = null;
									if (event.isTimeZoneSensitive()) {
										stEvent = Time.getDate(event.getStartDate(), timeZone);
									}
									else {
										stEvent = event.getStartDate();
									}
									
									if (stEvent.getHours() <= 12 && showCalendar) {
										%>
										<tr>
											<td align="center" nowrap class="nameContent" valign="top" width="20%">
												<i>
												<c:choose>
													<c:when test="<%= event.isAllDay() %>">
														<liferay-ui:message key="all-day" />
													</c:when>
													<%-- xuancong close
													<c:when test="<%= mcal.isMorning() || mcal.isAfternoon() || mcal.isEvening() %>">
														
													</c:when>
													--%>
													<c:when test="<%= mcal.isMorning() %>">
														<liferay-ui:message key="buoi-sang" />
													</c:when>
													<c:when test="<%= mcal.isAfternoon() %>">
														<liferay-ui:message key="buoi-chieu" />
													</c:when>
													<c:when test="<%= event.isTimeZoneSensitive() %>">
														<%= dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)) %>
													</c:when>
													<c:otherwise>
														<%= dateFormatTime.format(event.getStartDate()) %>
													</c:otherwise>
												</c:choose>
												</i>
											</td>
											<td  style="padding-left: 2px;" bgcolor ="<%=duplicateBgr %>"></td>
											<td valign="top" align="left" width="99%">
												<i>
												<font class="textinfoCal" color="#000080"><b><%= LanguageUtil.get(pageContext, "content") %>:</b>
												<%
												if (!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)) { 
												%>
													&nbsp;<%= event.getTitle() %>
												<% 
												}
												%>
												<font color="black">&nbsp;
												<%
												String title = StringPool.BLANK;
												int indexKeywordQuot = -1;			
												int indexKeywordBr = -1;
												indexKeywordQuot = event.getDescription().toLowerCase().indexOf("&#039;");
												indexKeywordBr = event.getDescription().toLowerCase().indexOf("\n");
												if (indexKeywordQuot != -1) {
													title = event.getDescription().replaceAll("&#039;","&quot;");
												}
												if (indexKeywordBr != -1) {
													if (!title.equals(StringPool.BLANK)) {
														title = title.replaceAll("\n","<br />");
													}
													else {
														title = event.getDescription().replaceAll("\n","<br />");
													}
												}
												if (!title.equals(StringPool.BLANK)) {
												%>
													<%= title%>
												<%
												}
												else {
												%>
													<%= event.getDescription()%> 
												<%
												}
												%>
												&nbsp;
												<%
												if (Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())) { 
												%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tai-noi") %>:</font>&nbsp; <%= Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff() %>
												<%
												} 
												%>
												<br>
												<%
												if (Validator.isNotNull(mcal.getComponent())) { 
												%>
													<font class="textinfoCal" color="#000080">TP:</font>&nbsp; <%= mcal.getComponent() %><br>
												<%
												}
												%>
												<%
												if (Validator.isNotNull(mcal.getNote())) { 
												%>
													<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "note") %>:</font>&nbsp;<%=mcal.getNote() %><Br>
												<%
												} 
												%>
												<%
												if (Validator.isNotNull(event.getUserName()) && tabs1_.equals("approved-calendar")) { 
													User user1 = UserLocalServiceUtil.getUser(event.getUserId());
												%>
													<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "entrant") %>:</font>&nbsp;<%= user1.getScreenName() %><Br>
												<%
												} 
												%>
												<%
												String tinh_trang = "";
												CalEvent moveEvent = null;
												try {
													moveEvent = CalEventLocalServiceUtil.getEvent(mcal.getMoveMcalId());
												}
												catch (Exception e) {
												}
												if (moveEvent!=null) {
													Calendar moveSelCal = null;
													try {
														moveSelCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
													}
													catch (Exception e) {
													}
													if (moveSelCal!=null) {
														moveSelCal.set(Calendar.YEAR, moveEvent.getStartDate().getYear()+ 1900);
														moveSelCal.set(Calendar.DATE, 1);
														moveSelCal.set(Calendar.MONTH, moveEvent.getStartDate().getMonth());
														moveSelCal.set(Calendar.DATE, moveEvent.getStartDate().getDate());
														Calendar move_cal = (Calendar)moveSelCal.clone();
														tinh_trang = "<font color='#004000'><b>" + LanguageUtil.get(pageContext, "doi-sang") + "&nbsp;" + dateFormatTime.format(Time.getDate(moveEvent.getStartDate(), timeZone)) + "&nbsp;" + LanguageUtil.get(pageContext, "ngay") + "&nbsp;" + dateFormatDate.format(Time.getDate(move_cal)) + "</b></font>";
													}
												}
												else {
													tinh_trang = "<font color='#004000'><b>" + LanguageUtil.get(pageContext, "doi-hop") + "</b></font>";
												}
												%>
													<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tinh-trang") %>:</font>&nbsp;<%=tinh_trang %>
												</i>
											</td>
										</tr>
						<%
									}//end if
								}//end kt event co trong 2 bang
							} // end if 
						}//end lich doi hop
						%>
						</table>
						</div>
					</td>
				</tr>
			</c:if>
			<c:if test="<%= eventsHuy.size() != 0%>">
				<tr>
					<td colspan="3">
						<a class="repeat" onclick="<portlet:namespace />showHideHuyHop('<portlet:namespace />showHideHuyHop_<%= randomNamespace %>');"><liferay-ui:message key="huy-hop"/></a>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div id="<portlet:namespace />showHideHuyHop_<%= randomNamespace %>" class="div" style="display: <%= (showHuyHop.equalsIgnoreCase("true")) ? "block" : "none" %>;">
						<table>
						<%
						// list lich huy
						for (int j = 0; j < eventsHuy.size(); j++) {
							CalEvent event = (CalEvent)eventsHuy.get(j);
							if (event != null) {
								MeetingCalendar mcal = null;
								try {
									mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
								}
								catch (Exception ex) {
									mcal = null;
								}
								// kt event chi co trong 1 bang
								if (mcal != null) {
									boolean showCalendar = false;
									if (checkUser) {
										showCalendar = true;
									}
									else {
										if (mcal.getState() != 0) {
											showCalendar = true;
										}
									}
									// isTimeZoneSensitive is true
									Date stEvent = null;
									if (event.isTimeZoneSensitive()) {
										stEvent = Time.getDate(event.getStartDate(), timeZone);
									}
									else {
										stEvent = event.getStartDate();
									}
									if (stEvent.getHours() <= 12 && showCalendar) {
										%>
										<tr>
											<td align="center" nowrap class="nameContent" valign="top" width="20%">
												<i>
												<c:choose>
													<c:when test="<%= event.isAllDay() %>">
														<liferay-ui:message key="all-day" />
													</c:when>
													<%-- xuancong close
													<c:when test="<%= mcal.isMorning() || mcal.isAfternoon() || mcal.isEvening() %>">
														
													</c:when>
													--%>
													<c:when test="<%= mcal.isMorning() %>">
														<liferay-ui:message key="buoi-sang" />
													</c:when>
													<c:when test="<%= mcal.isAfternoon() %>">
														<liferay-ui:message key="buoi-chieu" />
													</c:when>
													<c:when test="<%= event.isTimeZoneSensitive() %>">
														<%= dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)) %>
													</c:when>
													<c:otherwise>
														<%= dateFormatTime.format(event.getStartDate()) %>
													</c:otherwise>
												</c:choose>
												</i>
												<br>
												<%
												if (checkUser) { 
												%>
													<%@ include file="/html/portlet/ext/meeting_calendar/meeting_calendar_action.jsp" %>
												<%
												}
												%>
											</td>
											<td style="padding-left: 2px;" bgcolor ="<%=duplicateBgr %>"></td>
											<td valign="top" align="left" width="99%">
												<i>
												<font class="textinfoCal" color="#000080"><b><%= LanguageUtil.get(pageContext, "content") %>:</b>
												<%
												if (!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)) { 
												%>
													&nbsp;<%= event.getTitle() %>
												<% 
												}
												%>
												<font color="black">&nbsp;
												<%
												String title = StringPool.BLANK;
												int indexKeywordQuot = -1;			
												int indexKeywordBr = -1;
												indexKeywordQuot = event.getDescription().toLowerCase().indexOf("&#039;");
												indexKeywordBr = event.getDescription().toLowerCase().indexOf("\n");
												if (indexKeywordQuot != -1) {
													title = event.getDescription().replaceAll("&#039;","&quot;");
												}
												if (indexKeywordBr != -1) {
													if (!title.equals(StringPool.BLANK)) {
														title = title.replaceAll("\n","<br />");
													}
													else {
														title = event.getDescription().replaceAll("\n","<br />");
													}
												}
												if (!title.equals(StringPool.BLANK)) {
												%>
													<%= title %>
												<%
												}
												else {
												%>
													<%= event.getDescription()%> 
												<%
												}
												%>
												&nbsp;
												<%
												if (Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())) { 
												%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tai-noi") %>:</font>&nbsp; <%= Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff() %>
												<%
												} 
												%>
												<br>
												<%
												if (Validator.isNotNull(mcal.getComponent())) { 
												%>
													<font class="textinfoCal" color="#000080">TP:</font>&nbsp; <%= mcal.getComponent() %><br>
												<%
												} 
												%>
												<%
												if (Validator.isNotNull(mcal.getNote())) { 
												%>
													<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "note") %>:</font>&nbsp;<%=mcal.getNote() %><Br>
												<%
												} 
												%>
												<%
												if (Validator.isNotNull(event.getUserName()) && tabs1_.equals("approved-calendar")) { 
													User user1 = UserLocalServiceUtil.getUser(event.getUserId());
												%>
													<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "entrant") %>:</font>&nbsp;<%= user1.getScreenName() %><Br>
												<%
												} 
												%>
												<%
												String tinh_trang = "";
												tinh_trang = "<font color='#004000'><b>" + LanguageUtil.get(pageContext, "huy-hop") + "</b></font>";
												%>
													<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tinh-trang") %>:</font>&nbsp;<%=tinh_trang %>
												</i>
											</td>
										</tr>
								<%
									}//end if
								}//end kt event co trong 2 bang
							} // end if
						}//end list lich huy hop
						%>
						</table>
						</div>
					</td>
				</tr>
			</c:if>
			</table>
		</td>
		<!-- HIEN THI BUOI CHIEU TOI -->
		<td class="portlet-font" valign="top" width="45%">
			<table border="0" cellpadding="0" cellspacing="0" width="100%" id='<%= ((tabs1_.equals("approved-calendar")) && ((cal.getTime().equals(curCal.getTime())) || (cal.getTime().after(curCal.getTime()))) && PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(),MeetingCalendarKey.ORDER)) ? "chieu_"+mcaltype+"_"+i : ""%>'>
			<%
			String randomNamespace_E = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
			String duplicateBgr_E = StringPool.BLANK;
			String nightBgr_E = StringPool.BLANK;
			
			// list lich cho duyet va da duyet
			for (int k = 0; k < eventsDuyet_E.size(); k++) {
				CalEvent event_E = (CalEvent)eventsDuyet_E.get(k);
				//event_E = event_E.toEscapedModel();
				MeetingCalendar mcal_E = null;
				try {
					mcal_E = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event_E.getEventId());
				}
				catch (Exception ex) {
					mcal_E = null;
				}
				// kt khi event chi them vao trong 1 bang
				if (mcal_E != null) {		
					boolean showCalendar_E = false;
					if (checkUser) {
						showCalendar_E = true;
					}
					else {
						if (mcal_E.getState() != 0) {
							showCalendar_E = true;
						}
					}
					// isTimeZoneSensitive is true
					Date stEvent_E = null;
					if (event_E.isTimeZoneSensitive()) {
						stEvent_E = Time.getDate(event_E.getStartDate(), timeZone);
					}
					else {
						stEvent_E = event_E.getStartDate();
					}
					if (stEvent_E.getHours() > 12 && showCalendar_E) {
						Iterator itr_E = events.iterator();
						while (itr_E.hasNext()) {
							duplicateBgr_E = "";
							CalEvent itrCal_E = (CalEvent)itr_E.next();
							MeetingCalendar itrMcal_E = null;
							try {
								itrMcal_E = MeetingCalendarLocalServiceUtil.getMeetingCalendar(itrCal_E.getEventId());
							}
							catch (Exception ex) {
								itrMcal_E = null;
							}
							if (itrMcal_E != null) {
								// DuyDuong add: isTimeZoneSensitive is true
								Date stCal_E = null;
								if (itrCal_E.isTimeZoneSensitive()) {
									stCal_E = Time.getDate(itrCal_E.getStartDate(), timeZone);
								}
								else {
									stCal_E = itrCal_E.getStartDate();
								}
								if ((itrCal_E.getEventId() != event_E.getEventId()) && (stCal_E.getHours() > 12)) {
									if (stCal_E.getHours() > stEvent_E.getHours()) {
										if (((itrCal_E.getStartDate().getTime() - CalUtil.getEndTime(event_E).getTime()) < 0) 
											&& (((Validator.isNotNull(mcal_E.getPlace())) && (mcal_E.getPlace().equals(itrMcal_E.getPlace())))
											|| ((Validator.isNotNull(mcal_E.getPlace_diff())) && (mcal_E.getPlace_diff().equals(itrMcal_E.getPlace_diff())))) ) {
											duplicateBgr_E = "red";
											if (tabs1_.equals("calendar-release")) {
												duplicateBgr_E = itrMcal_E.getState() == MeetingCalendarKey.DA_DUYET? "red":"";
											}
											break;
										}
										else {
											duplicateBgr_E = "";
										}
									}
									else {
										if (((event_E.getStartDate().getTime() - CalUtil.getEndTime(itrCal_E).getTime())<0) 
											&& (((Validator.isNotNull(mcal_E.getPlace())) && (mcal_E.getPlace().equals(itrMcal_E.getPlace())))
											|| ((Validator.isNotNull(mcal_E.getPlace_diff())) && (mcal_E.getPlace_diff().equals(itrMcal_E.getPlace_diff())))) ) {
											duplicateBgr_E = "red";
											if (tabs1_.equals("calendar-release")) {
												duplicateBgr_E = itrMcal_E.getState() == MeetingCalendarKey.DA_DUYET? "red":"";
											}
											break;
										}
										else {
											duplicateBgr_E = "";
										}	
									}
								} 
							}
						}
						nightBgr_E = StringPool.BLANK;
						if (stEvent_E.getHours() >= 17) {
							nightBgr_E = "background-color:#F5F5DC;";
						}
						%>
						<%
						boolean prior_E = mcal_E.getPrior();
						String bgPrior_E = "";
						if (prior_E) {
							bgPrior_E = "#EFEFDE";
						}
						%>										
						
						<tr id='<%=mcal_E.getMcalId()+"_"+(k+1)%>' bgcolor="<%= bgPrior_E%>">
							<td nowrap valign="top" class="nameContent" style="<%= nightBgr_E%>" align="center" width="20%">
								<c:choose>
									<c:when test="<%= event_E.isAllDay() %>">
										<liferay-ui:message key="all-day" />
									</c:when>
									<%-- xuancong close
									<c:when test="<%= mcal_E.isMorning() || mcal_E.isAfternoon() || mcal_E.isEvening() %>">
										
									</c:when>
									--%>
									<c:when test="<%= mcal_E.isMorning() %>">
										<liferay-ui:message key="buoi-sang" />
									</c:when>
									<c:when test="<%= mcal_E.isAfternoon() %>">
										<liferay-ui:message key="buoi-chieu" />
									</c:when>
									<c:when test="<%= event_E.isTimeZoneSensitive() %>">
										<%= dateFormatTime.format(Time.getDate(event_E.getStartDate(), timeZone)) %>
									</c:when>
									<c:otherwise>
										<%= dateFormatTime.format(event_E.getStartDate()) %>
									</c:otherwise>
								</c:choose>
								<br>
								<%
								if (checkUser && checkDateNow) { 
								%>	
									<%@ include file="/html/portlet/ext/meeting_calendar/meeting_calendar_action_E.jsp" %>
									<br />
									<% 
									if (PortletPermissionUtil.contains(permissionChecker, plid.longValue(),portletDisplay.getId(),MeetingCalendarKey.ORDER)) {
									%>
									<img src="/html/portlet/ext/meeting_calendar/updown2.gif"/>
									<br />
								<%
									}
								}
								else {
									if ((nowDate.getTime() - event_E.getStartDate().getTime()) > 0 && (nowDate.getTime() - CalUtil.getEndTime(event_E).getTime()) < 0 && (mcal_E.getState() == MeetingCalendarKey.DA_DUYET)) {
								%>
										<img border="0" src="/html/portlet/ext/meeting_calendar/iDangHop.gif" title="<liferay-ui:message key="dang-hop" />" />
								<%
									}
									else if ((nowDate.getTime() - CalUtil.getEndTime(event_E).getTime()) >= 0 && mcal_E.getState() == MeetingCalendarKey.DA_DUYET) {
								%>
										<img border="0" src="/html/portlet/ext/meeting_calendar/iDaHop.gif" title="<liferay-ui:message key="da-hop" />" />
								<%
									}
								}
								%>
							</td>
							<td style="padding-left: 2px;<%= nightBgr_E%>" bgcolor="<%=duplicateBgr_E%>"></td>
							<td valign="top" width="99%" style="<%= nightBgr_E%>">
								<font class="textinfoCal" color="#000080"><b><%= LanguageUtil.get(pageContext, "content") %>:</b>
								<%
								if (!event_E.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)) { 
								%>
									&nbsp; <%= event_E.getTitle() %>
								<%
								} 
								%>
								<font color="black">&nbsp;
								<%
								String title_E = StringPool.BLANK;
								int indexKeywordQuot = -1;			
								int indexKeywordBr = -1;
								indexKeywordQuot = event_E.getDescription().toLowerCase().indexOf("&#039;");
								indexKeywordBr = event_E.getDescription().toLowerCase().indexOf("\n");
								if (indexKeywordQuot != -1) {
									title_E = event_E.getDescription().replaceAll("&#039;","&quot;");
								}
								if (indexKeywordBr != -1) {
									if (!title_E.equals(StringPool.BLANK)) {
										title_E = title_E.replaceAll("\n","<br />");
									}
									else {
										title_E = event_E.getDescription().replaceAll("\n","<br />");
									}
								}
								if (!title_E.equals(StringPool.BLANK)) {
								%>
									<%= title_E%>
								<%
								}
								else {
								%>
									<%= event_E.getDescription()%> 
								<%
								}
								%>
								&nbsp;
								<%
								if (Validator.isNotNull(mcal_E.getPlace()) || Validator.isNotNull(mcal_E.getPlace_diff())) { 
								%>
									<%= LanguageUtil.get(pageContext, "tai-noi") %>:&nbsp; <%= Validator.isNotNull(mcal_E.getPlace()) ? LanguageUtil.get(pageContext, mcal_E.getPlace()): mcal_E.getPlace_diff() %>
								<%
								} 
								%>
								<br>
								<%
								if (Validator.isNotNull(mcal_E.getComponent())) { 
								%>
									<font class="textinfoCal" color="#000080">TP:</font>&nbsp; <%= mcal_E.getComponent() %><br>
								<%
								} 
								%>
								<%
								if (Validator.isNotNull(mcal_E.getNote())) { 
								%>
									<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "note") %>:</font>&nbsp;<%=mcal_E.getNote() %><Br>
								<%
								} 
								%>
								<%
								if (Validator.isNotNull(event_E.getUserName()) && tabs1_.equals("approved-calendar")) { 
									User user1 = UserLocalServiceUtil.getUser(event_E.getUserId());
								%>
									<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "entrant") %>:</font>&nbsp;<%= user1.getScreenName() %><Br>
								<%
								} 
								%>
								<%
								if (Validator.isNotNull(mcal_E.getFilename())) { 
								%>
									<%@ include file="/html/portlet/ext/meeting_calendar/meeting_calendar_download_E.jsp" %>
								<br />
								<%
								} 

								String tinh_trang_E = "";
								if (tabs1_.equals("approved-calendar")) {
									if (mcal_E.getState() == MeetingCalendarKey.CHO_DUYET) {
										tinh_trang_E = "<font color='red'><b>" + LanguageUtil.get(pageContext, "cho-duyet") + "</b></font>";
									}
									else if (mcal_E.getState() == MeetingCalendarKey.DA_DUYET) {
										tinh_trang_E = "<font color='blue'><b>" + LanguageUtil.get(pageContext, "da-duyet") + "</b></font>";
									}
								 %>
										<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tinh-trang") %>:</font>&nbsp;<%= tinh_trang_E %><Br>
								<%
								}
								%>
							</td>
						</tr>
				<%
					}//end if
				}//end kt event co trong 2 bang
			}//end lich cho duyet va da duyet
			%>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<c:if test="<%=(eventsDoi_E.size()!= 0) || (eventsHuy_E.size()!= 0)%>">
				<tr>
					<td colspan="3">
						<div class="separator"><!-- --></div>
					</td>
				</tr>
			</c:if>
			<c:if test="<%= eventsDoi_E.size() != 0%>">
				<tr>
					<td colspan="3">
						<a class="repeat" onclick="<portlet:namespace />showHideDoiHop('<portlet:namespace />showHideDoiHop_<%= randomNamespace_E %>');"><liferay-ui:message key="doi-hop"/></a>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div id="<portlet:namespace />showHideDoiHop_<%= randomNamespace_E %>" class="div" style="display: <%= (showDoiHop.equalsIgnoreCase("true")) ? "block" : "none" %>;">
						<table>
						<%
						// list lich doi hop
						for (int k = 0; k < eventsDoi_E.size(); k++) {
							CalEvent event_E = (CalEvent)eventsDoi_E.get(k);
							event_E = event_E.toEscapedModel();
							MeetingCalendar mcal_E = null;
							try {
								mcal_E = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event_E.getEventId());
							}
							catch (Exception ex) {
								mcal_E = null;
							}
							// kt khi event chi them vao trong 1 bang
							if (mcal_E != null) {		
								boolean showCalendar_E = false;
								if (checkUser) {
									showCalendar_E = true;
								}
								else {
									if (mcal_E.getState()!= 0) {
										showCalendar_E = true;
									}
								}
								// isTimeZoneSensitive is true
								Date stEvent_E = null;
								if (event_E.isTimeZoneSensitive()) {
									stEvent_E = Time.getDate(event_E.getStartDate(), timeZone);
								}
								else {
									stEvent_E = event_E.getStartDate();
								}
								if (stEvent_E.getHours() > 12 && showCalendar_E) {
								%>
									<tr>
										<td nowrap valign="top" class="nameContent" align="center" width="20%">
											<i>
											<c:choose>
												<c:when test="<%= event_E.isAllDay() %>">
													<liferay-ui:message key="all-day" />
												</c:when>
												<%-- xuancong close
												<c:when test="<%= mcal_E.isMorning() || mcal_E.isAfternoon() || mcal_E.isEvening() %>">
													
												</c:when>
												--%>
												<c:when test="<%= mcal_E.isMorning() %>">
													<liferay-ui:message key="buoi-sang" />
												</c:when>
												<c:when test="<%= mcal_E.isAfternoon() %>">
													<liferay-ui:message key="buoi-chieu" />
												</c:when>
												<c:when test="<%= event_E.isTimeZoneSensitive() %>">
													<%= dateFormatTime.format(Time.getDate(event_E.getStartDate(), timeZone)) %>
												</c:when>
												<c:otherwise>
													<%= dateFormatTime.format(event_E.getStartDate()) %>
												</c:otherwise>
											</c:choose>
											</i>
										</td>
										<td style="padding-left: 2px;" bgcolor="<%=duplicateBgr_E%>"></td>
										<td valign="top" width="99%">
											<i>
											<font class="textinfoCal" color="#000080"><b><%= LanguageUtil.get(pageContext, "content") %>:</b>
											<%
											if (!event_E.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)) { 
											%>
												&nbsp; <%= event_E.getTitle() %>
											<%
											} 
											%>
											<font color="black">&nbsp;
											<%
											String title_E = StringPool.BLANK;
											int indexKeywordQuot = -1;			
											int indexKeywordBr = -1;
											indexKeywordQuot = event_E.getDescription().toLowerCase().indexOf("&#039;");
											indexKeywordBr = event_E.getDescription().toLowerCase().indexOf("\n");
											if (indexKeywordQuot != -1) {
												title_E = event_E.getDescription().replaceAll("&#039;","&quot;");
											}
											if (indexKeywordBr != -1) {
												if (!title_E.equals(StringPool.BLANK)) {
													title_E = title_E.replaceAll("\n","<br />");
												}
												else {
													title_E = event_E.getDescription().replaceAll("\n","<br />");
												}
											}
											if (!title_E.equals(StringPool.BLANK)) {
											%>
												<%= title_E%>
											<%
											}
											else {
												String descDoi = event_E.getDescription();
												descDoi = descDoi.replaceAll("&lt;", "<");
												descDoi = descDoi.replaceAll("&gt;", ">");
												descDoi = descDoi.replaceAll("\\<.*?\\>", "");
												descDoi = descDoi.replaceAll("'", "&quot;");
												descDoi = descDoi.replaceAll("\n", "<br />");
											%>
												<%= descDoi %> 
											<%
											}
											%>
											&nbsp;
											<%if (Validator.isNotNull(mcal_E.getPlace()) || Validator.isNotNull(mcal_E.getPlace_diff())) { %>
											<%= LanguageUtil.get(pageContext, "tai-noi") %>:&nbsp; <%= Validator.isNotNull(mcal_E.getPlace()) ? LanguageUtil.get(pageContext, mcal_E.getPlace()): mcal_E.getPlace_diff() %>
											<%
											} %>
											<br>
											<%
											if (Validator.isNotNull(mcal_E.getComponent())) { 
											%>
												<font class="textinfoCal" color="#000080">TP:</font>&nbsp; <%= mcal_E.getComponent() %><br>
											<%
											} 
											%>
											<%
											if (Validator.isNotNull(event_E.getUserName()) && tabs1_.equals("approved-calendar")) { 
												User user1 = UserLocalServiceUtil.getUser(event_E.getUserId());
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "entrant") %>:</font>&nbsp;<%= user1.getScreenName() %><Br>
											<%
											} 
											%>
											<%
											if (Validator.isNotNull(mcal_E.getNote())) { 
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "note") %>:</font>&nbsp;<%=mcal_E.getNote() %><Br>
											<%
											} 

											String tinh_trang_E = "";
											CalEvent moveEvent_E = null;
											try {
												moveEvent_E = CalEventLocalServiceUtil.getEvent(mcal_E.getMoveMcalId());
											}
											catch (Exception e) {
											
											}
											if (moveEvent_E != null) {
												Calendar moveSelCal_E = null;
												try {
													moveSelCal_E = CalendarFactoryUtil.getCalendar(timeZone, locale);
												}
												catch (Exception e) {
												}
												if (moveSelCal_E != null) {
													moveSelCal_E.set(Calendar.YEAR, moveEvent_E.getStartDate().getYear()+ 1900);
													moveSelCal_E.set(Calendar.DATE, 1);
													moveSelCal_E.set(Calendar.MONTH, moveEvent_E.getStartDate().getMonth());
													moveSelCal_E.set(Calendar.DATE, moveEvent_E.getStartDate().getDate());
													Calendar move_cal_E = (Calendar)moveSelCal_E.clone();
													tinh_trang_E = "<font color='#004000'><b>" + LanguageUtil.get(pageContext, "doi-sang") + "&nbsp;" + dateFormatTime.format(Time.getDate(moveEvent_E.getStartDate(), timeZone)) + "&nbsp;" + LanguageUtil.get(pageContext, "ngay") + "&nbsp;" + dateFormatDate.format(Time.getDate(move_cal_E)) + "</b></font>";
												}
											}
											else {
												tinh_trang_E = "<font color='#004000'><b>" + LanguageUtil.get(pageContext, "doi-hop") + "</b></font>";
											}
											 %>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tinh-trang") %>:</font>&nbsp;<%= tinh_trang_E %><Br>											
											</i>
										</td>
									</tr>
							<%
								}//end if
							}//end kt event co trong 2 bang
						}//end lich doi hop
						%>
						</table>
						</div>
					</td>
				</tr>
			</c:if>
			<c:if test="<%= eventsHuy_E.size() != 0%>">
				<tr>
					<td colspan="3">
						<a class="repeat" onclick="<portlet:namespace />showHideHuyHop('<portlet:namespace />showHideHuyHop_<%= randomNamespace_E %>');"><liferay-ui:message key="huy-hop"/></a>
					</td>
				</tr>
				<tr>
					<td colspan="3">
						<div id="<portlet:namespace />showHideHuyHop_<%= randomNamespace_E %>" class="div" style="display: <%= (showHuyHop.equalsIgnoreCase("true")) ? "block" : "none" %>;">
						<table>
						<%
						// list lich huy
						for (int k = 0; k < eventsHuy_E.size(); k++) {
							CalEvent event_E = (CalEvent)eventsHuy_E.get(k);
							event_E = event_E.toEscapedModel();
							MeetingCalendar mcal_E = null;
							try {
								mcal_E = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event_E.getEventId());
							}
							catch (Exception ex) {
								mcal_E = null;
							}
							// kt khi event chi them vao trong 1 bang
							if (mcal_E != null) {		
								boolean showCalendar_E = false;
								if (checkUser) {
									showCalendar_E = true;
								}
								else {
									if (mcal_E.getState() != 0) {
										showCalendar_E = true;
									}
								}
								// isTimeZoneSensitive is true
								Date stEvent_E = null;
								if (event_E.isTimeZoneSensitive()) {
									stEvent_E = Time.getDate(event_E.getStartDate(), timeZone);
								}
								else {
									stEvent_E = event_E.getStartDate();
								}
								if (stEvent_E.getHours() > 12 && showCalendar_E) {
								%>
									<tr>
										<td nowrap valign="top" class="nameContent" align="center" width="20%">
											<i>
											<c:choose>
												<c:when test="<%= event_E.isAllDay() %>">
													<liferay-ui:message key="all-day" />
												</c:when>
												<%-- xuancong close
												<c:when test="<%= mcal_E.isMorning() || mcal_E.isAfternoon() || mcal_E.isEvening() %>">
													
												</c:when>
												--%>
												<c:when test="<%= mcal_E.isMorning() %>">
													<liferay-ui:message key="buoi-sang" />
												</c:when>
												<c:when test="<%= mcal_E.isAfternoon() %>">
													<liferay-ui:message key="buoi-chieu" />
												</c:when>
												<c:when test="<%= event_E.isTimeZoneSensitive() %>">
													<%= dateFormatTime.format(Time.getDate(event_E.getStartDate(), timeZone)) %>
												</c:when>
												<c:otherwise>
													<%= dateFormatTime.format(event_E.getStartDate()) %>
												</c:otherwise>
											</c:choose>
											</i>	
											<br>
											<%
											if (checkUser) { 
											%>	
												<%@ include file="/html/portlet/ext/meeting_calendar/meeting_calendar_action_E.jsp" %>
											<%
											}
											%>
										</td>
										
										<td style="padding-left: 2px;" bgcolor="<%=duplicateBgr_E%>"></td>
										<td valign="top" width="99%">
											<i>
											<font class="textinfoCal" color="#000080"><b><%= LanguageUtil.get(pageContext, "content") %>:</b>
											<%
											if (!event_E.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)) { 
											%>
												&nbsp; <%= event_E.getTitle() %>
											<%
											} 
											%>
											<font color="black">&nbsp;
											<%
											String title_E = StringPool.BLANK;
											int indexKeywordQuot = -1;			
											int indexKeywordBr = -1;
											indexKeywordQuot = event_E.getDescription().toLowerCase().indexOf("&#039;");
											indexKeywordBr = event_E.getDescription().toLowerCase().indexOf("\n");
											if (indexKeywordQuot != -1) {
												title_E = event_E.getDescription().replaceAll("&#039;","&quot;");
											}
											if (indexKeywordBr != -1) {
												if (!title_E.equals(StringPool.BLANK)) {
													title_E = title_E.replaceAll("\n","<br />");
												}
												else {
													title_E = event_E.getDescription().replaceAll("\n","<br />");
												}
											}
											if (!title_E.equals(StringPool.BLANK)) {
											%>
												<%= title_E%>
											<%
											}
											else {
											%>
												<%= event_E.getDescription()%> 
											<%
											}
											%>
											&nbsp;
											<%
											if (Validator.isNotNull(mcal_E.getPlace()) || Validator.isNotNull(mcal_E.getPlace_diff())) { 
											%>
											<%= LanguageUtil.get(pageContext, "tai-noi") %>:&nbsp; <%= Validator.isNotNull(mcal_E.getPlace()) ? LanguageUtil.get(pageContext, mcal_E.getPlace()): mcal_E.getPlace_diff() %>
											<%
											} 
											%>
											<br>
											<%
											if (Validator.isNotNull(mcal_E.getComponent())) { 
											%>
												<font class="textinfoCal" color="#000080">TP:</font>&nbsp; <%= mcal_E.getComponent() %><br>
											<%
											} 
											%>
											<%
											if (Validator.isNotNull(mcal_E.getNote())) { 
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "note") %>:</font>&nbsp;<%=mcal_E.getNote() %><Br>
											<%
											} 
											%>
											<%
											if (Validator.isNotNull(event_E.getUserName()) && tabs1_.equals("approved-calendar")) { 
												User user1 = UserLocalServiceUtil.getUser(event_E.getUserId());
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "entrant") %>:</font>&nbsp;<%= user1.getScreenName() %><Br>
											<%
											} 

											String tinh_trang_E = "";
											tinh_trang_E = "<font color='#004000'><b>" + LanguageUtil.get(pageContext, "huy-hop") + "</b></font>";
										 	%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tinh-trang") %>:</font>&nbsp;<%= tinh_trang_E %><Br>
											</i>
										</td>
									</tr>
							<%
								}//end if
							}//end kt event co trong 2 bang
						}//end list lich huy hop
						%>
						</table>
						</div>
					</td>
				</tr>
			</c:if>
			</table>
		</td>
	</tr>
<%
	cal.add(Calendar.DATE, 1);
}
%>
</table>

<%
	// lich phuong ko co lich phu
	if (portletGroupId.longValue() != 14) {
		break;
	}
}
%>
</div>
</div>
</form>
	
<script language="javascript">
	
	function <portlet:namespace />showHideAdvance(objShowHide) {
		if (objShowHide && objShowHide!="") {
			var obj = window.document.getElementById(objShowHide + "");
			
			if (obj && obj.style) {
				if (obj.style.display == "block") {
					obj.style.display = "none";
					document.<portlet:namespace />fm.<portlet:namespace />showAdvance.value = "false";
				}
				else {
					obj.style.display = "block";
					document.<portlet:namespace />fm.<portlet:namespace />showAdvance.value = "true";
				}
			}
		}
	}
	
	function <portlet:namespace />showHideDoiHop(objShowHide) {
		if (objShowHide && objShowHide!="") {
			var obj = window.document.getElementById(objShowHide + "");
			
			if (obj && obj.style) {
				if (obj.style.display == "block") {
					obj.style.display = "none";
				}
				else {
					obj.style.display = "block";
				}
			}
		}
	}
	
	function <portlet:namespace />showHideHuyHop(objShowHide) {
		if (objShowHide && objShowHide!="") {
			var obj = window.document.getElementById(objShowHide + "");
			
			if (obj && obj.style) {
				if (obj.style.display == "block") {
					obj.style.display = "none";
				}
				else {
					obj.style.display = "block";
				}
			}
		}
	}
</script>