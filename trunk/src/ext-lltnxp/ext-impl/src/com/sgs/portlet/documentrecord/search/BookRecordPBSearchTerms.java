package com.sgs.portlet.documentrecord.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;

public class BookRecordPBSearchTerms extends BookRecordPBDisplayTerms{
	public BookRecordPBSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);
		loaiSoCV = DAOParamUtil.getLike(renderRequest, LOAI_SO_CV);
		soPB = DAOParamUtil.getLike(renderRequest, SO_PB);
	}
}
