package com.nss.portlet.linh_vuc_van_ban.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.linh_vuc_van_ban.model.LinhVucVanBan;

public class LinhVucVanBanTenLinhVucVanBanComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "ten_linh_vuc_van_ban ASC";
	public static String ORDER_BY_DESC = "ten_linh_vuc_van_ban DESC";
	
	private boolean _asc;
	
	public LinhVucVanBanTenLinhVucVanBanComparator(){
		this(false);
	}
	
	public LinhVucVanBanTenLinhVucVanBanComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		LinhVucVanBan linhVucVB1 = (LinhVucVanBan)arg0;
		LinhVucVanBan linhVucVB2 = (LinhVucVanBan)arg1;
		
		int value = linhVucVB1.getTenLinhVucVanBan().compareTo(linhVucVB2.getTenLinhVucVanBan());
		
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
