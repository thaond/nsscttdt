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
	
	public int countDocumentManager(String documentManagerCodes, String documentManagerDescriptions, String documentManagerTitles, boolean andOperator) throws SystemException{
		return documentManagerFinder.count_document_manager(documentManagerCodes, documentManagerDescriptions, documentManagerTitles, andOperator);
	}
	
	public List<DocumentManager> findDocumentManager(String documentManagerCodes, String documentManagerDescriptions, String documentManagerTitles, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return documentManagerFinder.find_document_manager(documentManagerCodes, documentManagerDescriptions, documentManagerTitles, start, end, andOperator, obc);
	}
}
