package com.nss.portlet.onedoor.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.model.PmlPaintDocument;
import com.nss.portlet.onedoor.service.base.PmlPaintDocumentLocalServiceBaseImpl;


public class PmlPaintDocumentLocalServiceImpl
    extends PmlPaintDocumentLocalServiceBaseImpl {
	
	public void removeByFileId(String fileId) throws SystemException {
		pmlPaintDocumentPersistence.removeByFileId(fileId);
	}
	
	public List<PmlPaintDocument> findByFileId(String fileId) throws SystemException {
		return pmlPaintDocumentPersistence.findByFileId(fileId);
	}
}
