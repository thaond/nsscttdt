/**
 * Copyright (c) 2000-2009 Liferay, Inc. All rights reserved.
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

package com.nss.portlet.journal.search;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.PortalPreferences;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.nss.portlet.journal.model.JournalArticle;
import com.nss.portlet.journal.search.ArticleDisplayTerms;
import com.nss.portlet.journal.search.ArticleSearchTerms;
import com.nss.portlet.journal.util.JournalUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

/**
 * <a href="ArticleSearch.java.html"><b><i>View Source</i></b></a>
 *
 * @author Brian Wing Shun Chan
 *
 */
public class ArticleSearchExt extends SearchContainer<JournalArticle> {

	static List<String> headerNames = new ArrayList<String>();
	static Map<String, String> orderableHeaders = new HashMap<String, String>();

	static {
		headerNames.add("id");
		headerNames.add("name");
		headerNames.add("version");
		headerNames.add("modified-date");
		headerNames.add("display-date");
		headerNames.add("author");

		orderableHeaders.put("id", "id");
		orderableHeaders.put("name", "title");
		orderableHeaders.put("version", "version");
		orderableHeaders.put("modified-date", "modified-date");
		orderableHeaders.put("display-date", "display-date");
	}

	public static final String EMPTY_RESULTS_MESSAGE = "no-web-content-were-found";

	public ArticleSearchExt(
		PortletRequest portletRequest, PortletURL iteratorURL) {

		super(
			portletRequest, new ArticleDisplayTerms(portletRequest),
			new ArticleSearchTerms(portletRequest), DEFAULT_CUR_PARAM,
			DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);

		PortletConfig portletConfig =
			(PortletConfig)portletRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

		ArticleDisplayTerms displayTerms =
			(ArticleDisplayTerms)getDisplayTerms();
		ArticleSearchTerms searchTerms = (ArticleSearchTerms)getSearchTerms();

		if (!portletConfig.getPortletName().equals("NSS_JOURNAL") && !portletConfig.getPortletName().equals("SGS_JOURNALWORKFLOW")) {
			displayTerms.setStatus("approved");
			searchTerms.setStatus("approved");
		}

		iteratorURL.setParameter(
			ArticleDisplayTerms.GROUP_ID,
			String.valueOf(displayTerms.getGroupId()));
		iteratorURL.setParameter(
			ArticleDisplayTerms.ARTICLE_ID, displayTerms.getArticleId());
		iteratorURL.setParameter(
			ArticleDisplayTerms.VERSION,
			String.valueOf(displayTerms.getVersion()));
		iteratorURL.setParameter(
			ArticleDisplayTerms.TITLE, displayTerms.getTitle());
		iteratorURL.setParameter(
			ArticleDisplayTerms.DESCRIPTION, displayTerms.getDescription());
		iteratorURL.setParameter(
			ArticleDisplayTerms.CONTENT, displayTerms.getContent());
		iteratorURL.setParameter(
			ArticleDisplayTerms.TYPE, displayTerms.getType());
		iteratorURL.setParameter(
			ArticleDisplayTerms.STRUCTURE_ID, displayTerms.getStructureId());
		iteratorURL.setParameter(
			ArticleDisplayTerms.TEMPLATE_ID, displayTerms.getTemplateId());
		iteratorURL.setParameter(
			ArticleDisplayTerms.STATUS, displayTerms.getStatus());

		try {
			PortalPreferences preferences =
				PortletPreferencesFactoryUtil.getPortalPreferences(
					portletRequest);

			String orderByCol = ParamUtil.getString(
				portletRequest, "orderByCol");
			String orderByType = ParamUtil.getString(
				portletRequest, "orderByType");

			if (Validator.isNotNull(orderByCol) &&
				Validator.isNotNull(orderByType)) {

				preferences.setValue(
					"NSS_JOURNAL", "articles-order-by-col", orderByCol);
				preferences.setValue(
					"NSS_JOURNAL", "articles-order-by-type", orderByType);
			}
			else {
				orderByCol = preferences.getValue(
					"NSS_JOURNAL", "articles-order-by-col", "id");
				orderByType = preferences.getValue(
					"NSS_JOURNAL", "articles-order-by-type", "asc");
			}

			OrderByComparator orderByComparator =
				JournalUtil.getArticleOrderByComparator(
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

	private static Log _log = LogFactoryUtil.getLog(ArticleSearchExt.class);

}