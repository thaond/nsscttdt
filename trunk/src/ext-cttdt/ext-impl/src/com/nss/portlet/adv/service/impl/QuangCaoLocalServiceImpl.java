package com.nss.portlet.adv.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.adv.model.QuangCao;
import com.nss.portlet.adv.service.base.QuangCaoLocalServiceBaseImpl;


public class QuangCaoLocalServiceImpl extends QuangCaoLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return quangCaoFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String name, String des, boolean andOperator) throws SystemException{
		return quangCaoFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<QuangCao> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return quangCaoFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<QuangCao> search(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return quangCaoFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<QuangCao> findByActive(int active) {
		List<QuangCao> quangCaoList = new ArrayList<QuangCao>();
		try {
			quangCaoList = quangCaoPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return quangCaoList;
	}
}
