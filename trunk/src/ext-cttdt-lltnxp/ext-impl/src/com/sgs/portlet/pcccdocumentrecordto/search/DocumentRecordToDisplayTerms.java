package com.sgs.portlet.pcccdocumentrecordto.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;
import javax.portlet.RenderRequest;

/**
 *
 * @author XUANCONG
 *
 */
public class DocumentRecordToDisplayTerms extends DisplayTerms {
	
	public static final String SONOIBO = "soNoiBo";
	public static final String SOHIEUGOC = "soHieuGoc";
	public static final String NGAYPHDAY = "ngayPHDay";
	public static final String NGAYPHMONTH = "ngayPHMonth";
	public static final String NGAYPHYEAR = "ngayPHYear";
	public static final String CAPGUI = "capGui";
	public static final String NOIPHATHANH = "noiPhatHanh";
	public static final String UUTIEN = "uuTien";
	public static final String NGAYDENDAY = "ngayDenDay";
	public static final String NGAYDENMONTH = "ngayDenMonth";
	public static final String NGAYDENYEAR = "ngayDenYear";
	public static final String LOAIVB = "loaiVB";
	public static final String PHONGBAN = "phongBan";
	public static final String TRICHYEU = "trichYeu";

	public DocumentRecordToDisplayTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soNoiBo = ParamUtil.getString(renderRequest, SONOIBO);
		soHieuGoc = ParamUtil.getString(renderRequest, SOHIEUGOC);
		ngayPHDay = ParamUtil.getInteger(renderRequest, NGAYPHDAY, 0);
		ngayPHMonth = ParamUtil.getInteger(renderRequest, NGAYPHMONTH, 0);
		ngayPHYear = ParamUtil.getInteger(renderRequest, NGAYPHYEAR, 0);
		capGui = ParamUtil.getLong(renderRequest, CAPGUI, 0);
		noiPhatHanh = ParamUtil.getString(renderRequest, NOIPHATHANH);
		uuTien = ParamUtil.getString(renderRequest, UUTIEN);
		ngayDenDay = ParamUtil.getInteger(renderRequest, NGAYDENDAY, 0);
		ngayDenMonth = ParamUtil.getInteger(renderRequest, NGAYDENMONTH, 0);
		ngayDenYear = ParamUtil.getInteger(renderRequest, NGAYDENYEAR, 0);
		loaiVB = ParamUtil.getLong(renderRequest, LOAIVB, 0);
		phongBan = ParamUtil.getString(renderRequest, PHONGBAN);
		trichYeu = ParamUtil.getString(renderRequest, TRICHYEU);
	}

	public String getSoNoiBo() {
		return soNoiBo;
	}

	public String getSoHieuGoc() {
		return soHieuGoc;
	}

	public int getNgayPHDay() {
		return ngayPHDay;
	}

	public int getNgayPHMonth() {
		return ngayPHMonth;
	}

	public int getNgayPHYear() {
		return ngayPHYear;
	}

	public long getCapGui() {
		return capGui;
	}

	public String getNoiPhatHanh() {
		return noiPhatHanh;
	}

	public String getUuTien() {
		return uuTien;
	}

	public int getNgayDenDay() {
		return ngayDenDay;
	}

	public int getNgayDenMonth() {
		return ngayDenMonth;
	}

	public int getNgayDenYear() {
		return ngayDenYear;
	}

	public long getLoaiVB() {
		return loaiVB;
	}

	public String getPhongBan() {
		return phongBan;
	}

	public String getTrichYeu() {
		return trichYeu;
	}

	protected String soNoiBo;
	protected String soHieuGoc;
	protected int ngayPHDay;
	protected int ngayPHMonth;
	protected int ngayPHYear;
	protected long capGui;
	protected String noiPhatHanh;
	protected String uuTien;
	protected int ngayDenDay;
	protected int ngayDenMonth;
	protected int ngayDenYear;
	protected long loaiVB;
	protected String phongBan;
	protected String trichYeu;
}