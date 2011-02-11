/**
 * 
 */
package com.sgs.portlet.pcccdocumentsendprocess.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author minh.nv
 *
 */
public class PcccDocumentSendProcessSearchDisplayTerms extends DisplayTerms{
	public static final String LOAISOCONGVAN = "loaisocongvan";
	protected int loaiSoCongVan;
	
	public PcccDocumentSendProcessSearchDisplayTerms(
			RenderRequest renderRequest) {
		super(renderRequest);
		loaiSoCongVan =  ParamUtil.getInteger(renderRequest, LOAISOCONGVAN);
	}

	public int getLoaiSoCongVan() {
		return loaiSoCongVan;
	}

	public void setLoaiSoCongVan(int loaiSoCongVan) {
		this.loaiSoCongVan = loaiSoCongVan;
	}

	
}
