package com.ext.portlet.meetingcalendar.util;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.rtf.RTFUtil;
import net.sourceforge.rtf.template.IContext;

import com.ext.portlet.meetingcalendar.dto.MeetingCalendarDTO;

/**
 *
 * @author Dao Duy Duong * 
 * @author Hai Trieu
 *
 */
public class MeetingCalendarPrintUtil extends RTFUtil {
	private List<MeetingCalendarDTO> meetingCalendarList;
	private String nowDay = "";
	private String nowMonth = "";
	private String nowYear = "";
	private String weekParam = "";
	private String formDate = "";
	private String toDate = "";
	private String focus = "";
	private String note = "";
	private String receive = "";
	
	public MeetingCalendarPrintUtil(String outDirectory) {
		super(outDirectory);
	}
	
	public MeetingCalendarPrintUtil(String outDirectory, List<MeetingCalendarDTO> meetingCalendarList,
			String nowDay, String nowMonth, String nowYear, String weekParam,
			String formDate, String toDate, String focus, String note, String receive) {
		super(outDirectory);
		this.meetingCalendarList = new ArrayList<MeetingCalendarDTO>();
		this.meetingCalendarList.addAll(meetingCalendarList);
		this.nowDay = nowDay;
		this.nowMonth = nowMonth;
		this.nowYear = nowYear;
		this.weekParam = weekParam;
		this.formDate = formDate;
		this.toDate = toDate;
		this.focus = focus;
		this.note = note;
		this.receive = receive;
	}

	protected void putContext(IContext context) {
		context.put("Cal", this.meetingCalendarList);
		context.put("day", this.nowDay);
		context.put("month", this.nowMonth);
		context.put("year", this.nowYear);
		context.put("week", this.weekParam);
		context.put("formDate", this.formDate);
		context.put("toDate", this.toDate);
		context.put("focus", this.focus);
		context.put("note", this.note);
		context.put("receive", this.receive);
	}
}