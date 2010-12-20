package com.nss.portlet.onedoor.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.model.PmlFileReturningInfo;
import com.nss.portlet.onedoor.service.base.PmlFileReturningInfoLocalServiceBaseImpl;


public class PmlFileReturningInfoLocalServiceImpl
    extends PmlFileReturningInfoLocalServiceBaseImpl {
	
	public List<PmlFileReturningInfo> findByFileId(String fileId) throws SystemException {
		return pmlFileReturningInfoPersistence.findByFileId(fileId);
	}
}
