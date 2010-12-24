package com.nss.portlet.phone_book.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.nss.portlet.phone_book.model.DetailBook;
import com.nss.portlet.phone_book.util.DetailBookUtil;

public class DetailBookSearch extends SearchContainer<DetailBook> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("stt");
		headerNames.add("ma-don-vi-co-so");
		headerNames.add("ten-don-vi-co-so");
		headerNames.add("mo-ta-don-vi-co-so");
		headerNames.add("zip-don-vi-co-so");
		headerNames.add("internal-don-vi-co-so");
		headerNames.add("home-don-vi-co-so");
		headerNames.add("mobile-don-vi-co-so");
		//headerNames.add("email");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ma-don-vi-co-so", "detailBookCode");
		orderableHeaders.put("ten-don-vi-co-so", "detailBookName");
		orderableHeaders.put("mo-ta-don-vi-co-so", "detailDescription");
		orderableHeaders.put("email", "email");
	}	

	public static final String EMPTY_RESULTS_MESSAGE = "no-detail-book-were-found";

	public DetailBookSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new DetailBookDisplayTerms(portletRequest),new DetailBookSearchTerms(portletRequest), 
				DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		DetailBookDisplayTerms displayTerms = (DetailBookDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(DetailBookDisplayTerms.CODE, displayTerms.getDetailBookCode());
		iteratorURL.setParameter(DetailBookDisplayTerms.NAME, displayTerms.getDetailBookName());
		iteratorURL.setParameter(DetailBookDisplayTerms.DESCRIPTION, displayTerms.getDetailDescription());
		iteratorURL.setParameter(DetailBookDisplayTerms.ZIP, displayTerms.getZip());
		iteratorURL.setParameter(DetailBookDisplayTerms.INTERNAL, displayTerms.getInternal());
		iteratorURL.setParameter(DetailBookDisplayTerms.HOME, displayTerms.getHome());
		iteratorURL.setParameter(DetailBookDisplayTerms.MOBILE, displayTerms.getMobile());
		iteratorURL.setParameter(DetailBookDisplayTerms.EMAIL, displayTerms.getEmail());
		
		try {
			PortalPreferences preferences =	PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);
			String orderByCol = ParamUtil.getString(portletRequest,"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");
			String portletName = "NSS_PHONE_BOOK";
			
			if (Validator.isNotNull(orderByCol) &&	Validator.isNotNull(orderByType)) {
				preferences.setValue(portletName, "detail-book-order-by-col",orderByCol);
				preferences.setValue(portletName, "detail-book-order-by-type",orderByType);
			}
			else {
				orderByCol = preferences.getValue(portletName, "detail-book-order-by-col", "detailBookCode");
				orderByType = preferences.getValue(portletName, "detail-book-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = DetailBookUtil.getDetailBookOrderByComparator(orderByCol, orderByType);
			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(DetailBook.class);
}
