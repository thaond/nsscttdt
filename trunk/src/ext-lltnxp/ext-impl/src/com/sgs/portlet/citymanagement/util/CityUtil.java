package com.sgs.portlet.citymanagement.util;

import java.util.List;

import com.sgs.portlet.citymanagement.model.City;
import com.sgs.portlet.citymanagement.service.CityLocalServiceUtil;
import com.sgs.portlet.districtmanagement.model.District;
import com.sgs.portlet.districtmanagement.service.DistrictLocalServiceUtil;
import com.sgs.portlet.districtmanagement.service.persistence.DistrictUtil;
import com.sgs.portlet.wardsmanagement.model.Wards;
import com.sgs.portlet.wardsmanagement.service.WardsLocalServiceUtil;
import com.sgs.portlet.wardsmanagement.service.persistence.WardsUtil;

public class CityUtil {
	public void updateCity(String cityId, String cityCode, String cityName,
			String description) throws Exception {
		City city = CityLocalServiceUtil.getCity(cityId);
		city.setCityCode(cityCode);
		city.setCityName(cityName);
		city.setDescription(description);

		CityLocalServiceUtil.updateCity(city);
	}

	/**
	 * xoa thanh pho 
	 * @param cityId
	 * @return boolean
	 * Aug 18, 2009
	 * com.sgs.portlet.citymanagement.util
	 *
	 */
	public boolean deleteCity(String cityId) {
		List<District> districtList = null;  
		try {
			districtList = DistrictUtil.findByCityID(cityId);
		} catch (Exception e) {}
		
		if (districtList != null && !districtList.isEmpty()) {
			return false;
		}
		
		else {
			try {
				CityLocalServiceUtil.deleteCity(cityId);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}

	public void updateDistrict(String districtId, String code,
			String name, String description) throws Exception {
		District district = DistrictLocalServiceUtil.getDistrict(districtId);
		district.setDistrictCode(code);
		district.setDistrictName(name);
		district.setDescription(description);
		
		DistrictLocalServiceUtil.updateDistrict(district);
	}
	
	/**
	 * xoa quan
	 * @param districtId
	 * @return boolean
	 * Aug 18, 2009
	 * com.sgs.portlet.citymanagement.util
	 *
	 */
	public boolean deleteDistrict(String districtId)  {
		List<Wards> wardsList = null;
		try {
			wardsList = WardsUtil.findByDistrictId(districtId);
		} catch (Exception e) {
		}
		
		if (wardsList != null && !wardsList.isEmpty()) {
			return false;
		}
		
		else {
			try {
				DistrictLocalServiceUtil.deleteDistrict(districtId);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
	}
	
	public void updateWard(String wardId, String code,
			String name, String description) throws Exception {
		Wards wards = WardsLocalServiceUtil.getWards(wardId);
		wards.setWardsCode(code);
		wards.setWardsName(name);
		wards.setDescription(description);
		
		WardsLocalServiceUtil.updateWards(wards);
	}
	
	public void deleteWard(String wardsId) throws Exception {
		WardsLocalServiceUtil.deleteWards(wardsId);
	}
}
