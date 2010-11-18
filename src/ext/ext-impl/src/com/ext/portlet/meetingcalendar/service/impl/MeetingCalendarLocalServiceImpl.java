package com.ext.portlet.meetingcalendar.service.impl;

import com.liferay.documentlibrary.NoSuchFileException;
import com.ext.portlet.meetingcalendar.action.MeetingCalendarKey;
import com.ext.portlet.meetingcalendar.model.MeetingCalendar;
import com.ext.portlet.meetingcalendar.service.MeetingCalendarLocalServiceUtil;
import com.ext.portlet.meetingcalendar.service.base.MeetingCalendarLocalServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.calendar.model.CalEvent;
import com.liferay.portal.model.CompanyConstants;
import com.liferay.portal.model.GroupConstants;
import java.util.Date;
import java.util.List;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.documentlibrary.service.*;
import com.liferay.portal.kernel.util.StringPool;

import java.util.Calendar;
import com.liferay.portal.kernel.util.CalendarUtil;

public class MeetingCalendarLocalServiceImpl
    extends MeetingCalendarLocalServiceBaseImpl {
	
	public MeetingCalendar getMCalById (long Id)throws SystemException,PortalException{
		return meetingCalendarPersistence.findByPrimaryKey(Id);
	}
	
	public MeetingCalendar addMCal(
			String place,String place_diff,String component,String note,
			CalEvent calevent,boolean repeatWeek, 
			ObjectValuePair<String, byte[]> file, String fileName, 
			boolean morning, boolean afternoon, boolean evening, boolean prior)throws SystemException,PortalException{
		return addMCal(
				place, place_diff, component, note, 
				calevent, MeetingCalendarKey.CHO_DUYET,repeatWeek,
				file, fileName, morning, afternoon, evening, prior);
	}
	
	public MeetingCalendar addMCal(
			String place,String place_diff,String component,String note,
			CalEvent calevent,int state, boolean repeatWeek,
			ObjectValuePair<String, byte[]> file, String fileName,
			boolean morning, boolean afternoon, boolean evening, boolean prior)throws SystemException,PortalException {
		
		//validate(place, place_diff);
		MeetingCalendar mcal = meetingCalendarPersistence.create(calevent.getEventId());
		mcal.setGroupId(calevent.getGroupId());
		mcal.setCompanyId(calevent.getCompanyId());
		mcal.setPlace(place);
		mcal.setPlace_diff(place_diff);
		mcal.setComponent(component);
		mcal.setNote(note);
		mcal.setState(state);
		mcal.setUserId(calevent.getUserId());
		mcal.setUserName(calevent.getUserName());
		mcal.setRepeatWeek(repeatWeek);
		mcal.setMorning(morning);
		mcal.setAfternoon(afternoon);
		mcal.setEvening(evening);
		mcal.setPrior(prior);
		mcal.setStt(0);
		// file dinh kem
		if(!fileName.equals("") && fileName!=null){
			long companyId = mcal.getCompanyId();
			String portletId = CompanyConstants.SYSTEM_STRING;
			long groupId = GroupConstants.DEFAULT_PARENT_GROUP_ID;
			long repositoryId = CompanyConstants.SYSTEM;
			String dirName = getDirName() + "/" + String.valueOf(mcal.getMcalId());
			
			try {
				DLService dlService = DLServiceFactory.getService();

				try {
					dlService.addDirectory(companyId, repositoryId, dirName);
				}
				catch (Exception exAdd) {
					System.out.println(exAdd.toString());
				}

				
				String filename = file.getKey();
				byte[] byteArray = file.getValue();
				/*
				long fileEntryId = CounterLocalServiceUtil.increment();
				dlService.addFile(
					companyId, portletId, groupId, repositoryId,
					dirName + "/" + filename, fileEntryId, StringPool.BLANK, new Date(),
					new String[0], new String[0], byteArray);
				*/

				dlService.addFile(
						companyId, portletId, groupId, repositoryId,
						dirName + "/" + filename, repositoryId, StringPool.BLANK,
						null, new String[0], null, byteArray);

				mcal.setFilename(fileName);
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				throw new SystemException();
			}
		}
		return meetingCalendarPersistence.update(mcal, false);
	}
	
	public MeetingCalendar approveMCal(long userApproved,long mcalId)throws SystemException,PortalException{
		MeetingCalendar mcal = null;
		Date now = new Date();
		mcal = meetingCalendarPersistence.findByPrimaryKey(mcalId);
		if(Validator.isNotNull(mcal)){
			mcal.setState(MeetingCalendarKey.DA_DUYET);
			mcal.setDateApproved(now);
			mcal.setUserApproved(userApproved);
		}
		meetingCalendarPersistence.update(mcal, false);
		return mcal;
	}
	
	public MeetingCalendar deleteMCal(long mcalId)throws SystemException,PortalException{
		MeetingCalendar mcal = null;
		mcal = MeetingCalendarLocalServiceUtil.getMeetingCalendar(mcalId);
		if(Validator.isNotNull(mcal)){
			MeetingCalendarLocalServiceUtil.deleteMeetingCalendar(mcal);
			
			//code xoa file upload kem theo
			long companyId = mcal.getCompanyId();
			String portletId = CompanyConstants.SYSTEM_STRING;
			long repositoryId = CompanyConstants.SYSTEM;
			
			DLService dlService = DLServiceFactory.getService();
			if (mcal.getFilename().trim().length() > 0) {
				String fileName = getDirName() + "/"
						+ String.valueOf(mcal.getMcalId()) + "/"
						+ mcal.getFilename();
				try {
					dlService.deleteFile(companyId, portletId, repositoryId, fileName);
				} 
				catch (Exception ex) {
					System.out.println(ex.getMessage());
					if (ex instanceof NoSuchFileException) {
						// Do nothing
					}
					else {
						throw new SystemException();
					}
				}
			}
		}
		return mcal;
	}
	
	public MeetingCalendar updateMCal(
			long mcalId, String place, String place_diff, 
			String component, String note, boolean repeatWeek, 
			ObjectValuePair<String, byte[]> file, 
			boolean morning, boolean afternoon, boolean evening, boolean prior)throws SystemException,PortalException{
	//	validate(place, place_diff);
		MeetingCalendar mcal = null;
		mcal = meetingCalendarPersistence.findByPrimaryKey(mcalId);
		mcal.setPlace(place);
		mcal.setPlace_diff(place_diff);
		mcal.setComponent(component);
		mcal.setNote(note);
		mcal.setRepeatWeek(repeatWeek);
		mcal.setMorning(morning);
		mcal.setAfternoon(afternoon);
		mcal.setEvening(evening);
		mcal.setPrior(prior);
		//xoa file cu, upload lai file moi
		long companyId = mcal.getCompanyId();
		String portletId = CompanyConstants.SYSTEM_STRING;
		long groupId = GroupConstants.DEFAULT_PARENT_GROUP_ID;
		long repositoryId = CompanyConstants.SYSTEM;
		String dirName = getDirName() + "/" + String.valueOf(mcal.getMcalId());
		String oldName = mcal.getFilename();
		String filename = file.getKey();
		if(filename!=null){
			if(!filename.equals(oldName)){
			try {
				DLService dlService = DLServiceFactory.getService();

				try {
					
					dlService.addDirectory(companyId, repositoryId, dirName);
				}
				catch (Exception exAdd) {
					System.out.println(exAdd.toString());
				}

				byte[] byteArray = file.getValue();

				// Check fileName
				if (filename != null && filename.trim().length() > 0) { // change file
					// Set properties
					mcal.setFilename(filename);
					
					// Delete old file
					if (oldName != null && oldName.trim().length() > 0) {
						String deleteName = dirName + "/" + oldName;
						try {
							dlService.deleteFile(companyId, portletId, repositoryId, deleteName);
							
						}
						catch(Exception exDel) {
							if (exDel instanceof NoSuchFileException) {
								// Do nothing
							}
							else {
								throw new SystemException();
							}
						}
					}

					// Add new file
					/*
					long fileEntryId = CounterLocalServiceUtil.increment();
					dlService.addFile(
							companyId, portletId, groupId, repositoryId,
							dirName + "/" + filename,fileEntryId, StringPool.BLANK,new Date(),
							new String[0],new String[0], byteArray);
					*/
					dlService.addFile(
							companyId, portletId, groupId, repositoryId,
							dirName + "/" + filename, repositoryId, StringPool.BLANK,
							null, new String[0], null, byteArray);
				}
				
				
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				throw new SystemException();
			}
			}
		}
		return meetingCalendarPersistence.updateImpl(mcal, false);
	}
	
	public MeetingCalendar updateMCal(
			long mcalId, String place, String place_diff,
			String component, String note, int state, boolean repeatWeek, 
			ObjectValuePair<String, byte[]> file,
			boolean morning, boolean afternoon, boolean evening, boolean prior)throws SystemException,PortalException{
		MeetingCalendar mcal = null;
		mcal = meetingCalendarPersistence.findByPrimaryKey(mcalId);
		mcal.setPlace(place);
		mcal.setPlace_diff(place_diff);
		mcal.setComponent(component);
		mcal.setNote(note);
		mcal.setState(state);
		mcal.setRepeatWeek(repeatWeek);
		mcal.setMorning(morning);
		mcal.setAfternoon(afternoon);
		mcal.setEvening(evening);
		mcal.setPrior(prior);
		
		//xoa file cu, upload lai file moi
		long companyId = mcal.getCompanyId();
		String portletId = CompanyConstants.SYSTEM_STRING;
		long groupId = GroupConstants.DEFAULT_PARENT_GROUP_ID;
		long repositoryId = CompanyConstants.SYSTEM;
		String dirName = getDirName() + "/" + String.valueOf(mcal.getMcalId());
		String oldName = mcal.getFilename();
		String filename = file.getKey();
		if(!oldName.equals(filename) && !filename.equals("") && filename!=null){
			try {
				DLService dlService = DLServiceFactory.getService();

				try {
					
					dlService.addDirectory(companyId, repositoryId, dirName);
				}
				catch (Exception exAdd) {
					System.out.println(exAdd.toString());
				}

				byte[] byteArray = file.getValue();

				// Check fileName
				if (filename != null && filename.trim().length() > 0) { // change file
					// Set properties
					mcal.setFilename(filename);
					
					// Delete old file
					if (oldName != null && oldName.trim().length() > 0) {
						String deleteName = dirName + "/" + oldName;
						try {
							dlService.deleteFile(companyId, portletId, repositoryId, deleteName);
							
						}
						catch(Exception exDel) {
							if (exDel instanceof NoSuchFileException) {
								// Do nothing
							}
							else {
								throw new SystemException();
							}
						}
					}

					// Add new file
					/*
					long fileEntryId = CounterLocalServiceUtil.increment();
					dlService.addFile(
							companyId, portletId, groupId, repositoryId,
							dirName + "/" + filename,fileEntryId, StringPool.BLANK,new Date(),
							new String[0],new String[0], byteArray);
					*/
					dlService.addFile(
							companyId, portletId, groupId, repositoryId,
							dirName + "/" + filename, repositoryId, StringPool.BLANK,
							null, new String[0], null, byteArray);
				}
			}
			catch (Exception ex) {
				System.out.println(ex.getMessage());
				throw new SystemException();
			}
		}
		return meetingCalendarPersistence.updateImpl(mcal, false);
	}
	
	public MeetingCalendar cancelMCal(long mcalId)throws SystemException,PortalException{
		MeetingCalendar mcal = null;
		mcal = meetingCalendarPersistence.fetchByPrimaryKey(mcalId);
		mcal.setState(MeetingCalendarKey.HUY);
		return meetingCalendarPersistence.update(mcal,false);
	}
	
	
	public MeetingCalendar moveMCal(long oldMcalId, long newMcalId)throws SystemException,PortalException{
		MeetingCalendar mcal = null;
		mcal = meetingCalendarPersistence.fetchByPrimaryKey(oldMcalId);
		mcal.setState(MeetingCalendarKey.DOI);
		mcal.setMoveMcalId(newMcalId);
		return meetingCalendarPersistence.update(mcal,false);
	}
	
	public int countBySD_D_S_C(
			Date startDateGT, Date startDateLT,
			String description, String sponsor, String component, boolean andOperator)
		throws SystemException {
		
		return meetingCalendarFinder.countBySD_D_S_C(startDateGT, startDateLT,
				description, sponsor, component, andOperator);
	}
	
	public int countBySD_D_S_C_S(
			Date startDateGT, Date startDateLT,
			String description, String sponsor, String component, int state, boolean andOperator)
		throws SystemException {
		
		return meetingCalendarFinder.countBySD_D_S_C_S(startDateGT, startDateLT,
				description, sponsor, component, state, andOperator);
	}
	
	public List<CalEvent> searchBySD_D_S_C(
			Date startDateGT, Date startDateLT,
			String description, String sponsor, String component,
			boolean andOperator, int begin, int end, OrderByComparator obc)
		throws SystemException {
		
		return meetingCalendarFinder.findBySD_D_S_C(startDateGT, startDateLT, 
				description, sponsor, component,
				andOperator, begin, end, obc);
	}
	
	public List<CalEvent> searchBySD_D_S_C_S(
			Date startDateGT, Date startDateLT,
			String description, String sponsor, String component, int state,
			boolean andOperator, int begin, int end, OrderByComparator obc)
		throws SystemException {
		
		return meetingCalendarFinder.findBySD_D_S_C_S(startDateGT, startDateLT, 
				description, sponsor, component, state,
				andOperator, begin, end, obc);
	}
	
	public String getDirName() {
		return "MCALFolder";
	}
	
	public void updateOrder(long mcalId, int stt) throws PortalException, SystemException{
		MeetingCalendar mcal = meetingCalendarPersistence.findByPrimaryKey(mcalId);
		mcal.setStt(stt);
		meetingCalendarPersistence.update(mcal, false);
	}
	
	public List<MeetingCalendar> getByG_SD (long groupId, Calendar cal, String eventType) throws SystemException, PortalException{
		return meetingCalendarFinder.findByG_SD(
			groupId, CalendarUtil.getGTDate(cal),
			CalendarUtil.getLTDate(cal), eventType);
	}
	public MeetingCalendar FindPrimaryKey(long mdweekId)
	throws PortalException, SystemException {
	
	try{
		return meetingCalendarPersistence.findByPrimaryKey(mdweekId);
					
	}
	catch (Exception ex){
		return null;
	}
} 
}