package com.sgs.portlet.documentdelegate.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.documentdelegate.model.PmlDocumentDelegate;
import com.sgs.portlet.documentdelegate.service.base.PmlDocumentDelegateLocalServiceBaseImpl;


public class PmlDocumentDelegateLocalServiceImpl
    extends PmlDocumentDelegateLocalServiceBaseImpl {
	
	public List<PmlDocumentDelegate> getPmlDocumentDelegate_SD_TD_USERISDELEGATE(long userDelegate, 
			String fromDateDelegate, String toDateDelegate, String listUserIsDelegate, int start, int end, OrderByComparator obc){
				try {
					return pmlDocumentDelegateFinder.findBy_SD_TD_USERISDELEGATE(userDelegate, 
							fromDateDelegate, toDateDelegate, listUserIsDelegate, start, end, obc);
				} catch (SystemException e) {
					e.printStackTrace();
				}
				return new ArrayList<PmlDocumentDelegate>();
		
	}
	
	public int countPmlDocumentDelegate_SD_TD_USERISDELEGATE(long userDelegate, 
			String fromDateDelegate, String toDateDelegate, String listUserIsDelegate){
				try {
					return pmlDocumentDelegateFinder.countBy_SD_TD_USERISDELEGATE(userDelegate, 
							fromDateDelegate, toDateDelegate, listUserIsDelegate);
				} catch (SystemException e) {
					e.printStackTrace();
				}
			return -1;
		
	}
}
