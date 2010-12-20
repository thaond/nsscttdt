/**
 * <a href="MeetingDetailWeekLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAI TRIEU
 *
 */
package com.ext.portlet.meetingcalendar.service.impl;

import com.ext.portlet.meetingcalendar.model.MeetingDetailWeek;
import com.ext.portlet.meetingcalendar.service.base.MeetingDetailWeekLocalServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.User;
import com.ext.portlet.meetingcalendar.FocusException;
import com.ext.portlet.meetingcalendar.DuplicateFocusException;

import com.liferay.portal.kernel.util.Validator;

public class MeetingDetailWeekLocalServiceImpl
    extends MeetingDetailWeekLocalServiceBaseImpl {
	
	public MeetingDetailWeek addMeetingDetailWeek(long userId,String focus, String note, String receive, 
				int weekOfYear, int year)
		throws PortalException, SystemException {
		
		long mdweekId = counterLocalService.increment();
		MeetingDetailWeek meetingDetailWeek = meetingDetailWeekPersistence.create(mdweekId);
		User user = userPersistence.findByPrimaryKey(userId);
		//check validate
		validate(weekOfYear, year);
		validateFocus(focus);
		//set Property value
		meetingDetailWeek.setUserId(user.getUserId());
		meetingDetailWeek.setGroupId(user.getGroup().getGroupId());
		meetingDetailWeek.setCompanyId(user.getCompanyId());
		meetingDetailWeek.setUserName(user.getFullName());
		
		meetingDetailWeek.setFocus(focus);
		meetingDetailWeek.setNote(note);
		meetingDetailWeek.setReceive(receive);
		meetingDetailWeek.setWeek(weekOfYear);
		meetingDetailWeek.setYear(year);
		
		meetingDetailWeekPersistence.update(meetingDetailWeek,false);
		
		return meetingDetailWeek;
	}
	
	public MeetingDetailWeek updateMeetingDetailWeek(long mdweekId, long userId, String focus, String note, String receive, 
			int weekOfYear, int year)
	throws PortalException, SystemException {
	
		MeetingDetailWeek oldmeetingDetailWeek = meetingDetailWeekPersistence.fetchByPrimaryKey(mdweekId);
		User user = userPersistence.findByPrimaryKey(userId);
		
		//set Property value
		oldmeetingDetailWeek.setUserId(user.getUserId());
		oldmeetingDetailWeek.setGroupId(user.getGroup().getGroupId());
		oldmeetingDetailWeek.setCompanyId(user.getCompanyId());
		oldmeetingDetailWeek.setUserName(user.getFullName());
		
		oldmeetingDetailWeek.setFocus(focus);
		oldmeetingDetailWeek.setNote(note);
		oldmeetingDetailWeek.setReceive(receive);
		oldmeetingDetailWeek.setWeek(weekOfYear);
		oldmeetingDetailWeek.setYear(year);
		
		meetingDetailWeekPersistence.update(oldmeetingDetailWeek,false);
		
		return oldmeetingDetailWeek;
	}
	
	public MeetingDetailWeek FindPrimaryKey(long mdweekId)
		throws PortalException, SystemException {
		
		try{
			return meetingDetailWeekPersistence.findByPrimaryKey(mdweekId);
						
		}
		catch (Exception ex){
			return null;
		}
	} 				
	
	public MeetingDetailWeek getWeekYear(int week, int year) 
		throws PortalException, SystemException {
	
		try {
			return meetingDetailWeekPersistence.findByW_Y(week, year);
		}
		catch (Exception ex) {
			return null;
		}
	}
	//Check week, year null
	protected void validate(int week, int year) 
		throws PortalException, SystemException{
		if (getWeekYear(week, year)!= null){
			throw new DuplicateFocusException();
		}
	}
	//Check focus
	protected void validateFocus(String focus) 
		throws PortalException, SystemException{
		if (Validator.isNull(focus)){
			throw new FocusException();
		}			
	}
	
	
}
