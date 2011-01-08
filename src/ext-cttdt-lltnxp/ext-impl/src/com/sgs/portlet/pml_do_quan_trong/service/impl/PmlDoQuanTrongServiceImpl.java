package com.sgs.portlet.pml_do_quan_trong.service.impl;

import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_do_quan_trong.service.base.PmlDoQuanTrongServiceBaseImpl;
import com.liferay.portal.PortalException;
import com.liferay.portal.SystemException;
import com.liferay.portal.security.permission.ActionKeys;


public class PmlDoQuanTrongServiceImpl extends PmlDoQuanTrongServiceBaseImpl {
	public PmlDoQuanTrong addPmlDoQuanTrong(String tenDoQuanTrong)
		throws PortalException, SystemException {
		
		return pmlDoQuanTrongLocalService.addPmlDoQuanTrong( tenDoQuanTrong);
	}

	public PmlDoQuanTrong updatePmlDoQuanTrong(long idDoQuanTrong, String tenDoQuanTrong)
		throws PortalException, SystemException {

		return pmlDoQuanTrongLocalService.updatePmlDoQuanTrong(idDoQuanTrong,tenDoQuanTrong);
	}
}
