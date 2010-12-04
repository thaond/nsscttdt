/**
 * 
 */
package com.nss.portlet.documentfield.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PmlFieldDisplayTerms extends DisplayTerms {
	public static final String MA_PHAN_LOAI = "maPhanLoai";
	public static final String TEN_PHAN_LOAI = "tenPhanLoai";
	
	protected String maPhanLoai;
	protected String tenPhanLoai;
	
	public PmlFieldDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		maPhanLoai = ParamUtil.getString(renderRequest, MA_PHAN_LOAI);
		tenPhanLoai = ParamUtil.getString(renderRequest, TEN_PHAN_LOAI);
	}

	public String getMaPhanLoai() {
		return maPhanLoai;
	}

	public void setMaPhanLoai(String maPhanLoai) {
		this.maPhanLoai = maPhanLoai;
	}

	public String getTenPhanLoai() {
		return tenPhanLoai;
	}

	public void setTenPhanLoai(String tenPhanLoai) {
		this.tenPhanLoai = tenPhanLoai;
	}

}
