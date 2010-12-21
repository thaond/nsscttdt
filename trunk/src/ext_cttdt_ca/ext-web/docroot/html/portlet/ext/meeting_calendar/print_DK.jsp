<%
/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
%>
<%@ include file="/html/portlet/ext/meeting_calendar/init.jsp" %>
<%
String eventType = ParamUtil.getString(request, "eventType");

PortletURL portletURL = renderResponse.createRenderURL();

boolean checkUser = true;

Calendar cal = (Calendar)selCal.clone();
// DuyDuong add: get Monday is first on week
int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
int firstDayOfWeek = dayOfWeek - 2;

DateFormat dateFormatDayOfWeek = new SimpleDateFormat("E", locale);
DateFormat dateFormatMonthAndDay = new SimpleDateFormat("M/d", locale);
portletURL.setWindowState(WindowState.NORMAL);

MeetingCalendarSearch searchContainer = new MeetingCalendarSearch(renderRequest, portletURL);
MeetingCalendarSearchTerms searchTerms = (MeetingCalendarSearchTerms)searchContainer.getSearchTerms();
MeetingCalendarDisplayTerms displayTerms = (MeetingCalendarDisplayTerms)searchContainer.getDisplayTerms();

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

cal.add(Calendar.DATE, -firstDayOfWeek);
%>

<table width="100%">
	<tr>
		<td align="center"><span style='font-size:12.0pt;line-height:115%;font-family:"Times New Roman"'><b>QU&#7852;N &#7910;Y - &#7910;Y BAN NH&#194;N D&#194;N</b></span></td>
		<td align="center"></td>
	</tr>
	<tr>
		<td align="center"><span style='font-size:12.0pt;line-height:115%;font-family:"Times New Roman"'><b>QU&#7852;N PH&#218; NHU&#7852;N</b></span></td>
		<td align="center"><span style='font-size:12.0pt;line-height:115%;font-family:"Times New Roman"'><b>L&#7882;CH C&#212;NG T&#193;C TU&#7846;N</b></span></td>
	</tr>
	<tr>
		<td align="center">--------------------</td>
		<td align="center"><span style='font-size:12.0pt;line-height:115%;font-family:"Times New Roman"'><b>BAN TV/QU - UBND QU&#7852;N PH&#218; NHU&#7852;N</b></span></td>
	</tr>
	<tr>
		<td align="center"><span style='font-size:12.0pt;line-height:115%;font-family:"Times New Roman"'><b><i><u>TU&#7846;N <%= cal.get(Calendar.WEEK_OF_YEAR)%> - <%= cal.get(Calendar.YEAR)%>:</u></i></b></span></td>
		<td align="center"><span style='font-size:12.0pt;line-height:115%;font-family:"Times New Roman"'><b>(t&#7915; ng&#224;y <%=dateFormatDate.format(Time.getDate(cal)) %><%cal.add(Calendar.DATE, 6);%> - <%=dateFormatDate.format(Time.getDate(cal)) %> )</b></span></td>
	</tr>
</table>
<br />
<%	
for(int mcaltype=0; mcaltype<MeetingCalendarImpl.TYPES.length; mcaltype++){
eventType = MeetingCalendarImpl.TYPES[mcaltype];
cal = (Calendar)selCal.clone();
// DuyDuong add: get Monday is first on week
firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 2;
cal.add(Calendar.DATE, -firstDayOfWeek);
%>
<c:if test='<%= eventType.equals("lich-phu") %>'>
<table width="100%">
	<tr>
		<td colspan="2" align="center">----------------------
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
		</td>
	</tr>
	<tr>
		<td align="center"><span style='font-size:12.0pt;line-height:115%;font-family:"Times New Roman"'><b><i><u>TU&#7846;N <%= cal.get(Calendar.WEEK_OF_YEAR)%>/<%= cal.get(Calendar.YEAR)%>:</u></i></b></span></td>
		<td align="center"><span style='font-size:12.0pt;line-height:115%;font-family:"Times New Roman"'><b>PH&#7908; L&#7908;C L&#7882;CH C&#212;NG T&#193;C TU&#7846;N DO C&#193;C PH&#210;NG BAN</b></span></td>
	</tr>
	<tr>
		<td></td>
		<td align="center"><span style='font-size:14.0pt;line-height:115%;font-family:"Times New Roman"'><b>V&#192; UBND 15 PH&#431;&#7900;NG &#272;&#258;NG K&#221;.</b></span></td>
	</tr>
</table>
<br />
</c:if>
<table width="100%" border="1">
	<tr>
		<td align="center" width="10%"><b>Ng&#224;y</b></td>
		<td align="center" width="10%"><b>Th&#7901;i gian</b></td>
		<td align="center" width="68%"><b>N&#7897;i dung - Th&#224;nh ph&#7847;n</b></td>
		<td align="center" width="12%"><b>&#272;&#7883;a &#273;i&#7875;m</b></td>
	</tr>
<%
for (int i = 0; i < 7; i++) {
%>
	<tr>
		<td valign="top" align="center">
			<%= user.getLanguageId().equals("vi_VN")? StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))),"Th",LanguageUtil.get(pageContext,"thu-trong-tuan" )):dateFormatDayOfWeek.format(Time.getDate(cal)) %><br />
			<%=dateFormatDate.format(Time.getDate(cal))  %>
		</td>
		<td colspan="3">
		<%
		List events = CalEventLocalServiceUtil.getEvents(portletGroupId.longValue(), cal, eventType);
		
		boolean hasAllDay = false;
		boolean hasMorning = false;
		boolean hasAfternoon = false;
		boolean hasEvening = false;
		List eventsAllDay = new ArrayList();
		List eventsMorning = new ArrayList();
		List eventsAfternoon = new ArrayList();
		List eventsEvening = new ArrayList();
		List eventsOrg = new ArrayList();
		List mcalComps = null;
		try{
			mcalComps = MeetingCalComponentLocalServiceUtil.getByG_SD(portletGroupId.longValue(), cal);
		}
		catch(Exception e){
		}
		if(mcalComps!=null){
			for(int j=0; j<mcalComps.size(); j++){
				MeetingCalComponent mcalComp = (MeetingCalComponent)mcalComps.get(j);
				CalEvent cale1 = CalEventLocalServiceUtil.getEvent(mcalComp.getMcalId());
				MeetingCalendar mcale = MeetingCalendarLocalServiceUtil.getMeetingCalendar(mcalComp.getMcalId());
				if(mcale.getState() == MeetingCalendarKey.DA_DUYET){
					eventsOrg.add(cale1);
				}
			}
		}
		events = ListUtil.sort(events, new EventTimeComparator(timeZone, locale));
		
		List eventsDuyet = new ArrayList();
		List mcalSTTs = null;
		try{
			mcalSTTs = MeetingCalendarLocalServiceUtil.getByG_SD(portletGroupId.longValue(), cal, eventType);
		}
		catch(Exception e){
		}
		
		if(mcalSTTs==null){
			mcalSTTs=events;
		}
		for(int j=0; j<mcalSTTs.size(); j++){
			MeetingCalendar mcale = (MeetingCalendar)mcalSTTs.get(j);
			CalEvent cale1 = CalEventLocalServiceUtil.getEvent(mcale.getMcalId());
			// isTimeZoneSensitive is true
			Date stEvent = null;
			if(cale1.isTimeZoneSensitive()){
				stEvent = Time.getDate(cale1.getStartDate(), timeZone);
			}
			else{
				stEvent = cale1.getStartDate();
			}
			if((mcale.getState() != MeetingCalendarKey.DOI) && (mcale.getState() != MeetingCalendarKey.HUY)){
				eventsDuyet.add(cale1);
			}
		}
		
		for (int j = 0; j < eventsDuyet.size(); j++) {
			CalEvent event = (CalEvent)eventsDuyet.get(j);	
			MeetingCalendar mcal = null;
			try{
				mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
			}
			catch(Exception ex){
				mcal = null;
			}
			// isTimeZoneSensitive is true
			Date stEvent = null;
			if(event.isTimeZoneSensitive()){
				stEvent = Time.getDate(event.getStartDate(), timeZone);
			}
			else{
				stEvent = event.getStartDate();
			}
			// kt event chi co trong 1 bang
			if(mcal!=null){
				if(event.getAllDay()){
					eventsAllDay.add(event);
					hasAllDay = true;
				}
				else if(mcal.getMorning() || stEvent.getHours()<=12){
					eventsMorning.add(event);
					hasMorning = true;
				}
				else if(mcal.getAfternoon() || (stEvent.getHours()>12 && stEvent.getHours()<17)){
					eventsAfternoon.add(event);
					hasAfternoon = true;
				}
				else if(mcal.getEvening() || stEvent.getHours()>=17){
					eventsEvening.add(event);
					hasEvening = true;
				}
			}
		}
		%>
			<table width="100%">
				<c:if test='<%= hasAllDay%>'>
				<tr>
					<td valign="top" align="center" width="11%">
						<liferay-ui:message key="all-day" />
					</td>
					<td>
						<table height="40" width="100%" style="border-left:1px solid black">
							<%
							for (int j = 0; j < eventsAllDay.size(); j++) {
								CalEvent event = (CalEvent)eventsAllDay.get(j);	
								MeetingCalendar mcal = null;
								try{
									mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
								}
								catch(Exception ex){
									mcal = null;
								}
								// kt event chi co trong 1 bang
								if(mcal!=null){
									// isTimeZoneSensitive is true
									Date stEvent = null;
									if(event.isTimeZoneSensitive()){
										stEvent = Time.getDate(event.getStartDate(), timeZone);
									}
									else{
										stEvent = event.getStartDate();
									}
							%>
							<tr>
								<td valign="top" align="left" width="85%">
								<font class="textinfoCal" color="black">
								&nbsp;-&nbsp;
								<%if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI) && !event.getTitle().equals(StringPool.BLANK)){ %>
									<b><%= event.getTitle() %></b>&nbsp;
								<% }%>
								<%
								String title = StringPool.BLANK;
								int indexKeywordQuot = -1;			
								int indexKeywordBr = -1;
								indexKeywordQuot = event.getDescription().toLowerCase().indexOf("&#039;");
								indexKeywordBr = event.getDescription().toLowerCase().indexOf("\n");
								if(indexKeywordQuot != -1){
									title = event.getDescription().replaceAll("&#039;","&quot;");
								}
								if(indexKeywordBr != -1){
									if(!title.equals(StringPool.BLANK)){
										title = title.replaceAll("\n","<br />");
									}
									else{
										title = event.getDescription().replaceAll("\n","<br />");
									}
								}
								if(!title.equals(StringPool.BLANK)){
								%>
									<%= title%>
								<%
								}
								else{
								%>
									<%= event.getDescription()%> 
								<%
								}
								%>
								&nbsp;
								<%if(Validator.isNotNull(mcal.getNote())){ %>
									<b><%=mcal.getNote() %></b>
								<%} %>
								<%if(Validator.isNotNull(mcal.getComponent())){ %>
									<b><i>M&#7901;i:</i></b>&nbsp; <%= mcal.getComponent() %>
								<%} %>
								</font>
								</td>
								<td width="1" style="border-left:1px solid black"></td>
								<td valign="top" align="center">
								<%if(Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())){ %>
									&nbsp;-&nbsp;
									T&#7841;i</font>&nbsp; <%= Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff() %>
									<%} %>
								</td>
							</tr>
							<%		
								}//end kt event co trong 2 bang
							}
							%>
						</table>
					</td>
				</tr>
				</c:if>
				<c:if test='<%= hasMorning%>'>
				<tr>
					<td valign="top" align="center" width="11%">
						<liferay-ui:message key="buoi-sang" />
					</td>
					<td>
						<table height="40" width="100%" style="border-left:1px solid black">
							<%
							for (int j = 0; j < eventsMorning.size(); j++) {
								CalEvent event = (CalEvent)eventsMorning.get(j);	
								MeetingCalendar mcal = null;
								try{
									mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
								}
								catch(Exception ex){
									mcal = null;
								}
								// kt event chi co trong 1 bang
								if(mcal!=null){
									// isTimeZoneSensitive is true
									Date stEvent = null;
									if(event.isTimeZoneSensitive()){
										stEvent = Time.getDate(event.getStartDate(), timeZone);
									}
									else{
										stEvent = event.getStartDate();
									}
							%>
							<tr>
								<td valign="top" align="left" width="85%">
								<font class="textinfoCal" color="black">
								&nbsp;-&nbsp;
								<c:if test='<%= !mcal.getMorning()%>'>
								<c:choose>
									<c:when test="<%= event.isTimeZoneSensitive() %>">
										<b><%= dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)) %></b>
									</c:when>
									<c:otherwise>
										<b><%= dateFormatTime.format(event.getStartDate()) %></b>
									</c:otherwise>
								</c:choose>
								</c:if>
								<%if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI) && !event.getTitle().equals(StringPool.BLANK)){ %>
									<b><%= event.getTitle() %></b>&nbsp;
								<% }%>
								<%
								String title = StringPool.BLANK;
								int indexKeywordQuot = -1;			
								int indexKeywordBr = -1;
								indexKeywordQuot = event.getDescription().toLowerCase().indexOf("&#039;");
								indexKeywordBr = event.getDescription().toLowerCase().indexOf("\n");
								if(indexKeywordQuot != -1){
									title = event.getDescription().replaceAll("&#039;","&quot;");
								}
								if(indexKeywordBr != -1){
									if(!title.equals(StringPool.BLANK)){
										title = title.replaceAll("\n","<br />");
									}
									else{
										title = event.getDescription().replaceAll("\n","<br />");
									}
								}
								if(!title.equals(StringPool.BLANK)){
								%>
									<%= title%>
								<%
								}
								else{
								%>
									<%= event.getDescription()%> 
								<%
								}
								%>
								&nbsp;
								<%if(Validator.isNotNull(mcal.getNote())){ %>
									<b><%=mcal.getNote() %></b>
								<%} %>
								<%if(Validator.isNotNull(mcal.getComponent())){ %>
									<b><i>M&#7901;i:</i></b>&nbsp; <%= mcal.getComponent() %>
								<%} %>
								</font>
								</td>
								<td width="1" style="border-left:1px solid black"></td>
								<td valign="top" align="center">
								<%if(Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())){ %>
									&nbsp;-&nbsp;
									T&#7841;i</font>&nbsp; <%= Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff() %>
									<%} %>
								</td>
							</tr>
							<%		
								}//end kt event co trong 2 bang
							}
							%>
						</table>
					</td>
				</tr>
				</c:if>
				<c:if test='<%= hasAfternoon%>'>
				<tr>
					<td valign="top" align="center" width="11%">
						<liferay-ui:message key="buoi-chieu" />
					</td>
					<td>
						<table height="40" width="100%" style="border-left:1px solid black">
							<%
							for (int j = 0; j < eventsAfternoon.size(); j++) {
								CalEvent event = (CalEvent)eventsAfternoon.get(j);	
								MeetingCalendar mcal = null;
								try{
									mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
								}
								catch(Exception ex){
									mcal = null;
								}
								// kt event chi co trong 1 bang
								if(mcal!=null){
									// isTimeZoneSensitive is true
									Date stEvent = null;
									if(event.isTimeZoneSensitive()){
										stEvent = Time.getDate(event.getStartDate(), timeZone);
									}
									else{
										stEvent = event.getStartDate();
									}
							%>
							<tr>
								<td valign="top" align="left" width="85%">
								<font class="textinfoCal" color="black">
								&nbsp;-&nbsp;
								<c:if test='<%= !mcal.getAfternoon()%>'>
								<c:choose>
									<c:when test="<%= event.isTimeZoneSensitive() %>">
										<b><%= dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)) %></b>
									</c:when>
									<c:otherwise>
										<b><%= dateFormatTime.format(event.getStartDate()) %></b>
									</c:otherwise>
								</c:choose>
								</c:if>
								<%if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI) && !event.getTitle().equals(StringPool.BLANK)){ %>
									<b><%= event.getTitle() %></b>&nbsp;
								<% }%>
								<%
								String title = StringPool.BLANK;
								int indexKeywordQuot = -1;			
								int indexKeywordBr = -1;
								indexKeywordQuot = event.getDescription().toLowerCase().indexOf("&#039;");
								indexKeywordBr = event.getDescription().toLowerCase().indexOf("\n");
								if(indexKeywordQuot != -1){
									title = event.getDescription().replaceAll("&#039;","&quot;");
								}
								if(indexKeywordBr != -1){
									if(!title.equals(StringPool.BLANK)){
										title = title.replaceAll("\n","<br />");
									}
									else{
										title = event.getDescription().replaceAll("\n","<br />");
									}
								}
								if(!title.equals(StringPool.BLANK)){
								%>
									<%= title%>
								<%
								}
								else{
								%>
									<%= event.getDescription()%> 
								<%
								}
								%>
								&nbsp;
								<%if(Validator.isNotNull(mcal.getNote())){ %>
									<b><%=mcal.getNote() %></b>
								<%} %>
								<%if(Validator.isNotNull(mcal.getComponent())){ %>
									<b><i>M&#7901;i:</i></b>&nbsp; <%= mcal.getComponent() %>
								<%} %>
								</font>
								</td>
								<td width="1" style="border-left:1px solid black"></td>
								<td valign="top" align="center">
								<%if(Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())){ %>
									&nbsp;-&nbsp;
									T&#7841;i</font>&nbsp; <%= Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff() %>
									<%} %>
								</td>
							</tr>
							<%		
								}//end kt event co trong 2 bang
							}
							%>
						</table>
					</td>
				</tr>
				</c:if>
				<c:if test='<%= hasEvening%>'>
				<tr>
					<td valign="top" align="center" width="11%">
						<liferay-ui:message key="buoi-toi" />
					</td>
					<td>
						<table height="40" width="100%" style="border-left:1px solid black">
							<%
							for (int j = 0; j < eventsEvening.size(); j++) {
								CalEvent event = (CalEvent)eventsEvening.get(j);	
								MeetingCalendar mcal = null;
								try{
									mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
								}
								catch(Exception ex){
									mcal = null;
								}
								// kt event chi co trong 1 bang
								if(mcal!=null){
									// isTimeZoneSensitive is true
									Date stEvent = null;
									if(event.isTimeZoneSensitive()){
										stEvent = Time.getDate(event.getStartDate(), timeZone);
									}
									else{
										stEvent = event.getStartDate();
									}
							%>
							<tr>
								<td valign="top" align="left" width="85%">
								<font class="textinfoCal" color="black">
								&nbsp;-&nbsp;
								<c:if test='<%= !mcal.getEvening()%>'>
								<c:choose>
									<c:when test="<%= event.isTimeZoneSensitive() %>">
										<b><%= dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)) %></b>
									</c:when>
									<c:otherwise>
										<b><%= dateFormatTime.format(event.getStartDate()) %></b>
									</c:otherwise>
								</c:choose>
								</c:if>
								<%if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI) && !event.getTitle().equals(StringPool.BLANK)){ %>
									<b><%= event.getTitle() %></b>&nbsp;
								<% }%>
								<%
								String title = StringPool.BLANK;
								int indexKeywordQuot = -1;			
								int indexKeywordBr = -1;
								indexKeywordQuot = event.getDescription().toLowerCase().indexOf("&#039;");
								indexKeywordBr = event.getDescription().toLowerCase().indexOf("\n");
								if(indexKeywordQuot != -1){
									title = event.getDescription().replaceAll("&#039;","&quot;");
								}
								if(indexKeywordBr != -1){
									if(!title.equals(StringPool.BLANK)){
										title = title.replaceAll("\n","<br />");
									}
									else{
										title = event.getDescription().replaceAll("\n","<br />");
									}
								}
								if(!title.equals(StringPool.BLANK)){
								%>
									<%= title%>
								<%
								}
								else{
								%>
									<%= event.getDescription()%> 
								<%
								}
								%>
								&nbsp;
								<%if(Validator.isNotNull(mcal.getNote())){ %>
									<b><i><%=mcal.getNote() %></i></b>
								<%} %>
								<%if(Validator.isNotNull(mcal.getComponent())){ %>
									<b><i>M&#7901;i:</i></b>&nbsp; <%= mcal.getComponent() %>
								<%} %>
								</font>
								</td>
								<td width="1" style="border-left:1px solid black"></td>
								<td valign="top" align="center">
								<%if(Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())){ %>
									&nbsp;-&nbsp;
									T&#7841;i</font>&nbsp; <%= Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff() %>
									<%} %>
								</td>
							</tr>
							<%		
								}//end kt event co trong 2 bang
							}
							%>
						</table>
					</td>
				</tr>
				</c:if>
				<c:if test='<%= hasAllDay==false && hasMorning==false && hasAfternoon==false && hasEvening==false %>'>
				<tr>
					<td valign="top" align="center" width="11%">&nbsp;
					</td>
					<td>
						<table height="40" width="100%" style="border-left:1px solid black">
							<tr>
								<td valign="top" align="left" width="85%">&nbsp;
								</td>
								<td width="1" style="border-left:1px solid black"></td>
								<td valign="top" align="left">&nbsp;
								</td>
							</tr>
						</table>
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
<br  />
<c:if test='<%= eventType.equals("lich") %>'>
<font class="textinfoCal" color="black"><b>
Ghi ch&#250;:<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.L&#7883;ch n&#224;y thay th&#432; m&#7901;i h&#7885;p &#273;&#7889;i v&#7899;i c&#225;c ph&#242;ng, ban,&#273;&#417;n v&#7883; v&#224; UBND 15 ph&#432;&#7901;ng.<br />
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.C&#225;c &#273;&#417;n v&#7883; chu&#7849;n b&#7883; n&#7897;i dung c&#243; tr&#225;ch nhi&#7879;m in &#7845;n t&#224;i li&#7879;u theo s&#7889; l&#432;&#7907;ng quy &#273;&#7883;nh trong l&#7883;ch.
</b></font>
</c:if>
<br />
<%
}
%>