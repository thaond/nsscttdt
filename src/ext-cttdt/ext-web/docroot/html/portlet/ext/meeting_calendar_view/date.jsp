<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.portlet.calendar.model.CalEvent"%>
<%@page import="com.ext.portlet.meetingcalendar.model.MeetingCalendar"%>
<%
String tabs1_ = ParamUtil.getString(request, "tabs1", tabs1Default);

portletURL.setWindowState(WindowState.NORMAL);

Calendar cal = (Calendar)curCal.clone();

// Lich ca ngay sang va chieu
// xuancong close List events = CalEventLocalServiceUtil.getEvents(portletGroupId.longValue(),cal);
// Dung groupId co dinh (sua tam thoi)
List events = CalEventLocalServiceUtil.getEvents(32903,cal);
//xuancong close events = ListUtil.sort(events, new EventTimeComparator(timeZone, locale));
Collections.sort(events, new Comparator<CalEvent>(){
				public int compare(CalEvent obj1, CalEvent obj2) {                                                
					return obj1.getStartDate().compareTo(obj2.getStartDate());
				}                                        
			});

StringBuilder sm = new StringBuilder();
StringBuilder sm2 = new StringBuilder();
String eventsStr = StringPool.BLANK;
sm.append("[");
if((events != null)){
	for(int i = 0; i < events.size(); i++){
		CalEvent event = (CalEvent)events.get(i);
		MeetingCalendar mcal = null;
		try{
			mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
		}
		catch(Exception ex){
		}
		if(mcal != null){
			Date stEvent = null;
			if(event.isTimeZoneSensitive()){
				stEvent = Time.getDate(event.getStartDate(), timeZone);
			}
			else{
				stEvent = event.getStartDate();
			}
			boolean showCalendar = false;
			if(mcal.getState()!= 0){
				showCalendar = true;
			}
			//xuancong close if((mcal.getState() != MeetingCalendarKey.DOI) && (mcal.getState() != MeetingCalendarKey.HUY)){
				//xuancong close if(stEvent.getHours()<=12 && showCalendar){
				if(showCalendar) {
					sm.append("'<font class=\"font_time\">");
					//xuancong close sm.append(dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)));
					if (event.isAllDay() == true){
						sm.append("C\u1ea3 ng\u00e0y");
					} // end if
					else if (mcal.isMorning() == true){
						sm.append("Bu\u1ED5i s\u00e1ng");
					} // end if
					else if (mcal.isAfternoon() == true){
						sm.append("Bu\u1ED5i chi\u1ec1u");
					} // end if
					else if (mcal.isEvening() == true){
						sm.append("T\u1ed1i");
					} // end if
					else {
						sm.append(dateFormatTime.format(Time.getDate(event.getStartDate(), timeZone)));
					} // end else
					
					if (mcal.getState() == MeetingCalendarKey.DOI){
						sm.append("&nbsp;(\u0111\u00e3 d\u1eddi h\u1ecdp)");
					}
					else if (mcal.getState() == MeetingCalendarKey.HUY){
						sm.append("&nbsp;(\u0111\u00e3 h\u1ee7y h\u1ecdp)");
					}
					sm.append(":&nbsp;</font><font class=\"font_content\">");
					// xu ly br va dau 2 nhay
					String title = event.getDescription();
					//xuancong close title = title.replaceAll("\\<.*?\\>", "");
					title = title.replaceAll("'","&quot;");
					//xuancong close title = title.replaceAll("\n","<br />");
					
					//xuancong tam thoi dongsm.append("<br />" + title + "&nbsp;");
					
					
					if(Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())){
						sm.append(LanguageUtil.get(pageContext, "tai-noi") + ":&nbsp;");
						sm.append(Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff());
					}
					sm.append("</font><font class=\"font_content1\" >");
					if(Validator.isNotNull(mcal.getComponent())){
						sm.append("<br>&nbsp;-&nbsp;");
						sm.append(LanguageUtil.get(pageContext, "component") + ":&nbsp;");
						sm.append(mcal.getComponent());
					}
					if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)){
						sm.append("<br>&nbsp;-&nbsp;");
						sm.append(LanguageUtil.get(pageContext, "sponsor") + ":&nbsp;");
						sm.append(event.getTitle());
					}
					sm.append("</font>',");
				}
			//xuancong close }
		}
	}
}
sm.append("]");
eventsStr = sm.toString();

if(eventsStr.equals("[]")){
	sm2.append("[");
	sm2.append("'<font class=\"font_content\">");
	sm2.append(LanguageUtil.get(pageContext, "khong-co-lich-cong-tac-nao-trong-sang-nay"));
	sm2.append("</font>'");
	sm2.append("]");
	eventsStr = sm2.toString();
}
else{
	if(eventsStr.substring(eventsStr.length()-2).equalsIgnoreCase(",]"))
		eventsStr = eventsStr.substring(0, eventsStr.length() - 2) + "]";
}

%>
<script type="text/JavaScript" language="javascript">
	function getObj(name){
		if (document.getElementById(name)){ // IE
			return document.getElementById(name); 
		}
		else if (document.layers){ // Netscape navigator
			return document.layers[name];
		}
	}

	var aImages1 = <%= eventsStr %>;
	
	var iDisplay = 5000;
	var oTimer = null;
	var iCurrent1 = 0;
	var sSource = "";
	
	function initScrollImg(){
		//setInterval("klload()", iDisplay);
		klload();
	}

	function start_show(){
		getObj("slideShow1").innerHTML = aImages1[0];
	}

	function klload(){
		iCurrent1++;
		if (iCurrent1 >= aImages1.length) iCurrent1 = 0;
		var myImg1 = aImages1[iCurrent1];
		var what1 = "slideShow1";
		var agent = navigator.userAgent.toLowerCase();

		if (agent.indexOf("msie") >= 0) {
			if (getObj(what1).filters){
				getObj(what1).filters[0].Stop();
				getObj(what1).filters[0].Apply();
				getObj(what1).filters.revealTrans.transition= 23;
				getObj(what1).innerHTML = myImg1;
				getObj(what1).filters[0].Play();
			}
		}
		else if (agent.indexOf("firefox") >= 0) {
			//getObj(what1).style.opacity = 0.4;
			//getObj(what1).filters.alpha.opacity = 40;
			getObj(what1).innerHTML = myImg1;
			//getObj(what1).style.opacity = 1;
			//getObj(what1).filters.alpha.opacity = 100;
		}
		setTimeout("klload()", iDisplay);
	}

</script>
<form method="get" name="<portlet:namespace />fm">
<input type="hidden" name="<portlet:namespace />tabs1" value="<%= tabs1_ %>" />
<table align="center" border="0" cellpadding="0" cellspacing="0" width="100%">
	<tr>
		<td bgcolor="#ffffff" width="100%">
			<table border="0" cellpadding="2" cellspacing="2" width="100%">
				<tr>
					<td align="left" valign="bottom">
						<table border="0" cellpadding="0" cellspacing="0" width="100%">
							<tr>
								<td class="maintitle" align="center"><img src="/html/portlet/ext/meeting_calendar_view/Lich_files/tieude.jpg"></td>
							</tr>
							<tr>
								<td class="font_ngay" align="center">
									<strong><%= user.getLanguageId().equals("vi_VN")? StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))),"Th",LanguageUtil.get(pageContext,"thu-trong-tuan" )):dateFormatDayOfWeek.format(Time.getDate(cal)) %>,&nbsp;<liferay-ui:message key="date" />&nbsp;<%= dateFormatDate.format(Time.getDate(cal))%></strong>
								</td>
							</tr>
						</table>
					</td>
				</tr>
				<tr height="20">
					<td>&nbsp;<td>
				</tr>
				<tr>								
					<td style="padding-bottom: 5px;">
						<div style="border:3px solid #FF4F67; height: 580px;">
						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td valign="top">
									<marquee id="slideShow1" behavior="slide" direction="up" height="570" STYLE="filter: revealTrans(TRANSITION=2)"></marquee>
									<script language="JavaScript">initScrollImg()</script>						
								</td>
							</tr>
						</table>
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
<script language="JavaScript">start_show()</script>