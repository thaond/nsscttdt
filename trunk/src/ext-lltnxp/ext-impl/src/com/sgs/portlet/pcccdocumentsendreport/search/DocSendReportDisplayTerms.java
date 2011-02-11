package com.sgs.portlet.pcccdocumentsendreport.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.RenderRequest;

/**
 *
 * @author XUANCONG
 *
 */
public class DocSendReportDisplayTerms extends DisplayTerms {
	
	public static final String SOPH = "soPH";
	public static final String NGAYPHMONTH = "ngayPHMonth";
	public static final String NGAYPHYEAR = "ngayPHYear";
	public static final String PHONGST = "phongST";
	public static final String NOINHAN = "noiNhan";
	public static final String LOAIVB = "loaiVB";
	public static final String NGUOIKY = "nguoiKy";
	public static final String NGUOIST = "nguoiST";
	public static final String TRICHYEU = "trichYeu";
	public static final String VANBANPH = "vanBanPH";

	public DocSendReportDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soPH = ParamUtil.getString(renderRequest, SOPH);
		ngayPHMonth = ParamUtil.getInteger(renderRequest, NGAYPHMONTH, 0);
		ngayPHYear = ParamUtil.getInteger(renderRequest, NGAYPHYEAR, 0);
		phongST = ParamUtil.getString(renderRequest, PHONGST);
		noiNhan = ParamUtil.getString(renderRequest, NOINHAN);
		loaiVB = ParamUtil.getLong(renderRequest, LOAIVB, 0);
		nguoiKy = ParamUtil.getString(renderRequest, NGUOIKY);
		nguoiST = ParamUtil.getLong(renderRequest, NGUOIST, 0);
		trichYeu = ParamUtil.getString(renderRequest, TRICHYEU);
		vanBanPH = ParamUtil.getString(renderRequest, VANBANPH);
	}

	public String getSoPH() {
		return soPH;
	}

	public int getNgayPHMonth() {
		return ngayPHMonth;
	}

	public int getNgayPHYear() {
		return ngayPHYear;
	}

	public String getPhongST() {
		return phongST;
	}

	public String getNoiNhan() {
		return noiNhan;
	}

	public long getLoaiVB() {
		return loaiVB;
	}

	public String getNguoiKy() {
		return nguoiKy;
	}

	public long getNguoiST() {
		return nguoiST;
	}

	public String getTrichYeu() {
		return trichYeu;
	}
	
	public String getVanBanPH() {
		return vanBanPH;
	}

	protected String soPH;
	protected int ngayPHMonth;
	protected int ngayPHYear;
	protected String phongST;
	protected String noiNhan;
	protected long loaiVB;
	protected String nguoiKy;
	protected long nguoiST;
	protected String trichYeu;
	protected String vanBanPH;
}