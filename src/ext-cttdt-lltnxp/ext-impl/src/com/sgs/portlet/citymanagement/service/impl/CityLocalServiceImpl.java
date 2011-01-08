package com.sgs.portlet.citymanagement.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.citymanagement.CityCanNotDeleteException;
import com.sgs.portlet.citymanagement.CityCodeSameCodeException;
import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.service.base.CityLocalServiceBaseImpl;
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.service.persistence.DistrictUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;

public class CityLocalServiceImpl extends CityLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return cityFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MA_THANH_PHO(String cityCode, String cityName, boolean andOperator) throws SystemException {
		return cityFinder.countByTEN_MA_THANH_PHO(cityCode, cityName, andOperator);
	}
	
	public List<City> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return cityFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<City> findByTEN_MA_THANH_PHO(String cityCode, String cityName, boolean andOperator,int start, int end, OrderByComparator obc) throws SystemException {
		return cityFinder.findByTEN_MA_THANH_PHO(cityCode, cityName, andOperator, start, end, obc);
	}
	// yenlt update 24082010
	protected void validateCity(int pmlDistrictListSize)
	throws PortalException, SystemException {
	
		if (pmlDistrictListSize != 0) {
			throw new CityCanNotDeleteException();
		} 
	}
	
	public void removeAgency(String cityId) throws SystemException, PortalException {
		List<District> pmlDistrictList = new ArrayList<District>();  
		try {
			pmlDistrictList = DistrictUtil.findByCityID(cityId);
		} catch (Exception e) {}
		
		validateCity(pmlDistrictList.size());
		cityPersistence.remove(cityId);
	}
	// end yenlt 
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma thanh pho khi them moi
	 */
	public City addCity(String cityCode, String cityName, String description, String active, 
								String countryId) throws SystemException, PortalException {

		// Check inputted value
		validateForAdd(cityCode);
		
		String cityID = "";
		try {
			cityID = IdTemplateServiceUtil.generatedId(City.class);
		} catch (RemoteException e) { }
		
		City city = cityPersistence.create(cityID);

		// Set properties value
		city.setCityCode(cityCode);
		city.setCityName(cityName);
		city.setDescription(description);
		city.setActive(active);
		city.setCountryId(countryId);
		
		cityPersistence.update(city, false);

		return city;
	}
	
	protected void validateForAdd(String cityCode) throws PortalException, SystemException {
		
		if (Validator.isNull(cityCode)) {
			throw new CityCodeSameCodeException();
		}
		
		List<City> list = cityPersistence.findByCode(cityCode.toLowerCase());
		if (!list.isEmpty()) {
			cityCode = cityCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (cityCode.equalsIgnoreCase(list.get(idx).getCityCode().trim())) {
					throw new CityCodeSameCodeException();
				}
			}
		}
	}
	
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma ho so dinh kem khi chinh sua
	 */
	public City updateCity(String cityId, String cityCode, String cityName, 
							String description) throws SystemException, PortalException {

		// Checking inputted values
		validateForUpdate(cityId, cityCode);

		City city = cityPersistence.findByPrimaryKey(cityId);

		// Updated properties
		city.setCityCode(cityCode);
		city.setCityName(cityName);
		city.setDescription(description);
		
		cityPersistence.update(city, false);

		return city;
	}
	
	protected void validateForUpdate(String cityId, String cityCode) throws PortalException, SystemException {
		
		if (Validator.isNull(cityCode)) {
			throw new CityCodeSameCodeException();
		}

		List<City> list  = cityPersistence.findByCode(cityCode.toLowerCase());
		if (!list.isEmpty()) {
			cityCode = cityCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (cityCode.equalsIgnoreCase(list.get(idx).getCityCode().trim()) && 
						!list.get(idx).getCityID().equals(cityId)) {
					throw new CityCodeSameCodeException();
				}
			}
		}
	}
}
