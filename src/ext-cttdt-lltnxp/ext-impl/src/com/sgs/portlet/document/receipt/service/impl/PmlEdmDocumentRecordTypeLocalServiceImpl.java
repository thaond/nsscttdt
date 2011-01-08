package com.sgs.portlet.document.receipt.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.PmlEdmDocumentRecordTypeCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentRecordType;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.base.PmlEdmDocumentRecordTypeLocalServiceBaseImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;


public class PmlEdmDocumentRecordTypeLocalServiceImpl
    extends PmlEdmDocumentRecordTypeLocalServiceBaseImpl {
	
//	minh 20100206
	
	public int searchCount(String keywords) throws SystemException{
		return pmlEdmDocumentRecordTypeFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String pmlEdmDocumentRecordTypeCode, String pmlEdmDocumentRecordTypeName, boolean andOperator) throws SystemException{
		return pmlEdmDocumentRecordTypeFinder.countByPmlEdmDocumentRecordType(pmlEdmDocumentRecordTypeCode, pmlEdmDocumentRecordTypeName, andOperator);
	}
	
	public List<PmlEdmDocumentRecordType> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmDocumentRecordTypeFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<PmlEdmDocumentRecordType> search(String pmlEdmDocumentRecordTypeCode, String pmlEdmDocumentRecordTypeName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmDocumentRecordTypeFinder.findByPmlEdmDocumentRecordType(pmlEdmDocumentRecordTypeCode, pmlEdmDocumentRecordTypeName, andOperator, start, end, obc);
	}
	
//  end	
	// yenlt update 23082010
	protected void validatePmlEdmDocumentRecordType(int pmlEdmDocumentTypeSize)
	throws PortalException, SystemException {
	
		if (pmlEdmDocumentTypeSize != 0) {
			throw new PmlEdmDocumentRecordTypeCanNotDeleteException();
		} 
	}
	
	public void removePmlEdmDocumentType(int documentRecordTypeId) throws SystemException, PortalException {
		List<PmlEdmDocumentType> pmlEdmDocumentTypeList = PmlEdmDocumentTypeUtil.findByDocumentRecordTypeId(documentRecordTypeId);
		validatePmlEdmDocumentRecordType(pmlEdmDocumentTypeList.size());
		pmlEdmDocumentRecordTypePersistence.remove(documentRecordTypeId);
	}
	// end yenlt
	
	//vu update 24122010
	
	public List<PmlEdmDocumentRecordType> findByDocumentRecordTypeCode(String documentRecordTypeCode) throws SystemException{
		return pmlEdmDocumentRecordTypeFinder.findByDocumentRecordTypeCode(documentRecordTypeCode);
	}
	
	//end vu
}
