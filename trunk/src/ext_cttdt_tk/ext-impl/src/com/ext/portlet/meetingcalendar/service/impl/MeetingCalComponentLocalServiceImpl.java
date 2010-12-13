package com.ext.portlet.meetingcalendar.service.impl;

import com.ext.portlet.meetingcalendar.model.MeetingCalComponent;
import com.ext.portlet.meetingcalendar.service.MeetingCalComponentLocalServiceUtil;
import com.ext.portlet.meetingcalendar.service.base.MeetingCalComponentLocalServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.model.Organization;
import com.liferay.portal.model.Group;

import java.util.Date;
import java.util.List;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Calendar;
import com.liferay.portal.kernel.util.CalendarUtil;

public class MeetingCalComponentLocalServiceImpl
    extends MeetingCalComponentLocalServiceBaseImpl {
	
	public void addMCalComponent(long mcalId, String[] orgIds, Date startDate) throws SystemException,PortalException{
		String groupIds = StringPool.BLANK;
		for(int i=0; i< orgIds.length; i++){
			Organization organization = organizationPersistence.findByPrimaryKey(Long.valueOf(orgIds[i]));
			Group group = organization.getGroup();
			if(i == orgIds.length-1){
				groupIds = groupIds + group.getGroupId();
			}
			else{
				groupIds = groupIds + group.getGroupId() + ",";
			}
		}
		MeetingCalComponent mcalComp = meetingCalComponentPersistence.create(mcalId);
		mcalComp.setGroupIds(groupIds);
		mcalComp.setStartDate(startDate);
		meetingCalComponentPersistence.update(mcalComp, false);
		
	}
	
	public void updateMCalComponent(long mcalId, String[] orgIds, Date startDate) throws SystemException, PortalException{
		String groupIds = StringPool.BLANK;
		for(int i=0; i< orgIds.length; i++){
			Organization organization = organizationPersistence.findByPrimaryKey(Long.valueOf(orgIds[i]));
			Group group = organization.getGroup();
			if(i == orgIds.length-1){
				groupIds = groupIds + group.getGroupId();
			}
			else{
				groupIds = groupIds + group.getGroupId() + ",";
			}
		}
		MeetingCalComponent mcalComp = null;
		try{
			mcalComp = meetingCalComponentPersistence.findBymcalId(mcalId);
		}
		catch(Exception e){
		}
		if(mcalComp==null){
			mcalComp = meetingCalComponentPersistence.create(mcalId);
		}
		mcalComp.setGroupIds(groupIds);
		mcalComp.setStartDate(startDate);
		meetingCalComponentPersistence.update(mcalComp, false);
		
	}
	
	public void deleteMCalComponent(long mcalId) throws SystemException,PortalException{
		MeetingCalComponent mcalComp = null;
		try{
			mcalComp = meetingCalComponentPersistence.findBymcalId(mcalId);
		}
		catch(Exception e){
		}
		
		if(mcalComp!=null){
				MeetingCalComponentLocalServiceUtil.deleteMeetingCalComponent(mcalComp);
		}
	}
	
	public MeetingCalComponent getBymcalId (long mcalId) throws SystemException, PortalException{
		return meetingCalComponentPersistence.findBymcalId(mcalId);
	}
	
	public List<MeetingCalComponent> getByG_SD (long groupId, Calendar cal) throws SystemException, PortalException{
		return meetingCalComponentFinder.findByG_SD(
			groupId, CalendarUtil.getGTDate(cal),
			CalendarUtil.getLTDate(cal));
	}
}
