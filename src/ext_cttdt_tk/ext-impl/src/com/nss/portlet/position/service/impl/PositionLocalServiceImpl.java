package com.nss.portlet.position.service.impl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.nss.portlet.department.model.PmlUser;
import com.nss.portlet.department.service.PmlUserLocalServiceUtil;
import com.nss.portlet.generatetemplateid.service.IdTemplateLocalServiceUtil;
import com.nss.portlet.position.PositionCanNotDeleteException;
import com.nss.portlet.position.PositionCodeSameCodeException;
import com.nss.portlet.position.model.Position;
import com.nss.portlet.position.service.base.PositionLocalServiceBaseImpl;


public class PositionLocalServiceImpl extends PositionLocalServiceBaseImpl {
	public List<Position> findByKeywords(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return positionFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<Position> find_CODE_NAME_DESCRIPTION(String code, String name, String description, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return positionFinder.find_CODE_NAME_DESCRIPTION(code, name, description, andOperator, start, end, obc);
	}
	
	/**
	 * ham dem total
	 */
	public int countByKeywords(String keywords) throws SystemException{
		return positionFinder.countByKeywords(keywords);
	}
	
	public int count_CODE_NAME_DESCRIPTION(String code, String name, String description, boolean andOperator) throws SystemException{
		return positionFinder.count_CODE_NAME_DESCRIPTION(code, name, description, andOperator);
	}
	
	protected void validatePosition(int pmlUserListSize)
	throws PortalException, SystemException {
		if (pmlUserListSize != 0) {
			throw new PositionCanNotDeleteException();
		} 
	}
	
	public void removePosition(String positionId) throws SystemException, PortalException {
		List<PmlUser> pmlUserList = new ArrayList<PmlUser>();
		
		try {
			pmlUserList = PmlUserLocalServiceUtil.findByPositionId(positionId);
		} catch (Exception e) {
			
		}
		validatePosition(pmlUserList.size());
		positionPersistence.remove(positionId);
	}
	
	public Position addPosition(String positionCode, String positionName, String description, 
								String active) throws PortalException, SystemException {

		// Check inputted value
		validateForAdd(positionCode);

		String positionId = "";
		positionId = IdTemplateLocalServiceUtil.generatedId(Position.class);
		
		Position position = positionPersistence.create(positionId);

		// Set properties value
		position.setPositionCode(positionCode);
		position.setPositionName(positionName);
		position.setDescription(description);
		position.setActive(active);
		
		positionPersistence.update(position, false);

		return position;
	}
	
	protected void validateForAdd(String positionCode) throws PortalException, SystemException {
		
		if (Validator.isNull(positionCode)) {
			throw new PositionCodeSameCodeException();
		}
		
		List<Position> list = positionPersistence.findByPositionCode(positionCode.toLowerCase());
		if (!list.isEmpty()) {
			positionCode = positionCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (positionCode.equalsIgnoreCase(list.get(idx).getPositionCode().trim())) {
					throw new PositionCodeSameCodeException();
				}
			}
		}
	}
	
	public Position updatePosition(String positionId, String positionCode, String positionName, 
									String description, String active) throws PortalException, SystemException {

		// Checking inputted values
		validateForUpdate(positionId, positionCode);

		Position position = positionPersistence.findByPrimaryKey(positionId);

		// Updated properties
		position.setPositionCode(positionCode);
		position.setPositionName(positionName);
		position.setDescription(description);
		position.setActive(active);
		
		positionPersistence.update(position, false);

		return position;
	}
	
	protected void validateForUpdate(String positionId, String positionCode) throws PortalException, SystemException {
		
		if (Validator.isNull(positionCode)) {
			throw new PositionCodeSameCodeException();
		}

		List<Position> list = positionPersistence.findByPositionCode(positionCode.toLowerCase());
		if (!list.isEmpty()) {
			positionCode = positionCode.trim();
			for (int idx = 0; idx < list.size(); idx ++) {
				if (positionCode.equalsIgnoreCase(list.get(idx).getPositionCode().trim()) && 
						!list.get(idx).getPositionId().equals(positionId)) {
					throw new PositionCodeSameCodeException();
				}
			}
		}
	}
}
