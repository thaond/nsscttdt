package com.sgs.portlet.generatetemplateid.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.agency.model.Agency;
import com.sgs.portlet.generatetemplateid.model.IdTemplate;


public class TemplateCodeComparator extends OrderByComparator{
	public static String ORDER_BY_ASC = "format ASC";
	public static String ORDER_BY_DESC = "format DESC";
	
	private boolean _asc;
	
	public TemplateCodeComparator(){
		this(false);
	}
	
	public TemplateCodeComparator(boolean asc){
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		IdTemplate template1 = (IdTemplate)arg0;
		IdTemplate template2 = (IdTemplate)arg1;
		
		int value = template1.getFormat().compareTo(template2.getFormat());
		
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
