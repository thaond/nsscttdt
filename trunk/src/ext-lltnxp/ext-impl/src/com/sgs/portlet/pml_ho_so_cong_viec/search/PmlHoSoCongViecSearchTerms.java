package com.sgs.portlet.pml_ho_so_cong_viec.search;

import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * <a href="PmlHoSoCongViecSearchTerms.java.html"><b><i>View Source</i></b></a>
 * 
 * @author XUANCONG
 * 
 */
public class PmlHoSoCongViecSearchTerms extends PmlHoSoCongViecDisplayTerms {

	public PmlHoSoCongViecSearchTerms(RenderRequest renderRequest) {
		super(renderRequest);

		soHieuHSCV = DAOParamUtil.getLike(renderRequest, SOHIEUHSCV, false);
		tieuDe = DAOParamUtil.getLike(renderRequest, TIEUDE, false);
		idLinhVuc = ParamUtil.getString(renderRequest, IDLINHVUC);
		vanDeLienQuan = DAOParamUtil.getLike(renderRequest, VANDELIENQUAN,
				false);
		idDoQuanTrong = ParamUtil.getLong(renderRequest, IDDOQUANTRONG);
		idTrangThaiHSCV = ParamUtil.getLong(renderRequest, IDTRANGTHAIHSCV);
		tomTatNoiDung = DAOParamUtil.getLike(renderRequest, TOMTATNOIDUNG,
				false);
		hoatDong = DAOParamUtil.getString(renderRequest, HOATDONG);

		if (hoatDong == null) {
			hoatDong = "0";
		} else if (hoatDong.equals("on")) {
			hoatDong = "1";
		}
	}
}