package com.nss.portlet.onedoor.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.model.PmlFilePCCCAttachedFile;
import com.nss.portlet.onedoor.service.base.PmlFilePCCCAttachedFileLocalServiceBaseImpl;


public class PmlFilePCCCAttachedFileLocalServiceImpl
    extends PmlFilePCCCAttachedFileLocalServiceBaseImpl {
	
	public List<PmlFilePCCCAttachedFile> findByFilePcccId(String fileId) throws SystemException{
		return pmlFilePCCCAttachedFilePersistence.findByFilePcccId(fileId);
	}
}
