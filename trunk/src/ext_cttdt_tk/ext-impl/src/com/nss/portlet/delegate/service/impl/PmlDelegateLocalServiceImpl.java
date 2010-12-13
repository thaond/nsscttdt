package com.nss.portlet.delegate.service.impl;

import java.util.Date;
import java.util.List;

import com.ext.portlet.meetingcalendar.NoSuchendarException;
import com.liferay.portal.SystemException;
import com.nss.portlet.delegate.model.PmlDelegate;
import com.nss.portlet.delegate.model.PmlFileTypeDelegate;
import com.nss.portlet.delegate.service.base.PmlDelegateLocalServiceBaseImpl;
import com.nss.portlet.delegate.service.persistence.PmlDelegateUtil;
import com.nss.portlet.delegate.service.persistence.PmlFileTypeDelegateUtil;


public class PmlDelegateLocalServiceImpl extends PmlDelegateLocalServiceBaseImpl {
	
	public List<PmlDelegate> findByAssigner(long assignerId) throws SystemException {
		return pmlDelegatePersistence.findByAssigner(assignerId);
	}
	
	/**
	 * check user has delegated a fileType at given date.
	 * call Delegate Service
	 * @param userId not null parameter
	 * @param fileTypeId not null parameter
	 * @param date not null parameter
	 * @return true if user has delegated a fileType at given date, otherwise return false
	 * @throws SystemException 
	 * @throws NoSuchException if not found assigner associate with given userId
	 * 
	 */
	public boolean checkDelegatedByTime(long userId, String fileTypeId,
			Date date) throws SystemException, NoSuchendarException {
		
		// get all filetype delegate relationship with given filetype
		List<PmlFileTypeDelegate> list = PmlFileTypeDelegateUtil.findByFileTypeId(fileTypeId);
		
		// For each fileTypeDelegate in list
		for (PmlFileTypeDelegate fileTypeDelegate : list) {
			// get delegateId from fileTypeDelegate
			long delegateId = fileTypeDelegate.getDelegateId();
			PmlDelegate delegate = null;
			// get delegate object from persistence.
			try {
				delegate = PmlDelegateUtil.findByPrimaryKey(delegateId);
			} catch (Exception e) {
				continue;
			}
			
			// check userId with assigner
			if (userId == delegate.getAssigner()) {
				// check start date.
				if (date.after(delegate.getStartDate()) || date.equals(delegate.getStartDate())) {
					
					// get end of delegate date.
					Date endDate = 
						    "1".equals(delegate.getCancelDelegate())
							? delegate.getCancelDate()
							: delegate.getEndDate();
							
					if (date.before(endDate) || date.equals(endDate)) {
						return true;
					}
				} else {
					continue;
				}
			}
		}
		
		return false;
	}
	
	/**
	 * get all Pml_Delegate record from start date to end date without cancel.
	 * @param receiver
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws SystemException 
	 */
	public List<PmlDelegate> getByReceive_StartDate_EndDate(long receiver, Date startDate, Date endDate) throws SystemException {
		return PmlDelegateUtil.findByReceive_StartDate_EndDate_CancelDelegate(receiver, startDate, endDate, "0");
	}
	
	/**
	 * get all Pml_Delegate record from start date to cancel date with cancel.
	 * @param receiver
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws SystemException 
	 */
	public List<PmlDelegate> getByReceive_StartDate_CancelDate(long receiver, Date startDate, Date cancelDate) throws SystemException {
		return PmlDelegateUtil.findByReceive_StartDate_CancelDate_CancelDelegate(receiver, startDate, cancelDate, "1");
	}
}
