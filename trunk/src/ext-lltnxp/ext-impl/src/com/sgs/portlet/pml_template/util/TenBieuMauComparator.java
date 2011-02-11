package com.sgs.portlet.pml_template.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_template.model.PmlTemplate;

public class TenBieuMauComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "templatename ASC";
	public static String ORDER_BY_DESC = "templatename DESC";
	
	private boolean _asc;
	
	public TenBieuMauComparator(){
		this(false);
	}
	
	public TenBieuMauComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlTemplate template1 = (PmlTemplate)arg0;
		PmlTemplate template2 = (PmlTemplate)arg1;
		
		int value = template1.getTemplateName().compareTo(template2.getTemplateName());
		
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
