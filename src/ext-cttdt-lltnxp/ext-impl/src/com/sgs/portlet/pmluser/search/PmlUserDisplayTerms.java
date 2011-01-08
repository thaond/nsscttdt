/**
 * 
 */
package com.sgs.portlet.pmluser.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * @author canhminh
 *
 */
public class PmlUserDisplayTerms extends DisplayTerms {
	public static final String TEN_GOI = "tenGoi";
	public static final String HO = "ho";
	public static final String LOT = "lot";
	public static final String TEN = "ten";
	public static final String CHUC_VU = "chucVu";

	protected String tenGoi;
	protected String ho;
	protected String lot;
	protected String ten;
	protected String chucVu;
	
	public PmlUserDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);
		tenGoi = ParamUtil.getString(renderRequest, TEN_GOI);
		ho = ParamUtil.getString(renderRequest, HO);
		lot = ParamUtil.getString(renderRequest, LOT);
		ten = ParamUtil.getString(renderRequest, TEN);
		chucVu = ParamUtil.getString(renderRequest, CHUC_VU);
	}

	public String getTenGoi() {
		return tenGoi;
	}

	public void setTenGoi(String tenGoi) {
		this.tenGoi = tenGoi;
	}

	

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

}
