package com.sgs.portlet.document.receipt.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.PmlEdmDocumentRecordTypeCanNotDeleteException;
import com.sgs.portlet.document.receipt.PmlEdmDocumentTypeCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentReceipt;
import com.sgs.portlet.document.receipt.model.PmlEdmDocumentType;
import com.sgs.portlet.document.receipt.service.base.PmlEdmDocumentTypeLocalServiceBaseImpl;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentReceiptUtil;
import com.sgs.portlet.document.receipt.service.persistence.PmlEdmDocumentTypeUtil;
import com.sgs.portlet.document.send.model.PmlEdmDocumentSend;
import com.sgs.portlet.document.send.service.persistence.PmlEdmDocumentSendUtil;

public class PmlEdmDocumentTypeLocalServiceImpl
    extends PmlEdmDocumentTypeLocalServiceBaseImpl {
	
//	minh 20100207
	
	public int searchCount(String keywords) throws SystemException{
		return pmlEdmDocumentTypeFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String pmlEdmDocumentTypeName, String pmlEdmDocumentRecordTypeName, boolean andOperator) throws SystemException{
		return pmlEdmDocumentTypeFinder.countByPmlEdmDocumentType(pmlEdmDocumentTypeName, pmlEdmDocumentRecordTypeName, andOperator);
	}
	
	public List<PmlEdmDocumentType> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmDocumentTypeFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<PmlEdmDocumentType> search(String pmlEdmDocumentTypeName, String pmlEdmDocumentRecordTypeName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmDocumentTypeFinder.findByPmlEdmDocumentType(pmlEdmDocumentTypeName, pmlEdmDocumentRecordTypeName, andOperator, start, end, obc);
	}
	
//  end	

	/**
	 * Lay ve danh sach cap gui theo danh sach ma so dua vao
	 */
	public List<PmlEdmDocumentType> findByDocumentTypeIds(
			List<Long> documentTypeIds) throws Exception {
		try {
			return pmlEdmDocumentTypeFinder.findByDocumentTypeIds(documentTypeIds);
		} catch (Exception ex) {
			return null;
        }
	}
	// yenlt update 23082010
	protected void validatePmlEdmDocumentType(int documentReceiptSize, int documentSendSize)
	throws PortalException, SystemException {
	
		if (documentReceiptSize != 0) {
			throw new PmlEdmDocumentTypeCanNotDeleteException();
		} 
		if (documentSendSize != 0) {
			throw new PmlEdmDocumentTypeCanNotDeleteException();
		} 
	}
	
	public void removePmlEdmDocumentType(long documentTypeId) throws SystemException, PortalException {
		List<PmlEdmDocumentReceipt> pmlEdmDocumentReceiptList = PmlEdmDocumentReceiptUtil.findByDocumentTypeId(documentTypeId);
		List<PmlEdmDocumentSend> pmlEdmDocumentSendList = PmlEdmDocumentSendUtil.findByDocumentTypeId(documentTypeId);
		validatePmlEdmDocumentType(pmlEdmDocumentReceiptList.size(), pmlEdmDocumentSendList.size());
		pmlEdmDocumentTypePersistence.remove(documentTypeId);
	}
	// end yenlt
	
	/**
	 * Lay danh sach loai van ban theo doi tuong su dung - 11/11/2010
	 * la cho van ban di, van ban den hoac ca 2
	 */
	
	public List<PmlEdmDocumentType> getDocType(int get1, int get2) throws SystemException {
		
		List<PmlEdmDocumentType> lst1 = new ArrayList<PmlEdmDocumentType>();
		List<PmlEdmDocumentType> lst2 = new ArrayList<PmlEdmDocumentType>();
		List<PmlEdmDocumentType> lst = new ArrayList<PmlEdmDocumentType>();
		
		try{
			lst1 = PmlEdmDocumentTypeUtil.findBySendReceiptDistinction(get1);
			lst2 = PmlEdmDocumentTypeUtil.findBySendReceiptDistinction(get2);
			lst.addAll(lst1);
			lst.addAll(lst2);
			
			if (!lst.isEmpty()) {
				Collections.sort(lst, new Comparator<PmlEdmDocumentType>(){
					public int compare(PmlEdmDocumentType obj1, PmlEdmDocumentType obj2) {   
						return obj1.getDocumentTypeName().compareTo(obj2.getDocumentTypeName());
					}                                        
				});
			}
		}
		catch (Exception e){
			return lst;
		}
		return lst;
	}
}
