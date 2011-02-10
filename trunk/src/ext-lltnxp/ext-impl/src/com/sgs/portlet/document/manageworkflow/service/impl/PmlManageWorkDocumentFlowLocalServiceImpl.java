package com.sgs.portlet.document.manageworkflow.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;
import com.sgs.portlet.document.manageworkflow.service.base.PmlManageWorkDocumentFlowLocalServiceBaseImpl;


public class PmlManageWorkDocumentFlowLocalServiceImpl
    extends PmlManageWorkDocumentFlowLocalServiceBaseImpl {
	
//	minh 20100201
	
	public int searchCount(String keywords) throws SystemException{
		return pmlManageWorkDocumentFlowFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String workflowName, String description, boolean andOperator) throws SystemException{
		return pmlManageWorkDocumentFlowFinder.countByDocumentWorkflow(workflowName, description, andOperator);
	}
	
	public List<PmlManageWorkDocumentFlow> search(String keywords, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlManageWorkDocumentFlowFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<PmlManageWorkDocumentFlow> search(String workflowName, String description, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException{
		return pmlManageWorkDocumentFlowFinder.findByDocumentWorkflow(workflowName, description, andOperator, start, end, obc);
	}
	
//  end	
}
