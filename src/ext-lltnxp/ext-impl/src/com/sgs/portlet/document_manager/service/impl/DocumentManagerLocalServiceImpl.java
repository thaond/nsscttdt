package com.sgs.portlet.document_manager.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document_manager.model.AttactFileDocument;
import com.sgs.portlet.document_manager.model.DocumentManager;
import com.sgs.portlet.document_manager.service.base.DocumentManagerLocalServiceBaseImpl;


public class DocumentManagerLocalServiceImpl extends DocumentManagerLocalServiceBaseImpl {
	
	public List<AttactFileDocument> getAttactFileDocuments(long documentManagerId) throws SystemException{
		return documentManagerPersistence.getAttactFileDocuments(documentManagerId);
	}
	
//	public int countDocumentManager(String documentManagerCodes, String documentManagerCategorys, String documentManagerDescriptions, String documentManagerTitles, String documentManagerStyles, boolean andOperator) throws SystemException{
//		return documentManagerFinder.count_document_manager(documentManagerCodes, documentManagerCategorys, documentManagerDescriptions, documentManagerTitles, documentManagerStyles, andOperator);
//	}
//	
//	public List<DocumentManager> findDocumentManager(String documentManagerCodes, String documentManagerCategorys, String documentManagerDescriptions, String documentManagerTitles, String documentManagerStyles, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
//		return documentManagerFinder.find_document_manager(documentManagerCodes, documentManagerCategorys, documentManagerDescriptions, documentManagerTitles, documentManagerStyles, start, end, andOperator, obc);
//	}
	
	public int countDocumentManagerTest(String documentManagerCodes, String documentManagerCategorys, String documentManagerDescriptions, String documentManagerTitles, String documentManagerStyles, String dateFrom, String dateTo, boolean andOperator) throws SystemException{
		return documentManagerFinder.count_document_manager_test(documentManagerCodes, documentManagerCategorys, documentManagerDescriptions, documentManagerTitles, documentManagerStyles, dateFrom, dateTo, andOperator);
	}
	
	public List<DocumentManager> findDocumentManagerTest(String documentManagerCodes, String documentManagerCategorys, String documentManagerDescriptions, String documentManagerTitles, String documentManagerStyles, String dateFrom, String dateTo, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return documentManagerFinder.find_document_manager_test(documentManagerCodes, documentManagerCategorys, documentManagerDescriptions, documentManagerTitles, documentManagerStyles, dateFrom, dateTo, start, end, andOperator, obc);
	}
}
