/**
 * 
 */
package com.sgs.portlet.departmentleader.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.department.model.Department;

/**
 * @author canhminh
 *
 */
public class PmlDepartmentCodeComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_departments.departmentscode ASC";

	public static String ORDER_BY_DESC = "pml_departments.departmentscode DESC";
	
	private final boolean _asc;
	
	public PmlDepartmentCodeComparator(){
		this(false);
	}
	
	public PmlDepartmentCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		Department department1 = (Department) o1;
		Department department2 = (Department) o2;
		
		int value = department1.getDepartmentsCode().compareTo(department2.getDepartmentsCode());
		
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
