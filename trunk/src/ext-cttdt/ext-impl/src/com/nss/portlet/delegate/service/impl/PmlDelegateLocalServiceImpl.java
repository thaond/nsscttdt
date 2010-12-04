package com.nss.portlet.delegate.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.delegate.model.PmlDelegate;
import com.nss.portlet.delegate.service.base.PmlDelegateLocalServiceBaseImpl;


public class PmlDelegateLocalServiceImpl extends PmlDelegateLocalServiceBaseImpl {
	
	public List<PmlDelegate> findByAssigner(long assignerId) throws SystemException {
		return pmlDelegatePersistence.findByAssigner(assignerId);
	}
}
