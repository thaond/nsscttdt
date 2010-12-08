package com.nss.portlet.onedoorfileprocessed.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class OneDoorFileProcessedSearchTerms extends OneDoorFileProcessedDisplayTerms {

	public OneDoorFileProcessedSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		maHoSo = DAOParamUtil.getLike(renderRequest, MAHOSO);
		tenHoSo = DAOParamUtil.getLike(renderRequest, TENHOSO);
		nam = DAOParamUtil.getLike(renderRequest, NAM);
	}

}
