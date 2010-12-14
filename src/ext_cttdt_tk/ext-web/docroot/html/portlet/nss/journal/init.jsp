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

<%@ page import="com.liferay.portal.kernel.xml.Document" %>
<%@ page import="com.liferay.portal.kernel.xml.Element" %>
<%@ page import="com.liferay.portal.kernel.xml.Node" %>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@ page import="com.liferay.portal.kernel.xml.XPath" %>
<%@ page import="com.liferay.portal.util.LayoutLister" %>
<%@ page import="com.liferay.portal.util.LayoutView" %>
<%@ page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<%@ page import="com.nss.portlet.journal.ArticleContentException" %>
<%@ page import="com.nss.portlet.journal.ArticleDisplayDateException" %>
<%@ page import="com.nss.portlet.journal.ArticleExpirationDateException" %>
<%@ page import="com.nss.portlet.journal.ArticleIdException" %>
<%@ page import="com.nss.portlet.journal.ArticleSmallImageNameException" %>
<%@ page import="com.nss.portlet.journal.ArticleSmallImageSizeException" %>
<%@ page import="com.nss.portlet.journal.ArticleTitleException" %>
<%@ page import="com.nss.portlet.journal.ArticleTypeException" %>
<%@ page import="com.nss.portlet.journal.DuplicateArticleIdException" %>
<%@ page import="com.nss.portlet.journal.DuplicateFeedIdException" %>
<%@ page import="com.nss.portlet.journal.DuplicateStructureIdException" %>
<%@ page import="com.nss.portlet.journal.DuplicateTemplateIdException" %>
<%@ page import="com.nss.portlet.journal.FeedContentFieldException" %>
<%@ page import="com.nss.portlet.journal.FeedDescriptionException" %>
<%@ page import="com.nss.portlet.journal.FeedIdException" %>
<%@ page import="com.nss.portlet.journal.FeedNameException" %>
<%@ page import="com.nss.portlet.journal.FeedTargetLayoutFriendlyUrlException" %>
<%@ page import="com.nss.portlet.journal.FeedTargetPortletIdException" %>
<%@ page import="com.nss.portlet.journal.NoSuchArticleException" %>
<%@ page import="com.nss.portlet.journal.NoSuchStructureException" %>
<%@ page import="com.nss.portlet.journal.NoSuchTemplateException" %>
<%@ page import="com.nss.portlet.journal.RequiredStructureException" %>
<%@ page import="com.nss.portlet.journal.RequiredTemplateException" %>
<%@ page import="com.nss.portlet.journal.StructureDescriptionException" %>
<%@ page import="com.nss.portlet.journal.StructureIdException" %>
<%@ page import="com.nss.portlet.journal.StructureInheritanceException" %>
<%@ page import="com.nss.portlet.journal.StructureNameException" %>
<%@ page import="com.nss.portlet.journal.StructureXsdException" %>
<%@ page import="com.nss.portlet.journal.TemplateDescriptionException" %>
<%@ page import="com.nss.portlet.journal.TemplateIdException" %>
<%@ page import="com.nss.portlet.journal.TemplateNameException" %>
<%@ page import="com.nss.portlet.journal.TemplateSmallImageNameException" %>
<%@ page import="com.nss.portlet.journal.TemplateSmallImageSizeException" %>
<%@ page import="com.nss.portlet.journal.TemplateXslException" %>
<%@ page import="com.nss.portlet.journal.action.EditArticleAction" %>
<%@ page import="com.nss.portlet.journal.model.JournalArticle" %>
<%@ page import="com.nss.portlet.journal.model.JournalFeed" %>
<%@ page import="com.nss.portlet.journal.model.JournalStructure" %>
<%@ page import="com.nss.portlet.journal.model.JournalTemplate" %>
<%@ page import="com.nss.portlet.journal.model.impl.JournalArticleImpl" %>
<%@ page import="com.nss.portlet.journal.model.impl.JournalFeedImpl" %>
<%@ page import="com.nss.portlet.journal.model.impl.JournalTemplateImpl" %>
<%@ page import="com.nss.portlet.journal.search.ArticleDisplayTerms" %>
<%@ page import="com.nss.portlet.journal.search.ArticleSearch" %>
<%@ page import="com.nss.portlet.journal.search.ArticleSearchTerms" %>
<%@ page import="com.nss.portlet.journal.search.FeedDisplayTerms" %>
<%@ page import="com.nss.portlet.journal.search.FeedSearch" %>
<%@ page import="com.nss.portlet.journal.search.FeedSearchTerms" %>
<%@ page import="com.nss.portlet.journal.search.StructureDisplayTerms" %>
<%@ page import="com.nss.portlet.journal.search.StructureSearch" %>
<%@ page import="com.nss.portlet.journal.search.StructureSearchTerms" %>
<%@ page import="com.nss.portlet.journal.search.TemplateDisplayTerms" %>
<%@ page import="com.nss.portlet.journal.search.TemplateSearch" %>
<%@ page import="com.nss.portlet.journal.search.TemplateSearchTerms" %>
<%@ page import="com.nss.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.nss.portlet.journal.service.JournalFeedLocalServiceUtil" %>
<%@ page import="com.nss.portlet.journal.service.JournalStructureLocalServiceUtil" %>
<%@ page import="com.nss.portlet.journal.service.JournalTemplateLocalServiceUtil" %>
<%@ page import="com.nss.portlet.journal.service.permission.JournalArticlePermission" %>
<%@ page import="com.nss.portlet.journal.service.permission.JournalFeedPermission" %>
<%@ page import="com.nss.portlet.journal.service.permission.JournalPermission" %>
<%@ page import="com.nss.portlet.journal.service.permission.JournalStructurePermission" %>
<%@ page import="com.nss.portlet.journal.service.permission.JournalTemplatePermission" %>
<%@ page import="com.nss.portlet.journal.util.JournalUtil" %>
<%@ page import="com.nss.portlet.journal.webdav.JournalWebDAVStorageImpl" %>

<%@ page import="com.liferay.util.RSSUtil" %>

<%
PortalPreferences portalPrefs = PortletPreferencesFactoryUtil.getPortalPreferences(request);

DateFormat dateFormatDate = DateFormats.getDate(locale, timeZone);
DateFormat dateFormatDateTime = DateFormats.getDateTime(locale, timeZone);
%>