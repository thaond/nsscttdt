package com.sgs.portlet.onedoor.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.onedoor.model.PmlWorkflow;
import com.sgs.portlet.onedoor.service.base.PmlWorkflowLocalServiceBaseImpl;
import com.sgs.portlet.onedoor.service.persistence.PmlWorkflowUtil;


/**
 * @author lethanhtung
 *
 */
public class PmlWorkflowLocalServiceImpl extends PmlWorkflowLocalServiceBaseImpl {
	
	/**
	 * get PmlWorkflow object by workflow and version
	 * @param workflow
	 * @param version
	 * @return PmlWorkflow
	 */
	public PmlWorkflow getByWorkflow_Version(String workflow, int version) {
		
		PmlWorkflow retValue = null;
		
		try {
			List<PmlWorkflow> list = PmlWorkflowUtil.findByWorkFlow_Version(workflow, version);
			if (list != null && list.size() > 0) {
				retValue = list.get(0);
			}
		}
		catch (SystemException e) {
			e.printStackTrace();
		}
		
		return retValue;
	}
//	minh 20100201
	
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
	
//  end	
}
