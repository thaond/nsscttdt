package com.sgs.portlet.pml_trang_thai_hscv.service.impl;

import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
import com.sgs.portlet.pml_trang_thai_hscv.service.base.PmlTrangThaiHSCVServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.security.permission.ActionKeys;


public class PmlTrangThaiHSCVServiceImpl extends PmlTrangThaiHSCVServiceBaseImpl {
	public PmlTrangThaiHSCV addPmlTrangThaiHSCV(String tenTinhChat)
		throws PortalException, SystemException {
		
		return pmlTrangThaiHSCVLocalService.addPmlTrangThaiHSCV( tenTinhChat);
	}

	public PmlTrangThaiHSCV updatePmlTrangThaiHSCV(long idTinhChat, String tenTinhChat)
		throws PortalException, SystemException {

		return pmlTrangThaiHSCVLocalService.updatePmlTrangThaiHSCV(idTinhChat,tenTinhChat);
	}
}
