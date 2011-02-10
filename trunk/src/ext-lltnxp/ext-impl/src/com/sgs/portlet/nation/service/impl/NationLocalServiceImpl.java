package com.sgs.portlet.nation.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.nation.model.Nation;
import com.sgs.portlet.nation.service.base.NationLocalServiceBaseImpl;


public class NationLocalServiceImpl extends NationLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return nationFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MA_MOTA_QUOCGIA(String code, String name,	String des, boolean andOperator) throws SystemException {
		return nationFinder.countByTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator);
	}
	
	public List<Nation> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return nationFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<Nation> findTEN_MA_MOTA_QUOCGIA(String code,String name, String des, boolean andOperator, int start,
			int end, OrderByComparator obc) throws SystemException{
		return nationFinder.findTEN_MA_MOTA_QUOCGIA(code, name, des, andOperator, start, end, obc);
	}
}
