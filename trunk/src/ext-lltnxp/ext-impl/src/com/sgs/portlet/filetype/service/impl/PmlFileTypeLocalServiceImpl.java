package com.sgs.portlet.filetype.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.persistence.PmlFieldUtil;
import com.sgs.portlet.filetype.FileTypeCanNotDeleteException;
import com.sgs.portlet.filetype.FileTypeCodeSameCodeException;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.base.PmlFileTypeLocalServiceBaseImpl;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.onedoor.model.PmlFileTypeAttachedFile;
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoor.service.persistence.PmlFileTypeAttachedFileUtil;
import com.sgs.portlet.onedoor.service.persistence.PmlOneDoorReceiveFileUtil;
import com.sgs.portlet.pmluser.model.PmlUser;
import com.sgs.portlet.pmluser.service.persistence.PmlUserUtil;


public class PmlFileTypeLocalServiceImpl extends PmlFileTypeLocalServiceBaseImpl {
//	yenlt 05/04/2010
	
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
	
//  end	
	/**
	 * Lay danh sach loai ho so thong qua ma linh vuc ho so
	 * @author Hai Trieu
	 */
	public List<PmlFileType> getListFileTypeByFieldId(String fieldId)
		throws SystemException, PortalException {
		List<PmlFileType> resultList = new ArrayList<PmlFileType>();
			try {
				resultList = pmlFileTypeFinder.getListFileTypeByFieldId(fieldId);
			}catch (Exception e) {
				return null;
			}
		return resultList;
	}
	
	

	/**
	 * get List<PmlFileType> by userId
	 * @param userId
	 * @since 30-03-2009
	 * @return List<PmlFileType>
	 */
	public List<PmlFileType> getListFileTypeByUserId (long userId) {
		
		List<PmlFileType> retValue = new ArrayList<PmlFileType>();
		List<PmlFileType> list = null;
		PmlUser user = null;
		List<PmlField> listField = null;
		
		try {
			user = PmlUserUtil.findByPrimaryKey(userId);
			String departmentId = user.getDepartmentsId();
			
			if (departmentId != null) {
				listField = PmlFieldUtil.findByDepartmentsId(departmentId);
				for (PmlField fieldItem : listField) {
					String fieldId = fieldItem.getFieldId();
					list = PmlFileTypeUtil.findByFieldId(fieldId);
					retValue.addAll(list);
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
	//Yenlt 05/04/2010
	
	public List<PmlFileType> search (int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFileTypeFinder.findAllFileTypes(start, end, obc);
	}
	
	public int searchCount() throws SystemException{
		return pmlFileTypeFinder.countAllFileTypes();
	}
	
	// yenlt update 25082010
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
			pmlOneDoorReceiveFileList = PmlOneDoorReceiveFileUtil.findByFileTypeId(fileTypeId);
		} catch (Exception e) {
			
		}
		
		try {
			pmlFileTypeAttachedFileList = PmlFileTypeAttachedFileUtil.findByFileTypeId(fileTypeId);
		} catch (Exception e) {
			
		}
		validateFileType(pmlOneDoorReceiveFileList.size(), pmlFileTypeAttachedFileList.size());
		pmlFileTypePersistence.remove(fileTypeId);
	}
	// end yenlt 
	
	/*
	// phmphuc update 27/08/2010 - rang buoc dieu kien trung code
	public int countFileTypeByCode(String fileTypeCode) throws SystemException {
		int result = 0;
		
		try {
			result = PmlFileTypeUtil.countByFileTypeCode(fileTypeCode);
		} catch (Exception ex) {
			_log.error(ex.getMessage());
		}
		return result;
	}
	
	private static Log _log = LogFactoryUtil.getLog(PmlFileTypeLocalServiceImpl.class);
	// phmphuc end */
	
	/*
	 * phmphuc create 08/09/2010
	 * kiem tra ma loai ho so khi them moi
	 */
	public PmlFileType addFileType(String fileTypeCode, String fileTypeName, String fieldId, String processTime, 
									String description, String active, String currentReceiptNumber, String receiptTemplate,
									String templateId) throws SystemException, PortalException {

		// Check inputted value
		validateForAdd(fileTypeCode);
		
		String fileTypeId = "";
		try {
			fileTypeId = IdTemplateServiceUtil.generatedId(PmlFileType.class);
		} catch (RemoteException e) { }
		
		PmlFileType fileType = pmlFileTypePersistence.create(fileTypeId);

		// Set properties value
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
	
	
	/*
	 * phmphuc create 08/09/2010
	 * kiem tra ma loai ho so khi chinh sua
	 */
	public PmlFileType updateFileType(String fileTypeId, String fileTypeCode, String fileTypeName, String fieldId, 
										String processTime,	String description, String active, String currentReceiptNumber, 
										String receiptTemplate,	String templateId) throws SystemException, PortalException {

		// Checking inputted values
		validateForUpdate(fileTypeId, fileTypeCode);

		PmlFileType fileType = pmlFileTypePersistence.findByPrimaryKey(fileTypeId);

		// Updated properties
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

}
