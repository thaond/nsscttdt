package com.nss.portlet.filetype.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.filetype.model.PmlFileAttachedFile;
import com.nss.portlet.filetype.service.base.PmlFileAttachedFileLocalServiceBaseImpl;


public class PmlFileAttachedFileLocalServiceImpl
    extends PmlFileAttachedFileLocalServiceBaseImpl {
	public List<PmlFileAttachedFile> findByAttachedFileId (String attachedFileId) throws SystemException {
		return pmlFileAttachedFilePersistence.findByAttachedFileId(attachedFileId);
	}
}
