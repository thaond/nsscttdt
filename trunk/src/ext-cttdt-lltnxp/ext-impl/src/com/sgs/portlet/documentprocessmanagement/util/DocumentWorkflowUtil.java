package com.sgs.portlet.documentprocessmanagement.util;

import com.liferay.portal.kernel.util.OrderByComparator;

public class DocumentWorkflowUtil {


	public static OrderByComparator getDocumentWorkflowOrderByComparator(
			String orderByCol, String orderByType) {
		
		boolean orderByAsc = false;
		if (orderByType.equals("asc")) {
			orderByAsc = true;
		}
		
		OrderByComparator orderByComparator = null;
		
		if(orderByCol.equals("sgs_onedoor_workflowadmin_workflow")) {
			orderByComparator = new DocumentWorkflowNameComparator(orderByAsc);
		} else {
			orderByComparator = new DocumentWorkflowNameComparator(orderByAsc);
		}
		
		return orderByComparator;
	}

}
