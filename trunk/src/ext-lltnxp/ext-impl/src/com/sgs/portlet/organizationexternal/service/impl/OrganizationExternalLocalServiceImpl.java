package com.sgs.portlet.organizationexternal.service.impl;

import java.util.List;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.organizationexternal.OrganizationExternalCodeSameCodeException;
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;
import com.sgs.portlet.organizationexternal.service.base.OrganizationExternalLocalServiceBaseImpl;


public class OrganizationExternalLocalServiceImpl extends OrganizationExternalLocalServiceBaseImpl {
	
	public int countByKeywords(String keywords) throws SystemException{
		return organizationExternalFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MA_DONVILIENTHONG(String code, String name, boolean andOperator) throws SystemException {
		return organizationExternalFinder.countByTEN_MA_DONVILIENTHONG(code, name, andOperator);
	}
	
	public List<OrganizationExternal> findByKeywords(String keywords, 
						int start, int end, OrderByComparator obc) throws SystemException {
		return organizationExternalFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<OrganizationExternal> findTEN_MA_DONVILIENTHONG(String code, String name, boolean andOperator, 
						int start, int end, OrderByComparator obc) throws SystemException {
		return organizationExternalFinder.findTEN_MA_DONVILIENTHONG(code, name, andOperator, start, end, obc);
	}
	
	/*
	 * kiem tra ma don vi lien thong khi them moi
	 */
	public OrganizationExternal addOrganizationExternal(String orgExternalCode, String orgExternalName, 
														boolean isOwnerOrg) throws SystemException, PortalException {
		// Check inputted value
		validateForAdd(orgExternalCode);
		
		long orgExternalId = 0;
		try {
			orgExternalId = CounterLocalServiceUtil.increment();
		} catch (Exception e) { }
		
		OrganizationExternal organizationExternal = organizationExternalPersistence.create(orgExternalId);

		// Set properties value
		organizationExternal.setOrgExternalCode(orgExternalCode);
		organizationExternal.setOrgExternalName(orgExternalName);
		organizationExternal.setIsOwnerOrg(isOwnerOrg);
		
		organizationExternalPersistence.update(organizationExternal, false);

		return organizationExternal;
	}
	
	protected void validateForAdd(String orgExternalCode) throws PortalException, SystemException {
		if (Validator.isNull(orgExternalCode)) {
			throw new OrganizationExternalCodeSameCodeException();
		}
		
		List<OrganizationExternal> list = organizationExternalPersistence.findByOrgExternalCode(orgExternalCode.toLowerCase());
		if (!list.isEmpty()) {
			orgExternalCode = orgExternalCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (orgExternalCode.equalsIgnoreCase(list.get(idx).getOrgExternalCode().trim())) {
					throw new OrganizationExternalCodeSameCodeException();
				}
			}
		}
	}
	
	
	/*
	 * kiem tra ma don vi lien thong khi chinh sua
	 */
	public OrganizationExternal updateOrganizationExternal(long orgExternalId, String orgExternalCode, 
								String orgExternalName, boolean isOwnerOrg) throws SystemException, PortalException {
		// Checking inputted values
		validateForUpdate(orgExternalId, orgExternalCode);

		OrganizationExternal organizationExternal = organizationExternalPersistence.findByPrimaryKey(orgExternalId);

		// Updated properties
		organizationExternal.setOrgExternalCode(orgExternalCode);
		organizationExternal.setOrgExternalName(orgExternalName);
		organizationExternal.setIsOwnerOrg(isOwnerOrg);
		
		organizationExternalPersistence.update(organizationExternal, false);

		return organizationExternal;
	}
	
	protected void validateForUpdate(long orgExternalId, String orgExternalCode) throws PortalException, SystemException {
		
		if (Validator.isNull(orgExternalCode)) {
			throw new OrganizationExternalCodeSameCodeException();
		}

		List<OrganizationExternal> list = organizationExternalPersistence.findByOrgExternalCode(orgExternalCode.toLowerCase());
		if (!list.isEmpty()) {
			orgExternalCode = orgExternalCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (orgExternalCode.equalsIgnoreCase(list.get(idx).getOrgExternalCode().trim()) && 
						list.get(idx).getOrgExternalId() != orgExternalId) {
					throw new OrganizationExternalCodeSameCodeException();
				}
			}
		}
	}
	
}
