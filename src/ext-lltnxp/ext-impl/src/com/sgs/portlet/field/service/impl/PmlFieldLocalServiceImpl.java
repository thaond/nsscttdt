package com.sgs.portlet.field.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.field.FieldCanNotDeleteException;
import com.sgs.portlet.field.FieldCodeSameCodeException;
import com.sgs.portlet.field.model.PmlField;
import com.sgs.portlet.field.service.base.PmlFieldLocalServiceBaseImpl;
import com.sgs.portlet.filetype.model.PmlFileType;
import com.sgs.portlet.filetype.service.persistence.PmlFileTypeUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;


public class PmlFieldLocalServiceImpl extends PmlFieldLocalServiceBaseImpl {

	public int searchCount(String keywords) throws SystemException{
		return pmlFieldFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String fieldCode, String fieldName, boolean andOperator) throws SystemException{
		return pmlFieldFinder.countByField(fieldCode, fieldName, andOperator);
	}
	
	public List<PmlField> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFieldFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<PmlField> search(String fieldCode, String fieldName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlFieldFinder.findByField(fieldCode, fieldName, andOperator, start, end, obc);
	}
	
	// yenlt update 24082010
	protected void validateField(int fileTypeListSize)
	throws PortalException, SystemException {
	
		if (fileTypeListSize != 0) {
			throw new FieldCanNotDeleteException();
		} 
	}
	
	public void removeAgency(String fieldId) throws SystemException, PortalException {
		List<PmlFileType> fileTypeList = new ArrayList<PmlFileType>();
		try {
			fileTypeList = PmlFileTypeUtil.findByFieldId(fieldId);
		} catch (Exception e) {
			
		}
		validateField(fileTypeList.size());
		pmlFieldPersistence.remove(fieldId);
	}
	// end yenlt 
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma linh vuc ho so khi them moi
	 */
	public PmlField addPmlField(String fieldCode, String fieldName, String departmentsId, String description, String active) throws SystemException, PortalException {

		// Check inputted value
		validateForAdd(fieldCode);
		
		String fieldId = "";
		try {
			fieldId = IdTemplateServiceUtil.generatedId(PmlField.class);
		} catch (RemoteException e) { }
		
		PmlField pmlField = pmlFieldPersistence.create(fieldId);

		// Set properties value
		pmlField.setFieldCode(fieldCode);
		pmlField.setFieldName(fieldName);
		pmlField.setDepartmentsId(departmentsId);
		pmlField.setDescription(description);
		pmlField.setActive(active);
		
		pmlFieldPersistence.update(pmlField, false);

		return pmlField;
	}
	
	protected void validateForAdd(String fieldCode) throws PortalException, SystemException {
		
		if (Validator.isNull(fieldCode)) {
			throw new FieldCodeSameCodeException();
		}
		
		List<PmlField> list = pmlFieldPersistence.findByFieldCode(fieldCode.toLowerCase());
		if (!list.isEmpty()) {
			fieldCode = fieldCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (fieldCode.equalsIgnoreCase(list.get(idx).getFieldCode().trim())) {
					throw new FieldCodeSameCodeException();
				}
			}
		}
	}
}