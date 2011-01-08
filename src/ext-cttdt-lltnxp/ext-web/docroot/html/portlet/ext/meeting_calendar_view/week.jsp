<%@ page import="java.util.regex.*" %>
<%
String tabs1_ = ParamUtil.getString(request, "tabs1", tabs1Default);

Calendar cal = (Calendar)curCal.clone();
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
int firstDayOfWeek = dayOfWeek - 2;

portletURL.setWindowState(WindowState.NORMAL);

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//lay ngay hien tai
String datenow = formatter.format(cal.getTime());
Calendar cale = CalendarFactoryUtil.getCalendar(timeZone, locale);
%>

<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<style>
	.meeting_calendar_bg{
		background:transparent url(/html/portlet/ext/meeting_calendar_view/Lich_files/bg.gif);
	}
</style>
<form method="post" name="<portlet:namespace />fm" class="meeting_calendar_bg">
<input type="hidden" name="<portlet:namespace />tabs1" value="<%= tabs1_ %>" />
<table background="/html/portlet/ext/meeting_calendar_view/Lich_files/bg.gif"  border="1" bordercolor="#0a8d31" style="border-collapse: collapse;" cellpadding="0" cellspacing="0" width="100%">
	<tr bgcolor="#087329" height="25" >
		<!-- <td class="portlet-section-header results-header" style="padding-left: 1px;"></td> -->
		
		<td class="titleCal" align="center" class= "titleCal">
			<%= LanguageUtil.get(pageContext, "thu-ngay").toUpperCase() %>
		</td>
		<!-- <td class="portlet-section-header results-header" style="padding-left: 1px;"></td> -->
		<td class= "titleCal" align="center">
			<font color="white" >
			<%= LanguageUtil.get(pageContext, "buoi-sang").toUpperCase() %></font>
		</td>
		<td class= "titleCal" align="center">
			<font color="white" ><%= LanguageUtil.get(pageContext, "buoi-chieu").toUpperCase() %></font>
		</td>
		<!-- <td class="portlet-section-header results-header" style="padding-left: 1px;"></td> -->
	</tr>
<%
cal = (Calendar)selCal.clone();

// DuyDuong add: get Monday is first on week
dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
firstDayOfWeek = dayOfWeek - 2;
cal.add(Calendar.DATE, -firstDayOfWeek);	

for (int i = 0; i < 7; i++) {
%>

	<!-- <tr>
		<td class="portlet-section-header results-header" colspan="3"></td>
	</tr> -->
	<tr>
		<!-- <td class="portlet-section-header results-header" style="padding-left: 0px;"></td> -->

		<%
		String className = "portlet-font";
		if((i%2)==0){
			className = "nameCal";
		}
		else{
			className = "nameCal_RE";
		}

		if(cal.getTime().before(curCal.getTime())){
			className = "nameCal_OLD";
		}
		%>

		<td class="<%= className %>" valign="top">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<!-- style="font-size: x-small;" -->
				<td class="<%= className %>" align="center" width=100% >
				
					<b><%= user.getLanguageId().equals("vi_VN")? StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))),"Th",LanguageUtil.get(pageContext,"thu-trong-tuan" )):dateFormatDayOfWeek.format(Time.getDate(cal)) %></b><br />
					
					
					<%=dateFormatDate.format(Time.getDate(cal))  %>
				</td>
			</tr>
			</table>
		</td>
		<!-- <td class="portlet-section-header results-header" style="padding-left: 1px;"></td> -->
		<!-- HIEN THI PHAN BUOI SANG -->
		<td valign="top"  width="45%">
			<table border="0"  cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td align="center" >
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
					
					<%
					//xuancong close List events = CalEventLocalServiceUtil.getEvents(portletGroupId.longValue(), cal, eventType);
					// Dung groupId co dinh (sua tam thoi) 
					List events = CalEventLocalServiceUtil.getEvents(32903, cal, eventType);
					
					//xuancong close events = ListUtil.sort(events, new EventTimeComparator(timeZone, locale));
					String duplicateBgr = StringPool.BLANK;
					long calEndFirst = 0;
					
					for (int j = 0; j < events.size(); j++) {
						CalEvent event = (CalEvent)events.get(j);	
						MeetingCalendar mcal = null;
						try{
							mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
						}
						catch(Exception e){
							mcal = null;
						}
						// kt event chi co trong 1 bang
						if(mcal!=null){
							boolean showCalendar = false;
							if(mcal.getState()!= 0){
								showCalendar = true;
							}
							
							
							// DuyDuong add: isTimeZoneSensitive is true
							Date stEvent = null;
							if(event.isTimeZoneSensitive()){
								stEvent = Time.getDate(event.getStartDate(), timeZone);
							}
							else{
								stEvent = event.getStartDate();
							}
							
							if(stEvent.getHours()<=12 && showCalendar){
								Iterator itr = events.iterator();
								while(itr.hasNext() ){
									CalEvent itrCal = (CalEvent)itr.next();
									MeetingCalendar itrMcal = null;
									try{
									itrMcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(itrCal.getEventId());
									}
									catch(Exception e){
										itrMcal = null;
									}
									if(itrMcal!=null){
										if((itrCal.getEventId() != event.getEventId()) && (itrCal.getStartDate().getHours()<=12)){
										
											boolean duplicateRoom = false;
											if(itrCal.getEventId()>event.getEventId()){
												if(((itrCal.getStartDate().getTime() - CalUtil.getEndTime(event).getTime())<0) 
													&& (((Validator.isNotNull(mcal.getPlace())) && (mcal.getPlace().equals(itrMcal.getPlace())))
														|| ((Validator.isNotNull(mcal.getPlace_diff())) && (mcal.getPlace_diff().equals(itrMcal.getPlace_diff())))) ){
														//out.print("BD " + itrCal.getEventId() + "-------" + itrCal.getStartDate().getTime() + "<br>");
													duplicateBgr = "red";
													break;
												}
												else{
													duplicateBgr = "";
												}
											}
											else{
												if(((event.getStartDate().getTime() - CalUtil.getEndTime(itrCal).getTime())<0) 
													&& (((Validator.isNotNull(mcal.getPlace())) && (mcal.getPlace().equals(itrMcal.getPlace())))
														|| ((Validator.isNotNull(mcal.getPlace_diff())) && (mcal.getPlace_diff().equals(itrMcal.getPlace_diff())))) ){
														//out.print("BD " + itrCal.getEventId() + "-------" + itrCal.getStartDate().getTime() + "<br>");
													duplicateBgr = "red";
													break;
												}
												else{
													duplicateBgr = "";
												}
											}
										}
									}
								}
								className = "portlet-section-body results-row";
								String classHoverName = "portlet-section-body-hover results-row hover";
		
								if (MathUtil.isEven(j)) {
									className = "portlet-section-alternate results-row alt";
									classHoverName = "portlet-section-alternate-hover results-row alt hover";
								}
		
								boolean allDay = CalUtil.isAllDay(event, timeZone, locale);
								
								if((mcal.getState() != MeetingCalendarKey.DOI) && (mcal.getState() != MeetingCalendarKey.HUY)){
								%>
			
									<tr class="<%//= className %>"  onMouseEnter="this.className = '<%//= classHoverName %>';" onMouseLeave="this.className = '<%//= className %>';">
										<!-- <td style="padding-left: 10px;"></td> -->
										<td align="center" nowrap class="nameContent" valign="top" width="20%">
										
											<c:choose>
												<c:when test="<%= allDay %>">
													<liferay-ui:message key="all-day" />
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="<%= event.isTimeZoneSensitive() %>">
															<%= dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)) %>
														</c:when>
														<c:otherwise>
															<%= dateFormatTime.format(event.getStartDate()) %>
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose>
										</td>
									
										<td  style="padding-left: 2px;" bgcolor ="<%=duplicateBgr %>"></td>
										<td valign="top" align="left"  width="99%">
											<font class="textinfoCal" color="#000080"><b><%= LanguageUtil.get(pageContext, "content") %>:</b><font color="#000080">&nbsp;
											
											<% 
											String contentOut = event.getDescription();
											contentOut = contentOut.replaceAll("\\<.*?\\>", "");
											out.print(contentOut);
											%> 
											&nbsp;
									
											<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tai-noi") %>:</font>&nbsp; <%= Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff() %><br>
											<%
											if(Validator.isNotNull(mcal.getComponent())){ 
											%>
												<font class="textinfoCal" color="#000080">TP:</font>&nbsp; <%= mcal.getComponent() %><br>
											<%
											} 
											%>
											<%
											if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)){ 
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "sponsor") %>:</font>&nbsp; <%= event.getTitle() %><br>
											<% 
											}
											%>
											<%
											if(Validator.isNotNull(event.getUserName()) && tabs1_.equals("lich-du-kien")){ 
												//User us = UserLocalServiceUtil.getUser(event.getUserId());
												User us = null;
												try {
													us = UserLocalServiceUtil.getUser(event.getUserId());
												}
												catch (Exception ex) {
													us = null;
												}
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "entrant") %>:</font>&nbsp;<%= us != null ? us.getScreenName() : "" %><Br>
											<%
											} 
											%>
											<%
											if(Validator.isNotNull(mcal.getNote())){ 
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "note") %>:</font>&nbsp;<%=mcal.getNote() %><Br>
											<%
											} 
											%>
											<%
												java.util.Date nowDate = new java.util.Date();
												String tinh_trang = "";
												
												if((nowDate.getTime() - event.getStartDate().getTime()) > 0 && (nowDate.getTime() - CalUtil.getEndTime(event).getTime()) < 0 && (mcal.getState() == MeetingCalendarKey.DA_DUYET)){
													tinh_trang = "<font color='red'><b>" + LanguageUtil.get(pageContext, "dang-hop") + "</b></font>";
												}
												else if((nowDate.getTime() - CalUtil.getEndTime(event).getTime()) >= 0 && (mcal.getState() == MeetingCalendarKey.DA_DUYET)){
													tinh_trang = "<font color='blue'><b>" + LanguageUtil.get(pageContext, "da-hop") + "</b></font>";
												}
											%>
												<c:if test="<%= !tinh_trang.equals(StringPool.BLANK) %>">
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tinh-trang") %>:</font>&nbsp;<%=tinh_trang %>
												</c:if>
										</td>
									</tr>
					<%		
								}
							}//end if
						}//end kt event co trong 2 bang
					}
					%>

					</table>
				</td>
			</tr>
			</table>
		</td>
		<!-- HIEN THI BUOI CHIEU -->
		<td class="portlet-font" valign="top" width="45%">
			<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr>
				<td>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">

					<%
					String duplicateBgr_E  = "";
					// xuancong close List events_E = CalEventLocalServiceUtil.getEvents(portletGroupId.longValue(), cal, eventType);
					// Dung groupId co dinh (sua tam thoi)
					List events_E = CalEventLocalServiceUtil.getEvents(32903, cal, eventType);

					//xuancong close events_E = ListUtil.sort(events_E, new EventTimeComparator(timeZone, locale));

					for (int k = 0; k < events_E.size(); k++) {
						CalEvent event_E = (CalEvent)events.get(k);
						event_E = event_E.toEscapedModel();
						MeetingCalendar mcal_E = null;
						try{
							mcal_E = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event_E.getEventId());
						}
						catch(Exception e){
							mcal_E = null;
						}
						// kt khi event chi them vao trong 1 bang
						if(mcal_E!=null){
							boolean showCalendar_E = false;						
							if(mcal_E.getState()!= 0){
								showCalendar_E = true;
							}
							
							// DuyDuong add: isTimeZoneSensitive is true
							Date stEvent_E = null;
							if(event_E.isTimeZoneSensitive()){
								stEvent_E = Time.getDate(event_E.getStartDate(), timeZone);
							}
							else{
								stEvent_E = event_E.getStartDate();
							}
							
							if(stEvent_E.getHours()>12 && showCalendar_E){
								Iterator itr_E = events_E.iterator();
								while(itr_E.hasNext() ){
									duplicateBgr_E = "";
									CalEvent itrCal_E = (CalEvent)itr_E.next();
									MeetingCalendar itrMcal_E = null;
									try{
										itrMcal_E = MeetingCalendarLocalServiceUtil.getMeetingCalendar(itrCal_E.getEventId());
									}
									catch(Exception e){
										itrMcal_E = null;
									}
									if(itrMcal_E!=null){
										if((itrCal_E.getEventId() != event_E.getEventId()) && (itrCal_E.getStartDate().getHours()>12)){
							
											if(itrCal_E.getEventId()>event_E.getEventId()){
												if(((itrCal_E.getStartDate().getTime() - CalUtil.getEndTime(event_E).getTime())<0) 
													&& (((Validator.isNotNull(mcal_E.getPlace())) && (mcal_E.getPlace().equals(itrMcal_E.getPlace())))
														|| ((Validator.isNotNull(mcal_E.getPlace_diff())) && (mcal_E.getPlace_diff().equals(itrMcal_E.getPlace_diff())))) ){
														//out.print("BD " + itrCal.getEventId() + "-------" + itrCal.getStartDate().getTime() + "<br>");
													duplicateBgr_E = "red";
													break;
												}
												else{
													duplicateBgr_E = "";
												}
											}
											else{
												if(((event_E.getStartDate().getTime() - CalUtil.getEndTime(itrCal_E).getTime())<0) 
													&& (((Validator.isNotNull(mcal_E.getPlace())) && (mcal_E.getPlace().equals(itrMcal_E.getPlace())))
														|| ((Validator.isNotNull(mcal_E.getPlace_diff())) && (mcal_E.getPlace_diff().equals(itrMcal_E.getPlace_diff())))) ){
														//out.print("BD " + itrCal.getEventId() + "-------" + itrCal.getStartDate().getTime() + "<br>");
													duplicateBgr_E = "red";
													break;
												}
												else{
													duplicateBgr_E = "";
												}	
											}
										} 
									}
								}
								
								className = "portlet-section-body results-row";
								String classHoverName_E = "portlet-section-body-hover results-row hover";
		
								if (MathUtil.isEven(k)) {
									className = "portlet-section-alternate results-row alt";
									classHoverName_E = "portlet-section-alternate-hover results-row alt hover";
								}
		
								boolean allDay_E = CalUtil.isAllDay(event_E, timeZone, locale);
								
								if((mcal_E.getState() != MeetingCalendarKey.DOI) && (mcal_E.getState() != MeetingCalendarKey.HUY)){
								%>		
									<tr class="<%//= className %>" style="font-size: xx-small;" onMouseEnter="this.className = '<%//= classHoverName_E %>';" onMouseLeave="this.className = '<%//= className %>';">
										<!-- <td style="padding-left: 10px;"></td> -->
										<td nowrap valign="top" class="nameContent" align="center" width="20%">
											<c:choose>
												<c:when test="<%= allDay_E %>">
													<liferay-ui:message key="all-day" />
												</c:when>
												<c:otherwise>
													<c:choose>
														<c:when test="<%= event_E.isTimeZoneSensitive() %>">
															<%= dateFormatTime.format(Time.getDate(event_E.getStartDate(), timeZone)) %>
														</c:when>
														<c:otherwise>
															<%= dateFormatTime.format(event_E.getStartDate()) %>
														</c:otherwise>
													</c:choose>
												</c:otherwise>
											</c:choose><br>
												
											<br>
										</td>
										<td style="padding-left: 2px;" bgcolor="<%=duplicateBgr_E%>"></td>
										<td valign="top" width="99%">
											<font class="textinfoCal" color="#000080"><strong><%= LanguageUtil.get(pageContext, "content") %>:</strong><font color="#000080">&nbsp;
											<% 
											String contentOut = event_E.getDescription();
											contentOut = contentOut.replaceAll("\\<.*?\\>", "");
											out.print(contentOut);
											%>
											&nbsp;
											<%= LanguageUtil.get(pageContext, "tai-noi") %>:&nbsp; <%= Validator.isNotNull(mcal_E.getPlace()) ? LanguageUtil.get(pageContext, mcal_E.getPlace()): mcal_E.getPlace_diff() %><br>
											<%
											if(Validator.isNotNull(mcal_E.getComponent())){ 
											%>
												<font class="textinfoCal" color="#000080">TP:</font>&nbsp; <%= mcal_E.getComponent() %><br>
											<%
											} 
											%>
											<%
											if(!event_E.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)){ 
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "sponsor") %>:</font>&nbsp; <%= event_E.getTitle() %><br>
											<%
											} 
											%>
											<%
											if(Validator.isNotNull(event_E.getUserName()) && tabs1_.equals("lich-du-kien")){ 
												//User us = UserLocalServiceUtil.getUser(event_E.getUserId());
												User us = null;
												try {
													us = UserLocalServiceUtil.getUser(event_E.getUserId());
												}
												catch (Exception ex) {
													us = null;
												}
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "entrant") %>:</font>&nbsp;<%= us != null ? us.getScreenName() : "" %><Br>
											<%
											} 
											%>
											<%
											if(Validator.isNotNull(mcal_E.getNote())){ 
											%>
												<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "note") %>:</font>&nbsp;<%=mcal_E.getNote() %><Br>
											<%
											} 
											java.util.Date nowDate_E = new java.util.Date();
											String tinh_trang_E = "";
											
											if((nowDate_E.getTime() - event_E.getStartDate().getTime()) > 0 && (nowDate_E.getTime() - CalUtil.getEndTime(event_E).getTime()) < 0 && (mcal_E.getState() == MeetingCalendarKey.DA_DUYET)){
												tinh_trang_E = "<font color='red'><b>" + LanguageUtil.get(pageContext, "dang-hop") + "</b></font>";
											}
											else if((nowDate_E.getTime() - CalUtil.getEndTime(event_E).getTime()) >= 0 && mcal_E.getState() == MeetingCalendarKey.DA_DUYET){
												tinh_trang_E = "<font color='blue'><b>" + LanguageUtil.get(pageContext, "da-hop") + "</b></font>";
											}
											%>
													<c:if test="<%= !tinh_trang_E.equals(StringPool.BLANK) %>">
													<font class="textinfoCal" color="#000080"><%= LanguageUtil.get(pageContext, "tinh-trang") %>:</font>&nbsp;<%= tinh_trang_E %><Br>
													</c:if>
										</td>
									</tr>
						<%
								}
							}//end if
						}//end kt event co trong 2 bang
					}//end for
					%>

					</table>
				</td>
			</tr>
			</table>
		</td>
		
		<!--  <td class="portlet-section-header results-header" style="padding-left: 1px;"></td>-->
	</tr>

	<c:if test="<%= i + 1 == 7 %>">
		<!-- <tr>
			<td class="portlet-section-header results-header" colspan="3"></td>
		</tr> -->
	</c:if>

<%
	cal.add(Calendar.DATE, 1);
}
%>
</table>
</form>