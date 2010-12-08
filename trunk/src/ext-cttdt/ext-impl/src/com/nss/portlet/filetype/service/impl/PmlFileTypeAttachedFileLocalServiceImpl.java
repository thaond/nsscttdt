package com.nss.portlet.filetype.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.filetype.NoSuchPmlFileTypeAttachedFileException;
import com.nss.portlet.filetype.model.PmlFileTypeAttachedFile;
import com.nss.portlet.filetype.service.base.PmlFileTypeAttachedFileLocalServiceBaseImpl;
import com.nss.portlet.filetype.service.persistence.PmlFileTypeAttachedFileUtil;


public class PmlFileTypeAttachedFileLocalServiceImpl
    extends PmlFileTypeAttachedFileLocalServiceBaseImpl {
	public List<PmlFileTypeAttachedFile> findByAttachedFileId (String attachedFileId) throws SystemException {
		return pmlFileTypeAttachedFilePersistence.findByAttachedFileId(attachedFileId);
	}
	
	public List<PmlFileTypeAttachedFile> findByFileTypeId (String fileTypeId) throws SystemException {
		return pmlFileTypeAttachedFilePersistence.findByFileTypeId(fileTypeId);
	}
	
	public PmlFileTypeAttachedFile findByPrimaryKey(String pmlFileTypeAttachedFileId) throws NoSuchPmlFileTypeAttachedFileException, SystemException {
			return PmlFileTypeAttachedFileUtil.findByPrimaryKey(pmlFileTypeAttachedFileId);
	}
	
}
