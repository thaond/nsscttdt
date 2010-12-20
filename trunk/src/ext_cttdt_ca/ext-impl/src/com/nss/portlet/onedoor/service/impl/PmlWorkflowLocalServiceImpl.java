package com.nss.portlet.onedoor.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.onedoor.model.PmlWorkflow;
import com.nss.portlet.onedoor.service.base.PmlWorkflowLocalServiceBaseImpl;
import com.nss.portlet.onedoor.service.persistence.PmlWorkflowUtil;


public class PmlWorkflowLocalServiceImpl extends PmlWorkflowLocalServiceBaseImpl {
	
	
	public int searchCount(String keywords) throws SystemException{
		return pmlWorkflowFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String fileTypeName, String workflowName, boolean andOperator) throws SystemException{
		return pmlWorkflowFinder.countByOneDoorWoorkflow(fileTypeName, workflowName, andOperator);
	}
	
	public List<PmlWorkflow> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlWorkflowFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<PmlWorkflow> search(String fileTypeName, String workflowName, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlWorkflowFinder.findByOneDoorWoorkflow(fileTypeName, workflowName, andOperator, start, end, obc);
	}
	
	public List<PmlWorkflow> findByWorkFlow_Version(String nameProcess, int version) throws SystemException {
			return pmlWorkflowPersistence.findByWorkFlow_Version(nameProcess, version);
	}
	public List<PmlWorkflow> findByFileTypeId(String fileTypeId) throws SystemException {
			return pmlWorkflowPersistence.findByFileTypeId(fileTypeId);
	}
	
	public List<PmlWorkflow> findByFileTypeId_Version (String fileTypeId , int version) throws SystemException {
		return  PmlWorkflowUtil.findByFileTypeId_Version(fileTypeId , version);
	}
	
}
