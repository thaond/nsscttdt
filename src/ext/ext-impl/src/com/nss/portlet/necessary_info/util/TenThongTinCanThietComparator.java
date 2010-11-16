package com.nss.portlet.necessary_info.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.necessary_info.model.ThongTinCanThiet;

public class TenThongTinCanThietComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "tenthongtincanthiet ASC";
	public static String ORDER_BY_DESC = "tenthongtincanthiet DESC";
	
	private boolean _asc;
	
	public TenThongTinCanThietComparator(){
		this(false);
	}
	
	public TenThongTinCanThietComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		ThongTinCanThiet thongTinCanThiet1 = (ThongTinCanThiet)arg0;
		ThongTinCanThiet thongTinCanThiet2 = (ThongTinCanThiet)arg1;
		
		int value = thongTinCanThiet1.getTenThongTinCanThiet().compareTo(thongTinCanThiet2.getTenThongTinCanThiet());
		
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
