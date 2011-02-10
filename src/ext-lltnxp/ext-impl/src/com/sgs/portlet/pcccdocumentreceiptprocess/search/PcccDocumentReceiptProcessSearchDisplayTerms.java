package com.sgs.portlet.pcccdocumentreceiptprocess.search;


import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PcccDocumentReceiptProcessSearchDisplayTerms extends DisplayTerms{
	
	public static final String CAPGUI = "capgui";
	public static final String LOAISOCONGVAN = "loaisocongvan";
	protected int capgui;
	protected int loaisocongvan;
	
	public PcccDocumentReceiptProcessSearchDisplayTerms(
			RenderRequest renderRequest) {
		super(renderRequest);
		capgui =  ParamUtil.getInteger(renderRequest, CAPGUI);
		loaisocongvan = ParamUtil.getInteger(renderRequest, LOAISOCONGVAN);
	}

	public int getCapgui() {
		return capgui;
	}

	public void setCapgui(int capgui) {
		this.capgui = capgui;
	}

	public int getLoaisocongvan() {
		return loaisocongvan;
	}

	public void setLoaisocongvan(int loaisocongvan) {
		this.loaisocongvan = loaisocongvan;
	}
	
}
