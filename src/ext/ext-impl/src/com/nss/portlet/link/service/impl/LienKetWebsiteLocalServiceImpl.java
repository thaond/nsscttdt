package com.nss.portlet.link.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.nss.portlet.link.model.LienKetWebsite;
import com.nss.portlet.link.service.base.LienKetWebsiteLocalServiceBaseImpl;


public class LienKetWebsiteLocalServiceImpl
    extends LienKetWebsiteLocalServiceBaseImpl {
	public int countByKeywords(String keywords) throws SystemException{
		return lienKetWebsiteFinder.countByKeywords(keywords);
	}
	
	public int countByTEN_MOTA(String name, String des, boolean andOperator) throws SystemException{
		return lienKetWebsiteFinder.countByTEN_MOTA(name, des, andOperator);
	}
	
	public List<LienKetWebsite> findByKeywords(String keywords,int start, int end, OrderByComparator obc) throws SystemException{
		return lienKetWebsiteFinder.findByKeywords(keywords, start, end, obc);
	}
	
	public List<LienKetWebsite> findTEN_MOTA(String name, String des, boolean andOperator, int start, int end, OrderByComparator obc) throws SystemException {
		return lienKetWebsiteFinder.findTEN_MOTA(name, des, andOperator, start, end, obc);
	}
	
	public List<LienKetWebsite> getListLienKetWebsiteByLoaiWebsiteId(long maLoaiWebsite) {
		List<LienKetWebsite> lienKetWebsiteList = new ArrayList<LienKetWebsite>();
		try {
			lienKetWebsiteList = lienKetWebsitePersistence.findByLoaiWebsiteId(maLoaiWebsite);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		
		return lienKetWebsiteList;
	}
	
	public List<LienKetWebsite> findByMaLoaiWebsite_Active(long maLoaiWebsite, int active) {
		List<LienKetWebsite> lienKetWebsiteList = new ArrayList<LienKetWebsite>();
		try {
			lienKetWebsiteList = lienKetWebsitePersistence.findByLoaiWebsiteId_Active(maLoaiWebsite, active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return lienKetWebsiteList;
	}
	
	public List<LienKetWebsite> findByActive(int active) {
		List<LienKetWebsite> lienKetWebsiteList = new ArrayList<LienKetWebsite>();
		try {
			lienKetWebsiteList = lienKetWebsitePersistence.findByActive(active);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		return lienKetWebsiteList;
	}
}
