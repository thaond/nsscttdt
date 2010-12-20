/**
 * 
 */
package com.nss.portlet.managementworkflowonedoor.util;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author canhminh
 *
 */
public class OneDoorWorkflowUtil {
	
	public static OrderByComparator getOneDoorWorkflowOrderByComparator(
			String orderByCol, String orderByType) {
		
			boolean orderByAsc = false;
			if(orderByType.equals("asc")){
				orderByAsc = true;
			}
			
			OrderByComparator orderByComparator = null;
			
			if(orderByCol.equals("sgs_filetype_filetypeName")) {
				orderByComparator = new OneDoorWorkflowFileTypeNameComparator(orderByAsc);
			} else {
				orderByComparator = new OneDoorWorkflowFileTypeNameComparator(orderByAsc);
			}
			
			return orderByComparator;
		}

}
