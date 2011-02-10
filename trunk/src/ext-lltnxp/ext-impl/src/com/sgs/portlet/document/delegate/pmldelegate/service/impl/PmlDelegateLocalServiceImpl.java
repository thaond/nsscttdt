package com.sgs.portlet.document.delegate.pmldelegate.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.document.delegate.pmldelegate.NoSuchException;
import com.sgs.portlet.document.delegate.pmldelegate.model.PmlDelegate;
import com.sgs.portlet.document.delegate.pmldelegate.service.PmlDelegateLocalServiceUtil;
import com.sgs.portlet.document.delegate.pmldelegate.service.base.PmlDelegateLocalServiceBaseImpl;
import com.sgs.portlet.document.delegate.pmldelegate.service.persistence.PmlDelegateUtil;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.model.PmlFileTypeDelegate;
import com.sgs.portlet.document.delegate.pmlfiletypedelegate.service.persistence.PmlFileTypeDelegateUtil;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;


/**
 * @author lethanhtung
 *
 */
public class PmlDelegateLocalServiceImpl extends PmlDelegateLocalServiceBaseImpl {
	
	/**
	 * get List<PmlDelegate> with cancelDelegate is 0
	 * cancelDelegate = 0 : chua uy quyen
	 * cancelDelegate = 1 : da uy quyen
	 * default value of cancelDelegate is 0
	 * @return List<PmlDelegate>
	 */
	public List<PmlDelegate> getListDelegateByDefault(){
		
		List<PmlDelegate> retValue = new ArrayList<PmlDelegate>();
		try {
			retValue = PmlDelegateUtil.findByCancelDelegate("0");
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * get List<PmlDelegate> had delegate
	 * cancelDelegate = 1
	 * @return List<PmlDelegate>
	 */
	public List<PmlDelegate> getListHadDelegate () {
		
		List<PmlDelegate> retValue = new ArrayList<PmlDelegate>();
		
		try {
			retValue = PmlDelegateUtil.findByCancelDelegate("1");
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
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
			Date date) throws SystemException, NoSuchException {
		
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
	
	/**
	 * Yenlt 06/04/2010
	 * @throws SystemException 
	 */
	
	public int searchCount() throws SystemException {
		return pmlDelegateFinder.countAllDelegate();
	}
	
	public List<PmlDelegate> search(int start, int end) throws SystemException{
		return pmlDelegateFinder.findAllDelegate(start, end);
	}
}
