package com.sgs.portlet.onedoorfileprocessed.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class OneDoorFileProcessedDisplayTerms extends DisplayTerms{
	public static final String MAHOSO = "maHoSo";
	public static final String TENHOSO = "tenHoSo";
	public static final String NAM = "nam";
	
	protected String maHoSo;
	protected String tenHoSo;
	protected String nam;
	
	public OneDoorFileProcessedDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		maHoSo = ParamUtil.getString(renderRequest, MAHOSO);
		tenHoSo = ParamUtil.getString(renderRequest, TENHOSO);
		nam = ParamUtil.getString(renderRequest, NAM);
	}

	public String getMaHoSo() {
		return maHoSo;
	}

	public void setMaHoSo(String maHoSo) {
		this.maHoSo = maHoSo;
	}

	public String getTenHoSo() {
		return tenHoSo;
	}

	public void setTenHoSo(String tenHoSo) {
		this.tenHoSo = tenHoSo;
	}

	public String getNam() {
		return nam;
	}

	public void setNam(String nam) {
		this.nam = nam;
	}

	
}
