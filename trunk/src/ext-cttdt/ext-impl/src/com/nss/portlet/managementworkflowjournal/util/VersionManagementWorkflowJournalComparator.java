package com.nss.portlet.managementworkflowjournal.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.managementworkflowjournal.model.ManagementWorkflowJournal;

public class VersionManagementWorkflowJournalComparator extends
		OrderByComparator {
	public static String ORDER_BY_ASC = "nss_quan_ly_quy_trinh_duyet_tin.version_ ASC";
	public static String ORDER_BY_DESC = "nss_quan_ly_quy_trinh_duyet_tin.version_ DESC";
	
	private boolean _asc;
	
	public VersionManagementWorkflowJournalComparator(){
		this(false);
	}
	
	public VersionManagementWorkflowJournalComparator(boolean asc){
		this._asc = asc;
	}
	
	@Override
	public int compare(Object o1, Object o2) {
		ManagementWorkflowJournal managementWorkflowJournal1 = (ManagementWorkflowJournal)o1;
		ManagementWorkflowJournal managementWorkflowJournal2 = (ManagementWorkflowJournal)o2;
		
		int value = managementWorkflowJournal1.getVersion_()- managementWorkflowJournal2.getVersion_();
		
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
