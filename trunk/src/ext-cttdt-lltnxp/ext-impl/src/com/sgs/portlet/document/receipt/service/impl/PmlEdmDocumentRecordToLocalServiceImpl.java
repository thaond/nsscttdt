package com.sgs.portlet.document.receipt.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.document.receipt.PmlEdmDocumentRecordToCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlEdmBookDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordTo;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.PmlEdmBookDocumentRecordToLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.base.PmlEdmDocumentRecordToLocalServiceBaseImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmBookDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentRecordToUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.send.PmlEdmBookDocumentSendCanNotDeleteException;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;


/**
 * @author lethanhtung
 *
 */
public class PmlEdmDocumentRecordToLocalServiceImpl extends PmlEdmDocumentRecordToLocalServiceBaseImpl {
	
	/**
	 * this method get a PmlEdmDocumentRecordTo object by year in use, department and document record type
	 * Use when book document receipt for department
	 * @param yearInUse : 
	 * @param departmentsId : id 
	 * @param documentRecordTypeId : id 
	 * @return PmlEdmDocumentRecordTo
	 * 
	 */
	public PmlEdmDocumentRecordTo getDocumentRecordTo (String yearInUse, String departmentsId, int documentRecordTypeId) {
		
		PmlEdmDocumentRecordTo retValue = null;
		List<PmlEdmDocumentRecordTo> list = null;
		try {
			list = PmlEdmDocumentRecordToUtil.findByDepartDocYear(yearInUse, departmentsId, documentRecordTypeId);
			
			if (list != null && list.size() > 0) {
				retValue = list.get(0);
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return retValue;
	}
	
	/**
	 * this method get a PmlEdmDocumentRecordTo object by year in use, agency and document record type
	 * Use when book document receipt for service office (service office : sở)
	 * @param yearInUse : 
	 * @param agencyId : id 
	 * @param documentRecordTypeId : id 
	 * @return PmlEdmDocumentRecordTo object
	 * 
	 */
	public PmlEdmDocumentRecordTo getDocumentRecordToBy_YearInUse_AgencyId_DocumentRecordTypeId (String yearInUse, String agencyId, 
																									int documentRecordTypeId) {
		
		PmlEdmDocumentRecordTo retValue = null;
		List<PmlEdmDocumentRecordTo> list = null;
		
		if (yearInUse == null || agencyId == null) {
			return retValue;
		} else {
			try {
				list = PmlEdmDocumentRecordToUtil.findByAgencyId_Year_DocumentRecordTo(agencyId, yearInUse, documentRecordTypeId);
				
				if (list != null && list.size() > 0) {
					retValue = list.get(0);
				}
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	/**
	 * this method get a PmlEdmDocumentRecordTo object by department, document record type and agency
	 * @param departmentsId : id 
	 * @param documentRecordTypeId :
	 * @return PmlEdmDocumentRecordTo object
	 * 
	 */
	public PmlEdmDocumentRecordTo getDocumentRecordTo (String departmentsId, int documentRecordTypeId, String agencyId) {
		
		PmlEdmDocumentRecordTo retValue = null;
		List<PmlEdmDocumentRecordTo> list = null;
		
		if (departmentsId == null || agencyId == null) {
			return retValue;
		} else {
			try {
				list = PmlEdmDocumentRecordToUtil.findByDepartDocAgency(agencyId, departmentsId, documentRecordTypeId);
				
				if (list != null && list.size() > 0) {
					retValue = list.get(0);
				}
			}
			catch (SystemException e) {
				e.printStackTrace();
			}
		}
		
		
		return retValue;
	}
	
	/**
	 * this method get a PmlEdmDocumentRecordTo object by document receipt
	 * @param documentReceiptId : id 
	 * @return PmlEdmDocumentRecordTo object
	 * 
	 */
	public PmlEdmDocumentRecordTo getDocumentRecordToByDocumentReceipt (long documentReceiptId) {
		
		PmlEdmDocumentRecordTo retValue = null;
		
		try {
			PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
			if (documentReceipt == null) {
				return retValue;
			}
				
			long documentTypeId = documentReceipt.getDocumentTypeId();
			
			PmlEdmDocumentType documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
			
			if (documentType != null) {
				int documentRecordTypeId = documentType.getDocumentRecordTypeId();
				
				retValue = PmlEdmDocumentRecordToUtil.findByDocumentRecordTypeId(documentRecordTypeId).get(0);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * this method get id of document record type () by document receipt ()
	 * @param documentReceiptId
	 * @return integer
	 * 
	 */
	public int getDocumentRecordTypeIdByDocumentReceipt (long documentReceiptId) {
		
		int retValue = 0;
		PmlEdmDocumentType documentType = null;
		try {
			PmlEdmDocumentReceipt documentReceipt = PmlEdmDocumentReceiptUtil.findByPrimaryKey(documentReceiptId);
			if (documentReceipt == null) {
				return retValue;
			}
				
			long documentTypeId = documentReceipt.getDocumentTypeId();
			documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
			
			if (documentType != null) {
				int documentRecordTypeId = documentType.getDocumentRecordTypeId();
				retValue = documentRecordTypeId;
			}
		}
		catch (Exception e) {
			retValue = 0;
			System.out.println(" ERROR IN METHOD GETDOCUMENTRECORDTYPEIDBYDOCUMENTRECEIPT IN " + PmlEdmDocumentRecordToLocalServiceImpl.class + " " + e.getMessage()); 
		}
		
		return retValue;
	}
	
	/**
	 * this method get id of department by user id
	 * @param userId
	 * @return String
	 * 
	 */
	public String getDepartmentIdByUserId (long userId) {
		
		String retValue = "";
		
		try {
			PmlUser pmlUser = PmlUserUtil.findByPrimaryKey(userId);
			if (pmlUser != null) {
				String departmentId = pmlUser.getDepartmentsId();
				if (departmentId != null) {
					retValue = departmentId;
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue; 
	}
	
	/**
	 * this method checking book document record to
	 * @param bookDocumentRecordTo
	 * @return true if book document record to success
	 * 
	 */
	public boolean addBookDocumentRecordTo (PmlEdmBookDocumentRecordTo bookDocumentRecordTo) {
		
		boolean retValue = false;
		
		if (bookDocumentRecordTo == null) {
			return false;
		}
		try {
			if (PmlEdmBookDocumentRecordToLocalServiceUtil.updatePmlEdmBookDocumentRecordTo(bookDocumentRecordTo) == null) {
				return retValue;
			} 
			retValue = true;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * this method get PmlEdmDocumentRecordTo object by documentTypeId and agencyId
	 * @param documentTypeId : ID 
	 * @param agencyId : ID 
	 * @return PmlEdmDocumentRecordTo object
	 */
	@SuppressWarnings("null")
	public PmlEdmDocumentRecordTo getDocumentRecordToBy_DocumentType_AgencyId (long documentTypeId, String agencyId) {
		
		PmlEdmDocumentRecordTo retValue = null;
		List<PmlEdmDocumentRecordTo> list = null;
		PmlEdmDocumentType documentType = null;
		
		try {
			documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if (agencyId == null || documentType == null) {
			return retValue;
		}
		
		int documentRecordTypeId = documentType.getDocumentRecordTypeId();
		try {
			list = PmlEdmDocumentRecordToUtil.findByAgency_DocumentType(agencyId, documentRecordTypeId);
			if (list == null) {
				return retValue;
			}
			else if (list != null || list.size() > 0) {
				retValue = list.get(0);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	/**
	 * this method get id of agency by a department
	 * @param department
	 * @return String
	 * 
	 */
	public String getAgencyIdByDepartment (Department department) {
		
		String retValue = "";
		
		if (department != null) {
			if (department.getAgencyId() != null) {
				retValue = department.getAgencyId();
			}
		}
		
		return retValue;
	}
	
	// phmphuc get 24/05/2010
	// SO CONG VAN DEN CUA SO
	public int searchCountSoCongVanDenSo(String keywords) throws SystemException {
		return pmlEdmDocumentRecordToFinder.countByKeywords(keywords);
	}
	
	public int searchCountSoCongVanDenSo(String loaiSoCVs, String so, boolean andOperator) throws SystemException{
		return pmlEdmDocumentRecordToFinder.countDocumentRecordToAgency(loaiSoCVs, so, andOperator);
	}
	
	public List<PmlEdmDocumentRecordTo> searchSoCongVanDenSo(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmDocumentRecordToFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<PmlEdmDocumentRecordTo> searchSoCongVanDenSo(String loaiSoCVs, String so, boolean andOperator,int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmDocumentRecordToFinder.findDocumentRecordToAgency(loaiSoCVs, so, andOperator, start, end, obc);
	}
	
	//SO CONG VAN DEN CUA PHONG BAN
	public int searchCountSoCongVanDenPB(String keywords) throws SystemException {
		return pmlEdmDocumentRecordToFinder.countByKeywordsPB(keywords);
	}
	
	public int searchCountSoCongVanDenPB(String loaiSoCVs, String phongBan, boolean andOperator) throws SystemException{
		return pmlEdmDocumentRecordToFinder.countDocumentRecordToDepartment(loaiSoCVs, phongBan, andOperator);
	}
	
	public List<PmlEdmDocumentRecordTo> searchSoCongVanDenPB(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmDocumentRecordToFinder.findByKeywordsPB(keywords, start, end, obc);
	}
	
	public List<PmlEdmDocumentRecordTo> searchSoCongVanDenPB(String loaiSoCVs, String phongBan, boolean andOperator,int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmDocumentRecordToFinder.findDocumentRecordToDepartment(loaiSoCVs, phongBan, andOperator, start, end, obc);
	}
	// end
	// yenlt update 24082010
	protected void validateDocumentRecordTo(int pmlEdmBookDocumentRecordToSize)
	throws PortalException, SystemException {
	
		if (pmlEdmBookDocumentRecordToSize != 0) {
			throw new PmlEdmDocumentRecordToCanNotDeleteException();
		} 
	}
	
	public void removePmlEdmPrivilegeLevel(long documentRecordToId) throws SystemException, PortalException {
		List<PmlEdmBookDocumentRecordTo> pmlEdmBookDocumentRecordToList = new ArrayList<PmlEdmBookDocumentRecordTo>();
		pmlEdmBookDocumentRecordToList = PmlEdmBookDocumentRecordToUtil.findByDocumentRecordToId(documentRecordToId);
		validateDocumentRecordTo(pmlEdmBookDocumentRecordToList.size());
		pmlEdmDocumentRecordToPersistence.remove(documentRecordToId);
	}
	// end yenlt
}
