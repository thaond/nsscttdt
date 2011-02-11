package com.sgs.portlet.pmlstreet.service.impl;

import java.rmi.RemoteException;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.filetype.FileTypeCanNotDeleteException;
import com.sgs.portlet.generatetemplateid.NoSuchIdGeneratedException;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.pmlstreet.NoGenerateStreetIdException;
import com.sgs.portlet.pmlstreet.model.PmlStreet;
import com.sgs.portlet.pmlstreet.service.base.PmlStreetLocalServiceBaseImpl;


public class PmlStreetLocalServiceImpl extends PmlStreetLocalServiceBaseImpl {
	
	public int searchCount(String keywords) throws SystemException{
		return pmlStreetFinder.countByKeywords(keywords);
	}
	
	public List<PmlStreet> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlStreetFinder.findByKeywords(keywords, start, end, obc);
	}

	protected String validateAddStreet() throws NoSuchIdGeneratedException, SystemException, RemoteException, NoGenerateStreetIdException {
		String streetId = "";
		streetId = IdTemplateServiceUtil.generatedId(PmlStreet.class);
		if ("".equals(streetId)) {
			throw new NoGenerateStreetIdException();
		}
		return streetId;
	}
	
	public PmlStreet addStreet(String streetCode, String streetName) throws NoSuchIdGeneratedException, NoGenerateStreetIdException, SystemException, RemoteException {
		String streetId = "";
		if ("".equals(streetCode)) {
			streetId = validateAddStreet();
		} else {
			streetId = streetCode;
		}
		PmlStreet street = pmlStreetPersistence.create(streetId);
		street.setStreetName(streetName);
		street = pmlStreetPersistence.update(street, false);
		return street;
	}
	
}
