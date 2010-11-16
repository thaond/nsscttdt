package com.nss.portlet.qa_chu_de.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.qa_chu_de.model.QAChuDeCauHoi;

public class TenChuDeCauHoiComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "tenchudecauhoi ASC";
	public static String ORDER_BY_DESC = "tenchudecauhoi DESC";
	
	private boolean _asc;
	
	public TenChuDeCauHoiComparator(){
		this(false);
	}
	
	public TenChuDeCauHoiComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		QAChuDeCauHoi chuDeCauHoi1 = (QAChuDeCauHoi)arg0;
		QAChuDeCauHoi chuDeCauHoi2 = (QAChuDeCauHoi)arg1;
		
		int value = chuDeCauHoi1.getTenChuDeCauHoi().compareTo(chuDeCauHoi2.getTenChuDeCauHoi());
		
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
