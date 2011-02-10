package com.sgs.portlet.deleteprocessinstance.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class DeleteDocumentSendUnpublishDisplayTerms extends DisplayTerms{
	public static final String LOAIVB = "loaiVB";
	public static final String NGUOIKY = "nguoiKy";
	
	protected long loaiVB;
	protected String nguoiKy;
	
	public DeleteDocumentSendUnpublishDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		loaiVB = ParamUtil.getLong(renderRequest, LOAIVB);
		nguoiKy = ParamUtil.getString(renderRequest, NGUOIKY);
	}

	public long getLoaiVB() {
		return loaiVB;
	}

	public void setLoaiVB(long loaiVB) {
		this.loaiVB = loaiVB;
	}

	public String getNguoiKy() {
		return nguoiKy;
	}

	public void setNguoiKy(String nguoiKy) {
		this.nguoiKy = nguoiKy;
	}

}
