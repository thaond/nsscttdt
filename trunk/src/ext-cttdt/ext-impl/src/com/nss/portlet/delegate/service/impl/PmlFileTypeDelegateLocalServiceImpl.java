package com.nss.portlet.delegate.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.delegate.model.PmlFileTypeDelegate;
import com.nss.portlet.delegate.service.base.PmlFileTypeDelegateLocalServiceBaseImpl;


public class PmlFileTypeDelegateLocalServiceImpl
    extends PmlFileTypeDelegateLocalServiceBaseImpl {
	public List<PmlFileTypeDelegate> findByDelegateId(long delegateId) throws SystemException {
		return pmlFileTypeDelegatePersistence.findByDelegateId(delegateId);
	}
}
