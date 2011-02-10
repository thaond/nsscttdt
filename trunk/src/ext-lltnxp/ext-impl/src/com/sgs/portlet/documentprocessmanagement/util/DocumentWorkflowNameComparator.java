package com.sgs.portlet.documentprocessmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.manageworkflow.model.PmlManageWorkDocumentFlow;

public class DocumentWorkflowNameComparator extends OrderByComparator{

	public static final String ORDER_BY_ASC ="workflowname ASC";
	public static final String ORDER_BY_DESC ="workflowname DESC";
	
	
	public DocumentWorkflowNameComparator(){
		this(false);
	}
	
	public DocumentWorkflowNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlManageWorkDocumentFlow pmlWorkflow1 = (PmlManageWorkDocumentFlow)o1;
		PmlManageWorkDocumentFlow pmlWorkflow2 = (PmlManageWorkDocumentFlow)o2;
		
		int value = pmlWorkflow1.getWorkFlowName().compareTo(pmlWorkflow2.getWorkFlowName());
		if(_asc){
			return value;
		}else{
			return -value;
		}
	}

	@Override
	public String getOrderBy(){
		if(_asc){
			return ORDER_BY_ASC;
		}else{
			return ORDER_BY_DESC;
		}
	}
	
	private final boolean _asc;
}