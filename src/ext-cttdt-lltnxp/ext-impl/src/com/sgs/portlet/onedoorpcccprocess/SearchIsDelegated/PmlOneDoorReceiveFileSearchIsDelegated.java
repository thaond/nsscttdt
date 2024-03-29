/**
 * 
 */
package com.sgs.portlet.onedoorpcccprocess.SearchIsDelegated;

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
import com.sgs.portlet.onedoorpcccprocess.utilsearch.PmlOneDoorReceiveFileSearchUtil;

/**
 * @author canhminh
 *
 */
public class PmlOneDoorReceiveFileSearchIsDelegated extends SearchContainer<PmlOneDoorReceiveFile>{
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static {
		headerNames.add("TT");
		headerNames.add("pccc-DSHS-mahoso");
		headerNames.add("pccc-TN-tenhoso");
		headerNames.add("pccc-TN-loaihoso");
		headerNames.add("pccc-DSHS-ngaynhan");		
		headerNames.add("pccc-DSHS-ngayHTK");
		
		
		orderableHeaders.put("pccc-DSHS-mahoso", "pccc-DSHS-mahoso");

	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "pmlfilereturn-search-khongtontaidulieu";
	
	public PmlOneDoorReceiveFileSearchIsDelegated(RenderRequest renderRequest, PortletURL iteratorURL) {
		super(renderRequest, new PmlOneDoorReceiveFileSearchIsDelegatedDisplayTerms(renderRequest),
				new PmlOneDoorReceiveFileSearchIsDelegatedTerms(renderRequest), DEFAULT_CUR_PARAM,
				DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_ONEDOORPCCCPROCESS";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "onedoorpcccprocessworks-order-by-col",	orderByCol);
				preferences.setValue(portletName, "onedoorpcccprocessworks-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "onedoorpcccprocessworks-order-by-col", "pccc-DSHS-mahoso");
				orderByType = preferences.getValue(portletName, "onedoorpcccprocessworks-order-by-type", "desc");
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

	private static Log _log = LogFactoryUtil.getLog(PmlOneDoorReceiveFileSearchIsDelegated.class);
}
