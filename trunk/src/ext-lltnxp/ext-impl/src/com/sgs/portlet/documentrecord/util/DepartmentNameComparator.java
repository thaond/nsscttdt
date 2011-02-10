package com.sgs.portlet.documentrecord.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.department.model.Department;

public class DepartmentNameComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_departments.departmentsname ASC";

	public static String ORDER_BY_DESC = "pml_departments.departmentsname DESC";
	
	private boolean _asc;
	
	public DepartmentNameComparator(){
		this(false);
	}
	
	public DepartmentNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		Department department1 = (Department)arg0;
		Department department2 = (Department)arg1;
		
		int value = department1.getDepartmentsName().compareTo(department2.getDepartmentsName());
		
		
		if(this._asc){
			return value;
		}else{
			return -value;
		}
	}
	
	public String getOrderBy() {
		if (_asc) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}
}
