package com.sgs.portlet.pml_template.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.pml_template.model.PmlTemplate;

public class MaBieuMauComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "templatecode ASC";
	public static String ORDER_BY_DESC = "templatecode DESC";
	
	private boolean _asc;
	
	public MaBieuMauComparator(){
		this(false);
	}
	
	public MaBieuMauComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		PmlTemplate template1 = (PmlTemplate)arg0;
		PmlTemplate template2 = (PmlTemplate)arg1;
		
		int value = template1.getTemplateCode().compareTo(template2.getTemplateCode());
		
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
