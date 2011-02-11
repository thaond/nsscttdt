package com.sgs.portlet.pml_edm_docconfuser.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.User;
import com.sgs.portlet.document.model.PmlDocumentReceiptLog;
import com.sgs.portlet.document.model.PmlDocumentSendLog;
import com.sgs.portlet.pml_edm_docconfuser.PmlEdmDocConfUserUserIdException;
import com.sgs.portlet.pml_edm_docconfuser.model.PmlEdmDocConfUser;
import com.sgs.portlet.pml_edm_docconfuser.service.base.PmlEdmDocConfUserLocalServiceBaseImpl;
import com.sgs.portlet.pmluser.model.PmlUser;

/**
 * <a href="PmlEdmDocConfUserLocalServiceImpl.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlEdmDocConfUserLocalServiceImpl
    extends PmlEdmDocConfUserLocalServiceBaseImpl {

	/**
	 * 
	 * @return The count of all item in table
	 * @throws SystemException
	 */
	public int countAll() 
	throws SystemException {
		try {
			return pmlEdmDocConfUserPersistence.countAll();
		}
		catch (Exception ex) {
			return 0;
		}
	}
	
	/**
	 * Get records to display to searchContainer
	 * @param start The position of starting record
	 * @param end The position of ending record
	 * @param obc Order by comparator
	 * @return List of document config user
	 * @throws SystemException
	 */
	public List<PmlEdmDocConfUser> findAll(
			int start, int end, OrderByComparator obc) 
	throws SystemException {
		try {
			return pmlEdmDocConfUserPersistence.findAll(start, end, obc);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param companyId Ma so cong ty
	 * @return Danh sach nguoi dung theo cong ty
	 * @throws SystemException
	 */
	public List<User> getUserByCompany(
			long companyId) 
	throws SystemException {
		
		try {
			return userPersistence.findByCompanyId(companyId);
		}
		catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Get item by primary
	 */
	public PmlEdmDocConfUser getPmlEdmDocConfUser(
			long dcuId) 
	throws SystemException {
		
		try {
			return pmlEdmDocConfUserPersistence.findByPrimaryKey(dcuId);
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	/**
	 * Add new item
	 * @param userId Ma so nguoi dung
	 * @param viewAllDoc Xem toan bo cong van
	 * @param viewDepDoc Danh sach phong duoc xem cong van
	 * @return Document config user
	 * @throws PortalException
	 * @throws SystemException
	 */
	public PmlEdmDocConfUser addPmlEdmDocConfUser(
			long userId, boolean viewAllDoc, String viewDepDoc)
	throws PortalException, SystemException {

		// Check inputted value
		validate(userId);
	
		long dcuId = counterLocalService.increment();
		
		PmlEdmDocConfUser pmlEdmDocConfUser = pmlEdmDocConfUserPersistence.create(dcuId);
	
		// Set properties value
		pmlEdmDocConfUser.setUserId(userId);
		pmlEdmDocConfUser.setViewAllDoc(viewAllDoc);
		pmlEdmDocConfUser.setViewDepDoc(viewDepDoc);

		pmlEdmDocConfUserPersistence.update(pmlEdmDocConfUser, false);
	
		return pmlEdmDocConfUser;
	}

	/**
	 * Kiem tra nguoi dung hop le
	 * @param userId Ma so nguoi dung
	 * @throws PortalException
	 * @throws SystemException
	 */
	protected void validate(long userId)
		throws PortalException, SystemException {
		
		try {
			userPersistence.findByPrimaryKey(userId);
		}
		catch (Exception ex) {
			throw new PmlEdmDocConfUserUserIdException();
		}
	}

	/**
	 * Cap nhat thong tin mot muc
	 * @param dcfId Ma so muc
	 * @param userId Ma so nguoi dung
	 * @param viewAllDoc Xem toan bo cong van
	 * @param viewDepDoc Danh sach phong ban duoc xem cong van
	 * @return Muc cap nhat
	 * @throws PortalException
	 * @throws SystemException
	 */
	public PmlEdmDocConfUser updatePmlEdmDocConfUser(
			long dcuId, long userId, boolean viewAllDoc,  
			String viewDepDoc)
		throws PortalException, SystemException {
	
		// Checking inputted values
		validate(userId);
	
		PmlEdmDocConfUser pmlEdmDocConfUser = pmlEdmDocConfUserPersistence.findByPrimaryKey(dcuId);
	
		// Updated properties
		pmlEdmDocConfUser.setUserId(userId);
		pmlEdmDocConfUser.setViewAllDoc(viewAllDoc);
		pmlEdmDocConfUser.setViewDepDoc(viewDepDoc);
		
		pmlEdmDocConfUserPersistence.update(pmlEdmDocConfUser, false);
	
		return pmlEdmDocConfUser;
	}
	
	/**
	 * Delete document configuration for user
	 */
	public void deletePmlEdmDocConfUser(
			long delDCUId) 
	throws PortalException, SystemException {
		
		if (delDCUId <= 0) return;
		pmlEdmDocConfUserPersistence.remove(delDCUId);
	}
	
	/**
	 * Return department id list for arraylist of received document id
	 * @param recDocIdList ArrayList of received document id
	 * @return ArrayList of document id which process document
	 * @throws SystemException
	 */
	public ArrayList<String> getDepIdListForRecDocIdList(
			ArrayList<Long> recDocIdList) 
	throws SystemException {
	
		ArrayList<String> retDepIdList = new ArrayList<String>();// ArrayList of department id to return
		// Construct retDepIdList 
		for (int idx = 0; idx < (recDocIdList.isEmpty() ? 0 : recDocIdList.size()); idx++) {
			retDepIdList.add("");
		}
		try {
			// Get all of received document log
			List<PmlDocumentReceiptLog> allRecDocLog = pmlEdmDocConfUserFinder.findAllRecDocLogByDocIdList(recDocIdList);
			ArrayList<String> userForEachDoc = new ArrayList<String>(); // ArrayList save user list for each document
			// Construct userForEachDoc 
			for (int idx = 0; idx < (recDocIdList.isEmpty() ? 0 : recDocIdList.size()); idx++) {
				userForEachDoc.add("");
			}
			
			ArrayList<Long> userIdUseDocList = new ArrayList<Long>(); // ArrayList of user which process document
			ArrayList<String> docUserTmpList = new ArrayList<String>(); // Temp ArrayList for checking before add
			// Read each item in allRecDocLog
			for (int idx = 0; idx < (allRecDocLog.isEmpty() ? 0 : allRecDocLog.size()); idx++) {
				PmlDocumentReceiptLog dclItem = (PmlDocumentReceiptLog)allRecDocLog.get(idx);

				String chkVal = ""; // Contain docId and "_" and userId
				String userIdListTmp = ""; // Temp list of userId which process document
				// Processor
				if (dclItem.getProcesser() > 0) {
					chkVal = String.valueOf(dclItem.getDocumentReceiptId()) + "_" + String.valueOf(dclItem.getProcesser());
					if (!docUserTmpList.contains(chkVal)) {
						// Add item into userForEachDoc
						if (recDocIdList.contains(dclItem.getDocumentReceiptId())) {
							userIdListTmp = String.valueOf(userForEachDoc.get(recDocIdList.indexOf(dclItem.getDocumentReceiptId()))).trim();
							if (!userIdListTmp.equals("")) {
								userIdListTmp += ",";
							}
							userIdListTmp += String.valueOf(dclItem.getProcesser());
							userForEachDoc.set(recDocIdList.indexOf(dclItem.getDocumentReceiptId()), userIdListTmp);

							// Add item into userIdUseDocList
							if (!userIdUseDocList.contains(dclItem.getProcesser())) {
								userIdUseDocList.add(dclItem.getProcesser());
							}
							// Add item into docUserTmpList
							docUserTmpList.add(chkVal);
						}
					}
				}
				// Receiver
				if (dclItem.getReceiver() > 0) {
					chkVal = String.valueOf(dclItem.getDocumentReceiptId()) + "_" + String.valueOf(dclItem.getReceiver());
					if (!docUserTmpList.contains(chkVal)) {
						// Add item into userForEachDoc
						if (recDocIdList.contains(dclItem.getDocumentReceiptId())) {
							userIdListTmp = String.valueOf(userForEachDoc.get(recDocIdList.indexOf(dclItem.getDocumentReceiptId()))).trim();
							if (!userIdListTmp.equals("")) {
								userIdListTmp += ",";
							}
							userIdListTmp += String.valueOf(dclItem.getReceiver());
							userForEachDoc.set(recDocIdList.indexOf(dclItem.getDocumentReceiptId()), userIdListTmp);

							// Add item into userIdUseDocList
							if (!userIdUseDocList.contains(dclItem.getReceiver())) {
								userIdUseDocList.add(dclItem.getReceiver());
							}
							// Add item into docUserTmpList
							docUserTmpList.add(chkVal);
						}
					}
				} // end if
			} // end for
			// Get department id for each user
			ArrayList<String> depForUserIdList = getDepIdListForUserIdList(userIdUseDocList);
			// View each item in userForEachDoc and match it's department
			for (int idx = 0; idx < (userForEachDoc.isEmpty() ? 0 : userForEachDoc.size()); idx++) {
				String resDepMat = ""; // Department match each user id in each element of userForEachDoc
				String[] userIdArr = userForEachDoc.get(idx).split(","); // each element of userForEachDoc
				for (int idxOfUserIdArr = 0; idxOfUserIdArr < userIdArr.length; idxOfUserIdArr++) {
					if (userIdUseDocList.contains(Long.parseLong(userIdArr[idxOfUserIdArr]))) {
						if (!resDepMat.equals("")) {
							resDepMat+= ",";
						}
						resDepMat+= depForUserIdList.get(userIdUseDocList.indexOf(Long.parseLong(userIdArr[idxOfUserIdArr])));
					}
				}
				retDepIdList.set(idx, resDepMat);
			}
		}
		catch (Exception ex) {
			// Do nothing
		}
		return retDepIdList;
	}
	
	/**
	 * Get Department id list from the list of user id which process document
	 * @param userIdList The list of user id which process document
	 * @return ArrayList of department id
	 * @throws SystemException
	 */
	public ArrayList<String> getDepIdListForUserIdList(
			ArrayList<Long> userIdList) 
	throws SystemException {

		ArrayList<String> retDepIdList = new ArrayList<String>();// ArrayList of department id to return
		// Construct retDepIdList 
		for (int idx = 0; idx < (userIdList.isEmpty() ? 0 : userIdList.size()); idx++) {
			retDepIdList.add("");
		}
		
		try {
			List<PmlUser> userProDocList = 
				pmlEdmDocConfUserFinder.findAllDepByUserIdList(userIdList);
			
			for (int idx = 0; idx < (userProDocList.isEmpty() ? 0 : userProDocList.size()); idx++) {
				PmlUser userTmp = (PmlUser)userProDocList.get(idx);
				if (userTmp.getUserId() > 0 && !userTmp.getDepartmentsId().trim().equals("")) {
					if (userIdList.contains(userTmp.getUserId())) {
						String depIdTmp = retDepIdList.get(userIdList.indexOf(userTmp.getUserId()));
						if (!depIdTmp.equals("")) {
							depIdTmp+= ",";
						}
						depIdTmp+= userTmp.getDepartmentsId().trim();
						retDepIdList.set(userIdList.indexOf(userTmp.getUserId()), depIdTmp);
					}
				}
			}
		}
		catch (Exception ex) {
			// No action
		}
		return retDepIdList;
	}
	
	/**
	 * Get Document configuration user by userId
	 * @param userId User id
	 * @return Document configuration
	 * @throws SystemException
	 */
	public PmlEdmDocConfUser findByUserId(
			long userId) 
	throws SystemException {
		
		try {
			return pmlEdmDocConfUserPersistence.findByUserId(userId);
		}
		catch (Exception ex) {
			return null;
		}
	}

	/**
	 * Return department id list for arraylist of received document id
	 * @param senDocIdList ArrayList of received document id
	 * @return ArrayList of document id which process document
	 * @throws SystemException
	 */
	public ArrayList<String> getDepIdListForSenDocIdList(
			ArrayList<Long> senDocIdList) 
	throws SystemException {
	
		ArrayList<String> retDepIdList = new ArrayList<String>();// ArrayList of department id to return
		// Construct retDepIdList 
		for (int idx = 0; idx < (senDocIdList.isEmpty() ? 0 : senDocIdList.size()); idx++) {
			retDepIdList.add("");
		}
		try {
			// Get all of sent document log
			List<PmlDocumentSendLog> allSenDocLog = pmlEdmDocConfUserFinder.findAllSendDocLogByDocIdList(senDocIdList);
			ArrayList<String> userForEachDoc = new ArrayList<String>(); // ArrayList save user list for each document
			// Construct userForEachDoc 
			for (int idx = 0; idx < (senDocIdList.isEmpty() ? 0 : senDocIdList.size()); idx++) {
				userForEachDoc.add("");
			}
			
			ArrayList<Long> userIdUseDocList = new ArrayList<Long>(); // ArrayList of user which process document
			ArrayList<String> docUserTmpList = new ArrayList<String>(); // Temp ArrayList for checking before add
			// Read each item in allSenDocLog
			for (int idx = 0; idx < (allSenDocLog.isEmpty() ? 0 : allSenDocLog.size()); idx++) {
				PmlDocumentSendLog dslItem = (PmlDocumentSendLog)allSenDocLog.get(idx);

				String chkVal = ""; // Contain docId and "_" and userId
				String userIdListTmp = ""; // Temp list of userId which process document
				// Processor
				if (dslItem.getProcesser() > 0) {
					chkVal = String.valueOf(dslItem.getDocumentSendId()) + "_" + String.valueOf(dslItem.getProcesser());
					if (!docUserTmpList.contains(chkVal)) {
						// Add item into userForEachDoc
						if (senDocIdList.contains(dslItem.getDocumentSendId())) {
							userIdListTmp = String.valueOf(userForEachDoc.get(senDocIdList.indexOf(dslItem.getDocumentSendId()))).trim();
							if (!userIdListTmp.equals("")) {
								userIdListTmp += ",";
							}
							userIdListTmp += String.valueOf(dslItem.getProcesser());
							userForEachDoc.set(senDocIdList.indexOf(dslItem.getDocumentSendId()), userIdListTmp);

							// Add item into userIdUseDocList
							if (!userIdUseDocList.contains(dslItem.getProcesser())) {
								userIdUseDocList.add(dslItem.getProcesser());
							}
							// Add item into docUserTmpList
							docUserTmpList.add(chkVal);
						}
					}
				}
				// Receiver
				if (dslItem.getReceiver() > 0) {
					chkVal = String.valueOf(dslItem.getDocumentSendId()) + "_" + String.valueOf(dslItem.getReceiver());
					if (!docUserTmpList.contains(chkVal)) {
						// Add item into userForEachDoc
						if (senDocIdList.contains(dslItem.getDocumentSendId())) {
							userIdListTmp = String.valueOf(userForEachDoc.get(senDocIdList.indexOf(dslItem.getDocumentSendId()))).trim();
							if (!userIdListTmp.equals("")) {
								userIdListTmp += ",";
							}
							userIdListTmp += String.valueOf(dslItem.getReceiver());
							userForEachDoc.set(senDocIdList.indexOf(dslItem.getDocumentSendId()), userIdListTmp);

							// Add item into userIdUseDocList
							if (!userIdUseDocList.contains(dslItem.getReceiver())) {
								userIdUseDocList.add(dslItem.getReceiver());
							}
							// Add item into docUserTmpList
							docUserTmpList.add(chkVal);
						}
					}
				} // end if
			} // end for
			// Get department id for each user
			ArrayList<String> depForUserIdList = getDepIdListForUserIdList(userIdUseDocList);
			// View each item in userForEachDoc and match it's department
			for (int idx = 0; idx < (userForEachDoc.isEmpty() ? 0 : userForEachDoc.size()); idx++) {
				String resDepMat = ""; // Department match each user id in each element of userForEachDoc
				String[] userIdArr = userForEachDoc.get(idx).split(","); // each element of userForEachDoc
				for (int idxOfUserIdArr = 0; idxOfUserIdArr < userIdArr.length; idxOfUserIdArr++) {
					if (userIdUseDocList.contains(Long.parseLong(userIdArr[idxOfUserIdArr]))) {
						if (!resDepMat.equals("")) {
							resDepMat+= ",";
						}
						resDepMat+= depForUserIdList.get(userIdUseDocList.indexOf(Long.parseLong(userIdArr[idxOfUserIdArr])));
					}
				}
				retDepIdList.set(idx, resDepMat);
			}
		}
		catch (Exception ex) {
			// Do nothing
		}
		return retDepIdList;
	}
}
