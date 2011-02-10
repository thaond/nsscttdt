package com.sgs.portlet.document.receipt.service.impl;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.sgs.portlet.document.receipt.PmlFileStatusStateProcessCanNotDeleteException;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.PmlFileStatusStateProcessLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.base.PmlFileStatusStateProcessLocalServiceBaseImpl;


public class PmlFileStatusStateProcessLocalServiceImpl
    extends PmlFileStatusStateProcessLocalServiceBaseImpl {
	// yenlt update 24082010
	protected void validateFileStatusStateProcess(PmlFileStatusStateProcess fileStatusStateProcess)
	throws PortalException, SystemException {
	
		if (null == fileStatusStateProcess) {
			throw new PmlFileStatusStateProcessCanNotDeleteException();
		} 
	}
	
	public void removeFileStatusStateProcess(long filestatusStateProcessId) throws SystemException, PortalException {
		PmlFileStatusStateProcess fileStatusStateProcess = null;
		fileStatusStateProcess = PmlFileStatusStateProcessLocalServiceUtil.getPmlFileStatusStateProcess(filestatusStateProcessId);
		validateFileStatusStateProcess(fileStatusStateProcess);
		pmlFileStatusStateProcessPersistence.remove(fileStatusStateProcess);
	}
	// end yenlt 
}
