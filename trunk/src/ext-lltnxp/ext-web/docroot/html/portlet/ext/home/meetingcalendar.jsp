<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portlet.calendar.service.CalEventLocalServiceUtil"%>
<%@page import="com.liferay.portlet.calendar.model.CalEvent"%>
<%@page import="com.ext.portlet.meetingcalendar.model.MeetingCalendar"%>
<%@page import="com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil"%>
<%@page import="com.ext.portlet.meetingcalendar.action.MeetingCalendarKey"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ext.portlet.meetingcalendar.util.comparator.EventTimeComparator"%>
<style type="text/css">
	.font_time {
		color: red;
		font-size: 16px;
		font-weight: bold;
	}
	
	.font_content {
		color: #0325B3;
		font-size: 14px;
	}
	
</style>
<%
Calendar curCal = CalendarFactoryUtil.getCalendar(timeZone, locale);
Calendar cal = (Calendar)curCal.clone();
DateFormat dateFormatTime = DateFormats.getTime(locale);

// Lich ca ngay
List events = CalEventLocalServiceUtil.getEvents(portletGroupId.longValue(), cal);
Collections.sort(events, new EventTimeComparator(timeZone, locale));

StringBuilder sm = new StringBuilder();
StringBuilder sm2 = new StringBuilder();
String eventsStr = StringPool.BLANK;
sm.append("[");
if((events != null)){
	for(int i = 0; i < events.size(); i++){
		CalEvent event = (CalEvent)events.get(i);
		MeetingCalendar mcal = null;
		try {
			mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
		}
		catch (Exception ex) {
			mcal = null;
		}
		if(mcal != null) {
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
			// Chi lay ra lich hop chinh thuc, khong bi huy hay doi lich
			if((mcal.getState() != MeetingCalendarKey.DOI) && (mcal.getState() != MeetingCalendarKey.HUY)){
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
				sm.append("</font><font class=\"font_content\">:&nbsp;");
				// Xu ly br va dau 2 nhay
				String title = StringPool.BLANK;
				int indexKeywordQuot = -1;
				int indexKeywordBr = -1;
				indexKeywordQuot = event.getDescription().toLowerCase().indexOf("'");				
				indexKeywordBr = event.getDescription().toLowerCase().indexOf("\n");
				if(indexKeywordQuot != -1){
					title = event.getDescription().replaceAll("'", "&quot;");
				}
				if(indexKeywordBr != -1){
					if(!title.equals(StringPool.BLANK)){
						title = title.replaceAll("\n", "<br />");
					}
					else{
						title = event.getDescription().replaceAll("\n", "<br />");
					}
				}
				if(!title.equals(StringPool.BLANK)){
					sm.append(title + "&nbsp;");
				}
				else{
					sm.append(event.getDescription() + "&nbsp;");
				}
				
				if(Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())){
					sm.append("<strong>");
					sm.append(LanguageUtil.get(pageContext, "tai-noi") + "</strong>:&nbsp;");
					sm.append(Validator.isNotNull(mcal.getPlace()) ? LanguageUtil.get(pageContext, mcal.getPlace()): mcal.getPlace_diff());
				}
				sm.append("</font><font class=\"font_content1\" >");
				if(Validator.isNotNull(mcal.getComponent())){
					sm.append("<br>&nbsp;-&nbsp;");
					sm.append("<strong>");
					sm.append(LanguageUtil.get(pageContext, "component") + "</strong>:&nbsp;");
					sm.append(mcal.getComponent());
				}
				if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI)){
					sm.append("<br>&nbsp;-&nbsp;");
					sm.append("<strong>");
					sm.append(LanguageUtil.get(pageContext, "sponsor") + "</strong>:&nbsp;");
					sm.append(event.getTitle());
				}
				sm.append("</font>',");
			}
		}
	}
}
sm.append("]");
eventsStr = sm.toString();

if(eventsStr.equals("[]")){
	sm2.append("[");
	sm2.append("'<font class=\"font_content\">");
	sm2.append(LanguageUtil.get(pageContext, "have-no-meeting-calendar-in-day"));
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
	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td valign="top" style="padding: 4px;">
				<marquee id="slideShow1" behavior="slide" direction="up" height="150" style="filter: revealTrans(TRANSITION=2)"></marquee>
				<script language="JavaScript">initScrollImg()</script>						
			</td>
		</tr>
	</table>
</form>
<script language="JavaScript">start_show()</script>