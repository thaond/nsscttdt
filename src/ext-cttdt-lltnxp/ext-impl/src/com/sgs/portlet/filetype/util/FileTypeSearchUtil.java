/**
 * 
 */
package com.sgs.portlet.filetype.util;

import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * @author canhminh
 *
 */
public class FileTypeSearchUtil {

	
	public static OrderByComparator getFileTypeOrderByComparator(
			String orderByCol, String orderByType) {		
			
			boolean orderByAsc = false;
			if (orderByType.equals("asc")) {
				orderByAsc = true;
			}
			
			OrderByComparator orderByComparator = null;
			
			if(orderByCol.equals("sgs_filetype_filetypeCode")) {
				orderByComparator = new FileTypeCodeComparator(orderByAsc);
			} else  if (orderByCol.equals("sgs_filetype_filetypeName")) {
				orderByComparator = new FileTypeNameComparator(orderByAsc);		
			} 
			return orderByComparator;
	}

}
