package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.model.PmlStateProcess;
import com.nss.portlet.onedoor.service.base.PmlStateProcessLocalServiceBaseImpl;


public class PmlStateProcessLocalServiceImpl
    extends PmlStateProcessLocalServiceBaseImpl {
	
	public List<PmlStateProcess> findByStateProcessIds(
			List<Long> stateProcessIds) throws Exception {
		return pmlStateProcessFinder.findByStateProcessIds(stateProcessIds);
	}
	
	public List<PmlStateProcess> findByStateProcessCode(String stateProcessCode) throws SystemException{
			return pmlStateProcessPersistence.findByStateProcessCode(stateProcessCode);
		
	}
	
	public List<PmlStateProcess> findByStateProcessCode_Name(String stateProcessCode, String typeWorkflow) throws SystemException{
			return pmlStateProcessPersistence.findByStateProcessCode_Name(stateProcessCode, typeWorkflow);
	}
	public List<PmlStateProcess> findByStateProcessName(String typeWorkflow) throws SystemException{
			return pmlStateProcessPersistence.findByStateProcessName(typeWorkflow);
	}
	
	public List<PmlStateProcess> findByFileStatusId(long fileStatusId) {
		try {
			return pmlStateProcessPersistence.findByFileStatusId(fileStatusId);
		} catch (SystemException e) {
			return new ArrayList<PmlStateProcess>();
		}
	}
}
