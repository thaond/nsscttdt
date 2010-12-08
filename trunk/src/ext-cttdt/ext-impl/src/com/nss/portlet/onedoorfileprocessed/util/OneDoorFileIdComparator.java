package com.nss.portlet.onedoorfileprocessed.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;

public class OneDoorFileIdComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "pml_file.generalorderno ASC";
	public static String ORDER_BY_DESC = "pml_file.generalorderno DESC";
	
	private boolean _asc;
	
	public OneDoorFileIdComparator(){
		this(false);
	}
	
	public OneDoorFileIdComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object obj1, Object obj2) {
		PmlOneDoorReceiveFile file1 = (PmlOneDoorReceiveFile)obj1;
		PmlOneDoorReceiveFile file2 = (PmlOneDoorReceiveFile)obj2;
		
		int value = String.valueOf(file1.getGeneralorderno()).compareTo(String.valueOf(file2.getGeneralorderno()));
		
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
