package com.nss.portlet.attachedfile.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.portlet.attachedfile.AttachedFileCanNotDeleteException;
import com.nss.portlet.attachedfile.AttachedFileCodeSameCodeException;
import com.nss.portlet.attachedfile.model.AttachedFile;
import com.nss.portlet.attachedfile.service.base.AttachedFileLocalServiceBaseImpl;
import com.nss.portlet.filetype.model.PmlFileAttachedFile;
import com.nss.portlet.filetype.model.PmlFileTypeAttachedFile;
import com.nss.portlet.filetype.service.PmlFileAttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalServiceUtil;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;


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
			pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileLocalServiceUtil.findByAttachedFileId(attachedFileId);
			pmlFileAttachedFileList = PmlFileAttachedFileLocalServiceUtil.findByAttachedFileId(attachedFileId);
		} catch (Exception e) {
			
		}
		validateAttachedFile(pmlFileTypeAttachedFileList.size(), pmlFileAttachedFileList.size());
		attachedFilePersistence.remove(attachedFileId);
	}
	
	public AttachedFile addAttachedFile(String attachedFileCode, String attachedFileName, 
			String description, String active) throws SystemException, PortalException {
		validateForAdd(attachedFileCode);
		
		String attachedFileId = "";
		attachedFileId = IdTemplateLocalServiceUtil.generatedId(AttachedFile.class);
		
		AttachedFile attachedFile = attachedFilePersistence.create(attachedFileId);
		
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
		
	public AttachedFile updateAttachedFile(String attachedFileId, String attachedFileCode, String attachedFileName, 
							String description, String active) throws SystemException, PortalException {
	
		validateForUpdate(attachedFileId, attachedFileCode);
		
		AttachedFile attachedFile = attachedFilePersistence.findByPrimaryKey(attachedFileId);
		
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
