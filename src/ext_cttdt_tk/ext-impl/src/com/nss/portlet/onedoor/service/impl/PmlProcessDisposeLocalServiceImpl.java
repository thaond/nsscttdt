package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.model.PmlProcessDispose;
import com.nss.portlet.onedoor.service.base.PmlProcessDisposeLocalServiceBaseImpl;


public class PmlProcessDisposeLocalServiceImpl
    extends PmlProcessDisposeLocalServiceBaseImpl {
	
	public List<PmlProcessDispose> findByFileId(String fileId) throws SystemException {
		return pmlProcessDisposePersistence.findByFileId(fileId);
	}
	
	public List<PmlProcessDispose> findByFileId_Transition(String fileId, int transition) {
		try {
			return pmlProcessDisposePersistence.findByFileId_Transition(fileId, transition);
		} catch (SystemException e) {
			return new ArrayList<PmlProcessDispose>();
		}
	}
	
	public List<PmlProcessDispose> findByStateProcessIdBefore(long stateProcessIdBefore) {
		try {
			return pmlProcessDisposePersistence.findByStateProcessIdBefore(stateProcessIdBefore);
		} catch (SystemException e) {
			return new ArrayList<PmlProcessDispose>();
		}
	}
}
