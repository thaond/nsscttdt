package com.sgs.portlet.document.send.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.send.PmlEdmBookDocumentSendCanNotDeleteException;
import com.sgs.portlet.document.send.model.PmlEdmBookDocumentSend;
import com.sgs.portlet.document.send.model.PmlEdmWriteDocumentSend;
import com.sgs.portlet.document.send.service.base.PmlEdmBookDocumentSendLocalServiceBaseImpl;
import com.sgs.portlet.document.send.service.persistence.PmlEdmBookDocumentSendUtil;
import com.sgs.portlet.document.send.service.persistence.PmlEdmWriteDocumentSendUtil;


/**
 * @author lethanhtung
 *
 */
public class PmlEdmBookDocumentSendLocalServiceImpl extends PmlEdmBookDocumentSendLocalServiceBaseImpl {
	
	/**
	 * this method get PmlEdmBookDocumentSend object by year in use, departmentID and documentRecordTypeId
	 * Use when book document send for department
	 * @param yearInUse : năm sử dụng
	 * @param departmentsId : ID của phòng ban
	 * @param documentRecordTypeId : ID của lọai sổ công văn
	 * @return PmlEdmBookDocumentSend object
	 * 
	 */
	public PmlEdmBookDocumentSend getBookDocumentSend(String yearInUse, String departmentsId, int documentRecordTypeId) {
		
		PmlEdmBookDocumentSend retValue = null;
		List<PmlEdmBookDocumentSend> list = null;
		
		if (yearInUse == null || departmentsId == null) {
			return retValue;
		} else {
			try {
				list = PmlEdmBookDocumentSendUtil.findByDepartDocYear(yearInUse, departmentsId, documentRecordTypeId);
				
				if (list != null && list.size() > 0) {
					retValue = list.get(0);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	/**
	 * this method get PmlEdmBookDocumentSend object by departmentsId, documentRecordTypeId and agencyId
	 * @param departmentsId : ID của phòng ban
	 * @param documentRecordTypeId : ID của lọai công văn
	 * @param agencyId : ID của cơ quan (đơn vị)
	 * @return PmlEdmBookDocumentSend object
	 * 
	 */
	public PmlEdmBookDocumentSend getBookDocumentSend(String departmentsId, int documentRecordTypeId, String agencyId) {
		
		PmlEdmBookDocumentSend retValue = null;
		List<PmlEdmBookDocumentSend> list = null;
		
		if (departmentsId == null || agencyId == null) {
			return retValue;
		} else {
			try {
				list = PmlEdmBookDocumentSendUtil.findByDepartDocAgency(agencyId, departmentsId, documentRecordTypeId);
				
				if (list != null && list.size() > 0) {
					retValue = list.get(0);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	/**
	 * this method get PmlEdmBookDocumentSend object by agencyId, yearInUse and documentRecordTypeId
	 * Use when book document send for service office (service office : sở)
	 * @param agencyId : ID của cơ quan (đơn vị)
	 * @param yearInUse : năm sử dụng
	 * @param documentRecordTypeId : ID của lọai sổ công văn
	 * @return PmlEdmBookDocumentSend object
	 * 
	 */
	public PmlEdmBookDocumentSend getBookDocumentSendBy_AgencyId_YearInUse_DocumentRecordTypeId 
										(String agencyId, String yearInUse, int documentRecordTypeId) {
		
		PmlEdmBookDocumentSend retValue = null;
		List<PmlEdmBookDocumentSend> list = null;
		
		if (agencyId == null || yearInUse == null) {
			return retValue;
		} else {
			try {
				list = PmlEdmBookDocumentSendUtil.findByAgencyId_YearInUse_DocumentRecordTypeId(agencyId, yearInUse, documentRecordTypeId);
				
				if (list != null && list.size() > 0) {
					retValue = list.get(0);
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return retValue;
	}
	
	/**
	 * this method get id of DocumentRecordType object by documentTypeId
	 * DocumentRecordType : lọai sổ công văn
	 * @param documentTypeId : ID của lọai công văn
	 * @return integer
	 * 
	 */
	public int getDocumentRecordTypeIdByDocumentType (long documentTypeId) {
		
		int retValue = 0;
		
		try {
			PmlEdmDocumentType documentType = PmlEdmDocumentTypeUtil.findByPrimaryKey(documentTypeId);
			
			if (documentType != null) {
				int documentRecordTypeId = documentType.getDocumentRecordTypeId();
				retValue = documentRecordTypeId;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	
	// phmphuc 24/05/2010
	// SO CONG VAN DI CUA SO
	public int searchCountSoCongVanDiSo(String keywords) throws SystemException {
		return pmlEdmBookDocumentSendFinder.countByKeywords(keywords);
	}
	
	public int searchCountSoCongVanDiSo(String loaiSoCVs, String so, boolean andOperator) throws SystemException{
		return pmlEdmBookDocumentSendFinder.countDocumentRecordToAgency(loaiSoCVs, so, andOperator);
	}
	
	public List<PmlEdmBookDocumentSend> searchSoCongVanDiSo(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmBookDocumentSendFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<PmlEdmBookDocumentSend> searchSoCongVanDiSo(String loaiSoCVs, String so, boolean andOperator,int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmBookDocumentSendFinder.findDocumentRecordToAgency(loaiSoCVs, so, andOperator, start, end, obc);
	}
	
	//SO CONG VAN DI CUA PHONG BAN
	public int searchCountSoCongVanDiPB(String keywords) throws SystemException {
		return pmlEdmBookDocumentSendFinder.countByKeywordsPB(keywords);
	}
	
	public int searchCountSoCongVanDiPB(String loaiSoCVs, String phongBan, boolean andOperator) throws SystemException{
		return pmlEdmBookDocumentSendFinder.countDocumentRecordToDepartment(loaiSoCVs, phongBan, andOperator);
	}
	
	public List<PmlEdmBookDocumentSend> searchSoCongVanDiPB(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmBookDocumentSendFinder.findByKeywordsPB(keywords, start, end, obc);
	}
	
	public List<PmlEdmBookDocumentSend> searchSoCongVanDiPB(String loaiSoCVs, String phongBan, boolean andOperator,int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmBookDocumentSendFinder.findDocumentRecordToDepartment(loaiSoCVs, phongBan, andOperator, start, end, obc);
	}
	// yenlt update 24082010
	protected void validatePmlEdmBookDocumentSend(int pmlEdmWriteDocumentSendSize)
	throws PortalException, SystemException {
	
		if (pmlEdmWriteDocumentSendSize != 0) {
			throw new PmlEdmBookDocumentSendCanNotDeleteException();
		} 
	}
	
	public void removePmlEdmPrivilegeLevel(long bookDocumentSendId) throws SystemException, PortalException {
		List<PmlEdmWriteDocumentSend> pmlEdmWriteDocumentSendList = new ArrayList<PmlEdmWriteDocumentSend>();
		pmlEdmWriteDocumentSendList = PmlEdmWriteDocumentSendUtil.findByBookDocumentSendId(bookDocumentSendId);
		validatePmlEdmBookDocumentSend(pmlEdmWriteDocumentSendList.size());
		pmlEdmBookDocumentSendPersistence.remove(bookDocumentSendId);
	}
	// end yenlt
}
