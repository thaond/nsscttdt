package com.sgs.portlet.organizationexternal.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.organizationexternal.model.OrganizationExternal;

@SuppressWarnings("serial")
public class OrgExternalNameComparator extends OrderByComparator {
	
	public static final String ORDER_BY_ASC = "orgexternalname ASC";
	public static final String ORDER_BY_DESC ="orgexternalname DESC";

	public OrgExternalNameComparator() {
		this(false);
	}
	
	public OrgExternalNameComparator(boolean asc) {
		this._asc = asc;
	}
	
	public int compare(Object arg0, Object arg1) {
		OrganizationExternal orgExternal1 = (OrganizationExternal)arg0;
		OrganizationExternal orgExternal2 = (OrganizationExternal)arg1;
		int value = orgExternal1.getOrgExternalName().compareTo(orgExternal2.getOrgExternalName());
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
