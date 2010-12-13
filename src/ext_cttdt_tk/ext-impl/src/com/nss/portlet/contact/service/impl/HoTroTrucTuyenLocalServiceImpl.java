package com.nss.portlet.contact.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.contact.model.HoTroTrucTuyen;
import com.nss.portlet.contact.service.base.HoTroTrucTuyenLocalServiceBaseImpl;


public class HoTroTrucTuyenLocalServiceImpl extends HoTroTrucTuyenLocalServiceBaseImpl {
	
	public List<HoTroTrucTuyen> findByActive(int active) throws SystemException {
		return hoTroTrucTuyenPersistence.findByActive(active);
	}
	
}
