/**
 * 
 */
package com.nss.portlet.department.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.department.model.Department;

/**
 * @author canhminh
 *
 */
public class PmlDepartmentAbbreviateNameComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_departments.abbreviatename ASC";

	public static String ORDER_BY_DESC = "pml_departments.abbreviatename DESC";
	
	private final boolean _asc;
	
	public PmlDepartmentAbbreviateNameComparator(){
		this(false);
	}
	
	public PmlDepartmentAbbreviateNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		Department department1 = (Department) o1;
		Department department2 = (Department) o2;
		
		int value = department1.getAbbreviateName().compareTo(department2.getAbbreviateName());
		
		if(this._asc){
			return value;
		}else{
			return -value;
		}
	}
	
	@Override
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}
}
