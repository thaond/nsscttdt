package com.sgs.portlet.wardsmanagement.service.impl;

import java.rmi.RemoteException;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.wardsmanagement.WardCodeSameCodeException;
import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.service.base.WardsLocalServiceBaseImpl;


public class WardsLocalServiceImpl extends WardsLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return wardsFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MA_MOTA_PHUONG(String code, String name,	String des, boolean andOperator) throws SystemException {
		return wardsFinder.countByTEN_MA_MOTA_PHUONG(code, name, des, andOperator);
	}
	
	public List<Wards> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return wardsFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<Wards> findTEN_MA_MOTA_PHUONG(String code,String name, String des, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException{
		return wardsFinder.findTEN_MA_MOTA_PHUONG(code, name, des, andOperator, start, end, obc);
	}
	
	public int searchCount(String districtId) throws SystemException {
		return wardsFinder.countWardsByDistrictId(districtId);
	}
	public List<Wards> search(String districtId, int start, int end) throws SystemException {
		return wardsFinder.findWardsByDistrictId(districtId, start, end);
	}
	
	
	/*
	 * phmphuc create 10/09/2010
	 * kiem tra ward code khi them moi
	 */
	public Wards addWard(String wardCode, String wardName, String districtId, String description, 
								String active) throws PortalException, SystemException {

		// Check inputted value
		validateForAdd(wardCode);

		String wardId = "";
		try {
			wardId = IdTemplateServiceUtil.generatedId(Wards.class);
		} catch (RemoteException e) { }
		
		Wards ward = wardsPersistence.create(wardId);

		// Set properties value
		ward.setWardsCode(wardCode);
		ward.setWardsName(wardName);
		ward.setDistrictId(districtId);
		ward.setDescription(description);
		ward.setActive(active);
		
		wardsPersistence.update(ward, false);

		return ward;
	}
	
	protected void validateForAdd(String wardCode) throws PortalException, SystemException {
		
		if (Validator.isNull(wardCode)) {
			throw new WardCodeSameCodeException();
		}
		
		List<Wards> list = wardsPersistence.findByCode(wardCode.toLowerCase());
		if (!list.isEmpty()) {
			wardCode = wardCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (wardCode.equalsIgnoreCase(list.get(idx).getWardsCode().trim())) {
					throw new WardCodeSameCodeException();
				}
			}
		}
	}
	
	
	/*
	 * phmphuc create 10/09/2010
	 * kiem tra ward code khi chinh sua
	 */
	public Wards updateWard(String wardId, String wardCode, String wardName, String districtId, 
									String description, String active) throws PortalException, SystemException {

		// Checking inputted values
		validateForUpdate(wardId, wardCode);

		Wards ward = wardsPersistence.findByPrimaryKey(wardId);

		// Updated properties
		ward.setWardsCode(wardCode);
		ward.setWardsName(wardName);
		ward.setDistrictId(districtId);
		ward.setDescription(description);
		ward.setActive(active);
		
		wardsPersistence.update(ward, false);

		return ward;
	}
	
	protected void validateForUpdate(String wardId, String wardCode) throws PortalException, SystemException {
		
		if (Validator.isNull(wardCode)) {
			throw new WardCodeSameCodeException();
		}

		List<Wards> list = wardsPersistence.findByCode(wardCode.toLowerCase());
		if (!list.isEmpty()) {
			wardCode = wardCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (wardCode.equalsIgnoreCase(list.get(idx).getWardsCode().trim()) && 
						!list.get(idx).getWardsId().equals(wardId)) {
					throw new WardCodeSameCodeException();
				}
			}
		}
	}
}
