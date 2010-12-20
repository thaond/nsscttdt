package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.onedoor.model.PmlStateWorkFlow;
import com.nss.portlet.onedoor.service.base.PmlStateWorkFlowLocalServiceBaseImpl;
import com.nss.portlet.onedoor.service.persistence.PmlStateWorkFlowUtil;


public class PmlStateWorkFlowLocalServiceImpl
    extends PmlStateWorkFlowLocalServiceBaseImpl {
	public List<PmlStateWorkFlow> findByWorkFlow_StateProcessId_Version(String workflow, long stateProcessNext, int version) throws SystemException {
			return PmlStateWorkFlowUtil.findByWorkFlow_StateProcessId_Version(workflow, stateProcessNext, version);
	} 
}
