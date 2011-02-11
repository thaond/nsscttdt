/**
 * 
 */
package com.sgs.portlet.workflow_admin.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.filetype.service.PmlFileTypeLocalServiceUtil;
import com.sgs.portlet.onedoor.model.PmlWorkflow;

/**
 * @author canhminh
 *
 */
public class OneDoorWorkflowFileTypeNameComparator extends OrderByComparator{

	public static final String ORDER_BY_ASC ="pml_filetype.filetypename ASC";
	public static final String ORDER_BY_DESC ="pml_filetype.filetypename DESC";
	
	
	public OneDoorWorkflowFileTypeNameComparator(){
		this(false);
	}
	
	public OneDoorWorkflowFileTypeNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlWorkflow pmlWorkflow1 = (PmlWorkflow)o1;
		PmlWorkflow pmlWorkflow2 = (PmlWorkflow)o2;
		String nameFiletype1 = "";
		String nameFiletype2 = "";
		try {
			nameFiletype1 = PmlFileTypeLocalServiceUtil.getPmlFileType(pmlWorkflow1.getFileTypeId()).getFileTypeName();
			nameFiletype2 = PmlFileTypeLocalServiceUtil.getPmlFileType(pmlWorkflow2.getFileTypeId()).getFileTypeName();
		} catch (Exception e) {			
		}
		
		int value = nameFiletype1.compareTo(nameFiletype2);
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
