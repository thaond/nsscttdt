package com.sgs.portlet.agency.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.sgs.portlet.agency.AgencyCanNotDeleteException;
import com.sgs.portlet.agency.AgencyCodeSameCodeException;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.agency.service.base.AgencyLocalServiceBaseImpl;
import com.sgs.portlet.department.model.Department;
import com.sgs.portlet.department.service.persistence.DepartmentUtil;
import com.sgs.portlet.generatetemplateid.service.IdTemplateServiceUtil;
import com.sgs.portlet.onedoor.service.PmlAgencyLeaderLocalServiceUtil;


public class AgencyLocalServiceImpl extends AgencyLocalServiceBaseImpl {
	public List<Agency> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return agencyFinder.findByKeywords(keywords, start, end, obc);
	}
	public List<Agency> search(String leaderLastNames, String leaderFirstNames, String agencyCode, String agencyName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return agencyFinder.findTEN_MA_COQUAN(leaderLastNames, leaderFirstNames, agencyCode, agencyName, andOperator, start, end, obc);
	}
	
	public int searchCount(String keywords) throws SystemException{
		return agencyFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String leaderLastNames, String leaderFirstNames, String agencyCode, String agencyName, boolean andOperator)throws SystemException {
		return agencyFinder.countByTEN_MA_COQUAN(leaderLastNames, leaderFirstNames, agencyCode, agencyName, andOperator);
	}
	// yenlt update 24082010
	protected void validateAgency(int pmlDepartmentListSize)
	throws PortalException, SystemException {
	
		if (pmlDepartmentListSize != 0) {
			throw new AgencyCanNotDeleteException();
		} 
	}
	
	public void removeAgency(String agencyId) throws SystemException, PortalException {
		List<Department> pmlDepartmentList = new ArrayList<Department>();
		try {
			pmlDepartmentList = DepartmentUtil.findByAgencyId(agencyId);
		} catch (Exception e) {
			
		}
		validateAgency(pmlDepartmentList.size());
		agencyPersistence.remove(agencyId);
		PmlAgencyLeaderLocalServiceUtil.deletePmlAgencyLeader(agencyId);
	}
	// end yenlt 
	/*
	 * phmphuc create 06/09/2010
	 * kiem tra agency code khi them moi
	 */
	public Agency addAgency(String agencyCode, String agencyName, String description, 
			String active) throws PortalException, SystemException {
			
		validateForAdd(agencyCode);

		String agencyId = "";
		try {
			agencyId = IdTemplateServiceUtil.generatedId(Agency.class);
		} catch (RemoteException e) { }
		
		Agency agency = agencyPersistence.create(agencyId);

		// Set properties value
		agency.setAgencyCode(agencyCode);
		agency.setAgencyName(agencyName);
		agency.setDescription(description);
		agency.setActive(active);
		
		agencyPersistence.update(agency, false);
		
		return agency;
	}
	
	protected void validateForAdd(String agencyCode) throws PortalException, SystemException {
		
		if (Validator.isNull(agencyCode)) {
			throw new AgencyCodeSameCodeException();
		}
		
		List<Agency> list = agencyPersistence.findByAgencyCode(agencyCode.toLowerCase());
		if (!list.isEmpty()) {
			agencyCode = agencyCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (agencyCode.equalsIgnoreCase(list.get(idx).getAgencyCode().trim())) {
					throw new AgencyCodeSameCodeException();
				}
			}
		}
	}
	
	
	/*
	 * phmphuc create 06/09/2010
	 * kiem tra agency code khi chinh sua
	 */
	public Agency updateAgency(String agencyId, String agencyCode, String agencyName, String description, 
								String active) throws PortalException, SystemException {

		// Checking inputted values
		validateForUpdate(agencyId, agencyCode);
		
		Agency agency = agencyPersistence.findByPrimaryKey(agencyId);

		// Updated properties
		agency.setAgencyCode(agencyCode);
		agency.setAgencyName(agencyName);
		agency.setDescription(description);
		agency.setActive(active);
		
		agencyPersistence.update(agency, false);

		return agency;
	}
	
	protected void validateForUpdate(String agencyId, String agencyCode) throws PortalException, SystemException {
		
		if (Validator.isNull(agencyCode)) {
			throw new AgencyCodeSameCodeException();
		}

		List<Agency> list = agencyPersistence.findByAgencyCode(agencyCode.toLowerCase());
		if (!list.isEmpty()) {
			agencyCode = agencyCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				// Neu ten kiem tra trung voi ten cua mot muc khac 
				if (agencyCode.equalsIgnoreCase(list.get(idx).getAgencyCode().trim()) && 
						!list.get(idx).getAgencyId().equals(agencyId)) {
					throw new AgencyCodeSameCodeException();
				}
			}
		}
	}
}
