package com.sgs.portlet.pmledm_filestatus.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.document.model.PmlFileStatus;

public class PmlFilestatusCodeComparator extends OrderByComparator{
	public static final String ORDER_BY_ASC ="filestatuscode ASC";
	public static final String ORDER_BY_DESC ="filestatuscode DESC";

	public PmlFilestatusCodeComparator(){
		this(false);
	}
	public PmlFilestatusCodeComparator(boolean asc){
		this._asc = asc;
	}
	public int compare(Object arg0, Object arg1) {
		PmlFileStatus filestatusccode1 = (PmlFileStatus) arg0;
		PmlFileStatus filestatusccode2 = (PmlFileStatus) arg1;
		int value = filestatusccode1.getFileStatusCode().compareTo(filestatusccode2.getFileStatusCode());
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
