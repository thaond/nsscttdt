package com.sgs.portlet.country.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.country.model.Country;
import com.sgs.portlet.country.service.base.CountryLocalServiceBaseImpl;

public class CountryLocalServiceImpl extends CountryLocalServiceBaseImpl {

	public List<Country> findByCountryCode(String countryCode) {

		try {
			return countryPersistence.findByCountryCode(countryCode);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByCountryName(String countryName) {

		try {
			return countryPersistence.findByCountryName(countryName);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByDescription(String description) {

		try {
			return countryPersistence.findByDescription(description);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByActive(String active) {

		try {
			return countryPersistence.findByActive(active);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByC_N_D(
		String code, String name, String description) {

		try {
			return countryPersistence.findByC_N_D(code, name, description);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByCountryCode(
		String countryCode, int start, int end) {

		try {
			return countryPersistence.findByCountryCode(countryCode, start, end);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByCountryName(
		String countryName, int start, int end) {

		try {
			return countryPersistence.findByCountryName(countryName, start, end);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByDescription(
		String description, int start, int end) {

		try {
			return countryPersistence.findByDescription(description, start, end);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByActive(String active, int start, int end) {

		try {
			return countryPersistence.findByActive(active, start, end);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Country> findByC_N_D(
		String code, String name, String description, int start, int end) {

		try {
			return countryPersistence.findByC_N_D(
				code, name, description, start, end);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int countByCountryCode(String countryCode) {

		try {
			return countryPersistence.countByCountryCode(countryCode);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int countByCountryName(String countryName) {

		try {
			return countryPersistence.countByCountryName(countryName);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int countByDescription(String description) {

		try {
			return countryPersistence.countByDescription(description);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int countByC_N_D(String code, String name, String description) {

		try {
			return countryPersistence.countByC_N_D(code, name, description);
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	//yenlt 30/03/2010
	public int countByKeywords(String keywords) throws SystemException{
		return countryFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MA_MOTA_QUOCGIA(String code, String name,	String des, boolean andOperator) throws SystemException {
		return countryFinder.countByTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator);
	}
	
	public List<Country> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return countryFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<Country> findTEN_MA_MOTA_QUOCGIA(String code,String name, String des, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException{
		return countryFinder.findTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator, start, end, obc);
	}
	//end
}
