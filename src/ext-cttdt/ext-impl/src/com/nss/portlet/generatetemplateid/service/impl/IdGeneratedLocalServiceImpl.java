package com.nss.portlet.generatetemplateid.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.generatetemplateid.model.IdGenerated;
import com.nss.portlet.generatetemplateid.service.base.IdGeneratedLocalServiceBaseImpl;


public class IdGeneratedLocalServiceImpl extends IdGeneratedLocalServiceBaseImpl {
	public List<IdGenerated> search(int start, int end) throws SystemException {
		return idGeneratedPersistence.findAll(start, end);
	}
	
	public int searchCount() throws SystemException {
		return idGeneratedPersistence.countAll();
	}
}
