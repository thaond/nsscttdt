package com.sgs.portlet.document.receipt.service.impl;

import java.rmi.RemoteException;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.document.receipt.ConfidentialLevelNameNotSameException;
import com.sgs.portlet.document.receipt.ConfidentialLevelSymbolNotSameException;
import com.sgs.portlet.document.receipt.model.PmlEdmConfidentialLevel;
import com.sgs.portlet.document.receipt.service.PmlEdmConfidentialLevelLocalServiceUtil;
import com.sgs.portlet.document.receipt.service.base.PmlEdmConfidentialLevelLocalServiceBaseImpl;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;

public class PmlEdmConfidentialLevelLocalServiceImpl
    extends PmlEdmConfidentialLevelLocalServiceBaseImpl {
	
//	minh 20100206
	
	public int searchCount(String keywords) throws SystemException{
		return pmlEdmConfidentialLevelFinder.countByKeywords(keywords);
	}
	
	public List<PmlEdmConfidentialLevel> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlEdmConfidentialLevelFinder.findByKeywords(keywords, start, end, obc);
	}
	
//  end	
	
	/*
	 * phmphuc create 24/12/2010
	 * kiem tra ten do mat va muc do cua do mat khi them moi
	 */
	public PmlEdmConfidentialLevel addPmlEdmConfidentialLevel(String confidentialLevelName, int confidentialLevelSymbol, 
							boolean limitViewDetail, boolean haveProcess) throws PortalException, SystemException {
			
		validateForAdd(confidentialLevelName, confidentialLevelSymbol);

		String pmlEdmConfidentialLevelId = "";
		try {
			pmlEdmConfidentialLevelId = IdTemplateServiceUtil.generatedStringId(PmlEdmConfidentialLevel.class.getName());
		} catch (RemoteException e) { }
		
		PmlEdmConfidentialLevel pmlEdmConfidentialLevel = pmlEdmConfidentialLevelPersistence.create(pmlEdmConfidentialLevelId);

		// Set properties value
		pmlEdmConfidentialLevel.setConfidentialLevelName(confidentialLevelName);
		pmlEdmConfidentialLevel.setConfidentialLevelSymbol(confidentialLevelSymbol);
		pmlEdmConfidentialLevel.setLimitViewDetail(limitViewDetail);
		pmlEdmConfidentialLevel.setHaveProcess(haveProcess);
		
		pmlEdmConfidentialLevelPersistence.update(pmlEdmConfidentialLevel, false);
		
		return pmlEdmConfidentialLevel;
	}
	
	protected void validateForAdd(String confidentialLevelName, int confidentialLevelSymbol) throws PortalException, SystemException {
		
		if (Validator.isNull(confidentialLevelName)) {
			throw new ConfidentialLevelNameNotSameException();
		}
		
		if (Validator.isNull(confidentialLevelSymbol)) {
			throw new ConfidentialLevelSymbolNotSameException();
		}
		
		List<PmlEdmConfidentialLevel> list = PmlEdmConfidentialLevelLocalServiceUtil.getPmlEdmConfidentialLevels(-1, -1);
		if (!list.isEmpty()) {
			confidentialLevelName = confidentialLevelName.trim().toLowerCase();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (confidentialLevelName.equalsIgnoreCase(list.get(idx).getConfidentialLevelName().trim().toLowerCase())) {
					throw new ConfidentialLevelNameNotSameException();
				}
				else if (confidentialLevelSymbol == list.get(idx).getConfidentialLevelSymbol()) {
					throw new ConfidentialLevelSymbolNotSameException();
				}
			}
		}
	}
	
	
	/*
	 * phmphuc create 24/12/2010
	 * kiem tra ten do mat va muc do cua do mat khi chinh sua
	 */
	public PmlEdmConfidentialLevel updatePmlEdmConfidentialLevel(String confidentialLevelId, String confidentialLevelName, int confidentialLevelSymbol,
									boolean limitViewDetail, boolean haveProcess) throws PortalException, SystemException {

		// Checking inputted values
		validateForUpdate(confidentialLevelId, confidentialLevelName, confidentialLevelSymbol);
		
		PmlEdmConfidentialLevel pmlEdmConfidentialLevel = pmlEdmConfidentialLevelPersistence.findByPrimaryKey(confidentialLevelId);

		// Updated properties
		pmlEdmConfidentialLevel.setConfidentialLevelName(confidentialLevelName);
		pmlEdmConfidentialLevel.setConfidentialLevelSymbol(confidentialLevelSymbol);
		pmlEdmConfidentialLevel.setLimitViewDetail(limitViewDetail);
		pmlEdmConfidentialLevel.setHaveProcess(haveProcess);
		
		pmlEdmConfidentialLevelPersistence.update(pmlEdmConfidentialLevel, false);

		return pmlEdmConfidentialLevel;
	}
	
	protected void validateForUpdate(String confidentialLevelId, String confidentialLevelName, int confidentialLevelSymbol) throws PortalException, SystemException {
		
		if (Validator.isNull(confidentialLevelName)) {
			throw new ConfidentialLevelNameNotSameException();
		}
		
		if (Validator.isNull(confidentialLevelSymbol)) {
			throw new ConfidentialLevelSymbolNotSameException();
		}
		
		List<PmlEdmConfidentialLevel> list = PmlEdmConfidentialLevelLocalServiceUtil.getPmlEdmConfidentialLevels(-1, -1);
		if (!list.isEmpty()) {
			confidentialLevelName = confidentialLevelName.trim().toLowerCase();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (confidentialLevelName.equalsIgnoreCase(list.get(idx).getConfidentialLevelName().trim().toLowerCase())
						&& !confidentialLevelId.equals(list.get(idx).getConfidentialLevelId())) {
					throw new ConfidentialLevelNameNotSameException();
				}
				else if (confidentialLevelSymbol == list.get(idx).getConfidentialLevelSymbol()
						&& !confidentialLevelId.equals(list.get(idx).getConfidentialLevelId())) {
					throw new ConfidentialLevelSymbolNotSameException();
				}
			}
		}
	}
}
