package com.sgs.portlet.pmllevelsend.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.pmllevelsend.PmlEdmLevelSendCanNotDeleteException;
import com.sgs.portlet.pmllevelsend.model.PmlEdmLevelSend;
import com.sgs.portlet.document.receipt.model.PmlEdmLevelSendDetail;
import com.sgs.portlet.pmllevelsend.service.impl.PmlEdmLevelSendLocalServiceImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmLevelSendDetailUtil;
import com.sgs.portlet.pmlissuingplace.model.PmlEdmIssuingPlace;
import com.sgs.portlet.pmlissuingplace.service.persistence.PmlEdmIssuingPlaceUtil;
import com.sgs.portlet.pmllevelsend.service.base.PmlEdmLevelSendLocalServiceBaseImpl;

/**
 * @author lethanhtung
 *
 */
public class PmlEdmLevelSendLocalServiceImpl
    extends PmlEdmLevelSendLocalServiceBaseImpl {

	/**
	 * get all issue place with concrete level send
	 *@param levelSendId 
	 * @return List<PmlEdmIssuingPlace> 
	 *
	 */
	public List<PmlEdmIssuingPlace> getPmlEdmIssuingPlacesWithPmlEdmLevelSend(int levelSendId) {
		List<PmlEdmIssuingPlace> resultList = new ArrayList<PmlEdmIssuingPlace>();
		
		try {
			List<PmlEdmLevelSendDetail> pmlEdmLevelSendDetailList = PmlEdmLevelSendDetailUtil.findByLevelSendId(levelSendId);
			if(pmlEdmLevelSendDetailList != null && pmlEdmLevelSendDetailList.size() > 0) {
				
				for (PmlEdmLevelSendDetail pmlEdmLevelSendDetail : pmlEdmLevelSendDetailList) {
					resultList.add(PmlEdmIssuingPlaceUtil.findByPrimaryKey(pmlEdmLevelSendDetail.getIssuingPlaceId()));
				}
			}
			
		} catch (Exception e) {
			System.out.println("ERROR: in method getPmlEdmIssuingPlacesWithPmlEdmLevelSend "+PmlEdmLevelSendLocalServiceImpl.class);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	/**
	 * get all document type with concrete documentRecordTo
	 * @param documentRecordId
	 * @return List<PmlEdmDocumentType>
	 *
	 */
	public List<PmlEdmDocumentType> getPmlEdmDocumentTypesWithPmlEdmDocumentRecordTo() {
		List<PmlEdmDocumentType> resultList = new ArrayList<PmlEdmDocumentType>();
		
		try {
		
			
		} catch (Exception e) {
			System.out.println("ERROR: in method getPmlEdmDocumentTypesWithPmlEdmDocumentRecordTo "+PmlEdmLevelSendLocalServiceImpl.class);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	
	/**
	 * get all document type with concrete document record type
	 * @param documentRecordTypeId
	 * @return List<PmlEdmDocumentType>
	 *
	 */
	public List<PmlEdmDocumentType> getPmlEdmDocumentTypeWithPmlEdmDocumentRecordType(int documentRecordTypeId){
		List<PmlEdmDocumentType> resultList = new ArrayList<PmlEdmDocumentType>();
		
		try {
			resultList = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId);
			
		} catch (Exception e) {
			System.out.println("ERROR: in method getPmlEdmDocumentTypesWithPmlEdmDocumentRecordTo "+PmlEdmLevelSendLocalServiceImpl.class);
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return resultList;
	}
	
	/**
	 * get number document receipt
	 * @param documentRecordId
	 * @return String
	 *
	 */
	public String getNumberDocumentReceipt(long documentRecordId) {
		String numberResult = null;
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return numberResult;
	}

	/**
	 * Lay tat ca level send
	 * @return
	 * @throws SystemException
	 */
	public List<PmlEdmLevelSend> getAll() 
	throws SystemException {
		try {
			return pmlEdmLevelSendPersistence.findAll();
		}
		catch (Exception ex) {
			return null;
		}
	}
	
	public List<PmlEdmLevelSend> findByLevelSendIds(
			List<Integer> levelSendIds) throws Exception {
		try {
			return pmlEdmLevelSendFinder.findByLevelSendIds(levelSendIds);
		} catch (Exception ex) {
			return null;
		}
	}
	
//	minh 20100206
	
	public int searchCount(String keywords) throws SystemException{
		return pmlEdmLevelSendFinder.countByKeywords(keywords);
	}
	
	public List<PmlEdmLevelSend> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmLevelSendFinder.findByKeywords(keywords, start, end, obc);
	}
	
//  end	
	// yenlt update 23082010
	protected void validatePmlEdmLevelSend(int documentReceiptSize, int levelSendDetailSize)
	throws PortalException, SystemException {
	
		if (documentReceiptSize != 0) {
			throw new PmlEdmLevelSendCanNotDeleteException();
		} 
		if (levelSendDetailSize != 0) {
			throw new PmlEdmLevelSendCanNotDeleteException();
		}
	}
	
	public void removePmlEdmLevelSend(int levelSendId) throws SystemException, PortalException {
		List<PmlEdmDocumentReceipt> pmlEdmDocumentReceiptList = PmlEdmDocumentReceiptUtil.findByLevelSendId(levelSendId);
		List<PmlEdmLevelSendDetail> pmlEdmLevelSendDetailList = PmlEdmLevelSendDetailUtil.findByLevelSendId(levelSendId);
		int documentReceiptSize = pmlEdmDocumentReceiptList.size();
		int levelSendDetailSize = pmlEdmLevelSendDetailList.size();
		validatePmlEdmLevelSend(documentReceiptSize, levelSendDetailSize);
		pmlEdmLevelSendPersistence.remove(levelSendId);
	}
	// end yenlt
}