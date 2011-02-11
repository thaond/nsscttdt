package com.sgs.portlet.pml_do_quan_trong.search;

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
import com.sgs.portlet.pml_do_quan_trong.model.PmlDoQuanTrong;
import com.sgs.portlet.pml_do_quan_trong.util.PmlDoQuanTrongUtil;

/**
 * <a href="PmlDoQuanTrongSearch.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAI TRIEU
 *
 */
public class PmlDoQuanTrongSearch extends SearchContainer<PmlDoQuanTrong> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		//Data columns
		//headerNames.add("order-no");
		headerNames.add("STT");
		headerNames.add("ten-do-quan-trong");
		
		//Order
		orderableHeaders.put("ten-do-quan-trong", "ten-do-quan-trong");
	}
	public static final String EMPTY_RESULTS_MESSAGE =
		"no-official-dispatch-pml-do-quan-trong-were-found";

	public PmlDoQuanTrongSearch(RenderRequest req, PortletURL iteratorURL) {
		super(
			req, new PmlDoQuanTrongDisplayTerms(req), new PmlDoQuanTrongSearchTerms(req),
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames,
			EMPTY_RESULTS_MESSAGE);

		PmlDoQuanTrongDisplayTerms displayTerms =
			(PmlDoQuanTrongDisplayTerms)getDisplayTerms();
		
		//iteratorURL.setParameter(PmlDoQuanTrongDisplayTerms.GROUPID, String.valueOf(displayTerms.getGroupId()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(req);

			String orderByCol = ParamUtil.getString(req, "orderByCol");
			String orderByType = ParamUtil.getString(req, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
					PortletKeysExt.PMLDOQUANTRONG, "pml_do_quan_trong-order-by-col", orderByCol);
				preferences.setValue(
					PortletKeysExt.PMLDOQUANTRONG, "pml_do_quan_trong-order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(
					PortletKeysExt.PMLDOQUANTRONG, "pml_do_quan_trong-order-by-col", "ten_do_quan_trong");
				orderByType = preferences.getValue(
					PortletKeysExt.PMLDOQUANTRONG, "pml_do_quan_trong-order-by-type", "asc");
			}

			OrderByComparator orderByComparator =
				PmlDoQuanTrongUtil.getPmlDoQuanTrongOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(PmlDoQuanTrongSearch.class);
}
