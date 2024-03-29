<%
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
%>

<%@ include file="/html/portlet/init.jsp" %>

<%@ page import="com.liferay.portal.kernel.search.Document" %>
<%@ page import="com.liferay.portal.kernel.search.Field" %>
<%@ page import="com.liferay.portal.kernel.search.DocumentSummary" %>
<%@ page import="com.liferay.portal.kernel.search.Indexer" %>
<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portlet.journal.model.impl.JournalArticleImpl" %>
<%@ page import="com.liferay.portlet.journal.service.JournalContentSearchLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.journalcontentsearch.util.ContentHits" %>

<%
PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

boolean showListedDefault = true;

if (portletName.equals(PortletKeys.JOURNAL_CONTENT_SEARCH)) {
	showListedDefault = PropsValues.JOURNAL_CONTENT_SEARCH_SHOW_LISTED;
}

boolean showListed = GetterUtil.getBoolean(preferences.getValue("show-listed", null), showListedDefault);

String targetPortletId = preferences.getValue("target-portlet-id", StringPool.BLANK);
String type = preferences.getValue("type", StringPool.BLANK);
//TuNV update 20101126
String c_search_type = preferences.getValue("c_search_type","sign");
boolean b1,b2,b3,b4;
b1 = (c_search_type.equalsIgnoreCase("all") ? true : false);
b2 = (c_search_type.equalsIgnoreCase("sign") ? true : false);
b3 = (c_search_type.equalsIgnoreCase("changesign") ? true : false);
b4 = (c_search_type.equalsIgnoreCase("notsign") ? true : false);
//End TuNV
%>