package com.nss.portlet.thong_tin_lien_quan.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.thong_tin_lien_quan.model.ThongTinLienQuan;

public class TenThongTinLienQuanComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "ten_thong_tin_lien_quan ASC";
	public static String ORDER_BY_DESC = "ten_thong_tin_lien_quan DESC";
	
	private boolean _asc;
	
	public TenThongTinLienQuanComparator(){
		this(false);
	}
	
	public TenThongTinLienQuanComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		ThongTinLienQuan thongTinLienQuan1 = (ThongTinLienQuan)arg0;
		ThongTinLienQuan thongTinLienQuan2 = (ThongTinLienQuan)arg1;
		
		int value = thongTinLienQuan1.getTenThongTinLienQuan().compareTo(thongTinLienQuan2.getTenThongTinLienQuan());
		
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
