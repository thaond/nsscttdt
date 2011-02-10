package com.sgs.portlet.generatetemplateid.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.generatetemplateid.model.IdGenerated;
import com.sgs.portlet.generatetemplateid.service.base.IdGeneratedLocalServiceBaseImpl;


public class IdGeneratedLocalServiceImpl extends IdGeneratedLocalServiceBaseImpl {
	public int searchCount() throws SystemException{
		return idGeneratedFinder.countAll();
	}
	
	public List<IdGenerated> search(int start, int end) throws SystemException {
		return idGeneratedFinder.findAll(start, end);
	}
}
