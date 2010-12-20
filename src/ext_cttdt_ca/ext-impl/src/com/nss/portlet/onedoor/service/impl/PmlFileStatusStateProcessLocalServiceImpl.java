package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.PmlFileStatusStateProcessCanNotDeleteException;
import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;
import com.nss.portlet.onedoor.service.PmlFileStatusStateProcessLocalServiceUtil;
import com.nss.portlet.onedoor.service.base.PmlFileStatusStateProcessLocalServiceBaseImpl;
import com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessUtil;


public class PmlFileStatusStateProcessLocalServiceImpl
    extends PmlFileStatusStateProcessLocalServiceBaseImpl {
	
	public void removeFileStatusStateProcess(long filestatusStateProcessId) throws SystemException, PortalException {
		PmlFileStatusStateProcess fileStatusStateProcess = null;
		fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.getPmlFileStatusStateProcess(filestatusStateProcessId);
		validateFileStatusStateProcess(fileStatusStateProcess);
		pmlFileStatusStateProcessPersistence.remove(fileStatusStateProcess);
	}
	
	protected void validateFileStatusStateProcess(PmlFileStatusStateProcess fileStatusStateProcess)
	throws PortalException, SystemException {
	
		if (null == fileStatusStateProcess) {
			throw new PmlFileStatusStateProcessCanNotDeleteException();
		} 
	}
	
	
	public List<PmlFileStatusStateProcess> findByFileStatusId(long filestatusId) throws SystemException{
			return pmlFileStatusStateProcessPersistence.findByFileStatusId(filestatusId);
		
	}
	
	public List<PmlFileStatusStateProcess> findByFileStatus_StateProcess(long fileStatusId, long stateProcessIdChooice) throws SystemException{
			return pmlFileStatusStateProcessPersistence.findByFileStatus_StateProcess(fileStatusId, stateProcessIdChooice);
	}
	
	public List<PmlFileStatusStateProcess> findByStateProcessId(long stateProcessId) throws SystemException {
		return pmlFileStatusStateProcessPersistence.findByStateProcessId(stateProcessId);
	}
	
}
