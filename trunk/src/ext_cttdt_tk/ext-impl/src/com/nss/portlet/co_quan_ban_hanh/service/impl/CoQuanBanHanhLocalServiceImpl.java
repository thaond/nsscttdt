package com.nss.portlet.co_quan_ban_hanh.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.co_quan_ban_hanh.model.CoQuanBanHanh;
import com.nss.portlet.co_quan_ban_hanh.service.base.CoQuanBanHanhLocalServiceBaseImpl;


public class CoQuanBanHanhLocalServiceImpl
    extends CoQuanBanHanhLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return coQuanBanHanhFinder.countByKeywords(keywords);
	}
	
	public int searchCount(String name, String des, boolean andOperator) throws SystemException{
		return coQuanBanHanhFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<CoQuanBanHanh> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return coQuanBanHanhFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<CoQuanBanHanh> search(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return coQuanBanHanhFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<CoQuanBanHanh> findByActive(int active) {
		List<CoQuanBanHanh> coQuanBanHanhList = new ArrayList<CoQuanBanHanh>();
		try {
			coQuanBanHanhList = coQuanBanHanhPersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return coQuanBanHanhList;
	}
}
