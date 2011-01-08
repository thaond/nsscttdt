package com.sgs.portlet.documentrecord.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class BookRecordSearchTerms extends BookRecordDisplayTerms{
	
	public BookRecordSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		loaiSoCV = DAOParamUtil.getLike(renderRequest, LOAI_SO_CV);
		soPB = DAOParamUtil.getLike(renderRequest, SO_PB);
	}
}
