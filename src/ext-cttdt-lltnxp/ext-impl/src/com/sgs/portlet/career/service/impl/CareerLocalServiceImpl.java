package com.sgs.portlet.career.service.impl;

import java.rmi.RemoteException;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.career.CareeerCodeSameCodeException;
import com.sgs.portlet.career.CareerCodeSameCodeException;
import com.sgs.portlet.career.model.Career;
import com.sgs.portlet.career.service.base.CareerLocalServiceBaseImpl;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;

public class CareerLocalServiceImpl extends CareerLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return careerFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MA_NGHENGHIEP(String code, String name, String des, boolean andOperator) throws SystemException{
		return careerFinder.countByTEN_MA_NGHENGHIEP(code, name, des, andOperator);
	}
	
	public List<Career> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return careerFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<Career> findTEN_MA_NGHENGHIEP(String code, String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return careerFinder.findTEN_MA_NGHENGHIEP(code, name, des, andOperator, start, end, obc);
	}
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma nganh nghe khi them moi
	 */
	public Career addCareer(String careerCode, String careerName, String description, String active) throws SystemException, PortalException {

		// Check inputted value
		validateForAdd(careerCode);
		
		String careerId = "";
		try {
			careerId = IdTemplateServiceUtil.generatedId(Career.class);
		} catch (RemoteException e) { }
		
		Career career = careerPersistence.create(careerId);

		// Set properties value
		career.setCareerCode(careerCode);
		career.setCareerName(careerName);
		career.setDescription(description);
		career.setActive(active);
		
		careerPersistence.update(career, false);

		return career;
	}
	
	protected void validateForAdd(String careerCode) throws PortalException, SystemException {
		
		if (Validator.isNull(careerCode)) {
			throw new CareeerCodeSameCodeException();
		}
		
		List<Career> list = careerPersistence.findByCareerCode(careerCode.toLowerCase());
		if (!list.isEmpty()) {
			careerCode = careerCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (careerCode.equalsIgnoreCase(list.get(idx).getCareerCode().trim())) {
					throw new CareerCodeSameCodeException();
				}
			}
		}
	}
	
	
	/*
	 * phmphuc create 07/09/2010
	 * kiem tra ma nganh nghe khi chinh sua
	 */
	public Career updateCareer(String careerId, String careerCode, String careerName, String description, String active) throws SystemException, PortalException {

		// Checking inputted values
		validateForUpdate(careerId, careerCode);

		Career career = careerPersistence.findByPrimaryKey(careerId);

		// Updated properties
		career.setCareerCode(careerCode);
		career.setCareerName(careerName);
		career.setDescription(description);
		career.setActive(active);
		
		careerPersistence.update(career, false);

		return career;
	}
	
	protected void validateForUpdate(String careerId, String careerCode) throws PortalException, SystemException {
		
		if (Validator.isNull(careerCode)) {
			throw new CareerCodeSameCodeException();
		}

		List<Career> list = careerPersistence.findByCareerCode(careerCode.toLowerCase());
		if (!list.isEmpty()) {
			careerCode = careerCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (careerCode.equalsIgnoreCase(list.get(idx).getCareerCode().trim()) && 
						!list.get(idx).getCareerId().equals(careerId)) {
					throw new CareerCodeSameCodeException();
				}
			}
		}
	}
}
