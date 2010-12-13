package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.model.PmlTransition;
import com.nss.portlet.onedoor.service.base.PmlTransitionLocalServiceBaseImpl;
import com.nss.portlet.onedoor.service.persistence.PmlTransitionUtil;


public class PmlTransitionLocalServiceImpl
    extends PmlTransitionLocalServiceBaseImpl {
	
	public int countByFileTypeId(String fileTypeId){
		try {
			return PmlTransitionUtil.countByFileTypeId(fileTypeId);
		} catch (SystemException e) {
			return 0;
		}
	}
	
	public List<PmlTransition> findByFileTypeId(String fileTypeId) throws SystemException {
			return PmlTransitionUtil.findByFileTypeId(fileTypeId);
	}
}
