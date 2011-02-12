package com.sgs.portlet.vanbannoibo.service.impl;

import java.util.List;

import com.liferay.portal.SystemException;
import com.sgs.portlet.vanbannoibo.model.FileDinhKemVanBanNoiBo;
import com.sgs.portlet.vanbannoibo.service.base.VanBanNoiBoLocalServiceBaseImpl;


public class VanBanNoiBoLocalServiceImpl extends VanBanNoiBoLocalServiceBaseImpl {
	
	public List<FileDinhKemVanBanNoiBo> getFileDinhKemVanBanNoiBos(long idVanBanNoiBo) throws SystemException{
		return vanBanNoiBoPersistence.getFileDinhKemVanBanNoiBos(idVanBanNoiBo);
	}
}
