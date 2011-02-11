package com.sgs.portlet.pmledm_filestatus.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.model.PmlFileStatus;

public class PmlFilestatusNameComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC ="filestatusname ASC";
	public static final String ORDER_BY_DESC ="filestatusname DESC";
	
	public PmlFilestatusNameComparator(){
		this(false);
	}
	
	public PmlFilestatusNameComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlFileStatus filestatusName1 = (PmlFileStatus) arg0;
		PmlFileStatus filestatusName2 = (PmlFileStatus) arg1;
		int value = filestatusName1.getFileStatusName().compareTo(filestatusName2.getFileStatusName());
		if(_asc){
			return value;
		}else{
			return -value;
		}
	}

	
	public String getOrderBy(){
		if(_asc){
			return ORDER_BY_ASC;
		}else{
			return ORDER_BY_DESC;
		}
	}
	
	private boolean _asc;
}
