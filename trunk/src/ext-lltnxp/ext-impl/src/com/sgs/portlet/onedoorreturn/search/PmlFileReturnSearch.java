package com.sgs.portlet.onedoorreturn.search;

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
import com.sgs.portlet.onedoor.model.PmlOneDoorReceiveFile;
import com.sgs.portlet.onedoorreturn.util.PmlFileReturnUtil;

public class PmlFileReturnSearch extends SearchContainer<PmlOneDoorReceiveFile> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static {
		headerNames.add("no.");
		headerNames.add("pccc-DSHS-mahoso");
		headerNames.add("pccc-TN-tenhoso");
		headerNames.add("pccc-TN-loaihoso");
		headerNames.add("pccc-TN-trangthaihoso");
		headerNames.add("pccc-DSHS-ngaynhan");
		headerNames.add("pccc-DSHS-ngayHTK");
		
		orderableHeaders.put("pccc-DSHS-mahoso", "pccc-DSHS-mahoso");

	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public PmlFileReturnSearch(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new PmlFileReturnDisplayTerms(renderRequest),
				new PmlFileReturnSearchTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		PmlFileReturnDisplayTerms displayTerms = (PmlFileReturnDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(PmlFileReturnDisplayTerms.NUMBERRECEIPT, displayTerms.getNumberreceipt());
		iteratorURL.setParameter(PmlFileReturnDisplayTerms.FILETYPEID, displayTerms.getFileTypeId());
		iteratorURL.setParameter(PmlFileReturnDisplayTerms.YEAR, displayTerms.getYear());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_ONEDOORRETURN";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "onedoorreturnworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "onedoorreturnworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "onedoorreturnworks-order-by-col", "pccc-DSHS-mahoso");
				orderByType = preferences.getValue(portletName, "onedoorreturnworks-order-by-type", "desc");
			}

			OrderByComparator orderByComparator = PmlFileReturnUtil.getPmlFileReturnOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PmlFileReturnSearch.class);
}
