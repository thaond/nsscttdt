package com.nss.portlet.qa_cau_tra_loi.searchCauHoi;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class QACauHoiDisplayTerms extends DisplayTerms{
	public static String TIEU_DE_CAU_HOI = "tieuDeCauHoi";
	public static String MA_CHU_DE_CAU_HOI = "maChuDeCauHoi";
	
	protected String tieuDeCauHoi;
	protected long maChuDeCauHoi;
	
	public QACauHoiDisplayTerms(PortletRequest portletRequest) {
		super(portletRequest);
		tieuDeCauHoi = ParamUtil.getString(portletRequest, TIEU_DE_CAU_HOI);
		maChuDeCauHoi = ParamUtil.getLong(portletRequest, MA_CHU_DE_CAU_HOI, 0);
	}
	
	public String getTieuDeCauHoi() {
		return tieuDeCauHoi;
	}
	
	public void setTieuDeCauHoi(String tieuDeCauHoi) {
		this.tieuDeCauHoi = tieuDeCauHoi;
	}
	
	public long getMaChuDeCauHoi() {
		return maChuDeCauHoi;
	}
	
	public void setMaChuDeCauHoi(long maCauHoi) {
		this.maChuDeCauHoi = maCauHoi;
	}
}
