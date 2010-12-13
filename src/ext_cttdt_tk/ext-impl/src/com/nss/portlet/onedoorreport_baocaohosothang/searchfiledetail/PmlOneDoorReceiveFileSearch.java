package com.nss.portlet.onedoorreport_baocaohosothang.searchfiledetail;

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
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.nss.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.nss.portlet.onedoorprocess.utilsearch.PmlOneDoorReceiveFileSearchUtil;

public class PmlOneDoorReceiveFileSearch extends SearchContainer<PmlOneDoorReceiveFile>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static {
		headerNames.add("TT");
		headerNames.add("pccc-DSHS-mahoso");
		headerNames.add("pccc-TN-tenhoso");
		headerNames.add("pccc-TN-loaihoso");
		headerNames.add("pccc-DSHS-trangthaihoso");
		headerNames.add("pccc-DSHS-ngaynhan");		
		headerNames.add("pccc-DSHS-ngayhentra");
		
		
		orderableHeaders.put("pccc-DSHS-mahoso", "pccc-DSHS-mahoso");

	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "pmlfilereturn-search-khongtontaidulieu";
	
	public PmlOneDoorReceiveFileSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new PmlOneDoorReceiveFileDisplayTerms(renderRequest),
				new PmlOneDoorReceiveFileSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_ONEDOORREPORT_BAOCAOHOSOTHANG";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "baocaohosothangworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "baocaohosothangworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "baocaohosothangworks-order-by-col", "pccc-DSHS-mahoso");
				orderByType = preferences.getValue(portletName, "baocaohosothangworks-order-by-type", "desc");
			}

			OrderByComparator orderByComparator = PmlOneDoorReceiveFileSearchUtil.getPmlOneDoorReceiveFileOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PmlOneDoorReceiveFileSearch.class);
}
