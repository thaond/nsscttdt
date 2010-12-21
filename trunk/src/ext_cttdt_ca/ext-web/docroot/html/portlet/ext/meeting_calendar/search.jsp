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
String redirect = ParamUtil.getString(request, "redirect");

String showAdvance = ParamUtil.getString(request, "showAdvance");

PortletURL portletURL = renderResponse.createRenderURL();

String tabs1 = ParamUtil.getString(request, "tabs1");

MeetingCalendarSearch searchContainer = new MeetingCalendarSearch(renderRequest, portletURL);
MeetingCalendarSearchTerms searchTerms = (MeetingCalendarSearchTerms)searchContainer.getSearchTerms();
MeetingCalendarDisplayTerms displayTerms = (MeetingCalendarDisplayTerms)searchContainer.getDisplayTerms();
	
String description = ParamUtil.getString(request, "description");
String sponsor = ParamUtil.getString(request, "sponsor");
String component = ParamUtil.getString(request, "component");

Calendar cal = (Calendar)selCal.clone();

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//lay ngay hien tai
String datenow = formatter.format(cal.getTime());
Calendar cale = CalendarFactoryUtil.getCalendar(timeZone, locale);

String frDay = request.getParameter("frDateDay");
String frMonth = request.getParameter("frDateMonth");
String frYear = request.getParameter("frDateYear");

String toDay = request.getParameter("toDateDay");
String toMonth = request.getParameter("toDateMonth");
String toYear = request.getParameter("toDateYear");

%>
<liferay-portlet:renderURL windowState="<%= WindowState.NORMAL.toString() %>" varImpl="searchURL"><portlet:param name="struts_action" value="/ext/meeting_calendar/search" /></liferay-portlet:renderURL>
<div id="divparent">
<form action="<%= searchURL %>" method="get" name="<portlet:namespace />fm" onSubmit="submitForm(this); return false;" class="meeting_calendar_bg">
<liferay-portlet:renderURLParams varImpl="searchURL" />

<liferay-util:include page="/html/portlet/ext/meeting_calendar/tabs1.jsp" />

<input type="hidden" name="<portlet:namespace /><%= Constants.CMD %>" />
<input name="<portlet:namespace />redirect" type="hidden" value="<%= HtmlUtil.escape(redirect) %>" />
<input type="hidden" name="<portlet:namespace />showAdvance" value="<%= showAdvance %>" />
<input type="hidden" name="<portlet:namespace />tabs1" value="<%= tabs1 %>" />
<table class="ltr-table" width="100%" style="margin-bottom:10px;">
<tr valign="top">
	<td width="50%">
		<c:choose>
			<c:when test='<%= tabs1.equals("calendar-release") %>'>
				<img border="0" src="/html/portlet/ext/meeting_calendar/Text_LichLamViec.gif" />
			</c:when>
			<c:otherwise>
				<img border="0" src="/html/portlet/ext/meeting_calendar/Text_DangKyLichTuan.gif" />
			</c:otherwise>
		</c:choose>
	</td>
	<td align="right" width="50%">
		
		<a class="repeat" onclick="<portlet:namespace />showHideAdvance('<portlet:namespace />showHideAdvance','<portlet:namespace />portletShowHide');"><liferay-ui:message key="search" /></a>
		<div id="<portlet:namespace />showHideAdvance" class="div" style="display: <%= (showAdvance.equalsIgnoreCase("true")) ? "block" : "none" %>;">
		<table class="search_table" width="100%">
			<tr>
				<td><liferay-ui:message key="from-date" />:</td>
				<td>
					<%
					//chuyen month thanh so, cong voi 1 de dung voi thang nhap tren combobox
					int frMonthInt = 0;
					if(frMonth !=null){
					frMonthInt = Integer.parseInt(frMonth) + 1;
					}
					
					String frDMY = frDay +"/"+ String.valueOf(frMonthInt) +"/"+ frYear; 
					
					Date frDisplayDate = null;
					
					if(frDay!=null){
						frDisplayDate = formatter.parse(frDMY);
					}
					
					// DuyDuong add: liferay-ui:input-date don`t undertand null
					if(frDay==null){
						frDay = "0";
					}
					if(frMonth==null){
						frMonth = "0";
					}
					if(frYear==null){
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
							yearRangeStart="<%= cale.get(Calendar.YEAR) - 5 %>"
							yearRangeEnd="<%= cale.get(Calendar.YEAR) + 5 %>"
							firstDayOfWeek="<%= cale.getFirstDayOfWeek() - 1 %>"
							disabled="<%= false %>"
						/>
					
				</td>
			</tr>
			<tr>
				<td><liferay-ui:message key="to-date" />:</td>
				<td>
					<%
					//chuyen month thanh so, cong voi 1 de dung voi thang nhap tren combobox
					int toMonthInt = 0;
					if(toMonth !=null){
					toMonthInt = Integer.parseInt(toMonth) + 1;
					}
					
					String toDMY = toDay +"/"+ String.valueOf(toMonthInt) +"/"+ toYear; 
					
					Date toDisplayDate = null;
					
					if(toDay!=null){
						toDisplayDate = formatter.parse(toDMY);
					}
					if(toDay==null){
						toDay = String.valueOf(cale.get(Calendar.DATE));
					}
					if(toMonth==null){
						toMonth = String.valueOf(cale.get(Calendar.MONTH));
					}
					if(toYear==null){
						toYear = String.valueOf(cale.get(Calendar.YEAR));
					}
					%>
					
						<liferay-ui:input-date
							disableNamespace="<%= true %>"
							formName='<%= renderResponse.getNamespace() + "fm" %>'
							monthParam="toDateMonth"
							monthValue="<%=Integer.parseInt(toMonth) %>"
							dayParam="toDateDay"
							dayValue="<%=Integer.parseInt(toDay) %>"
							yearParam="toDateYear"
							yearValue="<%=Integer.parseInt(toYear) %>"
							yearRangeStart="<%= cale.get(Calendar.YEAR) - 5 %>"
							yearRangeEnd="<%= cale.get(Calendar.YEAR) + 5 %>"
							firstDayOfWeek="<%= cale.getFirstDayOfWeek() - 1 %>"
							disabled="<%= false %>"
						/>
				</td>
			</tr>
			<tr>
				<td><liferay-ui:message key="meeting-content" /></td>
				<td>
					<input name="<portlet:namespace /><%= displayTerms.DESCRIPTION%>" type="text" value="<%= HtmlUtil.escape(displayTerms.getDescription()) %>" style="width:98%;" />
				</td>
			<tr>
				<td><liferay-ui:message key="meeting-sponsor" /></td>
				<td>
					<input name="<portlet:namespace /><%= displayTerms.SPONSOR%>" type="text" value="<%= HtmlUtil.escape(displayTerms.getSponsor()) %>" style="width:98%;" />
				</td>
			</tr>
			<tr>
				<td><liferay-ui:message key="meeting-component" /></td>
				<td>
					<input name="<portlet:namespace /><%= displayTerms.COMPONENT%>" type="text" value="<%= HtmlUtil.escape(displayTerms.getSponsor()) %>" style="width:98%;" />
				</td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="<liferay-ui:message key="search" />" onClick="submitForm(document.<portlet:namespace />fm);"/>
				</td>
			</tr>
		</table>
		</div>
	</td>
</tr>
</table>
<%
	portletURL.setWindowState(WindowState.NORMAL);

	portletURL.setParameter("struts_action", "/ext/meeting_calendar/search");
	portletURL.setParameter("redirect", redirect);
	portletURL.setParameter("showAdvance", showAdvance);
	portletURL.setParameter("tabs1", tabs1);
	
	int total = 0;
	if(tabs1.equals("calendar-release")){
		total = MeetingCalendarLocalServiceUtil.countBySD_D_S_C_S(frDisplayDate, toDisplayDate, searchTerms.getDescription(), searchTerms.getSponsor(), searchTerms.getComponent(), MeetingCalendarKey.DA_DUYET, searchTerms.isAndOperator());
		searchContainer.setTotal(total);
	}else if((tabs1.equals("approved-calendar"))){
		total = MeetingCalendarLocalServiceUtil.countBySD_D_S_C(frDisplayDate, toDisplayDate, searchTerms.getDescription(), searchTerms.getSponsor(), searchTerms.getComponent(), searchTerms.isAndOperator());
		searchContainer.setTotal(total);
	}
	
	List results = null;
	if(tabs1.equals("calendar-release")){
		results = MeetingCalendarLocalServiceUtil.searchBySD_D_S_C_S(frDisplayDate, toDisplayDate, searchTerms.getDescription(), searchTerms.getSponsor(), searchTerms.getComponent(), MeetingCalendarKey.DA_DUYET, searchTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		searchContainer.setResults(results);
	}else if((tabs1.equals("approved-calendar"))){
		results = MeetingCalendarLocalServiceUtil.searchBySD_D_S_C(frDisplayDate, toDisplayDate, searchTerms.getDescription(), searchTerms.getSponsor(), searchTerms.getComponent(), searchTerms.isAndOperator(), searchContainer.getStart(), searchContainer.getEnd(), searchContainer.getOrderByComparator());
		searchContainer.setResults(results);
	}
	
	List headerNames = searchContainer.getHeaderNames();
	headerNames.clear();
	headerNames.add("time");
	headerNames.add("content");
	headerNames.add("sponsor");
	headerNames.add("component");
	headerNames.add("room");
	
	List resultRows = searchContainer.getResultRows();
	for (int i = 0; i < results.size(); i++) {
		CalEvent event = (CalEvent)results.get(i);
		event = event.toEscapedModel();
		MeetingCalendar mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
		
		ResultRow row = new ResultRow(event, i, i);	
		
		Date startDate = event.getStartDate();
		int stDate = startDate.getDate();
		int stMonth = startDate.getMonth();
		int stYear = startDate.getYear();
		
		String time = dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone))+" - "+dateFormatTime.format(Time.getDate(CalUtil.getEndTime(event), timeZone))+" "+dateFormatDate.format(Time.getDate(startDate, timeZone));
		
		String descriptions = event.getDescription();
		descriptions = descriptions.replaceAll("&lt;", "<");
		descriptions = descriptions.replaceAll("&gt;", ">");
		descriptions = descriptions.replaceAll("&#045;", "-");
		while (descriptions.indexOf("<!--[if") > 0) {
			int firstPosRem = descriptions.indexOf("<!--[if");
			int lastPosRem = descriptions.indexOf("<![endif]-->", "<!--[if".length());
			if (lastPosRem > firstPosRem) {
				descriptions = descriptions.substring(0, firstPosRem) + descriptions.substring(lastPosRem + "<![endif]-->".length());
			} // end if
			else break;
		}
		while (descriptions.indexOf("<style") > 0) {
			int firstPosRem = descriptions.indexOf("<style");
			int lastPosRem = descriptions.indexOf("</style>", "<style".length());
			if (lastPosRem > firstPosRem) {
				descriptions = descriptions.substring(0, firstPosRem) + descriptions.substring(lastPosRem + "</style>".length());
			} // end if
			else break;
		}
				
		descriptions = descriptions.replaceAll("\\<.*?\\>", "");
		descriptions = descriptions.replaceAll("&amp;", "&");
		descriptions = descriptions.replaceAll("&#059;", ";");
		descriptions = descriptions.replaceAll("\n", "<br />");

		String sponsors = event.getTitle();
		String components = mcal.getComponent();
		String room = LanguageUtil.get(pageContext, mcal.getPlace());
		if(room.equals("")){
			room = LanguageUtil.get(pageContext, mcal.getPlace_diff());
		}
		
		PortletURL rowURL = renderResponse.createRenderURL();
		rowURL.setParameter("struts_action", "/ext/meeting_calendar/week_view");
		rowURL.setParameter("tabs1", String.valueOf(tabs1));
		rowURL.setParameter("day", String.valueOf(stDate));
		rowURL.setParameter("month", String.valueOf(stMonth));
		rowURL.setParameter("year", String.valueOf(stYear+1900));
			
		row.addText(time, rowURL);
		row.addText(descriptions, rowURL);
		row.addText(sponsors, rowURL);
		row.addText(components, rowURL);
		row.addText(room, rowURL);
		
		resultRows.add(row);	
	}
%>
<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" />
</form>
</div>
<script type="text/javascript">
	function <portlet:namespace />showHideAdvance(objShowHide) {
		if(objShowHide && objShowHide!=""){
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

</script>