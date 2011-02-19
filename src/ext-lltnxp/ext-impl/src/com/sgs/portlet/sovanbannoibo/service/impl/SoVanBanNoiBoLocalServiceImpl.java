package com.sgs.portlet.sovanbannoibo.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.sovanbannoibo.model.SoVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.service.base.SoVanBanNoiBoLocalServiceBaseImpl;


public class SoVanBanNoiBoLocalServiceImpl extends SoVanBanNoiBoLocalServiceBaseImpl {
	
	public int countByKeyword(String keyword) throws SystemException{
		return soVanBanNoiBoFinder.countByKeywords(keyword);
	}
	
	public List<SoVanBanNoiBo> findByKeyword(String keyword, int start, int end, OrderByComparator obc) throws SystemException{
		return soVanBanNoiBoFinder.findByKeywords(keyword, start, end, obc);
	}
	
	public int countSoVanBanNoiBo(String maSoVanBanNoiBos, String tenSoVanBanNoiBos, boolean andOperator) throws SystemException {
		return soVanBanNoiBoFinder.count_so_van_ban_noi_bo(maSoVanBanNoiBos, tenSoVanBanNoiBos, andOperator);
	}
	
	public List<SoVanBanNoiBo> findSoVanBanNoiBo(String maSoVanBanNoiBos, String tenSoVanBanNoiBos, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return soVanBanNoiBoFinder.find_so_van_ban_noi_bo(maSoVanBanNoiBos, tenSoVanBanNoiBos, start, end, andOperator, obc);
	}
}
