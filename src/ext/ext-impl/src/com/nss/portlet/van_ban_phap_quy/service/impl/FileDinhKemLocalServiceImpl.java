package com.nss.portlet.van_ban_phap_quy.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.SystemException;
import com.nss.portlet.van_ban_phap_quy.model.FileDinhKem;
import com.nss.portlet.van_ban_phap_quy.service.base.FileDinhKemLocalServiceBaseImpl;


public class FileDinhKemLocalServiceImpl extends FileDinhKemLocalServiceBaseImpl {
	
	public FileDinhKem getVanBanPhapQuy_PhienBan (long maVanBanPhapQuyId) {
		List<FileDinhKem> fileDinhKemList = new ArrayList<FileDinhKem>();
		FileDinhKem fileDinhKem = null;
		try {
			fileDinhKemList = fileDinhKemPersistence.findBymaVanBanPhapQuy(maVanBanPhapQuyId);
			fileDinhKemList = fileDinhKemPersistence.findBymaVanBanPhapQuy_PhienBan(maVanBanPhapQuyId, fileDinhKemList.size());
			if (!fileDinhKemList.isEmpty()) {
				fileDinhKem = fileDinhKemList.get(0);
			}
			
		} catch (Exception e) {
			 
		}
		return fileDinhKem;
		
	}
	
	public List<FileDinhKem> getListFileDinhKemByMaVanBanPhapQuy(long maVanBanPhapQuyId) {
		List<FileDinhKem> fileDinhKemList = new ArrayList<FileDinhKem>();
		try {
			fileDinhKemList = fileDinhKemPersistence.findBymaVanBanPhapQuy(maVanBanPhapQuyId);
		} catch (Exception e) {	 
		}
		return fileDinhKemList;
		
	}
	
	public int countFileDinhKem(long maVanBanPhapQuy) throws SystemException {
		return fileDinhKemFinder.countFileDinhKem(maVanBanPhapQuy);
	}
	
	public List<FileDinhKem> findFileDinhKem(long maVanBanPhapQuy, int start, int end) throws SystemException {
		return fileDinhKemFinder.findFileDinhKem(maVanBanPhapQuy, start, end);
	}
}
