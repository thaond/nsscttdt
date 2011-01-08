package com.sgs.portlet.pmluser.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.persistence.UserUtil;
import com.sgs.portlet.document.NoSuchPmlStateProcessException;
import com.sgs.portlet.document.model.PmlProcessDispose;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.service.PmlStateProcessLocalServiceUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;
import com.sgs.portlet.document.service.persistence.PmlProcessDisposeUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlDepartmentsLeaderUtil;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.service.persistence.PmlHoSoCongViecUtil;
import com.sgs.portlet.pmluser.NoSuchPmlUserException;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.base.PmlUserLocalServiceBaseImpl;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;

public class PmlUserLocalServiceImpl extends PmlUserLocalServiceBaseImpl {
	
	/**
	 * Find user by userId
	 * @param userId User id 
	 * @return User
	 * @throws SystemException
	 */
	public PmlUser findByUserId(
			long userId) 
	throws SystemException {
		
		try {
			return pmlUserPersistence.findByPrimaryKey(userId);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	//yenlt 05/04/2010
	// xuancong close public List<PmlUser> search(String departmentsId, int start, int end, OrderByComparator obc) throws SystemException{
	public List<PmlUser> searchByDep(String departmentsId, int start, int end, OrderByComparator obc) 
	throws SystemException {
		return pmlUserFinder.findListUserByDepartment(departmentsId, start, end, obc);
	}
	
	// xuancong close public int searchCount(String departmentsId) throws SystemException{
	public int searchCountByDep(String departmentsId) throws SystemException {
		return pmlUserFinder.countListUserByDepartments(departmentsId);
	}

	/**
	 * get List<PmlUser> by fieldId
	 * @param fieldId
	 * @return List<PmlUser>
	 */
	public List<PmlUser> getListUserByFieldId (String fieldId) {
		
		List<PmlUser> retValue = new ArrayList<PmlUser>();
		PmlField field = null;
		
		if (fieldId == null) {
			return retValue;
		}
		
		try {
			field = PmlFieldUtil.findByPrimaryKey(fieldId);
			String departmentId = field.getDepartmentsId();
			if (departmentId != null) {
				retValue = PmlUserUtil.findByDepartmentsId(departmentId);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
		
		return retValue;
	}
	
	/**
	 * Tinh hinh thu ly ho so cua cac chuyen vien trong phong ban theo ngay
	 * Ho so can xu ly
	 * Ton truoc
	 * - Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
	 *   + Lay List<PmlProcessDispose> theo processer (userId) : list1 = PmlProcessDisposeUtil.findByProcesser(userId)
	 *   + Lay List<PmlProcessDispose> theo delegateUser (userId) : list2 = PmlProcessDisposeUtil.findByDelegateUser(userId)
	 *   + Cong list1 va list2 : list3 = list1.addAll(list2)
	 * - Tao PmlProcessDispose pmlProcessDispose = null
	 * - Duyet list3, lay fileId va transition lon nhat cua fileId do
	 * - pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transition).get(0)
	 * - Tao List<PmlProcessDispose> list4 = new ArrayList<PmlProcessDispose>()
	 * - if (list4.contains(pmlProcessDispose)) {
	 * - 	continue;
	 * - } list4.add(pmlProcessDispose);
	 * - Tao List<PmlProcessDispose> resultList = new ArrayList<PmlProcessDispose>();
	 * - Duyet list4, lay receiveDate, fileId
	 * - Lay PmlOneDoorReceiveFile theo fileId : oneDoorReceiveFile
	 * - Lay ngay thuc tra : exactReturningDate
	 * - Neu (receiveDate <= date va date <= exactReturningDate) || exactReturningDate == null  thi them PmlProcessDispose vao resultList
	 * - Ket qua tra ve la resultList.size().
	 * 
	 * @param userId
	 * @param date
	 * @return int
	 */
	public int countFileTonTruoc (long userId, Date date) {
		
		int retValue = 0;
		
		if (date == null) {
			return retValue;
		}
		
		List<PmlProcessDispose> resultList = getListForTonTruoc(userId, date);
		retValue = resultList.size();
		
		return retValue;
	}

	public List<PmlProcessDispose> getListForTonTruoc(long userId, Date date) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		if (date == null) {
			return retValue;
		}
		
		// lay danh sach List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
		List<PmlProcessDispose> list = getListProcessDisposeOfUser(userId);
		
		// lay danh sach List<PmlProcessDispose> theo fileId va transitionMax cua fileId do
		List<PmlProcessDispose> list1 = new ArrayList<PmlProcessDispose>();
		PmlProcessDispose processDispose = null;
		
		// lay fileId va transitionMax cua fileId do
		/* yenlt close start 05/04/2010
		 * 
		for (PmlProcessDispose pmlProcessDispose : list) {
			String fileId = pmlProcessDispose.getFileId();
			int transitionMax = getTransitionMaxOfFile(fileId, list);
			try {
				processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
				if (list1.contains(processDispose)) {
					continue;
				}
				list1.add(processDispose);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		// lay List<PmlProcessDispose> co (date >= receiveDate va date <= exactReturningDate) || exactReturningDate == null
		for (PmlProcessDispose item : list1) {
			Date receiveDate = item.getReceiveDate();
			Date dateProcess = item.getDateProcess();
			
			if (receiveDate != null) {
				Date dateReceiveCompare = null;
				Date dateCompare = null;
				Date dateProcessCompare = null;
				
				try {
					dateReceiveCompare = df.parse(sdf.format(receiveDate));
					dateCompare = df.parse(sdf.format(date));
					
					if (dateProcess == null) {
						if ((dateReceiveCompare.before(dateCompare))) {
							retValue.add(item);
						}
					}
					if (dateProcess != null) {
						dateProcessCompare = df.parse(sdf.format(dateProcess));
						
						if ((dateReceiveCompare.before(dateCompare)) && (dateProcessCompare.after(dateCompare))) {
							retValue.add(item);
						}
					}
					
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		yenlt close end */
		//yenlt update 05/04/2010
		for (PmlProcessDispose pmlProcessDispose : list) {
			String fileId = pmlProcessDispose.getFileId();
			int transitionMax = 1;
			List<PmlProcessDispose> listMaxTransition = new ArrayList<PmlProcessDispose>();
			try {
				listMaxTransition = PmlProcessDisposeUtil.findByFileId(fileId);
			} catch (SystemException e1) {
				
			}
			
			if ( listMaxTransition.size() > 0) {
				transitionMax = listMaxTransition.size();
			}
			try {
				processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
				if (list1.contains(processDispose)) {
					continue;
				}
				list1.add(processDispose);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		// lay List<PmlProcessDispose> co (date >= receiveDate va date <= exactReturningDate) || exactReturningDate == null
		for (PmlProcessDispose item : list1) {
				if (item.getProcesser() == userId) {
				Date receiveDate = item.getReceiveDate();
				PmlOneDoorReceiveFile file = null;
				Date exactreturnDate = null;
				try {
					file = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(item.getFileId());
				} catch (PortalException e1) {
				} catch (SystemException e1) {
				}
				
				if ( null != file) {
					exactreturnDate = file.getExactReturningDate();
				}
				
				Date dateCompare = null;
				Date expecreturnDateCompare = null;
				Date receiveDateCompare = null;
				
				try {
					dateCompare = df.parse(sdf.format(date));
					if ( exactreturnDate != null) {
						expecreturnDateCompare = df.parse(sdf.format(exactreturnDate));
					}
					
					if ( receiveDate != null){
						receiveDateCompare = df.parse(sdf.format(receiveDate));
					}
					
					if ( (receiveDate != null && receiveDateCompare.before(dateCompare)) &&
							((exactreturnDate == null) || (expecreturnDateCompare.after(dateCompare) && expecreturnDateCompare.equals(dateCompare)))) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
	}
	
	public List<PmlOneDoorReceiveFile> getListFileTonTruoc (long userId, Date date) {
		List<PmlProcessDispose> resultList = getListForTonTruoc(userId, date);
		
		List<PmlOneDoorReceiveFile> listFile = getListFileFormListProcessDispose(resultList);
		
		return listFile;
	}

	private List<PmlOneDoorReceiveFile> getListFileFormListProcessDispose(
			List<PmlProcessDispose> resultList) {
		List<PmlOneDoorReceiveFile> listFile = new ArrayList<PmlOneDoorReceiveFile>();
		if (resultList == null) {
			return listFile;
		}
		
		for (int i = 0; i < resultList.size(); i++) {
			PmlProcessDispose pd = resultList.get(i);
			String fileId = pd.getFileId();
			
			try {
				PmlOneDoorReceiveFile file = PmlOneDoorReceiveFileLocalServiceUtil.getPmlOneDoorReceiveFile(fileId);
				
				//Yenlt 05/04/2010
				if ( listFile.contains(file)) {
					continue;
				}
				// end
				listFile.add(file);
			} catch (Exception e) {
				e.getStackTrace();
			}	
		}
		return listFile;
	}

	/**
	 * Lay transition lon nhat cua ho so trong List<PmlProcessDispose>
	 * - Tao List<PmlProcessDispose> listResult = new ArrayList<PmlProcessDispose>()
	 * - Duyet qua list, lay ra fileIdOfList
	 * - Neu fileId.equals(fileIdOfList) thi them PmlProcessDispose vao listResult
	 * - Lay transitionMax tu listResult
	 * - transitionMax = getTransitionMax(listResult)
	 * 
	 * @precondition : fileId != null, list != null, list.size > 0
	 * @param fileId
	 * @param list
	 * @return
	 */
	private int getTransitionMaxOfFile(String fileId, List<PmlProcessDispose> list) {

		int max = 1;
		
		List<PmlProcessDispose> listResult = new ArrayList<PmlProcessDispose>();
		
		for (PmlProcessDispose pmlProcessDispose : list) {
			String fileIdOfList = pmlProcessDispose.getFileId();
			if (fileId.equals(fileIdOfList)) {
				listResult.add(pmlProcessDispose);
			}
		}
		max = getTransitionMax(listResult);
		
		return max;
	}
	
	private int getTransitionMax(List<PmlProcessDispose> list) {

		int max = list.get(0).getTransition_();
		for(int index = 1; index < list.size(); index ++) {
			int transition_ = list.get(index).getTransition_();
			if(transition_ > max) {
				max = transition_;
			}
		}
		return max;
	}

	/**
	 * Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
	 * @param userId
	 * @param date
	 * @return
	 */
	private List<PmlProcessDispose> getListProcessDisposeOfUser(long userId) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		List<PmlProcessDispose> list1 = null;
		
		try {
			// lay List<PmlProcessDispose> theo processer
			retValue = PmlProcessDisposeUtil.findByProcesser(userId);
			
			// lay List<PmlProcessDispose> theo delegateUser
			list1 = PmlProcessDisposeUtil.findByDelegateUser(userId);
			
			retValue.addAll(list1);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}

		return retValue;
	}

	/**
	 * Ho so can xu ly
	 * Ho so moi chuyen den
	 * Da nhan
	 * - Lay List<PmlProcessDispose> ma chuyen vien do la nguoi xu ly
	 *   + Lay List<PmlProcessDispose> theo processer : list1 = PmlProcessDisposeUtil.findByProcesser(userId)
	 * - Tao PmlProcessDispose pmlProcessDispose = null
	 * - Duyet list1, lay fileId va transition lon nhat cua fileId do
	 * - pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transition).get(0)
	 * - Tao List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>()
	 * - if (list2.contains(pmlProcessDispose)) {
	 * - 	continue;
	 * - } list2.add(pmlProcessDispose);
	 * - Tao List<PmlProcessDispose> resultList = new ArrayList<PmlProcessDispose>()
	 * - Duyet list2, lay receiveDate. Neu receiveDate != null va receiveDate.equals(date) thi them PmlProcessDispose vao resultList.
	 * - Ket qua tra ve la resultList.size()
	 * 
	 * @param userId
	 * @param date
	 * @return int
	 */
	public int countFileDaNhan (long userId, Date date) {
		
		int retValue = 0;
		
		if (date == null) {
			return retValue;
		}
		
		List<PmlProcessDispose> resultList = getListForDaNhan(userId, date);
		retValue = resultList.size();
		
		return retValue;
	}

	public List<PmlProcessDispose> getListForDaNhan(long userId, Date date) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		if (date == null) {
			return retValue;
		}
		
		// lay List<PmlProcessDispose> ma chuyen vien do la nguoi xu ly
		List<PmlProcessDispose> list1 = new ArrayList<PmlProcessDispose>();
		
		List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>();
		
		PmlProcessDispose pmlProcessDispose = null;
		//yenlt update 05/04/2010
		try {
			list1 = PmlProcessDisposeUtil.findByProcesser(userId);
			for (PmlProcessDispose item : list1) {
				String fileId = item.getFileId();
				
				// lay fileId va transitionMax theo fileId do trong list1
				int transitionMax = 1;
				List<PmlProcessDispose> listMaxTransition = new ArrayList<PmlProcessDispose>();
				try {
					listMaxTransition = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (SystemException e1) {
					
				}
				
				// ho so duoc chuyen vien khac chuyen den cho chuyen vien can thong ke
				if ( listMaxTransition.size() > 1) {
					transitionMax = listMaxTransition.size();
					try {
						pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
						if (list2.contains(pmlProcessDispose)) {
							continue;
						}
						list2.add(pmlProcessDispose);
					}
					catch (SystemException e) {
						e.printStackTrace();
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		for (PmlProcessDispose item : list2) {
			if ( item.getProcesser() == userId) {
				Date receiveDate = item.getReceiveDate();
				Date dateProcess = item.getDateProcess();
				if (null != receiveDate) {
					Date dateReceiveCompare = null;
					Date dateCompare = null;
					
					try {
						dateReceiveCompare = df.parse(sdf.format(receiveDate));
						dateCompare = df.parse(sdf.format(date));
						if ((dateReceiveCompare != null && dateCompare.equals(dateReceiveCompare))
								&& dateProcess == null) {
							retValue.add(item);
						}
					}
					catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return retValue;
		/* yenlt close start 05/04/2010
		try {
			list1 = PmlProcessDisposeUtil.findByProcesser(userId);
			for (PmlProcessDispose item : list1) {
				String fileId = item.getFileId();
				
				// lay fileId va transitionMax theo fileId do trong list1
				int transitionMax = getTransitionMaxOfFile(fileId, list1);
				try {
					pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
					if (list2.contains(pmlProcessDispose)) {
						continue;
					}
					list2.add(pmlProcessDispose);
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		for (PmlProcessDispose item : list2) {
			Date receiveDate = item.getReceiveDate();
			if (receiveDate != null) {
				Date dateReceiveCompare = null;
				Date dateCompare = null;
				
				try {
					dateReceiveCompare = df.parse(sdf.format(receiveDate));
					dateCompare = df.parse(sdf.format(date));
					if (dateReceiveCompare != null && dateCompare.equals(dateReceiveCompare)) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		return retValue;
		yenlt close end */
		
	}
	
	public List<PmlOneDoorReceiveFile> getListFileDaNhan(long userId, Date date) {
		List<PmlProcessDispose> resultList = getListForDaNhan(userId, date);
		
		List<PmlOneDoorReceiveFile> listFile = getListFileFormListProcessDispose(resultList);
		return listFile;
	}

	/**
	 * Ho so can xu ly
	 * Ho so moi chuyen den
	 * Chua nhan
	 * - Lay List<PmlProcessDispose> theo processer : list1 = PmlProcessDisposeUtil.findByProcesser(userId)
	 * - Tao PmlProcessDispose pmlProcessDispose = null
	 * - Duyet list1, lay fileId va transition lon nhat cua fileId do
	 * - pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transition).get(0)
	 * - Tao List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>()
	 * - if (list2.contains(pmlProcessDispose)) {
	 * - 	continue;
	 * - } list2.add(pmlProcessDispose);
	 * - Tao List<PmlProcessDispose> resultList = new ArrayList<PmlProcessDispose>()
	 * - Duyet list2, lay receiveDate. Neu receiveDate == null hoac receiveDate > date thi them PmlProcessDispose vao resultList.
	 * - Ket qua tra ve la resultList.size()
	 * 
	 * @param userId
	 * @param date
	 * @return int
	 */
	public int countFileChuaNhan (long userId, Date date) {
		
		int retValue = 0;
		
		if (date == null) {
			return retValue;
		}
		
		List<PmlProcessDispose> resultList = getListForChuaNhan(userId, date);
		retValue = resultList.size();
		
		return retValue;
	}

	public List<PmlProcessDispose> getListForChuaNhan(long userId, Date date) {

		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		//String DATE_FORMAT = "dd-MM-yyyy";
		//SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		//DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		if (date == null) {
			return retValue;
		}
		
		// lay List<PmlProcessDispose> ma chuyen vien do la nguoi xu ly
		List<PmlProcessDispose> list1 = new ArrayList<PmlProcessDispose>();
		
		List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>();
		
		PmlProcessDispose pmlProcessDispose = null;
		//yenlt update 05/04/2010
		try {
			list1 = PmlProcessDisposeUtil.findByProcesser(userId);
			for (PmlProcessDispose item : list1) {
				String fileId = item.getFileId();
				
				// lay fileId va transitionMax theo fileId do trong list1
				int transitionMax = 1;
				List<PmlProcessDispose> listMaxTransition = new ArrayList<PmlProcessDispose>();
				try {
					listMaxTransition = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (SystemException e1) {
					
				}
				
				//ho so do chuyen vien khac chuyen den cho chuyen vien can thong ke nen transition != 1
				if ( listMaxTransition.size() > 1) {
					transitionMax = listMaxTransition.size();
					try {
						pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
						if (list2.contains(pmlProcessDispose)) {
							continue;
						}
						list2.add(pmlProcessDispose);
					}
					catch (SystemException e) {
						e.printStackTrace();
					}
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		for (PmlProcessDispose item : list2) {
			Date receiveDate = item.getReceiveDate();
			
			if ( item.getProcesser() == userId) {
				if ( null == receiveDate) {
					retValue.add(item);
				} 
			}
		}
		return retValue;
		//end
		/* yenlt close start 05/04/2010
		try {
			list1 = PmlProcessDisposeUtil.findByProcesser(userId);
			for (PmlProcessDispose item : list1) {
				String fileId = item.getFileId();
				
				// lay fileId va transitionMax theo fileId do trong list1
				int transitionMax = getTransitionMaxOfFile(fileId, list1);
				try {
					pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
					if (list2.contains(pmlProcessDispose)) {
						continue;
					}
					list2.add(pmlProcessDispose);
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		for (PmlProcessDispose item : list2) {
			Date receiveDate = item.getReceiveDate();
			Date dateReceiveCompare = null;
			Date dateCompare = null;
			
			if (receiveDate == null) {
				retValue.add(item);
			} else {
				try {
					dateReceiveCompare = df.parse(sdf.format(receiveDate));
					dateCompare = df.parse(sdf.format(date));
					if (dateCompare.before(dateReceiveCompare)) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
		yent close end */
	}
	
	public List<PmlOneDoorReceiveFile> getListFileChuaNhan(long userId, Date date) {
		List<PmlProcessDispose> resultList = getListForChuaNhan(userId, date);
		
		List<PmlOneDoorReceiveFile> listFile = getListFileFormListProcessDispose(resultList);
		return listFile;
	}

	/**
	 * Ho so giai quyet
	 * Tu giai quyet
	 * - Lay List<PmlProcessDispose> ma chuyen vien do la nguoi giai quyet
	 *   + Lay List<PmlProcessDispose> theo processer : list1 = PmlProcessDisposeUtil.findByProcesser(userId)
	 * - Duyet list1, lay fileId va transitionMax cua fileId do
	 * - Tao PmlProcessDispose pmlProcessDispose = null
	 * - pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0)
	 * - Tao List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>()
	 * - if (list2.contains(pmlProcessDispose)) {
	 * - 	continue;
	 * - } list2.add(pmlProcessDispose);
	 * - Duyet list2, lay dateProcess
	 * - Tao List<PmlProcessDispose> resultList = new ArrayList<PmlProcessDispose>()
	 * - Neu dateProcess != null va date = dateProcess thi them PmlProcessDispose vao resultList
	 * - Ket qua tra ve la resultList.size()
	 * 
	 * @param userId
	 * @param date
	 * @return
	 */
	public int countFileTuGiaiQuyet (long userId, Date date) {
		
		int retValue = 0;
		
		if (date == null) {
			return retValue;
		}
		
		List<PmlProcessDispose> resultList = getListForTuGiaiQuyet(userId, date);
		retValue = resultList.size();
		
		return retValue;
	}
	
	public List<PmlProcessDispose> getListForTuGiaiQuyet(long userId, Date date) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		if (date == null) {
			return retValue;
		}
		
		// lay List<PmlProcessDispose> ma chuyen vien do la nguoi xu ly
		List<PmlProcessDispose> list1 = new ArrayList<PmlProcessDispose>();
		
		List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>();
		
		PmlProcessDispose pmlProcessDispose = null;
		//yenlt update 05/04/2010
		try {
			list1 = PmlProcessDisposeUtil.findByProcesser(userId);
			for (PmlProcessDispose item : list1) {
				String fileId = item.getFileId();
				
				// lay fileId va transitionMax theo fileId do trong list1
				int transitionMax = 1;
				List<PmlProcessDispose> listMaxTransition = new ArrayList<PmlProcessDispose>();
				try {
					listMaxTransition = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (SystemException e1) {
					
				}
				if ( listMaxTransition.size() > 0) {
					transitionMax = listMaxTransition.size();
				}
				try {
					pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
					if (list2.contains(pmlProcessDispose)) {
						continue;
					}
					list2.add(pmlProcessDispose);
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		for (PmlProcessDispose item : list2) {
			Date dateProcess = item.getDateProcess();
			if ( item.getProcesser() == userId) {
				if (dateProcess != null) {
					Date dateProcessCompare = null;
					Date dateCompare = null;
					
					try {
						dateProcessCompare = df.parse(sdf.format(dateProcess));
						dateCompare = df.parse(sdf.format(date));
						if (dateCompare.equals(dateProcessCompare)) {
							retValue.add(item);
						}
					}
					catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return retValue;
		//end
		/* yenlt close start 05/04/2010
		try {
			list1 = PmlProcessDisposeUtil.findByProcesser(userId);
			//int transitionMax = getTransitionMaxOfFile11("0000297/BNHS09", list1);
			for (PmlProcessDispose item : list1) {
				String fileId = item.getFileId();
				
				// lay fileId va transitionMax theo fileId do trong list1
				int transitionMax = getTransitionMaxOfFile(fileId, list1);
				try {
					pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
					if (list2.contains(pmlProcessDispose)) {
						continue;
					}
					list2.add(pmlProcessDispose);
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		for (PmlProcessDispose item : list2) {
			Date dateProcess = item.getDateProcess();
			if (dateProcess != null) {
				Date dateProcessCompare = null;
				Date dateCompare = null;
				
				try {
					dateProcessCompare = df.parse(sdf.format(dateProcess));
					dateCompare = df.parse(sdf.format(date));
					if (dateCompare.equals(dateProcessCompare)) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
		yenlt close end */
	}

	/**
	 * Ho so giai quyet
	 * Nguoi khac thu ly thay
	 * - Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien nhung nguoi khac xu ly
	 *   + Lay List<PmlProcessDispose> theo delegateUser : list1 = PmlProcessDisposeUtil.findByDelegateUser(userId)
	 * - Duyet list1, lay fileId va transitionMax cua fileId do
	 * - Tao PmlProcessDispose pmlProcessDispose = null
	 * - pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0)
	 * - Tao List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>()
	 * - if (list2.contains(pmlProcessDispose)) {
	 * - 	continue;
	 * - } list2.add(pmlProcessDispose);
	 * - Duyet list2, lay dateProcess
	 * - Tao List<PmlProcessDispose> resultList = new ArrayList<PmlProcessDispose>()
	 * - Neu dateProcess != null va date = dateProcess thi them PmlProcessDispose vao resultList
	 * - Ket qua tra ve la resultList.size()
	 * 
	 * @param userId
	 * @param date
	 * @return
	 */
	public int countFileNguoiKhacThuLyThay (long userId, Date date) {
		
		int retValue = 0;
		
		if (date == null) {
			return retValue;
		}
		
		List<PmlProcessDispose> resultList = getListForNguoiKhacThuLyThay(userId, date);
		retValue = resultList.size();
		
		return retValue;
	}
	
	public List<PmlProcessDispose> getListForNguoiKhacThuLyThay(long userId, Date date) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		if (date == null) {
			return retValue;
		}
		
		// Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien nhung nguoi khac xu ly
		List<PmlProcessDispose> list1 = new ArrayList<PmlProcessDispose>();
		
		List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>();
		
		PmlProcessDispose pmlProcessDispose = null;
		//yenlt update 05/04/2010
		try {
			list1 = PmlProcessDisposeUtil.findByDelegateUser(userId);
			for (PmlProcessDispose item : list1) {
				String fileId = item.getFileId();
				
				// lay fileId va transitionMax theo fileId do trong list1
				int transitionMax = 1;
				List<PmlProcessDispose> listMaxTransition = new ArrayList<PmlProcessDispose>();
				try {
					listMaxTransition = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (SystemException e1) {
					
				}
				
				if ( listMaxTransition.size() > 0) {
					transitionMax = listMaxTransition.size();
				}
				try {
					pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
					if (list2.contains(pmlProcessDispose)) {
						continue;
					}
					list2.add(pmlProcessDispose);
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		for (PmlProcessDispose item : list2) {
			Date dateProcess = item.getDateProcess();
			if ( item.getProcesser() == userId) {
				if (dateProcess != null) {
					Date dateProcessCompare = null;
					Date dateCompare = null;
					
					try {
						dateProcessCompare = df.parse(sdf.format(dateProcess));
						dateCompare = df.parse(sdf.format(date));
						if (dateCompare.equals(dateProcessCompare)) {
							retValue.add(item);
						}
					}
					catch (ParseException e) {
						e.printStackTrace();
					}
				}
			}
		}

		return retValue;
		//end
		/* yenlt close start 05/04/2010
		try {
			list1 = PmlProcessDisposeUtil.findByDelegateUser(userId);
			for (PmlProcessDispose item : list1) {
				String fileId = item.getFileId();
				
				// lay fileId va transitionMax theo fileId do trong list1
				int transitionMax = getTransitionMaxOfFile(fileId, list1);
				try {
					pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
					if (list2.contains(pmlProcessDispose)) {
						continue;
					}
					list2.add(pmlProcessDispose);
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		for (PmlProcessDispose item : list2) {
			Date dateProcess = item.getDateProcess();
			if (dateProcess != null) {
				Date dateProcessCompare = null;
				Date dateCompare = null;
				
				try {
					dateProcessCompare = df.parse(sdf.format(dateProcess));
					dateCompare = df.parse(sdf.format(date));
					if (dateCompare.equals(dateProcessCompare)) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
		yenlt close end */
	}

	/**
	 * Ho so ton dong
	 * Trong han ISO
	 * - Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
	 *   + Tao List<PmlProcessDispose> list1 = new ArrayList<PmlProcessDispose>()
	 *   + Lay List<PmlProcessDispose> theo processer : list2 = PmlProcessDisposeUtil.findByProcesser(userId)
	 *   + Lay List<PmlProcessDispose> theo delegateUser : list3 = PmlProcessDisposeUtil.findByDelegateUser(userId)
	 *   + list1 = list2.addAll(list3)
	 * - Duyet list1, lay fileId va transitionMax cua fileId do
	 * - Tao PmlProcessDispose pmlProcessDispose = null
	 * - pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileID, transitionMax).get(0)
	 * - Tao List<PmlProcessDispose> list4 = new ArrayList<PmlProcessDispose>()
	 * - if (list4.contains(pmlProcessDispose)) {
	 * - 	continue;
	 * - } list4.add(pmlProcessDispose);
	 * - Duyet list4, lay expiredDate, dateProcess
	 * - Tao List<PmlProcessDispose> resultList = new ArrayList<PmlProcessDispose>()
	 * - Neu date < dateProcess va dateProcess <= expiredDate thi them PmlProcessDispose vao resultList
	 * - Ket qua tra ve la resultList.size()
	 * 
	 * @param userId
	 * @param date
	 * @return int
	 */
	public int countFileTrongHanISO (long userId, Date date) {
		
		int retValue = 0;
		
		if (date == null) {
			return retValue;
		}
		
		List<PmlProcessDispose> resultList = getListForTrongHanISO(userId, date);
		retValue = resultList.size();
		
		return retValue;
	}

	public List<PmlProcessDispose> getListForTrongHanISO(long userId, Date date) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		if (date == null) {
			return retValue;
		}
		
		// Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
		List<PmlProcessDispose> list1 = getListProcessDisposeOfUser(userId);
		
		List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>();
		
		PmlProcessDispose pmlProcessDispose = null;
		
		//yenlt update 05/4/2010
		for (PmlProcessDispose item : list1) {
			String fileId = item.getFileId();
			
			// lay fileId va transitionMax theo fileId do trong list1
			int transitionMax = 1;
			List<PmlProcessDispose> listMaxTransition = new ArrayList<PmlProcessDispose>();
			try {
				listMaxTransition = PmlProcessDisposeUtil.findByFileId(fileId);
			} catch (SystemException e1) {
				
			}
			
			if ( listMaxTransition.size() > 0) {
				transitionMax = listMaxTransition.size();
			}
			try {
				pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
				if (list2.contains(pmlProcessDispose)) {
					continue;
				}
				list2.add(pmlProcessDispose);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlProcessDispose item : list2) {
			if ( item.getProcesser() == userId) {
				Date expiredDate = item.getExpiredDate();
				Date dateProcess = item.getDateProcess();
				Date receiveDate = item.getReceiveDate();;
				Date dateProcessCompare = null;
				Date receiveDateCompare = null;
				Date expiredDateCompare = null;
				Date dateCompare = null;
				
				try {
					if ( null != receiveDate) {
						receiveDateCompare =  df.parse(sdf.format(receiveDate));
					}
		
					if ( dateProcess != null ) {
						dateProcessCompare =  df.parse(sdf.format(dateProcess));
					}
					if (expiredDate != null && receiveDate != null) {
							
							expiredDateCompare = df.parse(sdf.format(expiredDate));
							dateCompare = df.parse(sdf.format(date));
							
							if ((dateProcess == null || dateProcessCompare.after(dateCompare)) &&
									(receiveDateCompare.before(dateCompare) || receiveDateCompare.equals(dateCompare)) &&
									(dateCompare.before(expiredDateCompare) || dateCompare.equals(expiredDateCompare))) {
								retValue.add(item);
							}
					}
				} catch (ParseException e) {
				}
			}
			
		}

		return retValue;
		//end
		/* yenlt close start 05/04/2010
		for (PmlProcessDispose item : list1) {
			String fileId = item.getFileId();
			
			// lay fileId va transitionMax theo fileId do trong list1
			int transitionMax = getTransitionMaxOfFile(fileId, list1);
			try {
				pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
				if (list2.contains(pmlProcessDispose)) {
					continue;
				}
				list2.add(pmlProcessDispose);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlProcessDispose item : list2) {
			Date expiredDate = item.getExpiredDate();
			Date dateProcess = item.getDateProcess();
			
			Date dateProcessCompare = null;
			Date expiredDateCompare = null;
			Date dateCompare = null;
			if (dateProcess != null && expiredDate != null) {
				try {
					dateProcessCompare = df.parse(sdf.format(dateProcess));
					expiredDateCompare = df.parse(sdf.format(expiredDate));
					dateCompare = df.parse(sdf.format(date));
					if ((dateCompare.before(dateProcessCompare)) 
									&& (dateProcessCompare.equals(expiredDateCompare) || dateProcessCompare.before(expiredDateCompare))) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (dateProcess == null && expiredDate != null) {
				try {
					expiredDateCompare = df.parse(sdf.format(expiredDate));
					dateCompare = df.parse(sdf.format(date));
					if (dateCompare.before(expiredDateCompare) || dateCompare.equals(expiredDateCompare)) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
		yenlt close end */
	}

	/**
	 * Ho so ton dong
	 * Qua han ISO
	 * - Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
	 *   + Tao List<PmlProcessDispose> list1 = new ArrayList<PmlProcessDispose>()
	 *   + Lay List<PmlProcessDispose> theo processer : list2 = PmlProcessDisposeUtil.findByProcesser(userId)
	 *   + Lay List<PmlProcessDispose> theo delegateUser : list3 = PmlProcessDisposeUtil.findByDelegateUser(userId)
	 *   + list1 = list2.addAll(list3)
	 * - Duyet list1, lay fileId va transitionMax cua fileId do
	 * - Tao PmlProcessDispose pmlProcessDispose = null
	 * - pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileID, transitionMax).get(0)
	 * - Tao List<PmlProcessDispose> list4 = new ArrayList<PmlProcessDispose>()
	 * - if (list4.contains(pmlProcessDispose)) {
	 * - 	continue;
	 * - } list4.add(pmlProcessDispose);
	 * - Duyet list4, lay expiredDate, dateProcess
	 * - Tao List<PmlProcessDispose> resultList = new ArrayList<PmlProcessDispose>()
	 * - Neu date < dateProcess va dateProcess > expiredDate thi them PmlProcessDispose vao resultList
	 * - Ket qua tra ve la resultList.size()
	 * 
	 * @param userId
	 * @param date
	 * @return int
	 */
	public int countFileQuaHanISO (long userId, Date date) {
		
		int retValue = 0;
		
		if (date == null) {
			return retValue;
		}
		
		List<PmlProcessDispose> resultList = getListForQuaHanISO(userId, date);
		retValue = resultList.size();
		
		return retValue;
	}

	public List<PmlProcessDispose> getListForQuaHanISO(long userId, Date date) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		
		if (date == null) {
			return retValue;
		}
		
		// Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
		List<PmlProcessDispose> list1 = getListProcessDisposeOfUser(userId);
		
		List<PmlProcessDispose> list2 = new ArrayList<PmlProcessDispose>();
		
		PmlProcessDispose pmlProcessDispose = null;
		
		//yenlt update 05/04/2010
		for (PmlProcessDispose item : list1) {
			String fileId = item.getFileId();
			
			// lay fileId va transitionMax theo fileId do trong list1
			int transitionMax = 1;
			List<PmlProcessDispose> listMaxTransition = new ArrayList<PmlProcessDispose>();
			try {
				listMaxTransition = PmlProcessDisposeUtil.findByFileId(fileId);
			} catch (SystemException e1) {
				
			}
			
			if ( listMaxTransition.size() > 0) {
				transitionMax = listMaxTransition.size();
			}
			try {
				pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
				if (list2.contains(pmlProcessDispose)) {
					continue;
				}
				list2.add(pmlProcessDispose);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlProcessDispose item : list2) {
			if ( item.getProcesser() == userId) {
				Date expiredDate = item.getExpiredDate();
				Date dateProcess = item.getDateProcess();
				
				Date dateProcessCompare = null;
				Date expiredDateCompare = null;
				Date dateCompare = null;
				
				Date receiveDate = item.getReceiveDate();
				Date receiveDateCompare = null; 
				
				try {
					if ( null!= receiveDate) {
						receiveDateCompare = df.parse(sdf.format(receiveDate));
					}
					
					if ( dateProcess != null) {
							dateProcessCompare = df.parse(sdf.format(dateProcess));
					}
					
					if (expiredDate != null && receiveDate != null) {
						expiredDateCompare = df.parse(sdf.format(expiredDate));
						dateCompare = df.parse(sdf.format(date));
						
						if ((dateProcess == null || dateProcessCompare.after(dateCompare)) &&
								(receiveDateCompare.before(dateCompare) || receiveDateCompare.equals(dateCompare)) &&
								 dateCompare.after(expiredDateCompare)) {
							retValue.add(item);
						}
					}
				} catch (ParseException e) {}
			}
		}

		return retValue;
		//end
		/* yenlt close start 05/04/2010
		for (PmlProcessDispose item : list1) {
			String fileId = item.getFileId();
			
			// lay fileId va transitionMax theo fileId do trong list1
			int transitionMax = getTransitionMaxOfFile(fileId, list1);
			try {
				pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
				if (list2.contains(pmlProcessDispose)) {
					continue;
				}
				list2.add(pmlProcessDispose);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlProcessDispose item : list2) {
			Date expiredDate = item.getExpiredDate();
			Date dateProcess = item.getDateProcess();
			
			Date dateProcessCompare = null;
			Date expiredDateCompare = null;
			Date dateCompare = null;
			
			if (dateProcess != null && expiredDate != null) {
				try {
					dateProcessCompare = df.parse(sdf.format(dateProcess));
					expiredDateCompare = df.parse(sdf.format(expiredDate));
					dateCompare = df.parse(sdf.format(date));
					if ((dateCompare.before(dateProcessCompare)) && (dateProcessCompare.after(expiredDateCompare))) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
			if (dateProcess == null && expiredDate != null) {
				try {
					expiredDateCompare = df.parse(sdf.format(expiredDate));
					dateCompare = df.parse(sdf.format(date));
					if (dateCompare.after(expiredDateCompare)) {
						retValue.add(item);
					}
				}
				catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
		yenlt close end */
	}
	
	public List<PmlOneDoorReceiveFile> getListFileQuaHanISO(long userId, Date date) {
		List<PmlProcessDispose> resultList = getListForQuaHanISO(userId, date);
		
		List<PmlOneDoorReceiveFile> listFile = getListFileFormListProcessDispose(resultList);
		return listFile;
	}
	
	/**
	 * Dem so ho so cho bo sung
	 * @param userId
	 * @param date
	 * @return int
	 */
	public int countFileChoBoSung (long userId, Date date) {
		
		int retValue = 0;
		
		if (date == null) {
			return retValue;
		}
		
		retValue = getListFileChoBoSung(userId, date).size();
		
		return retValue;
	}
	
	private List<PmlProcessDispose> getListFileChoBoSung(long userId, Date date) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		if (date == null) {
			return retValue;
		}
		
		// Lay List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
		List<PmlProcessDispose> list1 = getListProcessDisposeOfUser(userId);
		
		// lay List<PmlStateProcess> co trang thai la chobosung
		List<PmlStateProcess> list2 = getListStateProcessChoBoSung(list1);
		
		// lay List<PmlProcessDispose> theo stateProcessIdBefore va co stateProcessCode = chobosung
		for (PmlStateProcess pmlStateProcess : list2) {
			long stateProcessId = pmlStateProcess.getStateProcessId();
			try {
				retValue.addAll(PmlProcessDisposeUtil.findByStateProcessIdBefore(stateProcessId));
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}

		return retValue;
	}

	public List<PmlOneDoorReceiveFile> getListFileDangChoBoSung(long userId, Date date) {
		List<PmlProcessDispose> resultList = getListFileChoBoSung(userId, date);
		
		List<PmlOneDoorReceiveFile> listFile = getListFileFormListProcessDispose(resultList);
		return listFile;
	}
	
	private List<PmlStateProcess> getListStateProcessChoBoSung(List<PmlProcessDispose> list) {
		
		List<PmlStateProcess> retValue = new ArrayList<PmlStateProcess>();
		
		if (list == null) {
			return retValue;
		}
		
		PmlStateProcess pmlStateProcess = null;
		
		// lay stateProcessIdBefore
		if (list != null && list.size() > 0) {
			for (PmlProcessDispose pmlProcessDispose : list) {
				long stateProcessIdBefore = pmlProcessDispose.getStateProcessIdBefore();
				
				// lay PmlProcessDispose co trang thai la chobosung
				try {
					pmlStateProcess = PmlStateProcessUtil.findByPrimaryKey(stateProcessIdBefore);
					if (pmlStateProcess != null) {
						String stateProcess = pmlStateProcess.getStateProcessCode();
						if (stateProcess != null && stateProcess.equalsIgnoreCase("chobosung")) {
							retValue.add(pmlStateProcess);
						}
					}
				}
				catch (NoSuchPmlStateProcessException e) {
					e.printStackTrace();
				}
				catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}

		return retValue;
	}
	
	/***************************************************************************************************
	 * 						BAO CAO HO SO THANG
	 ***************************************************************************************************/
	
	/**
	 * Lay so luong ho so ton dau ky
	 * 
	 * Dieu kien: 	ngay nop truoc ngay bat dau thong ke
	 * 				va ngay hoan thanh khong co hoac lon
	 * 				hon hay bang ngay bat dau thong ke
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numTonDauKy: so luong ho so ton dau ky
	 * @throws Exception 
	 */
	public int getTonDauKy(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		int numTonDauKy = 0;
		//yenlt 05/04/2010
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date c1 = null;
		//Date c2 = null;
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				String fileId = pmlFilePCCC.getFileId();
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				
				if ( processDisposeList.size() > 0) {
					try {
						processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
					} catch (Exception e) {
					}
					
					try{
						c1 = df.parse(sdf.format(fromDate));
						//c2 = df.parse(sdf.format(toDate));
				
						if ( null != processDispose ) {
							
							Date sendDate = null;
							Date dateProcess = null;
							Date dateProcessCompare = null; 
							Date sendDateCompare = null; 
							
							sendDate = processDispose.getSendDate();
							dateProcess = processDispose.getDateProcess();
							
							if ( null != sendDate ) {
								sendDateCompare = df.parse(sdf.format(sendDate));
							}
							if ( null!= dateProcess) {
								dateProcessCompare= df.parse(sdf.format(dateProcess));
							}
							if((sendDate != null && sendDateCompare.before(c1)) && 
									(dateProcess == null || dateProcessCompare.after(c1) || dateProcessCompare.equals(c1))) {
								numTonDauKy ++;
							}
						}
					} catch (ParseException e) {}
					//end
				}
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numTonDauKy;
		//end
		/* yenlt close start 05/04/2010
		 * 
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
						
				Calendar applicationDate = Calendar.getInstance(); // Ngay nhan ho so
				Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
				Calendar c1 = Calendar.getInstance(); // Tu ngay
				//Calendar c2 = Calendar.getInstance(); // Den ngay
				
				applicationDate.setTime(pmlFilePCCC.getApplicationDate());
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				if(returnDate != null) {
					exactReturningDate.setTime(returnDate);
				}
				c1.setTime(fromDate);
				//c2.setTime(toDate);
				
				if(applicationDate.before(c1) && 
						(returnDate == null || exactReturningDate.after(c1) || exactReturningDate.equals(c1))) {
					numTonDauKy ++;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numTonDauKy;
		yenlt close end */
	}
	
	/**
	 * Lay so luong ho so nhan trong thang
	 * 
	 * Dieu kien:	la nhung ho so co ngay nhan nam trong doan
	 * 				tu ngay bat dau den ngay ket thuc thong ke
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoNhanTrongThang: so luong ho so nhan trong thang
	 */
	public int getHoSoNhanTrongThang(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		// C1
		// return PmlOneDoorReceiveFileLocalServiceUtil.getListFile(fromDate, toDate).size();
		
		int numHoSoNhanTrongThang = 0;
		//yenlt update 05/4/2010
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);

				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				
				Calendar fromDateCompare = Calendar.getInstance();
				Calendar toDateCompare = Calendar.getInstance();
				
				fromDateCompare.setTime(df.parse(df.format(fromDate)));
				toDateCompare.setTime(df.parse(df.format(toDate)));
				
				String fileId = pmlFilePCCC.getFileId();
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				
				if ( processDisposeList.size() > 0) {
					try {
						processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
					} catch (Exception e) {
					}
					
					if ( null != processDispose ) {
						Date sendDate = null;
						
						Calendar sendDateCompare = Calendar.getInstance(); 
						sendDate = processDispose.getSendDate();
						
						if ( null != sendDate ) {
							sendDateCompare.setTime(df.parse(df.format(sendDate)));
						}
						if( sendDate  != null &&
								(fromDateCompare.before(sendDateCompare) || fromDateCompare.equals(sendDateCompare)) 
								&& (toDateCompare.after(sendDateCompare) || toDateCompare.equals(sendDateCompare))) {
							numHoSoNhanTrongThang ++;
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoNhanTrongThang;
		//end
		/* yenlt close start 05/04/2010
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);

				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Date applicationDate = df.parse(df.format((pmlFilePCCC.getApplicationDate())));
				
				if((fromDate.before(applicationDate) || fromDate.equals(applicationDate)) && (toDate.after(applicationDate) || toDate.equals(applicationDate))) {
					numHoSoNhanTrongThang ++;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoNhanTrongThang;
		yenlt close end */
	}
	
	/**
	 * Lay so luong ho so dung han (hoan thanh)
	 * 
	 * Dieu kien:	- Ho so co ngay hoan thanh nam trong thoi gian thong ke
	 * 				- Ngay hoan thanh khong lon hon ngay hen tra
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoDungHan: so luong ho so dung han
	 */
	public int getSoLuongHoSoDungHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		int numHoSoDungHan = 0;
		//yenlt 05/04/2010
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				
				Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				c1.setTime(df.parse(df.format(fromDate)));
				c2.setTime(df.parse(df.format(toDate)));	
				
				String fileId = pmlFilePCCC.getFileId();
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				Date exactreturnDate = null;
				Calendar exactreturnDateCompare = Calendar.getInstance(); 
				
				exactreturnDate = pmlFilePCCC.getExactReturningDate();
				if ( null != exactreturnDate ) {
					exactreturnDateCompare.setTime(df.parse(df.format(pmlFilePCCC.getExactReturningDate())));
				}
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				
				if ( processDisposeList.size() > 0) {
					try {
						processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
					} catch (Exception e) {
					}
					
					if ( null != processDispose ) {
						Date expiredDate = null;
						Date dateProcess = null;
						Calendar expiredDateCompare = Calendar.getInstance(); 
						Calendar dateProcessCompare = Calendar.getInstance(); 
						
						dateProcess = processDispose.getDateProcess();
						expiredDate = processDispose.getExpiredDate();
						
						if ( null != dateProcess) {
							dateProcessCompare.setTime(df.parse(df.format(processDispose.getDateProcess())));
						}
						
						if ( null != expiredDate ) {
							expiredDateCompare.setTime(df.parse(df.format(expiredDate)));
						}
						
						if ( exactreturnDate != null && dateProcess != null) {
							if ((c1.before(dateProcessCompare) || c1.equals(dateProcessCompare)) &&
									(c2.after(dateProcessCompare) || c2.equals(dateProcessCompare)) &&
									(exactreturnDateCompare.before(expiredDateCompare) || exactreturnDateCompare.equals(expiredDateCompare))) {
								numHoSoDungHan ++;
							}
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoDungHan;
		//end
		/* yenlt close start 05/04/2010
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
						
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				
				if(returnDate != null) { // Co ngay hoan thanh

					Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
					Calendar expectedReturningDate = Calendar.getInstance(); // Ngay hen tra 
					Calendar c1 = Calendar.getInstance(); // Tu ngay
					Calendar c2 = Calendar.getInstance(); // Den ngay
					
					exactReturningDate.setTime(returnDate);
					expectedReturningDate.setTime(pmlFilePCCC.getExpectedReturningDate());
					c1.setTime(fromDate);
					c2.setTime(toDate);
					
					if((c1.before(exactReturningDate) || c1.equals(exactReturningDate)) && 
							(c2.after(exactReturningDate) || c2.equals(exactReturningDate)) &&
							(exactReturningDate.before(expectedReturningDate) || exactReturningDate.equals(expectedReturningDate))) {
						numHoSoDungHan ++;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoDungHan;
		yenlt close end */
	}
	
	/**
	 * Lay so luong ho so tre han
	 * 
	 * Dieu kien:	- Ho so co ngay hoan thanh trong thoi gian thong ke
	 * 				- Ngay hoan thanh lon hon ngay hen tra
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoTreHan: so luong ho so tre han
	 */
	public int getSoLuongHoSoTreHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
			
		int numHoSoTreHan = 0;
		//yenlt 05/04/2010
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);

				Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				c1.setTime(df.parse(df.format(fromDate)));
				c2.setTime(df.parse(df.format(toDate)));
			
				Date exactreturnDate = null;
				Calendar exactreturnDateCompare = Calendar.getInstance(); 
				
				String fileId = pmlFilePCCC.getFileId();
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				
				exactreturnDate = pmlFilePCCC.getExactReturningDate();
				if ( null != exactreturnDate ) {
					exactreturnDateCompare.setTime(df.parse(df.format(pmlFilePCCC.getExactReturningDate())));
				}
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				
				if ( processDisposeList.size() > 0) {
					try {
						processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
					} catch (Exception e) {
					}
					
					if ( null != processDispose ) {
						Date expiredDate = null;
						Date dateProcess = null;
						Calendar expiredDateCompare = Calendar.getInstance(); 
						Calendar dateProcessCompare = Calendar.getInstance(); 
						
						dateProcess = processDispose.getDateProcess();
						expiredDate = processDispose.getExpiredDate();
						
						if ( null != dateProcess) {
							dateProcessCompare.setTime(df.parse(df.format(processDispose.getDateProcess())));
						}
						
						if ( null != expiredDate ) {
							expiredDateCompare.setTime(df.parse(df.format(expiredDate)));
						}
						
						if ( exactreturnDate != null && dateProcess != null) {
							if ((c1.before(dateProcessCompare) || c1.equals(dateProcessCompare)) &&
									(c2.after(dateProcessCompare) || c2.equals(dateProcessCompare)) &&
									(exactreturnDateCompare.after(expiredDateCompare))) {
								numHoSoTreHan ++;
							}
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoTreHan;
		//end
		/* yenlt close start 05/04/2010
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);

				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				
				if(returnDate != null) { // Co ngay hoan thanh
					
					Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
					Calendar expectedReturningDate = Calendar.getInstance(); // Ngay hen tra 
					Calendar c1 = Calendar.getInstance(); // Tu ngay
					Calendar c2 = Calendar.getInstance(); // Den ngay
					
					exactReturningDate.setTime(returnDate);
					expectedReturningDate.setTime(pmlFilePCCC.getExpectedReturningDate());
					c1.setTime(fromDate);
					c2.setTime(toDate);
					
					if(returnDate != null) { // Co ngay hoan thanh
						if((c1.before(exactReturningDate) || c1.equals(exactReturningDate)) && 
								(c2.after(exactReturningDate) || c2.equals(exactReturningDate)) &&
								(exactReturningDate.after(expectedReturningDate))) {
							numHoSoTreHan ++;
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoTreHan;
		yenlt close end */
	}
	
	/**
	 * Lay so luong ho so trong han (So luong ho so dang thu ly (ton))
	 * 
	 * Dieu kien:	- Ho so chua co ngay hoan thanh hoac ngay hoan thanh
	 * 				  lon hon ngay ket thuc thong ke
	 * 				- Ngay hen tra lon hon hoac bang ngay ket thuc thong ke
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoTrongHan: so luong ho so trong han
	 */
	public int getSoLuongHoSoTrongHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
			
		int numHoSoTrongHan = 0;
		//yenlt update 05/4/2010
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				
				Calendar c2 = Calendar.getInstance(); // Den ngay
				c2.setTime(df.parse(df.format(toDate)));
				
				String fileId = pmlFilePCCC.getFileId();
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				
				if ( processDisposeList.size() > 0) {
					try {
						processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
					} catch (Exception e) {
					}
					
					if ( null != processDispose ) {
						Date expiredDate = null;
						Date dateProcess = null;
						Date receiveDate = null;
						Calendar expiredDateCompare = Calendar.getInstance(); 
						Calendar dateProcessCompare = Calendar.getInstance(); 
						Calendar receiveDateCompare = Calendar.getInstance(); 
						
						dateProcess = processDispose.getDateProcess();
						receiveDate = processDispose.getReceiveDate();
						
						if ( null != dateProcess) {
							dateProcessCompare.setTime(df.parse(df.format(processDispose.getDateProcess())));
						}
						
						if ( null != expiredDate ) {
							expiredDateCompare.setTime(df.parse(df.format(processDispose.getExpiredDate())));
						}
						
						if ( null!= receiveDate) {
							receiveDateCompare.setTime(df.parse(df.format(processDispose.getReceiveDate())));
						}
						
						if ((dateProcess == null || dateProcessCompare.after(c2)) &&
								(receiveDateCompare.before(c2) || receiveDateCompare.equals(c2)) &&
								(expiredDateCompare.after(c2) || expiredDateCompare.equals(c2))) {
							numHoSoTrongHan ++;
						}
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoTrongHan;
		//end
		/* yenlt close start 05/04/2010
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				Calendar expectedReturningDate = Calendar.getInstance(); // Ngay hen tra		
				Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
				//Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				expectedReturningDate.setTime(pmlFilePCCC.getExpectedReturningDate());
				if(returnDate != null) {
					exactReturningDate.setTime(returnDate);
				}
				//c1.setTime(fromDate);
				c2.setTime(toDate);
				
				if((returnDate == null || exactReturningDate.after(c2)) &&
						(expectedReturningDate.after(c2) || expectedReturningDate.equals(c2))) {
					numHoSoTrongHan ++;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoTrongHan;
		yenlt close end */
	}
	
	/**
	 * Lay so luong ho so da tre han (So luong ho so dang thu ly (ton))
	 * 
	 * Dieu kien:	- Ho so chua co ngay hoan thanh hoac ngay hoan thanh
	 * 				  lon hon ngay ket thuc thong ke
	 * 				- Ngay hen tra nho hon ngay ket thuc thong ke
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoDaTreHan: so luong ho so da tre han
	 */
	public int getSoLuongHoSoDaTreHan(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		int numHoSoDaTreHan = 0;
		//yenlt update 05/4/2010
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				c2.setTime(df.parse(df.format(toDate)));
				String fileId = pmlFilePCCC.getFileId();
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				
				if ( processDisposeList.size() > 0) {
					try {
						processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
					} catch (Exception e) {
					}
					
					if ( null != processDispose ) {
						Date expiredDate = null;
						Date dateProcess = null;
						Date receiveDate = null;
						
						Calendar expiredDateCompare = Calendar.getInstance(); 
						Calendar dateProcessCompare = Calendar.getInstance(); 
						Calendar receiveDateCompare = Calendar.getInstance(); 
						
						dateProcess = processDispose.getDateProcess();
						receiveDate = processDispose.getReceiveDate();
						if ( null != dateProcess) {
							dateProcessCompare.setTime(df.parse(df.format(processDispose.getDateProcess())));
						}
						
						if ( null != expiredDate ) {
							expiredDateCompare.setTime(df.parse(df.format(processDispose.getExpiredDate())));
						}
						
						if ( null != receiveDate ) {
							receiveDateCompare.setTime(df.parse(df.format(processDispose.getReceiveDate())));
						}
						
						if ((dateProcess == null || dateProcessCompare.after(c2)) &&
								(receiveDateCompare.before(c2) || receiveDateCompare.equals(c2)) &&
								(expiredDateCompare.before(c2))) {
							numHoSoDaTreHan ++;
						}
					}
					
				}

			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoDaTreHan;
		//end
		/* yenlt close start 05/04/2010
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				Calendar expectedReturningDate = Calendar.getInstance(); // Ngay hen tra		
				Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
				//Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				expectedReturningDate.setTime(pmlFilePCCC.getExpectedReturningDate());
				if(returnDate != null) {
					exactReturningDate.setTime(returnDate);
				}
				//c1.setTime(fromDate);
				c2.setTime(toDate);
				
				if((returnDate == null || exactReturningDate.after(c2)) &&
												expectedReturningDate.before(c2)) {
					numHoSoDaTreHan ++;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoDaTreHan;
		yenlt close end */
	}
	
	/**
	 * Lay so luong ho so chinh sua, bo sung (So luong ho so dang thu ly (ton))
	 * 
	 * Dieu kien:	- Ho so co ngay nhan nho hon hoac bang ngay ket thuc thong ke
	 * 				- Co tinh trang cho bo sung
	 * 
	 * @param pmlFileTypeId: ma loai ho so
	 * @param fromDate: tu ngay
	 * @param toDate: den ngay
	 * @return numHoSoChinhSuaBoSung: so luong ho so chinh sua, bo sung
	 */
	public int getSoLuongHoSoChinhSuBoSung(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		int numHoSoChinhSuaBoSung = 0;
		//yenlt updat 05/04/2010
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		// Duyet qua tung ho so
		for(int index = 0; index < pmlFilePCCCSize; index ++) {
			
			// Lay ra tung File xu ly
			PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
			String pmlFilePCCCId = pmlFilePCCC.getFileId();
					
			Calendar c2 = Calendar.getInstance(); // Den ngay
			
			try {
				c2.setTime(df.parse(df.format(toDate)));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			List<PmlProcessDispose> pmlProcessDisposeList = new ArrayList<PmlProcessDispose>();
			try {
				pmlProcessDisposeList = PmlProcessDisposeUtil.findByFileId(pmlFilePCCCId);
			} catch (SystemException e) {
			}
			
			if (pmlProcessDisposeList.size() > 0 ) {
				List<PmlProcessDispose> list = new ArrayList<PmlProcessDispose>();
				PmlProcessDispose pmlProcessDispose = null;
				PmlStateProcess stateProcess = null;
				try {
					list = PmlProcessDisposeUtil.findByFileId_Transition (pmlFilePCCCId,pmlProcessDisposeList.size());//Yenlt update 15/03/2010
				} catch (SystemException e) {
				}
				
				if ( list.size() > 0) {
					Date sendDate = null;
					Calendar sendDateCompare = Calendar.getInstance();
					
					pmlProcessDispose = list.get(0);
					sendDate  = pmlProcessDispose.getSendDate();
					if ( null != sendDate) {
						try {
							sendDateCompare.setTime(df.parse(df.format(sendDate)));
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}
					String state = "";
					try {
						stateProcess = PmlStateProcessLocalServiceUtil.getPmlStateProcess(pmlProcessDispose.getStateProcessIdBefore());
					} catch (PortalException e) {
					} catch (SystemException e) {
					}
					
					if ( null != stateProcess) {
						state = stateProcess.getStateProcessCode();
					}
					//end
					if((sendDateCompare.before(c2) || sendDateCompare.equals(c2)) && (state.equals("chobosung"))) {
						numHoSoChinhSuaBoSung ++;
					}
				}
				
			}
		}
		return numHoSoChinhSuaBoSung;
		//end
		/*yenlt close start 05/04/2010
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String pmlFilePCCCId = pmlFilePCCC.getFileId();
						
				Calendar applicationDate = Calendar.getInstance(); // Ngay nhan ho so
				//Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				applicationDate.setTime(pmlFilePCCC.getApplicationDate());
				//c1.setTime(fromDate);
				c2.setTime(toDate);
				
				// Lay tinh trang cua ho so
				List<PmlProcessDispose> pmlProcessDisposeList = PmlProcessDisposeUtil.findByFileId(pmlFilePCCCId);
				if (pmlProcessDisposeList != null) {
					PmlProcessDispose pmlProcessDispose = PmlProcessDisposeUtil.findByFileId_Transition (pmlFilePCCCId, getMaxTransition_(pmlProcessDisposeList)).get(0);
					String state = PmlStateProcessLocalServiceUtil.getPmlStateProcess(pmlProcessDispose.getStateProcessIdBefore()).getStateProcessCode();
					
					if((applicationDate.before(c2) || applicationDate.equals(c2)) && (state.equals("chobosung"))) {
						numHoSoChinhSuaBoSung ++;
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return numHoSoChinhSuaBoSung;
		yenlt close end */
	}
	
	/**
	 * Lay buoc chuyen cuoi cung cua mot ho so (max transition_)
	 * 
	 * @param pmlProcessDisposeList
	 * @return
	 */
	/* Tam thoi dong vi ham chua su dung
	private int getMaxTransition_(List<PmlProcessDispose> pmlProcessDisposeList) {
		
		int max = 1;
		int pmlProcessDisposeSize = pmlProcessDisposeList.size();
		if(pmlProcessDisposeSize > 1) {
			max = pmlProcessDisposeList.get(0).getTransition_();
			for(int index = 1; index < pmlProcessDisposeSize; index ++) {
				int transition_ = pmlProcessDisposeList.get(index).getTransition_();
				if(transition_ > max) {
					max = transition_;
				}
			}
		}
		return max;
	}
	*/
	
	/***************************************************************************************************
	 * 					BAO CAO HO SO THANG LUY KE
	 ***************************************************************************************************/
	
	/**
	 * Lay so luong ho so nhan ton dau ky (Bao cao ho so thang luy ke)
	 * 
	 * Dieu kien:	- Hien thi so ho so thuoc tung loai ho so, moi ho so thuoc loai phong ban
	 * 				- Nhung ho so nay duoc tinh theo: ngay nop truoc ngay bat dau bao cao va
	 * 				  ngay hoan thanh khong co hoac lon hon hay bang ngay bat dau bao cao
	 * 
	 * @param pmlDepartmentId: 	ma phong ban
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	public int getTonDauKyThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return getListFileTonDauKyThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate).size();
	}
	
	public List<PmlOneDoorReceiveFile> getListFileTonDauKyThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
		//yenlt update 05/04/2010
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date dateCompare = null;
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				if ( fromDate == null) {
					return pmlOneDoorReceiveFileList;
				}
				
				
				String fileId = pmlFilePCCC.getFileId();
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				try {
					dateCompare = df.parse(sdf.format(fromDate));	
					
					if ( processDisposeList.size() > 0) {
						try {
							processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
						} catch (Exception e) {
						}
						if ( null != processDispose ) {
							Date sendDate = null;
							Date dateProcess = null;
							Date sendDateCompare = null; 
							Date dateProcessCompare = null; 
							
							dateProcess = processDispose.getDateProcess();
							sendDate = processDispose.getSendDate();
							if ( null != dateProcess) {
								dateProcessCompare = df.parse(sdf.format(dateProcess));
							}
							
							if ( null != sendDate ) {
								sendDateCompare = df.parse(sdf.format(sendDate));
							}
							
							if ((sendDate != null && sendDateCompare.before(dateCompare)) &&
									( dateProcess == null || dateProcessCompare.after(dateCompare) || dateProcessCompare.equals(dateCompare))) {
								pmlOneDoorReceiveFileList.add(pmlFilePCCC);
							}
						}
					}
					
				} catch (ParseException e) {
					
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pmlOneDoorReceiveFileList;
		//end
		/* yenlt close start 05/04/2010
		try {
			// Duyet qua tung ho so
			for(int index = 0; index < pmlFilePCCCSize; index ++) {
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
						
				Calendar applicationDate = Calendar.getInstance(); // Ngay nhan ho so
				Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
				Calendar c1 = Calendar.getInstance(); // Tu ngay
				//Calendar c2 = Calendar.getInstance(); // Den ngay
				
				applicationDate.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(new SimpleDateFormat("dd/MM/yyyy").format(pmlFilePCCC.getApplicationDate())));
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				if(returnDate != null) {
					exactReturningDate.setTime(returnDate);
				}
				c1.setTime(fromDate);
				//c2.setTime(toDate);
				
				if(applicationDate.before(c1) && 
						(returnDate == null || exactReturningDate.after(c1) || exactReturningDate.equals(c1))) {
					pmlOneDoorReceiveFileList.add(pmlFilePCCC);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pmlOneDoorReceiveFileList;
		yenlt close end */
	}
	
	/** phuong thuc nay da co chinh sua, comment bay gio dung cho phuong thuc ben duoi(doanhdv)
	 * Lay so luong ho so nhan trong giai doan tu ngay -> den ngay (Bao cao ho so thang luy ke)
	 * 
	 * Dieu kien: 	- Hien thi so ho so thuoc tung loai ho so, moi ho so thuoc loai phong ban
	 * 				- Nhung ho so nay duoc tinh trong giai doan tu ngay -> den ngay
	 * 
	 * @param pmlDepartmentId: 	ma phong ban
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	public int getHoSoNhanTuNgayDenNgayThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate).size();
	}
	
	public List<PmlOneDoorReceiveFile> getListFileHoSoNhanTuNgayDenNgayThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
		//yenlt update 05/04/2010
		String DATE_FORMAT = "yyyy-MM-dd";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date c1 = null;
		Date c2 = null;
		//end
		try {
			for(int index = 0; index < pmlFilePCCCSize; index ++) { // Duyet qua tung ho so
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				
				String fileId = pmlFilePCCC.getFileId();
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				
				try {
					c1 = df.parse(sdf.format(fromDate));	
					c2 = df.parse(sdf.format(toDate));
					
					if ( processDisposeList.size() > 0) {
						try {
							processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
						} catch (Exception e) {
						}
						
						if ( null != processDispose ) {
							Date sendDate = null;
							Date sendDateCompare = null; 
							
							sendDate = processDispose.getSendDate();
							
							if ( null != sendDate) {
								sendDateCompare= df.parse(sdf.format(sendDate));
							
							if ((c1.before(sendDateCompare) || c1.equals(sendDateCompare)) &&
									(c2.after(sendDateCompare) || c2.equals(sendDateCompare))) {
								pmlOneDoorReceiveFileList.add(pmlFilePCCC);
							}
							}
						}
					}
					
				} catch ( ParseException e) {}
				//end
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pmlOneDoorReceiveFileList;
		//end
		/* yenlt close start 05/04/2010
		
		try {
			for(int index = 0; index < pmlFilePCCCSize; index ++) { // Duyet qua tung ho so
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
						
				Calendar applicationDate = Calendar.getInstance(); // Ngay nhan ho so
				Calendar c1 = Calendar.getInstance(); // Tu ngay
				Calendar c2 = Calendar.getInstance(); // Den ngay
				
				applicationDate.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(new SimpleDateFormat("dd/MM/yyyy").format(pmlFilePCCC.getApplicationDate())));
				c1.setTime(fromDate);
				c2.setTime(toDate);
				
				// Neu (c1 <= applicationDate <= c2)
				if((c1.before(applicationDate) || c1.equals(applicationDate)) && (c2.after(applicationDate) || c2.equals(applicationDate))) {
					pmlOneDoorReceiveFileList.add(pmlFilePCCC);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pmlOneDoorReceiveFileList;
		yenlt close end */
	}
	
	/**
	 * Lay so luong ho so nhan trong thang (Bao cao ho so thang luy ke)
	 * 
	 * Dieu kien: 	- Hien thi so ho so thuoc tung loai ho so, moi ho so thuoc loai phong ban
	 * 				- Nhung ho so nay duoc tinh trong giai doan thoi gian bao cao (tu ngay -> den ngay)
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	public int getHoSoNhanTrongThangThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return getHoSoNhanTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	public List<PmlOneDoorReceiveFile> getListFileHoSoNhanTrongThangThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		return getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	/**
	 * Lay so luong ho so giai quyet trong nam
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	public int getHoSoNhanTrongNamThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		
		// Lay nam bao cao tu toDate
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		//int year = cal.YEAR;
		int year = cal.get(Calendar.YEAR);
		// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
		Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
		
		return getListFileHoSoNhanTrongNamThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, startDateOfYear, toDate).size();
	}
	
	public List<PmlOneDoorReceiveFile> getListFileHoSoNhanTrongNamThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) throws Exception {
		// Lay nam bao cao tu toDate
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		//int year = cal.YEAR;
		int year = cal.get(Calendar.YEAR);
		
		// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
		Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
		
		return getListFileHoSoNhanTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, startDateOfYear, toDate);
	}
	
	/**
	 * Lay so luong ho so giai quyet trong giai doan tu ngay -> den ngay (Bao cao ho so thang luy ke)
	 * 
	 * Dieu kien: 	- Hien thi so ho so thuoc tung loai ho so, moi ho so thuoc loai phong ban
	 * 				- Nhung ho so nay duoc tinh trong giai doan tu ngay -> den ngay
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	public int getHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate).size();
	}
	
	public List<PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
		//yenlt update 05/04/2010
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Date c1 = null;
		Date c2 = null;
		try {
			for(int index = 0; index < pmlFilePCCCSize; index ++) { // Duyet qua tung ho so
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
				String fileId = pmlFilePCCC.getFileId();
				PmlProcessDispose processDispose = null;
				List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
				
				try {
					processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
				} catch (Exception e) {
				}
				
				if ( processDisposeList.size() > 0) {
					try {
						c1 = df.parse(sdf.format(fromDate));	
						c2 = df.parse(sdf.format(toDate));
						
						try {
							processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
						} catch (Exception e) {
						}
						
						if ( null != processDispose ) {
							Date dateProcess = null;
							Date dateProcessCompare = null; 
							
							dateProcess = processDispose.getDateProcess();
							
							if ( null != dateProcess) {
								dateProcessCompare = df.parse(sdf.format(dateProcess));
							}
							
							if ( null != dateProcess && 
									(c1.before(dateProcessCompare) || c1.equals(dateProcessCompare)) &&
									(c2.after(dateProcessCompare) || c2.equals(dateProcessCompare))) {
								pmlOneDoorReceiveFileList.add(pmlFilePCCC);
							}
						}
						
					} catch(ParseException e) {}
					//end
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pmlOneDoorReceiveFileList;
		//end
		/* yenlt close start 05/04/2010
		try {
			for(int index = 0; index < pmlFilePCCCSize; index ++) { // Duyet qua tung ho so
				
				// Lay ra tung File xu ly
				PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
			
				Date returnDate = pmlFilePCCC.getExactReturningDate(); // Ngay thuc tra (ngay hoan thanh)
				if(returnDate != null) {
					Calendar exactReturningDate = Calendar.getInstance(); // Ngay thuc tra (ngay hoan thanh)
					Calendar c1 = Calendar.getInstance(); // Tu ngay
					Calendar c2 = Calendar.getInstance(); // Den ngay
					
					exactReturningDate.setTime(returnDate);
					c1.setTime(fromDate);
					c2.setTime(toDate);
					
					if((c1.before(exactReturningDate) || c1.equals(exactReturningDate)) && (c2.after(exactReturningDate) || c2.equals(exactReturningDate))) {
						pmlOneDoorReceiveFileList.add(pmlFilePCCC);
					}
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return pmlOneDoorReceiveFileList;
		yenlt close end */
	}
	
	/**
	 * Lay so luong ho so giai quyet trong thang
	 * 
	 * Dieu kien:	- Ho so giai quyet trong thang trong khoang thoi gian bao cao (tu ngay -> den ngay)
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 */
	public int getHoSoGiaiQuyetTrongThangThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		
		return getHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}
	
	public List<PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTrongThangThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date fromDate, Date toDate) {
		return getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, fromDate, toDate);
	}

	/**
	 * Lay so luong so ho so giai quyet trong nam
	 * 
	 * Dieu kien:	- Ho so giai quyet trong nam den thoi diem bao cao
	 * 
	 * @param pmlDepartmentId:	ma phong
	 * @param pmlFileTypeId: 	ma loai ho so
	 * @param fromDate: 		tu ngay
	 * @param toDate: 			den ngay
	 * @return
	 * @throws Exception 
	 */
	public int getHoSoGiaiQuyetTrongNam(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date toDate) throws Exception {
				
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		//int year = cal.YEAR; // Lay nam bao cao tu toDate
		int year = cal.get(Calendar.YEAR);
		
		// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
		Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
		
		return getHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, startDateOfYear, toDate);
	}
	
	public List<PmlOneDoorReceiveFile> getListFileHoSoGiaiQuyetTrongNam(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date toDate) throws Exception {
		Calendar cal = Calendar.getInstance();
		cal.setTime(toDate);
		//int year = cal.YEAR; // Lay nam bao cao tu toDate
		int year = cal.get(Calendar.YEAR);
		
		// Ngay dau tien cua nam bao cao (ex: 01/01/2000)
		Date startDateOfYear = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/" + year);
		
		return getListFileHoSoGiaiQuyetTuNgayDenNgayThangLuyKe(pmlFilePCCCList, pmlFilePCCCSize, startDateOfYear, toDate);
	}

	//yenlt create 05/04/2010
	public List<PmlOneDoorReceiveFile> getListFileHoSoTonThangLuyKe(List<PmlOneDoorReceiveFile> pmlFilePCCCList, int pmlFilePCCCSize, Date toDate) throws Exception {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		Calendar c2 = Calendar.getInstance();
		if ( toDate == null) {
			return pmlOneDoorReceiveFileList;
		}
		for(int index = 0; index < pmlFilePCCCSize; index ++) { // Duyet qua tung ho so
			
			// Lay ra tung File xu ly
			PmlOneDoorReceiveFile pmlFilePCCC = pmlFilePCCCList.get(index);
		
			String fileId = pmlFilePCCC.getFileId();
			PmlProcessDispose processDispose = null;
			List<PmlProcessDispose> processDisposeList = new ArrayList<PmlProcessDispose>();
			
			try {
				processDisposeList = PmlProcessDisposeUtil.findByFileId(fileId);
			} catch (Exception e) {
			}
			
			try {
				c2.setTime(df.parse(sdf.format(toDate)));
			} catch (ParseException e) {}
			
			
			if ( processDisposeList.size() > 0) {
				
				try {
					processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, processDisposeList.size()).get(0);
				} catch (Exception e) {
				}
				
				if ( null != processDispose ) {
					Date dateProcess = null;
					Date receiveDate = null;
					Calendar receiveDateCompare = Calendar.getInstance();
					Calendar dateProcessCompare = Calendar.getInstance(); 
					
					dateProcess = processDispose.getDateProcess();
					receiveDate = processDispose.getReceiveDate();
					try {
						
						if ( null != dateProcess) {
							dateProcessCompare.setTime(df.parse(sdf.format(dateProcess)));
						}
						
						if ( null != receiveDate) {
							receiveDateCompare.setTime(df.parse(sdf.format(receiveDate)));
						}
				
						if ( (null == dateProcess || c2.before(dateProcessCompare)) &&
								(receiveDateCompare.before(c2) || receiveDateCompare.equals(c2))) {
							pmlOneDoorReceiveFileList.add(pmlFilePCCC);
						}
					} catch (ParseException e) {}
				}
			}
		}
		return pmlOneDoorReceiveFileList;
	}
	//end
	/***************************************************************************************************
	 * 							TINH HINH THU LY HO SO CAP SO
	 ***************************************************************************************************/
	
	/**
	 * Lay so luong ho so ton truoc cap so
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	public int getSoLuongHoSoTonTruocCapSo(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		int num = 0;
		int pmlUserSize = pmlUserList.size();
		for(int index = 0; index < pmlUserSize; index ++) {
			num += countFileTonTruoc(pmlUserList.get(index).getUserId(), date);
		}
		return num;
	}
	
	/**
	 * Lay so luong ho so da nhan cap so 
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	public int getSoLuongHoSoDaNhanCapSo(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		int num = 0;
		int pmlUserSize = pmlUserList.size();
		for(int index = 0; index < pmlUserSize; index ++) {
			num += countFileDaNhan(pmlUserList.get(index).getUserId(), date);
		}
		return num;
	}
	
	/**
	 * Lay so luong ho so chua nhan cap so 
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	public int getSoLuongHoSoChuaNhanCapSo(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		int num = 0;
		int pmlUserSize = pmlUserList.size();
		for(int index = 0; index < pmlUserSize; index ++) {
			num += countFileChuaNhan(pmlUserList.get(index).getUserId(), date);
		}
		return num;
	}
	
	/**
	 * Lay so luong ho so giai quyet cap so
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	public int getSoLuongHoSoGiaiQuyetCapSo(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		int num = 0;
		int pmlUserSize = pmlUserList.size();
		for(int index = 0; index < pmlUserSize; index ++) {
			num += countFileTuGiaiQuyet(pmlUserList.get(index).getUserId(), date) + countFileNguoiKhacThuLyThay(pmlUserList.get(index).getUserId(), date);
		}
		return num;
	}
	
	/**
	 * Lay so luong ho so trong han ISO cap so
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	public int getSoLuongHoSoTrongHanISOCapSo(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		int num = 0;
		int pmlUserSize = pmlUserList.size();
		for(int index = 0; index < pmlUserSize; index ++) {
			num += countFileTrongHanISO(pmlUserList.get(index).getUserId(), date);
		}
		return num;
	}
	
	/**
	 * Lay so luong ho so qua han ISO cap so
	 * 
	 * @param pmlUserList: 	danh sach user
	 * @param date:			ngay bao cao thong ke
	 * @return
	 * @throws Exception
	 */
	public int getSoLuongHoSoQuaHanISOCapSo(List<PmlUser> pmlUserList, Date date) throws Exception {
		
		int num = 0;
		int pmlUserSize = pmlUserList.size();
		for(int index = 0; index < pmlUserSize; index ++) {
			num += countFileQuaHanISO(pmlUserList.get(index).getUserId(), date);
		}
		return num;
	}
	
	public String getFullName(long userId) throws Exception {
		
		User user = UserUtil.findByPrimaryKey(userId);
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		String middleName = user.getMiddleName();
		String fullName = lastName + " " + middleName + " " + firstName;
		return fullName;
	}
	
	/**
	 * Lay tat ca cac file ma user xu ly khong can quan tam buoc xu ly
	 * @param userId
	 * @return
	 */
	public List<PmlProcessDispose> getListFileForUser(long userId) {
		
		List<PmlProcessDispose> retValue = new ArrayList<PmlProcessDispose>();
		
		// lay danh sach List<PmlProcessDispose> thuoc tham quyen cua chuyen vien
		List<PmlProcessDispose> list = getListProcessDisposeOfUser(userId);
		
		// lay danh sach List<PmlProcessDispose> theo fileId va transitionMax cua fileId do
		List<PmlProcessDispose> list1 = new ArrayList<PmlProcessDispose>();
		PmlProcessDispose processDispose = null;
		
		// lay fileId va transitionMax cua fileId do
		for (PmlProcessDispose pmlProcessDispose : list) {
			String fileId = pmlProcessDispose.getFileId();
			int transitionMax = getTransitionMaxOfFile(fileId, list);
			try {
				processDispose = PmlProcessDisposeUtil.findByFileId_Transition(fileId, transitionMax).get(0);
				if (list1.contains(processDispose)) {
					continue;
				}
				list1.add(processDispose);
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		retValue.addAll(list1);
		
		return retValue;
	}
	
	// minh 20100204
	public int searchCount(String keywords) throws SystemException{
		return pmlUserFinder.countByKeywords(keywords);
	}
	
	/* Thay tim theo ten vi tri bang tim theo ma vi tri
	public int searchCount(String screenName, String lastName,
			String middleName, String firstName, String postionName, boolean andOperator) throws SystemException{
		return pmlUserFinder.countByPmlUser(screenName, lastName,
				middleName, firstName, postionName, andOperator);
	}
	*/
	
	public int searchCount(String screenName, String lastName,
			String middleName, String firstName, String positionId, boolean andOperator) throws SystemException{
		return pmlUserFinder.countByPmlUser(screenName, lastName,
				middleName, firstName, positionId, andOperator);
	}

	public List<PmlUser> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlUserFinder.findByKeywords(keywords, start, end, obc);
	}
	
	/* Thay tim theo ten vi tri bang tim theo ma vi tri
	public List<PmlUser> search(String screenName, String lastName,
			String middleName, String firstName, String postionName,
			boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlUserFinder.findByPmlUser(screenName, lastName,
				middleName, firstName, postionName, andOperator, start, end, obc);
	}
	*/

	public List<PmlUser> search(String screenName, String lastName,
			String middleName, String firstName, String positionId,
			boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlUserFinder.findByPmlUser(screenName, lastName,
				middleName, firstName, positionId, andOperator, start, end, obc);
	}

	// end
	
	/**
	 * @author phmphuc
	 * lay danh sach hien thi theo userId
	 */
	public List<PmlUser> findUserListByDepartmentId(String departmentsId, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlUserFinder.findUserListByDepartmentId(departmentsId, start, end, obc);
	}
	
	public int countUserListByDepartmentId(String departmentsId) throws Exception {
		return pmlUserFinder.countUserListByDepartmentId(departmentsId);
	}
	
	public int countTinhHinhThuLyCongVanChuyenVien(String departmentId) throws Exception {
		return pmlUserFinder.countTinhHinhThuLyCongVanChuyenVien(departmentId);
	}
	
	/**
	 * phmphuc 30/05/2010
	 * lay danh sach user theo phong ban - danh muc phong ban
	 */
	public List<PmlUser> findUserListByDepartment(String departmentsId, int start, int end) throws SystemException{
		return pmlUserFinder.findUserListByDepartment(departmentsId, start, end);
	}
	
	public int countUserListByDepartment(String departmentsId) throws Exception {
		return pmlUserFinder.countUserListByDepartment(departmentsId);
	}
	// end
	
	/**
	 * Dong bo nguoi dung cua phan mem loi theo nguoi dung cua portal
	 * 
	 * @author CONGPHAM
	 */
	public void synchronizePmlUserWithPortalUser() throws Exception {
		// Cach thuc dong bo
		// Doc tat ca nguoi dung cua portal ngoai tru nguoi dung co defaultUser la true
		// Kiem tra neu nguoi dung da co trong pmlUser thi cap nhat thong tin tu portalUer
		// Neu chua co trong pmlUser thi them moi vao pmlUser
		// Do lai tat ca nguoi dung cua pmlUser neu khong co trong portalUser thi xoa trong pmlUser
		// Khi xoa trong pmlUser phai kiem tra cac bang lien quan nhu van ban den, di, ho so, ho so cong viec
		// Neu con tham chieu thi bo qua, khong xoa khoi pmlUser
		
		// ********** Doc danh sach tat ca nguoi dung tu portal **********
		List<User> users = UserUtil.findAll();
		// ********** Doc tat ca nguoi dung ban dau tu pmlUser **********
		List<PmlUser> pmlUsers = PmlUserUtil.findAll();
		// ********** Cac danh sach userId dung chung **********
		List<Long> userIdExist = new ArrayList<Long>(); // Ma so nguoi dung da ton tai trong pmlUser
		List<Long> userIdNew = new ArrayList<Long>(); // Ma so nguoi dung duoc them vao pmlUser
		List<Long> userIdDelete = new ArrayList<Long>(); // Ma so nguoi dung can xoa di khoi pmlUser
		
		// ********** Duyet danh sach nguoi dung tu portal de them hoac hieu chinh **********
		if (users != null && !users.isEmpty()) {
			for (int idxPU = 0; idxPU < users.size(); idxPU ++) {
				User userItem = (User) users.get(idxPU);
				// Bo qua cac user co defaultUser la true
				if (userItem.getDefaultUser() == true) {
					continue;
				}
				
				PmlUser chkPmlUser = null; // Doi tuong pmlUser de kiem tra
				PmlUser updPmlUserItem = null; // Doi tuong pmlUser them moi hoac hieu chinh
				try {
					chkPmlUser = PmlUserUtil.findByPrimaryKey(userItem.getUserId());
					updPmlUserItem = chkPmlUser;
					// Them userId vao danh sach nguoi dung da ton tai
					userIdExist.add((Long) userItem.getUserId());
				}
				catch (Exception ex) {
					if (ex instanceof NoSuchPmlUserException) {
						chkPmlUser = null;
						// Them userId vao danh sach nguoi dung moi
						userIdNew.add((Long) userItem.getUserId());
						// ********** Them vao pmlUser **********
						updPmlUserItem = PmlUserUtil.create(userItem.getUserId());
					}
					else { // Loi khac
						throw new Exception();
					}
				}
				// Cap nhat thong tin nguoi dung moi tu nguoi dung cua portal
				if (updPmlUserItem != null) {
					updPmlUserItem.setActive(userItem.getActive());
					updPmlUserItem.setScreenName(userItem.getScreenName());
					updPmlUserItem.setFirstName(userItem.getFirstName());
					updPmlUserItem.setMiddleName(userItem.getMiddleName());
					updPmlUserItem.setLastName(userItem.getLastName());
					updPmlUserItem.setMale(userItem.getMale());
					updPmlUserItem.setBirthday(userItem.getBirthday());
					
					// Cap nhat vao database
					pmlUserPersistence.update(updPmlUserItem, false);
				}
			} // end for
		} // end if
		
		// ********** Duyet danh sach nguoi dung tu pml de xoa nhung nguoi dung khong ton tai trong portal **********
		if (pmlUsers != null && !pmlUsers.isEmpty()) {
			for (int idxPMLU = 0; idxPMLU < pmlUsers.size(); idxPMLU ++) {
				PmlUser pmlUItem = (PmlUser) pmlUsers.get(idxPMLU);
				// Kiem tra neu ma so khong co trong danh sach them moi hoac hieu chinh thi dua vao xoa
				if (userIdExist.contains((Long) pmlUItem.getUserId()) || 
						userIdNew.contains((Long) pmlUItem.getUserId())) {
					continue;
				}
				// Them vao danh sach can xoa
				userIdDelete.add((Long) pmlUItem.getUserId());
			}
			
			// Thuc hien xoa nguoi dung khong ton tai trong portal
			for (int idxDel = 0; idxDel < userIdDelete.size(); idxDel ++) {
				// Goi ham xoa
				removePmlUser((long) userIdDelete.get(idxDel));
			}
		}
		return;
	}
	
	public boolean removePmlUser(long userId) throws SystemException, PortalException {
		
		// ********** Kiem tra cac rang buoc lien quan **********
		// Van ban den
		if (PmlEdmDocumentReceiptUtil.countByMainUserProcessId(userId) > 0) return false;
		// Log van ban den
		if (PmlDocumentReceiptLogUtil.countByProcesser(userId) > 0) return false;
		if (PmlDocumentReceiptLogUtil.countByReceiver(userId) > 0) return false;
		// Van ban di
		if (PmlEdmDocumentSendUtil.countByEditorId(userId) > 0) return false;
		if (PmlEdmDocumentSendUtil.countBySignerId(userId) > 0) return false;
		// Log van ban di
		if (PmlDocumentSendLogUtil.countByProcesser(userId) > 0) return false;
		if (PmlDocumentSendLogUtil.countByReceiver(userId) > 0) return false;
		// Ho so cong viec
		if (PmlHoSoCongViecUtil.countByUserId(userId) > 0) return false;
		// Lanh dao phong
		if (PmlDepartmentsLeaderUtil.countByUserId(userId) > 0) return false;
		// Con thieu phan ho so, bo sung sau
		
		// Xoa nguoi dung tu pml dua vao ma so nguoi dung
		pmlUserPersistence.remove(userId);
		return true;
	}
	/**
	 * PHAN QUYEN THEO DOI HS 18/10/2010
	 * @throws SystemException 
	 */

	public List<User> listUserTheoDoiHoSo(int start, int end, OrderByComparator obc) throws SystemException {
		return pmlUserFinder.listUserTheoDoiHoSo(start, end, obc);
	}
	
	public int countUserTheoDoiHoSo() throws SystemException {
		return pmlUserFinder.countUserTheoDoiHoSo();
	}
}