package com.sgs.portlet.onedoorfileprocessed.search;

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
import com.sgs.portlet.onedoorfileprocessed.util.OneDoorFileProcessedUtil;

public class OneDoorFileProcessedSearch extends SearchContainer<PmlOneDoorReceiveFile> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("pccc-DSHS-mahoso");
		headerNames.add("pccc-TN-tenhoso");
		headerNames.add("pccc-TN-loaihoso");
		headerNames.add("pccc-TN-trangthaihoso");
		headerNames.add("pccc-DSHS-ngaynhan");
		headerNames.add("pccc-DSHS-ngayhentra");
		
		orderableHeaders.put("pccc-DSHS-mahoso", "maHoSo");
//		orderableHeaders.put("pccc-TN-tenhoso", "tenHoSo");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public OneDoorFileProcessedSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new OneDoorFileProcessedDisplayTerms(renderRequest), new OneDoorFileProcessedSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		OneDoorFileProcessedDisplayTerms displayTerms = (OneDoorFileProcessedDisplayTerms)getDisplayTerms();
		iteratorURL.setParameter(OneDoorFileProcessedDisplayTerms.MAHOSO, displayTerms.getMaHoSo());
		iteratorURL.setParameter(OneDoorFileProcessedDisplayTerms.TENHOSO, displayTerms.getTenHoSo());
		iteratorURL.setParameter(OneDoorFileProcessedDisplayTerms.NAM, displayTerms.getNam());
			
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "SGS_ONEDOORRETURN";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "processed-order-by-col", orderByCol);
				preferences.setValue(portletName, "processed-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "processed-order-by-col", "maHoSo");
				orderByType = preferences.getValue(portletName, "processed-order-by-type", "desc");
			}

			OrderByComparator orderByComparator = OneDoorFileProcessedUtil.getOneDoorFileByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
		
		private static Log _log = LogFactoryUtil.getLog(OneDoorFileProcessedSearch.class);
}
