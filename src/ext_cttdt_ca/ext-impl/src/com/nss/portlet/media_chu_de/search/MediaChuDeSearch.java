package com.nss.portlet.media_chu_de.search;

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
import com.nss.portlet.media_chu_de.model.MediaChuDe;
import com.nss.portlet.media_chu_de.util.MediaChuDeSearchUtil;

public class MediaChuDeSearch extends SearchContainer<MediaChuDe> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("ten-media-chu-de");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-media-chu-de", "tenMediaChuDe");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public MediaChuDeSearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new MediaChuDeDisplayTerms(renderRequest), new MediaChuDeSearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		MediaChuDeDisplayTerms displayTerms = (MediaChuDeDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(MediaChuDeDisplayTerms.TEN_MEDIA_CHU_DE, displayTerms.getTenMediaChuDe());
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_MEDIA_CHU_DE";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "mediaChuDe-order-by-col", orderByCol);
				preferences.setValue(portletName, "mediaChuDe-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "mediaChuDe-order-by-col", "tenMediaChuDe");
				orderByType = preferences.getValue(portletName, "mediaChuDe-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = MediaChuDeSearchUtil.getMediaChuDeOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(MediaChuDeSearch.class);
}
