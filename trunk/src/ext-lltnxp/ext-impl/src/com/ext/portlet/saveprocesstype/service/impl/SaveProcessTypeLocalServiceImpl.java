package com.ext.portlet.saveprocesstype.service.impl;

import java.util.List;
import com.ext.portlet.saveprocesstype.model.SaveProcessType;
import com.ext.portlet.saveprocesstype.service.base.SaveProcessTypeLocalServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.ext.portlet.processtype.model.impl.ProcessTypeImpl;


public class SaveProcessTypeLocalServiceImpl
    extends SaveProcessTypeLocalServiceBaseImpl {
	
	public SaveProcessType getSaveProcessTypeById(long id) throws SystemException, PortalException {
		return saveProcessTypePersistence.findByPrimaryKey(id);
	}
	
	public List<SaveProcessType> getProcessTypeByDocId(long docId) throws SystemException, PortalException {
		return saveProcessTypePersistence.findByDocId(docId);
	}
}
