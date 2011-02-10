package com.sgs.portlet.doccumentprivate.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.util.ParamUtil;


public class DocumentPrivateSearchTearms extends DocumentPrivateDisplayTearms {

	public DocumentPrivateSearchTearms(RenderRequest req) {
		super(req);
		tuNgay = ParamUtil.getString(req, TU_NGAY);
		denNgay = ParamUtil.getString(req, DEN_NGAY);
		listUserId = ParamUtil.getString(req, LIST_USERID);
	}
}