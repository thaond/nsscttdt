package com.nss.portlet.partner.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.partner.model.Partner;
import com.nss.portlet.partner.service.base.PartnerLocalServiceBaseImpl;


public class PartnerLocalServiceImpl extends PartnerLocalServiceBaseImpl {
	
	public int countByKeywords(String keywords) throws SystemException{
		return partnerFinder.countByKeywords(keywords);
	}
	
	public List<Partner> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return partnerFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public int countByTEN_MOTA(String name, String des, boolean andOperator) throws SystemException{
		return partnerFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<Partner> findTEN_MOTA(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return partnerFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
}
