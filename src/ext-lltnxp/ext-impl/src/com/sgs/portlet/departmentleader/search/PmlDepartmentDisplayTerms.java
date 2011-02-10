/**
 * 
 */
package com.sgs.portlet.departmentleader.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author minhnv
 *
 */
public class PmlDepartmentDisplayTerms extends DisplayTerms{

	public static final String MA_PHONG = "maPhong";
	public static final String TEN_PHONG = "tenPhong";
	public static final String TEN_VIET_TAT = "tenVietTat";
	
	protected String maPhong;
	protected String tenPhong;
	protected String tenVietTat;

	public PmlDepartmentDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		
		maPhong = ParamUtil.getString(renderRequest, MA_PHONG);
		tenPhong = ParamUtil.getString(renderRequest, TEN_PHONG);
		tenVietTat = ParamUtil.getString(renderRequest, TEN_VIET_TAT);
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getTenVietTat() {
		return tenVietTat;
	}

	public void setTenVietTat(String tenVietTat) {
		this.tenVietTat = tenVietTat;
	}

	
}
