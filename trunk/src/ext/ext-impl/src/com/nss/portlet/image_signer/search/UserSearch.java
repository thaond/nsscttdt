package com.nss.portlet.image_signer.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.nss.portlet.image_signer.util.UserUtil;

public class UserSearch extends SearchContainer<User> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static {
		headerNames.add("FirstName"); // ten tieu de cua cot
		headerNames.add("MiddleName");
		headerNames.add("LastName");
		orderableHeaders.put("FirstName", "orderFirstName");
		orderableHeaders.put("MiddleName", "orderMiddleName");
		orderableHeaders.put("LastName", "orderLastName");
	}
	public static final String EMPTY_RESULTs_MESSAGE = "khong tim thay";

	// dong hien thi khi khong tim thay ket qua tra ve
	public UserSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new UserDisplayTerms(portletRequest),
				new UserSearchTerms(portletRequest), DEFAULT_CUR_PARAM, 5,
				iteratorURL, headerNames, EMPTY_RESULTs_MESSAGE);

		// setOrderableHeaders(orderableHeaders);
		PortletConfig portletConfig = (PortletConfig) portletRequest
				.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		UserDisplayTerms displayTerms = (UserDisplayTerms) getDisplayTerms();
		iteratorURL.setParameter(UserDisplayTerms.FIRSTNAME,
				displayTerms.getFirstName());
		iteratorURL.setParameter(UserDisplayTerms.MIDDLENAME,
				displayTerms.getMiddleName());
		iteratorURL.setParameter(UserDisplayTerms.LASTNAME,
				displayTerms.getLastName());
		try {
			PortalPreferences preferences = PortletPreferencesFactoryUtil
					.getPortalPreferences(portletRequest);

			String orderByCol = ParamUtil.getString(portletRequest,
					"orderByCol");
			String orderByType = ParamUtil.getString(portletRequest,
					"orderByType");
			if (Validator.isNotNull(orderByCol)
					&& Validator.isNotNull(orderByType)) {

				preferences.setValue("NSS_IMAGE_SIGNER", "product-order-by-col",
						orderByCol);
				preferences.setValue("NSS_IMAGE_SIGNER", "product-order-by-type",
						orderByType);
			} else {
				orderByCol = preferences.getValue("NSS_IMAGE_SIGNER",
						"product-order-by-col", "id");
				orderByType = preferences.getValue("NSS_IMAGE_SIGNER",
						"product-order-by-type", "asc");
			}
			OrderByComparator orderByComparator = UserUtil.getUserOrderByComparator(orderByCol, orderByType);
			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);

		} catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(UserSearch.class);
}
