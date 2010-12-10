package com.nss.portlet.permissonuserbyfile.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.permissonuserbyfile.model.PmlUserFileType;
import com.nss.portlet.permissonuserbyfile.service.base.PmlUserFileTypeLocalServiceBaseImpl;


public class PmlUserFileTypeLocalServiceImpl
    extends PmlUserFileTypeLocalServiceBaseImpl {
	
	public List<PmlUserFileType> findByUserId(long userId) {
		try {
			return pmlUserFileTypePersistence.findByUserId(userId);
		} catch (SystemException e) {
			return new ArrayList<PmlUserFileType>();
		}
		
	}
}
