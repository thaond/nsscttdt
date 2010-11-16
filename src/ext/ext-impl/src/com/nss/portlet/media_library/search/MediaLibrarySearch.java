package com.nss.portlet.media_library.search;

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
import com.nss.portlet.media_library.model.MediaLibrary;
import com.nss.portlet.media_library.util.MediaLibrarySearchUtil;

public class MediaLibrarySearch extends SearchContainer<MediaLibrary> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	static{
		headerNames.add("STT");
		headerNames.add("tieu-de");
		headerNames.add("ten-media-library");
		headerNames.add("ten-media-chu-de");
		headerNames.add("active");
		headerNames.add("edit");
		headerNames.add("delete");
		
		orderableHeaders.put("ten-media-library", "tenMediaLibrary");
		//orderableHeaders.put("ten-media-chu-de", "tenMediaChuDe");
	}
	
	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";
	
	public MediaLibrarySearch(RenderRequest renderRequest, PortletURL iteratorURL){
		super(renderRequest, new MediaLibraryDisplayTerms(renderRequest), new MediaLibrarySearchTerms(renderRequest),
				DEFAULT_CUR_PARAM,DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		
		MediaLibraryDisplayTerms displayTerms = (MediaLibraryDisplayTerms)getDisplayTerms();
		
		iteratorURL.setParameter(MediaLibraryDisplayTerms.TIEU_DE_MEDIA_LIBRARY, displayTerms.getTieuDeMediaLibrary());
		iteratorURL.setParameter(MediaLibraryDisplayTerms.TEN_MEDIA_LIBRARY, displayTerms.getTenMediaLibrary());
		iteratorURL.setParameter(MediaLibraryDisplayTerms.MA_MEDIA_CHU_DE, String.valueOf(displayTerms.getMaMediaChuDe()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(renderRequest);

			String orderByCol = ParamUtil.getString(renderRequest, "orderByCol");
			String orderByType = ParamUtil.getString(renderRequest, "orderByType");

			String portletName = "NSS_MEDIA_LIBRARY";
			
			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(portletName, "mediaLibrary-order-by-col", orderByCol);
				preferences.setValue(portletName, "mediaLibrary-order-by-type", orderByType);
			}
			
			else {
				orderByCol = preferences.getValue(portletName, "mediaLibrary-order-by-col", "tenMediaLibrary");
				orderByType = preferences.getValue(portletName, "mediaLibrary-order-by-type", "asc");
			}

			OrderByComparator orderByComparator = MediaLibrarySearchUtil.getMediaLibraryOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(MediaLibrarySearch.class);
}
