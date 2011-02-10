package com.sgs.portlet.onedoorfileprocessed.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.onedoorpccc.model.PmlFilePCCC;

public class OneDoorFileNameComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_file_pccc.filename ASC";
	public static String ORDER_BY_DESC = "pml_file_pccc.filename DESC";
	
	private boolean _asc;
	
	public OneDoorFileNameComparator(){
		this(false);
	}
	
	public OneDoorFileNameComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlFilePCCC filePCCC1 = (PmlFilePCCC)obj1;
		PmlFilePCCC filePCCC2 = (PmlFilePCCC)obj2;
		
		int value = filePCCC1.getFileName().compareTo(filePCCC2.getFileName());
		
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
