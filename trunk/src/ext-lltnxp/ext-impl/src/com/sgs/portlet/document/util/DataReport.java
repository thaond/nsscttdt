/**
 * 
 */
package com.sgs.portlet.document.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.document.NoSuchPmlStateProcessException;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.PmlDocumentReceiptWF;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.document.model.PmlDocumentSendWF;
import com.sgs.portlet.document.model.PmlStateProcess;
import com.sgs.portlet.document.receipt.NoSuchPmlEdmDocumentReceiptException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.send.NoSuchPmlEdmDocumentSendException;
import com.sgs.portlet.document.send.model.PmlEdmAnswerDetail;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.persistence.PmlEdmAnswerDetailUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptLogUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentReceiptWFUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendLogUtil;
import com.sgs.portlet.document.service.persistence.PmlDocumentSendWFUtil;
import com.sgs.portlet.document.service.persistence.PmlStateProcessUtil;
import com.sgs.portlet.document.workflow.DocumentReceiptLiferayWorkflowService;
import com.sgs.portlet.document.workflow.DocumentSendLiferayWorkflowService;
import com.sgs.portlet.holiday.service.PmlHolidayLocalServiceUtil;
import com.sgs.portlet.department.NoSuchDepartmentException;
import com.sgs.portlet.pmluser.NoSuchPmlUserException;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;


/**
 * @author lethanhtung
 *
 */
public class DataReport {
	
	/*
	 * *******************************************************************************************
	 * 									CONG VAN DEN
	 * *******************************************************************************************
	 */
	/**
	 * @param list
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @return
	 */
	public List<PmlDocumentReceiptLog> filter_CVDen(String departmentId, long userId, int documentRecordTypeId) {
		
		List<PmlDocumentReceiptLog> list = new ArrayList<PmlDocumentReceiptLog>();

		try {
			// get all PmlDocumentReceiptLog
			list = PmlDocumentReceiptLogUtil.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		List<PmlDocumentReceiptLog> retValue = filterByDepartmentId_CVDen(list, departmentId);
		retValue = filterByUserId_CVDen(retValue, userId);
		retValue = filterByDocumentRecordTypeId_CVDen(retValue, documentRecordTypeId);
		
		return retValue;
	}
	
	/**
	* - Lay ds User theo departmentId : listUser <br>
	* - Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>(); <br>
	* - Duyet listUser, lay userIdOfListUser <br>
	* - Duyet list, lay processer <br>
	* - Neu userIdOfListUser = processer thi them doi tuong DocumentReceiptLog vao retValue
	* 
	* @param list
	* @param departmentId
	* @return List<PmlDocumentReceiptLog>
	*/
	private List<PmlDocumentReceiptLog> filterByDepartmentId_CVDen(List<PmlDocumentReceiptLog> list, String departmentId) {
	
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (list == null) {
			return new ArrayList<PmlDocumentReceiptLog>();
		}
		
		if (departmentId != null) {
			try {
				// get list of PmlUser by departmentId
				List<PmlUser> listUser = PmlUserUtil.findByDepartmentsId(departmentId);
				
				for (PmlUser pmlUser : listUser) {
					// get userId from listUser
					long userId = pmlUser.getUserId();
					
					for (PmlDocumentReceiptLog pmlEdmReceiptLog : list) {
						// get processer from list
						long processer = pmlEdmReceiptLog.getProcesser();
						
						if (processer == userId) {
							retValue.add(pmlEdmReceiptLog);
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	
		return retValue;
	}
	
	/**
	* - Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	* - Duyet list, lay ra processer <br>
	* - Neu processer = userId thi them doi tuong PmlDocumentReceiptLog vao retValue
	* 
	* @param list
	* @param userId
	* @return
	*/
	private List<PmlDocumentReceiptLog> filterByUserId_CVDen(List<PmlDocumentReceiptLog> list, long userId) {
	
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (list == null) {
			return new ArrayList<PmlDocumentReceiptLog>();
		}
		
		if (userId != 0) {
			for (PmlDocumentReceiptLog pmlEdmReceiptLog : list) {
				long processer = pmlEdmReceiptLog.getProcesser();
				if (processer == userId) {
					retValue.add(pmlEdmReceiptLog);
				}
			}
		}
	
		return retValue;
	}
	
	/**
	 * Neu documentRecordTypeId == 0 <br>
	 * - Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * - Tao List<PmlDocumentReceipt> listDocumentReceipt = PmlEdmDocumentReceiptUtil.findAll() <br>
	 * - Duyet listDocumentReceipt, lay documentReceiptIdOfList <br>
	 * - Duyet list, lay documentReceiptId <br>
	 * - Neu documentReceiptId == documentReceiptIdOfList thi them doi tuong PmlDocumentReceiptLog vao retValue <br>
	 * Neu documentRecordTypeId != 0 <br>
	 * - Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * - Lay ds PmlEdmDocumentType theo documentRecordTypeId <br> 
	 *   listDocumentType = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId) <br>
	 * - Duyet listDocumentType, lay documentTypeId <br>
	 * - Tao List<PmlDocumentReceipt> listDocumentReceipt = PmlDocumentReceiptLogUtil.findByDocumentTypeId(documentTypeId) <br>
	 * - Duyet listDocumentReceipt, lay documentReceiptIdOfList <br>
	 * - Duyet list, lay documentReceiptId <br>
	 * - Neu documentReceiptId == documentReceiptIdOfList thi them doi tuong PmlDocumentReceiptLog vao retValue 
	 * 
	 * @param list
	 * @param documentRecordTypeId
	 * @return
	 */
	private List<PmlDocumentReceiptLog> filterByDocumentRecordTypeId_CVDen(List<PmlDocumentReceiptLog> list, int documentRecordTypeId) {
	
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (list == null) {
			return new ArrayList<PmlDocumentReceiptLog>();
		}
		
		if (documentRecordTypeId == 0) {
			try {
				// get all PmlEdmDocumentReceipt
				List<PmlEdmDocumentReceipt> listDocumentReceipt = PmlEdmDocumentReceiptUtil.findAll();
				
				if (listDocumentReceipt != null && listDocumentReceipt.size() > 0) {
					for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : listDocumentReceipt) {
						// get documentReceiptId from listDocumentReceipt
						long documentReceiptId = pmlEdmDocumentReceipt.getDocumentReceiptId();
						
						for (PmlDocumentReceiptLog item : list) {
							if (documentReceiptId == item.getDocumentReceiptId()) {
								retValue.add(item);
							}
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else if (documentRecordTypeId != 0) {
			try {
				// get list PmlEdmDocumentType by documentRecordTypeId
				List<PmlEdmDocumentType> listDocumentType = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId);
				
				// get list PmlEdmDocumentReciept from listDocumentType
				List<PmlEdmDocumentReceipt> listDocumentReceipt = new ArrayList<PmlEdmDocumentReceipt>();
				List<PmlEdmDocumentReceipt> listDocumentReceipt2 = null;
				
				for (PmlEdmDocumentType pmlEdmDocumentType : listDocumentType) {
					// get documentTypeId from listDocumentType
					long documentTypeId = pmlEdmDocumentType.getDocumentTypeId();
					
					// get list PmlEdmDocumentReceipt by documentTypeId
					listDocumentReceipt2 = PmlEdmDocumentReceiptUtil.findByDocumentTypeId(documentTypeId);
					
					listDocumentReceipt.addAll(listDocumentReceipt2);
				}
				
				if (listDocumentReceipt != null && listDocumentReceipt.size() > 0) {
					for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : listDocumentReceipt) {
						// get documentReceiptId from listDocumentReceipt
						long documentReceiptId = pmlEdmDocumentReceipt.getDocumentReceiptId();
						
						for (PmlDocumentReceiptLog item : list) {
							if (documentReceiptId == item.getDocumentReceiptId()) {
								retValue.add(item);
							}
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	/**
	 * Lay ds PmlDocumentReceiptLog : resultList = getListForTonDauKy_CVDen(departmentId, userId, documentRecordTypeId, startDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param list
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int tonDauKy_CVDen(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForTonDauKy_CVDen(departmentId, userId, documentRecordTypeId, startDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dataProcess, dateReceive <br>
	 * Neu dateProcess == null hoac dateProcess >= startDate va receiveDate < startDate thi them PmlDocumentReceiptLog vao retValue <br>
	 * 
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForTonDauKy_CVDen(String departmentId, long userId, int documentRecordTypeId,
							Date startDate) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentReceiptLog by documentReceiptId and max transition of documentReceiptId
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			// get documentReceiptId from each item of list
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			
			// get max transition of each documentReceipt
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			try {
				// get PmlDocumentReceiptLog by documentReceiptId and transitionMax
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentReceiptLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dataProcess
			Date dateReceive = item.getReceiveDate(); // get dateReceive
			if (dateProcess == null) {
				retValue.add(item);
			} else if (dateProcess != null && dateReceive != null) {
				Date dateProcessCompare = null;
				Date dateReceiveCompare = null;
				Date startDateCompare = null;
				
				// parse dateProcess, dateReceive, startDate by dd-MM-yyyy
				dateProcessCompare = convertDateFormat(dateProcess);
				dateReceiveCompare = convertDateFormat(dateReceive);
				startDateCompare = convertDateFormat(startDate);
				
				// if dateProcess >= startDate and dateReceive = startDate, add PmlDocumentReceiptLog object from list1 into retValue
				if ((dateProcessCompare.after(startDateCompare) || dateProcessCompare.equals(startDateCompare))
								&& (dateReceiveCompare.before(startDateCompare))) {
					retValue.add(item);
				}
			}
		}

		return retValue;
	}

	/**
	 * Get transitionMax of documentReceiptId from list PmlDocumentReceiptLog
	 * 
	 * @param documentReceiptId
	 * @param list
	 * @return
	 */
	private int getTransitionMaxOfDocumentReceiptLog(long documentReceiptId, List<PmlDocumentReceiptLog> list) {

		int max = 1;
		
		List<PmlDocumentReceiptLog> listResult = new ArrayList<PmlDocumentReceiptLog>();
		
		for (PmlDocumentReceiptLog item : list) {
			long documentReceiptIdOfList = item.getDocumentReceiptId();
			if (documentReceiptIdOfList == documentReceiptId) {
				listResult.add(item);
			}
		}
		
		max = getTransitionMax(listResult);
		
		return max;
	}

	/**
	 * Get transitionMax in list of DocumentReceiptLog
	 * 
	 * @param list
	 * @return
	 */
	private int getTransitionMax(List<PmlDocumentReceiptLog> list) {

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
	 * Lay ds PmlDocumentReceiptLog : resultList = getListForNhanTrongKy_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param list
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int nhanTrongKy_CVDen(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForNhanTrongKy_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay receiveDate <br>
	 * Neu receiveDate >= startDate va receiveDate <= endDate thi them PmlDocumentReceiptLog vao retValue
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForNhanTrongKy_CVDen(String departmentId, long userId, int documentRecordTypeId,
						Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, documentRecordTypeId);
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			try {
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentReceiptLog item : list1) {
			Date dateReceive = item.getReceiveDate();
			if (dateReceive != null) {
				Date dateReceiveCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				dateReceiveCompare = convertDateFormat(dateReceive);
				startDateCompare = convertDateFormat(startDate);
				endDateCompare = convertDateFormat(endDate);
				
				if ((dateReceiveCompare.after(startDateCompare) || dateReceiveCompare.equals(startDateCompare))
								&& (dateReceiveCompare.before(endDateCompare) || dateReceiveCompare.equals(endDateCompare))) {
					retValue.add(item);
				}
			}
		}

		return retValue;
	}
	
	/**
	 * Lay ds PmlDocumentReceiptLog : resultList = getListForDaGiaiQuyet_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int daGiaiQuyet_CVDen(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForDaGiaiQuyet_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va startDate <= dateSuccess <= endDate thi them PmlDocumentReceiptLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForDaGiaiQuyet_CVDen(String departmentId, long userId, int documentRecordTypeId,
						Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, documentRecordTypeId);
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			try {
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentReceiptLog item : list1) {
			Date dateProcess = item.getDateProcess();
			int numDateProcess = item.getNumDateProcess();
			if (dateProcess != null) {
				Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
				if (dateSuccess != null) {
					Date dateSuccessCompare = null;
					Date startDateCompare = null;
					Date endDateCompare = null;
					
					dateSuccessCompare = convertDateFormat(dateSuccess);
					startDateCompare = convertDateFormat(startDate);
					endDateCompare = convertDateFormat(endDate);
					
					if ((dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
									&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
						retValue.add(item);
					}
				}
			}
		}

		return retValue;
	}
	
	public List<PmlDocumentReceiptLog> getListLog_CVDen_DaXuLy (long userId, Date date) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (userId == 0 || date == null) {
			return retValue;
		}
		
		try {
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			String departmentId = pmlUser.getDepartmentsId();
			
			if (departmentId != null) {
				List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, 0);
				List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
				PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
				
				// lay documentReceiptId va transitionMax cua documentReceiptId do
				for (PmlDocumentReceiptLog documentReceiptLog : list) {
					long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
					int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
					try {
						pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
						if (list1.contains(pmlDocumentReceiptLog)) {
							continue;
						}
						list1.add(pmlDocumentReceiptLog);
					} catch (SystemException e) {
						e.printStackTrace();
					}
				}
				
				for (PmlDocumentReceiptLog item : list1) {
					Date dateProcess = item.getDateProcess();
					int numDateProcess = item.getNumDateProcess();
					if (dateProcess != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
						if (dateSuccess != null) {
							Date dateSuccessCompare = null;
							Date dateCompare = null;
							
							dateSuccessCompare = convertDateFormat(dateSuccess);
							dateCompare = convertDateFormat(date);
							
							if ((dateSuccessCompare.before(dateCompare) || dateSuccessCompare.equals(dateCompare))) {
								retValue.add(item);
							}
						}
					}
				}
			}
		} catch (NoSuchPmlUserException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public List<PmlDocumentReceiptLog> getListLog_CVDen_DaXuLy_TreHan (long userId, Date date) {
		
		List<PmlDocumentReceiptLog> retValue = getListLog_CVDen_DaXuLy(userId, date);
		
		List<PmlDocumentReceiptLog> listLogTreHan = getListForTreHan_CVDen(userId, date);
		retValue.retainAll(listLogTreHan);
		
		return retValue;
	}
	
	public List<PmlEdmDocumentReceipt> getListDocumentReceipt_DaXuLy_TreHan (long userId, Date date, long statusId) {
		
		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		
		List<PmlDocumentReceiptLog> listLog = getList_DaXuLy_TreHan(userId, date, statusId);
		for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
			long documentReceiptId = pmlDocumentReceiptLog.getDocumentReceiptId();
			
			try {
				PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
				
				if (documentReceipt != null) {
					if (retValue.contains(documentReceipt)) continue;
					retValue.add(documentReceipt);
				}
			} catch (NoSuchPmlEdmDocumentReceiptException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	public List<PmlEdmDocumentReceipt> getListDocumentReceipt_DaXuLy (long userId, long statusId, int year) {
		
		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		
		if (userId == 0 || statusId == 0 || year == 0) {
			return retValue;
		}
		
		if ((new Date().getYear() + 1900) >= year){
			if ((new Date().getYear() + 1900) > year) {
				Date startDate = new Date(year - 1900, 0, 1);
				Date endDate = new Date(year - 1900, 11, 31);
				List<PmlDocumentReceiptLog> listLog = getList_CVDen_DaXuLy(userId, startDate, endDate, statusId);
				for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
					long documentReceiptId = pmlDocumentReceiptLog.getDocumentReceiptId();
					
					try {
						PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
						
						if (documentReceipt != null) {
							if (retValue.contains(documentReceipt)) continue;
							retValue.add(documentReceipt);
						}
					} catch (NoSuchPmlEdmDocumentReceiptException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
				}
			}
			List<PmlDocumentReceiptLog> listLog = getList_CVDen_DaXuLy(userId, new Date(), statusId);
			for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
				long documentReceiptId = pmlDocumentReceiptLog.getDocumentReceiptId();
				
				try {
					PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					
					if (documentReceipt != null) {
						if (retValue.contains(documentReceipt)) continue;
						retValue.add(documentReceipt);
					}
				} catch (NoSuchPmlEdmDocumentReceiptException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}

	private List<PmlDocumentReceiptLog> getList_CVDen_DaXuLy(long userId, Date startDate, Date endDate, long statusId) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		List<PmlDocumentReceiptLog> listLog = getListLog_CVDen_DaXuLy(userId, startDate, endDate);
		try {
			List<PmlStateProcess> listStateProcess1 = PmlStateProcessUtil.findByFileStatusId(statusId);
			List<PmlStateProcess> listStateProcess2 = getListStateProcessByListLog(listLog);
			
			listStateProcess2.retainAll(listStateProcess1);
			
			for (PmlStateProcess pmlStateProcess : listStateProcess2) {
				long stateProcessId = pmlStateProcess.getStateProcessId();
				
				for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
					long stateProcessIdBefore = pmlDocumentReceiptLog.getStateProcessIdBefore();
					
					if (stateProcessId == stateProcessIdBefore) {
						if (retValue.contains(pmlDocumentReceiptLog)) continue;
						retValue.add(pmlDocumentReceiptLog);
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	private List<PmlDocumentReceiptLog> getListLog_CVDen_DaXuLy(long userId, Date startDate, Date endDate) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (userId == 0 || startDate == null || endDate == null) {
			return retValue;
		}
		
		try {
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			String departmentId = pmlUser.getDepartmentsId();
			
			List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, 0);
			List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
			PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
			
			// lay documentReceiptId va transitionMax cua documentReceiptId do
			for (PmlDocumentReceiptLog documentReceiptLog : list) {
				long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
				int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
				try {
					pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
					if (list1.contains(pmlDocumentReceiptLog)) {
						continue;
					}
					list1.add(pmlDocumentReceiptLog);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
			for (PmlDocumentReceiptLog item : list1) {
				Date dateProcess = item.getDateProcess();
				int numDateProcess = item.getNumDateProcess();
				if (dateProcess != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
					if (dateSuccess != null) {
						Date dateSuccessCompare = null;
						Date startDateCompare = null;
						Date endDateCompare = null;
						
						dateSuccessCompare = convertDateFormat(dateSuccess);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);
						
						if ((dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
										&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
							retValue.add(item);
						}
					}
				}
			}
		} catch (NoSuchPmlUserException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		

		return retValue;
	}

	private List<PmlDocumentReceiptLog> getList_CVDen_DaXuLy(long userId, Date date, long statusId) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		List<PmlDocumentReceiptLog> listLog = getListLog_CVDen_DaXuLy(userId, date);
		try {
			List<PmlStateProcess> listStateProcess1 = PmlStateProcessUtil.findByFileStatusId(statusId);
			List<PmlStateProcess> listStateProcess2 = getListStateProcessByListLog(listLog);
			
			listStateProcess2.retainAll(listStateProcess1);
			
			for (PmlStateProcess pmlStateProcess : listStateProcess2) {
				long stateProcessId = pmlStateProcess.getStateProcessId();
				
				for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
					long stateProcessIdBefore = pmlDocumentReceiptLog.getStateProcessIdBefore();
					
					if (stateProcessId == stateProcessIdBefore) {
						if (retValue.contains(pmlDocumentReceiptLog)) continue;
						retValue.add(pmlDocumentReceiptLog);
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	private List<PmlDocumentReceiptLog> getList_DaXuLy_TreHan(long userId, Date date, long statusId) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (userId == 0 || date == null || statusId == 0) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> listLog = getListLog_CVDen_DaXuLy_TreHan(userId, date);
		try {
			List<PmlStateProcess> listStateProcess1 = PmlStateProcessUtil.findByFileStatusId(statusId);
			List<PmlStateProcess> listStateProcess2 = getListStateProcessByListLog(listLog);
			
			listStateProcess2.retainAll(listStateProcess1);
			
			for (PmlStateProcess pmlStateProcess : listStateProcess2) {
				long stateProcessId = pmlStateProcess.getStateProcessId();
				
				for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
					long stateProcessIdBefore = pmlDocumentReceiptLog.getStateProcessIdBefore();
					
					if (stateProcessId == stateProcessIdBefore) {
						if (retValue.contains(pmlDocumentReceiptLog)) continue;
						retValue.add(pmlDocumentReceiptLog);
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	/**
	 * @param dateProcess
	 * @param numDateProcess
	 * @return
	 */
	private Date getDateSuccess(Date dateProcess, int numDateProcess) {
		
		Date retValue = dateProcess;
		String DATE_FORMAT = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		
		if (numDateProcess == 0) {
			return retValue;
		}
		
		Date dateProcessCompare = convertDateFormat(dateProcess, DATE_FORMAT);
		String strDate = sdf.format(dateProcessCompare);
		int numDate = PmlHolidayLocalServiceUtil.checkDateHoliday(strDate, numDateProcess);
		int totalDate = numDate + numDateProcess;
		Calendar cal = Calendar.getInstance();
		cal.setTime(retValue);
		cal.add(Calendar.DAY_OF_YEAR, totalDate);
		retValue = cal.getTime();

		return retValue;
	}
	
	/**
	 * Convert a date by DATE_FORMAT
	 * @param date
	 * @param DATE_FORMAT
	 * @return
	 */
	private Date convertDateFormat(Date date, String DATE_FORMAT) {
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		
		Date retValue = null;
		try {
			retValue = df.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * Convert a date by dd-MM-yyyy format
	 * @param date
	 * @return
	 */
	private Date convertDateFormat(Date date) {
		
		String DATE_FORMAT = "dd-MM-yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		
		Date retValue = null;
		
		try {
			retValue = df.parse(sdf.format(date));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	/**
	 * Lay ds DocumentReceiptLog : resultList = getListForDungHan_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int dungHan_CVDen(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForDungHan_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va startDate <= dateSuccess <= endDate va dateSuccess <= expiredDate thi them PmlDocumentReceiptLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForDungHan_CVDen(String departmentId, long userId, int documentRecordTypeId,
					Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentReceiptLog by documentReceiptId and max transition of documentReceiptId
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			// get documentReceiptId from each item of list
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			
			// get max transition of documentReceiptId
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			try {
				// get PmlDocumentReceiptLog by documentReceiptId and transitionMax
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentReceiptLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dateProcess
			Date expiredDate = item.getExpiredDate(); // get expiredDate
			int numDateProcess = item.getNumDateProcess(); // get numDateProcess
			
			Date dateSuccessCompare = null;
			Date expiredDateCompare = null;
			Date startDateCompare = null;
			Date endDateCompare = null;
			
			if (expiredDate == null) {
				if (dateProcess != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
					dateSuccessCompare = convertDateFormat(dateSuccess);
					startDateCompare = convertDateFormat(startDate);
					endDateCompare = convertDateFormat(endDate);
					if ((dateSuccessCompare != null)
							&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
							|| (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
						if (retValue.contains(item)) {
							continue;
						}
						retValue.add(item);
					}
				}
			}
			
			if (dateProcess != null && expiredDate != null) {
				Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
				if (dateSuccess != null) {
					// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
					dateSuccessCompare = convertDateFormat(dateSuccess);
					expiredDateCompare = convertDateFormat(expiredDate);
					startDateCompare = convertDateFormat(startDate);
					endDateCompare = convertDateFormat(endDate);

					if ((dateSuccessCompare != null)
							&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
							&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
							&& (dateSuccessCompare.before(expiredDateCompare) || dateSuccessCompare.equals(expiredDateCompare))) {
						if (retValue.contains(item)) {
							continue;
						}
						retValue.add(item);
					}
				}
			}
		}

		return retValue;
	}

	/**
	 * Lay ds PmlDocumentReceiptLog : resultList = getListForTreHan_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate)<br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int treHan_CVDen(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForTreHan_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va startDate <= dateSuccess <= endDate va dateSuccess > expiredDate thi them PmlDocumentReceiptLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForTreHan_CVDen(String departmentId, long userId, int documentRecordTypeId,
						Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentReceiptLog by documentReceiptId and max transition of documentReceiptId
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			// get documentReceiptId from each item of list
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			
			// get max transition of documentReceiptId
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			try {
				// get PmlDocumentReceiptLog by documentReceiptId and transitionMax
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentReceiptLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dateProcess
			Date expiredDate = item.getExpiredDate(); // get expiredDate
			int numDateProcess = item.getNumDateProcess();
			
			Date dateSuccessCompare = null;
			Date expiredDateCompare = null;
			Date startDateCompare = null;
			Date endDateCompare = null;
			
			if (dateProcess != null && expiredDate != null) {
				Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
				if (dateSuccess != null) {
					
					
					// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
					dateSuccessCompare = convertDateFormat(dateSuccess);
					expiredDateCompare = convertDateFormat(expiredDate);
					startDateCompare = convertDateFormat(startDate);
					endDateCompare = convertDateFormat(endDate);
					
					if ((dateSuccessCompare != null) 
							&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
							&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
							&& (dateSuccessCompare.after(expiredDateCompare))) {
						if (retValue.contains(item)) {
							continue;
						}
						retValue.add(item);
					}
				}
			}
		}

		return retValue;
	}
	
	public List<PmlDocumentReceiptLog> getListForTreHan_CVDen(long userId, Date date) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (userId == 0 || date == null) {
			return retValue;
		}
		
		try {
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			String departmentId = pmlUser.getDepartmentsId();
			
			List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, 0);
			
			// get list PmlDocumentReceiptLog by documentReceiptId and max transition of documentReceiptId
			List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
			PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
			
			// lay documentReceiptId va transitionMax cua documentReceiptId do
			for (PmlDocumentReceiptLog documentReceiptLog : list) {
				// get documentReceiptId from each item of list
				long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
				
				// get max transition of documentReceiptId
				int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
				try {
					// get PmlDocumentReceiptLog by documentReceiptId and transitionMax
					pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
					
					if (list1.contains(pmlDocumentReceiptLog)) {
						continue;
					}
					list1.add(pmlDocumentReceiptLog);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
			for (PmlDocumentReceiptLog item : list1) {
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess();
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date dateCompare = null;
				
				if (dateProcess != null && expiredDate != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
					if (dateSuccess != null) {
						
						
						// parse dateSuccess, expiredDate, date to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						dateCompare = convertDateFormat(date);
						
						if ((dateSuccessCompare != null)
								&& (dateSuccessCompare.before(dateCompare) || dateSuccessCompare.equals(dateCompare))
								&& (dateSuccessCompare.after(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			}
		} catch (NoSuchPmlUserException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public List<PmlEdmDocumentReceipt> getListDocumentReceiptForTreHan(long userId, Date date, long statusId) {
		
		List<PmlEdmDocumentReceipt> retValue = new ArrayList<PmlEdmDocumentReceipt>();
		
		List<PmlDocumentReceiptLog> listLog = getListDocumentReceiptLogForTreHan(userId, date, statusId);
		
		for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
			long documentReceiptId = pmlDocumentReceiptLog.getDocumentReceiptId();
			
			if (documentReceiptId != 0) {
				try {
					PmlEdmDocumentReceipt pmlEdmDocumentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
					
					if (pmlEdmDocumentReceipt != null) {
						if (retValue.contains(pmlEdmDocumentReceipt)) continue;
						retValue.add(pmlEdmDocumentReceipt);
					}
				} catch (NoSuchPmlEdmDocumentReceiptException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}
	
	public List<PmlDocumentReceiptLog> getListDocumentReceiptLogForTreHan(long userId, Date date, long statusId) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (userId == 0 || date == null || statusId == 0) {
			return retValue;
		}
		
		try {
			List<PmlStateProcess> listStateProcess1 = PmlStateProcessUtil.findByFileStatusId(statusId);
			List<PmlDocumentReceiptLog> listLog = getListForTreHan_CVDen(userId, date);
			List<PmlStateProcess> listStateProcess2 = getListStateProcessByListLog(listLog);
			
			listStateProcess2.retainAll(listStateProcess1);
			
			for (PmlStateProcess pmlStateProcess : listStateProcess2) {
				long stateProcessId = pmlStateProcess.getStateProcessId();
				
				for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
					long stateProcessIdBefore = pmlDocumentReceiptLog.getStateProcessIdBefore();
					
					if (stateProcessId == stateProcessIdBefore) {
						if (retValue.contains(pmlDocumentReceiptLog)) continue;
						retValue.add(pmlDocumentReceiptLog);
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public List<PmlStateProcess> getListStateProcessByListLog(List<PmlDocumentReceiptLog> listLog) {
		
		List<PmlStateProcess> retValue = new ArrayList<PmlStateProcess>();
		
		if (listLog == null || listLog.size() == 0) {
			return retValue;
		}
		
		for (PmlDocumentReceiptLog pmlDocumentReceiptLog : listLog) {
			long stateProcessId = pmlDocumentReceiptLog.getStateProcessIdBefore();
			
			if (stateProcessId != 0) {
				try {
					PmlStateProcess pmlStateProcess = PmlStateProcessUtil.findByPrimaryKey(stateProcessId);
					if (pmlStateProcess != null) {
						if (retValue.contains(pmlStateProcess)) continue;
						retValue.add(pmlStateProcess);
					}
				} catch (NoSuchPmlStateProcessException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}

	/**
	 * Lay ds PmlDocumentReceiptLog : resultList = getListForDangGiaiQuyet_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int dangGiaiQuyet_CVDen(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForDangGiaiQuyet_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va dateSuccess > endDate thi them PmlDocumentReceiptLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForDangGiaiQuyet_CVDen(String departmentId, long userId, int documentRecordTypeId,
						Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentReceiptLog by documentReceiptId and max transition of documentReceiptId
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			// get documentReceiptId from each item of list
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			
			// get max transition of documentReceiptId
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			
			try {
				// get PmlDocumentReceiptLog by documentReceiptId and transitionMax
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentReceiptLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dateProcess
			int numDateProcess = item.getNumDateProcess(); // get numDateProcess
			if (dateProcess != null) {
				Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
				if (dateSuccess != null) {
					Date dateSuccessCompare = null;
					Date endDateCompare = null;
					
					// parse dateSuccess, endDate to dd-MM-yyyy format
					dateSuccessCompare = convertDateFormat(dateSuccess);
					endDateCompare = convertDateFormat(endDate);
					
					if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))) {
						retValue.add(item);
					}
				}
			}
		}

		return retValue;
	}

	/**
	 * Lay ds PmlDocumentReceiptLog : resultList = getListForTrongQuyTrinh_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int trongQuyDinh_CVDen(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForTrongQuyDinh_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va dateSuccess > endDate va endDate <= expiredDate thi them PmlDocumentReceiptLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForTrongQuyDinh_CVDen(String departmentId, long userId, int documentRecordTypeId,
					Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentReceiptLog by documentReceiptId and max transition of documentReceiptId
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			// get documentReceiptId from each item of list
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			
			// get max transition of documentReceiptId
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			try {
				// get PmlDocumentReceiptLog by documentReceiptId and transitionMax
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		List<PmlDocumentReceiptLog> listNhanTrongKy = getListForNhanTrongKy_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
		
		if (listNhanTrongKy != null && listNhanTrongKy.size() > 0) {
			for (PmlDocumentReceiptLog item : list1) {
				Date dateReceive = item.getReceiveDate(); // get dateReceive
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date endDateCompare = null;
				
				if (expiredDate == null) {
					if (dateReceive != null) {
						if (dateProcess == null) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				} else { // expiredDate != null
					if (dateReceive != null) {
						if (dateProcess == null) {
							expiredDateCompare = convertDateFormat(expiredDate);
							endDateCompare = convertDateFormat(endDate);
							
							if (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare)) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						} else {
							Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
							if (dateSuccess != null) {
								// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
								dateSuccessCompare = convertDateFormat(dateSuccess);
								expiredDateCompare = convertDateFormat(expiredDate);
								endDateCompare = convertDateFormat(endDate);
								
								if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
												&& (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare))) {
									if (retValue.contains(item)) {
										continue;
									}
									retValue.add(item);
								}
							}
						}
					}
				}
			}
		}

		return retValue;
	}

	/**
	 * Lay ds PmlDocumentReceiptLog : resultList = getListForQuaQuyDinh_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int quaQuyDinh_CVDen(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForQuaQuyDinh_CVDen(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va dateSuccess > endDate va endDate > expiredDate thi them PmlDocumentReceiptLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForQuaQuyDinh_CVDen(String departmentId, long userId, int documentRecordTypeId,
					Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentReceiptLog by documentReceiptId and max transition of documentReceiptId
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			// get documentReceiptId from each item of list
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			
			// get max transition of documentReceiptId
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			try {
				// get PmlDocumentReceiptLog by documentReceiptId and transitionMax
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentReceiptLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dateProcess
			Date expiredDate = item.getExpiredDate(); // get expiredDate
			int numDateProcess = item.getNumDateProcess(); // get numDateProcess
			
			Date dateSuccessCompare = null;
			Date expiredDateCompare = null;
			Date endDateCompare = null;
			
			if (expiredDate != null) {
				if (dateProcess == null) {
					expiredDateCompare = convertDateFormat(expiredDate);
					endDateCompare = convertDateFormat(endDate);
					
					if (endDateCompare.after(expiredDateCompare)) {
						if (retValue.contains(item)) {
							continue;
						}
						retValue.add(item);
					}
				} else {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
					if (dateSuccess != null) {
						// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						endDateCompare = convertDateFormat(endDate);
						
						if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
										&& (endDateCompare.after(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			}
		}

		return retValue;
	}

	/*
	 * *********************************************************************
	 * CONG VAN DI
	 * *********************************************************************
	 */
	/**
	 * @param list
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @return
	 */
	public List<PmlDocumentSendLog> filter_CVDi(String departmentId, long userId, int documentRecordTypeId) {
		
		List<PmlDocumentSendLog> list = new ArrayList<PmlDocumentSendLog>();

		try {
			list = PmlDocumentSendLogUtil.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		List<PmlDocumentSendLog> retValue = filterByDepartmentId_CVDi(list, departmentId);
		retValue = filterByUserId_CVDi(retValue, userId);
		retValue = filterByDocumentRecordTypeId_CVDi(retValue, documentRecordTypeId);
		
		return retValue;
	}
	
	/**
	* - Lay ds User theo departmentId : listUser <br>
	* - Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>(); <br>
	* - Duyet listUser, lay userIdOfListUser <br>
	* - Duyet list, lay processer <br>
	* - Neu userIdOfListUser = processer thi them doi tuong DocumentReceiptLog vao retValue
	* 
	* @param list
	* @param departmentId
	* @return List<PmlDocumentSendLog>
	*/
	private List<PmlDocumentSendLog> filterByDepartmentId_CVDi(List<PmlDocumentSendLog> list, String departmentId) {
	
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (list == null) {
			return list;
		}
		if (departmentId != null) {
			try {
				// get list PmlUser by departmentId
				List<PmlUser> listUser = PmlUserUtil.findByDepartmentsId(departmentId);
				
				for (PmlUser pmlUser : listUser) {
					long userId = pmlUser.getUserId();
					for (PmlDocumentSendLog sendLog : list) {
						long processer = sendLog.getProcesser();
						if (processer == userId) {
							retValue.add(sendLog);
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
	
		return retValue;
	}
	
	/**
	* - Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	* - Duyet list, lay ra processer <br>
	* - Neu processer = userId thi them doi tuong PmlDocumentSendLog vao retValue
	* 
	* @param list
	* @param userId
	* @return
	*/
	private List<PmlDocumentSendLog> filterByUserId_CVDi(List<PmlDocumentSendLog> list, long userId) {
	
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (userId != 0) {
			for (PmlDocumentSendLog sendLog : list) {
				long processer = sendLog.getProcesser();
				if (processer == userId) {
					retValue.add(sendLog);
				}
			}
		}
	
		return retValue;
	}
	
	/**
	 * Neu documentRecordTypeId == 0 <br>
	 * - Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * - Tao List<PmlEdmDocumentSend> listDocumentSend = PmlEdmDocumentSendUtil.findAll() <br>
	 * - Duyet listDocumentSend, lay documentSendIdOfList <br>
	 * - Duyet list, lay listDocumentSend <br>
	 * - Neu documentSendtId == documentSendtIdOfList thi them doi tuong PmlDocumentSendLog vao retValue <br>
	 * Neu documentRecordTypeId != 0 <br>
	 * - Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * - Lay ds PmlEdmDocumentType theo documentRecordTypeId <br> 
	 *   listDocumentType = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId) <br>
	 * - Duyet listDocumentType, lay documentTypeId <br>
	 * - Tao List<PmlDocumentSend> listDocumentSend = PmlDocumentSendLogUtil.findByDocumentTypeId(documentTypeId) <br>
	 * - Duyet listDocumentSend, lay documentSendIdOfList <br>
	 * - Duyet list, lay documentSendId <br>
	 * - Neu documentSendId == documentSendIdOfList thi them doi tuong PmlDocumentSendLog vao retValue 
	 * 
	 * @param list
	 * @param documentRecordTypeId
	 * @return
	 */
	private List<PmlDocumentSendLog> filterByDocumentRecordTypeId_CVDi(List<PmlDocumentSendLog> list, int documentRecordTypeId) {
	
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (list == null) {
			return list;
		}
		
		if (documentRecordTypeId == 0) {
			try {
				// get all PmlEdmDocumentSend
				List<PmlEdmDocumentSend> listDocumentSend = PmlEdmDocumentSendUtil.findAll();
				
				if (listDocumentSend != null && listDocumentSend.size() > 0) {
					for (PmlEdmDocumentSend pmlEdmDocumentSend : listDocumentSend) {
						// get documentSendId of listDocumentSend
						long documentSendIdOfList = pmlEdmDocumentSend.getDocumentSendId();
						
						for (PmlDocumentSendLog item : list) {
							if (documentSendIdOfList == item.getDocumentSendId()) {
								retValue.add(item);
							}
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else if (documentRecordTypeId != 0) {
			try {
				// get list PmlEdmDocumentType by documentRecordTypeId
				List<PmlEdmDocumentType> listDocumentType = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId);
				
				// get list PmlEdmDocumentSend from listDocumentType
				List<PmlEdmDocumentSend> listDocumentSend = new ArrayList<PmlEdmDocumentSend>();
				List<PmlEdmDocumentSend> listDocumentSend2 = null;
				
				for (PmlEdmDocumentType pmlEdmDocumentType : listDocumentType) {
					// get documentTypeId from each item of listDocumentType
					long documentTypeId = pmlEdmDocumentType.getDocumentTypeId();
					
					listDocumentSend2 = PmlEdmDocumentSendUtil.findByDocumentTypeId(documentTypeId);
					listDocumentSend.addAll(listDocumentSend2);
				}
				
				if (listDocumentSend != null && listDocumentSend.size() > 0) {
					for (PmlEdmDocumentSend pmlEdmDocumentSend : listDocumentSend) {
						// get documentSendId from each item of listDocumentSend
						long documentSendIdOfList = pmlEdmDocumentSend.getDocumentSendId();
						
						for (PmlDocumentSendLog item : list) {
							if (documentSendIdOfList == item.getDocumentSendId()) {
								retValue.add(item);
							}
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	/**
	 * Lay ds PmlDocumentSendLog : resultList = getListForTonDauKy_CVDi(departmentId, userId, documentRecordTypeId, startDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param list
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int tonDauKy_CVDi(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForTonDauKy_CVDi(departmentId, userId, documentRecordTypeId, startDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, receiveDate <br>
	 * Neu dateProcess == null hoac dateProcess >= startDate va receiveDate < startDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForTonDauKy_CVDi(String departmentId, long userId, int documentRecordTypeId,
							Date startDate) {
	
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
		List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
		PmlDocumentSendLog pmlDocumentSendLog = null;
		
		// lay documentSendId va transitionMax cua documentSendId do
		for (PmlDocumentSendLog documentSendLog : list) {
			// get documentSendId from each item of list
			long documentSendId = documentSendLog.getDocumentSendId();
			
			// get max transition of documentSendId
			int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
			try {
				// get PmlDocumentSendLog by documentSendId and transitionMax
				pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentSendLog)) {
					continue;
				}
				list1.add(pmlDocumentSendLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentSendLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dateProcess
			Date dateReceive = item.getReceiveDate(); // get dateReceive
			if (dateProcess == null) {
				retValue.add(item);
			} else if (dateProcess != null && dateReceive != null) {
				Date dateProcessCompare = null;
				Date dateReceiveCompare = null;
				Date startDateCompare = null;
				
				// parse dateProcess, dateReceive, startDate to dd-MM-yyyy format
				dateProcessCompare = convertDateFormat(dateProcess);
				dateReceiveCompare = convertDateFormat(dateReceive);
				startDateCompare = convertDateFormat(startDate);
				
				if ((dateProcessCompare.after(startDateCompare) || dateProcessCompare.equals(startDateCompare))
								&& (dateReceiveCompare.before(startDateCompare))) {
					retValue.add(item);
				}
			}
		}

		return retValue;
	}

	/**
	 * @param documentSendId
	 * @param list
	 * @return
	 */
	private int getTransitionMaxDocumentSendLog(long documentSendId, List<PmlDocumentSendLog> list) {

		int max = 1;
		
		List<PmlDocumentSendLog> listResult = new ArrayList<PmlDocumentSendLog>();
		
		for (PmlDocumentSendLog item : list) {
			long documentSendIdOfList = item.getDocumentSendId();
			if (documentSendIdOfList == documentSendId) {
				listResult.add(item);
			}
		}
		
		max = getTransitionMax_CVDi(listResult);
		
		return max;
	}

	/**
	 * @param list
	 * @return
	 */
	private int getTransitionMax_CVDi(List<PmlDocumentSendLog> list) {

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
	 * Lay ds PmlDocumentSendLog : resultList = getListForNhanTrongKy_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param list
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int nhanTrongKy_CVDi(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForNhanTrongKy_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay receiveDate <br>
	 * Neu receiveDate >= startDate va receiveDate <= endDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForNhanTrongKy_CVDi(String departmentId, long userId, int documentRecordTypeId,
						Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
		List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
		PmlDocumentSendLog pmlDocumentSendLog = null;
		
		// lay documentSendId va transitionMax cua documentSendId do
		for (PmlDocumentSendLog documentSendLog : list) {
			// get documentSendId from each item of list
			long documentSendId = documentSendLog.getDocumentSendId();
			
			// get max transition of documentSendId
			int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
			
			try {
				// get PmlDocumentSendLog by documentSendId and transitionMax
				pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentSendLog)) {
					continue;
				}
				list1.add(pmlDocumentSendLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentSendLog item : list1) {
			Date dateReceive = item.getReceiveDate(); // get dateReceive
			if (dateReceive != null) {
				Date dateReceiveCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				// parse dateReceive, startDate, endDate to dd-MM-yyyy format
				dateReceiveCompare = convertDateFormat(dateReceive);
				startDateCompare = convertDateFormat(startDate);
				endDateCompare = convertDateFormat(endDate);
				
				if ((dateReceiveCompare.after(startDateCompare) || dateReceiveCompare.equals(startDateCompare))
								&& (dateReceiveCompare.before(endDateCompare) || dateReceiveCompare.equals(endDateCompare))) {
					retValue.add(item);
				}
			}
		}

		return retValue;
	}

	/**
	 * Lay ds PmlDocumentSendLog : resultList = getListForDaGiaiQuyet_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int daGiaiQuyet_CVDi(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForDaGiaiQuyet_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va startDate <= dateSuccess <= endDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForDaGiaiQuyet_CVDi(String departmentId, long userId, int documentRecordTypeId,
						Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
		List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
		PmlDocumentSendLog pmlDocumentSendLog = null;
		
		// lay documentSendId va transitionMax cua documentSendId do
		for (PmlDocumentSendLog documentSendLog : list) {
			// get documentSendId from each item of list
			long documentSendId = documentSendLog.getDocumentSendId();
			
			// get max transition of documentSendId
			int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
			try {
				// get PmlDocumentSendLog by documentSendId and transitionMax
				pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentSendLog)) {
					continue;
				}
				list1.add(pmlDocumentSendLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentSendLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dateProcess
			int numDateProcess = item.getNumDateProcess(); // get numDateProcess
			if (dateProcess != null) {
				Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
				if (dateSuccess != null) {
					Date dateSuccessCompare = null;
					Date startDateCompare = null;
					Date endDateCompare = null;
					
					// parse dateSuccess, startDate, endDate to dd-MM-yyyy format
					dateSuccessCompare = convertDateFormat(dateSuccess);
					startDateCompare = convertDateFormat(startDate);
					endDateCompare = convertDateFormat(endDate);
					
					if ((dateSuccessCompare != null) 
									&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
									&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
						retValue.add(item);
					}
				}
			}
		}

		return retValue;
	}

	/**
	 * Lay ds PmlDocumentSendLog : resultList = getListForDungHan_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int dungHan_CVDi(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForDungHan_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va startDate <= dateSuccess <= endDate va dateSuccess <= expiredDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForDungHan_CVDi(String departmentId, long userId, int documentRecordTypeId,
					Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
		List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
		PmlDocumentSendLog pmlDocumentSendLog = null;
		
		// lay documentSendId va transitionMax cua documentSendId do
		for (PmlDocumentSendLog documentSendLog : list) {
			// get documentSendId from each item of list
			long documentSendId = documentSendLog.getDocumentSendId();
			
			// get max transition of documentSendId
			int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
			try {
				// get PmlDocumentSendLog by documentSendId and transitionMax
				pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentSendLog)) {
					continue;
				}
				list1.add(pmlDocumentSendLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentSendLog item : list1) {
			long documentSendId = item.getDocumentSendId();
			
			// cong van di khong co cong van den
			if (hasDocumentReceipt(documentSendId) == false) {
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (expiredDate == null) {
					if (dateProcess != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
						dateSuccessCompare = convertDateFormat(dateSuccess);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);
						if ((dateSuccessCompare != null)
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								|| (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
				
				if (dateProcess != null && expiredDate != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
					if (dateSuccess != null) {
						// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);

						if ((dateSuccessCompare != null)
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
								&& (dateSuccessCompare.before(expiredDateCompare) || dateSuccessCompare.equals(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			} else {
				// neu cong van di co cong van den
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceipt
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (expiredDate == null) {
					if (dateProcess != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
						dateSuccessCompare = convertDateFormat(dateSuccess);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);
						if ((dateSuccessCompare != null)
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								|| (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
				
				if (dateProcess != null && expiredDate != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
					if (dateSuccess != null) {
						// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);

						if ((dateSuccessCompare != null)
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
								&& (dateSuccessCompare.before(expiredDateCompare) || dateSuccessCompare.equals(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			}
		}

		return retValue;
	}
	
	public List<PmlEdmDocumentSend> getListDocumentSend_DaXuLy (long userId, long statusId, int year) {
		
		List<PmlEdmDocumentSend> retValue = new ArrayList<PmlEdmDocumentSend>();
		
		if (userId == 0 || statusId == 0 || year == 0) {
			return retValue;
		}
		
		if ((new Date().getYear() + 1900) >= year) {
			if ((new Date().getYear() + 1900) > year) {
				Date startDate = new Date(year - 1900, 0, 1);
				Date endDate = new Date(year - 1900, 11, 31);
				List<PmlDocumentSendLog> listLog = getList_CVDi_DaXuLy(userId, startDate, endDate, statusId);
				for (PmlDocumentSendLog pmlDocumentSendLog : listLog) {
					long documentSendId = pmlDocumentSendLog.getDocumentSendId();
					
					try {
						PmlEdmDocumentSend documentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
						
						if (documentSend != null) {
							if (retValue.contains(documentSend)) continue;
							retValue.add(documentSend);
						}
					} catch (NoSuchPmlEdmDocumentSendException e) {
						e.printStackTrace();
					} catch (SystemException e) {
						e.printStackTrace();
					}
				}
			}
			List<PmlDocumentSendLog> listLog = getList_CVDi_DaXuLy(userId, new Date(), statusId);
			for (PmlDocumentSendLog pmlDocumentSendLog : listLog) {
				long documentSendId = pmlDocumentSendLog.getDocumentSendId();
				
				try {
					PmlEdmDocumentSend documentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
					
					if (documentSend != null) {
						if (retValue.contains(documentSend)) continue;
						retValue.add(documentSend);
					}
				} catch (NoSuchPmlEdmDocumentSendException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}
	
	private List<PmlDocumentSendLog> getList_CVDi_DaXuLy(long userId, Date startDate, Date endDate, long statusId) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (userId == 0 || startDate == null || endDate == null || statusId == 0) {
			return retValue;
		}
		
		try {
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			String departmentId = pmlUser.getDepartmentsId();
			
			// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
			List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, 0);
			
			// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
			List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
			PmlDocumentSendLog pmlDocumentSendLog = null;
			
			// lay documentSendId va transitionMax cua documentSendId do
			for (PmlDocumentSendLog documentSendLog : list) {
				// get documentSendId from each item of list
				long documentSendId = documentSendLog.getDocumentSendId();
				
				// get max transition of documentSendId
				int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
				try {
					// get PmlDocumentSendLog by documentSendId and transitionMax
					pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
					
					if (list1.contains(pmlDocumentSendLog)) {
						continue;
					}
					list1.add(pmlDocumentSendLog);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
			for (PmlDocumentSendLog item : list1) {
				Date dateProcess = item.getDateProcess(); // get dateProcess
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				if (dateProcess != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
					if (dateSuccess != null) {
						Date dateSuccessCompare = null;
						Date startDateCompare = null;
						Date endDateCompare = null;
						
						// parse dateSuccess, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);
						
						if ((dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
										&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
							retValue.add(item);
						}
					}
				}
			}
		} catch (NoSuchPmlUserException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}

		return retValue;
	}

	private List<PmlDocumentSendLog> getList_CVDi_DaXuLy(long userId, Date date, long statusId) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		List<PmlDocumentSendLog> listLog = getListLog_CVDi_DaXuLy(userId, date);
		try {
			List<PmlStateProcess> listStateProcess1 = PmlStateProcessUtil.findByFileStatusId(statusId);
			List<PmlStateProcess> listStateProcess2 = getListStateProcessByListLogSend(listLog);
			
			listStateProcess2.retainAll(listStateProcess1);
			
			for (PmlStateProcess pmlStateProcess : listStateProcess2) {
				long stateProcessId = pmlStateProcess.getStateProcessId();
				
				for (PmlDocumentSendLog pmlDocumentSendLog : listLog) {
					long stateProcessIdBefore = pmlDocumentSendLog.getStateProcessIdBefore();
					
					if (stateProcessId == stateProcessIdBefore) {
						if (retValue.contains(pmlDocumentSendLog)) continue;
						retValue.add(pmlDocumentSendLog);
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	public List<PmlEdmDocumentSend> getListDocumentSend_DaXuLy_TreHan (long userId, Date date, long statusId) {
		
		List<PmlEdmDocumentSend> retValue = new ArrayList<PmlEdmDocumentSend>();
		
		if (userId == 0 || date == null || statusId == 0) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> listLog = getList_CVDi_DaXuLy_TreHan(userId, date, statusId);
		for (PmlDocumentSendLog pmlDocumentSendLog : listLog) {
			long documentSendId = pmlDocumentSendLog.getDocumentSendId();
			
			try {
				PmlEdmDocumentSend documentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
				
				if (documentSend != null) {
					if (retValue.contains(documentSend)) continue;
					retValue.add(documentSend);
				}
			} catch (NoSuchPmlEdmDocumentSendException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}

	private List<PmlDocumentSendLog> getList_CVDi_DaXuLy_TreHan(long userId, Date date, long statusId) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		List<PmlDocumentSendLog> listLog = getListLog_CVDi_DaXuLy_TreHan(userId, date);
		try {
			List<PmlStateProcess> listStateProcess1 = PmlStateProcessUtil.findByFileStatusId(statusId);
			List<PmlStateProcess> listStateProcess2 = getListStateProcessByListLogSend(listLog);
			
			listStateProcess2.retainAll(listStateProcess1);
			
			for (PmlStateProcess pmlStateProcess : listStateProcess2) {
				long stateProcessId = pmlStateProcess.getStateProcessId();
				
				for (PmlDocumentSendLog pmlDocumentSendLog : listLog) {
					long stateProcessIdBefore = pmlDocumentSendLog.getStateProcessIdBefore();
					
					if (stateProcessId == stateProcessIdBefore) {
						if (retValue.contains(pmlDocumentSendLog)) continue;
						retValue.add(pmlDocumentSendLog);
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	private List<PmlDocumentSendLog> getListLog_CVDi_DaXuLy_TreHan(long userId,	Date date) {
		
		List<PmlDocumentSendLog> retValue = getListLog_CVDi_DaXuLy(userId, date);
		
		List<PmlDocumentSendLog> listLogTreHan = getListForTreHan_CVDi(userId, date);
		retValue.retainAll(listLogTreHan);
		
		return retValue;
	}

	private List<PmlDocumentSendLog> getListLog_CVDi_DaXuLy(long userId, Date date) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		try {
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			
			String departmentId = pmlUser.getDepartmentsId();
			
			List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, 0);
			
			// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
			List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
			PmlDocumentSendLog pmlDocumentSendLog = null;
			
			// lay documentSendId va transitionMax cua documentSendId do
			for (PmlDocumentSendLog documentSendLog : list) {
				// get documentSendId from each item of list
				long documentSendId = documentSendLog.getDocumentSendId();
				
				// get max transition of documentSendId
				int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
				try {
					// get PmlDocumentSendLog by documentSendId and transitionMax
					pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
					
					if (list1.contains(pmlDocumentSendLog)) {
						continue;
					}
					list1.add(pmlDocumentSendLog);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
			for (PmlDocumentSendLog item : list1) {
				Date dateProcess = item.getDateProcess(); // get dateProcess
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				if (dateProcess != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
					if (dateSuccess != null) {
						Date dateSuccessCompare = null;
						Date dateCompare = null;
						
						// parse dateSuccess, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						dateCompare = convertDateFormat(date);
						
						if ((dateSuccessCompare.before(dateCompare) || dateSuccessCompare.equals(dateCompare))) {
							retValue.add(item);
						}
					}
				}
			}
		} catch (NoSuchPmlUserException e1) {
			e1.printStackTrace();
		} catch (SystemException e1) {
			e1.printStackTrace();
		}
		

		return retValue;
	}

	/**
	 * Lay ds PmlDocumentSendLog : resultList = getListForTreHan_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int treHan_CVDi(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForTreHan_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentSendId va transitionMax cua documentSendId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va startDate <= dateSuccess <= endDate va dateSuccess > expiredDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForTreHan_CVDi(String departmentId, long userId, int documentRecordTypeId,
						Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
		List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
		PmlDocumentSendLog pmlDocumentSendLog = null;
		
		// lay documentSendId va transitionMax cua documentSendId do
		for (PmlDocumentSendLog documentSendLog : list) {
			// get documentSendId from each item of list
			long documentSendId = documentSendLog.getDocumentSendId();
			
			// get max transition of documentSendId
			int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
			
			try {
				// get PmlDocumentSendLog by documentSendId and transitionMax
				pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentSendLog)) {
					continue;
				}
				list1.add(pmlDocumentSendLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentSendLog item : list1) {
			long documentSendId = item.getDocumentSendId();
			
			// cong van di khong co cong van den
			if (hasDocumentReceipt(documentSendId) == false) {
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess();
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (dateProcess != null && expiredDate != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
					if (dateSuccess != null) {
						// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);
						
						if ((dateSuccessCompare != null) 
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
								&& (dateSuccessCompare.after(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			} else {
				// cong van di co cong van den
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceiptLog
				int numDateProcess = item.getNumDateProcess();
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (dateProcess != null && expiredDate != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
					if (dateSuccess != null) {
						// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);
						
						if ((dateSuccessCompare != null) 
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
								&& (dateSuccessCompare.after(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			}
			
		}

		return retValue;
	}
	
	public List<PmlDocumentSendLog> getListForTreHan_CVDi (long userId, Date date) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (userId == 0 || date == null) {
			return retValue;
		}
		
		try {
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			String departmentId = pmlUser.getDepartmentsId();
			
			List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, 0);
			
			// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
			List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
			PmlDocumentSendLog pmlDocumentSendLog = null;
			
			// lay documentSendId va transitionMax cua documentSendId do
			for (PmlDocumentSendLog documentSendLog : list) {
				// get documentSendId from each item of list
				long documentSendId = documentSendLog.getDocumentSendId();
				
				// get max transition of documentSendId
				int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
				
				try {
					// get PmlDocumentSendLog by documentSendId and transitionMax
					pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
					
					if (list1.contains(pmlDocumentSendLog)) {
						continue;
					}
					list1.add(pmlDocumentSendLog);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
			
			for (PmlDocumentSendLog item : list1) {
				long documentSendId = item.getDocumentSendId();
				
				// cong van di khong co cong van den
				if (hasDocumentReceipt(documentSendId) == false) {
					Date dateProcess = item.getDateProcess(); // get dateProcess
					Date expiredDate = item.getExpiredDate(); // get expiredDate
					int numDateProcess = item.getNumDateProcess();
					
					Date dateSuccessCompare = null;
					Date expiredDateCompare = null;
					Date dateCompare = null;
					
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							dateCompare = convertDateFormat(date);
							
							if ((dateSuccessCompare != null)
									&& (dateSuccessCompare.before(dateCompare) || dateSuccessCompare.equals(dateCompare))
									&& (dateSuccessCompare.after(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				} else {
					// cong van di co cong van den
					Date dateProcess = item.getDateProcess(); // get dateProcess
					Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceiptLog
					int numDateProcess = item.getNumDateProcess();
					
					Date dateSuccessCompare = null;
					Date expiredDateCompare = null;
					Date dateCompare = null;
					
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							dateCompare = convertDateFormat(date);
							
							if ((dateSuccessCompare != null)
									&& (dateSuccessCompare.before(dateCompare) || dateSuccessCompare.equals(dateCompare))
									&& (dateSuccessCompare.after(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
				
			}
		} catch (NoSuchPmlUserException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public List<PmlDocumentSendLog> getListForTreHan_CVDi (long userId, Date date, long statusId) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (userId == 0 || date == null || statusId == 0) {
			return retValue;
		}
		
		try {
			List<PmlStateProcess> listStateProcess1 = PmlStateProcessUtil.findByFileStatusId(statusId);
			List<PmlDocumentSendLog> listLog = getListForTreHan_CVDi(userId, date);
			List<PmlStateProcess> listStateProcess2 = getListStateProcessByListLogSend(listLog);
			
			listStateProcess2.retainAll(listStateProcess1);
			
			for (PmlStateProcess pmlStateProcess : listStateProcess2) {
				long stateProcessId = pmlStateProcess.getStateProcessId();
				
				for (PmlDocumentSendLog pmlDocumentSendLog : listLog) {
					long stateProcessIdBefore = pmlDocumentSendLog.getStateProcessIdBefore();
					
					if (stateProcessId == stateProcessIdBefore) {
						if (retValue.contains(pmlDocumentSendLog)) continue;
						retValue.add(pmlDocumentSendLog);
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	private List<PmlStateProcess> getListStateProcessByListLogSend(List<PmlDocumentSendLog> listLog) {
		
		List<PmlStateProcess> retValue = new ArrayList<PmlStateProcess>();
		
		if (listLog == null || listLog.size() == 0) {
			return retValue;
		}
		
		for (PmlDocumentSendLog pmlDocumentSendLog : listLog) {
			long stateProcessIdBefore = pmlDocumentSendLog.getStateProcessIdBefore();
			
			if (stateProcessIdBefore != 0) {
				try {
					PmlStateProcess pmlStateProcess = PmlStateProcessUtil.findByPrimaryKey(stateProcessIdBefore);
					
					if (pmlStateProcess != null) {
						if (retValue.contains(pmlStateProcess)) continue;
						retValue.add(pmlStateProcess);
					}
				} catch (NoSuchPmlStateProcessException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}

	public List<PmlEdmDocumentSend> getListDocumentSendForTreHan(long userId, Date date, long statusId) {
		
		List<PmlEdmDocumentSend> retValue = new ArrayList<PmlEdmDocumentSend>();
		
		if (userId == 0 || date == null || statusId == 0) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> listLog = getListForTreHan_CVDi(userId, date, statusId);
		for (PmlDocumentSendLog pmlDocumentSendLog : listLog) {
			long documentSendId = pmlDocumentSendLog.getDocumentSendId();
			
			try {
				PmlEdmDocumentSend documentSend = PmlEdmDocumentSendUtil.findByPrimaryKey(documentSendId);
				
				if (documentSend != null) {
					if (retValue.contains(documentSend)) continue;
					retValue.add(documentSend);
				}
			} catch (NoSuchPmlEdmDocumentSendException e) {
				e.printStackTrace();
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}

	/**
	 * Lay ds PmlDocumentSendLog : resultList = getListForDangGiaiQuyet_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int dangGiaiQuyet_CVDi(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForDangGiaiQuyet_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va dateSuccess > endDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForDangGiaiQuyet_CVDi(String departmentId, long userId, int documentRecordTypeId,
						Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
		List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
		PmlDocumentSendLog pmlDocumentSendLog = null;
		
		// lay documentSendId va transitionMax cua documentSendId do
		for (PmlDocumentSendLog documentSendLog : list) {
			// get documentSendId from each item of list
			long documentSendId = documentSendLog.getDocumentSendId();
			
			// get max transition of documentSendId
			int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
			try {
				// get PmlDocumentSendLog by documentSendId and transitionMax
				pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentSendLog)) {
					continue;
				}
				list1.add(pmlDocumentSendLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentSendLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dateProcess
			int numDateProcess = item.getNumDateProcess(); // get numDateProcess
			if (dateProcess != null) {
				Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
				if (dateSuccess != null) {
					Date dateSuccessCompare = null;
					Date endDateCompare = null;
					
					// parse dateSuccess, endDate to dd-MM-yyyy format
					dateSuccessCompare = convertDateFormat(dateSuccess);
					endDateCompare = convertDateFormat(endDate);
					
					if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))) {
						retValue.add(item);
					}
				}
			}
		}

		return retValue;
	}

	/**
	 * Lay ds PmlDocumentSendLog : resultList = getListForTrongQuyDinh_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int trongQuyDinh_CVDi(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForTrongQuyDinh_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va dateSuccess > endDate va endDate <= expiredDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForTrongQuyDinh_CVDi(String departmentId, long userId, int documentRecordTypeId,
					Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
		List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
		PmlDocumentSendLog pmlDocumentSendLog = null;
		
		// lay documentSendId va transitionMax cua documentSendId do
		for (PmlDocumentSendLog documentSendLog : list) {
			// get documentSendId from each item of list
			long documentSendId = documentSendLog.getDocumentSendId();
			
			// get max transition of documentSendId
			int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
			
			try {
				// get PmlDocumentSendLog by documentSendId and transitionMax
				pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentSendLog)) {
					continue;
				}
				list1.add(pmlDocumentSendLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		List<PmlDocumentSendLog> listNhanTrongKy = getListForNhanTrongKy_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		
		if (listNhanTrongKy != null && listNhanTrongKy.size() > 0) {
			for (PmlDocumentSendLog item : list1) {
				long documentSendId = item.getDocumentSendId();
				
				// cong van di khong co cong van den
				if (hasDocumentReceipt(documentSendId) == false) {
					Date dateReceive = item.getReceiveDate();
					Date dateProcess = item.getDateProcess(); // get dateProcess
					Date expiredDate = item.getExpiredDate(); // get expiredDate
					int numDateProcess = item.getNumDateProcess(); // get numDateProcess
					
					Date dateSuccessCompare = null;
					Date expiredDateCompare = null;
					Date endDateCompare = null;
					
					if (expiredDate == null) {
						if (dateReceive != null) {
							if (dateProcess == null) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					} else {
						if (dateReceive != null && dateProcess != null) {
							Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
							if (dateSuccess != null) {
								// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
								dateSuccessCompare = convertDateFormat(dateSuccess);
								expiredDateCompare = convertDateFormat(expiredDate);
								endDateCompare = convertDateFormat(endDate);
								
								if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
												&& (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare))) {
									if (retValue.contains(item)) {
										continue;
									}
									retValue.add(item);
								}
							}
						}
					}
					
				} else {
					// cong van di co cong van den
					Date dateReceive = item.getReceiveDate();
					Date dateProcess = item.getDateProcess(); // get dateProcess
					Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceiptLog
					int numDateProcess = item.getNumDateProcess(); // get numDateProcess
					
					Date dateSuccessCompare = null;
					Date expiredDateCompare = null;
					Date endDateCompare = null;
					
					if (expiredDate == null) {
						if (dateReceive != null) {
							if (dateProcess == null) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					} else { // expiredDate != null
						if (dateReceive != null) {
							if (dateProcess == null) {
								expiredDateCompare = convertDateFormat(expiredDate);
								endDateCompare = convertDateFormat(endDate);
								
								if (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare)) {
									if (retValue.contains(item)) {
										continue;
									}
									retValue.add(item);
								}
							} else {
								Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
								if (dateSuccess != null) {
									// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
									dateSuccessCompare = convertDateFormat(dateSuccess);
									expiredDateCompare = convertDateFormat(expiredDate);
									endDateCompare = convertDateFormat(endDate);
									
									if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
													&& (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare))) {
										if (retValue.contains(item)) {
											continue;
										}
										retValue.add(item);
									}
								}
							}
						}
					}
				}
			}
		}

		return retValue;
	}

	/**
	 * Lay ds PmlDocumentSendLog : resultList = getListForQuaQuyDinh_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate) <br>
	 * Ket qua tra ve la resultList.size()
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public int quaQuyDinh_CVDi(String departmentId, long userId, 
						int documentRecordTypeId, Date startDate, Date endDate) {
		
		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForQuaQuyDinh_CVDi(departmentId, userId, documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();
		
		return retValue;
	}
	
	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi(departmentId, userId, documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va dateSuccess > endDate va endDate > expiredDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param departmentId
	 * @param userId
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForQuaQuyDinh_CVDi(String departmentId, long userId, int documentRecordTypeId,
					Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by departmentId, userId, documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi(departmentId, userId, documentRecordTypeId);
		
		// get list PmlDocumentSendLog by documentSendId and max transition of documentSendId
		List<PmlDocumentSendLog> list1 = new ArrayList<PmlDocumentSendLog>();
		PmlDocumentSendLog pmlDocumentSendLog = null;
		
		// lay documentSendId va transitionMax cua documentSendId do
		for (PmlDocumentSendLog documentSendLog : list) {
			// get documentSendId from each item of list
			long documentSendId = documentSendLog.getDocumentSendId();
			
			// get max transition of documentSendId
			int transitionMax = getTransitionMaxDocumentSendLog(documentSendId, list);
			
			try {
				// get PmlDocumentSendLog by documentSendId and transitionMax
				pmlDocumentSendLog = PmlDocumentSendLogUtil.findByDocumentSendId_Transition(documentSendId, transitionMax).get(0);
				if (list1.contains(pmlDocumentSendLog)) {
					continue;
				}
				list1.add(pmlDocumentSendLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentSendLog item : list1) {
			long documentSendId = item.getDocumentSendId();
			
			// cong van di khong co cong van den
			if (hasDocumentReceipt(documentSendId) == false) {
				Date dateReceive = item.getReceiveDate();
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date endDateCompare = null;
				
				if (expiredDate != null && dateReceive != null) {
					if (dateProcess == null) {
						expiredDateCompare = convertDateFormat(expiredDate);
						endDateCompare = convertDateFormat(endDate);
						
						if (endDateCompare.after(expiredDateCompare)) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					} else {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							endDateCompare = convertDateFormat(endDate);
							
							if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
											&& (endDateCompare.after(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			} else {
				// cong van di co cong van den
				Date dateReceive = item.getReceiveDate();
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceiptLog
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date endDateCompare = null;
				
				if (expiredDate != null && dateReceive != null) {
					if (dateProcess == null) {
						expiredDateCompare = convertDateFormat(expiredDate);
						endDateCompare = convertDateFormat(endDate);
						
						if (endDateCompare.after(expiredDateCompare)) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					} else {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							endDateCompare = convertDateFormat(endDate);
							
							if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
											&& (endDateCompare.after(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			}
		}

		return retValue;
	}
	
	/*
	 * *********************************************************
	 * 				CONG VAN DEN TOAN CO QUAN
	 * *********************************************************
	 */
	public List<PmlDocumentReceiptLog> filter_CVDen_ToanCoQuan(int documentRecordTypeId) {
		
		List<PmlDocumentReceiptLog> list = new ArrayList<PmlDocumentReceiptLog>();

		try {
			// get all PmlDocumentReceiptLog
			list = PmlDocumentReceiptLogUtil.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		List<PmlDocumentReceiptLog> retValue = filter_CVDen_ToanCoQuan(list, documentRecordTypeId);
		List<PmlDocumentReceiptLog> list2 = filterByDepartmentFromList(list);
		retValue.retainAll(list2);
		
		return retValue;
	}

	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>()
	 * Lay ds tat ca cac Phong ban : list1 = PmlDepartmentUtil.findAll()
	 * Lay ds Phong ban tu list : list2 = getListDepartment(list)
	 * Duyet list
	 * - Lay ra tung departmentId cua list2 va list1 : department2, department1
	 * - Neu department2 == department1 thi them doi tuong PmlDocumentReceiptLog vao retValue
	 * 
	 * @param list
	 * @return
	 */
	private List<PmlDocumentReceiptLog> filterByDepartmentFromList(List<PmlDocumentReceiptLog> list) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (list == null) {
			return retValue;
		}
		
		try {
			List<Department> list1 = DepartmentUtil.findAll();
			List<Department> list2 = getListDepartment(list);
			
			if (list1 != null && list2 != null) {
				for (PmlDocumentReceiptLog pmlDocumentReceiptLog : list) {
					for (Department pmlDepartment : list1) {
						for (Department pmlDepartment2 : list2) {
							String departmentId1 = pmlDepartment.getDepartmentsId();
							String departmentId2 = pmlDepartment2.getDepartmentsId();
							
							if (departmentId1 != null && departmentId2 != null) {
								if (departmentId1.equalsIgnoreCase(departmentId2)) {
									retValue.add(pmlDocumentReceiptLog);
								}
							}
						}
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	private List<Department> getListDepartment(List<PmlDocumentReceiptLog> list) {
		
		List<Department> retValue = new ArrayList<Department>();
		
		if (list == null) {
			return retValue;
		}
		
		List<PmlUser> listUser = new ArrayList<PmlUser>();
		
		for (PmlDocumentReceiptLog pmlDocumentReceiptLog : list) {
			long processer = pmlDocumentReceiptLog.getProcesser();
			
			if (processer != 0) {
				try {
					PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(processer);
					
					if (pmlUser != null) {
						if (listUser.contains(pmlUser)) {
							continue;
						}
						listUser.add(pmlUser);
					}
				} catch (NoSuchPmlUserException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		retValue = getListDepartmentByListUser(listUser);
		
		return retValue;
	}

	private List<Department> getListDepartmentByListUser(List<PmlUser> listUser) {
		
		List<Department> retValue = new ArrayList<Department>();
		
		if (listUser == null) {
			return retValue;
		}
		
		for (PmlUser pmlUser : listUser) {
			String departmentId = pmlUser.getDepartmentsId();
			
			if (departmentId != null) {
				try {
					Department pmlDepartment = DepartmentUtil.findByPrimaryKey(departmentId);
					
					if (pmlDepartment != null) {
						if (retValue.contains(pmlDepartment)) {
							continue;
						}
						retValue.add(pmlDepartment);
					}
				} catch (NoSuchDepartmentException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}

	private List<PmlDocumentReceiptLog> filter_CVDen_ToanCoQuan(List<PmlDocumentReceiptLog> list, int documentRecordTypeId) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (list == null) {
			return retValue;
		}
		
		if (documentRecordTypeId == 0) {
			try {
				// get all PmlEdmDocumentReceipt
				List<PmlEdmDocumentReceipt> listDocumentReceipt = PmlEdmDocumentReceiptUtil.findAll();
				
				if (listDocumentReceipt != null && listDocumentReceipt.size() > 0) {
					for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : listDocumentReceipt) {
						// get documentReceiptId from listDocumentReceipt
						long documentReceiptId = pmlEdmDocumentReceipt.getDocumentReceiptId();
						
						for (PmlDocumentReceiptLog item : list) {
							if (documentReceiptId == item.getDocumentReceiptId()) {
								retValue.add(item);
							}
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else if (documentRecordTypeId != 0) {
			try {
				// get list PmlEdmDocumentType by documentRecordTypeId
				List<PmlEdmDocumentType> listDocumentType = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId);
				
				// get list PmlEdmDocumentReciept from listDocumentType
				List<PmlEdmDocumentReceipt> listDocumentReceipt = new ArrayList<PmlEdmDocumentReceipt>();
				List<PmlEdmDocumentReceipt> listDocumentReceipt2 = null;
				
				for (PmlEdmDocumentType pmlEdmDocumentType : listDocumentType) {
					// get documentTypeId from listDocumentType
					long documentTypeId = pmlEdmDocumentType.getDocumentTypeId();
					
					// get list PmlEdmDocumentReceipt by documentTypeId
					listDocumentReceipt2 = PmlEdmDocumentReceiptUtil.findByDocumentTypeId(documentTypeId);
					
					listDocumentReceipt.addAll(listDocumentReceipt2);
				}
				
				if (listDocumentReceipt != null && listDocumentReceipt.size() > 0) {
					for (PmlEdmDocumentReceipt pmlEdmDocumentReceipt : listDocumentReceipt) {
						// get documentReceiptId from listDocumentReceipt
						long documentReceiptId = pmlEdmDocumentReceipt.getDocumentReceiptId();
						
						for (PmlDocumentReceiptLog item : list) {
							if (documentReceiptId == item.getDocumentReceiptId()) {
								retValue.add(item);
							}
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	public int tonDauKy_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentReceiptLog> resultList = getListForTonDauKy_CVDen_ToanCoQuan(documentRecordTypeId, startDate);
		retValue = resultList.size();
		
		return retValue;
	}

	public List<PmlDocumentReceiptLog> getListForTonDauKy_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen_ToanCoQuan(documentRecordTypeId);
		
		// get list PmlDocumentReceiptLog by documentReceiptId and max transition of documentReceiptId
		List<PmlDocumentReceiptLog> list1 = new ArrayList<PmlDocumentReceiptLog>();
		PmlDocumentReceiptLog pmlDocumentReceiptLog = null;
		
		// lay documentReceiptId va transitionMax cua documentReceiptId do
		for (PmlDocumentReceiptLog documentReceiptLog : list) {
			// get documentReceiptId from each item of list
			long documentReceiptId = documentReceiptLog.getDocumentReceiptId();
			
			// get max transition of each documentReceipt
			int transitionMax = getTransitionMaxOfDocumentReceiptLog(documentReceiptId, list);
			try {
				// get PmlDocumentReceiptLog by documentReceiptId and transitionMax
				pmlDocumentReceiptLog = PmlDocumentReceiptLogUtil.findByDocumentReceiptId_Transition(documentReceiptId, transitionMax).get(0);
				
				if (list1.contains(pmlDocumentReceiptLog)) {
					continue;
				}
				list1.add(pmlDocumentReceiptLog);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		for (PmlDocumentReceiptLog item : list1) {
			Date dateProcess = item.getDateProcess(); // get dataProcess
			Date dateReceive = item.getReceiveDate(); // get dateReceive
			if (dateProcess == null) {
				retValue.add(item);
			} else if (dateProcess != null && dateReceive != null) {
				Date dateProcessCompare = null;
				Date dateReceiveCompare = null;
				Date startDateCompare = null;
				
				// parse dateProcess, dateReceive, startDate by dd-MM-yyyy
				dateProcessCompare = convertDateFormat(dateProcess);
				dateReceiveCompare = convertDateFormat(dateReceive);
				startDateCompare = convertDateFormat(startDate);
				
				// if dateProcess >= startDate and dateReceive = startDate, add PmlDocumentReceiptLog object from list1 into retValue
				if ((dateProcessCompare.after(startDateCompare) || dateProcessCompare.equals(startDateCompare))
								&& (dateReceiveCompare.before(startDateCompare))) {
					retValue.add(item);
				}
			}
		}
		
		return retValue;
	}
	
	public int nhanTrongKy_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentReceiptLog> resultList = getListForNhanTrongKy_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}
	
	/**
	* Tao List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>() <br>
	* Lay ds PmlDocumentReceiptLog bang filter : list = filter_CVDen_ToanCoQuan(documentRecordTypeId) <br>
	* Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua documentReceiptId do : list1 <br>
	* Duyet list1, lay receiveDate <br>
	* Neu receiveDate >= startDate va receiveDate <= endDate thi them PmlDocumentReceiptLog vao retValue
	* 
	* @param documentRecordTypeId
	* @param startDate
	* @param endDate
	* @return
	*/
	public List<PmlDocumentReceiptLog> getListForNhanTrongKy_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentReceiptLog> list = filter_CVDen_ToanCoQuan(documentRecordTypeId);

		for (PmlDocumentReceiptLog item : list) {
			Date dateReceive = item.getReceiveDate();
			if (dateReceive != null) {
				Date dateReceiveCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;

				dateReceiveCompare = convertDateFormat(dateReceive);
				startDateCompare = convertDateFormat(startDate);
				endDateCompare = convertDateFormat(endDate);

				if ((dateReceiveCompare.after(startDateCompare) || dateReceiveCompare.equals(startDateCompare))
						&& (dateReceiveCompare.before(endDateCompare) || dateReceiveCompare.equals(endDateCompare))) {
					if (retValue.contains(item)) {
						continue;
					}
					retValue.add(item);
				}
			}
		}

		return retValue;
	}
	
	public int dungHan_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentReceiptLog> resultList = getListForDungHan_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}

	/**
	 * Tao List<PmlDocumentReceiptLog> retValue = new
	 * ArrayList<PmlDocumentReceiptLog>() <br>
	 * Lay ds PmlDocumentReceiptLog bang filter : list =
	 * filter_CVDen(documentRecordTypeId) <br>
	 * Lay ds PmlDocumentReceiptLog theo documentReceiptId va transitionMax cua
	 * documentReceiptId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan
	 * thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va startDate <= dateSuccess <= endDate va
	 * dateSuccess <= expiredDate thi them PmlDocumentReceiptLog vao retValue <br>
	 * 
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentReceiptLog> getListForDungHan_CVDen_ToanCoQuan(int documentRecordTypeId,	Date startDate, Date endDate) {

		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();

		if (startDate == null || endDate == null) {
			return retValue;
		}

		// get list PmlDocumentReceiptLog by documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen_ToanCoQuan(documentRecordTypeId);

		for (PmlDocumentReceiptLog item : list) {
			long documentReceiptId = item.getDocumentReceiptId();
			Date dateProcess = item.getDateProcess(); // get dateProcess
			Date expiredDate = item.getExpiredDate(); // get expiredDate
			int numDateProcess = item.getNumDateProcess(); // get numDateProcess
			
			if (checkDocumentReceiptFinish(documentReceiptId) == true) {
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (expiredDate == null) {
					if (dateProcess != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
						dateSuccessCompare = convertDateFormat(dateSuccess);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);
						if ((dateSuccessCompare != null)
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
				
				if (dateProcess != null && expiredDate != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
					if (dateSuccess != null) {
						// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);

						if ((dateSuccessCompare != null)
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
								&& (dateSuccessCompare.before(expiredDateCompare) || dateSuccessCompare.equals(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			}
		}

		return retValue;
	}
	
	/**
	 * Kiem tra cong van den da ket thuc quy trinh chinh hay chua
	 * false : chua ket thuc
	 * true : da ket thuc
	 * @param documentReceiptId
	 * @return
	 */
	public boolean checkDocumentReceiptFinish(long documentReceiptId) {
		
		boolean retValue = false;
		
		if (documentReceiptId == 0) {
			return retValue;
		}
		
		try {
			List<PmlDocumentReceiptWF> listDocumentReceiptWF = PmlDocumentReceiptWFUtil.findByDocumentReceiptIdIsMain(documentReceiptId, "1");
			if (listDocumentReceiptWF != null && listDocumentReceiptWF.size() > 0) {
				PmlDocumentReceiptWF documentReceiptWF = listDocumentReceiptWF.get(0);
				
				if (documentReceiptWF != null) {
					long processId = documentReceiptWF.getProcessId();
					DocumentReceiptLiferayWorkflowService documentReceiptLiferayWorkflowService = new DocumentReceiptLiferayWorkflowService();
					if (documentReceiptLiferayWorkflowService.getJbpmService() != null) {
						if (documentReceiptLiferayWorkflowService.getJbpmService().getProcessInstance(processId) != null) {
							if (documentReceiptLiferayWorkflowService.getJbpmService().getProcessInstance(processId).getEnd() != null) {
								retValue = true;
							}
						}
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public int treHan_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentReceiptLog> resultList = getListForTreHan_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}

	public List<PmlDocumentReceiptLog> getListForTreHan_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen_ToanCoQuan(documentRecordTypeId);
		
		for (PmlDocumentReceiptLog item : list) {
			long documentReceiptId = item.getDocumentReceiptId();
			Date dateProcess = item.getDateProcess(); // get dateProcess
			Date expiredDate = item.getExpiredDate(); // get expiredDate
			int numDateProcess = item.getNumDateProcess();
			
			Date dateSuccessCompare = null;
			Date expiredDateCompare = null;
			Date startDateCompare = null;
			Date endDateCompare = null;
			
			if (checkDocumentReceiptFinish(documentReceiptId) == true) {
				if (dateProcess != null && expiredDate != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
					if (dateSuccess != null) {
						
						
						// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						startDateCompare = convertDateFormat(startDate);
						endDateCompare = convertDateFormat(endDate);
						
						if ((dateSuccessCompare != null) 
								&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
								&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
								&& (dateSuccessCompare.after(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			}
		}

		return retValue;
	}
	
	public int trongQuyDinh_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentReceiptLog> resultList = getListForTrongQuyDinh_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}

	public List<PmlDocumentReceiptLog> getListForTrongQuyDinh_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen_ToanCoQuan(documentRecordTypeId);
		List<PmlDocumentReceiptLog> listNhanTrongKy = getListForNhanTrongKy_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		
		if (listNhanTrongKy != null && listNhanTrongKy.size() > 0) {
			for (PmlDocumentReceiptLog item : list) {
				long documentReceiptId = item.getDocumentReceiptId();
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date endDateCompare = null;
				
				if (checkDocumentReceiptFinish(documentReceiptId) == false) {
					if (expiredDate == null) {
						if (dateProcess == null) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						} else {
							Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
							if (dateSuccess != null) {
								// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
								dateSuccessCompare = convertDateFormat(dateSuccess);
								endDateCompare = convertDateFormat(endDate);
								
								if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))) {
									if (retValue.contains(item)) {
										continue;
									}
									retValue.add(item);
								}
							}
						}
					}
					
					if (dateProcess == null && expiredDate != null) {
						expiredDateCompare = convertDateFormat(expiredDate);
						endDateCompare = convertDateFormat(endDate);
						
						if (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare)) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
					
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							endDateCompare = convertDateFormat(endDate);
							
							if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
											&& (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			}
		}

		return retValue;
	}
	
	public int quaQuyDinh_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentReceiptLog> resultList = getListForQuaQuyDinh_CVDen_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}

	public List<PmlDocumentReceiptLog> getListForQuaQuyDinh_CVDen_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		List<PmlDocumentReceiptLog> retValue = new ArrayList<PmlDocumentReceiptLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentReceiptLog by documentRecordTypeId
		List<PmlDocumentReceiptLog> list = filter_CVDen_ToanCoQuan(documentRecordTypeId);
		
		for (PmlDocumentReceiptLog item : list) {
			long documentReceiptId = item.getDocumentReceiptId();
			Date dateProcess = item.getDateProcess(); // get dateProcess
			Date expiredDate = item.getExpiredDate(); // get expiredDate
			int numDateProcess = item.getNumDateProcess(); // get numDateProcess
			
			Date dateSuccessCompare = null;
			Date expiredDateCompare = null;
			Date endDateCompare = null;
			
			if (checkDocumentReceiptFinish(documentReceiptId) == false) {
				if (dateProcess == null && expiredDate != null) {
					expiredDateCompare = convertDateFormat(expiredDate);
					endDateCompare = convertDateFormat(endDate);
					
					if (endDateCompare.after(expiredDateCompare)) {
						if (retValue.contains(item)) {
							continue;
						}
						retValue.add(item);
					}
				}
				
				if (dateProcess != null && expiredDate != null) {
					Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
					if (dateSuccess != null) {
						// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
						dateSuccessCompare = convertDateFormat(dateSuccess);
						expiredDateCompare = convertDateFormat(expiredDate);
						endDateCompare = convertDateFormat(endDate);
						
						if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
										&& (endDateCompare.after(expiredDateCompare))) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
				}
			}
		}

		return retValue;
	}
	
	/*
	 * *********************************************************
	 * 			CONG VAN DI TOAN CO QUAN
	 * *********************************************************
	 */
	public List<PmlDocumentSendLog> filter_CVDi_ToanCoQuan(int documentRecordTypeId) {
		
		List<PmlDocumentSendLog> list = new ArrayList<PmlDocumentSendLog>();

		try {
			// get all PmlDocumentSendLog
			list = PmlDocumentSendLogUtil.findAll();
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		List<PmlDocumentSendLog> retValue = filter_CVDi_ToanCoQuan(list, documentRecordTypeId);
		List<PmlDocumentSendLog> list2 = filterByDepartmentFromList_CVDi_ToanCoQuan(list);
		retValue.retainAll(list2);
		
		return retValue;
	}

	/**
	 * Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>()
	 * Lay ds tat ca cac Phong ban : list1 = PmlDepartmentUtil.findAll()
	 * Lay ds Phong ban tu list : list2 = getListDepartment(list)
	 * Duyet list
	 * - Lay ra tung departmentId cua list2 va list1 : department2, department1
	 * - Neu department2 == department1 thi them doi tuong PmlDocumentSendLog vao retValue
	 * 
	 * @param list
	 * @return
	 */
	private List<PmlDocumentSendLog> filterByDepartmentFromList_CVDi_ToanCoQuan(List<PmlDocumentSendLog> list) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (list == null) {
			return retValue;
		}
		
		try {
			List<Department> list1 = DepartmentUtil.findAll();
			List<Department> list2 = getListDepartment_CVDi_ToanCoQuan(list);
			
			if (list1 != null && list2 != null) {
				for (PmlDocumentSendLog pmlDocumentSendLog : list) {
					for (Department pmlDepartment : list1) {
						for (Department pmlDepartment2 : list2) {
							String departmentId1 = pmlDepartment.getDepartmentsId();
							String departmentId2 = pmlDepartment2.getDepartmentsId();
							
							if (departmentId1 != null && departmentId2 != null) {
								if (departmentId1.equalsIgnoreCase(departmentId2)) {
									retValue.add(pmlDocumentSendLog);
								}
							}
						}
					}
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	private List<Department> getListDepartment_CVDi_ToanCoQuan(List<PmlDocumentSendLog> list) {
		
		List<Department> retValue = new ArrayList<Department>();
		
		if (list == null) {
			return retValue;
		}
		
		List<PmlUser> listUser = new ArrayList<PmlUser>();
		
		for (PmlDocumentSendLog pmlDocumentSendLog : list) {
			long processer = pmlDocumentSendLog.getProcesser();
			
			if (processer != 0) {
				try {
					PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(processer);
					
					if (pmlUser != null) {
						if (listUser.contains(pmlUser)) {
							continue;
						}
						listUser.add(pmlUser);
					}
				} catch (NoSuchPmlUserException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		retValue = getListDepartmentByListUser_CVDi_ToanCoQuan(listUser);
		
		return retValue;
	}

	private List<Department> getListDepartmentByListUser_CVDi_ToanCoQuan(List<PmlUser> listUser) {
		
		List<Department> retValue = new ArrayList<Department>();
		
		if (listUser == null) {
			return retValue;
		}
		
		for (PmlUser pmlUser : listUser) {
			String departmentId = pmlUser.getDepartmentsId();
			
			if (departmentId != null) {
				try {
					Department pmlDepartment = DepartmentUtil.findByPrimaryKey(departmentId);
					
					if (pmlDepartment != null) {
						if (retValue.contains(pmlDepartment)) {
							continue;
						}
						retValue.add(pmlDepartment);
					}
				} catch (NoSuchDepartmentException e) {
					e.printStackTrace();
				} catch (SystemException e) {
					e.printStackTrace();
				}
			}
		}
		
		return retValue;
	}

	private List<PmlDocumentSendLog> filter_CVDi_ToanCoQuan(List<PmlDocumentSendLog> list, int documentRecordTypeId) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (list == null) {
			return retValue;
		}
		
		if (documentRecordTypeId == 0) {
			try {
				// get all PmlEdmDocumentSend
				List<PmlEdmDocumentSend> listDocumentSend = PmlEdmDocumentSendUtil.findAll();
				
				if (listDocumentSend != null && listDocumentSend.size() > 0) {
					for (PmlEdmDocumentSend pmlEdmDocumentSend : listDocumentSend) {
						// get documentSendId from listDocumentSend
						long documentSendId = pmlEdmDocumentSend.getDocumentSendId();
						
						for (PmlDocumentSendLog item : list) {
							if (documentSendId == item.getDocumentSendId()) {
								retValue.add(item);
							}
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		} else if (documentRecordTypeId != 0) {
			try {
				// get list PmlEdmDocumentType by documentRecordTypeId
				List<PmlEdmDocumentType> listDocumentType = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId);
				
				// get list PmlEdmDocumentReciept from listDocumentType
				List<PmlEdmDocumentSend> listDocumentSend = new ArrayList<PmlEdmDocumentSend>();
				List<PmlEdmDocumentSend> listDocumentSend2 = null;
				
				for (PmlEdmDocumentType pmlEdmDocumentType : listDocumentType) {
					// get documentTypeId from listDocumentType
					long documentTypeId = pmlEdmDocumentType.getDocumentTypeId();
					
					// get list PmlEdmDocumentSend by documentTypeId
					listDocumentSend2 = PmlEdmDocumentSendUtil.findByDocumentTypeId(documentTypeId);
					
					listDocumentSend.addAll(listDocumentSend2);
				}
				
				if (listDocumentSend != null && listDocumentSend.size() > 0) {
					for (PmlEdmDocumentSend pmlEdmDocumentSend : listDocumentSend) {
						// get documentSendId from listDocumentSend
						long documentSendId = pmlEdmDocumentSend.getDocumentSendId();
						
						for (PmlDocumentSendLog item : list) {
							if (documentSendId == item.getDocumentSendId()) {
								retValue.add(item);
							}
						}
					}
				}
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	/**
	 * Kiem tra cong van di da ket thuc quy trinh chinh hay chua
	 * false : chua ket thuc
	 * true : da ket thuc
	 * @param documentReceiptId
	 * @return
	 */
	public boolean checkDocumentSendFinish(long documentSendId) {
		
		boolean retValue = false;
		
		if (documentSendId == 0) {
			return retValue;
		}
		
		try {
			PmlDocumentSendWF documentSendWF = PmlDocumentSendWFUtil.findByPrimaryKey(documentSendId);
			if (documentSendWF != null) {
				if (documentSendWF != null) {
					long processId = documentSendWF.getProcessId();
					DocumentSendLiferayWorkflowService documentSendLiferayWorkflowService = new DocumentSendLiferayWorkflowService();
					if (documentSendLiferayWorkflowService.getJbpmService().getProcessInstance(processId).getEnd() != null) {
						retValue = true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	public int tonDauKy_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		List<PmlDocumentSendLog> resultList = getListForTonDauKy_CVDi_ToanCoQuan(documentRecordTypeId, startDate);
		retValue = resultList.size();
		
		return retValue;
	}

	public List<PmlDocumentSendLog> getListForTonDauKy_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi_ToanCoQuan(documentRecordTypeId);
		
		for (PmlDocumentSendLog item : list) {
			Date dateProcess = item.getDateProcess(); // get dataProcess
			Date dateReceive = item.getReceiveDate(); // get dateReceive
			if (dateProcess == null) {
				retValue.add(item);
			} else if (dateProcess != null && dateReceive != null) {
				Date dateProcessCompare = null;
				Date dateReceiveCompare = null;
				Date startDateCompare = null;
				
				// parse dateProcess, dateReceive, startDate by dd-MM-yyyy
				dateProcessCompare = convertDateFormat(dateProcess);
				dateReceiveCompare = convertDateFormat(dateReceive);
				startDateCompare = convertDateFormat(startDate);
				
				// if dateProcess >= startDate and dateReceive = startDate, add PmlDocumentSendLog object from list1 into retValue
				if ((dateProcessCompare.after(startDateCompare) || dateProcessCompare.equals(startDateCompare))
								&& (dateReceiveCompare.before(startDateCompare))) {
					if (retValue.contains(item)) {
						continue;
					}
					retValue.add(item);
				}
			}
		}
		
		return retValue;
	}
	
	public int nhanTrongKy_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentSendLog> resultList = getListForNhanTrongKy_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}
	
	/**
	* Tao List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>() <br>
	* Lay ds PmlDocumentSendLog bang filter : list = filter_CVDi_ToanCoQuan(documentRecordTypeId) <br>
	* Lay ds PmlDocumentSendLog theo documentSendId va transitionMax cua documentSendId do : list1 <br>
	* Duyet list1, lay receiveDate <br>
	* Neu receiveDate >= startDate va receiveDate <= endDate thi them PmlDocumentSendLog vao retValue
	* 
	* @param documentRecordTypeId
	* @param startDate
	* @param endDate
	* @return
	*/
	public List<PmlDocumentSendLog> getListForNhanTrongKy_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentSendLog> list = filter_CVDi_ToanCoQuan(documentRecordTypeId);

		for (PmlDocumentSendLog item : list) {
			Date dateReceive = item.getReceiveDate();
			if (dateReceive != null) {
				Date dateReceiveCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;

				dateReceiveCompare = convertDateFormat(dateReceive);
				startDateCompare = convertDateFormat(startDate);
				endDateCompare = convertDateFormat(endDate);

				if ((dateReceiveCompare.after(startDateCompare) || dateReceiveCompare.equals(startDateCompare))
						&& (dateReceiveCompare.before(endDateCompare) || dateReceiveCompare.equals(endDateCompare))) {
					if (retValue.contains(item)) {
						continue;
					}
					retValue.add(item);
				}
			}
		}

		return retValue;
	}
	
	public int dungHan_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentSendLog> resultList = getListForDungHan_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}

	/**
	 * Tao List<PmlDocumentSendLog> retValue = new
	 * ArrayList<PmlDocumentSendLog>() <br>
	 * Lay ds PmlDocumentSendLog bang filter : list =
	 * filter_CVDi(documentRecordTypeId) <br>
	 * Lay ds PmlDocumentSendLog theo documentSendId va transitionMax cua
	 * documentSendId do : list1 <br>
	 * Duyet list1, lay dateProcess, numDateProcess, expiredDate <br>
	 * Cong them cho dateProcess so ngay numDateProcess de tinh duoc ngay hoan
	 * thanh giai doan : dateSuccess <br>
	 * Neu dateSuccess != null va startDate <= dateSuccess <= endDate va
	 * dateSuccess <= expiredDate thi them PmlDocumentSendLog vao retValue <br>
	 * 
	 * @param documentRecordTypeId
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public List<PmlDocumentSendLog> getListForDungHan_CVDi_ToanCoQuan(int documentRecordTypeId,	Date startDate, Date endDate) {

		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();

		if (startDate == null || endDate == null) {
			return retValue;
		}

		// get list PmlDocumentSendLog by documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi_ToanCoQuan(documentRecordTypeId);

		for (PmlDocumentSendLog item : list) {
			long documentSendId = item.getDocumentSendId();
			
			// cong van di khong co cong van den
			if (hasDocumentReceipt(documentSendId) == false) {
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (checkDocumentSendFinish(documentSendId) == true) {
					if (expiredDate == null) {
						if (dateProcess != null) {
							Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
							dateSuccessCompare = convertDateFormat(dateSuccess);
							startDateCompare = convertDateFormat(startDate);
							endDateCompare = convertDateFormat(endDate);
							if ((dateSuccessCompare != null)
									&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
									&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
					
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							startDateCompare = convertDateFormat(startDate);
							endDateCompare = convertDateFormat(endDate);

							if ((dateSuccessCompare != null)
									&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
									&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
									&& (dateSuccessCompare.before(expiredDateCompare) || dateSuccessCompare.equals(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			} else {
				// neu cong van di co cong van den
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceipt
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (checkDocumentSendFinish(documentSendId) == true) {
					if (expiredDate == null) {
						if (dateProcess != null) {
							Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
							dateSuccessCompare = convertDateFormat(dateSuccess);
							startDateCompare = convertDateFormat(startDate);
							endDateCompare = convertDateFormat(endDate);
							if ((dateSuccessCompare != null)
									&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
									&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
					
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							startDateCompare = convertDateFormat(startDate);
							endDateCompare = convertDateFormat(endDate);

							if ((dateSuccessCompare != null)
									&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
									&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
									&& (dateSuccessCompare.before(expiredDateCompare) || dateSuccessCompare.equals(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			}
		}

		return retValue;
	}
	
	private Date getExpiredDateFromDocumentReceiptLog(long documentSendId) {
		
		Date retValue = null;
		
		if (documentSendId == 0) {
			return retValue;
		}
		
		try {
			List<PmlEdmAnswerDetail> listAnswerDetail = PmlEdmAnswerDetailUtil.findByDocumentSendId(documentSendId);
			if (listAnswerDetail != null && listAnswerDetail.size() > 0) {
				PmlEdmAnswerDetail pmlEdmAnswerDetail = listAnswerDetail.get(0);
				long documentReceiptId = pmlEdmAnswerDetail.getDocumentReceiptId();
				List<PmlDocumentReceiptLog> listPmlDocumentReceiptLog =  PmlDocumentReceiptLogUtil.findByDocumentReceiptId(documentReceiptId);
				if (listPmlDocumentReceiptLog != null && listPmlDocumentReceiptLog.size() > 0) {
					PmlDocumentReceiptLog pmlDocumentReceiptLog = listPmlDocumentReceiptLog.get(0);
					retValue = pmlDocumentReceiptLog.getExpiredDate();
				}
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	/**
	 * Kiem tra xem cong van den co cong van di tra loi hay khong
	 * false : cong van den khong co cong van di
	 * true : cong van den co cong van di
	 * @param documentSendId
	 * @return
	 */
	private boolean hasDocumentReceipt(long documentSendId) {
		
		boolean retValue = false;
		
		if (documentSendId == 0) {
			return retValue;
		}
		
		try {
			List<PmlEdmAnswerDetail> listAnswerDetail = PmlEdmAnswerDetailUtil.findByDocumentSendId(documentSendId);
			if (listAnswerDetail != null && listAnswerDetail.size() > 0) {
				retValue = true;
			}
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}

	public int treHan_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentSendLog> resultList = getListForTreHan_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}

	public List<PmlDocumentSendLog> getListForTreHan_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi_ToanCoQuan(documentRecordTypeId);
		
		for (PmlDocumentSendLog item : list) {
			long documentSendId = item.getDocumentSendId();
			
			// cong van di khong co cong van den
			if (hasDocumentReceipt(documentSendId) == false) {
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess();
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (checkDocumentSendFinish(documentSendId) == true) {
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							startDateCompare = convertDateFormat(startDate);
							endDateCompare = convertDateFormat(endDate);
							
							if ((dateSuccessCompare != null) 
									&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
									&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
									&& (dateSuccessCompare.after(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			} else {
				// cong van di co cong van den
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceiptLog
				int numDateProcess = item.getNumDateProcess();
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date startDateCompare = null;
				Date endDateCompare = null;
				
				if (checkDocumentSendFinish(documentSendId) == true) {
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							startDateCompare = convertDateFormat(startDate);
							endDateCompare = convertDateFormat(endDate);
							
							if ((dateSuccessCompare != null) 
									&& (dateSuccessCompare.after(startDateCompare) || dateSuccessCompare.equals(startDateCompare))
									&& (dateSuccessCompare.before(endDateCompare) || dateSuccessCompare.equals(endDateCompare))
									&& (dateSuccessCompare.after(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			}
			
		}

		return retValue;
	}
	
	public int trongQuyDinh_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentSendLog> resultList = getListForTrongQuyDinh_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}

	public List<PmlDocumentSendLog> getListForTrongQuyDinh_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null || endDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi_ToanCoQuan(documentRecordTypeId);
		List<PmlDocumentSendLog> listNhanTrongKy = getListForNhanTrongKy_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		
		if (listNhanTrongKy != null && listNhanTrongKy.size() > 0) {
			for (PmlDocumentSendLog item : list) {
				long documentSendId = item.getDocumentSendId();
				
				// cong van di khong co cong van den
				if (hasDocumentReceipt(documentSendId) == false) {
					Date dateProcess = item.getDateProcess(); // get dateProcess
					Date expiredDate = item.getExpiredDate(); // get expiredDate
					int numDateProcess = item.getNumDateProcess(); // get numDateProcess
					
					Date dateSuccessCompare = null;
					Date expiredDateCompare = null;
					Date endDateCompare = null;
					
					if (checkDocumentSendFinish(documentSendId) == false) {
						if (expiredDate == null) {
							if (dateProcess == null) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							} else {
								Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
								if (dateSuccess != null) {
									// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
									dateSuccessCompare = convertDateFormat(dateSuccess);
									endDateCompare = convertDateFormat(endDate);
									
									if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))) {
										if (retValue.contains(item)) {
											continue;
										}
										retValue.add(item);
									}
								}
							}
						}
						
						if (dateProcess == null && expiredDate != null) {
							expiredDateCompare = convertDateFormat(expiredDate);
							endDateCompare = convertDateFormat(endDate);
							
							if (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare)) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
						if (dateProcess != null && expiredDate != null) {
							Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
							if (dateSuccess != null) {
								// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
								dateSuccessCompare = convertDateFormat(dateSuccess);
								expiredDateCompare = convertDateFormat(expiredDate);
								endDateCompare = convertDateFormat(endDate);
								
								if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
												&& (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare))) {
									if (retValue.contains(item)) {
										continue;
									}
									retValue.add(item);
								}
							}
						}
					}
				} else {
					// cong van di co cong van den
					Date dateProcess = item.getDateProcess(); // get dateProcess
					Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceiptLog
					int numDateProcess = item.getNumDateProcess(); // get numDateProcess
					
					Date dateSuccessCompare = null;
					Date expiredDateCompare = null;
					Date endDateCompare = null;
					
					if (checkDocumentSendFinish(documentSendId) == false) {
						if (expiredDate == null) {
							if (dateProcess == null) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							} else {
								Date dateSuccess = getDateSuccess(dateProcess, numDateProcess);
								if (dateSuccess != null) {
									// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
									dateSuccessCompare = convertDateFormat(dateSuccess);
									endDateCompare = convertDateFormat(endDate);
									
									if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))) {
										if (retValue.contains(item)) {
											continue;
										}
										retValue.add(item);
									}
								}
							}
						}
						
						if (dateProcess == null && expiredDate != null) {
							expiredDateCompare = convertDateFormat(expiredDate);
							endDateCompare = convertDateFormat(endDate);
							
							if (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare)) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
						if (dateProcess != null && expiredDate != null) {
							Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
							if (dateSuccess != null) {
								// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
								dateSuccessCompare = convertDateFormat(dateSuccess);
								expiredDateCompare = convertDateFormat(expiredDate);
								endDateCompare = convertDateFormat(endDate);
								
								if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
												&& (endDateCompare.before(expiredDateCompare) || endDateCompare.equals(expiredDateCompare))) {
									if (retValue.contains(item)) {
										continue;
									}
									retValue.add(item);
								}
							}
						}
					}
				}
			}
		}

		return retValue;
	}
	
	public int quaQuyDinh_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {

		int retValue = 0;

		if (startDate == null || endDate == null) {
			return retValue;
		}

		List<PmlDocumentSendLog> resultList = getListForQuaQuyDinh_CVDi_ToanCoQuan(documentRecordTypeId, startDate, endDate);
		retValue = resultList.size();

		return retValue;
	}

	public List<PmlDocumentSendLog> getListForQuaQuyDinh_CVDi_ToanCoQuan(int documentRecordTypeId, Date startDate, Date endDate) {
		
		List<PmlDocumentSendLog> retValue = new ArrayList<PmlDocumentSendLog>();
		
		if (startDate == null) {
			return retValue;
		}
		
		// get list PmlDocumentSendLog by documentRecordTypeId
		List<PmlDocumentSendLog> list = filter_CVDi_ToanCoQuan(documentRecordTypeId);
		
		for (PmlDocumentSendLog item : list) {
			long documentSendId = item.getDocumentSendId();
			
			// cong van di khong co cong van den
			if (hasDocumentReceipt(documentSendId) == false) {
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = item.getExpiredDate(); // get expiredDate
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date endDateCompare = null;
				
				if (checkDocumentSendFinish(documentSendId) == false) {
					if (dateProcess == null && expiredDate != null) {
						expiredDateCompare = convertDateFormat(expiredDate);
						endDateCompare = convertDateFormat(endDate);
						
						if (endDateCompare.after(expiredDateCompare)) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							endDateCompare = convertDateFormat(endDate);
							
							if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
											&& (endDateCompare.after(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			} else {
				// cong van di co cong van den
				Date dateProcess = item.getDateProcess(); // get dateProcess
				Date expiredDate = getExpiredDateFromDocumentReceiptLog(documentSendId); // get expiredDate from DocumentReceiptLog
				int numDateProcess = item.getNumDateProcess(); // get numDateProcess
				
				Date dateSuccessCompare = null;
				Date expiredDateCompare = null;
				Date endDateCompare = null;
				
				if (checkDocumentSendFinish(documentSendId) == false) {
					if (dateProcess == null && expiredDate != null) {
						expiredDateCompare = convertDateFormat(expiredDate);
						endDateCompare = convertDateFormat(endDate);
						
						if (endDateCompare.after(expiredDateCompare)) {
							if (retValue.contains(item)) {
								continue;
							}
							retValue.add(item);
						}
					}
					if (dateProcess != null && expiredDate != null) {
						Date dateSuccess = getDateSuccess(dateProcess, numDateProcess); // get dateSuccess
						if (dateSuccess != null) {
							// parse dateSuccess, expiredDate, startDate, endDate to dd-MM-yyyy format
							dateSuccessCompare = convertDateFormat(dateSuccess);
							expiredDateCompare = convertDateFormat(expiredDate);
							endDateCompare = convertDateFormat(endDate);
							
							if ((dateSuccessCompare != null) && (dateSuccessCompare.after(endDateCompare))
											&& (endDateCompare.after(expiredDateCompare))) {
								if (retValue.contains(item)) {
									continue;
								}
								retValue.add(item);
							}
						}
					}
				}
			}
		}

		return retValue;
	}

}