package com.ext.portlet.processtype.service.impl;

import java.util.List;

import com.ext.portlet.processtype.model.ProcessType;
import com.ext.portlet.processtype.service.base.ProcessTypeLocalServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;

public class ProcessTypeLocalServiceImpl extends ProcessTypeLocalServiceBaseImpl {
	
	public ProcessType getProcessTypeById(long id) throws SystemException, PortalException {
		return processTypePersistence.findByPrimaryKey(id);
	}
	
	public List<ProcessType> getProcessTypeByFlag(int flag) throws SystemException, PortalException {
		return processTypePersistence.findByFlagProcessType(flag);
	}
	
	//phmphuc - 05/06/2010 - lay danh sach Cach thuc xu ly dua vao documentid
	public List<ProcessType> getListProcessType(long documentReceiptId) throws Exception {
		return processTypeFinder.getListProcessType(documentReceiptId);
	}
	// end
	
}
