package com.sgs.portlet.pml_tinh_chat.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ext.portal.util.PortletKeysExt;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sgs.portlet.pml_tinh_chat.model.PmlTinhChat;
import com.sgs.portlet.pml_tinh_chat.util.PmlTinhChatUtil;

/**
 * <a href="PmlTinhChatSearch.java.html"><b><i>View Source</i></b></a>
 *
 * @author HAI TRIEU
 *
 */
public class PmlTinhChatSearch extends SearchContainer<PmlTinhChat> {
	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();
	
	static {
		//Data columns
		//headerNames.add("order-no");
		headerNames.add("STT");
		headerNames.add("ten-tinh-chat");
		
		//Order
		orderableHeaders.put("ten-tinh-chat", "ten-tinh-chat");
	}
	public static final String EMPTY_RESULTS_MESSAGE =
		"no-official-dispatch-pml-tinh-chat-were-found";

	public PmlTinhChatSearch(RenderRequest req, PortletURL iteratorURL) {
		super(
			req, new PmlTinhChatDisplayTerms(req), new PmlTinhChatSearchTerms(req),
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames,
			EMPTY_RESULTS_MESSAGE);

		PmlTinhChatDisplayTerms displayTerms =
			(PmlTinhChatDisplayTerms)getDisplayTerms();
		
		//iteratorURL.setParameter(PmlTinhChatDisplayTerms.GROUPID, String.valueOf(displayTerms.getGroupId()));
		
		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(req);

			String orderByCol = ParamUtil.getString(req, "orderByCol");
			String orderByType = ParamUtil.getString(req, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
					PortletKeysExt.PMLTINHCHAT, "pml_tinh_chat-order-by-col", orderByCol);
				preferences.setValue(
					PortletKeysExt.PMLTINHCHAT, "pml_tinh_chat-order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(
					PortletKeysExt.PMLTINHCHAT, "pml_tinh_chat-order-by-col", "ten-tinh-chat");
				orderByType = preferences.getValue(
					PortletKeysExt.PMLTINHCHAT, "pml_tinh_chat-order-by-type", "asc");
			}

			OrderByComparator orderByComparator =
				PmlTinhChatUtil.getPmlTinhChatOrderByComparator(orderByCol, orderByType);

			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(PmlTinhChatSearch.class);
}
