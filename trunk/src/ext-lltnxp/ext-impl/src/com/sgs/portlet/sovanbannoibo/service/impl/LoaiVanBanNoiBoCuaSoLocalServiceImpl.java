package com.sgs.portlet.sovanbannoibo.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.sgs.portlet.sovanbannoibo.model.LoaiVanBanNoiBoCuaSo;
import com.sgs.portlet.sovanbannoibo.service.base.LoaiVanBanNoiBoCuaSoLocalServiceBaseImpl;


public class LoaiVanBanNoiBoCuaSoLocalServiceImpl extends LoaiVanBanNoiBoCuaSoLocalServiceBaseImpl {
	
	public int countByKeyword(String keyword) throws SystemException{
		return loaiVanBanNoiBoCuaSoFinder.countByKeywords(keyword);
	}
	
	public List<LoaiVanBanNoiBoCuaSo> findByKeyword(String keyword, int start, int end, OrderByComparator obc) throws SystemException{
		return loaiVanBanNoiBoCuaSoFinder.findByKeywords(keyword, start, end, obc);
	}
	
	public int countLoaiVanBanNoiBo(String kyHieuLoaiVanBanNoiBos, String tenLoaiVanBanNoiBos, boolean andOperator) throws SystemException {
		return loaiVanBanNoiBoCuaSoFinder.count_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos, tenLoaiVanBanNoiBos, andOperator);
	}
	
	public List<LoaiVanBanNoiBoCuaSo> findLoaiVanBanNoiBo(String kyHieuLoaiVanBanNoiBos, String tenLoaiVanBanNoiBos, int start, int end, boolean andOperator, OrderByComparator obc) throws SystemException{
		return loaiVanBanNoiBoCuaSoFinder.find_loai_van_ban_noi_bo(kyHieuLoaiVanBanNoiBos, tenLoaiVanBanNoiBos, start, end, andOperator, obc);
	}
}
