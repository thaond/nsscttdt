package com.nss.portlet.permissonuserbyfile.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.nss.portlet.permissonuserbyfile.util.PermissionUserByFileSearchUtil;

public class PermissionUserByFileSearch extends SearchContainer<User>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static {
		headerNames.add("STT");
		headerNames.add("permisson.account");
		headerNames.add("permisson.user.name");
		headerNames.add("permisson.watchfor");
		headerNames.add("permisson.desc");
		headerNames.add("permission.assign");		
		
		orderableHeaders.put("permisson.user.name", "userName");
	}
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
		
	public PermissionUserByFileSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new PermissionUserByFileDisplayTerms(renderRequest),
				new PermissionUserByFileSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_PERMISSONUSERBYFILE";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "permissionuserbyfile-order-by-col", orderByCol);
				preferences.setValue(portletName, "permissionuserbyfile-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "permissionuserbyfile-order-by-col", "userName");
				orderByType = preferences.getValue(portletName, "permissionuserbyfile-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = PermissionUserByFileSearchUtil.getUserOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(PermissionUserByFileSearch.class);
}
