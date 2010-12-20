package com.nss.portlet.filetype.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.nss.portlet.filetype.FileTypeCanNotDeleteException;
import com.nss.portlet.filetype.FileTypeCodeSameCodeException;
import com.nss.portlet.filetype.model.PmlFileType;
import com.nss.portlet.filetype.model.PmlFileTypeAttachedFile;
import com.nss.portlet.filetype.service.PmlFileTypeAttachedFileLocalServiceUtil;
import com.nss.portlet.filetype.service.base.PmlFileTypeLocalServiceBaseImpl;
import com.nss.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoor.service.PmlOneDoorReceiveFileLocalServiceUtil;


public class PmlFileTypeLocalServiceImpl extends PmlFileTypeLocalServiceBaseImpl {
	
	public List<PmlFileType> findAll() {
		try {
			return PmlFileTypeUtil.findAll();
		} catch (SystemException e) {
			return new ArrayList<PmlFileType>();
		}
	}
	
	public int searchCount(String keywords) throws SystemException{
		return pmlFileTypeFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String fileTypeCode, String fileTypeName, boolean andOperator) throws SystemException{
		return pmlFileTypeFinder.countByFileType(fileTypeCode, fileTypeName, andOperator);
	}
	
	public List<PmlFileType> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFileTypeFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<PmlFileType> search(String fileTypeCode, String fileTypeName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFileTypeFinder.findByFileType(fileTypeCode, fileTypeName, andOperator, start, end, obc);
	}
	
	protected void validateFileType(int onedoorRecieveFileSize, int fileTypeAttachedFileSize)
	throws PortalException, SystemException {
	
		if (onedoorRecieveFileSize != 0) {
			throw new FileTypeCanNotDeleteException();
		} 
		if (fileTypeAttachedFileSize != 0) {
			throw new FileTypeCanNotDeleteException();
		} 
	}
	
	public void removePmlFileType(String fileTypeId) throws SystemException, PortalException {
		List<PmlOneDoorReceiveFile> pmlOneDoorReceiveFileList = new ArrayList<PmlOneDoorReceiveFile>();
		List<PmlFileTypeAttachedFile> pmlFileTypeAttachedFileList = new ArrayList<PmlFileTypeAttachedFile>();
		try {
			pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileLocalServiceUtil.findByFileTypeId(fileTypeId);
		} catch (Exception e) {
			
		}
		
		try {
			pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileLocalServiceUtil.findByFileTypeId(fileTypeId);
		} catch (Exception e) { }	
		validateFileType(pmlOneDoorReceiveFileList.size(), pmlFileTypeAttachedFileList.size());
		pmlFileTypePersistence.remove(fileTypeId);
	}
	
	public PmlFileType addFileType(String fileTypeCode, String fileTypeName, String fieldId, String processTime, 
			String description, String active, String currentReceiptNumber, String receiptTemplate,
			String templateId) throws SystemException, PortalException {

		validateForAdd(fileTypeCode);
		
		String fileTypeId = "";
		fileTypeId = IdTemplateLocalServiceUtil.generatedId(PmlFileType.class);
		
		PmlFileType fileType = pmlFileTypePersistence.create(fileTypeId);
		
		fileType.setFileTypeCode(fileTypeCode);
		fileType.setFileTypeName(fileTypeName);
		fileType.setFieldId(fieldId);
		fileType.setProcessTime(processTime);
		fileType.setDescription(description);
		fileType.setActive(active);
		fileType.setCurrentReceiptNumber(currentReceiptNumber);
		fileType.setReceiptTemplate(receiptTemplate);
		fileType.setTemplateId(templateId);
		
		pmlFileTypePersistence.update(fileType, false);
		
		return fileType;
	}
			
	protected void validateForAdd(String fileTypeCode) throws PortalException, SystemException {
			
		if (Validator.isNull(fileTypeCode)) {
			throw new FileTypeCodeSameCodeException();
		}
			
		List<PmlFileType> list = pmlFileTypePersistence.findByFileTypeCode(fileTypeCode.toLowerCase());
		if (!list.isEmpty()) {
			fileTypeCode = fileTypeCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (fileTypeCode.equalsIgnoreCase(list.get(idx).getFileTypeCode().trim())) {
					throw new FileTypeCodeSameCodeException();
				}
			}
		}
	}
	
	public PmlFileType updateFileType(String fileTypeId, String fileTypeCode, String fileTypeName, String fieldId, 
			String processTime,	String description, String active, String currentReceiptNumber, 
			String receiptTemplate,	String templateId) throws SystemException, PortalException {

		validateForUpdate(fileTypeId, fileTypeCode);
		
		PmlFileType fileType = pmlFileTypePersistence.findByPrimaryKey(fileTypeId);
		
		fileType.setFileTypeCode(fileTypeCode);
		fileType.setFileTypeName(fileTypeName);
		fileType.setFieldId(fieldId);
		fileType.setProcessTime(processTime);
		fileType.setDescription(description);
		fileType.setActive(active);
		fileType.setCurrentReceiptNumber(currentReceiptNumber);
		fileType.setReceiptTemplate(receiptTemplate);
		fileType.setTemplateId(templateId);
		
		pmlFileTypePersistence.update(fileType, false);
		
		return fileType;
	}
			
	protected void validateForUpdate(String fileTypeId, String fileTypeCode) throws PortalException, SystemException {
	
		if (Validator.isNull(fileTypeCode)) {
			throw new FileTypeCodeSameCodeException();
		}
		
		List<PmlFileType> list = pmlFileTypePersistence.findByFileTypeCode(fileTypeCode.toLowerCase());
		if (!list.isEmpty()) {
			fileTypeCode = fileTypeCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (fileTypeCode.equalsIgnoreCase(list.get(idx).getFileTypeCode().trim()) && 
						!list.get(idx).getFileTypeId().equals(fileTypeId)) {
					throw new FileTypeCodeSameCodeException();
				}
			}
		}
	}
	
	public List<PmlFileType> search(int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFileTypePersistence.findAll(start, end, obc);
	}
}
