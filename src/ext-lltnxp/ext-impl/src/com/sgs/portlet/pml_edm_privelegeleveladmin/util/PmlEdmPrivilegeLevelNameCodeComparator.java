/**
 * 
 */
package com.sgs.portlet.pml_edm_privelegeleveladmin.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.receipt.model.PmlEdmPrivilegeLevel;

/**
 * @author canhminh
 *
 */
public class PmlEdmPrivilegeLevelNameCodeComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "privilegelevelname ASC";
	public static final String ORDER_BY_DESC = "privilegelevelname DESC";
	
	
	public PmlEdmPrivilegeLevelNameCodeComparator(){
		this(false);
	}
	
	public PmlEdmPrivilegeLevelNameCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		
		PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel1 = (PmlEdmPrivilegeLevel)o1;
		PmlEdmPrivilegeLevel pmlEdmPrivilegeLevel2 = (PmlEdmPrivilegeLevel)o2;
		
		int value = pmlEdmPrivilegeLevel1.getPrivilegeLevelName().compareTo(pmlEdmPrivilegeLevel2.getPrivilegeLevelName());
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
