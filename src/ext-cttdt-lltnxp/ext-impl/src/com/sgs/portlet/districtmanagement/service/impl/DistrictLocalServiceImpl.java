package com.sgs.portlet.districtmanagement.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.districtmanagement.DistrictCanNotDeleteException;
import com.sgs.portlet.districtmanagement.DistrictCodeSameCodeException;
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.service.base.DistrictLocalServiceBaseImpl;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.service.persistence.WardsUtil;

public class DistrictLocalServiceImpl extends DistrictLocalServiceBaseImpl {
	//yenlt 05/04/2010
	
	public int countByKeywords(String keywords) throws SystemException{
		return districtFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MA_MOTA_QUAN(String code, String name,	String des, boolean andOperator) throws SystemException {
		return districtFinder.countByTEN_MA_MOTA_QUAN(code, name, des, andOperator);
	}
	
	public List<District> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return districtFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<District> findTEN_MA_MOTA_QUAN(String code,String name, String des, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException{
		return districtFinder.findTEN_MA_MOTA_QUAN(code, name, des, andOperator, start, end, obc);
	}
	
	public int searchCount(String cityId) throws SystemException {
		return districtFinder.countDistrictByCityId(cityId);
	}
	
	public List<District> search(String cityId, int start, int end) throws SystemException {
		return districtFinder.findDistrictByCityId(cityId, start, end);
	}
	//end
	// yenlt update 24082010
	protected void validateDistrict(int wardSize)
	throws PortalException, SystemException {
	
		if (wardSize != 0) {
			throw new DistrictCanNotDeleteException();
		} 
	}
	
	public void removeDistrict(String districtId) throws SystemException, PortalException {
		List<Wards> wardsList = new ArrayList<Wards>();
		wardsList = WardsUtil.findByDistrictId(districtId);
		validateDistrict(wardsList.size());
		districtPersistence.remove(districtId);
	}
	// end yenlt 
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma quan huyen khi them moi
	 */
	public District addDistrict(String districtCode, String districtName, String cityID, String description, String active) throws SystemException, PortalException {

		// Check inputted value
		validateForAdd(districtCode);
		
		String districtId = "";
		try {
			districtId = IdTemplateServiceUtil.generatedId(District.class);
		} catch (RemoteException e) { }
		
		District district = districtPersistence.create(districtId);

		// Set properties value
		district.setDistrictCode(districtCode);
		district.setDistrictName(districtName);
		district.setCityID(cityID);
		district.setDescription(description);
		district.setActive(active);
		
		districtPersistence.update(district, false);

		return district;
	}
	
	protected void validateForAdd(String districtCode) throws PortalException, SystemException {
		
		if (Validator.isNull(districtCode)) {
			throw new DistrictCodeSameCodeException();
		}
		
		List<District> list = districtPersistence.findByCode(districtCode.toLowerCase());
		if (!list.isEmpty()) {
			districtCode = districtCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (districtCode.equalsIgnoreCase(list.get(idx).getDistrictCode().trim())) {
					throw new DistrictCodeSameCodeException();
				}
			}
		}
	}
	
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma quan huyen khi chinh sua
	 */
	public District updateDistrict(String districtId, String districtCode, String districtName, String cityID, String description, String active) throws SystemException, PortalException {

		// Checking inputted values
		validateForUpdate(districtId, districtCode);

		District district = districtPersistence.findByPrimaryKey(districtId);

		// Updated properties
		district.setDistrictCode(districtCode);
		district.setDistrictName(districtName);
		district.setCityID(cityID);
		district.setDescription(description);
		district.setActive(active);
		
		districtPersistence.update(district, false);

		return district;
	}
	
	protected void validateForUpdate(String districtId, String districtCode) throws PortalException, SystemException {
		
		if (Validator.isNull(districtCode)) {
			throw new DistrictCodeSameCodeException();
		}

		List<District> list = districtPersistence.findByCode(districtCode.toLowerCase());
		if (!list.isEmpty()) {
			districtCode = districtCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (districtCode.equalsIgnoreCase(list.get(idx).getDistrictCode().trim()) && 
						!list.get(idx).getDistrictId().equals(districtId)) {
					throw new DistrictCodeSameCodeException();
				}
			}
		}
	}
}