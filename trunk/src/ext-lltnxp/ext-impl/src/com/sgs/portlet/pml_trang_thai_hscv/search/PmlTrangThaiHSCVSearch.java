package com.sgs.portlet.pml_trang_thai_hscv.search;

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
import com.sgs.portlet.pml_trang_thai_hscv.model.PmlTrangThaiHSCV;
import com.sgs.portlet.pml_trang_thai_hscv.util.PmlTrangThaiHSCVUtil;

/**
 * <a href="PmlTrangThaiHSCVSearch.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAI TRIEU
 *
 */
public class PmlTrangThaiHSCVSearch extends SearchContainer<PmlTrangThaiHSCV> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		//Data columns
		//headerNames.add("order-no");
		headerNames.add("STT");
		headerNames.add("ten-trang-thai-hscv");
		
		//Order
		orderableHeaders.put("ten-trang-thai-hscv", "ten-trang-thai-hscv");
	}
	public static final String EMPTY_RESULTS_MESSAGE =
		"no-official-dispatch-pml-trang-thai-hscv-were-found";

	public PmlTrangThaiHSCVSearch(RenderRequest req, PortletURL iteratorURL) {
		super(
			req, new PmlTrangThaiHSCVDisplayTerms(req), new PmlTrangThaiHSCVSearchTerms(req),
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames,
			EMPTY_RESULTS_MESSAGE);

		PmlTrangThaiHSCVDisplayTerms displayTerms =
			(PmlTrangThaiHSCVDisplayTerms)getDisplayTerms();
		
		//iteratorURL.setParameter(PmlTrangThaiHSCVDisplayTerms.GROUPID, String.valueOf(displayTerms.getGroupId()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(req);

			String orderByCol = ParamUtil.getString(req, "orderByCol");
			String orderByType = ParamUtil.getString(req, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
					PortletKeysExt.PMLTRANGTHAIHSCV, "pml_trang_thai_hscv-order-by-col", orderByCol);
				preferences.setValue(
					PortletKeysExt.PMLTRANGTHAIHSCV, "pml_trang_thai_hscv-order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(
					PortletKeysExt.PMLTRANGTHAIHSCV, "pml_trang_thai_hscv-order-by-col", "ten_trang_thai_hscv");
				orderByType = preferences.getValue(
					PortletKeysExt.PMLTRANGTHAIHSCV, "pml_trang_thai_hscv-order-by-type", "asc");
			}

			OrderByComparator orderByComparator =
				PmlTrangThaiHSCVUtil.getPmlTrangThaiHSCVOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(PmlTrangThaiHSCVSearch.class);
}
