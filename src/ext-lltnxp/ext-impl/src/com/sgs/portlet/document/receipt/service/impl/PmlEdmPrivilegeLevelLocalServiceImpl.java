package com.sgs.portlet.document.receipt.service.impl;

import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.PmlEdmPrivilegeLevelCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;
import com.sgs.portlet.document.receipt.service.base.PmlEdmPrivilegeLevelLocalServiceBaseImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;


public class PmlEdmPrivilegeLevelLocalServiceImpl
    extends PmlEdmPrivilegeLevelLocalServiceBaseImpl {
//	minh 20100206
	
	public int searchCount(String keywords) throws SystemException{
		return pmlEdmPrivilegeLevelFinder.countByKeywords(keywords);
	}
	
	public List<PmlEdmPrivilegeLevel> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmPrivilegeLevelFinder.findByKeywords(keywords, start, end, obc);
	}
	
//  end	
	// yenlt update 23082010
	protected void validatePmlEdmPrivilegeLevel(int documentReceiptSize)
	throws PortalException, SystemException {
	
		if (documentReceiptSize != 0) {
			throw new PmlEdmPrivilegeLevelCanNotDeleteException();
		} 
	}
	
	public void removePmlEdmPrivilegeLevel(String privilegeLevelId) throws SystemException, PortalException {
		List<PmlEdmDocumentReceipt> pmlEdmDocumentReceiptList = PmlEdmDocumentReceiptUtil.findByPrivilegeLevelId(privilegeLevelId);
		validatePmlEdmPrivilegeLevel(pmlEdmDocumentReceiptList.size());
		pmlEdmPrivilegeLevelPersistence.remove(privilegeLevelId);
	}
	// end yenlt
	
}
