package com.nss.portlet.loai_van_ban.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.loai_van_ban.model.LoaiVanBan;

public class LoaiVanBanTenLoaiVanBanComparator extends OrderByComparator {
	public static String ORDER_BY_ASC = "ten_loai_van_ban ASC";
	public static String ORDER_BY_DESC = "ten_loai_van_ban DESC";
	
	private boolean _asc;
	
	public LoaiVanBanTenLoaiVanBanComparator(){
		this(false);
	}
	
	public LoaiVanBanTenLoaiVanBanComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		LoaiVanBan loaiVB1 = (LoaiVanBan)arg0;
		LoaiVanBan loaiVB2 = (LoaiVanBan)arg1;
		
		int value = loaiVB1.getTenLoaiVanBan().compareTo(loaiVB2.getTenLoaiVanBan());
		
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
