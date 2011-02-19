package com.sgs.portlet.sovanbannoibo.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class SoVanBanNoiBoDisplayTerms extends DisplayTerms{

	public static final String MASOVANBANNOIBO = "maSoVanBanNoiBo";
	public static final String TENSOVANBANNOIBO = "tenSoVanBanNoiBo";
	
	protected String maSoVanBanNoiBo;
	protected String tenSoVanBanNoiBo;

	public SoVanBanNoiBoDisplayTerms(RenderRequest request) {
		super(request);
		maSoVanBanNoiBo = ParamUtil.getString(request, MASOVANBANNOIBO);
		tenSoVanBanNoiBo = ParamUtil.getString(request, TENSOVANBANNOIBO);
	}

	public String getMaSoVanBanNoiBo() {
		return maSoVanBanNoiBo;
	}

	public void setMaSoVanBanNoiBo(String maSoVanBanNoiBo) {
		this.maSoVanBanNoiBo = maSoVanBanNoiBo;
	}

	public String getTenSoVanBanNoiBo() {
		return tenSoVanBanNoiBo;
	}

	public void setTenSoVanBanNoiBo(String tenSoVanBanNoiBo) {
		this.tenSoVanBanNoiBo = tenSoVanBanNoiBo;
	}
}
