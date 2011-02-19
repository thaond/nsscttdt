package com.sgs.portlet.sovanbannoibo.util;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.search.RowChecker;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sgs.portlet.loaivanbannoibo.model.LoaiVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.model.SoLoaiVanBanNoiBo;
import com.sgs.portlet.sovanbannoibo.service.persistence.SoLoaiVanBanNoiBoUtil;

public class LoaiVanBanNoiBoRowChecker extends RowChecker{

	public LoaiVanBanNoiBoRowChecker(RenderResponse renderResponse) {
		super(renderResponse);
	}
	public boolean isChecked(Object obj) {
		LoaiVanBanNoiBo loaiVanBanNoiBo = (LoaiVanBanNoiBo) obj;
		List<SoLoaiVanBanNoiBo> list = new ArrayList<SoLoaiVanBanNoiBo>();
		List<SoLoaiVanBanNoiBo> listTemp = new ArrayList<SoLoaiVanBanNoiBo>();
		boolean check = false;
		try{
			long loaiVanBanNoiBoId = loaiVanBanNoiBo.getLoaiVanBanNoiBoId();
			list = SoLoaiVanBanNoiBoUtil.findByLoaiVanBanNoiBo(loaiVanBanNoiBoId);
			for(SoLoaiVanBanNoiBo soLoaiVanBanNoiBo : list){
				long soVanBanNoiBoId = soLoaiVanBanNoiBo.getSoVanBanNoiBoId(); 
				listTemp = SoLoaiVanBanNoiBoUtil.findBySoVanBanNoiBo_LoaiVanBanNoiBo(soVanBanNoiBoId, loaiVanBanNoiBoId);
				if(listTemp.size() > 0){
					check = true;
				}
			}
		}catch(Exception e){
			_log.error(e);
		}
		if (check) {
			return true;
		}
		else {
			return false;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LoaiVanBanNoiBoRowChecker.class);
}
