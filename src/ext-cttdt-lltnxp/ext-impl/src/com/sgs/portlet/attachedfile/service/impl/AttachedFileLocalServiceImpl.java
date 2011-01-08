package com.sgs.portlet.attachedfile.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.attachedfile.AttachedFileCanNotDeleteException;
import com.sgs.portlet.attachedfile.AttachedFileCodeSameCodeException;
import com.sgs.portlet.attachedfile.model.AttachedFile;
import com.sgs.portlet.attachedfile.service.base.AttachedFileLocalServiceBaseImpl;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.onedoor.model.PmlFileAttachedFile;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;
import com.sgs.portlet.onedoor.service.persistence.PmlFileAttachedFileUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlFileTypeAttachedFileUtil;
/**
 * 
 * @author Yenlt 28/01/2010
 *
 */

public class AttachedFileLocalServiceImpl
    extends AttachedFileLocalServiceBaseImpl {
	
	public List<AttachedFile> search(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return attachedFileFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<AttachedFile> search(String code, String name, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return attachedFileFinder.findTEN_MA(code, name, andOperator, start, end, obc);
	}
	
	public int searchCount(String keywords) throws SystemException{
		return attachedFileFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String code, String name, boolean andOperator) throws SystemException{
		return attachedFileFinder.countByTEN_MA(code, name, andOperator);
	}
	// yenlt update 24082010
	protected void validateAttachedFile(int fileTypeAttachedFileSize, int fileAttachedFileSize)
	throws PortalException, SystemException {
	
		if (fileTypeAttachedFileSize != 0) {
			throw new AttachedFileCanNotDeleteException();
		} 
		if (fileAttachedFileSize != 0) {
			throw new AttachedFileCanNotDeleteException();
		} 
	}
	
	public void removeAttachedFile(String attachedFileId) throws SystemException, PortalException {
		List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFileList = new ArrayList<PmlFileTypeAttachedFile>();
		List<PmlFileAttachedFile> pmlFileAttachedFileList = new ArrayList<PmlFileAttachedFile>();
		try {
			pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileUtil.findByAttachedFileId(attachedFileId);
			pmlFileAttachedFileList = PmlFileAttachedFileUtil.findByAttachedFileId(attachedFileId);
		} catch (Exception e) {
			
		}
		validateAttachedFile(pmlFileTypeAttachedFileList.size(), pmlFileAttachedFileList.size());
		attachedFilePersistence.remove(attachedFileId);
	}
	// end yenlt 
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma ho so dinh kem khi them moi
	 */
	public AttachedFile addAttachedFile(String attachedFileCode, String attachedFileName, 
						String description, String active) throws SystemException, PortalException {

		// Check inputted value
		validateForAdd(attachedFileCode);
		
		String attachedFileId = "";
		try {
			attachedFileId = IdTemplateServiceUtil.generatedId(PmlFileAttachedFile.class);
		} catch (RemoteException e) { }
		
		AttachedFile attachedFile = attachedFilePersistence.create(attachedFileId);

		// Set properties value
		attachedFile.setAttachedFileCode(attachedFileCode);
		attachedFile.setAttachedFileName(attachedFileName);
		attachedFile.setDescription(description);
		attachedFile.setActive(active);
		
		attachedFilePersistence.update(attachedFile, false);

		return attachedFile;
	}
	
	protected void validateForAdd(String attachedFileCode) throws PortalException, SystemException {
		
		if (Validator.isNull(attachedFileCode)) {
			throw new AttachedFileCodeSameCodeException();
		}
		
		List<AttachedFile> list = attachedFilePersistence.findByAttachedFileCode(attachedFileCode.toLowerCase());
		if (!list.isEmpty()) {
			attachedFileCode = attachedFileCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (attachedFileCode.equalsIgnoreCase(list.get(idx).getAttachedFileCode().trim())) {
					throw new AttachedFileCodeSameCodeException();
				}
			}
		}
	}
	
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma ho so dinh kem khi chinh sua
	 */
	public AttachedFile updateAttachedFile(String attachedFileId, String attachedFileCode, String attachedFileName, 
									String description, String active) throws SystemException, PortalException {

		// Checking inputted values
		validateForUpdate(attachedFileId, attachedFileCode);

		AttachedFile attachedFile = attachedFilePersistence.findByPrimaryKey(attachedFileId);

		// Updated properties
		attachedFile.setAttachedFileCode(attachedFileCode);
		attachedFile.setAttachedFileName(attachedFileName);
		attachedFile.setDescription(description);
		attachedFile.setActive(active);
		
		attachedFilePersistence.update(attachedFile, false);

		return attachedFile;
	}
	
	protected void validateForUpdate(String attachedFileId, String attachedFileCode) throws PortalException, SystemException {
		
		if (Validator.isNull(attachedFileCode)) {
			throw new AttachedFileCodeSameCodeException();
		}

		List<AttachedFile> list  = attachedFilePersistence.findByAttachedFileCode(attachedFileCode.toLowerCase());
		if (!list.isEmpty()) {
			attachedFileCode = attachedFileCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (attachedFileCode.equalsIgnoreCase(list.get(idx).getAttachedFileCode().trim()) && 
						!list.get(idx).getAttachedFileId().equals(attachedFileId)) {
					throw new AttachedFileCodeSameCodeException();
				}
			}
		}
	}
}
