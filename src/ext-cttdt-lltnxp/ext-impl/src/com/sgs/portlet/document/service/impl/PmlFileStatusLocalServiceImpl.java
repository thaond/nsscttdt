package com.sgs.portlet.document.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.document.PmlFileStatusCanNotDeleteException;
import com.sgs.portlet.document.PmlFileStatusCodeSameCodeException;
import com.sgs.portlet.document.model.PmlFileStatus;
import com.sgs.portlet.document.receipt.model.PmlFileStatusStateProcess;
import com.sgs.portlet.document.receipt.service.persistence.PmlFileStatusStateProcessUtil;
import com.sgs.portlet.document.service.base.PmlFileStatusLocalServiceBaseImpl;

/**
 * 
 * @author XUAN CONG
 *
 */
public class PmlFileStatusLocalServiceImpl
    extends PmlFileStatusLocalServiceBaseImpl {

	/**
	 * Danh sach tinh trang cong van theo loai
	 * @author XUAN CONG
	 * @param type 1: cong van, 0: ho so
	 * @return Danh sach
	 * @throws SystemException
	 */
	public List<PmlFileStatus> findByType(
			String type) 
	throws SystemException {
		try {
			// Mac dinh lay ra danh sach cong van
			if (type == null) {
				type = "1";
			}
			type = type.trim();
			if (!type.equals("0")) {
				type = "1";
			}
			return pmlFileStatusPersistence.findByType(type);
		}
		catch (Exception ex) {
			return null;
		}
	}
	/**
	 * Yen update 05/04/2010
	 * @param keywords 
	 * @throws SystemException 
	 */
	public int searchCountCV(String keywords) throws SystemException{
		return pmlFileStatusFinder.countByKeywordsCV(keywords);
	}
	
	public int searchCountCV(String fileStatusCode, String fileStatusName, boolean andOperator) throws SystemException{
		return pmlFileStatusFinder.countByMA_TEN_CV(fileStatusCode, fileStatusName, andOperator);
	}
	
	public List<PmlFileStatus> searchCV(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFileStatusFinder.findByKeywordsCV(keywords, start, end, obc);
	}
	
	public List<PmlFileStatus> searchCV(String fileStatusCode, String fileStatusName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFileStatusFinder.findByMA_TEN_CV(fileStatusCode, fileStatusName, andOperator, start, end, obc);
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
	//end update 05/04/2010
	// yenlt update 24082010
	protected void validateFileStatus(int pFSSPlistSize)
	throws PortalException, SystemException {
	
		if (pFSSPlistSize != 0) {
			throw new PmlFileStatusCanNotDeleteException();
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
	// end yenlt 
	
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
}