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
import com.nss.portlet.phone_book.model.ContactBook;
import com.nss.portlet.phone_book.util.ContactBookUtil;

public class ContactBookSearch extends SearchContainer<ContactBook> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("stt");
		headerNames.add("ma-khoi");
		headerNames.add("ten-khoi");
		headerNames.add("mo-ta-khoi");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ma-khoi", "contactBookCode");
		orderableHeaders.put("ten-khoi", "contactBookName");
		orderableHeaders.put("mo-ta-khoi", "contactDescription");
	}	

	public static final String EMPTY_RESULTS_MESSAGE = "no-contact-book-were-found";

	public ContactBookSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(
			portletRequest, new ContactBookDisplayTerms(portletRequest),
			new ContactBookSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		ContactBookDisplayTerms displayTerms = (ContactBookDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(ContactBookDisplayTerms.CODE, displayTerms.getContactBookCode());
		iteratorURL.setParameter(ContactBookDisplayTerms.NAME, displayTerms.getContactBookName());
		iteratorURL.setParameter(ContactBookDisplayTerms.DESCRIPTION, displayTerms.getContactDescription());
		
		try {
			PortalPreferences preferences =	PortletPreferencesFactoryUtil.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest,"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest, "orderByType");
			String portletName = "NSS_PHONE_BOOK";
			
			if (Validator.isNotNull(orderByCol) &&	Validator.isNotNull(orderByType)) {
				preferences.setValue(portletName, "contact-book-order-by-col",orderByCol);
				preferences.setValue(portletName, "contact-book-order-by-type",orderByType);
			}
			else {
				orderByCol = preferences.getValue(portletName, "contact-book-order-by-col", "contactBookCode");
				orderByType = preferences.getValue(portletName, "contact-book-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = ContactBookUtil.getContactBookOrderByComparator(orderByCol, orderByType);
			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ContactBook.class);
}
