package com.sgs.portlet.pml_ho_so_cong_viec.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ext.portal.util.PortletKeysExt;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.pml_ho_so_cong_viec.model.PmlHoSoCongViec;
import com.sgs.portlet.pml_ho_so_cong_viec.util.PmlHoSoCongViecUtil;

/**
 * <a href="PmlHoSoCongViecSearch.java.html"><b><i>View Source</i></b></a>
 *
 * @author XUANCONG
 *
 */
public class PmlHoSoCongViecSearch extends SearchContainer<PmlHoSoCongViec> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		//headerNames.add("order_no");
		headerNames.add("STT");
		headerNames.add("pml_sohieuhscv");
		headerNames.add("pml_tieude");
		headerNames.add("pml_ngaymohscv");
		headerNames.add("pml_linhvuc");
		headerNames.add("pml_vandelienquan");
		headerNames.add("pml_hosocha");
		//xuancong close headerNames.add("pml_nguoilap");
		headerNames.add("pml_sovanban");

		// Order by
		orderableHeaders.put("pml_sohieuhscv", "pml_sohieuhscv");
		orderableHeaders.put("pml_ngaymohscv", "pml_ngaymohscv");
		orderableHeaders.put("pml_linhvuc", "pml_linhvuc");
	}

	public static final String EMPTY_RESULTS_MESSAGE =
		"no-pml-hscv-were-found";

	public PmlHoSoCongViecSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(
			renderRequest, new PmlHoSoCongViecDisplayTerms(renderRequest),
			new PmlHoSoCongViecSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		PmlHoSoCongViecDisplayTerms displayTerms =
			(PmlHoSoCongViecDisplayTerms)getDisplayTerms();

		iteratorURL.setParameter(
				PmlHoSoCongViecDisplayTerms.SOHIEUHSCV, displayTerms.getSoHieuHSCV());
		iteratorURL.setParameter(
				PmlHoSoCongViecDisplayTerms.TIEUDE, displayTerms.getTieuDe());
		// Chua co ngay
		iteratorURL.setParameter(
				PmlHoSoCongViecDisplayTerms.IDLINHVUC, String.valueOf(displayTerms.getIdLinhVuc()));
		iteratorURL.setParameter(
				PmlHoSoCongViecDisplayTerms.VANDELIENQUAN, displayTerms.getVanDeLienQuan());
		iteratorURL.setParameter(
				PmlHoSoCongViecDisplayTerms.IDDOQUANTRONG, String.valueOf(displayTerms.getIdDoQuanTrong()));
		iteratorURL.setParameter(
				PmlHoSoCongViecDisplayTerms.IDTRANGTHAIHSCV, String.valueOf(displayTerms.getIdTrangThaiHSCV()));
		iteratorURL.setParameter(
				PmlHoSoCongViecDisplayTerms.TOMTATNOIDUNG, displayTerms.getTomTatNoiDung());
		iteratorURL.setParameter(
				PmlHoSoCongViecDisplayTerms.HOATDONG, displayTerms.getHoatDong());

		try {
			PortalPreferences prefs =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					renderRequest);

			String orderByCol = ParamUtil.getString(
				renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				renderRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				prefs.setValue(
					PortletKeysExt.PMLHOSOCONGVIEC, "pml-hscv-order-by-col", orderByCol);
				prefs.setValue(
					PortletKeysExt.PMLHOSOCONGVIEC, "pml-hscv-order-by-type", orderByType);
			}
			else {
				orderByCol = prefs.getValue(
						PortletKeysExt.PMLHOSOCONGVIEC, "pml-hscv-order-by-col", "pml_sohieuhscv");
				orderByType = prefs.getValue(
						PortletKeysExt.PMLHOSOCONGVIEC, "pml-hscv-order-by-type", "asc");
			}

			OrderByComparator orderByComparator =
				PmlHoSoCongViecUtil.getPmlHoSoCongViecOrderByComparator(
						orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(PmlHoSoCongViecSearch.class);

}