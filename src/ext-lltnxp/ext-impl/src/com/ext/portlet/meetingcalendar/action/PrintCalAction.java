
package com.ext.portlet.meetingcalendar.action;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.kernel.util.DateFormats;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portlet.calendar.NoSuchEventException;
import com.liferay.portlet.calendar.service.CalEventLocalServiceUtil;
import com.liferay.util.servlet.ServletResponseUtil;
import com.liferay.portal.model.User;
import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;
import com.ext.portlet.meetingcalendar.model.MeetingDetailWeek;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil;
import com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalServiceUtil;
import com.ext.portlet.meetingcalendar.service.MeetingDetailWeekLocalServiceUtil;
import com.ext.portlet.meetingcalendar.dto.MeetingCalendarDTO;
import com.ext.portlet.meetingcalendar.util.MeetingCalendarPrintUtil;
import com.ext.portlet.meetingcalendar.util.comparator.EventTimeComparator;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.io.InputStream;
import java.text.SimpleDateFormat;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sourceforge.rtf.StringUtils;


/**
 *
 * @author Dao Duy Duong
 * @author Hai Trieu
 * @update date: 20091026
 *
 */
public class PrintCalAction extends PortletAction {

	public void processAction(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String reportType = ParamUtil.getString(actionRequest, "reportType");
		if(Validator.isNull(reportType) == false && "".equals(reportType) == false) {
			if(reportType.equals("word")) { // xuat ra file word
				xuatFileWord(actionRequest, actionResponse);
			}
		}
	}
	
	public ActionForward render(
			ActionMapping mapping, ActionForm form, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws Exception {

		try {
			ActionUtil.getEvent(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof NoSuchEventException ||
				e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass().getName());

				return mapping.findForward("portlet.ext.meeting_calendar.error");
			}
			else {
				throw e;
			}
		}
		return mapping.findForward(
			getForward(renderRequest, "portlet.ext.meeting_calendar.view"));
	}
	
	private List<MeetingCalendarDTO> getMeetingCalendarList(ActionRequest req, long groupId,
			Calendar selCal, String eventType , String tabs1_) throws Exception {
		Locale locale = null;
		TimeZone timeZone = null;
		User user = PortalUtil.getUser(req);
		locale = user.getLocale();
		timeZone = user.getTimeZone();
		String bSt = "\\b ";//"\\ltrch\\fcs0 \\b";// tao the in dam trong rtf 
		String bEn = " \\b0 ";//"\\rtlch\\fcs1";
		String par = "\\par ";
		
		DateFormat dateFormatTime = DateFormats.getTime(locale);
		DateFormat dateFormatDayOfWeek = new SimpleDateFormat("E", locale);
		DateFormat dateFormatMonthAndDay = new SimpleDateFormat("d/M", locale);
		
		List<MeetingCalendarDTO> meetingCalendarList = new ArrayList<MeetingCalendarDTO>();
		
		Calendar cal = (Calendar)selCal.clone();
		// DuyDuong add: get Monday is first on week
		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 2;
		cal.add(Calendar.DATE, -firstDayOfWeek);
		
		for (int i = 0; i < 6; i++) {
			// truong du lieu DTO thu ngay thang
			StringBuilder sbthu_ngay = new StringBuilder();
			if(user.getLanguageId().equals("vi_VN")){
				String thu = "";
				//= StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))), 
						//"Th", LanguageUtil.get(locale, "thu-trong-tuan" ));
				if (dateFormatDayOfWeek.format(Time.getDate(cal)).equals("Th 2")){
					thu = StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))), 
							"Th 2", LanguageUtil.get(locale, "thu-2" ));
				}
				else if (dateFormatDayOfWeek.format(Time.getDate(cal)).equals("Th 3")){
					thu = StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))), 
							"Th 3", LanguageUtil.get(locale, "thu-3" ));
				}
				else if (dateFormatDayOfWeek.format(Time.getDate(cal)).equals("Th 4")){
					thu = StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))), 
							"Th 4", LanguageUtil.get(locale, "thu-4" ));
				}
				else if (dateFormatDayOfWeek.format(Time.getDate(cal)).equals("Th 5")){
					thu = StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))), 
							"Th 5", LanguageUtil.get(locale, "thu-5" ));
				}
				else if (dateFormatDayOfWeek.format(Time.getDate(cal)).equals("Th 6")){
					thu = StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))), 
							"Th 6", LanguageUtil.get(locale, "thu-6" ));
				}
				else if (dateFormatDayOfWeek.format(Time.getDate(cal)).equals("Th 7")){
					thu = StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))), 
							"Th 7", LanguageUtil.get(locale, "thu-7" ));
				}
				else
					thu = StringUtil.replace(StringUtil.trim(dateFormatDayOfWeek.format(Time.getDate(cal))), 
					"Th", LanguageUtil.get(locale, "thu-trong-tuan" ));
				sbthu_ngay.append(thu);
			}
			else{
				sbthu_ngay.append(dateFormatDayOfWeek.format(Time.getDate(cal)));
			}
			sbthu_ngay.append("   " + dateFormatMonthAndDay.format(Time.getDate(cal))); //
			String thu_ngay = StringUtils.convertToRTF(sbthu_ngay.toString());
			// lay list lich chinh xac
			List events = CalEventLocalServiceUtil.getEvents(groupId, cal, eventType);
			Collections.sort(events, new EventTimeComparator(timeZone, locale));
			List eventsOrg = new ArrayList();
			List mcalComps = null;
			try{
				mcalComps = MeetingCalComponentLocalServiceUtil.getByG_SD(groupId, cal);
			}
			catch(Exception e){
			}
			if(mcalComps!=null){
				for(int j=0; j<mcalComps.size(); j++){
					MeetingCalComponent mcalComp = (MeetingCalComponent)mcalComps.get(j);
					CalEvent cale1 = CalEventLocalServiceUtil.getEvent(mcalComp.getMcalId());
					MeetingCalendar mcale = MeetingCalendarLocalServiceUtil.getMeetingCalendar(
							mcalComp.getMcalId());
					if(mcale.getState() == MeetingCalendarKey.DA_DUYET){
						eventsOrg.add(cale1);
					}
				}
			}
			
			List eventsDuyet = new ArrayList();
			List eventsDuyet_E = new ArrayList();
			
			if(eventsOrg.size()!=0){
				for(int j=0; j<eventsOrg.size(); j++){
					CalEvent cale1 = (CalEvent)eventsOrg.get(j);
					eventsDuyet.add(cale1);
					eventsDuyet_E.add(cale1);
				}
			}
			Collections.sort(eventsDuyet, new EventTimeComparator(timeZone, locale));
			Collections.sort(eventsDuyet_E, new EventTimeComparator(timeZone, locale));
			/*List mcalSTTs = null;
			try{
				mcalSTTs = MeetingCalendarLocalServiceUtil.getByG_SD(groupId, cal, eventType);
			}
			catch(Exception e){
			}
			
			if(mcalSTTs==null){
				mcalSTTs=events;
			}
			for(int j=0; j<mcalSTTs.size(); j++){
				MeetingCalendar mcale = (MeetingCalendar)mcalSTTs.get(j);
				CalEvent cale1 = CalEventLocalServiceUtil.getEvent(mcale.getMcalId());*/
			for(int j=0; j<events.size(); j++){
				CalEvent cale1 = (CalEvent)events.get(j);
				MeetingCalendar mcale = MeetingCalendarLocalServiceUtil.getMeetingCalendar(cale1.getEventId());
				// isTimeZoneSensitive is true
				Date stEvent = null;
				if(cale1.isTimeZoneSensitive()){
					stEvent = Time.getDate(cale1.getStartDate(), timeZone);
				}
				else{
					stEvent = cale1.getStartDate();
				}
				if((mcale.getState() != MeetingCalendarKey.DOI) && 
						(mcale.getState() != MeetingCalendarKey.HUY)){
					if(tabs1_.equals("calendar-release")){
						if(mcale.getState() != MeetingCalendarKey.CHO_DUYET){
							if(stEvent.getHours()<=12){
								eventsDuyet.add(cale1);
							}
							else if (stEvent.getHours()>12){
								eventsDuyet_E.add(cale1);
							}
						}
					}
					else{
						if(stEvent.getHours()<=12){
							eventsDuyet.add(cale1);
						}
						else if (stEvent.getHours()>12){
							eventsDuyet_E.add(cale1);
						}
					}
				}
			}
			// truong du lieu DTO buoi sang
			StringBuilder sbbuoisang = new StringBuilder();
			for (int j = 0; j < eventsDuyet.size(); j++) {
				CalEvent event = (CalEvent)eventsDuyet.get(j);
				MeetingCalendar mcal = null;
				try{
					mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
				}
				catch(Exception ex){
					mcal = null;
				}
				// kt event chi co trong 1 bang
				if(mcal!=null){
					sbbuoisang.append(" - ");
					// thoi gian hop
					if(event.isTimeZoneSensitive()){
						sbbuoisang.append(bSt + dateFormatTime.format(Time.getDate(
								event.getStartDate(), timeZone)) + bEn + " ");
					}
					else{
						sbbuoisang.append(bSt + dateFormatTime.format(event.getStartDate()) + bEn + " ");
					}
					// nguoi chu tri
					if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI) && 
							!event.getTitle().equals(StringPool.BLANK)){
						sbbuoisang.append(event.getTitle() + "; ");
					}
					// noi dung
					sbbuoisang.append(event.getDescription().replaceAll("\\<.*?\\>", "") + "; ");
					// dia diem
					if(Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())){
						sbbuoisang.append(LanguageUtil.get(locale, "tai-noi") + " ");
						if(Validator.isNotNull(mcal.getPlace())){
							sbbuoisang.append(LanguageUtil.get(locale, mcal.getPlace()) + "; ");
						}
						else{
							sbbuoisang.append(mcal.getPlace_diff() + "; ");
						}
					}
					// thanh phan
					if(Validator.isNotNull(mcal.getComponent())){
						sbbuoisang.append("TP: " + mcal.getComponent() + "; ");
					}
					// ghi chu
					if(Validator.isNotNull(mcal.getNote())){
						sbbuoisang.append(mcal.getNote() + ";   "); // 
					}
					sbbuoisang.append(par);
				}	
			}
			String buoisang = StringUtils.convertToRTF(sbbuoisang.toString());
			int starttag = 1;
			int endtag = 1;
			String result = "";
			while (starttag >= 0 && endtag > 0){
				 starttag = buoisang.toLowerCase().indexOf("<");
				 endtag = buoisang.toLowerCase().indexOf(">");

				if (starttag >= 0 &&  endtag > 0 && endtag < buoisang.length()){
					if(starttag < endtag){
						result = buoisang.substring(starttag,endtag +1);
						buoisang = buoisang.replace(result,"");
					}
					else{
						break;
					}
					
				}
			}
			// truong du lieu DTO buoi chieu
			StringBuilder sbbuoichieu = new StringBuilder();
			for (int j = 0; j < eventsDuyet_E.size(); j++) {
				CalEvent event = (CalEvent)eventsDuyet_E.get(j);
				MeetingCalendar mcal = null;
				try{
					mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(event.getEventId());
				}
				catch(Exception ex){
					mcal = null;
				}
				// kt event chi co trong 1 bang
				if(mcal!=null){
					sbbuoichieu.append(" - ");
					// thoi gian hop
					if(event.isTimeZoneSensitive()){
						sbbuoichieu.append(bSt + dateFormatTime.format(Time.getDate(
								event.getStartDate(), timeZone)) + bEn + " ");
					}
					else{
						sbbuoichieu.append(bSt + dateFormatTime.format(event.getStartDate()) + bEn + " ");
					}
					// nguoi chu tri
					if(!event.getTitle().equals(MeetingCalendarKey.KHONG_CO_CHU_TRI) && 
							!event.getTitle().equals(StringPool.BLANK)){
						sbbuoichieu.append(event.getTitle() + " ");
					}
					// noi dung
					sbbuoichieu.append(event.getDescription().replaceAll("\\<.*?\\>", "") + " ");
					// dia diem
					if(Validator.isNotNull(mcal.getPlace()) || Validator.isNotNull(mcal.getPlace_diff())){
						sbbuoichieu.append(LanguageUtil.get(locale, "tai-noi") + " ");
						if(Validator.isNotNull(mcal.getPlace())){
							sbbuoichieu.append(LanguageUtil.get(locale, mcal.getPlace()) + "; ");
						}
						else{
							sbbuoichieu.append(mcal.getPlace_diff() + "; ");
						}
					}
					// thanh phan
					if(Validator.isNotNull(mcal.getComponent())){
						sbbuoichieu.append("TP: " + mcal.getComponent() + "; ");
					}
					// ghi chu
					if(Validator.isNotNull(mcal.getNote())){
						sbbuoichieu.append(mcal.getNote() + ";  "); //
					}
					sbbuoichieu.append(par);
				}	
			}
			String buoichieu = StringUtils.convertToRTF(sbbuoichieu.toString());
			starttag = 1;
			endtag = 1;
			result = "";
			while (starttag >= 0 && endtag > 0){
				 starttag = buoichieu.toLowerCase().indexOf("<");
				 endtag = buoichieu.toLowerCase().indexOf(">");

				if (starttag >= 0 &&  endtag > 0 && endtag < buoichieu.length()){
					if(starttag < endtag){
						result = buoichieu.substring(starttag,endtag +1);
						buoichieu = buoichieu.replace(result,"");
					}
					else{
						break;
					}
					
				}
			}
			// tao va them cac truong du lieu vao DTO
			MeetingCalendarDTO meetingCalendarDTO = new MeetingCalendarDTO();
			meetingCalendarDTO.setThuNgay(thu_ngay);
			meetingCalendarDTO.setBuoiSang(buoisang);
			meetingCalendarDTO.setBuoiChieu(buoichieu);
			meetingCalendarList.add(meetingCalendarDTO);
			//tang ngay len 1
			cal.add(Calendar.DATE, 1);
		}
		return meetingCalendarList;
	}

	private void xuatFileWord(ActionRequest req, ActionResponse res) throws Exception {
		Locale locale = null;
		TimeZone timeZone = null;
		User user = PortalUtil.getUser(req);
		locale = user.getLocale();
		timeZone = user.getTimeZone();
		
		DateFormat dateFormatDate = DateFormats.getDate(locale);	
		
		String monthParam = ParamUtil.getString(req, "month");
		String dayParam = ParamUtil.getString(req, "day");
		String yearParam = ParamUtil.getString(req, "year");
		String DateNow  = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		String nowDay = DateNow.substring(0,2);
		String nowMoth = DateNow.substring(3,5);
		String nowYear = DateNow.substring(6,10);
		String weekParam = ParamUtil.getString(req, "week");
		int weekNumber = Integer.parseInt(weekParam);
		if (weekNumber >= 2)
			weekNumber = weekNumber - 1;
		weekParam = String.valueOf(weekNumber);
		Calendar selCal = CalendarFactoryUtil.getCalendar(timeZone, locale);

		try {
			selCal.set(Calendar.YEAR, Integer.parseInt(yearParam));
		}
		catch (NumberFormatException nfe) {
		}

		try {
			if (dayParam != null) {
				selCal.set(Calendar.DATE, 1);
			}
			

			selCal.set(Calendar.MONTH, Integer.parseInt(monthParam));
		}
		catch (NumberFormatException nfe) {
		}

		try {
			int maxDayOfMonth = selCal.getActualMaximum(Calendar.DATE);

			int dayParamInt = Integer.parseInt(dayParam);

			if (dayParamInt > maxDayOfMonth) {
				dayParamInt = maxDayOfMonth;
			}

			selCal.set(Calendar.DATE, dayParamInt);
		}
		catch (NumberFormatException nfe) {
		}
		Calendar cal = (Calendar)selCal.clone();
		long userId = user.getUserId();
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
			focus = meetingDetailWeekes.getFocus().toString();
			int starttag = 1;
			int endtag = 1;
			String result = "";
			String meta = "";
			String par = "\\par ";
			
			int metaNumStart = 1;
			int metaNumEnd = 1;
			if (!focus.equals("") & focus != null){
				metaNumStart = focus.toLowerCase().indexOf("<meta");
				metaNumEnd = focus.toLowerCase().lastIndexOf("</meta>");
				if (metaNumStart >=0 && metaNumEnd > 0 && metaNumEnd < focus.length()){
					if (metaNumStart < metaNumEnd){
						meta = focus.substring(metaNumStart, metaNumEnd + 7);
						focus = focus.replace(meta, "");
					}
				} //end if
				while (starttag >= 0 && endtag > 0){
					 starttag = focus.toLowerCase().indexOf("<");
					 endtag = focus.toLowerCase().indexOf(">");
	
					if (starttag >= 0 &&  endtag > 0 && endtag < focus.length()){
						if (starttag < endtag){
							result = focus.substring(starttag, endtag +1);
							if (!result.equals("") & result != null){
								if (result.equals("<br />")){
									focus = focus.replace("<br />", par);
								}
								else if (result.equals("</p>")){
									focus = focus.replace("</p>", par);
								}
								else
									focus = focus.replace(result, "");
							}
						}
						else {
							break;
						}
						
					}
				} // end while
				focus = focus.replaceAll("&amp;", "&");
				focus = focus.replaceAll("&nbsp;", " ");
				focus = focus.replaceAll("\\<.*?\\>", "");
				focus = StringUtils.convertToRTF(focus.trim());
			} // end if
			
			note = meetingDetailWeekes.getNote().toString();
			starttag = 1;
			endtag = 1;
			result = "";
			if (!note.equals("") & note != null) {
				while (starttag >= 0 && endtag > 0){
					 starttag = note.toLowerCase().indexOf("<");
					 endtag = note.toLowerCase().indexOf(">");
	
					if (starttag >= 0 &&  endtag > 0 && endtag < note.length()){
						if(starttag < endtag){
							result = note.substring(starttag,endtag +1);
							note = note.replace(result, par);
						}
						else{
							break;
						}
						
					}
				} // end while
			} // end if
			note = StringUtils.convertToRTF(note);
			receive = meetingDetailWeekes.getReceive().toString();		
			starttag = 1;
			endtag = 1;
			result = "";
			if (!receive.equals("") & receive != null) {
				while (starttag >= 0 && endtag > 0){
					 starttag = receive.toLowerCase().indexOf("<");
					 endtag = receive.toLowerCase().indexOf(">");
	
					if (starttag >= 0 &&  endtag > 0 && endtag < receive.length()){
						if(starttag < endtag){
							result = receive.substring(starttag,endtag +1);
							receive = receive.replace(result, par);
							
						}
						else{
							break;
						}						
					}
				} // end while
				receive = StringUtils.convertToRTF(receive);
			} // end if
			week = meetingDetailWeekes.getWeek();
			year = meetingDetailWeekes.getYear();
		}		
		int firstDayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 2;
		cal.add(Calendar.DATE, -firstDayOfWeek);
		String formDate = dateFormatDate.format(Time.getDate(cal));
		cal.add(Calendar.DATE, 6);
		String toDate =dateFormatDate.format(Time.getDate(cal));	
		
		// lay thoi gian thu 6 tuan truoc la thoi gian phat hanh
		cal.add(Calendar.DATE, -9);
		String dateRelease = dateFormatDate.format(Time.getDate(cal));
		if (dateRelease.length() == 10)
		{
			nowDay = dateRelease.substring(0, 2);
			nowMoth = dateRelease.substring(3 , 5);
			nowYear = dateRelease.substring(6, 10);
		}		
		
		long groupId = Long.parseLong(ParamUtil.getString(req, "groupId"));
		String eventType = ParamUtil.getString(req, "eventType");
		String tabs1_ = ParamUtil.getString(req, "tabs1_");
		
		HttpServletRequest request = PortalUtil.getHttpServletRequest(req);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(res);
		
		MeetingCalendarPrintUtil rtfUtil = new MeetingCalendarPrintUtil(
				request.getSession().getServletContext().getRealPath("reports"),
				getMeetingCalendarList(req, groupId, selCal, eventType, tabs1_), nowDay,
				nowMoth, nowYear, weekParam, formDate, toDate, 
				focus, note, receive);
		
		InputStream in = rtfUtil.run(
				request.getSession().getServletContext().getRealPath("reports/MeetingCalendar.rtf"));
		ServletResponseUtil.sendFile(response, "Lich_Tuan.rtf", in, "application/rtf");
	}
}