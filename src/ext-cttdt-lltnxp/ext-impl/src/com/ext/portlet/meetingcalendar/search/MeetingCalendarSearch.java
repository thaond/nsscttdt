/**
 * Copyright (c) 2000-2008 Liferay, Inc. All rights reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.ext.portlet.meetingcalendar.search;

import com.ext.portlet.meetingcalendar.util.MeetingCalendarUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ext.portlet.meetingcalendar.action.MeetingCalendarKey;

/**
 * <a href="ArticleSearch.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class MeetingCalendarSearch extends SearchContainer {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("time");
		headerNames.add("content");
		headerNames.add("sponsor");
		headerNames.add("component");
		headerNames.add("room");

		orderableHeaders.put("time", "startDate");
		orderableHeaders.put("content", "description");
		orderableHeaders.put("sponsor", "title");
		orderableHeaders.put("component", "component");
		orderableHeaders.put("room", "room");
	}

	public static final String EMPTY_RESULTS_MESSAGE =
		"no-meeting-calendar-were-found";

	public MeetingCalendarSearch(RenderRequest req, PortletURL iteratorURL) {
		super(
			req, new MeetingCalendarDisplayTerms(req), new MeetingCalendarSearchTerms(req),
			DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames,
			EMPTY_RESULTS_MESSAGE);

		PortletConfig portletConfig = (PortletConfig)req.getAttribute(
			JavaConstants.JAVAX_PORTLET_CONFIG);

		MeetingCalendarDisplayTerms displayTerms =
			(MeetingCalendarDisplayTerms)getDisplayTerms();
		MeetingCalendarSearchTerms searchTerms = (MeetingCalendarSearchTerms)getSearchTerms();

		iteratorURL.setParameter(
			MeetingCalendarDisplayTerms.DESCRIPTION, displayTerms.getDescription());
		iteratorURL.setParameter(
				MeetingCalendarDisplayTerms.SPONSOR, displayTerms.getSponsor());
		iteratorURL.setParameter(
				MeetingCalendarDisplayTerms.COMPONENT, displayTerms.getComponent());
		
		if(displayTerms.getStartDateGT()==null)
			iteratorURL.setParameter(MeetingCalendarDisplayTerms.START_DATE_GT,"");
		else 
			iteratorURL.setParameter(
					MeetingCalendarDisplayTerms.START_DATE_GT, displayTerms.getStartDateGT().toString());
		if(displayTerms.getStartDateLT()==null)
			iteratorURL.setParameter(MeetingCalendarDisplayTerms.START_DATE_LT,"");
		else 
			iteratorURL.setParameter(
					MeetingCalendarDisplayTerms.START_DATE_LT, displayTerms.getStartDateLT().toString());
		try {
			PortalPreferences prefs =
				PortletPreferencesFactoryUtil.getPortalPreferences(req);

			String orderByCol = ParamUtil.getString(req, "orderByCol");
			String orderByType = ParamUtil.getString(req, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				prefs.setValue(
					MeetingCalendarKey.PORTLET_MEETING_CALENDAR, "calendar-order-by-col", orderByCol);
				prefs.setValue(
					MeetingCalendarKey.PORTLET_MEETING_CALENDAR, "calendar-order-by-type", orderByType);
			}
			else {
				orderByCol = prefs.getValue(
					MeetingCalendarKey.PORTLET_MEETING_CALENDAR, "calendar-order-by-col", "startDate");
				orderByType = prefs.getValue(
					MeetingCalendarKey.PORTLET_MEETING_CALENDAR, "calendar-order-by-type", "desc");
			}
			
			OrderByComparator orderByComparator = 
				MeetingCalendarUtil.getArticleOrderByComparator(
						orderByCol, orderByType);
			
			setOrderableHeaders(orderableHeaders);
			setOrderByCol(orderByCol);
			setOrderByType(orderByType);
			setOrderByComparator(orderByComparator);
		}
		catch (Exception e) {
			_log.error(e);
		}
	}

	private static Log _log = LogFactory.getLog(MeetingCalendarSearch.class);

}