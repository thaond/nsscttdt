
<%@page import="com.nss.portlet.journalworkflow.service.JournalProcessDefinitionLocalServiceUtil"%>
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

<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@ page import="com.liferay.portal.kernel.search.Hits" %>
<%@ page import="com.liferay.portal.kernel.xml.Document" %>
<%@ page import="com.liferay.portal.kernel.xml.Element" %>
<%@ page import="com.liferay.portal.kernel.xml.SAXReaderUtil" %>
<%@ page import="com.liferay.portlet.PortalPreferences" %>
<%@ page import="com.liferay.portlet.assetpublisher.util.AssetPublisherUtil" %>
<%@ page import="com.liferay.portlet.blogs.model.BlogsEntry" %>
<%@ page import="com.liferay.portlet.blogs.service.BlogsEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.blogs.service.BlogsEntryServiceUtil" %>
<%@ page import="com.liferay.portlet.blogs.service.permission.BlogsEntryPermission" %>
<%@ page import="com.liferay.portlet.blogs.service.permission.BlogsPermission" %>
<%@ page import="com.liferay.portlet.bookmarks.model.BookmarksEntry" %>
<%@ page import="com.liferay.portlet.bookmarks.model.BookmarksFolder" %>
<%@ page import="com.liferay.portlet.bookmarks.model.impl.BookmarksFolderImpl" %>
<%@ page import="com.liferay.portlet.bookmarks.service.BookmarksEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.bookmarks.service.BookmarksFolderLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.bookmarks.service.permission.BookmarksEntryPermission" %>
<%@ page import="com.liferay.portlet.bookmarks.service.permission.BookmarksFolderPermission" %>
<%@ page import="com.liferay.portlet.bookmarks.service.permission.BookmarksPermission" %>
<%@ page import="com.liferay.portlet.bookmarks.util.BookmarksUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFileEntry" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFolder" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.DLFolderConstants" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.impl.DLFileEntryImpl" %>
<%@ page import="com.liferay.portlet.documentlibrary.model.impl.DLFolderImpl" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.permission.DLFileEntryPermission" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.permission.DLPermission" %>
<%@ page import="com.liferay.portlet.documentlibrary.util.DLUtil" %>
<%@ page import="com.liferay.portlet.imagegallery.model.IGFolder" %>
<%@ page import="com.liferay.portlet.imagegallery.model.IGImage" %>
<%@ page import="com.liferay.portlet.imagegallery.model.impl.IGFolderImpl" %>
<%@ page import="com.liferay.portlet.imagegallery.service.IGFolderLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.imagegallery.service.IGImageLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.imagegallery.service.permission.IGImagePermission" %>
<%@ page import="com.liferay.portlet.imagegallery.service.permission.IGPermission" %>
<%@ page import="com.liferay.portlet.journalcontent.util.JournalContentUtil" %>
<%@ page import="com.liferay.portlet.journal.NoSuchArticleException" %>
<%@ page import="com.liferay.portlet.journal.action.EditArticleAction" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticleDisplay" %>
<%@ page import="com.liferay.portlet.journal.model.JournalArticleResource" %>
<%@ page import="com.liferay.portlet.journal.model.impl.JournalArticleImpl" %>
<%@ page import="com.liferay.portlet.journal.search.ArticleDisplayTerms" %>
<%@ page import="com.liferay.portlet.journal.search.ArticleSearch" %>
<%@ page import="com.liferay.portlet.journal.search.ArticleSearchTerms" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleServiceUtil" %>
<%@ page import="com.liferay.portlet.journal.service.JournalArticleResourceLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.journal.service.permission.JournalArticlePermission" %>
<%@ page import="com.liferay.portlet.journal.service.permission.JournalPermission" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBMessage" %>
<%@ page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.messageboards.service.permission.MBMessagePermission" %>
<%@ page import="com.liferay.portlet.tags.NoSuchAssetException" %>
<%@ page import="com.liferay.portlet.tags.NoSuchEntryException" %>
<%@ page import="com.liferay.portlet.tags.NoSuchPropertyException" %>
<%@ page import="com.liferay.portlet.tags.model.TagsAsset" %>
<%@ page import="com.liferay.portlet.tags.model.TagsAssetType" %>
<%@ page import="com.liferay.portlet.tags.model.TagsEntry" %>
<%@ page import="com.liferay.portlet.tags.model.TagsEntryConstants" %>
<%@ page import="com.liferay.portlet.tags.model.TagsProperty" %>
<%@ page import="com.liferay.portlet.tags.model.TagsVocabulary" %>
<%@ page import="com.liferay.portlet.tags.service.TagsAssetLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.tags.service.TagsAssetServiceUtil" %>
<%@ page import="com.liferay.portlet.tags.service.TagsEntryLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.tags.service.TagsPropertyLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.tags.service.TagsVocabularyLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.tags.util.TagsUtil" %>
<%@ page import="com.liferay.portlet.wiki.model.WikiNode" %>
<%@ page import="com.liferay.portlet.wiki.model.WikiPage" %>
<%@ page import="com.liferay.portlet.wiki.model.WikiPageDisplay" %>
<%@ page import="com.liferay.portlet.wiki.model.WikiPageResource" %>
<%@ page import="com.liferay.portlet.wiki.model.impl.WikiPageImpl" %>
<%@ page import="com.liferay.portlet.wiki.service.WikiNodeLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.wiki.service.WikiPageLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.wiki.service.WikiPageResourceLocalServiceUtil" %>
<%@ page import="com.liferay.portlet.wiki.service.permission.WikiPagePermission" %>
<%@ page import="com.liferay.portlet.wiki.util.WikiCacheUtil" %>
<%@ page import="com.liferay.portlet.wiki.util.WikiUtil" %>
<%@ page import="com.liferay.util.xml.DocUtil" %>

<%@ page import="java.io.StringReader" %>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<theme:defineObjects/>

<%
DateFormat df = new SimpleDateFormat("hh'h' mm - dd/MM/yyyy");
DateFormat df1 = new SimpleDateFormat("(dd/MM/yyyy)");

PortletPreferences preferences = renderRequest.getPreferences();

String portletResource = ParamUtil.getString(request, "portletResource");

if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}

String selectionStyle = preferences.getValue("selection-style", null);

if (Validator.isNull(selectionStyle)) {
	selectionStyle = "dynamic";
}

long classNameId = GetterUtil.getLong(preferences.getValue("class-name-id", StringPool.BLANK));
long[] classNameIds = null;

if (classNameId > 0) {
	classNameIds = new long[] {classNameId};
}
else {
	classNameIds = new long[0];
}

String category = GetterUtil.getString(preferences.getValue("category", StringPool.BLANK));

String tag = ParamUtil.getString(request, "tag");

String[] entries = null;


// by triltm
String[] tagsCategories = preferences.getValues("tags-categories", new String[0]);
String[] notTagsCategories = preferences.getValues("not-tags-categories", new String[0]);
if (Validator.isNull(tag)) {
	entries = preferences.getValues("entries", new String[0]);
}
else {
	entries = new String[] {tag};
}

String[] notEntries = preferences.getValues("not-entries", new String[0]);
boolean mergeUrlTags = GetterUtil.getBoolean(preferences.getValue("merge-url-tags", null), true);
boolean andOperator = GetterUtil.getBoolean(preferences.getValue("and-operator", null), false);

String displayStyle = GetterUtil.getString(preferences.getValue("display-style", "abstracts"));

if (Validator.isNull(displayStyle)) {
	displayStyle = "abstracts";
}

boolean showAssetTitle = GetterUtil.getBoolean(preferences.getValue("show-asset-title", null), true);
boolean showContextLink = GetterUtil.getBoolean(preferences.getValue("show-context-link", null), true);
int abstractLength = GetterUtil.getInteger(preferences.getValue("abstract-length", StringPool.BLANK), 200);
String assetLinkBehaviour = GetterUtil.getString(preferences.getValue("asset-link-behaviour", "showFullContent"));
String orderByColumn1 = GetterUtil.getString(preferences.getValue("order-by-column-1", "modifiedDate"));
String orderByColumn2 = GetterUtil.getString(preferences.getValue("order-by-column-2", "title"));
String orderByType1 = GetterUtil.getString(preferences.getValue("order-by-type-1", "DESC"));
String orderByType2 = GetterUtil.getString(preferences.getValue("order-by-type-2", "ASC"));
boolean excludeZeroViewCount = GetterUtil.getBoolean(preferences.getValue("exclude-zero-view-count", "0"));
int delta = GetterUtil.getInteger(preferences.getValue("delta", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
String paginationType = GetterUtil.getString(preferences.getValue("pagination-type", "none"));
boolean showQueryLogic = GetterUtil.getBoolean(preferences.getValue("show-query-logic", StringPool.BLANK));
boolean showAvailableLocales = GetterUtil.getBoolean(preferences.getValue("show-available-locales", StringPool.BLANK));
boolean enableRatings = GetterUtil.getBoolean(preferences.getValue("enable-ratings", null));
boolean enableComments = GetterUtil.getBoolean(preferences.getValue("enable-comments", null));
boolean enableCommentRatings = GetterUtil.getBoolean(preferences.getValue("enable-comment-ratings", null));
boolean enableTagBasedNavigation = GetterUtil.getBoolean(preferences.getValue("enable-tag-based-navigation", null));
//TuNV update 20101126
String c_view_sign_type = GetterUtil.getString(preferences.getValue("c_view_sign_type", "all"));
boolean b1,b2,b3,b4;
b1 = (c_view_sign_type.equalsIgnoreCase("all") ? true : false);
b2 = (c_view_sign_type.equalsIgnoreCase("sign") ? true : false);
b3 = (c_view_sign_type.equalsIgnoreCase("changesign") ? true : false);
b4 = (c_view_sign_type.equalsIgnoreCase("notsign") ? true : false);
//end TuNV update

//by triltm

// minh 20100713
String[] tagsCategoriesHelp = tagsCategories;
long  selectPlId = GetterUtil.getLong(preferences.getValue("selectPlId", StringPool.BLANK));
String  portletAssetPublisher = GetterUtil.getString(preferences.getValue("portletAssetPublisher", StringPool.BLANK));
long tagsEntryId = ParamUtil.getLong(request, "tagsEntry", 0);
TagsEntry tagsEntryO = null; 
if (0 != tagsEntryId) {
	tagsEntryO = TagsEntryLocalServiceUtil.getEntry(tagsEntryId);
	tagsCategories = new String[]{tagsEntryO.getName()};
	long  tagsEntryIdSelectPlId = GetterUtil.getLong(preferences.getValue(String.valueOf(tagsEntryId), StringPool.BLANK));
	selectPlId = tagsEntryIdSelectPlId;
}
// end minh 20100713

//MoNT start 17/11/2010
long categoryParentIdAbstractEntry = 0;
List<TagsEntry> tagsAbstractEntrys = new ArrayList<TagsEntry>();
List<TagsVocabulary> vocabulariesTest = TagsVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId, TagsEntryConstants.FOLKSONOMY_CATEGORY);
	for (TagsVocabulary vocabulary : vocabulariesTest) {
		if (vocabulary.getName().equals(category)) {
			categoryParentIdAbstractEntry = vocabulary.getVocabularyId();	
		}
	}
try {
	tagsAbstractEntrys= JournalProcessDefinitionLocalServiceUtil.getListTagsEntry(categoryParentIdAbstractEntry);

} catch (Exception e) {
	
}

//MoNT start 12/2/2010
Map<Long,String> mapValueAbstract = new HashMap<Long,String>();
Map<Long,String> mapValueChildren = new HashMap<Long,String>();
	for(TagsVocabulary vocabulary : vocabulariesTest){
		long vocabularyId = vocabulary.getVocabularyId();
		String valueAbstractVocabulary = GetterUtil.getString(preferences.getValue("valueAbstract"+vocabularyId,"2"));
		if(valueAbstractVocabulary.equals("")||valueAbstractVocabulary==null){
			valueAbstractVocabulary="2";
		}
		mapValueAbstract.put(vocabularyId,valueAbstractVocabulary);
		String valueChildrenVocabulary = GetterUtil.getString(preferences.getValue("valueChildren"+vocabularyId,"5"));
		if(valueChildrenVocabulary.equals("")||valueChildrenVocabulary==null){
			valueChildrenVocabulary="5";
		}
		mapValueChildren.put(vocabularyId,valueChildrenVocabulary);
	}
//MoNT end 12/2/2010

Map<String,String> mapValueAbstractEntry= new HashMap<String,String>();
Map<String,String> mapValueChildrenEntry= new HashMap<String,String>(); 

for(TagsVocabulary vocabulary : vocabulariesTest){
	long vocabularyChildrenId = vocabulary.getVocabularyId();
		List<TagsEntry> tagChildrenEntrys = new ArrayList<TagsEntry>();
	try {
		tagChildrenEntrys = JournalProcessDefinitionLocalServiceUtil.getListTagsEntry(vocabularyChildrenId);
	}
	catch (Exception e) {
	}
	if(tagChildrenEntrys.size()>0){
		for(int i=0;i<tagChildrenEntrys.size();i++){
			long tagEntryId=tagChildrenEntrys.get(i).getEntryId();
			String valueAbstractEntry = GetterUtil.getString(preferences.getValue("valueAbstractEntry"+tagEntryId,"2"));
			if(valueAbstractEntry.equals("")||valueAbstractEntry==null){
				valueAbstractEntry="2";
		    }
		    mapValueAbstractEntry.put(""+tagEntryId,valueAbstractEntry);
		    String valueChildrenEntry = GetterUtil.getString(preferences.getValue("valueChildrenEntry"+tagEntryId,"5"));
		    if(valueChildrenEntry.equals("")||valueChildrenEntry==null){
		    	valueChildrenEntry="5";
		    }
			mapValueChildrenEntry.put(""+tagEntryId,valueChildrenEntry); 
		} 
	}
}
//MoNT end 17/11/2010


int abstractDelta = GetterUtil.getInteger(preferences.getValue("abstractDelta", StringPool.BLANK), 1);

String defaultMetadataFields = StringPool.BLANK;
String allMetadataFields = "create-date,modified-date,publish-date,expiration-date,priority,author,view-count,tags";

String[] metadataFields = StringUtil.split(preferences.getValue("metadata-fields", defaultMetadataFields));

Arrays.sort(entries);

String[] manualEntries = preferences.getValues("manual-entries", new String[0]);

boolean viewInContext = assetLinkBehaviour.equals("viewInPortlet");

boolean showPortletWithNoResults = false;
boolean groupByClass = false;
boolean allowEmptyResults = false;

DateFormat dateFormatDate = DateFormats.getDate(locale, timeZone);

request.setAttribute("view.jsp-abstractDelta", abstractDelta);
%>

<%@ include file="/html/portlet/nss/asset_publisher_nss/init-ext.jsp" %>

<%!
private String _checkViewURL(String viewURL, String currentURL, ThemeDisplay themeDisplay) {
	if (viewURL.startsWith(themeDisplay.getURLPortal())) {
		viewURL = HttpUtil.setParameter(viewURL, "redirect", currentURL);
	}

	return viewURL;
}
%>