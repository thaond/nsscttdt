package com.nss.portlet.adv.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.adv.model.QuangCao;


public class TenQuangCaoComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "tenquangcao ASC";
	public static String ORDER_BY_DESC = "tenquangcao DESC";
	
	private boolean _asc;
	
	public TenQuangCaoComparator(){
		this(false);
	}
	
	public TenQuangCaoComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		QuangCao quangCao1 = (QuangCao)arg0;
		QuangCao quangCao2 = (QuangCao)arg1;
		
		int value = quangCao1.getTenQuangCao().compareTo(quangCao2.getTenQuangCao());
		
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
