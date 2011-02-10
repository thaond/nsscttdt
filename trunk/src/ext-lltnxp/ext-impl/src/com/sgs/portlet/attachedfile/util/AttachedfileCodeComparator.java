package com.sgs.portlet.attachedfile.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.attachedfile.model.AttachedFile;

public class AttachedfileCodeComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "attachedfilecode ASC";
	public static String ORDER_BY_DESC = "attachedfilecode DESC";
	
	private boolean _asc;
	
	public AttachedfileCodeComparator(){
		this(false);
	}
	
	public AttachedfileCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		AttachedFile name1 = (AttachedFile)arg0;
		AttachedFile name2 = (AttachedFile)arg1;
		
		int value = name1.getAttachedFileCode().compareTo(name2.getAttachedFileCode());
		
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
