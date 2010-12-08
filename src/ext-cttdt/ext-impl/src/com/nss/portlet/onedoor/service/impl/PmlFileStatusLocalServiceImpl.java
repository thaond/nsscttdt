package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.portlet.onedoor.PmlFileStatusCanNotDeleteException;
import com.nss.portlet.onedoor.PmlFileStatusCodeSameCodeException;
import com.nss.portlet.onedoor.model.PmlFileStatus;
import com.nss.portlet.onedoor.model.PmlFileStatusStateProcess;
import com.nss.portlet.onedoor.service.base.PmlFileStatusLocalServiceBaseImpl;
import com.nss.portlet.onedoor.service.persistence.PmlFileStatusStateProcessUtil;


public class PmlFileStatusLocalServiceImpl
    extends PmlFileStatusLocalServiceBaseImpl {
	
	/*
	 * phmphuc create 08/09/2010
	 * kiem tra ma trang thai ho so khi them moi
	 */
	public PmlFileStatus addFileStatus(String fileStatusCode, String fileStatusName, String description, 
											String active, String type) throws SystemException, PortalException {

		// Check inputted value
		validateForAdd(fileStatusCode, type);
		
		long fileStatusId = 0;
		try {
			fileStatusId = CounterLocalServiceUtil.increment();
		} catch (SystemException e) { }
		
		PmlFileStatus fileStatus = pmlFileStatusPersistence.create(fileStatusId);

		// Set properties value
		fileStatus.setFileStatusCode(fileStatusCode);
		fileStatus.setFileStatusName(fileStatusName);
		fileStatus.setDescription(description);
		fileStatus.setActive(active);
		fileStatus.setType(type);
		
		pmlFileStatusPersistence.update(fileStatus, false);

		return fileStatus;
	}
	
	protected void validateForAdd(String fileStatusCode, String type) throws PortalException, SystemException {
		
		if (Validator.isNull(fileStatusCode)) {
			throw new PmlFileStatusCodeSameCodeException();
		}
		
		List<PmlFileStatus> list = pmlFileStatusPersistence.findByFileStatusCode(fileStatusCode.toLowerCase());
		
		if (!list.isEmpty()) {
			fileStatusCode = fileStatusCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (fileStatusCode.equalsIgnoreCase(list.get(idx).getFileStatusCode().trim())
						&& type.equals(list.get(idx).getType())) {
					throw new PmlFileStatusCodeSameCodeException();
				}
			}
		}
	}
	
	public void removeFileStatus(long fileStatusId) throws SystemException, PortalException {
		List<PmlFileStatusStateProcess> pFSSPlist = new ArrayList<PmlFileStatusStateProcess>();
		try {
			pFSSPlist = PmlFileStatusStateProcessUtil.findByFileStatusId(fileStatusId);
		} catch (Exception e) {
			pFSSPlist = new ArrayList<PmlFileStatusStateProcess>();
		}
		
		validateFileStatus(pFSSPlist.size());
		pmlFileStatusPersistence.remove(fileStatusId);
	}
	
	protected void validateFileStatus(int pFSSPlistSize)
	throws PortalException, SystemException {
	
		if (pFSSPlistSize != 0) {
			throw new PmlFileStatusCanNotDeleteException();
		} 
	}
	
	/*
	 * phmphuc create 08/09/2010
	 * kiem tra ma trang thai ho so khi chinh sua
	 */
	public PmlFileStatus updateFileStatus(long fileStatusId, String fileStatusCode, String fileStatusName, String description, 
											String active, String type) throws SystemException, PortalException {

		// Checking inputted values
		validateForUpdate(fileStatusId, fileStatusCode, type);

		PmlFileStatus fileStatus = pmlFileStatusPersistence.findByPrimaryKey(fileStatusId);

		// Updated properties
		fileStatus.setFileStatusCode(fileStatusCode);
		fileStatus.setFileStatusName(fileStatusName);
		fileStatus.setDescription(description);
		fileStatus.setActive(active);
		fileStatus.setType(type);
		
		pmlFileStatusPersistence.update(fileStatus, false);

		return fileStatus;
	}
	
	protected void validateForUpdate(long fileStatusId, String fileStatusCode, String type) throws PortalException, SystemException {
		
		if (Validator.isNull(fileStatusCode)) {
			throw new PmlFileStatusCodeSameCodeException();
		}

		List<PmlFileStatus> list = pmlFileStatusPersistence.findByFileStatusCode(fileStatusCode.toLowerCase());
		if (!list.isEmpty()) {
			fileStatusCode = fileStatusCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (fileStatusCode.equalsIgnoreCase(list.get(idx).getFileStatusCode().trim()) 
					&& type.equals(list.get(idx).getType())
					&& list.get(idx).getFileStatusId() != fileStatusId) {
					throw new PmlFileStatusCodeSameCodeException();
				}
			}
		}
	}
	
	public int searchCountMC(String keywords) throws SystemException{
		return pmlFileStatusFinder.countByKeywordsMC(keywords);
	}
	
	public int searchCountMC(String fileStatusCode, String fileStatusName, boolean andOperator) throws SystemException{
		return pmlFileStatusFinder.countByMA_TEN_MC(fileStatusCode, fileStatusName, andOperator);
	}
	
	public List<PmlFileStatus> searchMC(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFileStatusFinder.findByKeywordsMC(keywords, start, end, obc);
	}
	
	public List<PmlFileStatus> searchMC(String fileStatusCode, String fileStatusName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFileStatusFinder.findByMA_TEN_MC(fileStatusCode, fileStatusName, andOperator, start, end, obc);
	}
}
