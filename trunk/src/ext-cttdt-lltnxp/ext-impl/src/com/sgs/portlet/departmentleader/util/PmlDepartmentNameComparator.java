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
public class PmlDepartmentNameComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "pml_departments.departmentsname ASC";

	public static String ORDER_BY_DESC = "pml_departments.departmentsname DESC";
	
	private final boolean _asc;
	
	public PmlDepartmentNameComparator(){
		this(false);
	}
	
	public PmlDepartmentNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		Department department1 = (Department) o1;
		Department department2 = (Department) o2;
		
		int value = department1.getDepartmentsName().compareTo(department2.getDepartmentsName());
		
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
